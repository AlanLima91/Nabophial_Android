package nabophial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nabophial.Model.AuthToken;
import nabophial.Network.RetrofitInstance;
import nabophial.Network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static RetrofitService client;
    public String TokenNow;
    private EditText email;
    private EditText password;
    private TextView signup;
    private TextView forgetPass;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        forgetPass = findViewById(R.id.forget_password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                client = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class); // On crée notre instance
                Log.e(TAG, "Email : " + email.getText() + " Password : " + password.getText());//toString()+ password.toString()
                Call<AuthToken> call = client.login(email.getText().toString(), password.getText().toString());

                call.enqueue(new Callback<AuthToken>() {

                    @Override
                    public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {

                        Log.e(TAG, "Code de réponse de l'api : " + response.code());

                        if (response.isSuccessful()) {
                            Log.i("Token : ", response.body().toString());
                            TokenNow = response.body().getToken();
                            openHomepage(view);
                        } else {
                            Toast.makeText(getApplicationContext(), "Identifiant incorrect", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthToken> call, Throwable t) {
                        Log.e(TAG, "FAUX onResponse: ConfigurationListener::" + call.request().url());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void SignUp(View view) {
        startActivity(new Intent(this, SignupActivity.class));
    }

    public void ResetPassword(View view) {
        startActivity(new Intent(this, ResetPasswordActivity.class));
    }

    public void openHomepage(View view) {
        // Not the right Activity, made it just for the test and it works
        startActivity(new Intent(this, HomeActivity.class));
        Toast.makeText(getApplicationContext(), TokenNow, Toast.LENGTH_LONG).show();
    }

}
