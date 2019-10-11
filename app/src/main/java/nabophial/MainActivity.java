package nabophial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;

import nabophial.Model.Session;
import nabophial.Network.RetrofitInstance;
import nabophial.Network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static RetrofitService client;
    public static Session session = new Session(null,"");
    private EditText email;
    private EditText password;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {

                client = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class); // On crée notre instance


                Call<Session> call = client.login(email.getText().toString(), password.getText().toString());

                call.enqueue(new Callback<Session>() {

                    @Override
                    public void onResponse(Call<Session> call, Response<Session> response) {

                        Log.i(TAG, "Code de réponse de l'api : " + response.code());

                        if (response.isSuccessful()) {
                            session.setToken(response.body().getToken());
                            DecodeId(session.getToken());
                            Log.i(" ID : ", session.getId().toString());
                            Log.i(" Token : ", session.getToken());
                            openHomepage(view);
                        } else {
                            Toast.makeText(getApplicationContext(), "Identifiant incorrect", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Session> call, Throwable t) {
                        Log.e(TAG, "Erreur onFailure: ConfigurationListener::" + call.request().url());
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

        startActivity(new Intent(this, HomeActivity.class));
    }

    private void DecodeId(String token) {

        try {
            String[] split = token.split("\\.");

            //Log.i("JWT_DECODED", "Header: " + getJson(split[0]));
            //Log.i("JWT_DECODED", "Body: " + getJson(split[1]));

            JsonObject convertedObject = new Gson().fromJson(getJson(split[1]), JsonObject.class);

            session.setId(convertedObject.get("id").getAsInt());


        } catch (UnsupportedEncodingException e) {

        }
        //Log.i(" ID : ", jwt.getId());
        //session.setId(Integer.parseInt(jwt.getId()));
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
            byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
            return new String(decodedBytes, "UTF-8");
    }


}
