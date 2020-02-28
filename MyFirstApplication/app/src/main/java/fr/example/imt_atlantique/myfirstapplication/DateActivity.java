package fr.example.imt_atlantique.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {

    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        datePicker = findViewById(R.id.datePicker);
    }

    public void confirmDate(View v) {

        Intent intent =  new Intent(this, MainActivity.class);

        String year = String.valueOf(datePicker.getYear());
        String month = String.valueOf(datePicker.getMonth()+1); // months are indexed at 0
        String day = String.valueOf(datePicker.getDayOfMonth());

        String date = day+"/"+month+"/"+year;
        intent.putExtra("date", date);

        setResult(1, intent);
        finish();

    }

    public void cancelDate(View v) {

        Intent intent =  new Intent(this, MainActivity.class);

        // Don't send anything

        setResult(0, intent);
        finish();

    }

}
