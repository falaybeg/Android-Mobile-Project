package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class NewInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_info);


        setTitle("Bunlari Biliyor Musunuz ?");


        int timeout = 5000;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent anaSayfa = new Intent(NewInfoActivity.this, AddActivity.class);
                startActivity(anaSayfa);
            }
        }, timeout);

    }
}
