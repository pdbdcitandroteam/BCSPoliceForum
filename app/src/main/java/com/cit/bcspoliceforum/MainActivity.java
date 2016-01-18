package com.cit.bcspoliceforum;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.cit.bcspoliceforum.database.DbHelper;
import com.cit.bcspoliceforum.database.HolderContact;
import com.cit.bcspoliceforum.fragment.FragContactList;

import org.json.JSONObject;

public class MainActivity extends FragmentActivity{

    Context context;

    DbHelper dbHelper;

    public static final String SHARED_PREFERENCES_NAME = "bcs_memory";
    public static final String SP_INITIATED = "sp_initiated";

    SharedPreferences sharedPreferences;

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
        context = MainActivity.this;
        dbHelper = new DbHelper(context);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        if(true || !sharedPreferences.contains(SP_INITIATED) || !sharedPreferences.getBoolean(SP_INITIATED,false)) {

            String[] contactList = getResources().getStringArray(R.array.contacts);

            if(contactList.length > 0) {
                for(int i = 0; i < contactList.length; i++ ) {
                    String contactJson = contactList[i];

                    try {
                        JSONObject root = new JSONObject(contactJson);
                        HolderContact holderContact = new HolderContact(
                                root.getInt("id"),
                                root.getString("displayId"),
                                root.getString("name"),
                                root.getString("father"),
                                root.getString("mother"),
                                root.getString("address"),
                                root.getString("phone"),
                                root.getString("email"),
                                root.getString("position"),
                                root.getString("posting"),
                                root.getString("bloodGroup"),
                                root.getString("photo"),
                                false,
                                "",
                                "",
                                false
                        );
                        dbHelper.insertContact(holderContact);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sharedPreferences.edit().putBoolean(SP_INITIATED, true).commit();
            }
        }

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
