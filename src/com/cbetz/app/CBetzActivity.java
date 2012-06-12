package com.cbetz.app;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;

public class CBetzActivity extends SherlockFragmentActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Sherlock);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_navigation);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        Tab tabMe = getSupportActionBar().newTab();
        tabMe.setTag("me");
        String tabText = "Me";
        tabMe.setText(tabText);
        tabMe.setTabListener(new TabListener<MeFragment>(CBetzActivity.this, "me", MeFragment.class));

        Tab tabResume = getSupportActionBar().newTab();
        tabResume.setTag("resume");
        String tabText2 = "Resume";
        tabResume.setText(tabText2);
        tabResume.setTabListener(new TabListener<ResumeFragment>(CBetzActivity.this, "resume", ResumeFragment.class));
        
        getSupportActionBar().addTab(tabMe);
        getSupportActionBar().addTab(tabResume);       
    }
}