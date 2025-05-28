package com.example.swastha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        reference = FirebaseDatabase.getInstance().getReference("users");

        // Disable the signup button initially
        signupButton.setEnabled(false);

        // Add text change listeners to validate fields dynamically
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkFieldsForEmptyValues();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        signupName.addTextChangedListener(textWatcher);
        signupEmail.addTextChangedListener(textWatcher);
        signupUsername.addTextChangedListener(textWatcher);
        signupPassword.addTextChangedListener(textWatcher);

        signupButton.setOnClickListener(view -> {
            if (validateInputs()) {
                signupButton.setEnabled(false); // Prevent multiple clicks
                checkIfUserExists();
            }
        });

        loginRedirectText.setOnClickListener(view -> startActivity(new Intent(SignupActivity.this, LoginActivity.class)));
    }

    private void checkFieldsForEmptyValues() {
        String name = signupName.getText().toString().trim();
        String email = signupEmail.getText().toString().trim();
        String username = signupUsername.getText().toString().trim();
        String password = signupPassword.getText().toString().trim();

        // Enable button only if all fields are filled
        signupButton.setEnabled(!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty());
    }

    private boolean validateInputs() {
        String email = signupEmail.getText().toString().trim();
        String password = signupPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signupEmail.setError("Enter a valid email");
            return false;
        }
        if (password.length() < 6) {
            signupPassword.setError("Password must be at least 6 characters");
            return false;
        }
        return true;
    }

    private void checkIfUserExists() {
        String username = signupUsername.getText().toString().trim();

        reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    signupUsername.setError("Username already taken");
                    signupUsername.requestFocus();
                    signupButton.setEnabled(true);
                } else {
                    registerUser();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SignupActivity.this, "Database error. Please try again.", Toast.LENGTH_SHORT).show();
                signupButton.setEnabled(true);
            }
        });
    }

    private void registerUser() {
        String name = signupName.getText().toString().trim();
        String email = signupEmail.getText().toString().trim();
        String username = signupUsername.getText().toString().trim();
        String password = signupPassword.getText().toString().trim();

        HelperClass helperClass = new HelperClass(name, email, username, password);
        reference.child(username).setValue(helperClass).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(SignupActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(SignupActivity.this, "Signup failed. Try again.", Toast.LENGTH_SHORT).show();
            }
            signupButton.setEnabled(true);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
        finish();
    }
}
