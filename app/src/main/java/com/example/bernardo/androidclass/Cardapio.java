package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Cardapio extends AppCompatActivity {
    String caso;
    View view;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);


        prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);


        Toast.makeText(this,prefs.getString("Menu", "").toString(), Toast.LENGTH_SHORT ).show();


    }


}
