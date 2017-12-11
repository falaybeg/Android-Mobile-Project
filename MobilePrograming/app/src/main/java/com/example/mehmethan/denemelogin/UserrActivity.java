package com.example.mehmethan.denemelogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.internal.kx;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;

public class UserrActivity extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText editName,editSurname,editAge;
    RadioGroup radioGroup;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userr);
        save = (Button) findViewById(R.id.btnSave);
        editName = (EditText) findViewById(R.id.editName);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editAge = (EditText) findViewById(R.id.editAge);

        mAuth = FirebaseAuth.getInstance();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final  String Name         =editName.getText().toString();
                final String Surname      =editSurname.getText().toString();
                final String Age          =editAge.getText().toString();
                String DisplayName  =(editName.getText().toString()+editSurname.getText().toString());

                if(Name.isEmpty()){
                    editName.setError("İsim alanı boş !");
                    editName.requestFocus();
                    return;
                }
                if(Surname.isEmpty()){
                    editSurname.setError("Soyisim alanı boş !");
                    editSurname.requestFocus();
                    return;
                }
                if(Age.isEmpty()){
                    editAge.setError("Yaş alanı boş !");
                    editAge.requestFocus();
                    return;
                }

                FirebaseUser User = mAuth.getCurrentUser();
                Database db = new Database(getApplicationContext());
                db.UpdateUser(Name,Surname,Age);

                if(User!=null){

                    UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                            .setDisplayName(DisplayName)
                            .build();
                    User.updateProfile(profile)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
/*
                                Toast.makeText(UserActivity.this,"Profil güncellendi !",Toast.LENGTH_SHORT).show();
*/
                                        Intent home=new Intent(UserrActivity.this,HomeActivity.class);
                                        Toast.makeText(getApplicationContext(), "SQLite Profil Guncelleme işlemi başarılı...", Toast.LENGTH_SHORT).show();
                                        startActivity(home);
                                    }
                                }
                            });
                }
            }
        });
    }
}
