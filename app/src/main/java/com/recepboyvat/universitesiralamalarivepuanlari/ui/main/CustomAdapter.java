package com.recepboyvat.universitesiralamalarivepuanlari.ui.main;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.Universite;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater universiteInflater;
    private List<Universite> universiteListesi;

    public CustomAdapter(Activity activity,List<Universite> universiteler)
    {
        universiteInflater=(LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.universiteListesi=universiteler;

    }

    @Override
    public int getCount() {
        return universiteListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return universiteListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView;
        lineView=universiteInflater.inflate(R.layout.university_custom_layout,null);
        Universite universite=universiteListesi.get(position);
        TextView textViewUniversiteAdi=(TextView)lineView.findViewById(R.id.universityNameTextView);
        ImageView imageViewUniversite=(ImageView)lineView.findViewById(R.id.imageViewUniversity);
        textViewUniversiteAdi.setText(universite.getUniversiteAdi());
        imageViewUniversite.setImageResource(R.drawable.ic_account_balance_purple_24dp);
        return lineView;
    }
}
