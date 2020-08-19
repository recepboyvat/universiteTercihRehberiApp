package com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari;

import android.content.Context;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.recepboyvat.universitesiralamalarivepuanlari.MainActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.Program;
import com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari.ui.main.PageViewModel;
import com.recepboyvat.universitesiralamalarivepuanlari.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProgramDetayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProgramDetayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgramDetayFragment extends Fragment {
    TextView universiteAdiTextView,bolumAdiTextView,programAdiTextView,puanTuruTextView,universiteTuruTextView,bursTuruTextView,genelKontenjanTextView,okulBirincisiKontenjaniTextView,toplamKontenjanTextView,
            ilkYerlesmeOraniTextView,tabanpuandokuzTextView,tabanpuansekizTextView,tabanpuanyediTextView,tavanpuandokuzTextView,tavanpuansekizTextView,tavanpuanyediTextView,tabansiralamadokuzTextView,
    tabansiralamasekizTextView,tabansiralamayediTextView,tavansiralamadokuzTextView,tavansiralamasekizTextView,tavansiralamayediTextView,profesorsayisiTextView,docentsayisiTextView,doktorsayisiTextView;
    ImageView universityImageView;
    Button favoriEkleBtn;
    int programKodu;
    int lisansOrOnlisans;
    String previousActivity;
    Program program;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    PageViewModel pageViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProgramDetayFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
  /*  public static ProgramDetayFragment newInstance(String param1, String param2) {
        ProgramDetayFragment fragment = new ProgramDetayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
  public static ProgramDetayFragment newInstance()
  {
      return new ProgramDetayFragment();
  }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel= ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
     //   Intent intent=getActivity().getIntent();
     //   int programKodu=intent.getIntExtra("programKodu",0);
     //   programiGetir(programKodu);


    }
    public void programiGetir(int programKodu)
    {
        for(int i=0;i< MainActivity.programlar.size();i++)
        {
            if(MainActivity.programlar.get(i).getProgramKodu()==programKodu)
            {

                String universiteAdi= MainActivity.programlar.get(i).getUniversiteAdi();
                universiteAdiTextView.setText("");
                universiteAdiTextView.setText(universiteAdi);
                String bolumAdi=MainActivity.programlar.get(i).getBolumAdi();
                bolumAdiTextView.setText("");
                bolumAdiTextView.setText(bolumAdi);
                String programAdi=MainActivity.programlar.get(i).getProgramAdi();
                programAdiTextView.setText("");
                programAdiTextView.setText(programAdi);
                lisansOrOnlisans=MainActivity.programlar.get(i).getLisansOrOnlisans();
                int puanTuru;
                if(lisansOrOnlisans==1) {

                    puanTuru = MainActivity.programlar.get(i).getPuanTuru();
                    String sonPuanTuru = "---";
                    if (puanTuru == 1) {
                        sonPuanTuru = "SAY";
                    } else if (puanTuru == 2) {
                        sonPuanTuru = "EA";
                    } else if (puanTuru == 3) {
                        sonPuanTuru = "SÖZ";
                    } else if (puanTuru == 4) {
                        sonPuanTuru = "DİL";
                    } else {
                        sonPuanTuru = "---";
                    }
                    puanTuruTextView.setText("");
                    puanTuruTextView.setText(sonPuanTuru);
                }else {
                    puanTuru=MainActivity.programlar.get(i).getPuanTuru();
                    puanTuruTextView.setText("");
                    puanTuruTextView.setText("TYT");
                }

                int universiteTuru=MainActivity.programlar.get(i).getDevletOrOzel();
                String sonUniversiteTuru="---";
                if(universiteTuru==1)
                {
                    sonUniversiteTuru="Devlet";
                }
                else if(universiteTuru==2)
                {
                    sonUniversiteTuru="Vakıf";
                }
                else if(universiteTuru==3)
                {
                    sonUniversiteTuru="Özel";
                }
                else if(universiteTuru==4)
                {
                    sonUniversiteTuru="Kktc";
                }
                else if(universiteTuru==5)
                {
                    sonUniversiteTuru="Yabancı";
                }
                else if(universiteTuru==6)
                {
                    sonUniversiteTuru="Diğer";
                }
                else
                {
                    sonUniversiteTuru="---";
                }
                universiteTuruTextView.setText("");
                universiteTuruTextView.setText(sonUniversiteTuru);

                int bursTuru=MainActivity.programlar.get(i).getBursTuru();
                String sonBursTuru;

                if(bursTuru==1)
                {
                    sonBursTuru="Ücretsiz";
                }
                else if(bursTuru==2)
                {
                    sonBursTuru="Devlet-İÖ";
                }
                else if(bursTuru==3)
                {
                    sonBursTuru="%75 İndirimli";
                }
                else if(bursTuru==4)
                {
                    sonBursTuru="%50 İndirimli";
                }
                else if(bursTuru==5)
                {
                    sonBursTuru="%25 İndirimli";
                }
                else if(bursTuru==6)
                {
                    sonBursTuru="Tam Burslu";
                }
                else if(bursTuru==7)
                {
                    sonBursTuru="İÖ-Ücretli/Özel";
                }
                else if(bursTuru==8)
                {
                    sonBursTuru="Ücretli";
                }
                else if(bursTuru==9)
                {
                    sonBursTuru="UE-Ücretli";
                }
                else{
                    sonBursTuru="Diğer";
                }
                bursTuruTextView.setText("");
                bursTuruTextView.setText(sonBursTuru);


                int genelKontenjan=MainActivity.programlar.get(i).getGenelKontenjan();
                genelKontenjanTextView.setText("");
                genelKontenjanTextView.setText(Integer.toString(genelKontenjan));
                String okulBirincisiKontenjani=MainActivity.programlar.get(i).getOkulBirincisiKontenjani();
                okulBirincisiKontenjaniTextView.setText("");
                okulBirincisiKontenjaniTextView.setText(okulBirincisiKontenjani);
                int toplamKontenjan=MainActivity.programlar.get(i).getToplamKontenjan();
                toplamKontenjanTextView.setText("");
                toplamKontenjanTextView.setText(Integer.toString(toplamKontenjan));
                String ilkYerlesmeOrani=MainActivity.programlar.get(i).getIlkYerlesmeOrani();
                ilkYerlesmeOraniTextView.setText("");
                ilkYerlesmeOraniTextView.setText(ilkYerlesmeOrani);

                double ondokuztabanpuan=MainActivity.programlar.get(i).getTabanPuandokuz();
                tabanpuandokuzTextView.setText("");
                if(ondokuztabanpuan==0)
                {
                    tabanpuandokuzTextView.setText("Dolmadı");
                }
                else{
                    tabanpuandokuzTextView.setText(Double.toString(ondokuztabanpuan));
                }

                double onsekiztabanpuan=MainActivity.programlar.get(i).getTabanPuansekiz();
                tabanpuansekizTextView.setText("");
                if(onsekiztabanpuan==0)
                {
                    tabanpuansekizTextView.setText("---");
                }
                else{
                    tabanpuansekizTextView.setText(Double.toString(onsekiztabanpuan));
                }


                double onyeditabanpuan=MainActivity.programlar.get(i).getTabanPuanyedi();
                tabanpuanyediTextView.setText("");
                if(onyeditabanpuan==0)
                {
                    tabanpuanyediTextView.setText("---");
                }
                else
                {
                    tabanpuanyediTextView.setText(Double.toString(onyeditabanpuan));
                }

                double ondokuztavanpuan=MainActivity.programlar.get(i).getTavanPuandokuz();
                tavanpuandokuzTextView.setText("");
                if(ondokuztavanpuan==0)
                {
                    tavanpuandokuzTextView.setText("---");
                }
                else {
                    tavanpuandokuzTextView.setText(Double.toString(ondokuztavanpuan));
                }

                double onsekiztavanpuan=MainActivity.programlar.get(i).getTavanPuansekiz();
                tavanpuansekizTextView.setText("");
                if(onsekiztavanpuan==0)
                {
                    tavanpuansekizTextView.setText("---");
                }
                else {
                    tavanpuansekizTextView.setText(Double.toString(onsekiztavanpuan));
                }

                double onyeditavanpuan=MainActivity.programlar.get(i).getTavanPuanyedi();
                tavanpuanyediTextView.setText("");
                if(onyeditavanpuan==0)
                {
                    tavanpuanyediTextView.setText("---");
                }
                else {
                    tavanpuanyediTextView.setText(Double.toString(onyeditavanpuan));
                }


                int ondokuztabansiralama=MainActivity.programlar.get(i).getTabanSiralamadokuz();
                tabansiralamadokuzTextView.setText("");
                if(ondokuztabansiralama==0)
                {
                    tabansiralamadokuzTextView.setText("Dolmadı");
                }
                else{
                    tabansiralamadokuzTextView.setText(Integer.toString(ondokuztabansiralama));
                }


                int onsekiztabansiralama=MainActivity.programlar.get(i).getTabanSiralamasekiz();
                tabansiralamasekizTextView.setText("");
                if(onsekiztabansiralama==0)
                {
                    tabansiralamasekizTextView.setText("---");
                }
                else{
                    tabansiralamasekizTextView.setText(Integer.toString(onsekiztabansiralama));
                }

                int onyeditabansiralama=MainActivity.programlar.get(i).getTabanSiralamayedi();
                tabansiralamayediTextView.setText("");
                if(onyeditabansiralama==0)
                {
                    tabansiralamayediTextView.setText("---");
                }
                else{
                    tabansiralamayediTextView.setText(Integer.toString(onyeditabansiralama));
                }

                int ondokuztavansiralama=MainActivity.programlar.get(i).getTavanSiralamadokuz();
                tavansiralamadokuzTextView.setText("");
                tavansiralamadokuzTextView.setText(Integer.toString(ondokuztavansiralama));
                int onsekiztavansiralama=MainActivity.programlar.get(i).getTavanSiralamasekiz();
                tavansiralamasekizTextView.setText("");
                tavansiralamasekizTextView.setText(Integer.toString(onsekiztavansiralama));
                int onyeditavansiralama=MainActivity.programlar.get(i).getTavanSiralamayedi();
                tavansiralamayediTextView.setText("");
                tavansiralamayediTextView.setText(Integer.toString(onyeditavansiralama));

                String profesorSayisi=MainActivity.programlar.get(i).getProfSayisi();
                profesorsayisiTextView.setText("");
                profesorsayisiTextView.setText(profesorSayisi);
                String docentSayisi=MainActivity.programlar.get(i).getDocantSayisi();
                docentsayisiTextView.setText("");
                docentsayisiTextView.setText(docentSayisi);
                String doktorSayisi=MainActivity.programlar.get(i).getDoktorSayisi();
                doktorsayisiTextView.setText("");
                doktorsayisiTextView.setText(doktorSayisi);

                universityImageView.setImageResource(R.drawable.ic_school_black_24dp);

                double okulBirincisiTabanPuan=MainActivity.programlar.get(i).getOkulBirincisiTabanPuani();
                int okulBirincisiTabanSiralama=MainActivity.programlar.get(i).getOkulBirincisiTabanSiralama();

                program=new Program(programKodu,bolumAdi,bursTuru,universiteTuru,docentSayisi,doktorSayisi,genelKontenjan,ilkYerlesmeOrani,okulBirincisiKontenjani,okulBirincisiTabanPuan,okulBirincisiTabanSiralama,profesorSayisi,programAdi,puanTuru,ondokuztabanpuan,onsekiztabanpuan,onyeditabanpuan,ondokuztabansiralama,onsekiztabansiralama,onyeditabansiralama,ondokuztavanpuan,onsekiztavanpuan,onyeditavanpuan,ondokuztavansiralama,onsekiztavansiralama,onyeditavansiralama,toplamKontenjan,universiteAdi,lisansOrOnlisans);


            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program_detay, container, false);


    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

      super.onViewCreated(view, savedInstanceState);

      universiteAdiTextView=view.findViewById(R.id.universiteAdi);
      bolumAdiTextView=view.findViewById(R.id.bolumAdi);
      programAdiTextView=view.findViewById(R.id.programAdi);
      puanTuruTextView=view.findViewById(R.id.puanTuru);
      universiteTuruTextView=view.findViewById(R.id.universiteTuru);
      bursTuruTextView=view.findViewById(R.id.bursTuru);
      genelKontenjanTextView=view.findViewById(R.id.genelKontenjan);
      okulBirincisiKontenjaniTextView=view.findViewById(R.id.okulBirincisiKontenjani);
      toplamKontenjanTextView=view.findViewById(R.id.toplamKontenjan);
      ilkYerlesmeOraniTextView=view.findViewById(R.id.ilkYerlesmeOrani);
      tabanpuandokuzTextView=view.findViewById(R.id.tabanpuandokuz);
      tabanpuansekizTextView=view.findViewById(R.id.tabanpuansekiz);
      tabanpuanyediTextView=view.findViewById(R.id.tabanpuanyedi);
      tavanpuandokuzTextView=view.findViewById(R.id.tavanpuandokuz);
      tavanpuansekizTextView=view.findViewById(R.id.tavanpuansekiz);
      tavanpuanyediTextView=view.findViewById(R.id.tavanpuanyedi);
      tabansiralamadokuzTextView=view.findViewById(R.id.tabansiralamadokuz);
      tabansiralamasekizTextView=view.findViewById(R.id.tabansiralamasekiz);
      tabansiralamayediTextView=view.findViewById(R.id.tabansiralamayedi);
      tavansiralamadokuzTextView=view.findViewById(R.id.tavansiralamadokuz);
      tavansiralamasekizTextView=view.findViewById(R.id.tavansiralamasekiz);
      tavansiralamayediTextView=view.findViewById(R.id.tavansiralamayedi);
      profesorsayisiTextView=view.findViewById(R.id.profesorsayisi);
      docentsayisiTextView=view.findViewById(R.id.docentsayisi);
      doktorsayisiTextView=view.findViewById(R.id.doktorsayisi);
      universityImageView=view.findViewById(R.id.universityImageView);
      favoriEkleBtn=view.findViewById(R.id.favoriBtn);
      Intent intent=getActivity().getIntent();
      programKodu=intent.getIntExtra("programKodu",0);
      previousActivity=intent.getStringExtra("FROM_ACTIVITY");
      programiGetir(programKodu);
      if(previousActivity!=null) {
          if (previousActivity.equals("Favoriler")) {
              favoriEkleBtn.setText("");
              favoriEkleBtn.setText("Favorilerden Cikar");
              favoriEkleBtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      favorilerDenCikar();

                  }
              });
          } else {
              favoriEkleBtn.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      favorilereEkle();

                  }
              });
          }
      }







  }
  public void favorilereEkle()
  {
      try {
          SQLiteDatabase sqLiteDatabase=getActivity().openOrCreateDatabase("FavoriProgramlarDatabase2",Context.MODE_PRIVATE,null);
          sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS favoriProgramKodlari(programKodu INT PRIMARY KEY,programAdi VARCHAR,bolumAdi VARCHAR,devletOrOzel INT,puanTuru INT,bursTuru INT,genelKontenjan INT,okulBirincisiKontenjani VARCHAR,toplamKontenjan INT,ilkYerlesmeOrani VARCHAR,universiteAdi VARCHAR,lisansOrOnlisans INT,profSayisi VARCHAR,docentSayisi VARCHAR,doktorSayisi VARCHAR,tabanPuandokuz REAL,tabanSiralamadokuz INT,tavanPuandokuz REAL,tavanSiralamadokuz INT,tabanPuansekiz REAL,tabanSiralamasekiz INT,tavanPuansekiz REAL,tavanSiralamasekiz INT,tabanPuanyedi REAL,tabanSiralamayedi INT,tavanPuanyedi REAL,tavanSiralamayedi INT,okulBirincisiTabanPuan REAL,okulBirincisiTabanSiralama INT)");
          String degerler=program.getProgramKodu()+",'"+program.getProgramAdi()+"','"+program.getBolumAdi()+"',"+program.getDevletOrOzel()+","+program.getPuanTuru()+","+program.getBursTuru()+","+program.getGenelKontenjan()+",'"+program.getOkulBirincisiKontenjani()+"',"+program.getToplamKontenjan()+",'"+program.getIlkYerlesmeOrani()+"','"+program.getUniversiteAdi()+"',"+program.getLisansOrOnlisans()+",'"+program.getProfSayisi()+"','"+program.getDocantSayisi()+"','"+program.getDoktorSayisi()+"',"+program.getTabanPuandokuz()+","+program.getTabanSiralamadokuz()+","+program.getTavanPuandokuz()+","+program.getTavanSiralamadokuz()+","+program.getTabanPuansekiz()+","+program.getTabanSiralamasekiz()+","+program.getTavanPuansekiz()+","+program.getTavanSiralamasekiz()+","+program.getTabanPuanyedi()+"," +program.getTabanSiralamayedi()+","+program.getTavanPuanyedi()+","+program.getTavanSiralamayedi()+","+program.getOkulBirincisiTabanPuani()+","+program.getOkulBirincisiTabanSiralama()+")";

          String sorgu="INSERT INTO favoriProgramKodlari(programKodu,programAdi,bolumAdi,devletOrOzel,puanTuru,bursTuru,genelKontenjan,okulBirincisiKontenjani,toplamKontenjan,ilkYerlesmeOrani,universiteAdi,lisansOrOnlisans,profSayisi,docentSayisi,doktorSayisi ,tabanPuandokuz,tabanSiralamadokuz,tavanPuandokuz,tavanSiralamadokuz,tabanPuansekiz,tabanSiralamasekiz,tavanPuansekiz,tavanSiralamasekiz,tabanPuanyedi,tabanSiralamayedi,tavanPuanyedi,tavanSiralamayedi,okulBirincisiTabanPuan,okulBirincisiTabanSiralama) VALUES("+degerler;
          sqLiteDatabase.execSQL(sorgu);
          Toast.makeText(getContext(),"Favorilere Eklendi",Toast.LENGTH_LONG).show();

      }
      catch (Exception e)
      {
          Toast.makeText(getContext(),"Kaydetme esnasında hata oluştu",Toast.LENGTH_LONG).show();
          e.printStackTrace();
      }
  }
  public void favorilerDenCikar()
  {
      try{
          SQLiteDatabase sqLiteDatabase=getActivity().openOrCreateDatabase("FavoriProgramlarDatabase2",Context.MODE_PRIVATE,null);
          String silmeSorgusu="DELETE FROM favoriProgramKodlari WHERE programKodu ="+String.valueOf(programKodu);
          sqLiteDatabase.execSQL(silmeSorgusu);
          Toast.makeText(getContext(),"Favorilerden Cikarildi",Toast.LENGTH_LONG).show();


      }
      catch (Exception e)
      {
          Toast.makeText(getContext(),"Favorilerden cikarirken hata olustu",Toast.LENGTH_LONG).show();
      }

  }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
   /*     if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
