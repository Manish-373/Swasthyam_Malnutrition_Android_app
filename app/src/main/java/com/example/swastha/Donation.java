package com.example.swastha;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class Donation extends AppCompatActivity implements PaymentResultListener {

    private EditText etAmount;
    private Button btnDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        Checkout.preload(getApplicationContext());

        etAmount = findViewById(R.id.etAmount);
        btnDonate = findViewById(R.id.btnDonate);

        btnDonate.setOnClickListener(v -> {
            String amountStr = etAmount.getText().toString().trim();

            if (amountStr.isEmpty()) {
                Toast.makeText(this, "Enter a valid amount", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int amount = Integer.parseInt(amountStr);
                if (amount <= 0) {
                    Toast.makeText(this, "Enter an amount greater than 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                startPayment(amount * 100);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startPayment(int amount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID("RAZERPAY_KEY_ID"); // Replace with your Razorpay Key ID

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Donation");
            options.put("description", "Donation for a Noble Cause");
            options.put("currency", "INR");
            options.put("amount", amount);

            // ✅ Add Razorpay QR Code ID (Replace with your actual Razorpay QR Code ID)
            options.put("method", "upi");

            checkout.open(this, options);
        } catch (Exception e) {
            Toast.makeText(this, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        Toast.makeText(this, "Payment Successful! Payment ID: " + razorpayPaymentID, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPaymentError(int code, String response) {
        Toast.makeText(this, "Payment Failed! " + response, Toast.LENGTH_LONG).show();
    }
}
