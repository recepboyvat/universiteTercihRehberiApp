package com.recepboyvat.universitesiralamalarivepuanlari.ui.main;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.recepboyvat.universitesiralamalarivepuanlari.Program;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

import java.util.List;

public class CustomUniversiteProgramAdapter extends BaseAdapter{

    private LayoutInflater universiteProgramInflater;
    private List<Program> universiteProgramListesi; //exampleList

    public CustomUniversiteProgramAdapter(Activity activity, List<Program> programlar)
    {
        universiteProgramInflater=(LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.universiteProgramListesi=programlar;


    }



    @Override
    public int getCount() {
        return universiteProgramListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return universiteProgramListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      View lineView;
      lineView=universiteProgramInflater.inflate(R.layout.custom_universite_program_layout,null);
      Program program=universiteProgramListesi.get(position);
      ImageView imageView=lineView.findViewById(R.id.imageViewUniversityProgram);
      TextView textViewUniversiteAdi=lineView.findViewById(R.id.universityProgramUniAdiTextView);
      TextView textViewProgramAdi=lineView.findViewById(R.id.universityProgramProgramAdiTextView);
      TextView textViewbasariSiralama=lineView.findViewById(R.id.basariSiralama);
      TextView textViewgercekBasariSiralama=lineView.findViewById(R.id.universityProgramBasariSiralama);
      TextView textViewTabanPuan=lineView.findViewById(R.id.tabanPuan);
      TextView textViewGercekTabanPuan=lineView.findViewById(R.id.universityProgramTabanPuan);
      textViewUniversiteAdi.setText(program.getUniversiteAdi());
      textViewProgramAdi.setText(program.getProgramAdi());
      if(program.getTabanSiralamadokuz()==0)
      {
          textViewgercekBasariSiralama.setText("Dolmadı");
      }
      else {
          textViewgercekBasariSiralama.setText(Integer.toString(program.getTabanSiralamadokuz()));
      }
      if(program.getTabanPuandokuz()==0.0d)
      {
          textViewGercekTabanPuan.setText("Dolmadı");
      }
      else
      {
          textViewGercekTabanPuan.setText(Double.toString(program.getTabanPuandokuz()));
      }


      imageView.setImageResource(R.drawable.ic_account_balance_purple_24dp);
      return lineView;
    }


}
