package fr.example.imt_atlantique.myfirstapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView cityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        cityTextView = findViewById(R.id.cityTextView);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("userParcelable");

        firstNameTextView.setText(user.getFirstName());
        lastNameTextView.setText(user.getLastName());
        cityTextView.setText(user.getCity());

    }

}