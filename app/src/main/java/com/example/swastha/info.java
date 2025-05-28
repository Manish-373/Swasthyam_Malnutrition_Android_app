package com.example.swastha;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class info extends AppCompatActivity {

    LinearLayout l1, l3, l4, l6;
    TextView user;
    static String USER_NAME = "file";
    static String KEY_NAME = "name";
    static final String PREFS_NAME = "user_prefs";
    SharedPreferences sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_info);

        l3 = findViewById(R.id.about);
        l4 = findViewById(R.id.contact);
        l1 = findViewById(R.id.rateus);
        l6 = findViewById(R.id.out);
        user = findViewById(R.id.user);

        // Retrieve username from SharedPreferences and display it
        SharedPreferences sd = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String name = sd.getString("name", null);
        if (name != null && !name.isEmpty()) {
            user.setText("Hello! \n" + name );
        } else {
            user.setText("Hello! User!"); // Fallback text
        }

        l3.setOnClickListener(v -> startActivity(new Intent(info.this, about.class)));

        l1.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(info.this);
            bottomSheetDialog.setContentView(R.layout.rate);
            ImageView imageView = bottomSheetDialog.findViewById(R.id.close);
            RatingBar ratingBar = bottomSheetDialog.findViewById(R.id.rateBar);
            Button submitButton = bottomSheetDialog.findViewById(R.id.submit);

            imageView.setOnClickListener(view -> bottomSheetDialog.dismiss());

            submitButton.setOnClickListener(v1 -> {
                if (ratingBar.getRating() > 0) {
                    Toast.makeText(info.this, "Thank You For Rating Us!!", Toast.LENGTH_SHORT).show();
                    bottomSheetDialog.dismiss();
                } else {
                    Toast.makeText(info.this, "Please Select Number Of Stars", Toast.LENGTH_SHORT).show();
                }
            });

            bottomSheetDialog.show();
        });

        l4.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "yashkalekar82@gmail.com", null));
            startActivity(emailIntent);
        });

        l6.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(info.this);
            builder.setTitle("Sign Out");
            builder.setMessage("Are you sure you want to sign out?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // 🔹 Clear SharedPreferences on Logout
                        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();

                        // 🔹 Navigate back to Login screen
                        Intent intent = new Intent(info.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss());

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(info.this, MainActivity.class));
        finish();
    }
}
