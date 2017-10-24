package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
    }


    protected void initToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Restaurantes");
        toolbar.setLogo(R.mipmap.logo);

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.Config:
            Toast.makeText(this, "Configuração", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            break;

            case R.id.Telef:
                Toast.makeText(this, "Telefone", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_DIAL));
                break;

            case R.id.Logout:
                SharedPreferences prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);
                prefs.edit().putBoolean("status", false).apply();

                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
