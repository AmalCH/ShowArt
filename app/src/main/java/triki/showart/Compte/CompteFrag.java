package triki.showart.Compte;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import triki.showart.Artist.FollowersArtistFrag;
import triki.showart.Artist.FollowingArtistFrag;
import triki.showart.Login.SharedPreference;
import triki.showart.R;

public class CompteFrag extends Fragment {

    TextView mFollowing_lettre;
    TextView mFollowing_nbr;
    TextView mFollower_lettre;
    TextView mFollower_nbr;
    TextView mName_compte_view;
    GridView gridview;
    FloatingActionButton mEditCompte;
    CircleImageView circleImageView;
    SharedPreference sharedPreference;
    public CompteFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_compte, container, false);
   //     sharedPreference = new SharedPreference();


        mName_compte_view = (TextView) view.findViewById(R.id.nameView);

        //Retrieve a value from SharedPreference
//   String     mName_compte = sharedPreference.getValue(getActivity().getApplicationContext());
  //      mName_compte_view.setText(mName_compte);

        Bundle bundle= getActivity().getIntent().getExtras();
        if(bundle==null){
            return view;
        }
        String message=bundle.getString("email");
        mName_compte_view.setText(message);


        circleImageView= (CircleImageView) view.findViewById(R.id.imageView_profile);
        gridview = (GridView) view.findViewById(R.id.gridViewAlbumCompte);
        mFollower_lettre=(TextView)view.findViewById(R.id.followers_lettre);
        mFollower_nbr=(TextView)view.findViewById(R.id.followers_nbr);
        mFollowing_lettre=(TextView)view.findViewById(R.id.following_lettre);
        mFollowing_nbr=(TextView)view.findViewById(R.id.following_nbr);
        mEditCompte=(FloatingActionButton)view.findViewById(R.id.edit_compte);

        mFollower_nbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new FollowersArtistFrag());
                ft.commit();
            }
        });
        mFollower_lettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new FollowersArtistFrag());
                ft.commit();
            }
        });
        mFollower_nbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new FollowersArtistFrag());
                ft.commit();
            }
        });
        mFollowing_lettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new FollowingArtistFrag());
                ft.commit();
            }
        });
        mFollowing_nbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new FollowingArtistFrag());
                ft.commit();
            }
        });
        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(CompteFrag.this.getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        mEditCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frag_compte_frame, new Edit_compteFrag());
                ft.commit();
            }
        });
        // Inflate the layout for this fragment

        return view;
    }
    private List<ItemObject> getAllItemObject() {

        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("ONE", "one"));
        items.add(new ItemObject("TOW", "two"));
        items.add(new ItemObject("THREE", "three"));
        items.add(new ItemObject("FOOR", "two"));
        items.add(new ItemObject("TOW", "two"));
        items.add(new ItemObject("THREE", "one"));
        items.add(new ItemObject("FOOR", "two"));
        return items; }
}
