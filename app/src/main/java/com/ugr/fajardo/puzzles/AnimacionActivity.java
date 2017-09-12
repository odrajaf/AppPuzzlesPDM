package com.ugr.fajardo.puzzles;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimacionActivity extends AppCompatActivity {

    ImageView animacion;
    AnimationDrawable frameAnimation;
    MediaPlayer mp;
    Button jugar;
    Button maulla;
    int veces = 0;
    int nivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacion);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        jugar = (Button) findViewById(R.id.buttonJugar);
        maulla = (Button) findViewById(R.id.buttonMaulla);
        animacion = (ImageView) findViewById(R.id.imageView);

        try {
            nivel = (int) getIntent().getExtras().getSerializable("nivel");
        }catch (Exception e){

        }

        if(nivel == 2) {
            animacion.setImageResource(R.drawable.perrogif);
            mp = MediaPlayer.create(getApplicationContext(), R.raw.ladridoperro);
        }else{
            animacion.setImageResource(R.drawable.loading);
            mp = MediaPlayer.create(getApplicationContext(), R.raw.escuchamaulla);
        }




        frameAnimation = (AnimationDrawable) animacion.getDrawable();
        frameAnimation.start();
        if(veces == 0) {
            mp.start();
            veces++;
        }

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nivel == 2) {
                    Intent alInicio = new Intent(AnimacionActivity.this, InicioActivity.class);
                    startActivity(alInicio);
                    finish();

                }else{
                    Intent siguienteNivel = new Intent(AnimacionActivity.this, MainActivity.class);
                    siguienteNivel.putExtra("nivel", 2);
                    startActivity(siguienteNivel);
                    finish();
                }

            }
        });

        maulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nivel == 2) {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.ladrido);

                }else{
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.maullido);
                }
                mp.start();

            }
        });




    }

}
