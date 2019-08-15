package com.example.livemvvmfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFirstName;
    private TextView textviewLastName;
    private TextView textViewEmail;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textViewFirstName = findViewById(R.id.textViewFirstName);
        textviewLastName = findViewById(R.id.textViewLastName);
        textViewEmail = findViewById(R.id.textVieweEmail);

        mainViewModel=ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.init();
        mainViewModel.getProfile().observe(this, new Observer<MainModel>() {
            @Override
            public void onChanged(MainModel mainModel) {
                UpdateTextViews(mainModel);
            }
        });


    }

    private void UpdateTextViews(MainModel mainModel) {
        textViewFirstName.setText(mainModel.getFirstName());
        textviewLastName.setText(mainModel.getLastName());
        textViewEmail.setText(mainModel.getEmail());
    }
}
