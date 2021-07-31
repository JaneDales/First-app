package com.example.firstapp.ui.auth.signUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapp.MainActivity;
import com.example.firstapp.R;
import com.example.firstapp.helpers.ListHelper;
import com.example.firstapp.helpers.TextChangedHelper;
import com.example.firstapp.helpers.SharedPreferencesHelper;

import java.util.List;

public class SignUpActivity extends AppCompatActivity implements TextChangedHelper.TextChangedCallback {
    EditText etLogin, etPassword, etPasswordConfirm;
    Button btnSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        List<Integer> list = ListHelper.getIntList(0, 20);

        init();
    }

    @Override
    public void onTextChanged(String s) {
        checkButtonSingUp();
    }

    private void init(){
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        etPasswordConfirm = findViewById(R.id.etPasswordConfirm);
        btnSingUp = findViewById(R.id.btnSignUp);

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCredentials();
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });

        new TextChangedHelper(this).attachEditText(etLogin);
        new TextChangedHelper(this).attachEditText(etPassword);
        new TextChangedHelper(this).attachEditText(etPasswordConfirm);
    }
    private void checkButtonSingUp() {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        String repeatPassword = etPasswordConfirm.getText().toString();

        if (login.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() || !password.equals(repeatPassword)) {
            btnSingUp.setAlpha(0.35f);
            btnSingUp.setEnabled(false);
        }
        else {
            btnSingUp.setAlpha(1f);
            btnSingUp.setEnabled(true);
        }
    }
    public void saveCredentials() {
        SharedPreferences preferences = SharedPreferencesHelper.getInstance(this);
        String login = etLogin.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        preferences.edit().putString("login", login).apply();
        preferences.edit().putString("password", password).apply();

        System.out.println("login =" + login);
        System.out.println("password ="+ password);
    }
}