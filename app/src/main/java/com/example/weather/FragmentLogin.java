package com.example.weather;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {
    TextInputEditText login ;
    TextInputEditText password ;
    // Регулярные выражения позволяют проверить на соответствие шаблону
// Это имя. Первая буква большая латинская, остальные маленькие латинские
    Pattern checkLogin = Pattern. compile ( "^[A-Z][a-z]{2,}$" );
    // Это пароль, минимум 6 символов, обязательны маленькая буква, большая буква, цифра
    Pattern checkPassword =
            Pattern. compile ( "^(?=^.{6,}$)(?=.* \\ d)(?=.*[a-z])(?=.*[A-Z])(?!.* \\ s).*$" );

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login = view.findViewById(R.id. inputLoginName );
        password = view.findViewById(R.id. inputPassword );
        Button btnOk = view.findViewById(R.id.butOK);

        //сделаем проверку при
        login .setOnFocusChangeListener( new View.OnFocusChangeListener() {
            //Как только фокус потерян, сразу проверяем на валидность данные
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return ;
                TextView tv = (TextView) v;

                validate(tv, checkLogin , "Это не имя!" );
            }
        });

        // Пароль тоже проверим при потере фокуса
        password .setOnFocusChangeListener( new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return ;
                TextView tv = (TextView) v;
// Валидация, почти точно такая же, как и в поле логина
                validate(tv, checkPassword , "Пароль слишком простой!" );
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainFragment();
            }
        });

        return view;
    }

    // Валидация
    private void validate(TextView tv, Pattern check, String message){
        String value = tv.getText().toString();
        if (check.matcher(value).matches()){ // Проверим на основе регулярных
            //выражений
            hideError(tv);
        }
        else {
            showError(tv, message);
        }
    }
    // Показать ошибку
    private void showError(TextView view, String message) {
        view.setError(message);
    }
    // спрятать ошибку
    private void hideError(TextView view) {
        view.setError( null );
    }

    private void startMainFragment() {
        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }
}
