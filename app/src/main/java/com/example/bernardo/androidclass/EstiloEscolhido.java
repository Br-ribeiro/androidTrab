package com.example.bernardo.androidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EstiloEscolhido extends AppCompatActivity {



    public static final String KEYGUARD_SERVICE = "com.example.bernardo.androidclass";
    String caso;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estilo_escolhido);


        String yourDataObject = null;

        if(getIntent().hasExtra(KEYGUARD_SERVICE)){
            yourDataObject = getIntent().getStringExtra(KEYGUARD_SERVICE);
            caso = yourDataObject;
            Toast.makeText(this, "funcionou", Toast.LENGTH_SHORT).show();
            Selecionar(caso);

        }else{
            Toast.makeText(this, "È nulo", Toast.LENGTH_SHORT).show();
        }

    }

    public String Selecionar(String item){
        view = findViewById(R.id.escolhaTela);
        switch (item){

            case "Japonesa":
                view.setBackgroundColor(getResources().getColor(android.R.color.black));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Massas":
                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Fast-food":
                view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;
            case "Brasileira":
                view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                Toast.makeText(this, caso, Toast.LENGTH_SHORT).show();
                break;





        }
        return item;
    }

    /*<item>Japonesa</item>
        <item>Massas</item>
        <item>Fast-food</item>
        <item>Brasileira</item>*/

}
