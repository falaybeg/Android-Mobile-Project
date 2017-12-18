package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    Button C1,A2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        C1 = (Button) findViewById(R.id.C1);
        A2 = (Button) findViewById(R.id.A2);
        int sayac=0;

        // Quiz Ekraninda Dogru soru sectiginde ekran kapaniyor ve Aktivite Listesi ekrani geliyor
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(QuizActivity.this, "TEBRİKLER bildiniz !!!", Toast.LENGTH_SHORT).show();

                int timeout = 1500;
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        finish();
                        Intent anaSayfa = new Intent(QuizActivity.this, ListActivity.class);
                        startActivity(anaSayfa);
                    }
                }, timeout);

            }
        });
    }
}
