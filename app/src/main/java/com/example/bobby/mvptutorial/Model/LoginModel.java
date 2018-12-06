package com.example.bobby.mvptutorial.Model;

import android.text.TextUtils;

import com.example.bobby.mvptutorial.Presenter.LoginPresenter;
import com.example.bobby.mvptutorial.View.LoginView;

public class LoginModel implements LoginPresenter {

    private LoginView loginView;

    public LoginModel(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
        {
            loginView.loginValidation();
        }

        else if (username.equalsIgnoreCase("bobby") && password.equalsIgnoreCase("bobby"))
        {
            loginView.loginSuccess();
        }

        else
        {
            loginView.loginError();
        }

    }
}
