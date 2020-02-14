package fr.example.imt_atlantique.imt_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int nbClicks;
    private TextView textArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nbClicks = 0;
        textArea = findViewById(R.id.editTextArea);

    }

    public void incrementNumber (View v) {

        nbClicks++;
        textArea.setText(String.valueOf(nbClicks));

    }


}
