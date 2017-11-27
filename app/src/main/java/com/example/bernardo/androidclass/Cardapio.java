package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bernardo.androidclass.adapters.adaptersmenu.AdapterMenuBR;
import com.example.bernardo.androidclass.adapters.adaptersmenu.AdapterMenuFastFood;
import com.example.bernardo.androidclass.adapters.adaptersmenu.AdapterMenuJapa;
import com.example.bernardo.androidclass.adapters.adaptersmenu.AdapterMenuMassas;

public class Cardapio extends AppCompatActivity {
    String caso;
    SharedPreferences prefs;

    RecyclerView.Adapter JapaMenu =  new AdapterMenuJapa();
    RecyclerView.Adapter Brasileiromenu =  new AdapterMenuBR();
    RecyclerView.Adapter Massasmenu =  new AdapterMenuMassas();
    RecyclerView.Adapter Fast_foodmenu =  new AdapterMenuFastFood();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);

        caso = prefs.getString("Menu","");
        Selecionar(caso);


    }
    private void initRecyclerViewGenerico(RecyclerView.Adapter adaptergenerico){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvMenuGenerico);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptergenerico);
    }

    public String Selecionar(String item){
        switch (item){

            case "japa":
                initRecyclerViewGenerico(JapaMenu);
                break;
            case "massas":
                initRecyclerViewGenerico(Massasmenu);
                break;
            case "fast_food":
                initRecyclerViewGenerico(Fast_foodmenu);
                break;
            case "brasieiro":
                initRecyclerViewGenerico(Brasileiromenu);
                break;
        }
        return item;
    }

}
