package com.cit.bcspoliceforum;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.cit.bcspoliceforum.fragment.FragContactList;

public class MainActivity extends FragmentActivity{

    DrawerLayout bcsDrawerLayout;
    RelativeLayout fragContainer;

    FragmentManager fragManager;
    Fragment fragment;

    FragmentTransaction fragTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bcsDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fragContainer = (RelativeLayout) findViewById(R.id.frag_container);

        fragManager = getSupportFragmentManager();

        fragTransaction = fragManager.beginTransaction();
        fragment = new FragContactList();
        fragTransaction.add(R.id.frag_container, fragment, "frag_contact_list");
        fragTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
