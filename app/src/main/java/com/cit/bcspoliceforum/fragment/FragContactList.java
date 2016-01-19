package com.cit.bcspoliceforum.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cit.bcspoliceforum.Communicator;
import com.cit.bcspoliceforum.R;
import com.cit.bcspoliceforum.database.DbHelper;
import com.cit.bcspoliceforum.database.HolderContact;

import java.util.ArrayList;

public class FragContactList extends Fragment {

    ImageView imgContactImage;
    TextView txtContactName, txtContactDesignation, txtContactPhone;
    ListView lvContactList;
    Context context;
    DbHelper dbHelper;
    ArrayList<HolderContact> listContact;
    int listCount = 0;
    int extraListCount = 0;
    Communicator com;

    int[] alpha = new int[27];

    public FragContactList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_contact_list, container, false);
        lvContactList = (ListView) view.findViewById(R.id.lv_contact_list);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        com = (Communicator) getActivity();
        init();
    }

    private void init(){
        context = getActivity();
        dbHelper = new DbHelper(context);

        listContact = dbHelper.getContact();

        listCount = listContact.size();

        lvContactList.setAdapter(new populateContactInformation());

        lvContactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listContact.get(i).getId() != -1) {
//                    Toast.makeText(context, listContact.get(i).getName(), Toast.LENGTH_LONG).show();

                    Bundle args = new Bundle();
                    args.putInt("id", listContact.get(i).getId());
                    Fragment toFragment = new FragProfile();
                    toFragment.setArguments(args);

                    com.action(toFragment);
                }
            }
        });
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
            return listContact.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            HolderContact data = (HolderContact) getItem(position);
            View layout = convertView;
            if(data.getId() != -1) {
                char firstChar = data.getName().toUpperCase().charAt(0);
                int firstCharInt = firstChar;

                if (alpha[firstChar - 65] != 1) {

                    alpha[firstChar - 65] = 1;
                    listContact.add(position, new HolderContact().setName(firstChar+"") );
                    notifyDataSetChanged();

//                listCount++;
//                extraListCount++;
//                LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//                layout = mInflater.inflate(R.layout.item_divider_alphabet, null);
//                TextView tvAlpha = (TextView) layout.findViewById(R.id.tv_list_alpha);
//                tvAlpha.setText(firstChar+"");
//                return layout;
                }
                data = (HolderContact) getItem(position);
            }


            if(data.getId() == -1){
                LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                layout = mInflater.inflate(R.layout.item_divider_alphabet, null);
                TextView tvAlpha = (TextView) layout.findViewById(R.id.tv_list_alpha);
                tvAlpha.setText(data.getName()+"");
                return layout;
            }else {
                LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                layout = mInflater.inflate(R.layout.item_contact, null);

                ImageView imgContactPic = (ImageView) layout.findViewById(R.id.imgContantImage);
                TextView txtContactName = (TextView) layout.findViewById(R.id.txtContantName);
                TextView txtContactDesignation = (TextView) layout.findViewById(R.id.txtContantDesignation);
                TextView txtContactPhone = (TextView) layout.findViewById(R.id.txtContantPhoneNumber);
                TextView txtContactId = (TextView) layout.findViewById(R.id.txtContantId);

                //imgContactPic.setImageResource(data.);
                txtContactName.setText(data.getName());
                txtContactDesignation.setText(data.getPosition());
                txtContactPhone.setText(data.getPhone());
                txtContactId.setText(data.getDisplayId());

                return layout;
            }
        }
    }
}
