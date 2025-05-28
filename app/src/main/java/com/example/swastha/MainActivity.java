package com.example.swastha;

import androidx.activity.OnBackPressedCallback; // Import for back press handling
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide ActionBar if available
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Initialize buttons and views
        more = findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, info.class);
                startActivity(i);
            }
        });

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(v -> open_malnutrition());

        imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(v -> open_donation());

        imageButton3 = findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(v -> open_awareness());

        imageButton4 = findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(v -> open_LoginActivity());

        // Handle back button press with OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });
    }

    // Functions to open activities
    public void open_malnutrition() {
        startActivity(new Intent(MainActivity.this, Malnutrition.class));
    }

//    public void open_donation() {
//        startActivity(new Intent(MainActivity.this, Donation.class));
//    }

    public void open_donation() {
        // Check login status from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            // Not logged in — redirect to login and show message
            Toast.makeText(MainActivity.this, "Before Donating Please Login First", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } else {
            // Logged in — proceed to Donation screen
            startActivity(new Intent(MainActivity.this, Donation.class));
        }
    }


    public void open_awareness() {
        startActivity(new Intent(MainActivity.this, Awareness.class));
    }

    public void open_LoginActivity() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    // Function to show exit confirmation dialog
    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT !!")
                .setMessage("Are you sure you want to Exit ??")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> finishAffinity()) // Close the app properly
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
