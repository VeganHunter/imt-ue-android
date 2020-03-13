package fr.example.imt_atlantique.myfirstapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_EDIT;
import static android.content.Intent.ACTION_PICK;
import static android.content.Intent.ACTION_VIEW;
import static android.text.InputType.TYPE_CLASS_PHONE;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText birthdateField;
    private EditText cityField;
    private Spinner departmentField;
    private TableLayout table;
    private InputFragment fragment;

    // LIFECYCLE

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Lifecycle", "onCreate method");

        fragment = new InputFragment();
        FragmentManager fragmentMngr = getSupportFragmentManager();
        FragmentTransaction tx = fragmentMngr.beginTransaction();
        View view = findViewById(R.id.constraintLayout2);
        int containerViewId = ((ViewGroup) view.getParent()).getId();
        tx.add(containerViewId, fragment, "mainFragment");
        tx.commit();

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

        String prenom = fragment.getFirstNameField().getText().toString();
        editor.putString("firstName", prenom);

        String nom = fragment.getLastNameField().getText().toString();
        editor.putString("lastName", nom);

        String birthdate = fragment.getBirthdateField().getText().toString();
        editor.putString("birthdate", birthdate);

        String ville = fragment.getCityField().getText().toString();
        editor.putString("ville", ville);

        int numdep = fragment.getDepartmentField().getSelectedItemPosition();
        editor.putInt("numDep", numdep);

        int nbPhones = fragment.getTable().getChildCount();
        editor.putInt("nbPhones", nbPhones);

        for (int i=0; i<nbPhones; i++) {
            TableRow r = (TableRow) fragment.getTable().getChildAt(i);
            EditText t = (EditText) r.getChildAt(0);
            editor.putString("phone"+i, t.getText().toString());
        }

        editor.apply();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Lifecycle", "onDestroy method");
    }

    // MENU ACTIONS

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean resetAction(MenuItem item) {

        firstNameField.setText(null);
        lastNameField.setText(null);
        birthdateField.setText(null);
        cityField.setText(null);
        departmentField.setSelection(0);
        table.removeAllViews();

        return true;
    }


    public boolean wikipedia_search(MenuItem item) {

        boolean success = true;

        String city = cityField.getText().toString();

        if (city.equals("")) {
            success = false;
        }

        else {

            String url = "http://fr.wikipedia.org/?search=" + city;
            Uri uri = Uri.parse(url);

            Intent intent = new Intent(ACTION_VIEW, uri);

            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

        return success;

    }

    public boolean share(MenuItem item) {

        boolean success = true;

        String city = cityField.getText().toString();

        if (city.equals("")) {
            success = false;
        }

        else {

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_TEXT, city);
            intent.setType("text/plain");

            // Verify that the intent will resolve to an activity
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

        return success;

    }

    // BUTTONS


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

        String firstName = firstNameField.getText().toString();
        String lastName = lastNameField.getText().toString();
        String city = cityField.getText().toString();
        String birthdate = birthdateField.getText().toString();

        List<String> phoneNumbers = new ArrayList<String>();

        for(int i =0; i< table.getChildCount(); i++){
            TableRow r = (TableRow) table.getChildAt(i);
            EditText t = (EditText) r.getChildAt(0);

            String phoneNumber = t.getText().toString();
            if (!phoneNumber.equals(""))
                phoneNumbers.add(phoneNumber);
        }

        User user = new User(firstName, lastName, city, birthdate, phoneNumbers);
        Intent intent =  new Intent(this, DisplayActivity.class);
        intent.putExtra("userParcelable", user);
        startActivity(intent);

    }

    public boolean setDate(View v) {

        Intent intent = new Intent();
        intent.setAction(ACTION_PICK);

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 5);
        }

        return true;
    }

    public boolean viewLastName(View v) {

        Intent intent = new Intent();
        intent.setAction(ACTION_VIEW);
        intent.putExtra("lastName", lastNameField.getText().toString());

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);
        }

        return true;
    }

    public boolean editFirstName(View v) {

        Intent intent = new Intent();
        intent.setAction(ACTION_EDIT);

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 7);
        }

        return true;
    }



    public boolean callPhone (View v) {
        Intent intent = new Intent();
        intent.setAction(ACTION_DIAL);

        ArrayList<String> phoneNumbers = new ArrayList<String>();

        for(int i =0; i< table.getChildCount(); i++){
            TableRow r = (TableRow) table.getChildAt(i);
            EditText t = (EditText) r.getChildAt(0);

            String phoneNumber = t.getText().toString();
            if (!phoneNumber.equals(""))
                phoneNumbers.add(phoneNumber);
        }

        intent.putStringArrayListExtra("phoneList", phoneNumbers);

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        return true;
    }

    // MISC

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("DoubleLose", "onActivityResult");

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 5) { // DateActivity

            if (resultCode == RESULT_OK) { // confirm button

                String pickedDate = data.getStringExtra("date");
                birthdateField.setText(pickedDate);
            }

            if (resultCode == RESULT_CANCELED) { // cancel button
                // do nothing
            }
        }

        else if (requestCode == 7) { //EditFirstNameActivity

            Log.i("DoubleLose", "request code ok");


            if (resultCode == RESULT_OK) { // confirm button

                Log.i("DoubleLose", "result code ok");


                String pickedFirstName = data.getStringExtra("firstName");
                firstNameField.setText(pickedFirstName);

            }

            if (resultCode == RESULT_CANCELED) { // cancel button
                // do nothing
            }
        }
    }

    // SAVING

    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        String prenom = firstNameField.getText().toString();
        outState.putString("prenom", prenom);

        String nom = lastNameField.getText().toString();
        outState.putString("nom", nom);

        String birthdate = birthdateField.getText().toString();
        outState.putString("birthdate", birthdate);

        String ville = cityField.getText().toString();
        outState.putString("ville", ville);

        // phones and birthdate are not handled, but they're saved in prefs

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        String restoredPrenom = savedInstanceState.getString("prenom");
        firstNameField.setText(restoredPrenom);

        String restoredNom = savedInstanceState.getString("nom");
        lastNameField.setText(restoredNom);

        String restoredBirthdate = savedInstanceState.getString("birthdate");
        birthdateField.setText(restoredBirthdate);

        String restoredVille = savedInstanceState.getString("ville");
        cityField.setText(restoredVille);


    }

}
