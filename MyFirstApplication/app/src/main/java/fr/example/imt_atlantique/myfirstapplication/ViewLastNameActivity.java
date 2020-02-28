package fr.example.imt_atlantique.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewLastNameActivity extends AppCompatActivity {

    private TextView lastNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_last_name);

        lastNameTextView = findViewById(R.id.lastNameTextView);

        Intent intent = getIntent();
        String lastName = intent.getStringExtra("lastName");

        lastNameTextView.setText(lastName);

    }

}
