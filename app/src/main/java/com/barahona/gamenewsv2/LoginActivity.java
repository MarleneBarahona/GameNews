package com.barahona.gamenewsv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button entrar;
    EditText user, pass;
    public EditText username_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        botonEntrar();

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
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
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
}
