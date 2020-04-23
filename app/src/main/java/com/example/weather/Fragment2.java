package com.example.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
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
    Button btnDark;
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
        TextView textCity = view.findViewById(R.id.textView6);

//        String msk = (String) getText(R.string.MSK);
//        String spb = (String) getText(R.string.SPB);
//        String krd = (String) getText(R.string.CRD);
//        final String[] data = {msk, spb, krd};

        String[] data = getResources().getStringArray(R.array.arrayCity);
        spinerMethod(textCity, data);

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

    private void spinerMethod(final TextView t6, final String[] data) {
        //адаптер----------------------------------------------------
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) view.findViewById(R.id.spiner);
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
                    case 0: t6.setText(data[position]);
                        break;

                    case 1: t6.setText(data[position]);
                        break;

                    case 2: t6.setText(data[position]);
                        break;
                }
                MainActivity.setSity(t6.getText().toString());
                MainActivity.setPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }




}
