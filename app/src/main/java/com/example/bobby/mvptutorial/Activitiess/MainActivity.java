package com.example.bobby.mvptutorial.Activitiess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bobby.mvptutorial.Model.LoginModel;
import com.example.bobby.mvptutorial.Presenter.LoginPresenter;
import com.example.bobby.mvptutorial.R;
import com.example.bobby.mvptutorial.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    EditText username, password;
    Button login;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginPresenter = new LoginModel(this);

        username = findViewById(R.id.usename);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                loginPresenter.performLogin(name, pass);
            }
        });
    }

    @Override
    public void loginValidation() {

        Toast.makeText(this, "Validation failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show();
    }
}
