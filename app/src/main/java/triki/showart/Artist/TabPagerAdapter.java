package triki.showart.Artist;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by HAJEUR on 22/03/2015.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }


    @Override
    public android.support.v4.app.Fragment getItem(int index)
    {
        switch (index)
        {
            case 0:
                return new AllArtistFrag();
            case 1:
                return new FollowersArtistFrag();
            case 2:
                return new FollowingArtistFrag();

        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}