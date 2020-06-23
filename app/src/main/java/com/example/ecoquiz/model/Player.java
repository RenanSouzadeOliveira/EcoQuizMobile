package com.example.ecoquiz.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Player implements Parcelable {
    Integer codigo;
    String nome;
    int pontuacao;
    String dificuldade;

    public Player(int codigo, String nome, int pontuacao, String dificuldade){
        setCodigo(codigo);
        setNome(nome);
        setPontuacao(pontuacao);
        setDificuldade(dificuldade);
    }


    public Player(String nome, int pontuacao, String dificuldade){
        setNome(nome);
        setPontuacao(pontuacao);
        setDificuldade(dificuldade);
    }


    public Player(int pontuacao, String dificuldade){
        Random geradorAleatorio = new Random();
        String nome = "User{" + geradorAleatorio.nextInt(1000) + "}";
        setNome(nome);
        setPontuacao(pontuacao);
        setDificuldade(dificuldade);
    }


    protected Player(Parcel in) {
        if (in.readByte() == 0) {
            codigo = null;
        } else {
            codigo = in.readInt();
        }
        nome = in.readString();
        pontuacao = in.readInt();
        dificuldade = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (codigo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(codigo);
        }
        dest.writeString(nome);
        dest.writeInt(pontuacao);
        dest.writeString(dificuldade);
    }
    @Override
    public String toString(){
        return "Parabéns: " + this.getNome() + "\n" + "Pontuação: " + this.getPontuacao();
    }
}
