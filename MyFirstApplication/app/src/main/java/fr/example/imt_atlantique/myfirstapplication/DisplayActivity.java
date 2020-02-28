package fr.example.imt_atlantique.myfirstapplication;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static android.text.InputType.TYPE_CLASS_PHONE;

public class DisplayActivity extends AppCompatActivity {

    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView cityTextView;
    private TextView birthdateTextView;
    private TableLayout phoneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        cityTextView = findViewById(R.id.cityTextView);
        birthdateTextView = findViewById(R.id.birthdateTextView);
        phoneLayout = findViewById(R.id.phoneLayout);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("userParcelable");

        firstNameTextView.setText(user.getFirstName());
        lastNameTextView.setText(user.getLastName());
        cityTextView.setText(user.getCity());
        birthdateTextView.setText(user.getBirthdate());

        List<String> phoneNumbers = user.getPhoneNumbers();
        Log.i("victor", "06-"+phoneNumbers.get(0));
        for(int i=0; i<phoneNumbers.size() ;i++){
            TextView textView = new TextView(this);
            textView.setText(phoneNumbers.get(i));
            TableRow newRow = new TableRow(this);
            newRow.addView(textView);
            phoneLayout.addView(newRow);
        }

    }

}