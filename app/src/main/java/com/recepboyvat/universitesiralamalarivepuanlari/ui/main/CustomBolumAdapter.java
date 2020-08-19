package com.recepboyvat.universitesiralamalarivepuanlari.ui.main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.recepboyvat.universitesiralamalarivepuanlari.Bolum;
import com.recepboyvat.universitesiralamalarivepuanlari.R;


import java.util.List;

public class CustomBolumAdapter extends BaseAdapter {
    private LayoutInflater bolumInflater;
    private List<Bolum> bolumListesi;

    public CustomBolumAdapter(Activity activity, List<Bolum> bolumler)
    {
        bolumInflater=(LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.bolumListesi=bolumler;

    }
    @Override
    public int getCount() {
        return bolumListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return bolumListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView;
        lineView=bolumInflater.inflate(R.layout.university_custom_layout,null);
        Bolum bolum=bolumListesi.get(position);
        TextView textViewBolumAdi=(TextView)lineView.findViewById(R.id.universityNameTextView);
        ImageView imageViewBolum=(ImageView)lineView.findViewById(R.id.imageViewUniversity);
        textViewBolumAdi.setText(bolum.getBolumAdi());
        imageViewBolum.setImageResource(R.drawable.ic_account_balance_purple_24dp);
        return lineView;
    }

}
