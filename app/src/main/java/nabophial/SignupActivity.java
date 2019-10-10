package nabophial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nabophial.Model.User;
import nabophial.Network.RetrofitInstance;
import nabophial.Network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private static RetrofitService client;

    private boolean OK = true;
    private boolean OK2 = true;
    private boolean OK3 = true;
    private boolean OK4 = true;

    private EditText email;
    private String Semail;
    private EditText password;
    private String Spassword;
    private EditText repeatedPassword;
    private String SrepeatedPassword;
    private EditText firstName;
    private String SfirstName;
    private EditText lastName;
    private String SlastName;
    private Button SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repeatedPassword = findViewById(R.id.repeatedPassword);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);

        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(final View view) {

                Semail = email.getText().toString();
                Spassword = password.getText().toString();
                SrepeatedPassword = repeatedPassword.getText().toString();
                SfirstName = firstName.getText().toString();
                SlastName = lastName.getText().toString();

                client = RetrofitInstance.getRetrofitInstance().create(RetrofitService.class); // On crée notre instance

                //On vérifie chaque champs avant d'envoyer l'inscription
                if ( Semail.matches(""))
                {
                    OK =false ;
                    email.setError("Email manquant ");
                } else {
                    if ( android.util.Patterns.EMAIL_ADDRESS.matcher(Semail).matches() == true ) //On vérifie si l'email est valide
                    {
                        OK =true ;
                    } else
                    {
                        OK =false ;
                        email.setError("Email invalide ");
                    }
                }

                if ( Spassword.matches(""))
                { OK2 =false ; password.setError("Mot de passe manquant "); }
                else {
                    if ( SrepeatedPassword.matches(""))
                    {
                        OK2 =false ; repeatedPassword.setError("Mot de passe de confirmation manquant ");
                    }
                    else {
                        if ( Spassword.matches(SrepeatedPassword))
                        {
                            OK2 =true;
                        } else {
                            OK2 =false ;
                            password.setError("Mots de passe différents ! ");
                            repeatedPassword.setError("Mots de passe différents ! ");
                        }

                    }
                }

                if ( SfirstName.matches(""))
                { OK3 =false ; firstName.setError("Prénom manquant "); } else { OK3 =true ; }
                if ( SlastName.matches(""))
                { OK4 =false ; lastName.setError("Nom manquant "); } else { OK4 =true ; }

                //Si tout les champs sont valide, on envoi l'inscripstion
                if ((OK)&&(OK2)&&(OK3)&&(OK4))
                {

                Call<User> call = client.signup(Semail,Spassword,SfirstName,SlastName);

                call.enqueue(new Callback<User>() {

                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        Log.e(TAG, "Code de réponse de l'api : " + response.code());

                        if (response.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Compte créé avec succès !", Toast.LENGTH_LONG).show();
                            openMainpage(view);

                        } else {
                            Log.e("Erreur : ", response.errorBody().toString() +  response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e(TAG, "Erreur onResponse: ConfigurationListener::" + call.request().url());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }); }
            }

        });

    }

    public void openMainpage(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


}
