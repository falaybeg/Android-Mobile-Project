package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button test,yeniBilgi,activitySec,activityEkle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        activitySec = (Button) findViewById(R.id.btnActivity);
        activityEkle = (Button) findViewById(R.id.btnAddAct);



        // Gecerli aktiviteleri ekrani acilir
        activitySec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent anaSayfa = new Intent(HomeActivity.this, QuizActivity.class);
                startActivity(anaSayfa);
            }
        });

        // Yeni Aktivite eklemek istedigimizde ekran acilir
        activityEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent anaSayfa = new Intent(HomeActivity.this, NewInfoActivity.class);
                startActivity(anaSayfa);
            }
        });


    }
}
