package com.example.lab6_7;

import android.os.Bundle; // Bundle
import androidx.appcompat.app.AppCompatActivity; // базовая Activity

import androidx.viewpager2.widget.ViewPager2; // компонент свайпа страниц
import com.google.android.material.tabs.TabLayout; // вкладки сверху
import com.google.android.material.tabs.TabLayoutMediator; // связывает вкладки и ViewPager2

public class TabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        TabsPagerAdapter adapter = new TabsPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText(R.string.tab_feed);
            if (position == 1) tab.setText(R.string.tab_photo);
            if (position == 2) tab.setText(R.string.tab_map);
        }).attach();
    }
}