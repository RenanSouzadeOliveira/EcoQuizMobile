package com.example.ecoquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.ecoquiz.hard.Hard0;
import com.example.ecoquiz.model.Player;
import com.example.ecoquiz.normal.Normal0;
import com.example.ecoquiz.novato.Novato0;

public class SelecionarDificuldade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_dificuldade);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void nextNovato(View v){
        Intent it = new Intent(SelecionarDificuldade.this, Novato0.class);
        EditText edtNome = (EditText)findViewById(R.id.edtNome);
        Player player;
        if(edtNome.getText().length() == 0){
           player =  new Player(0,"Novato");
           it.putExtra("user", player);
           startActivityForResult(it, 0);
        } else{
            player = new Player(edtNome.getText().toString(), 0, "Novato");
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        }
    }

    public void nextNormal(View v){
        Intent it = new Intent(SelecionarDificuldade.this, Normal0.class);
        EditText edtNome = (EditText)findViewById(R.id.edtNome);
        Player player;
        if(edtNome.getText().length() == 0){
            player =  new Player(0,"Normal");
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        } else{
            player = new Player(edtNome.getText().toString(), 0, "Normal");
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        }
    }

    public void nextHard(View v){
        Intent it = new Intent(SelecionarDificuldade.this, Hard0.class);
        EditText edtNome = (EditText)findViewById(R.id.edtNome);
        Player player;
        if(edtNome.getText().length() == 0){
            player =  new Player(0,"Hard");
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        } else{
            player = new Player(edtNome.getText().toString(), 0, "Hard");
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        }
    }

}