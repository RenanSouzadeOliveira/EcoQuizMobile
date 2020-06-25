package com.example.ecoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.ecoquiz.ranking.SelecionarDificuldadeRanking;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void nextEscolherDificuldade(View v){
        Intent it = new Intent(MainActivity.this, SelecionarDificuldade.class);
        startActivityForResult(it, 0);
    }

    public void nextEscolherDificuldadeRanking(View v){
        Intent it = new Intent(MainActivity.this, SelecionarDificuldadeRanking.class);
        startActivityForResult(it, 0);
    }
    public void nextCreditos(View v){
        Intent it = new Intent(MainActivity.this, Creditos.class);
        startActivityForResult(it, 0);
    }

    public void fechar(View v){
        finishAffinity();
    }

}