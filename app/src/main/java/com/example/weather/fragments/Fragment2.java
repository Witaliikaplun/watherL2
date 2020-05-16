package com.example.weather.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.weather.MainActivity;
import com.example.weather.R;
import com.example.weather.Singleton;
import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    private Button btn4;
    private Button btnDark;
    private Fragment1 fragment1;
    private View view;
    private Switch sPress;
    private Switch sSpeed;
    private Switch sHumi;
    private Switch sTheme;
    Spinner spinner;
    MainActivity act;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        act = (MainActivity) getContext();

        fragment1 = new Fragment1();
        view = inflater.inflate(R.layout.fragment_2, null);
        btn4 = view.findViewById(R.id.button4);

        sPress = view.findViewById(R.id.switchPress);
        sSpeed = view.findViewById(R.id.switchSpeed);
        sHumi = view.findViewById(R.id.switchHumi);
        sTheme = view.findViewById(R.id.switchTheme);
        TextView textCity = view.findViewById(R.id.textView6);

        String[] arrayCity = getResources().getStringArray(R.array.arrayCity);

        spinner = (Spinner) view.findViewById(R.id.spiner);
        spinerMethod(textCity, arrayCity, spinner);

        if(Singleton.getSingleton().getSwitchPress()) sPress.setChecked(true);
        else sPress.setChecked(false);

        if(Singleton.getSingleton().getSwitchHumil()) sHumi.setChecked(true);
        else sHumi.setChecked(false);

        if(Singleton.getSingleton().getSwitchSpeed()) sSpeed.setChecked(true);
        else sSpeed.setChecked(false);

        if(MainActivity.isSwitchTheme()) sTheme.setChecked(true);
        else sTheme.setChecked(false);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment1);
                //ft.addToBackStack("");
                ft.commit();
            }
        });

        sPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sPress.isChecked()) {
                    sPress.setChecked(false);
                    Snackbar.make(view, R.string.textchengPress,
                            Snackbar.LENGTH_LONG).setAction(R.string.show_button, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchPress(true);
                            sPress.setChecked(true);
                        }
                    }).show();
                }
                else {
                    sPress.setChecked(true);

                    Snackbar.make(view, R.string.textchengPress_2,
                            Snackbar.LENGTH_LONG).setAction(R.string.rem_pres, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchPress(false);
                            sPress.setChecked(false);
                        }
                    }).show();
                }
            }
        });

        sHumi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sHumi.isChecked()) {
                    sHumi.setChecked(false);
                    Snackbar.make(view, R.string.textshowHumi,
                            Snackbar.LENGTH_LONG).setAction(R.string.show_button, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchHumil(true);
                            sHumi.setChecked(true);
                        }
                    }).show();
                }
                else {
                    sHumi.setChecked(true);
                    Snackbar.make(view, R.string.textremiveHumi,
                            Snackbar.LENGTH_LONG).setAction(R.string.rem_pres, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchHumil(false);
                            sHumi.setChecked(false);
                        }
                    }).show();
                }
            }
        });

        sSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sSpeed.isChecked()){
                    sSpeed.setChecked(false);
                    Snackbar.make(view, R.string.show_speed,
                            Snackbar.LENGTH_LONG).setAction(R.string.show_button, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchSpeed(true);
                            sSpeed.setChecked(true);
                        }
                    }).show();
                }
                else{
                    sSpeed.setChecked(true);
                    Snackbar.make(view, R.string.rem_speed,
                            Snackbar.LENGTH_LONG).setAction(R.string.remove_but, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Singleton.getSingleton().setSwitchSpeed(false);
                            sSpeed.setChecked(false);
                        }
                    }).show();
                }
            }
        });

        sTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sTheme.isChecked()) MainActivity.setSwitchTheme(true);
                else MainActivity.setSwitchTheme(false);
                getActivity().recreate();// пересоздать активити
            }
        });
        return view;
    }



    private void spinerMethod(final TextView textCity, final String[] arrayCity, Spinner spinner) {
        //адаптер----------------------------------------------------
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, arrayCity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        // заголовок--------------------------------------------------
        spinner.setPrompt("Title");
        // выделяем элемент ------------------------------
        spinner.setSelection(MainActivity.getPosition());

        // устанавливаем обработчик нажатия---------------------------
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                switch (position){
                    case 0: textCity.setText(arrayCity[position]);
                        MainActivity.setPosition(0);
                        act.getReq().init();
                        break;

                    case 1: textCity.setText(arrayCity[position]);
                        MainActivity.setPosition(1);
                        act.getReq().init();
                        break;

                    case 2: textCity.setText(arrayCity[position]);
                        MainActivity.setPosition(2);
                        act.getReq().init();
                        break;
                }
                MainActivity.setSity(textCity.getText().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }




}
