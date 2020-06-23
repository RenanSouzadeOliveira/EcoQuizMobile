package com.example.ecoquiz.ranking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.ecoquiz.R;

public class SelecionarDificuldadeRanking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_dificuldade_ranking);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void abrirRankingNovato(View view){
        Intent it = new Intent(SelecionarDificuldadeRanking.this, RankingNovato.class);
        startActivityForResult(it, 0);
    }
}