package com.recepboyvat.universitesiralamalarivepuanlari.Onlisans;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.Universite;
import com.recepboyvat.universitesiralamalarivepuanlari.UniversiteProgramlarActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.CustomAdapter;
import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.PageViewModel;

import java.util.ArrayList;
import java.util.List;


public class OnlisanUniversiteFragment extends Fragment {
    String universiteAdlari[]={"ADIYAMAN ÜNİVERSİTESİ ","AFYON KOCATEPE ÜNİVERSİTESİ ","AFYONKARAHİSAR SAĞLIK BİLİMLERİ ÜNİVERSİTESİ ","AĞRI İBRAHİM ÇEÇEN ÜNİVERSİTESİ   ","AKDENİZ ÜNİVERSİTESİ ","AKSARAY ÜNİVERSİTESİ ","ALANYA ALAADDİN KEYKUBAT ÜNİVERSİTESİ ","AMASYA ÜNİVERSİTESİ ","ANADOLU ÜNİVERSİTESİ ","ANKARA HACI BAYRAM VELİ ÜNİVERSİTESİ ","ANKARA ÜNİVERSİTESİ ","ANKARA YILDIRIM BEYAZIT ÜNİVERSİTESİ ","ARDAHAN ÜNİVERSİTESİ ","ARTVİN ÇORUH ÜNİVERSİTESİ ","ATATÜRK ÜNİVERSİTESİ ","AYDIN ADNAN MENDERES ÜNİVERSİTESİ ","BALIKESİR ÜNİVERSİTESİ ","BANDIRMA ONYEDİ EYLÜL ÜNİVERSİTESİ ","BARTIN ÜNİVERSİTESİ ","BATMAN ÜNİVERSİTESİ ","BAYBURT ÜNİVERSİTESİ ","BİLECİK ŞEYH EDEBALİ ÜNİVERSİTESİ ","BİNGÖL ÜNİVERSİTESİ ","BİTLİS EREN ÜNİVERSİTESİ ","BOLU ABANT İZZET BAYSAL ÜNİVERSİTESİ ","BURDUR MEHMET AKİF ERSOY ÜNİVERSİTESİ ","BURSA ULUDAĞ ÜNİVERSİTESİ ","ÇANAKKALE ONSEKİZ MART ÜNİVERSİTESİ ","ÇANKIRI KARATEKİN ÜNİVERSİTESİ ","ÇUKUROVA ÜNİVERSİTESİ ","DİCLE ÜNİVERSİTESİ ","DOKUZ EYLÜL ÜNİVERSİTESİ ","DÜZCE ÜNİVERSİTESİ  ","EGE ÜNİVERSİTESİ ","ERCİYES ÜNİVERSİTESİ ","ERZİNCAN BİNALİ YILDIRIM ÜNİVERSİTESİ ","ESKİŞEHİR OSMANGAZİ ÜNİVERSİTESİ ","ESKİŞEHİR TEKNİK ÜNİVERSİTESİ ","FIRAT ÜNİVERSİTESİ ","GALATASARAY ÜNİVERSİTESİ ","GAZİ ÜNİVERSİTESİ ","GAZİANTEP ÜNİVERSİTESİ ","GİRESUN ÜNİVERSİTESİ ","GÜMÜŞHANE ÜNİVERSİTESİ ","HACETTEPE ÜNİVERSİTESİ ","HAKKARİ ÜNİVERSİTESİ ","HARRAN ÜNİVERSİTESİ ","HATAY MUSTAFA KEMAL ÜNİVERSİTESİ ","HİTİT ÜNİVERSİTESİ ","IĞDIR ÜNİVERSİTESİ ","ISPARTA UYGULAMALI BİLİMLER ÜNİVERSİTESİ ","İNÖNÜ ÜNİVERSİTESİ ","İSKENDERUN TEKNİK ÜNİVERSİTESİ ","İSTANBUL ÜNİVERSİTESİ  ","İSTANBUL ÜNİVERSİTESİ-CERRAHPAŞA ","İZMİR BAKIRÇAY ÜNİVERSİTESİ ","İZMİR DEMOKRASİ ÜNİVERSİTESİ ","İZMİR KATİP ÇELEBİ ÜNİVERSİTESİ  ","KAFKAS ÜNİVERSİTESİ ","KAHRAMANMARAŞ İSTİKLAL ÜNİVERSİTESİ ","KAHRAMANMARAŞ SÜTÇÜ İMAM ÜNİVERSİTESİ ","KARABÜK ÜNİVERSİTESİ ","KARADENİZ TEKNİK ÜNİVERSİTESİ ","KARAMANOĞLU MEHMETBEY ÜNİVERSİTESİ ","KASTAMONU ÜNİVERSİTESİ ","KAYSERİ ÜNİVERSİTESİ ","KIRIKKALE ÜNİVERSİTESİ ","KIRKLARELİ ÜNİVERSİTESİ ","KIRŞEHİR AHİ EVRAN ÜNİVERSİTESİ ","KİLİS 7 ARALIK ÜNİVERSİTESİ ","KOCAELİ ÜNİVERSİTESİ ","KONYA TEKNİK ÜNİVERSİTESİ ","KÜTAHYA DUMLUPINAR ÜNİVERSİTESİ ","KÜTAHYA SAĞLIK BİLİMLERİ ÜNİVERSİTESİ ","MALATYA TURGUT ÖZAL ÜNİVERSİTESİ ","MANİSA CELÂL BAYAR ÜNİVERSİTESİ ","MARDİN ARTUKLU ÜNİVERSİTESİ ","MARMARA ÜNİVERSİTESİ ","MERSİN ÜNİVERSİTESİ  ","MİMAR SİNAN GÜZEL SANATLAR ÜNİVERSİTESİ ","MUĞLA SITKI KOÇMAN ÜNİVERSİTESİ ","MUNZUR ÜNİVERSİTESİ ","MUŞ ALPARSLAN ÜNİVERSİTESİ ","NECMETTİN ERBAKAN ÜNİVERSİTESİ ","NEVŞEHİR HACI BEKTAŞ VELİ ÜNİVERSİTESİ ","NİĞDE ÖMER HALİSDEMİR ÜNİVERSİTESİ  ","ONDOKUZ MAYIS ÜNİVERSİTESİ ","ORDU ÜNİVERSİTESİ ","ORTA DOĞU TEKNİK ÜNİVERSİTESİ  ","OSMANİYE KORKUT ATA ÜNİVERSİTESİ ","PAMUKKALE ÜNİVERSİTESİ ","RECEP TAYYİP ERDOĞAN ÜNİVERSİTESİ ","SAĞLIK BİLİMLERİ ÜNİVERSİTESİ ","SAKARYA UYGULAMALI BİLİMLER ÜNİVERSİTESİ ","SAKARYA ÜNİVERSİTESİ  ","SAMSUN ÜNİVERSİTESİ ","SELÇUK ÜNİVERSİTESİ ","SİİRT ÜNİVERSİTESİ ","SİNOP ÜNİVERSİTESİ ","SİVAS CUMHURİYET ÜNİVERSİTESİ ","SÜLEYMAN DEMİREL ÜNİVERSİTESİ ","ŞIRNAK ÜNİVERSİTESİ ","TARSUS ÜNİVERSİTESİ ","TEKİRDAĞ NAMIK KEMAL ÜNİVERSİTESİ ","TOKAT GAZİOSMANPAŞA ÜNİVERSİTESİ ","TRABZON ÜNİVERSİTESİ ","TRAKYA ÜNİVERSİTESİ ","UŞAK ÜNİVERSİTESİ ","VAN YÜZÜNCÜ YIL ÜNİVERSİTESİ ","YALOVA ÜNİVERSİTESİ ","YOZGAT BOZOK ÜNİVERSİTESİ ","ZONGULDAK BÜLENT ECEVİT ÜNİVERSİTESİ  ","ACIBADEM MEHMET ALİ AYDINLAR ÜNİVERSİTESİ ","ALTINBAŞ ÜNİVERSİTESİ ","ANKARA MEDİPOL ÜNİVERSİTESİ ","ANTALYA AKEV ÜNİVERSİTESİ ","ATAŞEHİR ADIGÜZEL MESLEK YÜKSEKOKULU ","ATILIM ÜNİVERSİTESİ ","AVRASYA ÜNİVERSİTESİ ","AVRUPA MESLEK YÜKSEKOKULU ","BAHÇEŞEHİR ÜNİVERSİTESİ ","BAŞKENT ÜNİVERSİTESİ ","BEYKENT ÜNİVERSİTESİ ","BEYKOZ ÜNİVERSİTESİ ","BEZM-İ ÂLEM VAKIF ÜNİVERSİTESİ ","BİRUNİ ÜNİVERSİTESİ ","ÇAĞ ÜNİVERSİTESİ ","ÇANKAYA ÜNİVERSİTESİ ","DEMİROĞLU BİLİM ÜNİVERSİTESİ ","DOĞUŞ ÜNİVERSİTESİ ","FARUK SARAÇ TASARIM MESLEK YÜKSEKOKULU ","FATİH SULTAN MEHMET VAKIF ÜNİVERSİTESİ ","HALİÇ ÜNİVERSİTESİ ","HASAN KALYONCU ÜNİVERSİTESİ ","IŞIK ÜNİVERSİTESİ ","İSTANBUL AREL ÜNİVERSİTESİ  ","İSTANBUL AYDIN ÜNİVERSİTESİ ","İSTANBUL AYVANSARAY ÜNİVERSİTESİ ","İSTANBUL BİLGİ ÜNİVERSİTESİ ","İSTANBUL ESENYURT ÜNİVERSİTESİ ","İSTANBUL GEDİK ÜNİVERSİTESİ ","İSTANBUL GELİŞİM ÜNİVERSİTESİ ","İSTANBUL KENT ÜNİVERSİTESİ ","İSTANBUL KÜLTÜR ÜNİVERSİTESİ ","İSTANBUL MEDİPOL ÜNİVERSİTESİ  ","İSTANBUL OKAN ÜNİVERSİTESİ ","İSTANBUL RUMELİ ÜNİVERSİTESİ ","İSTANBUL ŞEHİR ÜNİVERSİTESİ ","İSTANBUL ŞİŞLİ MESLEK YÜKSEKOKULU ","İSTANBUL YENİ YÜZYIL ÜNİVERSİTESİ  ","İSTİNYE ÜNİVERSİTESİ ","İZMİR EKONOMİ ÜNİVERSİTESİ  ","İZMİR KAVRAM MESLEK YÜKSEKOKULU  ","KADİR HAS ÜNİVERSİTESİ  ","KAPADOKYA ÜNİVERSİTESİ ","KTO KARATAY ÜNİVERSİTESİ ","LOKMAN HEKİM ÜNİVERSİTESİ ","MALTEPE ÜNİVERSİTESİ ","MEF ÜNİVERSİTESİ  ","NİŞANTAŞI ÜNİVERSİTESİ ","OSTİM TEKNİK ÜNİVERSİTESİ ","PİRİ REİS ÜNİVERSİTESİ ","TOROS ÜNİVERSİTESİ ","TÜRK HAVA KURUMU ÜNİVERSİTESİ ","UFUK ÜNİVERSİTESİ ","ÜSKÜDAR ÜNİVERSİTESİ ","YAŞAR ÜNİVERSİTESİ ","YEDİTEPE ÜNİVERSİTESİ ","YÜKSEK İHTİSAS ÜNİVERSİTESİ ","DOĞU AKDENİZ ÜNİVERSİTESİ ","GİRNE AMERİKAN ÜNİVERSİTESİ ","GİRNE ÜNİVERSİTESİ ","KIBRIS AMERİKAN ÜNİVERSİTESİ  ","KIBRIS İLİM ÜNİVERSİTESİ ","KIBRIS SAĞLIK VE TOPLUM BİLİMLERİ ÜNİVERSİTESİ ","KIBRIS SOSYAL BİLİMLER ÜNİVERSİTESİ ","LEFKE AVRUPA ÜNİVERSİTESİ ","ULUSLARARASI KIBRIS ÜNİVERSİTESİ ","YAKIN DOĞU ÜNİVERSİTESİ ","HOCA AHMET YESEVİ ULUSLARARASI TÜRK-KAZAK ÜNİVERSİTESİ ","DOĞU AKDENİZ ÜNİVERSİTESİ ","GİRNE AMERİKAN ÜNİVERSİTESİ ","LEFKE AVRUPA ÜNİVERSİTESİ ","ULUSLARARASI KIBRIS ÜNİVERSİTESİ ","YAKIN DOĞU ÜNİVERSİTESİ ","GİRNE ÜNİVERSİTESİ ","KIBRIS İLİM ÜNİVERSİTESİ ","KIBRIS AMERİKAN ÜNİVERSİTESİ ","KIBRIS SOSYAL BİLİMLER ÜNİVERSİTESİ ","KIBRIS SAĞLIK VE TOPLUM BİLİMLERİ ÜNİVERSİTESİ ","HOCA AHMET YESEVİ ULUSLARARASI TÜRK-KAZAK ÜNİVERSİTESİ	 "};
    PageViewModel pageViewModel;
    final List<Universite> universiteler=new ArrayList<Universite>();
    List<Universite> filteredUniversiteler;
    ListView listView2;
    CustomAdapter filterAdapter;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    private OnFragmentInteractionListener mListener;

