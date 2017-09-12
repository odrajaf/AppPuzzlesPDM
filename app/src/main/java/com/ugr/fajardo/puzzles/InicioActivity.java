package com.ugr.fajardo.puzzles;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity {

    ImageView puzzleGato;
    ImageView puzzlePerro;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.musicafondo);
        mp.setLooping(true);
        mp.start();

        puzzleGato = (ImageView) findViewById(R.id.imagePuzzle1);
        puzzlePerro =  (ImageView) findViewById(R.id.imagePuzzle2);

        puzzleGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                mp.release();
                mp = null;
                Intent nuevoJuego = new Intent(InicioActivity.this, MainActivity.class);
                nuevoJuego.putExtra("nivel", 1);
                startActivity(nuevoJuego);
                finish();

            }
        });
        puzzlePerro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                mp.release();
                mp = null;
                Intent nuevoJuego = new Intent(InicioActivity.this, MainActivity.class);
                nuevoJuego.putExtra("nivel", 2);
                startActivity(nuevoJuego);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed (){
        mp.stop();
        mp.release();
        mp = null;
        finish();
    }


}
