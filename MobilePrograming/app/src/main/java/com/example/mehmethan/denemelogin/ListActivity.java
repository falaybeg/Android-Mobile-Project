package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ListActivity extends AppCompatActivity {


    CheckBox dolu1,dolu2,dolu3,dolu4,dolu5;
    Button duzenle,onayla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dolu1 = (CheckBox) findViewById(R.id.dolu1);
        dolu2 = (CheckBox) findViewById(R.id.dolu2);
        dolu3 = (CheckBox) findViewById(R.id.dolu3);
        dolu4 = (CheckBox) findViewById(R.id.dolu4);
        dolu5 = (CheckBox) findViewById(R.id.dolu5);

        duzenle = (Button) findViewById(R.id.duzenle);
        onayla = (Button) findViewById(R.id.onayla);


        // kullanicinin sectigi aktiviteli check olarak getiriyoruz
        dolu1.setChecked(true);
        dolu2.setChecked(true);
        dolu3.setChecked(true);
        dolu4.setChecked(true);
        dolu5.setChecked(true);

        // Aktivite turunu seciyoruz.
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Etkinlik seçiniz..");
        spinnerArray.add("Hafta İçi");
        spinnerArray.add("Hafta Sonu");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);


        // Aktivite islemlerini duzenliyiceksek
        duzenle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this, "Aktivite Başarıyla Güncellendi !", Toast.LENGTH_SHORT).show();


                int timeout = 1200; // make the activity visible for 4 seconds

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                        Intent anaSayfa = new Intent(ListActivity.this, HomeActivity.class);
                        startActivity(anaSayfa);
                    }
                }, timeout);


            }
        });

        // Duzenlenen aktiviteleri onaylama islemi
        onayla.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this, "Başarıyla Onaylandı !!", Toast.LENGTH_SHORT).show();

                int timeout = 1200; // make the activity visible for 4 seconds

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                        Intent anaSayfa = new Intent(ListActivity.this, HomeActivity.class);
                        startActivity(anaSayfa);
                    }
                }, timeout);

            }
        });

    }
}
