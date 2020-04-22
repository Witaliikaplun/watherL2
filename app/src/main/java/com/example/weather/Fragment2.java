package com.example.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    Button btn4;
    Fragment1 fragment1;
    View view;
    Switch s2Press;
    Switch s3Speed;
    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment1 = new Fragment1();
        view = inflater.inflate(R.layout.fragment_2, null);
        btn4 = view.findViewById(R.id.button4);
        s2Press = view.findViewById(R.id.switch2);
        s3Speed = view.findViewById(R.id.switch3);

        if(MainActivity.isSwitchPress()) s2Press.setChecked(true);
        else s2Press.setChecked(false);

        if(MainActivity.isSwitchSpeed()) s3Speed.setChecked(true);
        else s3Speed.setChecked(false);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment1);
                //ft.addToBackStack("");
                ft.commit();

            }
        });

        s2Press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s2Press.isChecked()) MainActivity.setSwitchPress(true);
                else MainActivity.setSwitchPress(false);
            }
        });

        s3Speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s3Speed.isChecked()) MainActivity.setSwitchSpeed(true);
                else MainActivity.setSwitchSpeed(false);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }




}
