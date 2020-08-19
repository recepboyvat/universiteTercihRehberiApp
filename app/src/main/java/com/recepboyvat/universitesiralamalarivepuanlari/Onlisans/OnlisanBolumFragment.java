package com.recepboyvat.universitesiralamalarivepuanlari.Onlisans;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.recepboyvat.universitesiralamalarivepuanlari.Bolum;
import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.UniversiteProgramlarActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.CustomBolumAdapter;
import com.recepboyvat.universitesiralamalarivepuanlari.ui.main.PageViewModel;

import java.util.ArrayList;
import java.util.List;


public class OnlisanBolumFragment extends Fragment {
    String []bolumAdlari={"ACİL DURUM VE AFET YÖNETİMİ","ACİL DURUM VE AFET YÖNETİMİ(AÇIKÖĞRETİM)","ADALET","ADALET(AÇIKÖĞRETİM)","AĞIZ VE DİŞ SAĞLIĞI","ALTERNATİF ENERJİ KAYNAKLARI TEKNOLOJİSİ","AMELİYATHANE HİZMETLERİ","ANESTEZİ","ARICILIK","AŞÇILIK","AŞÇILIK(AÇIKÖĞRETİM)","ATÇILIK VE ANTRENÖRLÜĞÜ","ATIK YÖNETİMİ","AVCILIK VE YABAN HAYATI","AYAKKABI TASARIM VE ÜRETİMİ","BAĞCILIK","BAHÇE TARIMI","BANKACILIK VE SİGORTACILIK","BANKACILIK VE SİGORTACILIK(AÇIKÖĞRETİM)","BASIM VE YAYIN TEKNOLOJİLERİ","BASIN VE YAYINCILIK","BİLGİ GÜVENLİĞİ TEKNOLOJİSİ","BİLGİ YÖNETİMİ","BİLGİ YÖNETİMİ(AÇIKÖĞRETİM)","BİLGİSAYAR DESTEKLİ TASARIM VE ANİMASYON","BİLGİSAYAR OPERATÖRLÜĞÜ","BİLGİSAYAR OPERATÖRLÜĞÜ(ENGELLİLER)","BİLGİSAYAR PROGRAMCILIĞI","BİLGİSAYAR TEKNOLOJİSİ","BİTKİ KORUMA","BİYOKİMYA","BİYOMEDİKAL CİHAZ TEKNOLOJİSİ","BOYA TEKNOLOJİSİ","BÜRO YÖNETİMİ VE YÖNETİCİ ASİSTANLIĞI","BÜRO YÖNETİMİ VE YÖNETİCİ ASİSTANLIĞI(AÇIKÖĞRETİM)","CEZA İNFAZ VE GÜVENLİK HİZMETLERİ","COĞRAFİ BİLGİ SİSTEMLERİ","COĞRAFİ BİLGİ SİSTEMLERİ(AÇIKÖĞRETİM)","ÇAĞRI MERKEZİ HİZMETLERİ","ÇAĞRI MERKEZİ HİZMETLERİ(AÇIKÖĞRETİM)","ÇAY TARIMI VE İŞLEME TEKNOLOJİSİ","ÇEVRE KORUMA VE KONTROL","ÇEVRE SAĞLIĞI","ÇEVRE TEMİZLİĞİ VE DENETİMİ","ÇİM ALAN TESİSİ VE YÖNETİMİ","ÇİNİ SANATI VE TASARIMI","ÇOCUK GELİŞİMİ","ÇOCUK GELİŞİMİ(AÇIKÖĞRETİM)","ÇOCUK KORUMA VE BAKIM HİZMETLERİ","DENİZ BROKERLİĞİ","DENİZ ULAŞTIRMA VE İŞLETME","DENİZ VE LİMAN İŞLETMECİLİĞİ","DENİZCİ SAĞLIĞI","DERİ KONFEKSİYON","DERİ TEKNOLOJİSİ","DEZENFEKSİYON, STERİLİZASYON VE ANTİSEPSİ","DIŞ TİCARET","DIŞ TİCARET(AÇIKÖĞRETİM)","DİJİTAL MEDYA VE PAZARLAMA","DİŞ PROTEZ TEKNOLOJİSİ","DİYALİZ","DOĞAL YAPI TAŞLARI TEKNOLOJİSİ","DOĞALGAZ VE TESİSATI TEKNOLOJİSİ","DÖKÜM","ECZANE HİZMETLERİ","ELEKTRİK","ELEKTRİK ENERJİSİ ÜRETİM, İLETİM VE DAĞITIMI","ELEKTRİK ENERJİSİ ÜRETİM, İLETİM VE DAĞITIMI(AÇIKÖĞRETİM)","ELEKTRİKLİ CİHAZ TEKNOLOJİSİ","ELEKTRONİK HABERLEŞME TEKNOLOJİSİ","ELEKTRONİK TEKNOLOJİSİ","ELEKTRONÖROFİZYOLOJİ","EMLAK VE EMLAK YÖNETİMİ","EMLAK VE EMLAK YÖNETİMİ(AÇIKÖĞRETİM)","ENDÜSTRİ ÜRÜNLERİ TASARIMI","ENDÜSTRİYEL CAM VE SERAMİK","ENDÜSTRİYEL HAMMADDELER İŞLEME TEKNOLOJİSİ","ENDÜSTRİYEL KALIPÇILIK","ENDÜSTRİYEL TAVUKÇULUK","ENERJİ TESİSLERİ İŞLETMECİLİĞİ","ENGELLİ BAKIMI VE REHABİLİTASYON","ENGELLİ BAKIMI VE REHABİLİTASYON(AÇIKÖĞRETİM)","ESER KORUMA","ET VE ÜRÜNLERİ TEKNOLOJİSİ","EV İDARESİ(AÇIKÖĞRETİM)","EV TEKSTİL TASARIMI","EVDE HASTA BAKIMI","FINDIK EKSPERLİĞİ","FİDAN YETİŞTİRİCİLİĞİ","FİZYOTERAPİ","FOTOĞRAFÇILIK VE KAMERAMANLIK","FOTOĞRAFÇILIK VE KAMERAMANLIK(AÇIKÖĞRETİM)","GAZ VE TESİSATI TEKNOLOJİSİ","GELENEKSEL EL SANATLARI","GELENEKSEL TEKSTİLLERİN KONSERVASYONU VE RESTORASYONU","GEMİ AŞÇILIĞI","GEMİ İNŞAATI","GEMİ MAKİNELERİ İŞLETME","GEOTEKNİK","GIDA KALİTE KONTROLÜ VE ANALİZİ","GIDA TEKNOLOJİSİ","GİYİM ÜRETİM TEKNOLOJİSİ","GÖRSEL İLETİŞİM","GRAFİK TASARIMI","HALICILIK VE KİLİMCİLİK","HALKLA İLİŞKİLER VE TANITIM","HALKLA İLİŞKİLER VE TANITIM(AÇIKÖĞRETİM)","HARİTA VE KADASTRO","HAVA LOJİSTİĞİ","HİBRİD VE ELEKTRİKLİ TAŞITLAR TEKNOLOJİSİ","HUKUK BÜRO YÖNETİMİ VE SEKRETERLİĞİ","HUKUK BÜRO YÖNETİMİ VE SEKRETERLİĞİ(AÇIKÖĞRETİM)","İÇ MEKAN TASARIMI","İKLİMLENDİRME VE SOĞUTMA TEKNOLOJİSİ","İKRAM HİZMETLERİ","İLAHİYAT(AÇIKÖĞRETİM)","İLK VE ACİL YARDIM","İNSAN KAYNAKLARI YÖNETİMİ","İNSAN KAYNAKLARI YÖNETİMİ(AÇIKÖĞRETİM)","İNŞAAT TEKNOLOJİSİ","İNTERNET VE AĞ TEKNOLOJİLERİ","İŞ MAKİNELERİ OPERATÖRLÜĞÜ","İŞ SAĞLIĞI VE GÜVENLİĞİ","İŞ SAĞLIĞI VE GÜVENLİĞİ(AÇIKÖĞRETİM)","İŞ VE UĞRAŞI TERAPİSİ","İŞLETME YÖNETİMİ","İŞLETME YÖNETİMİ(AÇIKÖĞRETİM)","KAYNAK TEKNOLOJİSİ","KİMYA TEKNOLOJİSİ","KONTROL VE OTOMASYON TEKNOLOJİSİ","KOOPERATİFÇİLİK","KOZMETİK TEKNOLOJİSİ","KUYUMCULUK VE TAKI TASARIMI","KÜLTÜREL MİRAS VE TURİZM","KÜLTÜREL MİRAS VE TURİZM(AÇIKÖĞRETİM)","KÜMES HAYVANLARI YETİŞTİRİCİLİĞİ","LABORANT VE VETERİNER SAĞLIK","LABORANT VE VETERİNER SAĞLIK(AÇIKÖĞRETİM)","LABORATUVAR TEKNOLOJİSİ","LASTİK VE PLASTİK TEKNOLOJİSİ","LOJİSTİK","LOJİSTİK(AÇIKÖĞRETİM)","MADEN TEKNOLOJİSİ","MAKİNE","MAKİNE, RESİM VE KONSTRÜKSİYON","MALİYE","MANTARCILIK","MARİNA VE YAT İŞLETMECİLİĞİ","MARKA İLETİŞİMİ(AÇIKÖĞRETİM)","MEDYA VE İLETİŞİM","MEDYA VE İLETİŞİM(AÇIKÖĞRETİM)","MEKATRONİK","MENKUL KIYMETLER VE SERMAYE PİYASASI","MENKUL KIYMETLER VE SERMAYE PİYASASI(AÇIKÖĞRETİM)","METALURJİ","MEYVE VE SEBZE İŞLEME TEKNOLOJİSİ","MİMARİ DEKORATİF SANATLAR","MİMARİ RESTORASYON","MOBİL TEKNOLOJİLERİ","MOBİLYA VE DEKORASYON","MODA TASARIMI","MODA YÖNETİMİ","MUHASEBE VE VERGİ UYGULAMALARI","MUHASEBE VE VERGİ UYGULAMALARI(AÇIKÖĞRETİM)","NÜFUS VE VATANDAŞLIK","NÜKLEER TEKNOLOJİ VE RADYASYON GÜVENLİĞİ","NÜKLEER TIP TEKNİKLERİ","ODYOMETRİ","OPTİSYENLİK","ORGANİK TARIM","ORMANCILIK VE ORMAN ÜRÜNLERİ","ORTOPEDİK PROTEZ VE ORTEZ","OTO BOYA VE KAROSERİ","OTOBÜS KAPTANLIĞI","OTOMOTİV TEKNOLOJİSİ","OTOPSİ YARDIMCILIĞI","ÖZEL GÜVENLİK VE KORUMA","ÖZEL GÜVENLİK VE KORUMA(AÇIKÖĞRETİM)","PASTACILIK VE EKMEKÇİLİK","PATOLOJİ LABORATUVAR TEKNİKLERİ","PAZARLAMA","PERAKENDE SATIŞ VE MAĞAZA YÖNETİMİ","PERAKENDE SATIŞ VE MAĞAZA YÖNETİMİ(AÇIKÖĞRETİM)","PERFÜZYON TEKNİKLERİ","PEYZAJ VE SÜS BİTKİLERİ","PODOLOJİ","POLİMER TEKNOLOJİSİ","POSTA HİZMETLERİ","RADYO VE TELEVİZYON PROGRAMCILIĞI","RADYO VE TELEVİZYON PROGRAMCILIĞI(AÇIKÖĞRETİM)","RADYO VE TELEVİZYON TEKNOLOJİSİ","RADYOTERAPİ","RAFİNERİ VE PETRO-KİMYA TEKNOLOJİSİ","RAYLI SİSTEMLER ELEKTRİK VE ELEKTRONİK TEKNOLOJİSİ","RAYLI SİSTEMLER İŞLETMECİLİĞİ","RAYLI SİSTEMLER MAKİNE TEKNOLOJİSİ","RAYLI SİSTEMLER MAKİNİSTLİK","RAYLI SİSTEMLER YOL TEKNOLOJİSİ","REKLAMCILIK","REKLAMCILIK(AÇIKÖĞRETİM)","SAÇ BAKIMI VE GÜZELLİK HİZMETLERİ","SAĞLIK BİLGİ SİSTEMLERİ TEKNİKERLİĞİ","SAĞLIK KURUMLARI İŞLETMECİLİĞİ","SAĞLIK KURUMLARI İŞLETMECİLİĞİ(AÇIKÖĞRETİM)","SAĞLIK TURİZMİ İŞLETMECİLİĞİ","SAHNE VE DEKOR TASARIMI","SAHNE VE GÖSTERİ SANATLARI TEKNOLOJİSİ","SERACILIK","SERAMİK, CAM VE ÇİNİCİLİK","SİLAH SANAYİ TEKNİKERLİĞİ","SİVİL HAVA ULAŞTIRMA İŞLETMECİLİĞİ","SİVİL HAVA ULAŞTIRMA İŞLETMECİLİĞİ(AÇIKÖĞRETİM)","SİVİL HAVACILIK KABİN HİZMETLERİ","SİVİL SAVUNMA VE İTFAİYECİLİK","SONDAJ TEKNOLOJİSİ","SOSYAL GÜVENLİK","SOSYAL HİZMETLER","SOSYAL HİZMETLER(AÇIKÖĞRETİM)","SOSYAL MEDYA YÖNETİCİLİĞİ(AÇIKÖĞRETİM)","SPOR YÖNETİMİ","SPOR YÖNETİMİ(AÇIKÖĞRETİM)","SU ALTI TEKNOLOJİSİ","SU ÜRÜNLERİ İŞLEME TEKNOLOJİSİ","SULAMA TEKNOLOJİSİ","SÜS BİTKİLERİ YETİŞTİRİCİLİĞİ","SÜT VE BESİ HAYVANCILIĞI","SÜT VE ÜRÜNLERİ TEKNOLOJİSİ","ŞARAP ÜRETİM TEKNOLOJİSİ","TAHRİBATSIZ MUAYENE","TAPU VE KADASTRO","TARIM MAKİNELERİ","TARIM(AÇIKÖĞRETİM)","TARIMSAL İŞLETMECİLİK","TARIMSAL ÜRÜNLER MUHAFAZA VE DEPOLAMA TEKNOLOJİSİ","TARLA BİTKİLERİ","TEKSTİL TEKNOLOJİSİ","TEKSTİL VE HALI MAKİNELERİ","TIBBİ DOKÜMANTASYON VE SEKRETERLİK","TIBBİ DOKÜMANTASYON VE SEKRETERLİK(AÇIKÖĞRETİM)","TIBBİ GÖRÜNTÜLEME TEKNİKLERİ","TIBBİ LABORATUVAR TEKNİKLERİ","TIBBİ TANITIM VE PAZARLAMA","TIBBİ VE AROMATİK BİTKİLER","TOHUMCULUK TEKNOLOJİSİ","TURİST REHBERLİĞİ","TURİZM ANİMASYONU","TURİZM VE OTEL İŞLETMECİLİĞİ","TURİZM VE OTEL İŞLETMECİLİĞİ(AÇIKÖĞRETİM)","TURİZM VE SEYAHAT HİZMETLERİ","TURİZM VE SEYAHAT HİZMETLERİ(AÇIKÖĞRETİM)","UÇAK TEKNOLOJİSİ","UÇUŞ HAREKAT YÖNETİCİLİĞİ","ULAŞTIRMA VE TRAFİK HİZMETLERİ","UN VE UNLU MAMULLER TEKNOLOJİSİ","UYGULAMALI İNGİLİZCE VE ÇEVİRMENLİK","UYGULAMALI İSPANYOLCA VE ÇEVİRMENLİK","UYGULAMALI RUSÇA VE ÇEVİRMENLİK","ÜÇ BOYUTLU MODELLEME VE ANİMASYON","ÜRETİMDE KALİTE KONTROL","WEB TASARIMI VE KODLAMA(AÇIKÖĞRETİM)","YAĞ ENDÜSTRİSİ","YAPI DENETİMİ","YAPI RESSAMLIĞI","YAPI RESSAMLIĞI(ENGELLİLER)","YAPI TESİSAT TEKNOLOJİSİ","YAPI YALITIM TEKNOLOJİSİ","YAŞLI BAKIMI","YAŞLI BAKIMI(AÇIKÖĞRETİM)","YAT KAPTANLIĞI","YENİ MEDYA VE GAZETECİLİK","YEREL YÖNETİMLER","YEREL YÖNETİMLER(AÇIKÖĞRETİM)","ZEYTİNCİLİK VE ZEYTİN İŞLEME TEKNOLOJİSİ",};
    final List<Bolum> bolumler=new ArrayList<Bolum>();

