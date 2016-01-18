package com.cit.bcspoliceforum.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cit.bcspoliceforum.R;

import java.util.ArrayList;

import database.DbHelper;
import database.HolderContact;

public class FragContactList extends Fragment {

    ImageView imgContactImage;
    TextView txtContactName,txtContactDesignation,txtContactPhone;
    ListView lstContactList;
    Context context;
    DbHelper dbHelper;
    ArrayList<HolderContact> listContact;

    public FragContactList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_contact_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imgContactImage = (ImageView) getActivity().findViewById(R.id.imgContantImage);
        txtContactName = (TextView) getActivity().findViewById(R.id.txtContantName);
        txtContactDesignation = (TextView) getActivity().findViewById(R.id.txtContantDesignation);
        txtContactPhone = (TextView) getActivity().findViewById(R.id.txtContantPhoneNumber);

        init();

    }

    private void init(){
        context = getActivity().getApplicationContext();
        lstContactList = (ListView) getActivity().findViewById(R.id.lstContactList);
        dbHelper = new DbHelper(context);


        listContact = dbHelper.getContact();

        lstContactList.setAdapter(new populateContactInformation());
    }


    class populateContactInformation extends BaseAdapter{

        @Override
        public int getCount() {
            return listContact.size();
        }

        @Override
        public Object getItem(int position) {
            return listContact.get(position);
        }

        @Override
        public long getItemId(int position) {
            return listContact.get(position).cont_ID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View layout = convertView;
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            if (layout == null) {
                layout = mInflater.inflate(R.layout.item_contact, null);
            }
            ImageView imgContactPic = (ImageView) layout.findViewById(R.id.imgContantImage);
            TextView txtContactName = (TextView) layout.findViewById(R.id.txtContantName);
            TextView txtContactDesignation = (TextView) layout.findViewById(R.id.txtContantDesignation);
            TextView txtContactPhone = (TextView) layout.findViewById(R.id.txtContantPhoneNumber);
            TextView txtContactId = (TextView) layout.findViewById(R.id.txtContantId);

            HolderContact data = (HolderContact) getItem(position);   // Change to the related Holder Name
            //imgContactPic.setImageResource(data.);
            txtContactName.setText(data.cont_name);
            txtContactDesignation.setText(data.cont_position);
            txtContactPhone.setText(data.cont_phone);
            txtContactId.setText(data.cont_display_id);

            return layout;
        }
    }
}
