package fr.example.imt_atlantique.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class SecondaryActivity extends AppCompatActivity  {

    private EditText firstname;
    private EditText lastname;
    private EditText mail;
    private EditText city;
    private TableLayout table;

    //private String firstName_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Log.i("Lifecycle", "onCreate method");

        firstname = findViewById(R.id.editTextfirstName);
        lastname = findViewById(R.id.editTextLastName);
        mail = findViewById(R.id.editTextMail);
        city = findViewById(R.id.editTextCity);
        table = findViewById(R.id.table_layout);

        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);

        //firstName_str = prefs.getString("firstName", "");
       // Log.i("hello", "voici la string : "+firstName_str);
        //firstname.setText(firstName_str);
        //firstname.setText(prefs.getString("firstName", ""));

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
        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        //editor.putString("firstName", firstName_str);
        editor.putString("firstName", firstname.getText().toString());
        editor.apply();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy method");
    }

    public void validateAction (View v) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean resetAction(MenuItem item) {

        firstname.setText(null);
        lastname.setText(null);
        mail.setText(null);
        city.setText(null);

        return true;

    }

    public void addPhoneNumber (View v) {

        EditText lEditText = new EditText(this);
        lEditText.setHint("Phone Number");

        Button removeButton = new Button(this);
        removeButton.setText("X");

        removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ViewGroup)v.getParent().getParent()).removeView((ViewGroup)v.getParent());
            }
        });

        TableRow newRow = new TableRow(this);
        newRow.addView(lEditText);
        newRow.addView(removeButton);
        table.addView(newRow);

    }

    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        //firstName_str = firstname.getText().toString();
        //Log.i("message", ""+firstName_str);
        outState.putString("firstName", firstname.getText().toString());
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        //firstName_str = savedInstanceState.getString("firstName");
        //firstname.setText(firstName_str);

        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        firstname.setText(prefs.getString("firstName", ""));

    }

}
