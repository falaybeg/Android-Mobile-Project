package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText edtUserName,edtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth =FirebaseAuth.getInstance();

        edtUserName     = (EditText) findViewById(R.id.edtUserName);
        edtPass         = (EditText) findViewById(R.id.edtPass);

        findViewById(R.id.btnRegister).setOnClickListener(this);
        findViewById(R.id.btnAddLogin).setOnClickListener(this);

    }

    // Login isleminde Validation kontrolleri
    private void userLogin() {

        String uName    =edtUserName.getText().toString().trim();
        String pass     =edtPass.getText().toString().trim();

        if(uName.isEmpty()){
            edtUserName.setError("Eposta adresi boş !");
            edtUserName.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(uName).matches()){
            edtUserName.setError("Eposta adresi");
            edtUserName.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            edtPass.setError("Şifre adresi boş !");
            edtPass.requestFocus();
            return;
        }
        if(pass.length()<6){
            edtPass.setError("Minumum 6 karakter olmalıdır.");
            edtPass.requestFocus();
            return;
        }


        // Firebase"e email ve sifre ile giris islemi
        mAuth.signInWithEmailAndPassword(uName,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Giriş Yapılıyor LÜTFEN BEKLEYİNİZ...", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    // burdada tikladigimiz buton islemi
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnRegister:

                startActivity(new Intent(this , RegisterActivity.class));
                break;
            
            case R.id.btnAddLogin:
                userLogin();
                break;
        }


    }


}
