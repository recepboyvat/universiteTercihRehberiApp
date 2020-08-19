package com.recepboyvat.universitesiralamalarivepuanlari;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari.ProgramDetaylariActivity;

import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.CustomUniversiteProgramAdapter;


import java.util.ArrayList;
import java.util.List;

public class UniversiteProgramlarActivity extends AppCompatActivity {
    String universiteAdi;
    String universiteAdi2;
    String bolumAdi1;
    String bolumAdi2;
    private InterstitialAd mInterstitialAd;

    final List<Program> universiteProgramlar=new ArrayList<Program>();
     List<Program> filteredProgramlar2;
     ListView listView2;
    CustomUniversiteProgramAdapter filterAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universite_programlar);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        SearchView searchView=findViewById(R.id.universityProgramlarSearch);
        final ListView listView=findViewById(R.id.universityProgramListView);
        listView2=findViewById(R.id.universityProgramListView);

        Intent intent=getIntent();
        universiteAdi=intent.getStringExtra("universiteAdi");
        universiteAdi2=intent.getStringExtra("universiteAdi2");

        Intent intent2=getIntent();
        bolumAdi1=intent2.getStringExtra("bolumAdi1");
        bolumAdi2=intent2.getStringExtra("bolumAdi2");




            if (universiteAdi == null && universiteAdi2 == null && bolumAdi1 == null) {
                bolumFiltrele(bolumAdi2);
            } else if (universiteAdi == null && universiteAdi2 == null && bolumAdi2 == null) {
                bolumFiltrele(bolumAdi1);
            } else if (universiteAdi2 == null && bolumAdi1 == null && bolumAdi2 == null) {
                universiteFiltrele(universiteAdi);
            } else if (universiteAdi == null && bolumAdi1 == null && bolumAdi2 == null) {
                universiteFiltrele(universiteAdi2);
            }



        CustomUniversiteProgramAdapter customUniversiteProgramAdapter=new CustomUniversiteProgramAdapter(this,universiteProgramlar);
        listView.setAdapter(customUniversiteProgramAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), ProgramDetaylariActivity.class);
                intent.putExtra("programKodu",universiteProgramlar.get(position).getProgramKodu());
                intent.putExtra("FROM_ACTIVITY","UniversiteProgram");
                startActivity(intent);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }


            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String sorgu=newText.toUpperCase();
                filteredProgramlar2=new ArrayList<Program>();
                for (int i=0;i<universiteProgramlar.size();i++)
                {
                    Program program=universiteProgramlar.get(i);
                    if(program.getUniversiteAdi().contains(sorgu))
                    {
                        filteredProgramlar2.add(program);
                    }
                }
                filterAdapter2=new CustomUniversiteProgramAdapter(UniversiteProgramlarActivity.this,filteredProgramlar2);
                listView2.setAdapter(filterAdapter2);
                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getApplicationContext(), ProgramDetaylariActivity.class);
                        intent.putExtra("programKodu",filteredProgramlar2.get(position).getProgramKodu());
                        startActivity(intent);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
                    }
                });


                return true;
            }
        });




    }


    public void universiteFiltrele(String universiteAdi)
    {
        for(int i=0;i<MainActivity.programlar.size();i++)
        {
            if(universiteAdi.equals(MainActivity.programlar.get(i).getUniversiteAdi()))
            {
                universiteProgramlar.add(MainActivity.programlar.get(i));
            }
        }
    }
    public void bolumFiltrele(String bolumAdi)
    {
        for(int i=0;i<MainActivity.programlar.size();i++)
        {
            if(bolumAdi.equals(MainActivity.programlar.get(i).getBolumAdi()))
            {
                universiteProgramlar.add(MainActivity.programlar.get(i));
            }
        }
    }
}
