package com.recepboyvat.universitesiralamalarivepuanlari.Authentication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    ImageView profilFotoImageView;
    TextView kullaniciAdiTextView;
    Button cikisYapBtn;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    int cinsiyet;
    String kullaniciAdi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        cikisYapBtn=findViewById(R.id.profilCikisYapBtn);
        profilFotoImageView=findViewById(R.id.profilFotoImageView);
        kullaniciAdiTextView=findViewById(R.id.kullaniciAdiTextView);
        if(firebaseUser!=null)
        {
            kullaniciBilgileriGetir();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Aktif kullanici bulumamaktadir",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(),KayitOlActivity.class);
            startActivity(intent);
        }
        cikisYapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CikisYapActivity.class);
                startActivity(intent);
            }
        });








    }

    public void kayitOlGit(View v)
    {
        Intent intent=new Intent(getApplicationContext(),KayitOlActivity.class);
        startActivity(intent);
    }

    public void kullaniciBilgileriGetir()
    { FirebaseFirestore firebaseFirestore1=FirebaseFirestore.getInstance();
        CollectionReference collectionReference=firebaseFirestore1.collection("Users");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e!=null)
                {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

                }
                else
                {
                    if(queryDocumentSnapshots!=null){
                        for(DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments())
                        {
                            Map<String,Object> kullanici=snapshot.getData();
                            String veritabaniEmail=(String)kullanici.get("useremail");
                            String veritabaniUserName=(String)kullanici.get("username");
                            int veritabaniCinsiyet=snapshot.getLong("gender").intValue();
                            if(veritabaniEmail.equals(firebaseUser.getEmail()))
                            {
                                cinsiyet=veritabaniCinsiyet;
                                if(cinsiyet==1)
                                {
                                    profilFotoImageView.setImageResource(R.drawable.young);
                                }
                                else if(cinsiyet==2)
                                {
                                    profilFotoImageView.setImageResource(R.drawable.woman);
                                }
                                else
                                {
                                    profilFotoImageView.setImageResource(R.drawable.bigender);
                                }

                                kullaniciAdi=veritabaniUserName;
                                kullaniciAdiTextView.setText(kullaniciAdi);

                            }

                        }
                    }
                }
            }
        });


    }


}
