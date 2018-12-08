package com.example.bobby.mvptutorial.Model;

import android.content.Context;
import android.text.TextUtils;

import com.example.bobby.mvptutorial.Presenter.LoginPresenter;
import com.example.bobby.mvptutorial.Utilities.MySharedPref;
import com.example.bobby.mvptutorial.View.LoginView;

public class LoginModel implements LoginPresenter {

    private Context context;

    private LoginView loginView;

    public LoginModel(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
        {
            loginView.loginValidation();
        }

        else
        {
            MySharedPref.init(context);
            MySharedPref.write("Name", username);
            MySharedPref.write("Password", password);
            loginView.saveInPrefs();
            loginView.loginSuccess();
        }

    }
}
