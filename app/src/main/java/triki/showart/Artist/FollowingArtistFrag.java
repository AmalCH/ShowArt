package triki.showart.Artist;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import triki.showart.Compte.CompteFrag;
import triki.showart.R;


public class FollowingArtistFrag extends Fragment {

    public FollowingArtistFrag() {
        // Required empty public constructor
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_following_artist, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.following_menu_back) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.following_back_frame, new CompteFrag());
            ft.commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
