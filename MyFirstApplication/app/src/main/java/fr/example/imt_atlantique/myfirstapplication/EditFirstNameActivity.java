package fr.example.imt_atlantique.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditFirstNameActivity extends AppCompatActivity {

    private EditText firstNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("DoubleLose", "lancement onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_first_name);

        firstNameField = findViewById(R.id.firstNameEditText);
    }

    public void confirmName(View v) {

        Log.i("DoubleLose", "lancement confirm");

        String firstName = firstNameField.getText().toString();

        Log.i("DoubleLose", "lancement confirm111");

        Intent intent =  new Intent();

        Log.i("DoubleLose", "lancement confirm2222");

        intent.putExtra("firstName", firstName);

        Log.i("DoubleLose", "lancement confirm3333");

        setResult(RESULT_OK, intent);

        Log.i("DoubleLose", "lancement confirm4444");

        super.finish();

        Log.i("DoubleLose", "lancement confirm55555555");

    }

    public void cancelName(View v) {

        Intent intent =  new Intent();

        // Don't send anything

        setResult(RESULT_CANCELED, intent);
        super.finish();

    }
}
