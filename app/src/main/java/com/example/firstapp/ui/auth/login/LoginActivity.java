package com.example.firstapp.ui.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstapp.MainActivity;
import com.example.firstapp.R;
import com.example.firstapp.helpers.ListHelper;
import com.example.firstapp.helpers.SharedPreferencesHelper;
import com.example.firstapp.helpers.TextChangedHelper;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements TextChangedHelper.TextChangedCallback {

    EditText etLogin, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        List <Integer> list = ListHelper.getIntList(1, 100);
        List <String> list1 = ListHelper.getFamilyNames();

       init();
    }

    private void init(){
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnSend);

        new TextChangedHelper(this).attachEditText(etLogin);
        new TextChangedHelper(this).attachEditText(etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                SharedPreferences preferences = SharedPreferencesHelper.getInstance(LoginActivity.this);
                String savedLogin = preferences.getString("login", "");
                String savedPassword = preferences.getString("password", "");
                System.out.println("savedLogin = " + savedLogin);
                System.out.println("savedPassword = " + savedPassword);

                if(login.equals(savedLogin) && password.equals(savedPassword)){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkButtonLogin() {
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        if (login.isEmpty() || password.isEmpty()) {
            btnLogin.setAlpha(0.35f);
            btnLogin.setEnabled(false);
        }
        else {
            btnLogin.setAlpha(1f);
            btnLogin.setEnabled(true);
        }
    }

    @Override
    public void onTextChanged(String s) {
        checkButtonLogin();
    }
}