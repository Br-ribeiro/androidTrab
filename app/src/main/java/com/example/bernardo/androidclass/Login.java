package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText input_email;
    private EditText input_password;
    private Button button_entrar;
    private Button button_cadastrar;
    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input_email = (EditText)findViewById(R.id.Email);
        input_password = (EditText)findViewById(R.id.Senha);
        button_entrar = (Button)findViewById(R.id.bot_entrar);
        button_cadastrar = (Button)findViewById(R.id.bot_cadastrar);

        prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);

        if(prefs.getString("user", null) != null){
            input_email.setText(prefs.getString("user", null));
            input_password.requestFocus();
        }

        button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = input_email.getText().toString().trim();//pegando o que o cara digita.
                String senha = input_password.getText().toString().trim();

                if(usuario.equalsIgnoreCase(prefs.getString("user", null)) && senha.equals(prefs.getString("passwd", null))){
                    prefs.edit().putBoolean("status", true).apply();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    Toast.makeText(Login.this,"foi", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(Login.this, "Usuário ou senha errado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = input_email.getText().toString().trim();
                String senha = input_password.getText().toString().trim();

                prefs.edit().putString("user", usuario).apply();
                prefs.edit().putString("passwd",senha).apply();
                prefs.edit().putBoolean("status", true).apply();

                startActivity(new Intent(Login.this, MainActivity.class));
            }
        });




    }
}
