package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    int icones[] = {R.mipmap.img0, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4};

    //Variaveis globais.
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Double longitude = -41.327504;
    Double latitude = -21.761077;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initSpinnerCustom();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

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
        toolbar.setLogo(R.mipmap.ic_launcher);
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
            Toast.makeText(this, "GPS", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] categoria = getResources().getStringArray(R.array.aCategorias);

        if(categoria[position].equals("Escolha!!")){

        }else{
            Intent intent = new Intent(this, EstiloEscolhido.class);
            intent.putExtra(EstiloEscolhido.KEYGUARD_SERVICE, categoria[position]);
            startActivity(intent);
        }

    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng posicaoInicialFalsa = new LatLng(latitude,longitude);

        if(cont == 1){
        LatLng minhaPosicao = new LatLng(latitude,longitude);
            mMap.addMarker(new MarkerOptions().position(minhaPosicao).title("Marker Real"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(minhaPosicao));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(minhaPosicao,15));

        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        try {

            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                longitude = mLastLocation.getLongitude();
                latitude = mLastLocation.getLatitude();
            cont = 1;
            onMapReady(mMap);
        } catch (SecurityException e) {

        }
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onConnectionSuspended(int i) {
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
}
