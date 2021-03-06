package com.e.onlineclothingshoppingapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.onlineclothingshoppingapp.DahboardActivity;
import com.e.onlineclothingshoppingapp.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private Button btnLogin;
    private EditText etUsername_Login, etPassword_Login;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login_fragment, container, false);
        btnLogin = view.findViewById(R.id.btnLogin);
        etPassword_Login = view.findViewById(R.id.etPassword_Login);
        etUsername_Login = view.findViewById(R.id.etUsername_Signup);

        btnLogin.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        if (!validate()) {
            return;
        }
        checkLogin();


    }

    private void checkLogin() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        String uname = etUsername_Login.getText().toString();
        String pass = etPassword_Login.getText().toString();
        if (username.equals(uname) && password.equals(pass)) {
            Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity().getApplicationContext(), DahboardActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity(), "Username or password doesnt match", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean validate() {
        boolean isValid = true;
        if (TextUtils.isEmpty(etUsername_Login.getText().toString())) {
            etUsername_Login.setError("Please Enter Username");
            etUsername_Login.requestFocus();
            isValid = false;
        } else if (TextUtils.isEmpty(etPassword_Login.getText().toString())) {
            etPassword_Login.setError("Please Enter Password");
            etPassword_Login.requestFocus();
            isValid = false;

        }
        return isValid;
    }
}