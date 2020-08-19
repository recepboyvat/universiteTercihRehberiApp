package com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.EditText;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;


import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import com.google.firebase.firestore.QuerySnapshot;

import com.recepboyvat.universitesiralamalarivepuanlari.Authentication.GirisYapActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.Authentication.KayitOlActivity;
import com.recepboyvat.universitesiralamalarivepuanlari.ProgramDetaylari.ui.main.PageViewModel;
import com.recepboyvat.universitesiralamalarivepuanlari.R;
import com.recepboyvat.universitesiralamalarivepuanlari.Yorum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link YorumlarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YorumlarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YorumlarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int programKodu;
    PageViewModel pageViewModel;
    TextView internetTextView;
    EditText yorumEditText;
    Button yorumYapBtn;
    ListView yorumlarListView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    private AdView mAdView;

    ListView listView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public YorumlarFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
 /*   public static YorumlarFragment newInstance(String param1, String param2) {
        YorumlarFragment fragment = new YorumlarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
 public static YorumlarFragment newInstance()
 {
     return new YorumlarFragment();
 }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel= ViewModelProviders.of(requireActivity()).get(PageViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yorumlar, container, false);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

     super.onViewCreated(view, savedInstanceState);
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

     Intent intent=getActivity().getIntent();
     programKodu=intent.getIntExtra("programKodu",0);
     internetTextView=view.findViewById(R.id.internetTextView);
     yorumEditText=view.findViewById(R.id.yorumEditText);
     yorumYapBtn=view.findViewById(R.id.yorumYapBtn);
     listView=view.findViewById(R.id.yorumlarListView);
     firebaseAuth=FirebaseAuth.getInstance();
     firebaseUser=firebaseAuth.getCurrentUser();


     if(internetBaglantisi())
     {
         internetTextView.setTextColor(R.color.green);
         internetTextView.setText("İnternet var");
         yorumlariGetir();



         yorumYapBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(kullaniciGirisi())
                 {
                     kullaniciBilgileriGetir();

                 }
                 else
                 {
                     Toast.makeText(getActivity().getApplicationContext(),"Yorum yapmak için kullanici girisi yapmalisiniz",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getActivity().getApplicationContext(),KayitOlActivity.class);
                    startActivity(intent);
                 }


             }
         });
     }
     else
     {
         internetTextView.setTextColor(R.color.red);
         internetTextView.setText("Lütfen internet bağlantınızı kontrol edin");

     }






 }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
     /*   if (context instanceof OnFragmentInteractionListener) {
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

    public boolean internetBaglantisi()
    {
        ConnectivityManager cm =
                (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
}
public boolean yorumDoluMu()
{
    String yorum=yorumEditText.getText().toString();
    if(yorum.equals("")||yorum.length()<6||yorum.length()>300)
    {
        Toast.makeText(getActivity().getApplicationContext(),"Yorumlar 6 karakterden kısa olamaz",Toast.LENGTH_LONG).show();
        return false;
    }
    return true;
}

public boolean kullaniciGirisi()
{
    FirebaseUser user=firebaseAuth.getCurrentUser();
    if(user==null)
    {
        Toast.makeText(getActivity().getApplicationContext(),"Yorum eklemek için kullanici girisi yapmalisiniz",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getActivity().getApplicationContext(), GirisYapActivity.class);
        startActivity(intent);
        return false;
    }
    else {
        return true;
    }
}

public void kullaniciBilgileriGetir()
{ FirebaseFirestore firebaseFirestore1=FirebaseFirestore.getInstance();
   CollectionReference collectionReference=firebaseFirestore1.collection("Users");
   collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
       @Override
       public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
           if(e!=null)
           {
               e.printStackTrace();
               Toast.makeText(getActivity().getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

           }
           else
           {
               if(queryDocumentSnapshots!=null){
                   for(DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments())
                   {
                       Map<String,Object> kullanici=snapshot.getData();
                       String veritabaniEmail=(String)kullanici.get("useremail");
                       String veritabaniUserName=(String)kullanici.get("username");
                     //  Timestamp date= (Timestamp) kullanici.get("yorumTarihi");
                       int veritabaniCinsiyet=snapshot.getLong("gender").intValue();
                       if(veritabaniEmail.equals(firebaseUser.getEmail()))
                       {
                           yorumEkle(yorumEditText.getText().toString(),firebaseUser.getEmail(),veritabaniUserName,veritabaniCinsiyet);

                       }

                   }
               }
           }
       }
   });


}
public void yorumEkle(String yorum, String email, String username, int cinsiyet)
{
    Map<String,Object> yorumSon=new HashMap<>();
    yorumSon.put("yorumMetin",yorum);
    yorumSon.put("yorumKullaniciAdi",username);
    yorumSon.put("yorumKullaniciMail",email);
    yorumSon.put("yorumCinsiyet",cinsiyet);
    yorumSon.put("yorumTarihi",FieldValue.serverTimestamp());
    yorumSon.put("programKodu",programKodu);
    FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();

    if(yorumDoluMu()) {
        firebaseFirestore.collection("Comments").document().set(yorumSon).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getActivity().getApplicationContext(), "Yorumunuz eklendi", Toast.LENGTH_LONG).show();
                yorumEditText.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity().getApplicationContext(), "Yorum eklenirken hata olustu", Toast.LENGTH_LONG).show();
            }
        });
    }
    else
    {
        Toast.makeText(getActivity().getApplicationContext(),"Yorumlar 6 karakterden kısa veya 300 karakterden uzun olamaz",Toast.LENGTH_LONG).show();
    }
}
public void yorumlariGetir()
{
    final FirebaseFirestore firebaseFirestore1=FirebaseFirestore.getInstance();
    CollectionReference collectionReference=firebaseFirestore1.collection("Comments");
    collectionReference.orderBy("yorumTarihi", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
        @Override
        public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
            if(e!=null)
            {
                e.printStackTrace();
                Toast.makeText(getActivity().getApplicationContext(),e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

            }
            else
            {
                if(queryDocumentSnapshots!=null){
                    List<Yorum> yorumlar=new ArrayList<Yorum>();

                    for(DocumentSnapshot snapshot:queryDocumentSnapshots.getDocuments())
                    {
                        Map<String,Object> kullanici=snapshot.getData();

                        int programK=snapshot.getLong("programKodu").intValue();
                        String yorum=(String) snapshot.get("yorumMetin");
                        String yorumKullaniciAdi=(String)snapshot.get("yorumKullaniciAdi");
                        int yorumCinsiyet=snapshot.getLong("yorumCinsiyet").intValue();

                        Timestamp timestamp=snapshot.getTimestamp("yorumTarihi");
                        if(timestamp!=null)
                        {
                            if(programK==programKodu)
                            {

                                yorumlar.add(new Yorum(programKodu,yorumKullaniciAdi,timestamp,yorum,yorumCinsiyet));

                            }

                        }




                    }
                    YorumAdapter adapter=new YorumAdapter(getActivity(),yorumlar);
                    listView=getView().findViewById(R.id.yorumlarListView);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }

            }
        }
    });



}







}
