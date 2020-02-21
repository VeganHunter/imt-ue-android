package com.example.myintentapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText questionfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionfield = findViewById(R.id.questionText);
        if(getIntent().getStringExtra("answer")!=null){
            String ans = getIntent().getStringExtra("answer");
        }
    }

    public void sendQuestion(View v){
        Intent intent =  new Intent(this, AnsActivity.class);
        String question = questionfield.getText().toString();
        intent.putExtra("question", question);
        startActivityForResult(intent, 4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 4 && resultCode == 1){
            View v = (View) questionfield.getParent();
            final Snackbar sb = Snackbar.make(v, data.getStringExtra("answer"), Snackbar.LENGTH_LONG);

            sb.show();
            sb.setAction(R.string.dismiss, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Respond to the click, such as by undoing the modification that caused
                    // this message to be displayed
                }
            });
        }
    }
}
