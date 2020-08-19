package com.recepboyvat.universitesiralamalarivepuanlari.Authentication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.recepboyvat.universitesiralamalarivepuanlari.MainActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.R;


public class GirisYapActivity extends AppCompatActivity {
    EditText emailText,passwordText;
    CardView girisYapCardView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    public String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);
        emailText=findViewById(R.id.emailEditTextGiris);
        passwordText=findViewById(R.id.parolaEditTextGiris);
        girisYapCardView=findViewById(R.id.girisYapCard);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();



        if(firebaseUser!=null)
        {
            Toast.makeText(getApplicationContext(),"Aktif oturum bulunmaktadir",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }



    }




    public void girisYapp(View view)
    {
        email=emailText.getText().toString();
        password=passwordText.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

                    Toast.makeText(getApplicationContext(),"Başarıyla giriş yaptınız",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Oturum açma sırasında bir hata oluştu",Toast.LENGTH_LONG).show();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Oturum açma esnasında bir hata oluştu",Toast.LENGTH_LONG).show();
            }
        });
    }


}
