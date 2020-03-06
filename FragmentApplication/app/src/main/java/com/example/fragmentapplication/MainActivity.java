package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity Lifecycle", "onCreate method");
        setContentView(R.layout.activity_main);
    }

    public boolean confirmField(View v) {
        EditText wordfield;
        wordfield = findViewById(R.id.editText);
        String textToShow = wordfield.getText().toString();

        DisplayFragment fragment = (DisplayFragment) getFragmentManager().findFragmentById(R.id.display_fragment);
        Log.i("thomas", ""+fragment.getClass());
        fragment.displayFragment(textToShow);

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity Lifecycle", "onStart method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity Lifecycle", "onRestart method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity Lifecycle", "onResume method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity Lifecycle", "onPause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity Lifecycle", "onStop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity Lifecycle", "onDestroy method");
    }

}