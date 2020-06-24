package com.example.ecoquiz.normal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ecoquiz.MainActivity;
import com.example.ecoquiz.R;
import com.example.ecoquiz.controll.PartidaController;
import com.example.ecoquiz.model.Player;
import com.example.ecoquiz.novato.Novato1;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class Normal2 extends AppCompatActivity {
    private AlertDialog alerta;
    private CountDownTimer relogio;
    private RewardedAd rewardedAd;
    private String url = "http://ecoquizapp.eu5.org/create.php";
    MediaPlayer mp;

    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal2);
        player = getIntent().getExtras().getParcelable("user");
        TextView pontuacao = (TextView)findViewById(R.id.txtPontuacaoAtual);
        pontuacao.setText(Integer.toString(player.getPontuacao()));
        mp = MediaPlayer.create(this, R.raw.timer);
        final TextView text = (TextView)findViewById(R.id.txtCronometro);

        relogio = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                text.setText(Long.toString(millisUntilFinished / 1000));
                mp.start();
            }

            public void onFinish() {
                exibePontuacao(player);
                relogio.cancel();
                mp.stop();
            }
        }.start();
        loadAd();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Verificando se a resposta é a correta
    public void verificarResposta0(View v){
        Button botao = (Button)findViewById(R.id.btnResposta0);
        PartidaController part = new PartidaController();
        TextView cronometro = (TextView)findViewById(R.id.txtCronometro);

        if(part.validarResposta(botao.getText().toString())){
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.acerto);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonverify));
            relogio.cancel();
            player.setPontuacao(Integer.parseInt(cronometro.getText().toString()));
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        } else{
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.erro);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonerror));
            relogio.cancel();
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        }
    }

    public void verificarResposta1(View v){
        Button botao = (Button)findViewById(R.id.btnResposta1);
        PartidaController part = new PartidaController();
        TextView cronometro = (TextView)findViewById(R.id.txtCronometro);

        if(part.validarResposta(botao.getText().toString())){
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.acerto);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonverify));
            relogio.cancel();
            player.setPontuacao(Integer.parseInt(cronometro.getText().toString()));
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        } else{
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.erro);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonerror));
            relogio.cancel();
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        }
    }

    public void verificarResposta2(View v){
        Button botao = (Button)findViewById(R.id.btnResposta2);
        PartidaController part = new PartidaController();
        TextView cronometro = (TextView)findViewById(R.id.txtCronometro);

        if(part.validarResposta(botao.getText().toString())){
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.acerto);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonverify));
            relogio.cancel();
            player.setPontuacao(Integer.parseInt(cronometro.getText().toString()));
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        } else{
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.erro);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonerror));
            relogio.cancel();
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user", player);
            startActivityForResult(it, 0);
        }
    }

    public void verificarResposta3(View v){
        Button botao = (Button)findViewById(R.id.btnResposta3);
        PartidaController part = new PartidaController();
        TextView cronometro = (TextView)findViewById(R.id.txtCronometro);

        if(part.validarResposta(botao.getText().toString())){
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.acerto);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonverify));
            relogio.cancel();
            player.setPontuacao(Integer.parseInt(cronometro.getText().toString()));
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        } else{
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.erro);
            mp.start();
            botao.setBackground(getResources().getDrawable(R.drawable.buttonerror));
            relogio.cancel();
            Intent it = new Intent(Normal2.this, Novato1.class);
            it.putExtra("user",player);
            startActivityForResult(it, 0);
        }
    }

    //Exibe alert com nome e pontuacao do usuario, também registra no banco de dados
    public void exibePontuacao(final Player player){

        try {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            View dialog = getLayoutInflater().inflate(R.layout.dialog_game_over, null);
            Button btnOk = (Button)dialog.findViewById(R.id.btnFim);
            TextView txtPlayer = (TextView)dialog.findViewById(R.id.txtPlayer);
            txtPlayer.setText(player.toString());
            ImageButton adButton = (ImageButton)dialog.findViewById(R.id.adButton);
            // Encerra a partida e registra no banco de dados
            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registrarOnline(player.getNome().toString(), player.getPontuacao());
                    Intent it = new Intent(Normal2.this, MainActivity.class);
                    startActivityForResult(it, 0);
                }
            });
            //Video recompensado
            adButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rewardedAd.isLoaded()) {
                        Activity activityContext = Normal2.this;
                        RewardedAdCallback adCallback = new RewardedAdCallback() {
                            @Override
                            public void onRewardedAdOpened() {
                                // Ad opened.
                            }

                            @Override
                            public void onRewardedAdClosed() {
                                loadAd();
                            }

                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                AlertDialog.Builder abc = new AlertDialog.Builder(Normal2.this);
                                View dialog = getLayoutInflater().inflate(R.layout.dialog_continuar, null);
                                Button btnContinue = (Button)dialog.findViewById(R.id.btnContinuar);

                                btnContinue.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Normal2.this, Novato1.class);
                                        it.putExtra("user",player);
                                        startActivityForResult(it, 0);
                                    }
                                });
                                abc.setView(dialog);
                                alerta = abc.create();
                                alerta.show();
                            }

                            @Override
                            public void onRewardedAdFailedToShow(int errorCode) {
                                // Ad failed to display.
                            }
                        };
                        rewardedAd.show(activityContext, adCallback);
                    } else {
                        Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                    }
                }
            });
            msg.setView(dialog);
            alerta = msg.create();
            alerta.show();
        } catch (SQLException e){
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Erro");
            msg.setMessage("Infelizmente ocorreu um problema e não conseguimos registrar sua partida, tente novamente.");
            msg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent it = new Intent(Normal2.this, MainActivity.class);
                    startActivityForResult(it, 0);
                }
            });
            msg.show();
        }
    }
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    private void registrarOnline(final String user, final int pontuacao) {
        Ion.with(this)
                .load(url)
                .setBodyParameter("nome", user)
                .setBodyParameter("pontuacao", String.valueOf(pontuacao))
                .setBodyParameter("dificuldade", player.getDificuldade())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                    }
                });
    }

    private void loadAd(){
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }

}