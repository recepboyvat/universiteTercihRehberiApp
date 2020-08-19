package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.recepboyvat.universitesiralamalarivepuanlari.Authentication.KayitOlActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.Authentication.ProfileActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.Onlisans.OnlisansActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final List<Program> programlar=new ArrayList<Program>();
    CardView cardViewLisans;
    CardView cardViewSayac;
    CardView cardViewHesap;
    CardView cardViewDagilim;
    CardView onLisans;
    CardView favoriler;
    CardView hakkinda;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    private FirebaseAnalytics mFirebaseAnalytics;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewLisans=findViewById(R.id.cardViewLisans);
        cardViewSayac=findViewById(R.id.geriSayim);
        onLisans=findViewById(R.id.onlisansCardView);
        favoriler=findViewById(R.id.favorilerCardView );
        cardViewHesap=findViewById(R.id.hesapCardView);
        cardViewDagilim=findViewById(R.id.SoruDagilimCardView);
        hakkinda=findViewById(R.id.HakkindaCardView);
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    public void lisansaGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),LisansActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void onlisansaGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(), OnlisansActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void DagilimaGit(View view)
    {

        Intent intent=new Intent(getApplicationContext(),DagilimActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);

    }


    public void sayacaGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),GeriSayimActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void puanaGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),PuanHesaplaActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void favorilereGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),FavorilerActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void HakkindayaGit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),HakkindaActivity.class);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        startActivity(intent);
    }
    public void kayitOlaGit(View view)
    {
        if(user!=null)
        {
            Intent intent=new Intent(getApplicationContext(), ProfileActivity.class);
            System.out.println("Useremail"+user.getEmail());
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getApplicationContext(), KayitOlActivity.class);
            startActivity(intent);
        }

    }
}
