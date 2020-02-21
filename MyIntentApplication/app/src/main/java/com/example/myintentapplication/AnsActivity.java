package com.example.myintentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AnsActivity extends AppCompatActivity {

    private TextView questionfield;
    private EditText answerfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans);
        questionfield = findViewById(R.id.questionfield);
        answerfield = findViewById(R.id.answerfield);

        String question = getIntent().getStringExtra("question");

        questionfield.setText(question);

    }

    public void sendAnswer(View v){
        Intent intent =  new Intent(this, MainActivity.class);
        String ans = answerfield.getText().toString();
        intent.putExtra("answer", ans);
        setResult(1, intent);
        finish();
    }
}
