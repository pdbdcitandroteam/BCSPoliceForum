package com.cit.bcspoliceforum.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cit.bcspoliceforum.R;
import com.cit.bcspoliceforum.database.DbHelper;
import com.cit.bcspoliceforum.database.HolderContact;

/**
 * Created by CIT on 1/19/2016.
 */
public class FragProfile extends Fragment {

    TextView PoliceName,PoliceDesignation,PoliceFatherName,PoliceMotherName,PoliceAddress,PolicePhone1,PolicePhone2,PolicePhone3,PoliceEmail,
    PolicePosting,PolicePositioning,PoliceDateOfJoin;
    ImageView PolicePhoto;
    Context context;

    DbHelper dbHelper;
    HolderContact listContact;
    public FragProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_frag_profile, container, false);

        context = getActivity();
        PoliceName = (TextView) v.findViewById(R.id.police_name);
        PoliceDesignation = (TextView) v.findViewById(R.id.police_designation);
        PoliceFatherName = (TextView) v.findViewById(R.id.police_fName);
        PoliceMotherName = (TextView) v.findViewById(R.id.police_mname);
        PoliceAddress = (TextView) v.findViewById(R.id.police_address);
        PolicePhone1 = (TextView) v.findViewById(R.id.police_phone1);
        PolicePhone2 = (TextView) v.findViewById(R.id.police_phone2);
        PolicePhone3 = (TextView) v.findViewById(R.id.police_phone3);
        PoliceEmail = (TextView) v.findViewById(R.id.police_email);
        PolicePosting = (TextView) v.findViewById(R.id.police_posting);
        PolicePositioning = (TextView) v.findViewById(R.id.police_positioning);
        PoliceDateOfJoin = (TextView) v.findViewById(R.id.police_date_of_joining);

        PolicePhoto = (ImageView) v.findViewById(R.id.police_photo);

        //int id = bundle.getInt(, defaultValue);

//        PoliceName.setText(listContact.get(id).getName());
//        PoliceDesignation.setText(listContact.get(id).getPosition());
//        PoliceFatherName.setText(listContact.get(id).getFather());
//        PoliceMotherName.setText(listContact.get(id).getMother());
//        PoliceAddress.setText(listContact.get(id).getAddress());
//        PolicePhone1.setText(listContact.get(id).getPhone());
//        PoliceEmail.setText(listContact.get(id).getEmail());
//        PolicePosting.setText(listContact.get(id).getPosting());
//        PolicePositioning.setText(listContact.get(id).getPosition());
//       // PoliceDateOfJoin.setText(listContact.get(id).get());
//
//        //PolicePhoto.setImageURI(Uri.parse(listContact.get(id).getPhoto()));
//
//
//        // Inflate the layout for this fragment

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        context = getActivity();

        Bundle bundle = getArguments();
        int id = bundle.getInt("id");

        dbHelper = new DbHelper(context);
        listContact = dbHelper.getContact(id);

        PoliceName.setText(listContact.getName());
        PoliceDesignation.setText(listContact.getPosition());
        PoliceFatherName.setText(listContact.getFather());
        PoliceMotherName.setText(listContact.getMother());
        PoliceAddress.setText(listContact.getAddress());
        PolicePhone1.setText(listContact.getPhone());
        PoliceEmail.setText(listContact.getEmail());
        PolicePosting.setText(listContact.getPosting());
        PolicePositioning.setText(listContact.getPosition());
       // PoliceDateOfJoin.setText(listContact.get(id).get());
        Toast.makeText(context, id+" => "+listContact.getName(), Toast.LENGTH_LONG).show();
    }
}
