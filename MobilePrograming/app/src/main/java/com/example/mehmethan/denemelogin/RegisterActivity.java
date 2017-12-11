package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userMail , userPass , userPasRep ;


    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.btnSaveChanges).setOnClickListener(this);

        userMail    = (EditText) findViewById(R.id.userMail);
        userPass    = (EditText) findViewById(R.id.userPass);
        userPasRep  = (EditText) findViewById(R.id.userPassRep);


        mAuth = FirebaseAuth.getInstance();
    }

    private void registerUser(){

        final String uName    =userMail.getText().toString().trim();
        final String pass     =userPass.getText().toString().trim();
        String repass   =userPasRep.getText().toString().trim();

        if(uName.isEmpty()){
            userMail.setError("Eposta adresi boş !");
            userMail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(uName).matches()){
            userMail.setError("Eposta adresi");
            userMail.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            userPass.setError("Şifre adresi boş !");
            userPass.requestFocus();
            return;
        }
        if(pass.length()<6){
            userPass.setError("Minumum 6 karakter olmalıdır.");
            userPass.requestFocus();
            return;
        }
        if(pass==repass){
            userPass.setError("Şifreler eşleşmiyor !");
            userPass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(uName,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                Database db = new Database(getApplicationContext());

                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Kullanıcı Kaydı Başarılı",Toast.LENGTH_SHORT).show();
                    Intent intent1=new Intent(RegisterActivity.this,UserrActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                   long id = db.InsertUser(uName,pass);
                    if(id == -1)
                    {
                        Toast.makeText(RegisterActivity.this, "SQLite Kayıt Hatası Oluştu!!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "SQLite Kayıt işlemi başarılı...", Toast.LENGTH_SHORT).show();
                    }

                    startActivity(intent1);
                }
                else{
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"Kullanıcı zaten kayıtlı !",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){



            case R.id.btnSaveChanges:
                registerUser();

        }
    }
}
