package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class AddActivity extends AppCompatActivity {

    Button ekle;
    EditText yeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        ekle = (Button) findViewById(R.id.newAdd);
        yeni = (EditText) findViewById(R.id.aktiviteAdi);

        // yeni aktivite kaydet buttonu
        ekle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String yenisi = yeni.getText().toString();

                if(yenisi.isEmpty())
                {
                    Toast.makeText(AddActivity.this, "Aktivite adı boş bırakılamaz !!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // aktivite EditText bos degilse yeni aktivite olusturuluyor
                    Toast.makeText(AddActivity.this, "Yeni aktivite başarıyla kaydedildi !", Toast.LENGTH_SHORT).show();

                    int timeout = 3000; // make the activity visible for 4 seconds
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            finish();
                            Intent anaSayfa = new Intent(AddActivity.this, HomeActivity.class);
                            startActivity(anaSayfa);
                        }
                    }, timeout);
                }
            }
        });
    }
}
