package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProductFragment extends Fragment {

    public ProductFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fraagment_product, container, false);

        EditText number1 = view.findViewById(R.id.number1);
        EditText number2 = view.findViewById(R.id.number2);
        Button calculateProduct = view.findViewById(R.id.calculate_product);
        TextView resultProduct = view.findViewById(R.id.result_product);

        calculateProduct.setOnClickListener(v -> {
            String num1Str = number1.getText().toString();
            String num2Str = number2.getText().toString();
            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double product = num1 * num2;
                resultProduct.setText("Product: " + product);
            }
        });

        return view;
    }
}
