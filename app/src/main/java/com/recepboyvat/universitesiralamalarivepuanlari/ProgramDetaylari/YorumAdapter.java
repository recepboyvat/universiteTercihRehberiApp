package com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.Yorum;

import java.util.List;

public class YorumAdapter extends BaseAdapter {
    private LayoutInflater yorumInflater;
    private List<Yorum> yorumList;

    public YorumAdapter(Activity activity,List<Yorum> yorumListesi)
    {
        yorumInflater=(LayoutInflater)activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        this.yorumList=yorumListesi;
    }


    @Override
    public int getCount() {
        return yorumList.size();
    }

    @Override
    public Object getItem(int position) {
        return yorumList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView;
        lineView=yorumInflater.inflate(R.layout.yorum_row,null);
        TextView textViewUserName=(TextView)lineView.findViewById(R.id.yorumKullaniciAdi);
        TextView textViewYorum=(TextView)lineView.findViewById(R.id.yorumMetin);
        ImageView imageViewUserPicture=(ImageView)lineView.findViewById(R.id.yorumResimImageView);

        Yorum yorum=yorumList.get(position);
        textViewUserName.setText(yorum.getUserName());
        textViewYorum.setText(yorum.getMesaj());





        if(yorum.getGender()==1)
        {
            imageViewUserPicture.setImageResource(R.drawable.young);
        }
        else if(yorum.getGender()==2)
        {
            imageViewUserPicture.setImageResource(R.drawable.woman);
        }
        else{
            imageViewUserPicture.setImageResource(R.drawable.bigender);
        }

        return lineView;
    }
}
