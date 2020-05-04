package com.example.weather;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private Button btn2;
    private Fragment2 fragment2;
    private TextView textPressure;
    private TextView textSpeed;
    private TextView textCity;
    private Button btnGo;
    RecyclerView recyclerView;

    public Fragment1() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragment2 = new Fragment2();
        View view = inflater.inflate(R.layout.fragment_1, null);
getView();
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

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        WeatherSource ws = new WeatherSource(getResources());
        ArrayList weather = ws.build().getListWeather();

        WeatherAdapter weatherAdapter = new WeatherAdapter(weather);

        recyclerView.setAdapter(weatherAdapter);

       //декоратор-------------
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getActivity().getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);
        //----------------------
        return view;
    }



    private void viewTextPresSpeed() {
        if(MainActivity.isSwitchPress()) textPressure.setVisibility(View.VISIBLE);
        else textPressure.setVisibility(View.INVISIBLE);

        if(MainActivity.isSwitchSpeed()) textSpeed.setVisibility(View.VISIBLE);
        else textSpeed.setVisibility(View.INVISIBLE);
    }
}
