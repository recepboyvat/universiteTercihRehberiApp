package com.recepboyvat.universitesiralamalarivepuanlari.ui.main;


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
import com.recepboyvat.universitesiralamalarivepuanlari.Bolum;
import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.UniversiteProgramlarActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BolumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BolumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BolumFragment extends Fragment {

    String[] bolumAdlari={"ACİL YARDIM VE AFET YÖNETİMİ(FAKÜLTE)","ACİL YARDIM VE AFET YÖNETİMİ(YÜKSEKOKUL)","ADLİ BİLİMLER","ADLİ BİLİŞİM MÜHENDİSLİĞİ","ADLİ BİLİŞİM MÜHENDİSLİĞİ(M.T.O.K.)","AĞAÇ İŞLERİ ENDÜSTRİ MÜHENDİSLİĞİ","AĞAÇ İŞLERİ ENDÜSTRİ MÜHENDİSLİĞİ(M.T.O.K.)","AİLE VE TÜKETİCİ BİLİMLERİ","AKTÜERYA BİLİMLERİ","AKTÜERYA VE RİSK YÖNETİMİ","AKTÜERYA(FAKÜLTE)","AKTÜERYA(YÜKSEKOKUL)","ALMAN DİLİ VE EDEBİYATI","ALMANCA ÖĞRETMENLİĞİ","AMERİKAN KÜLTÜRÜ VE EDEBİYATI","ANİMASYON","ANİMASYON VE OYUN TASARIMI","ANTRENÖRLÜK EĞİTİMİ(FAKÜLTE)","ANTROPOLOJİ","ARAP DİLİ VE EDEBİYATI","ARAPÇA ÖĞRETMENLİĞİ","ARKEOLOJİ","ARKEOLOJİ VE SANAT TARİHİ","ARNAVUT DİLİ VE EDEBİYATI","ASTRONOMİ VE ASTROFİZİK","ASTRONOMİ VE UZAY BİLİMLERİ","AVRUPA BİRLİĞİ İLİŞKİLERİ","AYAKKABI TASARIMI VE ÜRETİMİ","AZERBAYCAN DİLİ ÖĞRETMENLİĞİ","AZERBAYCAN DİLİ VE EDEBİYATI","AZERBAYCAN DİLİ VE EDEBİYATI ÖĞRETMENLİĞİ","AZERBAYCAN TÜRKÇESİ VE EDEBİYATI","BAHÇE BİTKİLERİ","BAHÇE BİTKİLERİ ÜRETİMİ VE PAZARLAMASI","BAHÇE VE TARLA BİTKİLERİ","BALIKÇILIK TEKNOLOJİSİ MÜHENDİSLİĞİ","BANKACILIK VE FİNANS(FAKÜLTE)","BANKACILIK VE FİNANS(YÜKSEKOKUL)","BANKACILIK VE SİGORTACILIK(FAKÜLTE)","BANKACILIK VE SİGORTACILIK(YÜKSEKOKUL)","BANKACILIK(FAKÜLTE)","BANKACILIK(YÜKSEKOKUL)","BASIM TEKNOLOJİLERİ(YÜKSEKOKUL)","BASIN VE YAYIN","BATI DİLLERİ","BEDEN EĞİTİMİ VE SPOR ÖĞRETMENLİĞİ","BESLENME VE DİYETETİK(FAKÜLTE)","BESLENME VE DİYETETİK(YÜKSEKOKUL)","BİLGİ GÜVENLİĞİ TEKNOLOJİSİ","BİLGİ VE BELGE YÖNETİMİ","BİLGİSAYAR BİLİMLERİ","BİLGİSAYAR MÜHENDİSLİĞİ","BİLGİSAYAR MÜHENDİSLİĞİ(M.T.O.K.)","BİLGİSAYAR TEKNOLOJİSİ VE BİLİŞİM SİSTEMLERİ(FAKÜLTE)","BİLGİSAYAR TEKNOLOJİSİ VE BİLİŞİM SİSTEMLERİ(YÜKSEKOKUL)","BİLGİSAYAR VE ÖĞRETİM TEKNOLOJİLERİ ÖĞRETMENLİĞİ","BİLGİSAYAR VE YAZILIM MÜHENDİSLİĞİ","BİLGİSAYAR-ENFORMATİK","BİLİM TARİHİ","BİLİŞİM SİSTEMLERİ MÜHENDİSLİĞİ","BİLİŞİM SİSTEMLERİ MÜHENDİSLİĞİ(M.T.O.K.)","BİLİŞİM SİSTEMLERİ VE TEKNOLOJİLERİ","BİTKİ KORUMA","BİTKİSEL ÜRETİM VE TEKNOLOJİLERİ","BİYOENFORMATİK VE GENETİK","BİYOKİMYA","BİYOLOJİ","BİYOLOJİ ÖĞRETMENLİĞİ","BİYOMEDİKAL MÜHENDİSLİĞİ","BİYOMEDİKAL MÜHENDİSLİĞİ(M.T.O.K.)","BİYOMÜHENDİSLİK","BİYOSİSTEM MÜHENDİSLİĞİ","BİYOTEKNOLOJİ","BİYOTEKNOLOJİ VE MOLEKÜLER BİYOLOJİ","BOŞNAK DİLİ VE EDEBİYATI","BULGAR DİLİ VE EDEBİYATI","CANLANDIRMA FİLMİ TASARIM VE YÖNETİMİ","CEVHER HAZIRLAMA MÜHENDİSLİĞİ","ÇOCUK GELİŞİMİ(FAKÜLTE)(AÇIKÖĞRETİM)","COĞRAFYA","COĞRAFYA ÖĞRETMENLİĞİ","COĞRAFYA(AÇIKÖĞRETİM)","ÇAĞDAŞ TÜRK LEHÇELERİ VE EDEBİYATLARI","ÇAĞDAŞ YUNAN DİLİ VE EDEBİYATI","ÇALIŞMA EKONOMİSİ VE ENDÜSTRİ İLİŞKİLERİ","ÇALIŞMA EKONOMİSİ VE ENDÜSTRİ İLİŞKİLERİ(AÇIKÖĞRETİM)","ÇERKEZ DİLİ VE EDEBİYATI","ÇEVİRİBİLİM","ÇEVRE MÜHENDİSLİĞİ","ÇİN DİLİ VE EDEBİYATI","ÇİZGİ FİLM VE ANİMASYON","ÇOCUK GELİŞİMİ(FAKÜLTE)","ÇOCUK GELİŞİMİ(YÜKSEKOKUL)","DENİZ İŞLETMECİLİĞİ VE YÖNETİMİ","DENİZ ULAŞTIRMA İŞLETME MÜHENDİSLİĞİ(FAKÜLTE)","DENİZ ULAŞTIRMA İŞLETME MÜHENDİSLİĞİ(YÜKSEKOKUL)","DENİZCİLİK İŞLETMELERİ YÖNETİMİ(FAKÜLTE)","DERİ MÜHENDİSLİĞİ","DİJİTAL OYUN TASARIMI(FAKÜLTE)","DİL VE KONUŞMA TERAPİSİ(FAKÜLTE)","DİL VE KONUŞMA TERAPİSİ(YÜKSEKOKUL)","DİLBİLİM","DİLBİLİMİ","DİNİ İLİMLER","DİŞ HEKİMLİĞİ","DOĞU DİLLERİ","EBELİK(FAKÜLTE)","EBELİK(YÜKSEKOKUL)","ECZACILIK","EKONOMETRİ","EKONOMİ","EKONOMİ VE FİNANS","EL SANATLARI","EL SANATLARI TASARIMI VE ÜRETİMİ","EL SANATLARI(M.T.O.K.)","ELEKTRİK MÜHENDİSLİĞİ","ELEKTRİK-ELEKTRONİK MÜHENDİSLİĞİ","ELEKTRİK-ELEKTRONİK MÜHENDİSLİĞİ(M.T.O.K.)","ELEKTRONİK MÜHENDİSLİĞİ","ELEKTRONİK TİCARET VE TEKNOLOJİ YÖNETİMİ","ELEKTRONİK VE HABERLEŞME MÜHENDİSLİĞİ","ELEKTRONİK VE HABERLEŞME MÜHENDİSLİĞİ(M.T.O.K.)","ENDÜSTRİ MÜHENDİSLİĞİ","ENDÜSTRİ MÜHENDİSLİĞİ PROGRAMLARI","ENDÜSTRİ ÜRÜNLERİ TASARIMI(FAKÜLTE)","ENDÜSTRİ ÜRÜNLERİ TASARIMI(YÜKSEKOKUL)","ENDÜSTRİ VE SİSTEM MÜHENDİSLİĞİ","ENDÜSTRİYEL TASARIM","ENDÜSTRİYEL TASARIM MÜHENDİSLİĞİ","ENDÜSTRİYEL TASARIM MÜHENDİSLİĞİ(M.T.O.K.)","ENERJİ MÜHENDİSLİĞİ","ENERJİ SİSTEMLERİ MÜHENDİSLİĞİ","ENERJİ SİSTEMLERİ MÜHENDİSLİĞİ(M.T.O.K.)","ENERJİ YÖNETİMİ","ERGOTERAPİ(FAKÜLTE)","ERGOTERAPİ(YÜKSEKOKUL)","ERMENİ DİLİ VE EDEBİYATI","ERMENİ DİLİ VE KÜLTÜRÜ(ERMENİCE)","ESKİ YUNAN DİLİ VE EDEBİYATI","EŞİT AĞIRLIKLI PROGRAMLAR","FARS DİLİ VE EDEBİYATI","FELSEFE","FELSEFE GRUBU ÖĞRETMENLİĞİ","FELSEFE(AÇIKÖĞRETİM)","FEN BİLGİSİ ÖĞRETMENLİĞİ","FİLM TASARIM VE YAZARLIK","FİLM TASARIM VE YÖNETMENLİĞİ","FİLM TASARIMI","FİNANS VE BANKACILIK(FAKÜLTE)","FİZİK","FİZİK MÜHENDİSLİĞİ","FİZİK ÖĞRETMENLİĞİ","FİZYOTERAPİ VE REHABİLİTASYON(FAKÜLTE)","FİZYOTERAPİ VE REHABİLİTASYON(YÜKSEKOKUL)","FOTOĞRAF","FOTOĞRAF VE VİDEO","FOTONİK","FRANSIZ DİLİ VE EDEBİYATI","FRANSIZCA ÖĞRETMENLİĞİ","GASTRONOMİ VE MUTFAK SANATLARI(FAKÜLTE)","GASTRONOMİ VE MUTFAK SANATLARI(M.T.O.K.)","GASTRONOMİ VE MUTFAK SANATLARI(YÜKSEKOKUL)","GASTRONOMİ(FAKÜLTE)","GASTRONOMİ(YÜKSEKOKUL)","GAYRİMENKUL GELİŞTİRME VE YÖNETİMİ(FAKÜLTE)","GAYRİMENKUL GELİŞTİRME VE YÖNETİMİ(YÜKSEKOKUL)","GAYRİMENKUL VE VARLIK DEĞERLEME(FAKÜLTE)","GAYRİMENKUL VE VARLIK DEĞERLEME(YÜKSEKOKUL)","GAZETECİLİK","GELENEKSEL TÜRK SANATLARI(M.T.O.K.)","GEMİ İNŞAATI VE GEMİ MAKİNELERİ MÜHENDİSLİĞİ","GEMİ MAKİNELERİ İŞLETME MÜHENDİSLİĞİ(FAKÜLTE)","GEMİ MAKİNELERİ İŞLETME MÜHENDİSLİĞİ(YÜKSEKOKUL)","GEMİ VE DENİZ TEKNOLOJİSİ MÜHENDİSLİĞİ","GEMİ VE YAT TASARIMI","GENETİK VE BİYOMÜHENDİSLİK","GENETİK VE YAŞAM BİLİMLERİ PROGRAMLARI","GEOMATİK MÜHENDİSLİĞİ","GERONTOLOJİ(FAKÜLTE)","GERONTOLOJİ(YÜKSEKOKUL)","GIDA MÜHENDİSLİĞİ","GIDA TEKNOLOJİSİ(YÜKSEKOKUL)","GİRİŞİMCİLİK","GÖRSEL İLETİŞİM","GÖRSEL İLETİŞİM TASARIMI","GÖRSEL SANATLAR","GÖRSEL SANATLAR VE GÖRSEL İLETİŞİM TASARIMI","GÖRSEL SANATLAR VE İLETİŞİM TASARIMI","GÖRSEL SANATLAR(M.T.O.K.)","GRAFİK TASARIM","GRAFİK TASARIMI","GRAFİK TASARIMI(M.T.O.K.)","GÜMRÜK İŞLETME(YÜKSEKOKUL)","GÜRCÜ DİLİ VE EDEBİYATI","GÜVERTE(YÜKSEKOKUL)","HALKBİLİM","HALKLA İLİŞKİLER","HALKLA İLİŞKİLER VE REKLAMCILIK(AÇIKÖĞRETİM)","HALKLA İLİŞKİLER VE REKLAMCILIK(FAKÜLTE)","HALKLA İLİŞKİLER VE REKLAMCILIK(YÜKSEKOKUL)","HALKLA İLİŞKİLER VE TANITIM","HALKLA İLİŞKİLER VE TANITIM(AÇIKÖĞRETİM)","HARİTA MÜHENDİSLİĞİ","HAVACILIK ELEKTRİK VE ELEKTRONİĞİ(FAKÜLTE)","HAVACILIK ELEKTRİK VE ELEKTRONİĞİ(YÜKSEKOKUL)","HAVACILIK ELEKTRONİĞİ","HAVACILIK VE UZAY MÜHENDİSLİĞİ","HAVACILIK YÖNETİMİ(AÇIKÖĞRETİM)","HAVACILIK YÖNETİMİ(FAKÜLTE)","HAVACILIK YÖNETİMİ(YÜKSEKOKUL)","HAYVANSAL ÜRETİM VE TEKNOLOJİLERİ","HAYVANSAL ÜRETİM(YÜKSEKOKUL)","HEMŞİRELİK VE SAĞLIK HİZMETLERİ(YÜKSEKOKUL)","HEMŞİRELİK(FAKÜLTE)","HEMŞİRELİK(YÜKSEKOKUL)","HİDROJEOLOJİ MÜHENDİSLİĞİ","HİNDOLOJİ","HİTİTOLOJİ","HUKUK","HUNGAROLOJİ","İBRANİ DİLİ VE EDEBİYATI","İÇ MİMARLIK","İÇ MİMARLIK VE ÇEVRE TASARIMI","İKTİSADİ VE İDARİ BİLİMLER PROGRAMLARI","İKTİSADİ VE İDARİ PROGRAMLARI","İKTİSAT","İKTİSAT(AÇIKÖĞRETİM)","İLAHİYAT","İLETİŞİM","İLETİŞİM BİLİMLERİ","İLETİŞİM SANATLARI","İLETİŞİM TASARIMI","İLETİŞİM TASARIMI VE MEDYA","İLETİŞİM TASARIMI VE YENİ MEDYA","İLETİŞİM TASARIMI VE YÖNETİMİ","İLETİŞİM VE TASARIM","İLKÖĞRETİM MATEMATİK ÖĞRETMENLİĞİ","İMALAT MÜHENDİSLİĞİ","İMALAT MÜHENDİSLİĞİ(M.T.O.K.)","İNGİLİZ DİL BİLİMİ","İNGİLİZ DİLİ VE EDEBİYATI","İNGİLİZ DİLİ VE KARŞILAŞTIRMALI EDEBİYAT","İNGİLİZ VE RUS DİLLERİ VE EDEBİYATLARI","İNGİLİZCE ÖĞRETMENLİĞİ","İNSAN KAYNAKLARI YÖNETİMİ(FAKÜLTE)","İNSAN KAYNAKLARI YÖNETİMİ(FAKÜLTE)(AÇIKÖĞRETİM)","İNSAN KAYNAKLARI YÖNETİMİ(YÜKSEKOKUL)","İNSAN VE TOPLUM BİLİMLERİ","İNŞAAT MÜHENDİSLİĞİ","İNŞAAT MÜHENDİSLİĞİ(M.T.O.K.)","İSLAM BİLİMLERİ","İSLAM EKONOMİSİ VE FİNANS","İSLAM VE DİN BİLİMLERİ","İSLAMİ İLİMLER","İSPANYOL DİLİ VE EDEBİYATI","İSTATİSTİK","İSTATİSTİK VE BİLGİSAYAR BİLİMLERİ","İŞ SAĞLIĞI VE GÜVENLİĞİ(FAKÜLTE)","İŞ SAĞLIĞI VE GÜVENLİĞİ(FAKÜLTE)(AÇIKÖĞRETİM)","İŞ SAĞLIĞI VE GÜVENLİĞİ(YÜKSEKOKUL)","İŞLETME","İŞLETME BİLGİ YÖNETİMİ(YÜKSEKOKUL)","İŞLETME ENFORMATİĞİ","İŞLETME MÜHENDİSLİĞİ","İŞLETME YÖNETİMİ","İŞLETME(AÇIKÖĞRETİM)","İŞLETME-EKONOMİ","İTALYAN DİLİ VE EDEBİYATI","JAPON DİLİ VE EDEBİYATI","JAPONCA ÖĞRETMENLİĞİ","JEOFİZİK MÜHENDİSLİĞİ","JEOLOJİ MÜHENDİSLİĞİ","KAMU YÖNETİMİ","KAMU YÖNETİMİ(AÇIKÖĞRETİM)","KANATLI HAYVAN YETİŞTİRİCİLİĞİ","KARŞILAŞTIRMALI EDEBİYAT","KAZAK DİLİ VE EDEBİYATI","KENTSEL TASARIM VE PEYZAJ MİMARLIĞI","KİMYA","KİMYA MÜHENDİSLİĞİ","KİMYA MÜHENDİSLİĞİ VE UYGULAMALI KİMYA","KİMYA ÖĞRETMENLİĞİ","KİMYA VE SÜREÇ MÜHENDİSLİĞİ","KİMYA-BİYOLOJİ MÜHENDİSLİĞİ","KLASİK ARKEOLOJİ","KONAKLAMA İŞLETMECİLİĞİ(FAKÜLTE)","KONAKLAMA İŞLETMECİLİĞİ(FAKÜLTE)(AÇIKÖĞRETİM)","KONAKLAMA İŞLETMECİLİĞİ(YÜKSEKOKUL)","KONAKLAMA VE TURİZM İŞLETMECİLİĞİ(YÜKSEKOKUL)","KONTROL VE OTOMASYON MÜHENDİSLİĞİ","KORE DİLİ VE EDEBİYATI","KURGU-SES VE GÖRÜNTÜ YÖNETİMİ","KUYUMCULUK VE MÜCEVHER TASARIMI(FAKÜLTE)","KUYUMCULUK VE MÜCEVHER TASARIMI(FAKÜLTE)(M.T.O.K.)","KUYUMCULUK VE MÜCEVHERAT TASARIMI(YÜKSEKOKUL)","KÜLTÜR VARLIKLARINI KORUMA VE ONARIM","KÜLTÜR VE İLETİŞİM BİLİMLERİ","KÜRESEL SİYASET VE ULUSLARARASI İLİŞKİLER","KÜRT DİLİ VE EDEBİYATI","LATİN DİLİ VE EDEBİYATI","LEH DİLİ VE EDEBİYATI","LİF VE POLİMER MÜHENDİSLİĞİ","LOJİSTİK YÖNETİMİ(FAKÜLTE)","LOJİSTİK YÖNETİMİ(YÜKSEKOKUL)","LOJİSTİK(YÜKSEKOKUL)","MADEN MÜHENDİSLİĞİ","MAKİNE MÜHENDİSLİĞİ","MAKİNE MÜHENDİSLİĞİ(M.T.O.K.)","MAKİNE VE İMALAT MÜHENDİSLİĞİ","MAKİNE VE İMALAT MÜHENDİSLİĞİ(M.T.O.K.)","MALİYE","MALİYE(AÇIKÖĞRETİM)","MALZEME BİLİMİ VE MÜHENDİSLİĞİ","MALZEME BİLİMİ VE NANOTEKNOLOJİ MÜHENDİSLİĞİ","MALZEME BİLİMİ VE TEKNOLOJİLERİ","MALZEME MÜHENDİSLİĞİ","MATEMATİK","MATEMATİK MÜHENDİSLİĞİ","MATEMATİK ÖĞRETMENLİĞİ","MATEMATİK VE BİLGİSAYAR BİLİMLERİ","MATEMATİK-BİLGİSAYAR","MEDYA VE GÖRSEL SANATLAR","MEDYA VE İLETİŞİM(FAKÜLTE)","MEDYA VE İLETİŞİM(YÜKSEKOKUL)","MEKATRONİK MÜHENDİSLİĞİ","MEKATRONİK MÜHENDİSLİĞİ(M.T.O.K.)","MEKATRONİK SİSTEMLER MÜHENDİSLİĞİ","METALURJİ VE MALZEME MÜHENDİSLİĞİ","METALURJİ VE MALZEME MÜHENDİSLİĞİ(M.T.O.K.)","METEOROLOJİ MÜHENDİSLİĞİ","MİMARLIK","MODA TASARIMI(FAKÜLTE)","MODA TASARIMI(M.T.O.K.)","MODA TASARIMI(YÜKSEKOKUL)","MODA VE TEKSTİL TASARIMI","MOLEKÜLER BİYOLOJİ VE GENETİK","MOLEKÜLER BİYOTEKNOLOJİ","MUHASEBE BİLGİ SİSTEMLERİ(YÜKSEKOKUL)","MUHASEBE VE DENETİM(FAKÜLTE)","MUHASEBE VE DENETİM(YÜKSEKOKUL)","MUHASEBE VE FİNANS YÖNETİMİ(FAKÜLTE)","MUHASEBE VE FİNANS YÖNETİMİ(YÜKSEKOKUL)","MUHASEBE(FAKÜLTE)","MUHASEBE(YÜKSEKOKUL)","MUTFAK SANATLARI VE YÖNETİMİ(İNGİLİZCE)","MÜHENDİSLİK PROGRAMLARI","MÜHENDİSLİK VE DOĞA BİLİMLERİ PROGRAMLARI","MÜTERCİM-TERCÜMANLIK(FAKÜLTE)","MÜTERCİM-TERCÜMANLIK(YÜKSEKOKUL)","MÜZECİLİK","NANOBİLİM VE NANOTEKNOLOJİ","NANOTEKNOLOJİ MÜHENDİSLİĞİ","NÜKLEER ENERJİ MÜHENDİSLİĞİ","ODYOLOJİ(FAKÜLTE)","ODYOLOJİ(YÜKSEKOKUL)","OKUL ÖNCESİ ÖĞRETMENLİĞİ","OPTİK VE AKUSTİK MÜHENDİSLİĞİ","ORGANİK TARIM İŞLETMECİLİĞİ(FAKÜLTE)","ORGANİK TARIM İŞLETMECİLİĞİ(YÜKSEKOKUL)","ORMAN ENDÜSTRİSİ MÜHENDİSLİĞİ","ORMAN MÜHENDİSLİĞİ","ORTEZ-PROTEZ(FAKÜLTE)","ORTEZ-PROTEZ(YÜKSEKOKUL)","OTEL YÖNETİCİLİĞİ(YÜKSEKOKUL)","OTOMOTİV MÜHENDİSLİĞİ","OTOMOTİV MÜHENDİSLİĞİ(M.T.O.K.)","ÖZEL EĞİTİM ÖĞRETMENLİĞİ","PAZARLAMA(FAKÜLTE)","PAZARLAMA(YÜKSEKOKUL)","PERFÜZYON(FAKÜLTE)","PERFÜZYON(YÜKSEKOKUL)","PETROL VE DOĞALGAZ MÜHENDİSLİĞİ","PEYZAJ MİMARLIĞI","PİLOTAJ(FAKÜLTE)","PİLOTAJ(YÜKSEKOKUL)","POLİMER MÜHENDİSLİĞİ","POLİTİKA VE EKONOMİ","POLONYA DİLİ VE KÜLTÜRÜ","PROTOHİSTORYA VE ÖN ASYA ARKEOLOJİSİ","PSİKOLOJİ","PSİKOLOJİK DANIŞMANLIK VE REHBERLİK","PSİKOLOJİK DANIŞMANLIK VE REHBERLİK ÖĞRETMENLİĞİ","RADYO VE TELEVİZYON","RADYO, TELEVİZYON VE SİNEMA","RAYLI SİSTEMLER MÜHENDİSLİĞİ","REHBERLİK VE PSİKOLOJİK DANIŞMANLIK","REKLAM TASARIMI VE İLETİŞİMİ","REKLAMCILIK","REKLAMCILIK(AÇIKÖĞRETİM)","REKLAMCILIK VE HALKLA İLİŞKİLER","REKREASYON YÖNETİMİ(FAKÜLTE)","REKREASYON YÖNETİMİ(M.T.O.K.)","REKREASYON YÖNETİMİ(YÜKSEKOKUL)","REKREASYON","RESTORASYON VE KONSERVASYON(YÜKSEKOKUL)","RUS DİLİ ÖĞRETMENLİĞİ","RUS DİLİ VE EDEBİYATI","RUS DİLİ VE EDEBİYATI ÖĞRETMENLİĞİ","RUS VE İNGİLİZ DİLLERİ VE EDEBİYATI","SAĞLIK YÖNETİMİ(AÇIKÖĞRETİM)","SAĞLIK YÖNETİMİ(FAKÜLTE)","SAĞLIK YÖNETİMİ(YÜKSEKOKUL)","SANAT TARİHİ","SANAT VE KÜLTÜR YÖNETİMİ","SANAT VE SOSYAL BİLİMLER PROGRAMLARI","SANAT YÖNETİMİ","SERAMİK TASARIMI","SERMAYE PİYASALARI VE PORTFÖY YÖNETİMİ(FAKÜLTE)","SERMAYE PİYASASI(YÜKSEKOKUL)","SEYAHAT İŞLETMECİLİĞİ VE TURİZM REHBERLİĞİ(FAKÜLTE)","SEYAHAT İŞLETMECİLİĞİ VE TURİZM REHBERLİĞİ(M.T.O.K.)","SEYAHAT İŞLETMECİLİĞİ VE TURİZM REHBERLİĞİ(YÜKSEKOKUL)","SEYAHAT İŞLETMECİLİĞİ(FAKÜLTE)","SEYAHAT İŞLETMECİLİĞİ(YÜKSEKOKUL)","SINIF ÖĞRETMENLİĞİ","SİGORTACILIK VE AKTÜERYA BİLİMLERİ(FAKÜLTE)","SİGORTACILIK VE AKTÜERYA BİLİMLERİ(YÜKSEKOKUL)","SİGORTACILIK VE RİSK YÖNETİMİ(FAKÜLTE)","SİGORTACILIK VE RİSK YÖNETİMİ(YÜKSEKOKUL)","SİGORTACILIK VE SOSYAL GÜVENLİK","SİGORTACILIK(YÜKSEKOKUL)","SİNEMA VE DİJİTAL MEDYA","SİNEMA VE TELEVİZYON","SİNOLOJİ","SİYASAL BİLİMLER VE ULUSLARARASI İLİŞKİLER(AÇIKÖĞRETİM)","SİYASAL BİLİMLER VE ULUSLARARASI İLİŞKİLER","SİYASET BİLİMİ","SİYASET BİLİMİ VE KAMU YÖNETİMİ","SİYASET BİLİMİ VE ULUSLARARASI İLİŞKİLER","SOSYAL BİLGİLER ÖĞRETMENLİĞİ","SOSYAL HİZMET(FAKÜLTE)","SOSYAL HİZMET(FAKÜLTE)(AÇIKÖĞRETİM)","SOSYAL HİZMET(YÜKSEKOKUL)","SOSYAL VE SİYASAL BİLİMLER","SOSYOLOJİ","SOSYOLOJİ(AÇIKÖĞRETİM)","SPOR BİLİMLERİ","SPOR YÖNETİCİLİĞİ(FAKÜLTE)","SPOR YÖNETİCİLİĞİ(YÜKSEKOKUL)","SU BİLİMLERİ MÜHENDİSLİĞİ","SU ÜRÜNLERİ MÜHENDİSLİĞİ","SÜMEROLOJİ","SÜRYANİ DİLİ VE EDEBİYATI","SÜT TEKNOLOJİSİ","ŞEHİR VE BÖLGE PLANLAMA","TAKI TASARIMI(FAKÜLTE)","TAPU KADASTRO(YÜKSEKOKUL)","TARIM EKONOMİSİ","TARIM MAKİNELERİ VE TEKNOLOJİLERİ MÜHENDİSLİĞİ","TARIM TİCARETİ VE İŞLETMECİLİĞİ","TARIMSAL BİYOTEKNOLOJİ","TARIMSAL GENETİK MÜHENDİSLİĞİ","TARIMSAL YAPILAR VE SULAMA","TARİH","TARİH ÖĞRETMENLİĞİ","TARİH ÖNCESİ ARKEOLOJİSİ","TARİH(AÇIKÖĞRETİM)","TARLA BİTKİLERİ","TAŞINABİLİR KÜLTÜR VARLIKLARINI KORUMA VE ONARIM","TEKNOLOJİ VE BİLGİ YÖNETİMİ","TEKSTİL MÜHENDİSLİĞİ","TEKSTİL TASARIMI","TEKSTİL TASARIMI(M.T.O.K.)","TEKSTİL VE MODA TASARIMI","TELEVİZYON HABERCİLİĞİ VE PROGRAMCILIĞI(FAKÜLTE)","TELEVİZYON HABERCİLİĞİ VE PROGRAMCILIĞI(YÜKSEKOKUL)","TIP","TIP MÜHENDİSLİĞİ","TİYATRO ELEŞTİRMENLİĞİ VE DRAMATURJİ(FAKÜLTE)","TOHUM BİLİMİ VE TEKNOLOJİSİ","TOPRAK BİLİMİ VE BİTKİ BESLEME","TURİZM İŞLETMECİLİĞİ VE OTELCİLİK(YÜKSEKOKUL)","TURİZM İŞLETMECİLİĞİ(FAKÜLTE)","TURİZM İŞLETMECİLİĞİ(FAKÜLTE)(M.T.O.K.)","TURİZM İŞLETMECİLİĞİ(YÜKSEKOKUL)","TURİZM REHBERLİĞİ(FAKÜLTE)","TURİZM REHBERLİĞİ(YÜKSEKOKUL)","TURİZM VE OTEL İŞLETMECİLİĞİ(FAKÜLTE)","TURİZM VE OTEL İŞLETMECİLİĞİ(YÜKSEKOKUL)","TURİZM VE OTELCİLİK(FAKÜLTE)","TÜRK DİLİ VE EDEBİYATI","TÜRK DİLİ VE EDEBİYATI ÖĞRETMENLİĞİ","TÜRK DİLİ VE EDEBİYATI(AÇIKÖĞRETİM)","TÜRK HALKBİLİMİ","TÜRK İSLAM ARKEOLOJİSİ","TÜRKÇE ÖĞRETMENLİĞİ","TÜRKOLOJİ","TÜTÜN EKSPERLİĞİ(YÜKSEKOKUL)","UÇAK BAKIM VE ONARIM","UÇAK ELEKTRİK-ELEKTRONİK(FAKÜLTE)","UÇAK ELEKTRİK-ELEKTRONİK(YÜKSEKOKUL)","UÇAK GÖVDE-MOTOR BAKIM(FAKÜLTE)","UÇAK GÖVDE-MOTOR BAKIM(YÜKSEKOKUL)","UÇAK MÜHENDİSLİĞİ","UÇAK VE UZAY MÜHENDİSLİĞİ","UKRAYNA DİLİ VE EDEBİYATI","ULAŞTIRMA MÜHENDİSLİĞİ","ULAŞTIRMA VE LOJİSTİK(FAKÜLTE)","ULAŞTIRMA VE LOJİSTİK(YÜKSEKOKUL)","ULUSLARARASI EKONOMİ","ULUSLARARASI EKONOMİK İLİŞKİLER","ULUSLARARASI FİNANS VE BANKACILIK(FAKÜLTE)","ULUSLARARASI FİNANS VE BANKACILIK(YÜKSEKOKUL)","ULUSLARARASI FİNANS(FAKÜLTE)","ULUSLARARASI FİNANS(YÜKSEKOKUL)","ULUSLARARASI GİRİŞİMCİLİK","ULUSLARARASI İLİŞKİLER","ULUSLARARASI İLİŞKİLER(AÇIKÖĞRETİM)","ULUSLARARASI İŞLETME YÖNETİMİ","ULUSLARARASI İŞLETMECİLİK(FAKÜLTE)","ULUSLARARASI İŞLETMECİLİK VE TİCARET(FAKÜLTE)","ULUSLARARASI İŞLETMECİLİK VE TİCARET(YÜKSEKOKUL)","ULUSLARARASI LOJİSTİK VE TAŞIMACILIK(FAKÜLTE)","ULUSLARARASI LOJİSTİK VE TAŞIMACILIK(YÜKSEKOKUL)","ULUSLARARASI LOJİSTİK YÖNETİMİ","ULUSLARARASI TİCARET VE FİNANS","ULUSLARARASI TİCARET VE İŞLETMECİLİK(FAKÜLTE)","ULUSLARARASI TİCARET VE İŞLETMECİLİK (YÜKSEKOKUL)","ULUSLARARASI TİCARET VE LOJİSTİK YÖNETİMİ(AÇIKÖĞRETİM)","ULUSLARARASI TİCARET VE LOJİSTİK YÖNETİMİ(FAKÜLTE)","ULUSLARARASI TİCARET VE LOJİSTİK YÖNETİMİ(YÜKSEKOKUL)","ULUSLARARASI TİCARET VE LOJİSTİK(FAKÜLTE)","ULUSLARARASI TİCARET VE LOJİSTİK(YÜKSEKOKUL)","ULUSLARARASI TİCARET(FAKÜLTE)","ULUSLARARASI TİCARET(YÜKSEKOKUL)","ULUSLARARASI ULAŞTIRMA SİSTEMLERİ","URDU DİLİ VE EDEBİYATI","UZAY BİLİMLERİ VE TEKNOLOJİLERİ","UZAY MÜHENDİSLİĞİ","VETERİNERLİK","YABAN HAYATI EKOLOJİSİ VE YÖNETİMİ","YAPAY ZEKA MÜHENDİSLİĞİ","YAZILIM GELİŞTİRME","YAZILIM MÜHENDİSLİĞİ","YAZILIM MÜHENDİSLİĞİ(M.T.O.K.)","YENİ MEDYA VE GAZETECİLİK(FAKÜLTE)","YENİ MEDYA VE GAZETECİLİK(YÜKSEKOKUL)","YENİ MEDYA VE İLETİŞİM","YENİ MEDYA(FAKÜLTE)","YENİ MEDYA(YÜKSEKOKUL)","YER BİLİMLERİ MÜHENDİSLİĞİ PROGRAMLARI","YEREL YÖNETİMLER","YİYECEK-İÇECEK İŞLETMECİLİĞİ(FAKÜLTE)","YİYECEK-İÇECEK İŞLETMECİLİĞİ(YÜKSEKOKUL)","YÖNETİM BİLİMLERİ PROGRAMLARI","YÖNETİM BİLİŞİM SİSTEMLERİ(FAKÜLTE)(AÇIKÖĞRETİM)","YÖNETİM BİLİŞİM SİSTEMLERİ(FAKÜLTE)","YÖNETİM BİLİŞİM SİSTEMLERİ(YÜKSEKOKUL)","YUNAN DİLİ VE EDEBİYATI","ZAZA DİLİ VE EDEBİYATI","ZİRAAT MÜHENDİSLİĞİ PROGRAMLARI","ZOOTEKNİ"};
    final List<Bolum> bolumler=new ArrayList<Bolum>();
    private AdView mAdView;
     List<Bolum> filteredBolumler;
     ListView listView2;
     CustomBolumAdapter filterBolumAdapter;
     PageViewModel pageViewModel;
    private InterstitialAd mInterstitialAd;
    private OnFragmentInteractionListener mListener;

    public BolumFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
  /*  public static BolumFragment newInstance(String param1, String param2) {
        BolumFragment fragment = new BolumFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
  public static BolumFragment newInstance()
  {
      return new BolumFragment();
  }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(getActivity().getApplicationContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-1124250551775434/3089259935");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

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
        return inflater.inflate(R.layout.fragment_bolum, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SearchView searchView=view.findViewById(R.id.bolumfragmentsearch);
        ListView listView=view.findViewById(R.id.bolumListView);
        listView2=view.findViewById(R.id.bolumListView);

        final ListView bolumListView=view.findViewById(R.id.bolumListView);
        final CustomBolumAdapter customBolumAdapter=new CustomBolumAdapter(getActivity(),bolumler);
        bolumListView.setAdapter(customBolumAdapter);

        bolumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), UniversiteProgramlarActivity.class);
                intent.putExtra("bolumAdi1",bolumler.get(position).getBolumAdi());
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
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }
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

 /*   @Override
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
