package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class DagilimDetayActivity extends AppCompatActivity {
    ImageView soruDagilimiImageView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        setContentView(R.layout.activity_dagilim_detay);
        soruDagilimiImageView=findViewById(R.id.soruDagilimiImageView);
        Intent intent=getIntent();
        String ders=intent.getStringExtra("ders");

        if(ders.equals("tytTurkce"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytturkce);
        }
        else if(ders.equals("tytMatematik"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytmatematik);
        }
        else if(ders.equals("tytTarih"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tyttarih);
        }
        else if(ders.equals("tytGeometri"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytgeometri);
        }
        else if(ders.equals("tytFizik"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytfizik);
        }
        else if(ders.equals("tytKimya"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytkimya);
        }
        else if(ders.equals("tytBiyoloji"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytbiyoloji);
        }
        else if(ders.equals("tytDin"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytdin);
        }
        else if(ders.equals("tytCografya"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytcografya);
        }
        else if(ders.equals("tytFelsefe"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.tytfelsefe);
        }
        else if(ders.equals("aytMatematik"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytmatematik);
        }
        else if(ders.equals("aytGeometri"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytgeometri);
        }
        else if(ders.equals("aytEdebiyat"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytedebiyat);
        }
        else if(ders.equals("aytTarih1"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.ayttarihbir);
        }
        else if(ders.equals("aytTarih2"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.ayttarihiki);
        }
        else if(ders.equals("aytCografya1"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytcografyabir);
        }
        else if(ders.equals("aytCografya2"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytcografyaiki);
        }
        else if(ders.equals("aytFelsefe"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytfelsefe);
        }
        else if(ders.equals("aytDin"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytdin);
        }
        else if(ders.equals("aytFizik"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytfizik);
        }
        else if(ders.equals("aytKimya"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytkimya);
        }
        else if(ders.equals("aytBiyoloji"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytbiyoloji);
        }
        else if(ders.equals("aytDil"))
        {
            soruDagilimiImageView.setImageResource(R.drawable.aytdil);
        }




    }
}
