package com.cit.bcspoliceforum.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cit.bcspoliceforum.R;

public class FragContactList extends Fragment {

    ImageView imgContactImage;
    TextView txtContactName,txtContactDesignation,txtContactPhone;

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
    }
}
