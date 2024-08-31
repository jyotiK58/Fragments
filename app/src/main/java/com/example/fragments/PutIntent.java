package com.example.fragments;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class PutIntent extends AppCompatActivity {

    private EditText editTextId, editTextName, editTextPhone;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.put_intent);

        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditText fields
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();

                // Create an Intent to start DisplayActivity
                Intent intent = new Intent(PutIntent.this, GetIntent.class);

                // Pass data to DisplayActivity
                intent.putExtra("ID", id);
                intent.putExtra("NAME", name);
                intent.putExtra("PHONE", phone);

                // Start DisplayActivity
                startActivity(intent);
            }
        });
    }
}
