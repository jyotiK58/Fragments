package com.example.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertSimpleInterest extends AppCompatActivity {
    Button buttonShowDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_si);

         buttonShowDialog = findViewById(R.id.buttonShowDialog);
        buttonShowDialog.setOnClickListener(v -> showInterestDialog());
    }

    private void showInterestDialog() {
        LayoutInflater inflater = getLayoutInflater();
        // Inflate the custom layout
     View dialogView = inflater.inflate(R.layout.alert_simple_interest, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Calculate Simple Interest");
        builder.setView(dialogView);

        EditText editTextPrincipal = dialogView.findViewById(R.id.editTextPrincipal);
        EditText editTextRate = dialogView.findViewById(R.id.editTextRate);
        EditText editTextTime = dialogView.findViewById(R.id.editTextTime);

        builder.setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    double principal = Double.parseDouble(editTextPrincipal.getText().toString());
                    double rate = Double.parseDouble(editTextRate.getText().toString());
                    double time = Double.parseDouble(editTextTime.getText().toString());

                    // Calculate simple interest
                    double interest = (principal * rate * time) / 100;

                    // Show result
                    AlertDialog resultDialog = new AlertDialog.Builder(AlertSimpleInterest.this)
                            .setTitle("Simple Interest Result")
                            .setMessage("The simple interest is: " + interest)
                            .setPositiveButton("OK", null)
                            .create();
                    resultDialog.show();
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    new AlertDialog.Builder(AlertSimpleInterest.this)
                            .setTitle("Error")
                            .setMessage("Please enter valid numbers.")
                            .setPositiveButton("OK", null)
                            .show();
                }
            }
        });

        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
