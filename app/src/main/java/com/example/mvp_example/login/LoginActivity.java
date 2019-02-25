package com.example.mvp_example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp_example.R;
import com.example.mvp_example.root.MVPApp;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements  LoginActivityMVP.View{
    private EditText editText1;
    private EditText editText2;
    private Button login;

    @Inject
    LoginActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((MVPApp)getApplication()).getComponent().inject(LoginActivity.this);
        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
        login=findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.LoginButtonClicked();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return editText1.getText().toString();
    }

    @Override
    public String getLastName() {
        return editText2.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this,"User Not Available",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveUserMessage() {
        Toast.makeText(this,"User Saved",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Input Error",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fName) {
        editText1.setText(fName);

    }

    @Override
    public void setLastName(String lName) {
        editText2.setText(lName);
    }
}
