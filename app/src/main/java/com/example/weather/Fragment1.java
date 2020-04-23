package com.example.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    Button btn2;
    Fragment2 fragment2;
    TextView textPressure;
    TextView textSpeed;
    TextView textCity;
    Button btnGo;

    public Fragment1() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragment2 = new Fragment2();
        View view = inflater.inflate(R.layout.fragment_1, null);
        textPressure = view.findViewById(R.id.textView10);
        textSpeed = view.findViewById(R.id.textView9);
        btn2 = view.findViewById(R.id.button2);
        btnGo = view.findViewById(R.id.buttonGo);
        textCity = view.findViewById(R.id.textView2);

        textCity.setText(MainActivity.getSity());


        viewTextPresSpeed();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.fragment_container, fragment2);
                ft.addToBackStack("");
                ft.commit();
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String site = "https://yandex.ru/pogoda/krasnodar";
                Uri uri = Uri.parse(site);
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });

        return view;
    }

    private void viewTextPresSpeed() {
        if(MainActivity.isSwitchPress()) textPressure.setVisibility(View.VISIBLE);
        else textPressure.setVisibility(View.INVISIBLE);

        if(MainActivity.isSwitchSpeed()) textSpeed.setVisibility(View.VISIBLE);
        else textSpeed.setVisibility(View.INVISIBLE);
    }
}
