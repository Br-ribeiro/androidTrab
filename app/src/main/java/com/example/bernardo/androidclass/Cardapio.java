package com.example.bernardo.androidclass;

import android.content.Context;
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


        Toast.makeText(this,"entrou no cardapio", Toast.LENGTH_SHORT ).show();
        Toast.makeText(this,"Vai falar o tipo", Toast.LENGTH_SHORT ).show();
        //Toast.makeText(this,String.valueOf(aaa), Toast.LENGTH_SHORT ).show();

        if(prefs.getString("menu","japa").equalsIgnoreCase("japa")){
            View view = findViewById(R.id.teste);
            view.setBackgroundColor(000000);
        }

        if(prefs.getString("menu","massas").equalsIgnoreCase("massas")){
            View view = findViewById(R.id.teste);
            view.setBackgroundColor(999999);
        }


        if(prefs.getString("menu","massas").equalsIgnoreCase("null")){
            View view = findViewById(R.id.teste);
            view.setBackgroundColor(222222);
        }


    }



    /*public String Selecionar(String item){
        view = findViewById(R.id.escolhaTela);
        switch (item){

            case "Japonesa":
                view.setBackgroundColor(getResources().getColor(android.R.color.black));
                //initRecucleViewJaponesa();
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Massas":
                //initRecucleViewMassas();
                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Fast-food":
                //initRecucleViewFastFood();
                view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Brasileira":
                //initRecucleViewBR();
                view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;





        }
        return item;
    }*/
}
