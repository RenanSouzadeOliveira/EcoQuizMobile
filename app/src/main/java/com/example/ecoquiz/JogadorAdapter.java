package com.example.ecoquiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ecoquiz.model.Player;
import com.google.gson.JsonObject;


import java.util.List;

public class JogadorAdapter extends BaseAdapter {
    private Context tela;
    private List<Player> lista;

    public JogadorAdapter(Context tela, List<Player> lista){
        this.tela = tela;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Player getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView == null){
            LayoutInflater inflater = ((Activity)tela).getLayoutInflater();
            view = inflater.inflate(R.layout.linha_jogador, null);

        } else{
            view = convertView;
        }

        Player p = getItem(position);

        TextView txtPlayer = (TextView)view.findViewById(R.id.txtPlayer);
        TextView txtPontos = (TextView)view.findViewById(R.id.txtPontos);

        txtPlayer.setText(p.getNome());
        txtPontos.setText(String.valueOf(p.getPontuacao()));

        return view;
    }
}