    List<Bolum> filteredBolumler;
    ListView listView2;
    CustomBolumAdapter filterBolumAdapter;
    PageViewModel pageViewModel;
    private AdView mAdView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OnlisanBolumFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static OnlisanBolumFragment newInstance() {
        return new OnlisanBolumFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel= ViewModelProviders.of(requireActivity()).get(PageViewModel.class);
        for (int i=0;i<bolumAdlari.length;i++)
        {
            bolumler.add(new Bolum(bolumAdlari[i],"a1111.png"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onlisan_bolum, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        SearchView searchView=view.findViewById(R.id.onlisansBolumSearch);
        ListView listView=view.findViewById(R.id.onlisansBolumListView);
        listView2=view.findViewById(R.id.onlisansBolumListView);

        final ListView bolumListView=view.findViewById(R.id.onlisansBolumListView);
        final CustomBolumAdapter customBolumAdapter=new CustomBolumAdapter(getActivity(),bolumler);
        bolumListView.setAdapter(customBolumAdapter);

        bolumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), UniversiteProgramlarActivity.class);
                intent.putExtra("bolumAdi1",bolumler.get(position).getBolumAdi());
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
                filteredBolumler=new ArrayList<Bolum>();
                for (int i=0;i<bolumler.size();i++)
                {
                    Bolum bolum=bolumler.get(i);
                    if(bolum.getBolumAdi().contains(sorgu))
                    {
                        filteredBolumler.add(bolum);
                    }
                }
                filterBolumAdapter=new CustomBolumAdapter(getActivity(),filteredBolumler);
                listView2.setAdapter(filterBolumAdapter);

                listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(getActivity().getApplicationContext(),UniversiteProgramlarActivity.class);
                        intent.putExtra("bolumAdi2",filteredBolumler.get(position).getBolumAdi());
                        startActivity(intent);
                    }
                });

                return false;
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
