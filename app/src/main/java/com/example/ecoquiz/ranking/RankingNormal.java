package com.example.ecoquiz.ranking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.ecoquiz.JogadorAdapter;
import com.example.ecoquiz.R;
import com.example.ecoquiz.model.Player;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class RankingNormal extends AppCompatActivity {
    private ListView lstDados;
    List<Player> ranking;
    String url = "http://ecoquizapp.eu5.org/readNormal.php";
    private JogadorAdapter jogadorAdapter;
    ProgressBar pbRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_normal);
        lstDados = (ListView)findViewById(R.id.lstDados);
        pbRanking = (ProgressBar)findViewById(R.id.pbRanking);
        ranking = new ArrayList<Player>();
        jogadorAdapter = new JogadorAdapter(this, ranking);
        lstDados.setAdapter(jogadorAdapter);
        listaPlayers();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void listaPlayers(){
        final JsonObject json = new JsonObject();
        Ion.with(this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i = 0; i < result.size(); i++) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject = result.get(i).getAsJsonObject();
                            Player p = new Player(jsonObject.get("id").getAsInt(),
                                    jsonObject.get("nome").getAsString(),
                                    jsonObject.get("pontuacao").getAsInt(),
                                    jsonObject.get("dificuldade").getAsString());
                            ranking.add(p);

                        }
                        jogadorAdapter.notifyDataSetChanged();
                        pbRanking.setVisibility(View.INVISIBLE);
                    }
                });
    }

}