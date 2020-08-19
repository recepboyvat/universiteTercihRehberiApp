package com.recepboyvat.universitesiralamalarivepuanlari.Authentication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.recepboyvat.universitesiralamalarivepuanlari.MainActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

import java.util.HashMap;
import java.util.Map;

public class KayitOlActivity extends AppCompatActivity {
    EditText kullaniciAdiEditText, hedefEditText, emailEditText, parolaEditText, parolatekrarEditText;
    CardView kayitOlCardView, girisYapCardView;
    RadioButton erkekRadioButton, kadinRadioButton, cinsiyetsizRadioButton;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseUser user;

    int cinsiyet = 4;
    String parola;
    String kullaniciAdi;
    String email;
    String hedef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        kullaniciAdiEditText = findViewById(R.id.kullaniciAdiEditText);
        hedefEditText = findViewById(R.id.hedefEditText);
        emailEditText = findViewById(R.id.emailEditText);
        parolaEditText = findViewById(R.id.parolaEditText);
        parolatekrarEditText = findViewById(R.id.parolaTekrarEditText);
        kayitOlCardView = findViewById(R.id.kayitOlCardView);
        girisYapCardView = findViewById(R.id.girisYapGitCardView);
        erkekRadioButton = findViewById(R.id.radio_erkek);
        kadinRadioButton = findViewById(R.id.radio_kadin);
        cinsiyetsizRadioButton = findViewById(R.id.radio_lgbt);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user = firebaseAuth.getCurrentUser();
        if (user != null) {
            System.out.println("User email:" + user.getEmail());
        }



    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_erkek:
                if (checked)
                    cinsiyet = 1;
                break;
            case R.id.radio_kadin:
                if (checked)
                    cinsiyet = 2;
                break;
            case R.id.radio_lgbt:
                if (checked)
                    cinsiyet = 3;
                break;
            default:
                cinsiyet = 4;
                break;


        }
    }





    public void girisYapGit(View view) {
        Intent intent = new Intent(getApplicationContext(), GirisYapActivity.class);
        startActivity(intent);
    }


    public boolean formDoldurma() {
        if (kullaniciAdiEditText.getText().toString().equals("") || hedefEditText.getText().toString().equals("") || emailEditText.getText().toString().equals("") || parolatekrarEditText.getText().toString().equals("") || parolatekrarEditText.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Tüm alanların doldurulmasi zorunludur", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean parolaEsitlik(String parola1, String parola2) {
        if (parola1.equals(parola2)) {
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Parolalar Eşleşmiyor", Toast.LENGTH_LONG).show();
            parolaEditText.setText("");
            parolatekrarEditText.setText("");
            return false;
        }

    }

    public void KayıtOl(View view) {
        if (formDoldurma() && parolaEsitlik(parolaEditText.getText().toString(), parolatekrarEditText.getText().toString())) {
            kullaniciAdi = kullaniciAdiEditText.getText().toString();
            hedef = hedefEditText.getText().toString();
            email = emailEditText.getText().toString();
            parola = parolaEditText.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(email, parola).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Toast.makeText(getApplicationContext(), "Başarıyla kayit oldunuz", Toast.LENGTH_SHORT).show();
                    HashMap<String, Object> kullaniciBilgileri = new HashMap<>();
                    kullaniciBilgileri.put("useremail", email);
                    kullaniciBilgileri.put("username", kullaniciAdi);
                    kullaniciBilgileri.put("hedef", hedef);
                    kullaniciBilgileri.put("password", parola);
                    kullaniciBilgileri.put("gender", cinsiyet);
                    firebaseFirestore.collection("Users").document(emailEditText.getText().toString()).set(kullaniciBilgileri).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Kullanici bilgileri kaydedildi",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"Kullanici olusturulurken hata olustu",Toast.LENGTH_LONG).show();
                        }
                    });
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Bir hata olustu", Toast.LENGTH_LONG).show();

                    emailEditText.setText("");
                    parolaEditText.setText("");
                    parolatekrarEditText.setText("");


                }
            });


        } else {
            Toast.makeText(getApplicationContext(), "Lütfen tüm alanlari doldurun", Toast.LENGTH_LONG).show();
        }
    }
}

