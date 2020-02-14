package fr.example.imt_atlantique.imt_clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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

        textArea = findViewById(R.id.editTextArea);

        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        nbClicks = prefs.getInt("nbClicks", 0);
        textArea.setText(String.valueOf(nbClicks));

        // Log.i("Prefs path", Environment.getDataDirectory().toString());
        // should print "/data"
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Lifecycle", "onStop method");
        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("nbClicks", nbClicks);
        editor.apply();
        // editor.commit();
    }

    public void incrementNumber (View v) {

        nbClicks++;
        textArea.setText(String.valueOf(nbClicks));
    }

    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("nbClicks", nbClicks);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

        nbClicks = savedInstanceState.getInt("nbClicks");
        textArea.setText(String.valueOf(nbClicks));
    }


}
