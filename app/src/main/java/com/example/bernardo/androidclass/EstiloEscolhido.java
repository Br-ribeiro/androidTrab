package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bernardo.androidclass.adapters.AdapterBR;
import com.example.bernardo.androidclass.adapters.AdapterFastFood;
import com.example.bernardo.androidclass.adapters.AdapterJaponesa;
import com.example.bernardo.androidclass.adapters.AdapterMassas;

import java.io.Serializable;

public class EstiloEscolhido extends AppCompatActivity implements Serializable {


    String caso;
    RecyclerView.Adapter Japonesa = new AdapterJaponesa();
    RecyclerView.Adapter Massas = new AdapterMassas();
    RecyclerView.Adapter Fast_food = new AdapterFastFood();
    RecyclerView.Adapter Brasileira = new AdapterBR();

    private SharedPreferences prefs;

    String teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estilo_escolhido);

        prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);

        String yourDataObject = null;

        if(getIntent().hasExtra(KEYGUARD_SERVICE)){
            yourDataObject = getIntent().getStringExtra(KEYGUARD_SERVICE);
            caso = yourDataObject;
            Selecionar(caso);
        }
    }




    private void initRecyclerViewGenerico(RecyclerView.Adapter AdapterGeral){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvGenerico);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(AdapterGeral);
    }

    public String Selecionar(String item){
        switch (item){

            case "Japonesa":
                prefs.edit().putString("Menu","japa").apply();
                initRecyclerViewGenerico(Japonesa);
                break;
            case "Massas":
                prefs.edit().putString("Menu","massas").apply();
                initRecyclerViewGenerico(Massas);
                break;
            case "Fast-food":
                prefs.edit().putString("Menu","fast_food").apply();
                initRecyclerViewGenerico(Fast_food);
                break;
            case "Brasileira":
                prefs.edit().putString("Menu","brasieiro").apply();
                initRecyclerViewGenerico(Brasileira);
                break;
        }
        return item;
    }


}
