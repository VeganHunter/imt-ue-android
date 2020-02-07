package fr.example.imt_atlantique.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class SecondaryActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Log.i("Lifecycle", "onCreate method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecycle", "onStart method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Lifecycle", "onRestart method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecycle", "onResume method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecycle", "onPause method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Lifecycle", "onStop method");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy method");
    }

    public void validateAction (View v) {

        EditText firstname = findViewById(R.id.editTextfirstName);
        String textToShow = firstname.getText().toString();

        Toast.makeText(getApplicationContext(), textToShow, Toast.LENGTH_LONG).show();

        final Snackbar sb = Snackbar.make(v, textToShow, Snackbar.LENGTH_LONG);

        sb.show();
        sb.setAction(R.string.dismiss, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Respond to the click, such as by undoing the modification that caused
                        // this message to be displayed
                    }
                });

        Log.i("Message", "Button method "+textToShow);

    }

}
