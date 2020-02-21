package fr.example.imt_atlantique.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

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

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText mailField;
    private EditText cityField;
    private TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Log.i("Lifecycle", "onCreate method");

        firstNameField = findViewById(R.id.editTextfirstName);
        lastNameField = findViewById(R.id.editTextLastName);
        mailField = findViewById(R.id.editTextMail);
        cityField = findViewById(R.id.editTextCity);
        table = findViewById(R.id.table_layout);

        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        String savedPrenom = prefs.getString("firstName", "");
        firstNameField.setText(savedPrenom);

        Log.i("PRENOM QUON CHOPPE", "."+savedPrenom);


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

        String prenom = firstNameField.getText().toString();
        editor.putString("firstName", prenom);
        editor.apply();

        Log.i("PRENOM EN TRAIN DETRE SAUVEGARDE", ""+prenom);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy method");
    }

    public void validateAction (View v) {

        String textToShow = firstNameField.getText().toString();

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

        firstNameField.setText(null);
        lastNameField.setText(null);
        mailField.setText(null);
        cityField.setText(null);

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

        String prenom = firstNameField.getText().toString();
        outState.putString("prenom", prenom);

        String nom = lastNameField.getText().toString();
        outState.putString("nom", nom);

        String mail = mailField.getText().toString();
        outState.putString("mailField", mail);

        String ville = cityField.getText().toString();
        outState.putString("ville", ville);

        // TODO : departement
        // TODO : numéro de téléphone

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        String restoredPrenom = savedInstanceState.getString("prenom");
        firstNameField.setText(restoredPrenom);

        String restoredNom = savedInstanceState.getString("nom");
        lastNameField.setText(restoredNom);

        String restoredMail = savedInstanceState.getString("mailField");
        mailField.setText(restoredMail);

        String restoredVille = savedInstanceState.getString("ville");
        cityField.setText(restoredVille);


    }

}
