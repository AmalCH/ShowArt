package triki.showart.Artist;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import triki.showart.R;


public class ArtistFrag extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    public static int int_items = 3 ;
    private int[] tabIcons = {
            R.drawable.ic_all_artist,
            R.drawable.ic_followers,
            R.drawable.ic_following
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_artist, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.pagerArtistList);
        tabLayout= (TabLayout) view.findViewById(R.id.tabLayoutArtist);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        return view;
    }

private void setupTabIcons(){
    TextView tabOne = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_tab, null);
    tabOne.setText("All Artist");
    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_all_artist, 0, 0);
    tabLayout.getTabAt(0).setCustomView(tabOne);

    TextView tabTwo = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_tab, null);
    tabTwo.setText("Followers");
    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_followers, 0, 0);
    tabLayout.getTabAt(1).setCustomView(tabTwo);

    TextView tabThree = (TextView) LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.custom_tab, null);
    tabThree.setText("Following");
    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_following, 0, 0);
    tabLayout.getTabAt(2).setCustomView(tabThree);



}
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new AllArtistFrag(), "All Artists");
        adapter.addFrag(new FollowersArtistFrag(), "Followers");
        adapter.addFrag(new FollowingArtistFrag(), "Followings");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
