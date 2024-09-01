package com.example.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class DatePicker extends AppCompatActivity {

    private TextView textViewDate;
    private Button buttonPickDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);

        textViewDate = findViewById(R.id.textViewDate);
        buttonPickDate = findViewById(R.id.buttonPickDate);

        buttonPickDate.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and show DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            // Display the selected date
            String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            textViewDate.setText(date);
        }, year, month, day);

        datePickerDialog.show();
    }
}

