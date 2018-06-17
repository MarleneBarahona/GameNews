package com.barahona.gamenewsv2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.barahona.gamenewsv2.Activities.MainActivity;
import com.barahona.gamenewsv2.Data.Model.Post;
import com.barahona.gamenewsv2.Data.Remote.APIService;
import com.barahona.gamenewsv2.Data.Remote.ApiUtils;
import com.barahona.gamenewsv2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class LoginActivity extends AppCompatActivity {

    private APIService myAPIService;

    Button entrar;
    EditText user, pass;

    public EditText username_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //String token = getIntent().getStringExtra("TOKEN_ID");
        botonEntrar();
        myAPIService = ApiUtils.getAPIService();


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean espacio = false;
                for (int i = 0; i < user.length(); i++) {
                    if (user.getText().toString().charAt(i) == ' ') {
                        espacio = true;
                        Toast.makeText(getApplicationContext(), "Los espacios no son validos en estos campos", Toast.LENGTH_LONG).show();
                    }}
                if((!user.getText().toString().isEmpty()) && (!pass.getText().toString().isEmpty()) && !espacio){
                    sendPost(user.getText().toString().trim(), pass.getText().toString().trim());
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void botonEntrar(){
        entrar = (Button) findViewById(R.id.btn_entrar);
        user = (EditText) findViewById(R.id.edit_user);
        pass = (EditText) findViewById(R.id.edit_pass);
        //username_perfil = findViewById();
    }

    public void sendPost(String user, String pass) {
        myAPIService.savePost(user, pass).enqueue(new Callback<Post>() {
            //Metodo que espera como parametros un llamada a la clase LoginPOST y una respuesta de dicha clase
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {
                    //Si la respuesta fue exitosa, se manda a llamar el metodo donde muestra el tccken
                    //y asi poder obtener dicho tocken
                    showResponse(response.body().toString());
                    Log.i("MENSAJE", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e("MENSAJE", "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String token) {
        Log.e("MENSAJE", "Unable to submit post to API.");
        Toast.makeText(getApplicationContext(), token,Toast.LENGTH_SHORT).show();
    }
}
