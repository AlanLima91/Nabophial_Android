package com.example.nabophial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText    email;
    private EditText    password;
    private TextView    signup;
    private TextView    forgetPass;
    private Button      loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email       = (EditText) findViewById(R.id.email);
        password    = (EditText) findViewById(R.id.password);
        signup      = (TextView) findViewById(R.id.signup);
        forgetPass  = (TextView) findViewById(R.id.forget_password);
        loginBtn    = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login())
                    openHomepage();
                else
                    return ;
            }
        });
    }

    public boolean login()
    {
        return true ;
    }

    public void openHomepage()
    {
        // Not the right Activity, made it just for the test and it works
        startActivity(new Intent(this, SignupActivity.class));
    }

}
