package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DagilimActivity extends AppCompatActivity {
    Button tytTurkce,tytMat,tytGeo,tytFizik,tytKimya,tytBiyoloji,tytTarih,tytCografya,tytFelsefe,tytDin,
    aytMatematik,aytGeo,aytFizik,aytKimya,aytBiyoloji,aytEdebiyat,aytCografya1,aytTarih,aytCografya2,aytFelsefe,
    aytDin,aytDil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagilim);
        tanimla();

        tytTurkce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytTurkce");
                startActivity(intent);
            }
        });
        tytMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytMatematik");
                startActivity(intent);
            }
        });
        tytDin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytDin");
                startActivity(intent);
            }
        });
        tytFelsefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytFelsefe");
                startActivity(intent);
            }
        });
        tytCografya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytCografya");
                startActivity(intent);
            }
        });
        tytTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytTarih");
                startActivity(intent);
            }
        });
        tytBiyoloji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytBiyoloji");
                startActivity(intent);
            }
        });
        tytFizik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytFizik");
                startActivity(intent);
            }
        });
        tytKimya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytKimya");
                startActivity(intent);
            }
        });
        tytGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","tytGeometri");
                startActivity(intent);
            }
        });
        aytMatematik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytMatematik");
                startActivity(intent);
            }
        });
        aytGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytGeometri");
                startActivity(intent);
            }
        });
        aytFizik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytFizik");
                startActivity(intent);
            }
        });
        aytBiyoloji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytBiyoloji");
                startActivity(intent);
            }
        });
        aytEdebiyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytEdebiyat");
                startActivity(intent);
            }
        });
        aytCografya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytCografya1");
                startActivity(intent);
            }
        });
        aytCografya2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytCografya2");
                startActivity(intent);
            }
        });
        aytFelsefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytFelsefe");
                startActivity(intent);
            }
        });
        aytDin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytDin");
                startActivity(intent);
            }
        });
        aytDil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytDil");
                startActivity(intent);
            }
        });
        aytKimya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytKimya");
                startActivity(intent);
            }
        });
        aytTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DagilimDetayActivity.class);
                intent.putExtra("ders","aytTarih1");
                startActivity(intent);
            }
        });




    }


    public void tanimla()
    {
        tytTurkce=findViewById(R.id.tytTurkceDagilim);
        tytMat=findViewById(R.id.tytMatematikDagilim);
        tytGeo=findViewById(R.id.tytGeometriDagilim);
        tytFizik=findViewById(R.id.tytFizikDagilim);
        tytKimya=findViewById(R.id.tytKimyaDagilim);
        tytBiyoloji=findViewById(R.id.tytBiyolojiDagilim);
        tytTarih=findViewById(R.id.tytTarihDagilim);
        tytCografya=findViewById(R.id.tytCografyaDagilim);
        tytFelsefe=findViewById(R.id.tytFelsefeDagilim);
        tytDin=findViewById(R.id.tytDinDagilim);
        aytMatematik=findViewById(R.id.aytMatematikDagilim);
        aytGeo=findViewById(R.id.aytGeometriDagilim);
        aytFizik=findViewById(R.id.aytFizikDagilim);
        aytKimya=findViewById(R.id.aytKimyaDagilim);
        aytBiyoloji=findViewById(R.id.aytBiyolojiDagilim);
        aytEdebiyat=findViewById(R.id.aytEdebiyatDagilim);
        aytCografya1=findViewById(R.id.aytCografya1Dagilim);
        aytTarih=findViewById(R.id.aytTarihDagilim);
        aytCografya2=findViewById(R.id.aytCografya2Dagilim);
        aytFelsefe=findViewById(R.id.aytFelsefeDagilim);
        aytDin=findViewById(R.id.aytDinDagilim);
        aytDil=findViewById(R.id.aytDilDagilim);
    }
}
