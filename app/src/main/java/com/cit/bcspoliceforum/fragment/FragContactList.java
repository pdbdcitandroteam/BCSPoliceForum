package com.cit.bcspoliceforum.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cit.bcspoliceforum.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragContactList extends Fragment {

    public FragContactList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag_contact_list, container, false);
    }


}
