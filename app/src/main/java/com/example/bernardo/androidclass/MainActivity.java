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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bernardo.androidclass.adapters.AdapterSpinner;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnMapReadyCallback {

    int icones[] = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4};
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        //initSpinner();

        initSpinnerCustom();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void initSpinner(){

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.aCategorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void  initSpinnerCustom(){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        AdapterSpinner adapterSpinner = new AdapterSpinner(this,icones, getResources().getStringArray(R.array.aCategorias));
        spinner.setAdapter(adapterSpinner);
    }

    protected void initToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_principal);
        toolbar.setTitle(" ");
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
            /*Toast.makeText(this, "Configuração", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));*/

                Intent intent;

                    intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
            break;

            /*case R.id.Telef:
                Toast.makeText(this, "Telefone", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_DIAL));
                break;*/

            case R.id.Logout:
                SharedPreferences prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);
                prefs.edit().putBoolean("status", false).apply();

                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] categoria = getResources().getStringArray(R.array.aCategorias);
        Toast.makeText(this, categoria[position], Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
