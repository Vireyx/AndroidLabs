package com.example.lab6_7;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsPagerAdapter extends FragmentStateAdapter {

    public TabsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) return new FeedFragment();
        if (position == 1) return new PhotoFragment();
        return new MapFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}