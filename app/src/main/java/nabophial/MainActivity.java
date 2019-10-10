package nabophial;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nabophial.Model.AuthToken;
import nabophial.Network.RetrofitInstance;
import nabophial.Network.RetrofitService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{
    private EditText    email;
    private EditText    password;
    private TextView    signup;
    private TextView    forgetPass;
    private Button      loginBtn;
	private static RetrofitService client ;
    private static final String TAG = "MainActivity";
    public String TokenNow ;

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

			client = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class); // On crée notre instance
                Log.e(TAG, "passs: "+ email.getText() +" " +password.getText());//toString()+ password.toString()
			Call<AuthToken> call = client.login(email.getText().toString(),password.getText().toString());

            call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {

                Log.e(TAG, "VRAI onResponse:"+response.code());

                if (response.isSuccessful()){
                        Log.i("onSuccess", response.body().toString());
                        TokenNow = response.body().getToken();
                        openHomepage();
                } else {
                    Toast.makeText(getApplicationContext(), "Identifiant incorrect", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                Log.e(TAG, "FAUX onResponse: ConfigurationListener::"+call.request().url());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

			  
            }
        });
    }

    public void SignUp(View v) {  }

    public void ResetPassword(View v) {  }

    public void openHomepage()
    {
        // Not the right Activity, made it just for the test and it works
        startActivity(new Intent(this, SignupActivity.class));
        Toast.makeText(getApplicationContext(),TokenNow, Toast.LENGTH_LONG).show();
    }

}