    public OnlisanUniversiteFragment() {
        // Required empty public constructor
    }


    public static OnlisanUniversiteFragment newInstance() {
        return new OnlisanUniversiteFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        for(int i=0;i<universiteAdlari.length;i++)
        {
            universiteler.add(new Universite(universiteAdlari[i],"a1111.png"));

        }
        mInterstitialAd = new InterstitialAd(getActivity().getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        pageViewModel= ViewModelProviders.of(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onlisan_universite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        SearchView searchView=view.findViewById(R.id.onlisansUniversiteSearch);
        final ListView listView=view.findViewById(R.id.onlisansUniversiteListView);
        listView2=view.findViewById(R.id.onlisansUniversiteListView);

        final CustomAdapter customAdapter=new CustomAdapter(getActivity(),universiteler);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity().getApplicationContext(), UniversiteProgramlarActivity.class);
                intent.putExtra("universiteAdi",universiteler.get(position).getUniversiteAdi());

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                startActivity(intent);
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
                filteredUniversiteler=new ArrayList<Universite>();
                // filterAdapter=new CustomAdapter(getActivity(),filteredUniversiteler);
                for (int i=0;i<universiteler.size();i++)
                {
                    //String universiteAdi=universiteler.get(i).getUniversiteAdi();
                    Universite universite=universiteler.get(i);
                    if(universite.getUniversiteAdi().contains(sorgu))
                    {
                        filteredUniversiteler.add(universite);
                    }
                }
                filterAdapter=new CustomAdapter(getActivity(),filteredUniversiteler);
                listView2.setAdapter(filterAdapter);
                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity().getApplicationContext(),UniversiteProgramlarActivity.class);
                        intent.putExtra("universiteAdi2",filteredUniversiteler.get(position).getUniversiteAdi());
                        startActivity(intent);
                    }
                });



                return true;
            }
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

  /*  @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
*/
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
