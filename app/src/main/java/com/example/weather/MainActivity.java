package com.example.weather;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.weather.data.Request;
import com.example.weather.fragments.Fragment1;
import com.example.weather.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {
    private Fragment2 fragment2;

    private static boolean switchTheme = false;
    private static String sity = "Москва";
    private static int position = 0;

    public Singleton singleton;

    Request req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        singleton = Singleton.getSingleton();
        Log.e("sing", String.valueOf(singleton));

        if(switchTheme)setTheme(R.style.AppDarkTheme);
        else setTheme(R.style.AppTheme);

        setContentView(R.layout.activity_main);
        fragment2 = new Fragment2();
        startMainFragment();

        req = new Request();
    }

    private void startMainFragment() {
        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }









    public static void setPosition(int position) {
        MainActivity.position = position;
    }

    public static int getPosition() {
        return position;
    }

    public static void setSity(String sity) {
        MainActivity.sity = sity;
    }

    public static String getSity() {
        return sity;
    }

    public static void setSwitchTheme(boolean switchTheme) {
        MainActivity.switchTheme = switchTheme;
    }

    public static boolean isSwitchTheme() {
        return switchTheme;
    }

    public Request getReq() {
        return req;
    }


}




