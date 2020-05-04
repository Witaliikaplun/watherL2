package com.example.weather;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Fragment2 fragment2;
    private static boolean switchPress = false;
    private static boolean switchSpeed = false;
    private static String sity = "Москва";
    private static int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment2 = new Fragment2();
        //startMainFragment();
        startLoginFragment();

    }

    private void startMainFragment() {
        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    private void startLoginFragment() {
        FragmentLogin fragmentLogin = new FragmentLogin();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragmentLogin);
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

}




