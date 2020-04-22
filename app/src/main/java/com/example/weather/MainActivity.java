package com.example.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Fragment2 fragment2;
    private static boolean switchPress = false;
    private static boolean switchSpeed = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment2 = new Fragment2();
        startMainFragment();
    }

    private void startMainFragment() {
        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    public static void setSwitchSpeed(boolean switchSpeed) {
        MainActivity.switchSpeed = switchSpeed;
    }

    public static boolean isSwitchSpeed() {
        return switchSpeed;
    }

    public static void setSwitchPress(boolean switchPress) {
        MainActivity.switchPress = switchPress;
    }

    public static boolean isSwitchPress() {
        return switchPress;
    }


}
