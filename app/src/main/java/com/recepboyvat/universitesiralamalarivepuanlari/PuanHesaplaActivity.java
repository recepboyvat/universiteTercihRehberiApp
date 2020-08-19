package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class PuanHesaplaActivity extends AppCompatActivity {
    EditText diplomaNotuEditText,tytTurkceDogru,tytTurkceYanlis,tytSosyalDogru,tytSosyalYanlis,tytMatematikDogru,
    tytMatematikYanlis,tytFenDogru,tytFenYanlis,aytEdebiyatDogru,aytEdebiyatYanlis,aytTarihDogru,aytTarihYanlis,
    aytCografyaDogru,aytCograftaYanlis,aytTarih2Dogru,aytTarih2Yanlis,aytCografya2Dogru,aytCografya2Yanlis,
    aytFelsefeDogru,aytFelsefeYanlis,aytDinDogru,aytDinYanlis,aytMatematikDogru,aytMatematikYanlis,
    aytFizikDogru,aytFizikYanlis,aytKimyaDogru,aytKimyaYanlis,aytBiyolojiDogru,aytBiyolojiYanlis,aytDilDogru,
    aytDilYanlis;
    TextView tytTurkceNetTextView,tytSosyalNetTextView,tytMatematikNetTextView,tytFenNetTextView,aytEdebiyatNetTextView,aytTarih1NetTextView,aytCografya1NetTextView,
    aytTarih2NetTextView,aytCografya2NetTextView,aytFelsefeNetTextView,aytDinNetTextView,aytMatematikNetTextView,aytFizikNetTextView,aytKimyaNetTextView,aytBiyolojiNetTextView,
    aytDilNetTextView,tytHamPuanTextView,tytYerPuanTextView,tytEksikPuanTextView,EAHamPuanTextView,EAYerPuanTextView,EAEksikPuanTextView,SozelHamPuanTextView,SozelYerPuanTextView,
    sozelEksikPuanTextView,SayisalHamPuanTextView,SayisalYerPuanTextView,SayisalEksikPuanTextView,DilHamPuanTextView,DilYerPuanTextView,DilEksikPuanTextView;
    Button temizleBtn,HesaplaBtn;
    double diplomaPuan=0;
    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan_hesapla);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        tanimla();
        if(diplomaNotuKontrol(diplomaNotuEditText.getText().toString()))
        {
            HesaplaBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
            diplomaPuan=Double.parseDouble(diplomaNotuEditText.getText().toString());
            double tytTurkceNet=netGetir(tytTurkceDogru.getText().toString(),tytTurkceYanlis.getText().toString(),40);
            double tytMatematikNet=netGetir(tytMatematikDogru.getText().toString(),tytMatematikYanlis.getText().toString(),40);
            double tytFenNet=netGetir(tytFenDogru.getText().toString(),tytFenYanlis.getText().toString(),20);
            double tytSosyalNet=netGetir(tytSosyalDogru.getText().toString(),tytSosyalYanlis.getText().toString(),20);
            tytTurkceNetTextView.setText(String.valueOf(tytTurkceNet));
            tytMatematikNetTextView.setText(String.valueOf(tytMatematikNet));
            tytSosyalNetTextView.setText(String.valueOf(tytSosyalNet));
            tytFenNetTextView.setText(String.valueOf(tytFenNet));
            double tytHam=tytHamPuanHesapla(tytTurkceNet,tytSosyalNet,tytMatematikNet,tytFenNet);
            tytHamPuanTextView.setText(String.valueOf(tytHam));
            double tytYer=tytYerlestirmePuanHesapla(tytTurkceNet,tytSosyalNet,tytMatematikNet,tytFenNet,diplomaPuan);
            tytYerPuanTextView.setText(String.valueOf(tytYer));
            double tytEksikYer=tytEksikPuanHesapla(tytTurkceNet,tytSosyalNet,tytMatematikNet,tytFenNet,diplomaPuan);
            tytEksikPuanTextView.setText(String.valueOf(tytEksikYer));
            double aytMatNet=netGetir(aytMatematikDogru.getText().toString(),aytMatematikYanlis.getText().toString(),40);
            aytMatematikNetTextView.setText(String.valueOf(aytMatNet));
            double aytFizikNet=netGetir(aytFizikDogru.getText().toString(),aytFizikYanlis.getText().toString(),14);
            aytFizikNetTextView.setText(String.valueOf(aytFizikNet));
            double aytKimyaNet=netGetir(aytKimyaDogru.getText().toString(),aytKimyaYanlis.getText().toString(),13);
            aytKimyaNetTextView.setText(String.valueOf(aytKimyaNet));
            double aytBiyolojiNet=netGetir(aytBiyolojiDogru.getText().toString(),aytBiyolojiYanlis.getText().toString(),13);
            aytBiyolojiNetTextView.setText(String.valueOf(aytBiyolojiNet));
            double aytHamSayisalPuan=aytSayisalHamPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytFizikNet,aytKimyaNet,aytBiyolojiNet);
            SayisalHamPuanTextView.setText(String.valueOf(aytHamSayisalPuan));
            double aytSayisalYerPuan=aytSayisalYerPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytFizikNet,aytKimyaNet,aytBiyolojiNet,diplomaPuan);
            SayisalYerPuanTextView.setText(String.valueOf(aytSayisalYerPuan));
            double aytSayisalEksikPuan=aytSayisalEksikPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytFizikNet,aytKimyaNet,aytBiyolojiNet,diplomaPuan);
            SayisalEksikPuanTextView.setText(String.valueOf(aytSayisalEksikPuan));
            double aytEdeb1Net=netGetir(aytEdebiyatDogru.getText().toString(),aytEdebiyatYanlis.getText().toString(),24);
            aytEdebiyatNetTextView.setText(String.valueOf(aytEdeb1Net));
            double aytTarih1Net=netGetir(aytTarihDogru.getText().toString(),aytTarihYanlis.getText().toString(),10);
            aytTarih1NetTextView.setText(String.valueOf(aytTarih1Net));
            double cografya1Net=netGetir(aytCografyaDogru.getText().toString(),aytCograftaYanlis.getText().toString(),6);
            aytCografya1NetTextView.setText(String.valueOf(cografya1Net));
            double tarih2Net=netGetir(aytTarih2Dogru.getText().toString(),aytTarih2Yanlis.getText().toString(),11);
            aytTarih2NetTextView.setText(String.valueOf(tarih2Net));
            double aytCografya2Net=netGetir(aytCografya2Dogru.getText().toString(),aytCografya2Yanlis.getText().toString(),11);
            aytCografya2NetTextView.setText(String.valueOf(aytCografya2Net));
            double felsefeNet=netGetir(aytFelsefeDogru.getText().toString(),aytFelsefeYanlis.getText().toString(),12);
            aytFelsefeNetTextView.setText(String.valueOf(felsefeNet));
            double aytDinNet=netGetir(aytDinDogru.getText().toString(),aytDinYanlis.getText().toString(),6);
            aytDinNetTextView.setText(String.valueOf(aytDinNet));
            double aytSozelHamPuan=aytSozelHamPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytEdeb1Net,aytTarih1Net,cografya1Net,tarih2Net,aytCografya2Net,felsefeNet,aytDinNet);
            SozelHamPuanTextView.setText(String.valueOf(aytSozelHamPuan));
            double aytSozelYerPuan=aytSozelYerPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytEdeb1Net,aytTarih1Net,cografya1Net,tarih2Net,aytCografya2Net,felsefeNet,aytDinNet,diplomaPuan);
            SozelYerPuanTextView.setText(String.valueOf(aytSozelYerPuan));
            double aytSozelEksikPuan=aytSozelEksikPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytEdeb1Net,aytTarih1Net,cografya1Net,tarih2Net,aytCografya2Net,felsefeNet,aytDinNet,diplomaPuan);
            sozelEksikPuanTextView.setText(String.valueOf(aytSozelEksikPuan));
            double aytEaHamPuan=aytEsitAgirlikHamPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytEdeb1Net,aytTarih1Net,cografya1Net);
            EAHamPuanTextView.setText(String.valueOf(aytEaHamPuan));
            double aytEaYerPuan=aytEsitAgirlikYerPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytEdeb1Net,aytTarih1Net,cografya1Net,diplomaPuan);
            EAYerPuanTextView.setText(String.valueOf(aytEaYerPuan));
            double aytEaEksikPuan=aytEsitAgirlikEksikPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,aytMatNet,aytEdeb1Net,aytTarih1Net,cografya1Net,diplomaPuan);
            EAEksikPuanTextView.setText(String.valueOf(aytEaEksikPuan));
            double dilNet=netGetir(aytDilDogru.getText().toString(),aytDilYanlis.getText().toString(),80);
            double aytDilHamPuan=aytDilHamPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,dilNet);
            aytDilNetTextView.setText(String.valueOf(dilNet));
            DilHamPuanTextView.setText(String.valueOf(aytDilHamPuan));
            double aytDilYerPuan=aytDilYerPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,dilNet,diplomaPuan);
            DilYerPuanTextView.setText(String.valueOf(aytDilYerPuan));
            double aytDilEksikPuan=aytDilEksikPuanHesapla(tytTurkceNet,tytMatematikNet,tytSosyalNet,tytFenNet,dilNet,diplomaPuan);
            DilEksikPuanTextView.setText(String.valueOf(aytDilEksikPuan));

                }
            });

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Lütfen geçerli bir diploma notu giriniz",Toast.LENGTH_LONG).show();
            diplomaNotuEditText.setText("");
        }
        temizleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplomaNotuEditText.setText("0");
                tytTurkceDogru.setText("0");
                tytSosyalDogru.setText("0");
                tytMatematikDogru.setText("0");
                tytFenDogru.setText("0");
                tytTurkceYanlis.setText("0");
                tytMatematikYanlis.setText("0");
                tytSosyalYanlis.setText("0");
                tytFenYanlis.setText("0");
                aytEdebiyatDogru.setText("0");
                aytEdebiyatYanlis.setText("0");
                aytTarihDogru.setText("0");
                aytTarihYanlis.setText("0");
                aytCografyaDogru.setText("0");
                aytCograftaYanlis.setText("0");
                aytTarih2Dogru.setText("0");
                aytTarih2Yanlis.setText("0");
                aytCografya2Dogru.setText("0");
                aytCografya2Yanlis.setText("0");
                aytFelsefeDogru.setText("0");
                aytFelsefeYanlis.setText("0");
                aytFizikDogru.setText("0");
                aytFizikYanlis.setText("0");
                aytKimyaDogru.setText("0");
                aytKimyaYanlis.setText("0");
                aytBiyolojiDogru.setText("0");
                aytBiyolojiYanlis.setText("0");
                aytDinDogru.setText("0");
                aytDinYanlis.setText("0");
                aytDilDogru.setText("0");
                aytDinYanlis.setText("0");
                aytMatematikDogru.setText("0");
                aytMatematikYanlis.setText("0");
                tytTurkceNetTextView.setText("0");
                tytMatematikNetTextView.setText("0");
                tytSosyalNetTextView.setText("0");
                tytFenNetTextView.setText("0");
                aytMatematikNetTextView.setText("0");
                aytEdebiyatNetTextView.setText("0");
                aytTarih1NetTextView.setText("0");
                aytCografya1NetTextView.setText("0");
                aytTarih2NetTextView.setText("0");
                aytCografya2NetTextView.setText("0");
                aytFelsefeNetTextView.setText("0");
                aytDinNetTextView.setText("0");
                aytFizikNetTextView.setText("0");
                aytKimyaNetTextView.setText("0");
                aytBiyolojiNetTextView.setText("0");
                aytDilNetTextView.setText("0");
                tytHamPuanTextView.setText("0");
                tytYerPuanTextView.setText("0");
                tytEksikPuanTextView.setText("0");
                EAHamPuanTextView.setText("0");
                EAEksikPuanTextView.setText("0");
                EAYerPuanTextView.setText("0");
                SayisalHamPuanTextView.setText("0");
                SayisalYerPuanTextView.setText("0");
                SayisalEksikPuanTextView.setText("0");
                SozelHamPuanTextView.setText("0");
                sozelEksikPuanTextView.setText("0");
                SozelYerPuanTextView.setText("0");
                DilHamPuanTextView.setText("0");
                DilYerPuanTextView.setText("0");
                DilEksikPuanTextView.setText("0");


            }
        });



    }
    public double netGetir(String dogruSayisi,String YanlisSayisi,int toplamSoru)
    {
        try {
            int dogru=Integer.parseInt(dogruSayisi);
            int yanlis=Integer.parseInt(YanlisSayisi);
            if(dogru+yanlis>toplamSoru)
            {
                Toast.makeText(getApplicationContext(),"Dogru ve yanlislarin sayisi soru sayisini gecemez",Toast.LENGTH_LONG).show();
                return 0;
            }
            return dogru-(((double)yanlis/4));
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Doğru ve yanlis sayisi tamsayi olmalidir",Toast.LENGTH_LONG).show();
            return 0;
        }


    }
    public double tytHamPuanHesapla(double turkceNet,double sosyalNet,double matematikNet,double fenNet)
    {
        return (100+(turkceNet*3.3)+(sosyalNet*3.4)+(matematikNet*3.3)+(fenNet*3.4));
    }
    public double tytYerlestirmePuanHesapla(double turkceNet,double sosyalNet,double matematikNet,double fenNet,double diploma)
    {
        return (100+(turkceNet*3.3)+(sosyalNet*3.4)+(matematikNet*3.3)+(fenNet*3.4)+(diploma*0.6));
    }
    public double tytEksikPuanHesapla(double turkceNet,double sosyalNet,double matematikNet,double fenNet,double diploma)
    {
        return (100+(turkceNet*3.3)+(sosyalNet*3.4)+(matematikNet*3.3)+(fenNet*3.4)+(diploma*0.3));
    }
    public double aytSayisalHamPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytMat,double aytFizik,double aytKimya,double aytBiyoloji)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytMat*3)+(aytFizik*2.85)+(aytKimya*3.07)+(aytBiyoloji*3.07));
    }
    public double aytSayisalYerPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytMat,double aytFizik,double aytKimya,double aytBiyoloji,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytMat*3)+(aytFizik*2.85)+(aytKimya*3.07)+(aytBiyoloji*3.07)+(diploma*0.6));
    }
    public double aytSayisalEksikPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytMat,double aytFizik,double aytKimya,double aytBiyoloji,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytMat*3)+(aytFizik*2.85)+(aytKimya*3.07)+(aytBiyoloji*3.07)+(diploma*0.3));
    }

    public double aytSozelHamPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytEdeb1,double aytTarih1,double aytCografya1,double aytTarih2,double aytCografya2,double aytFelsefe,double aytDin)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytEdeb1*3)+(aytTarih1*2.8)+(aytCografya1*3.33)+(aytTarih2*2.91)+(aytCografya2*2.91)+(aytFelsefe*3)+(aytDin*3.33));
    }
    public double aytSozelYerPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytEdeb1,double aytTarih1,double aytCografya1,double aytTarih2,double aytCografya2,double aytFelsefe,double aytDin,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytEdeb1*3)+(aytTarih1*2.8)+(aytCografya1*3.33)+(aytTarih2*2.91)+(aytCografya2*2.91)+(aytFelsefe*3)+(aytDin*3.33)+(diploma*0.6));
    }
    public double aytSozelEksikPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytEdeb1,double aytTarih1,double aytCografya1,double aytTarih2,double aytCografya2,double aytFelsefe,double aytDin,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytEdeb1*3)+(aytTarih1*2.8)+(aytCografya1*3.33)+(aytTarih2*2.91)+(aytCografya2*2.91)+(aytFelsefe*3)+(aytDin*3.33)+(diploma*0.3));
    }

    public double aytEsitAgirlikHamPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double matNet,double edeb1Net,double tarih1Net,double cografya1Net)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(matNet*3)+(edeb1Net*3)+(tarih1Net*3)+(cografya1Net*1*33));
    }
    public double aytEsitAgirlikYerPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double matNet,double edeb1Net,double tarih1Net,double cografya1Net,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(matNet*3)+(edeb1Net*3)+(tarih1Net*3)+(cografya1Net*1*33)+(diploma*0.6));
    }
    public double aytEsitAgirlikEksikPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double matNet,double edeb1Net,double tarih1Net,double cografya1Net,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(matNet*3)+(edeb1Net*3)+(tarih1Net*3)+(cografya1Net*1*33)+(diploma*0.3));
    }

    public double aytDilHamPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytDilNet)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytDilNet*3));
    }
    public double aytDilYerPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytDilNet,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytDilNet*3)+(diploma*0.6));
    }
    public double aytDilEksikPuanHesapla(double tytTurkce,double tytMat,double tytSosyal,double tytFen,double aytDilNet,double diploma)
    {
        return (100+(tytTurkce*1.32)+(tytMat*1.32)+(tytSosyal*1.36)+(tytFen*1.36)+(aytDilNet*3)+(diploma*0.3));
    }






    public void tanimla()
{
    diplomaNotuEditText=findViewById(R.id.diplomaNotuEditText);
    tytTurkceDogru=findViewById(R.id.tytTurkceDogruEditText);
    tytTurkceYanlis=findViewById(R.id.tytTurkceYanlisEditText);
    tytTurkceNetTextView=findViewById(R.id.tytTurkceNetTextView);
    tytSosyalDogru=findViewById(R.id.tytSosyalDogruEditText);
    tytSosyalYanlis=findViewById(R.id.tytSosyalYanlisEditText);
    tytSosyalNetTextView=findViewById(R.id.tytSosyalNetTextView);
    tytMatematikDogru=findViewById(R.id.tytMatematikDogruEditText);
    tytMatematikYanlis=findViewById(R.id.tytMatematikYanlisEditText);
    tytMatematikNetTextView=findViewById(R.id.tytMatematikNetTextView);
    tytFenDogru=findViewById(R.id.tytFenDogruEditText);
    tytFenYanlis=findViewById(R.id.tytFenYanlisEditText);
    tytFenNetTextView=findViewById(R.id.tytFenNetTextView);
    aytEdebiyatDogru=findViewById(R.id.aytEdebiyatDogruEditText);
    aytEdebiyatYanlis=findViewById(R.id.aytEdebiyatYanlisEditText);
    aytEdebiyatNetTextView=findViewById(R.id.aytEdebiyatNetTextView);
    aytTarihDogru=findViewById(R.id.aytTarihDogruEditText);
    aytTarihYanlis=findViewById(R.id.aytTarihYanlisEditText);
    aytTarih1NetTextView=findViewById(R.id.aytTarihNetTextView);
    aytCografyaDogru=findViewById(R.id.aytCografyaDogruEditText);
    aytCograftaYanlis=findViewById(R.id.aytCografyaYanlisEditText);
    aytCografya1NetTextView=findViewById(R.id.aytCografyaNetTextView);
    aytTarih2Dogru=findViewById(R.id.aytTarih2DogruEditText);
    aytTarih2Yanlis=findViewById(R.id.aytTarih2YanlisEditText);
    aytTarih2NetTextView=findViewById(R.id.aytTarih2NetTextView);
    aytCografya2Dogru=findViewById(R.id.aytCografya2DogruEditText);
    aytCografya2Yanlis=findViewById(R.id.aytCografya2YanlisEditText);
    aytCografya2NetTextView=findViewById(R.id.aytCografya2NetTextView);
    aytFelsefeDogru=findViewById(R.id.aytFelsefeDogruEditText);
    aytFelsefeYanlis=findViewById(R.id.aytFelsefeYanlisEditText);
    aytFelsefeNetTextView=findViewById(R.id.aytFelsefeNetTextView);
    aytDinDogru=findViewById(R.id.aytDinDogruEditText);
    aytDinYanlis=findViewById(R.id.aytDinYanlisEditText);
    aytDinNetTextView=findViewById(R.id.aytDinNetTextView);
    aytMatematikDogru=findViewById(R.id.aytMatematikDogruEditText);
    aytMatematikYanlis=findViewById(R.id.aytMatematikYanlisEditText);
    aytMatematikNetTextView=findViewById(R.id.aytMatematikNetTextView);
    aytFizikDogru=findViewById(R.id.aytFizikDogruEditText);
    aytFizikYanlis=findViewById(R.id.aytFizikYanlisEditText);
    aytFizikNetTextView=findViewById(R.id.aytFizikNetTextView);
    aytKimyaDogru=findViewById(R.id.aytKimyaDogruEditText);
    aytKimyaYanlis=findViewById(R.id.aytKimyaYanlisEditText);
    aytKimyaNetTextView=findViewById(R.id.aytKimyaNetTextView);
    aytBiyolojiDogru=findViewById(R.id.aytBiyolojiDogruEditText);
    aytBiyolojiYanlis=findViewById(R.id.aytBiyolojiYanlisEditText);
    aytBiyolojiNetTextView=findViewById(R.id.aytBiyolojiNetTextView);
    aytDilDogru=findViewById(R.id.aytDilDogruEditText);
    aytDilYanlis=findViewById(R.id.aytDilYanlisEditText);
    aytDilNetTextView=findViewById(R.id.aytDilNetTextView);
    HesaplaBtn=findViewById(R.id.HesaplaButton);
    temizleBtn=findViewById(R.id.TemizleButton);
    tytHamPuanTextView=findViewById(R.id.tytHamPuanTextView);
    tytYerPuanTextView=findViewById(R.id.tytYerlestirmePuan);
    tytEksikPuanTextView=findViewById(R.id.tytEksikPuan);
    EAHamPuanTextView=findViewById(R.id.aytEAHamPuanTextView);
    EAYerPuanTextView=findViewById(R.id.aytEaYerPuan);
    EAEksikPuanTextView=findViewById(R.id.aytEAEksikPuan);
    SozelHamPuanTextView=findViewById(R.id.aytSozelHamPuanTextView);
    sozelEksikPuanTextView=findViewById(R.id.aytSozelEksikPuan);
    SozelYerPuanTextView=findViewById(R.id.aytSozelYerPuan);
    SayisalHamPuanTextView=findViewById(R.id.aytSayisalHamPuanTextView);
    SayisalYerPuanTextView=findViewById(R.id.aytSayisalYerPuan);
    SayisalEksikPuanTextView=findViewById(R.id.aytSayisalEksikPuan);
    DilHamPuanTextView=findViewById(R.id.aytDilHamPuan);
    DilYerPuanTextView=findViewById(R.id.aytDilYerPuan);
    DilEksikPuanTextView=findViewById(R.id.aytDilEksikPuan);



}

public boolean diplomaNotuKontrol(String diplomaNotu)
{

    try {
        diplomaPuan=Double.parseDouble(diplomaNotu);
        if(diplomaPuan>100)
        {
            Toast.makeText(getApplicationContext(),"Diploma notu 100 den büyük olamaz",Toast.LENGTH_LONG).show();
            diplomaNotuEditText.setText("");
            return false;
        }
        if(diplomaPuan<0)
        {
            Toast.makeText(getApplicationContext(),"Diploma notu 0 dan küçük olamaz",Toast.LENGTH_LONG).show();
            diplomaNotuEditText.setText("");
            return false;
        }
        else {
            return true;
        }

    }
    catch (Exception e)
    {
        diplomaPuan=0;
        Toast.makeText(getApplicationContext(),"Lütfen diploma notunu dğru giriniz.",Toast.LENGTH_LONG).show();
        diplomaNotuEditText.setText("");
        return false;
    }

}




}
