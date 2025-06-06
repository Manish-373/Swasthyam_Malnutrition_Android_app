package com.example.swastha;
import com.example.swastha.ml.MalnuLiteModel;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Malnutrition extends AppCompatActivity {

    Button camera, gallery;
    ImageView imageView;
    TextView result,basicCure, medicalCure;
    int imageSize = 224;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malnutrition);

        camera = findViewById(R.id.button);
        gallery = findViewById(R.id.button2);

        result = findViewById(R.id.result);
        basicCure = findViewById(R.id.basicCure);
        medicalCure = findViewById(R.id.medicalCure);
        imageView = findViewById(R.id.imageView);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, 3);
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                }
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, 1);
            }
        });
    }

    public void classifyImage(Bitmap image){
        try {
            MalnuLiteModel model = MalnuLiteModel.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
            for(int i = 0; i < imageSize; i ++){
                for(int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            MalnuLiteModel.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            // find the index of the class with the biggest confidence.
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            String[] classes = {
                    "Marasmus",
                    "Kwashiorkor",
                    "Rickets",
                    "Iron Deficiency (Anemia)",
                    "Vitamin A Deficiency",
                    "Zinc Deficiency",
                    "Iodine Deficiency (Goiter)",
                    "Cheilosis",
                    "Clubbing",
                    "Scurvy",
                    "Healthy"
            };
            result.setText(classes[maxPos]);

            // Define basic and medical cure suggestions
            String[] basicCures = {
                    "Increase calorie intake, balanced diet",
                    "Protein-rich foods (eggs, fish, dairy)",
                    "Vitamin D and calcium-rich foods",
                    "Iron-rich diet (leafy greens, meat)",
                    "Vitamin A supplements, carrots, fish",
                    "Zinc-rich diet (nuts, meat, dairy)",
                    "Iodine-rich foods (seaweed, dairy, eggs)",
                    "Vitamin B2-rich foods (milk, eggs, meat)",
                    "Improve circulation, monitor nails",
                    "Vitamin C intake (fruits, vegetables)",
                    "No action needed, maintain healthy diet"
            };

            String[] medicalCures = {
                    "Consult nutritionist for calorie plan",
                    "Medical-grade protein supplements",
                    "Vitamin D and calcium supplements",
                    "Iron supplements under doctor supervision",
                    "Medical-grade Vitamin A treatment",
                    "Zinc supplements if necessary",
                    "Iodine supplements or medication",
                    "Riboflavin supplements as per doctor",
                    "Check for underlying respiratory issues",
                    "Medical-grade Vitamin C treatment",
                    "No medical treatment needed"
            };

            // Set text in newly added TextViews
            basicCure.setText("Basic Cure: " + basicCures[maxPos]);
            medicalCure.setText("Medical Cure: " + medicalCures[maxPos]);

            // Releases model resources if no longer used.
            model.close();
        } catch (IOException e) {
            e.printStackTrace();      //maybe to remove
            // TODO Handle the exception
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 3){
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }else{
                Uri dat = data.getData();
                Bitmap image = null;
                try {
                    image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}