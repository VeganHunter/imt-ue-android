package fr.example.imt_atlantique.myfirstapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import static android.Manifest.permission.CALL_PHONE;

public class DialActivity extends AppCompatActivity {

    TableLayout phoneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneLayout = findViewById(R.id.phoneLayout);

        Intent intent = getIntent();

        ArrayList<String> phoneNumbers = intent.getStringArrayListExtra("phoneList");

        for (int i=0; i<phoneNumbers.size() ;i++) {

            final TextView textView = new TextView(this);
            textView.setText(phoneNumbers.get(i));
            TableRow newRow = new TableRow(this);
            newRow.addView(textView);

            ImageButton callbutton = new ImageButton(this);
            callbutton.setImageResource(android.R.drawable.ic_menu_call);
            newRow.addView(callbutton);

            callbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Uri uri = Uri.parse(textView.getText().toString());
                    Intent callIntent = new Intent(Intent.ACTION_CALL, uri);

                    Log.i("THOMAS", "..."+uri.toString());

                    if (!checkPermission(CALL_PHONE)) // Request permission if we don't have it
                        requestPermission(CALL_PHONE);

                    if (checkPermission(CALL_PHONE) && callIntent.resolveActivity(getPackageManager()) != null)  // if we have the permission AND an activity exists
                            startActivity(callIntent);

                    // TODO: no activity exists :(

                }
            });

            Log.i("Dial activity", "tel" + phoneNumbers.get(i));
            phoneLayout.addView(newRow);

        }

    }

    private boolean checkPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission(String permission) {
        ActivityCompat.requestPermissions(this, new String[]{permission},42);
    }

}
