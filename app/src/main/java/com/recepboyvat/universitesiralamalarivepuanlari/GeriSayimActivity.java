package com.recepboyvat.universitesiralamalarivepuanlari;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GeriSayimActivity extends AppCompatActivity {
    public TextView tytGun,tytSaat,tytDakika,aytGun,aytSaat,aytDakika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geri_sayim);
        initialize();
        System.out.println(aniGetir());
        long tyt=tytHesapla();
        long ayt=aytHesapla();
        String[] tytarray=calculateTime(tyt);
        String[] aytarray=calculateTime(ayt);
        tytGun.setText(tytarray[0]);
        tytSaat.setText(tytarray[1]);
        tytDakika.setText(tytarray[2]);
        aytGun.setText(aytarray[0]);
        aytSaat.setText(aytarray[1]);
        aytDakika.setText(aytarray[2]);



    }

    public void initialize()
    {
        tytGun=findViewById(R.id.tytGunTextView);
        tytSaat=findViewById(R.id.tytSaatTextView);
        tytDakika=findViewById(R.id.tytDakikaTextView);
        aytGun=findViewById(R.id.aytGunTextView);
        aytSaat=findViewById(R.id.aytSaatTextView);
        aytDakika=findViewById(R.id.aytDakikaTextView);

    }
    public String aniGetir()
    {
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat Tarih=new SimpleDateFormat("yyy-MM-dd HH:mm");
        return Tarih.format(calendar.getTime());

    }
    public long tytHesapla()
    {
        String simdi=aniGetir();
        DateFormat formatter=new SimpleDateFormat("yyy-MM-dd HH:mm");
        Date bitis=new Date();
        try {
            bitis=formatter.parse("2020-06-27 10:15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date suan=new Date();
        try {
            suan=formatter.parse(simdi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long fark=((bitis.getTime()-suan.getTime()))/1000;

        System.out.println(fark);
        return fark;
    }

    public static String[] calculateTime(long seconds) {
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) -
                TimeUnit.DAYS.toHours(day);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) -
                TimeUnit.DAYS.toMinutes(day) -
                TimeUnit.HOURS.toMinutes(hours);
        String[] array={Integer.toString(day),Long.toString(hours),Long.toString(minute)};
        return array;

    }

    public long aytHesapla()
    {
        String simdi=aniGetir();
        DateFormat formatter=new SimpleDateFormat("yyy-MM-dd HH:mm");
        Date bitis=new Date();
        try {
            bitis=formatter.parse("2020-06-28 10:15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date suan=new Date();
        try {
            suan=formatter.parse(simdi);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long fark=((bitis.getTime()-suan.getTime()))/1000;

        System.out.println(fark);
        return fark;
    }

}
