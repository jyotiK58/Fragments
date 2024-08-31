package com.example.fragments;



import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GetIntent extends AppCompatActivity {

    private TextView textViewId, textViewName, textViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_intent);

        textViewId = findViewById(R.id.textViewId);
        textViewName = findViewById(R.id.textViewName);
        textViewPhone = findViewById(R.id.textViewPhone);

        // Get data passed from DataEntryActivity
        String id = getIntent().getStringExtra("ID");
        String name = getIntent().getStringExtra("NAME");
        String phone = getIntent().getStringExtra("PHONE");

        // Set data to TextViews
        textViewId.setText("ID: " + id);
        textViewName.setText("Name: " + name);
        textViewPhone.setText("Phone: " + phone);
    }
}
