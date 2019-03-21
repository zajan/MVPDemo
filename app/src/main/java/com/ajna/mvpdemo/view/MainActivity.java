package com.ajna.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ajna.mvpdemo.R;
import com.ajna.mvpdemo.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private MainActivityPresenter presenter;
    private EditText etLogin, etPassword;
    private TextView tvLogin, tvPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLogin = findViewById(R.id.tv_login);
        tvPassword = findViewById(R.id.tv_password);
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        presenter = new MainActivityPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        presenter.updateInfo(etLogin.getText().toString(),
                etPassword.getText().toString());
    }

    @Override
    public void updateLoginInfo(String login) {
        tvLogin.setText(login);
    }

    @Override
    public void updatePasswordInfo(String password) {
        tvPassword.setText(password);
    }
}