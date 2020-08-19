package com.recepboyvat.universitesiralamalarivepuanlari.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.recepboyvat.universitesiralamalarivepuanlari.MainActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

public class CikisYapActivity extends AppCompatActivity {
    Button cikisYapBtn;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cikis_yap);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        if(user==null)
        {
            Toast.makeText(getApplicationContext(),"Bir hata olustu",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),GirisYapActivity.class);
            startActivity(intent);

        }


        cikisYapBtn=findViewById(R.id.cikisYapBtn);
        cikisYapBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        firebaseAuth.signOut();
                        Toast.makeText(getApplicationContext(),"Başarıyla çıkış yaptınız",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }



}
