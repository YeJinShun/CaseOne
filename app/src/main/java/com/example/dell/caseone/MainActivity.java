package com.example.dell.caseone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.caseone.adapter.FraAdapter;
import com.example.dell.caseone.fragment.CaseFragment;
import com.example.dell.caseone.fragment.HomeFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        initFra();

    }

    private void initFra() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new CaseFragment());
        tab.addTab(tab.newTab().setText("校门"));
        tab.addTab(tab.newTab().setText("关注"));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        FraAdapter adapter = new FraAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
    }
}
