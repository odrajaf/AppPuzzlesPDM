package com.ugr.fajardo.puzzles;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout lienzo;
    TextView textoSalida;

    ImageView imagenA;
    ImageView imagenB;
    ImageView imagenC;
    ImageView imagenD;

    float margenVista = 175;
    boolean colocadaA = false;
    boolean colocadaB = false;
    boolean colocadaC = false;
    boolean colocadaD = false;

    int nivel= 0;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.musicafondo);
        mp.setLooping(true);
        mp.start();

        try {
            nivel = (int) getIntent().getExtras().getSerializable("nivel");
        }catch (Exception e){

        }

        lienzo = (ConstraintLayout) findViewById(R.id.gridPrueba);
        lienzo.setBackgroundColor(Color.rgb(200,200,255));
        textoSalida = (TextView) findViewById(R.id.textMuestra);
        imagenA = (ImageView) findViewById(R.id.imageA);
        imagenB = (ImageView) findViewById(R.id.imageB);
        imagenC = (ImageView) findViewById(R.id.imageC);
        imagenD = (ImageView) findViewById(R.id.imageD);

        if(nivel ==2) {
            imagenA.setImageResource(R.mipmap.perroa);
            imagenB.setImageResource(R.mipmap.perrob);
            imagenC.setImageResource(R.mipmap.perroc);
            imagenD.setImageResource(R.mipmap.perrod);

        }

        imagenA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imagenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imagenC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imagenD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imagenA.setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch( View arg0, MotionEvent arg1 ) {
                if( arg1.getAction() == MotionEvent.ACTION_MOVE ) {
                    if(arg1.getY() + arg0.getY()-margenVista > -50) {

                        imagenA.setY(arg1.getY() + arg0.getY() - margenVista);
                    }
                    if((arg1.getX() + arg0.getX()-margenVista) > -50 && (arg1.getX() + arg0.getX()-margenVista) < 1050) {
                        imagenA.setX(arg1.getX() + arg0.getX() - margenVista);
                    }
                    //textoSalida.setText("Imagen A Tocada " +(arg0.getX()) + " " +(arg0.getY()));
                    colocadaA = false;
                }else{

                    if((arg1.getX() + arg0.getX()-margenVista) > 275 && (arg1.getX() + arg0.getX()-margenVista) < 610){
                        if((arg1.getY() + arg0.getY()-margenVista) < 260 && (arg1.getY() + arg0.getY()-margenVista) > 120){
                            //textoSalida.setText("Imagen A Colocado");
                            colocadaA = true;
                            imagenA.setX(517);
                            imagenA.setY(181);
                            comprobarFinal();
                        }

                    }
                }
                return false;
            }
        });

        imagenB.setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch( View arg0, MotionEvent arg1 ) {
                if( arg1.getAction() == MotionEvent.ACTION_MOVE ) {
                    if(arg1.getY() + arg0.getY()-margenVista > -50) {

                        imagenB.setY(arg1.getY() + arg0.getY() - margenVista);
                    }
                    if((arg1.getX() + arg0.getX()-margenVista) > -50 && (arg1.getX() + arg0.getX()-margenVista) < 1050) {
                        imagenB.setX(arg1.getX() + arg0.getX() - margenVista);
                    }
                    //textoSalida.setText("Imagen B Tocada " +(arg0.getX()) + " " +(arg0.getY()));
                    colocadaB = false;
                }else{

                    if((arg1.getX() + arg0.getX()-margenVista) > 300 && (arg1.getX() + arg0.getX()-margenVista) < 480){
                        if((arg1.getY() + arg0.getY()-margenVista) < 50 && (arg1.getY() + arg0.getY()-margenVista) > -70){
                            //textoSalida.setText("Imagen B Colocado");
                            colocadaB = true;
                            imagenB.setX(420);
                            imagenB.setY(0);
                            comprobarFinal();
                        }

                    }
                }
                return false;
            }
        });

        imagenC.setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch( View arg0, MotionEvent arg1 ) {
                if( arg1.getAction() == MotionEvent.ACTION_MOVE ) {
                    if(arg1.getY() + arg0.getY()-margenVista > -50) {

                        imagenC.setY(arg1.getY() + arg0.getY() - margenVista);
                    }
                    if((arg1.getX() + arg0.getX()-margenVista) > -50 && (arg1.getX() + arg0.getX()-margenVista) < 1050) {
                        imagenC.setX(arg1.getX() + arg0.getX() - margenVista);
                    }
                    //textoSalida.setText("Imagen C Tocada " +(arg0.getX()) + " " +(arg0.getY()));
                    colocadaC = false;
                }else{

                    if((arg1.getX() + arg0.getX()-margenVista) > 350 && (arg1.getX() + arg0.getX()-margenVista) < 480){
                        if((arg1.getY() + arg0.getY()-margenVista) < 260 && (arg1.getY() + arg0.getY()-margenVista) > 120){
                            //textoSalida.setText("Imagen C Colocado");
                            colocadaC = true;
                            imagenC.setX(420);
                            imagenC.setY(181);
                            comprobarFinal();
                        }

                    }
                }
                return false;
            }
        });

        imagenD.setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch( View arg0, MotionEvent arg1 ) {
                if( arg1.getAction() == MotionEvent.ACTION_MOVE ) {
                    if(arg1.getY() + arg0.getY()-margenVista > -50) {

                        imagenD.setY(arg1.getY() + arg0.getY() - margenVista);
                    }
                    if((arg1.getX() + arg0.getX()-margenVista) > -50 && (arg1.getX() + arg0.getX()-margenVista) < 1050) {
                        imagenD.setX(arg1.getX() + arg0.getX() - margenVista);
                    }
                    //textoSalida.setText("Imagen D Tocada " +(arg0.getX()) + " " +(arg0.getY()));
                    colocadaD = false;
                }else{

                    if((arg1.getX() + arg0.getX()-margenVista) > 550 && (arg1.getX() + arg0.getX()-margenVista) < 680){
                        if((arg1.getY() + arg0.getY()-margenVista) < 40 && (arg1.getY() + arg0.getY()-margenVista) > -115){
                            //textoSalida.setText("Imagen D Colocado");
                            colocadaD = true;
                            imagenD.setX(597);
                            imagenD.setY(0);
                            comprobarFinal();
                        }

                    }
                }
                return false;
            }
        });

    }
    public void comprobarFinal(){
        if(colocadaA && colocadaB && colocadaC && colocadaD){
            //textoSalida.setText("Has ganado el juego");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        mp.stop();
                        mp.release();
                        mp = null;
                    }catch (Exception ex){

                    }

                    Intent nuevoJuego = new Intent(MainActivity.this, AnimacionActivity.class);
                    if(nivel == 2) {

                        nuevoJuego.putExtra("nivel", 2);
                    }
                    startActivity(nuevoJuego);
                    finish();
                }
            }, 1000);
        }

    }

    @Override
    public void onBackPressed (){
        mp.stop();
        mp.release();
        mp = null;
        Intent nuevoJuego = new Intent(MainActivity.this, InicioActivity.class);
        startActivity(nuevoJuego);
        finish();
    }

}
