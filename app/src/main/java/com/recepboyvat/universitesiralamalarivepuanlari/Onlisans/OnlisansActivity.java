package com.recepboyvat.universitesiralamalarivepuanlari.Onlisans;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;


import com.recepboyvat.universitesiralamalarivepuanlari.MainActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.Onlisans.ui.main.SectionsPagerAdapter;
import com.recepboyvat.universitesiralamalarivepuanlari.Program;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OnlisansActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlisans);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        MainActivity.programlar.clear();
        AddMenuItemsFromJsonOnlisans();
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);




    }

    private void AddMenuItemsFromJsonOnlisans(){

        try {
            String jsonDataString=readJsonDataFromFileOnlisans();
            JSONArray menuItemsJsonArray=new JSONArray(jsonDataString);

            for(int i=0;i<menuItemsJsonArray.length();++i)
            {
                JSONObject menuItemObject=menuItemsJsonArray.getJSONObject(i);
                Program program=new Program(menuItemObject.getInt("programKodu"),menuItemObject.getString("bolumAdi"),menuItemObject.getInt("bursTuru"),menuItemObject.getInt("devletOrOzel"),
                        menuItemObject.getString("docentSayisi"),menuItemObject.getString("doktorSayisi"),menuItemObject.getInt("genelKontenjan"),
                        menuItemObject.getString("ilkYerlesmeOrani"),menuItemObject.getString("okulBirincisiKontenjani"),menuItemObject.getDouble("okulBirincisiTabanPuan"),
                        menuItemObject.getInt("okulBirincisiTabanSiralama"),menuItemObject.getString("profSayisi"),menuItemObject.getString("programAdi"),menuItemObject.getInt("puanTuru"),
                        menuItemObject.getDouble("tabanPuandokuz"),menuItemObject.getDouble("tabanPuansekiz"),menuItemObject.getDouble("tabanPuanyedi"),menuItemObject.getInt("tabanSiralamadokuz"),
                        menuItemObject.getInt("tabanSiralamasekiz"),menuItemObject.getInt("tabanSiralamayedi"),menuItemObject.getDouble("tavanPuandokuz"),
                        menuItemObject.getDouble("tavanPuansekiz"),menuItemObject.getDouble("tavanPuanyedi"),menuItemObject.getInt("tavanSiralamadokuz"),
                        menuItemObject.getInt("tavanSiralamasekiz"),menuItemObject.getInt("tavanSiralamayedi"),menuItemObject.getInt("toplamKontenjan"),
                        menuItemObject.getString("universiteAdi"),menuItemObject.getInt("lisansOrOnlisans"));
                MainActivity.programlar.add(program);


            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }




    private String readJsonDataFromFileOnlisans() throws IOException
    {
        InputStream inputStream=null;
        StringBuilder builder=new StringBuilder();

        try{
            String jsonDataString=null;
            inputStream=getResources().openRawResource(R.raw.onlisansprogramlari);
            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream,"UTF-8"));
            while ((jsonDataString=bufferedReader.readLine())!=null){
                builder.append(jsonDataString);
            }


        }
        finally {
            if(inputStream!=null){
                inputStream.close();
            }

        }
        return new String(builder);
    }

}