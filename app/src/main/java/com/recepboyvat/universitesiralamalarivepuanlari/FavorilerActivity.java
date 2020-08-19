package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari.ProgramDetaylariActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.CustomUniversiteProgramAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavorilerActivity extends AppCompatActivity {
    ListView favorilerListView;
    private AdView mAdView;

    public static List<Program> favoriProgramlar=new ArrayList<Program>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriler);
        favorilerListView=findViewById(R.id.favorilerListView);

        favorileriGetir();
        CustomUniversiteProgramAdapter programAdapter=new CustomUniversiteProgramAdapter(this,favoriProgramlar);
        favorilerListView.setAdapter(programAdapter);
        favorilerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(), ProgramDetaylariActivity.class);
                intent.putExtra("programKodu",favoriProgramlar.get(position).getProgramKodu());
                intent.putExtra("FROM_ACTIVITY","Favoriler");
                startActivity(intent);
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }
    public void favorileriGetir()
    {
        try {
            favoriProgramlar.clear();
            SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("FavoriProgramlarDatabase2",Context.MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favoriProgramKodlari(programKodu INT PRIMARY KEY,programAdi VARCHAR,bolumAdi VARCHAR,devletOrOzel INT,puanTuru INT,bursTuru INT,genelKontenjan INT,okulBirincisiKontenjani VARCHAR,toplamKontenjan INT,ilkYerlesmeOrani VARCHAR,universiteAdi VARCHAR,lisansOrOnlisans INT,profSayisi VARCHAR,docentSayisi VARCHAR,doktorSayisi VARCHAR,tabanPuandokuz REAL,tabanSiralamadokuz INT,tavanPuandokuz REAL,tavanSiralamadokuz INT,tabanPuansekiz REAL,tabanSiralamasekiz INT,tavanPuansekiz REAL,tavanSiralamasekiz INT,tabanPuanyedi REAL,tabanSiralamayedi INT,tavanPuanyedi REAL,tavanSiralamayedi INT,okulBirincisiTabanPuan REAL,okulBirincisiTabanSiralama INT)");

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM favoriProgramKodlari",null);

            int programKoduIx = cursor.getColumnIndex("programKodu");
            int programAdiIx=cursor.getColumnIndex("programAdi");
            int bolumAdiIx=cursor.getColumnIndex("bolumAdi");
            int devletOrOzelIx=cursor.getColumnIndex("devletOrOzel");
            int puanTuruIx=cursor.getColumnIndex("puanTuru");
            int bursTuruIx=cursor.getColumnIndex("bursTuru");
            int genelKontenjanIx=cursor.getColumnIndex("genelKontenjan");
            int okulBirincisiKontenjaniIx=cursor.getColumnIndex("okulBirincisiKontenjani");
            int toplamKontenjanIx=cursor.getColumnIndex("toplamKontenjan");
            int ilkYerlesmeOraniIx=cursor.getColumnIndex("ilkYerlesmeOrani");
            int universiteAdiIx=cursor.getColumnIndex("universiteAdi");
            int lisansOrOnlisansIx=cursor.getColumnIndex("lisansOrOnlisans");
            int profSayisiIx=cursor.getColumnIndex("profSayisi");
            int docentSayisiIx=cursor.getColumnIndex("docentSayisi");
            int doktorSayisiIx=cursor.getColumnIndex("genelKontenjan");
            int tabanPuandokuzIx=cursor.getColumnIndex("tabanPuandokuz");
            int tabanSiralamadokuzIx=cursor.getColumnIndex("tabanSiralamadokuz");
            int tavanPuandokuzIx=cursor.getColumnIndex("tavanPuandokuz");
            int tavanSiralamadokuzIx=cursor.getColumnIndex("tavanSiralamadokuz");
            int tabanPuansekizIx=cursor.getColumnIndex("tabanPuansekiz");
            int tabanSiralamasekizIx=cursor.getColumnIndex("tabanSiralamasekiz");
            int tavanPuansekizIx=cursor.getColumnIndex("tavanPuansekiz");
            int tavanSiralamasekizIx=cursor.getColumnIndex("tavanSiralamasekiz");
            int tabanPuanyediIx=cursor.getColumnIndex("tabanPuanyedi");
            int tabanSiralamayediIx=cursor.getColumnIndex("tabanSiralamayedi");
            int tavanPuanyediIx=cursor.getColumnIndex("tavanPuanyedi");
            int tavanSiralamayediIx=cursor.getColumnIndex("tavanSiralamayedi");
            int okulBirincisiTabanPuanIx=cursor.getColumnIndex("okulBirincisiTabanPuan");
            int okulBirincisiTabanSiralamaIx=cursor.getColumnIndex("okulBirincisiTabanSiralama");


            while (cursor.moveToNext()) {
                favoriProgramlar.add(new Program(cursor.getInt(programKoduIx),cursor.getString(bolumAdiIx),cursor.getInt(bursTuruIx),cursor.getInt(devletOrOzelIx),cursor.getString(docentSayisiIx),cursor.getString(doktorSayisiIx),cursor.getInt(genelKontenjanIx),cursor.getString(ilkYerlesmeOraniIx),cursor.getString(okulBirincisiKontenjaniIx),cursor.getDouble(okulBirincisiTabanPuanIx),cursor.getInt(okulBirincisiTabanSiralamaIx),cursor.getString(profSayisiIx),cursor.getString(programAdiIx),cursor.getInt(puanTuruIx),cursor.getDouble(tabanPuandokuzIx),cursor.getDouble(tabanPuansekizIx),cursor.getDouble(tabanPuanyediIx),cursor.getInt(tabanSiralamadokuzIx),cursor.getInt(tabanSiralamasekizIx),cursor.getInt(tabanSiralamayediIx),cursor.getDouble(tavanPuandokuzIx),cursor.getDouble(tavanPuansekizIx),cursor.getDouble(tavanPuanyediIx),cursor.getInt(tavanSiralamadokuzIx),cursor.getInt(tavanSiralamasekizIx),cursor.getInt(tavanSiralamayediIx),cursor.getInt(toplamKontenjanIx),cursor.getString(universiteAdiIx),cursor.getInt(lisansOrOnlisansIx)));
            }

            cursor.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        }

}
