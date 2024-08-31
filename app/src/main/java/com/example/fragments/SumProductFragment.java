package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SumProductFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sumproduct_fragment);

        if (savedInstanceState == null) {
            // Show SumFragment initially
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SumFragment())
                    .commit();
        }

        Button switchToSum = findViewById(R.id.switch_to_sum);
        Button switchToProduct = findViewById(R.id.switch_to_product);

        switchToSum.setOnClickListener(v -> replaceFragment(new SumFragment()));
        switchToProduct.setOnClickListener(v -> replaceFragment(new ProductFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
