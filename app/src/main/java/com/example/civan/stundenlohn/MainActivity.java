package com.example.civan.stundenlohn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText lohnNormal, lohnNachts, lohnFeiertags, lohnSonntags;
    private Button berechnen;
    private TextView ergebnis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    /** Called when the user taps the Send button */
    public void addListenerOnButton() {
        lohnNormal = (EditText) findViewById(R.id.normal);
        lohnNachts = (EditText) findViewById(R.id.nachts);
        lohnSonntags = (EditText) findViewById(R.id.sonntags);
        lohnFeiertags = (EditText) findViewById(R.id.feiertags);
        berechnen =  (Button) findViewById(R.id.berechnen);
        ergebnis = (TextView) findViewById(R.id.ergebnis);

        berechnen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double mindestlohn = 9.19;
                double nachtzuschlag = 1.25;
                double feiertagszuschlag = 2.0;
                double sonntagszuschlag = 1.5;
                String stundenNormal = lohnNormal.getText().toString();
                String stundenNachts = lohnNachts.getText().toString();
                String stundenFeiertags = lohnFeiertags.getText().toString();
                String stundenSonntags = lohnSonntags.getText().toString();
                double wertNormal = Double.parseDouble(stundenNormal);
                double wertNachts = Double.parseDouble(stundenNachts);
                double wertFeiertags = Double.parseDouble(stundenFeiertags);
                double wertSonntags = Double.parseDouble(stundenSonntags);

                double lohn =   (wertNormal * mindestlohn)
                        +   (wertNachts * mindestlohn * nachtzuschlag)
                        +   (wertFeiertags * mindestlohn * feiertagszuschlag)
                        +   (wertSonntags * mindestlohn * sonntagszuschlag);

                ergebnis.setText(Double.toString(lohn));
                Toast.makeText(getApplicationContext(), String.valueOf(ergebnis), Toast.LENGTH_LONG).show();
            }
        });
    }
}
