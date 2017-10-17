package com.teamjsnbd.ieltsassistor;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class RTFActivty1 extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
private TabLayout tabLayout;
private ViewPager viewPager;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtfactivty);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Passage 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Passage 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Passage 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(this);
        }

@Override
public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        }

@Override
public void onTabUnselected(TabLayout.Tab tab) {

        }

@Override
public void onTabReselected(TabLayout.Tab tab) {

        }
}

