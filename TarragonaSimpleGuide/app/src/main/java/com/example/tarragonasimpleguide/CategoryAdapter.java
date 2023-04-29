package com.example.tarragonasimpleguide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link androidx.viewpager2.adapter.FragmentStateAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Option} objects.
 */

//public class CategoryAdapter extends  androidx.viewpager.widget.PagerAdapter {
public class CategoryAdapter extends FragmentPagerAdapter {
    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentsFragment();
        } else if (position == 1) {
            return new MuseumsFragment();
        } else if (position == 2) {
            return new LandscapesFragment();
        } else {
            return new InformationFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_monuments);
        } else if (position == 1) {
            return mContext.getString(R.string.category_museums);
        } else if (position == 2) {
            return mContext.getString(R.string.category_landscapes);
        } else {
            return mContext.getString(R.string.category_information);
        }
    }
}
