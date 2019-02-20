package com.gzeinnumer.mystore.PageHomeOnline;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzeinnumer.mystore.R;

public class HomeFragmentOnline extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;


    Context context;

    View view;

    public HomeFragmentOnline() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_online, container, false);


        context = view.getContext();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.containerOnline);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabsOnline);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        return view;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Komputer page1 = new Komputer();
                    return page1;
                default:
                    Komputer pageDef = new Komputer();
                    return pageDef;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }
    }
}
