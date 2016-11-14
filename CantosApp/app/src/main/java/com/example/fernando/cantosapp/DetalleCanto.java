package com.example.fernando.cantosapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

class DetalleCantoActivity extends ActionBarActivity implements View.OnClickListener {

    TextView contenedorCanto;
    TextView tituloCanto;
    Button botonAudio;
    MediaPlayer mPlayer;
    String numeroCanto = "";
    String nombreCanto = "";
    Boolean playOn = false;
    String nombreDelHimnario="";

    Button botonZoomDentro;
    Button getBotonZoomFuera;

    Integer fontSizeDefault = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_canto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contenedorCanto = (TextView) findViewById(R.id.contenidoCanto);
        tituloCanto = (TextView) findViewById(R.id.tituloCanto);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nombreHimnario = (String) bundle.get("NombreHimnario");
        numeroCanto = (String) bundle.get("NumeroCanto");
        nombreCanto = (String) bundle.get("NombreCanto");

        nombreDelHimnario = nombreHimnario;

        MostrarCanto(nombreHimnario, numeroCanto, nombreCanto);

        botonAudio = (Button)findViewById(R.id.botonPlayAudio);
        botonAudio.setOnClickListener(this);

        botonZoomDentro = (Button)findViewById(R.id.botonZoomIN);
        botonZoomDentro.setOnClickListener(this);

        getBotonZoomFuera = (Button)findViewById(R.id.botonZoomOUT);
        getBotonZoomFuera.setOnClickListener(this);


        //contenedorCanto.setText((String) bundle.get("NumeroCanto"));
    }
    private void MostrarCanto(String nombreHimnario, String numeroCanto, String nombreCanto)
    {
        if(nombreHimnario.equals("CantosEHimnosEspirituales"))
        {
            ListaCantosEHimnosEspirituales cantosEHimnosEspirituales = new ListaCantosEHimnosEspirituales();
            contenedorCanto.setText(cantosEHimnosEspirituales.ObtenerCanto(numeroCanto));
            tituloCanto.setText(numeroCanto + "-" + nombreCanto);
        }
        if(nombreHimnario.equals("CantosDelCamino"))
        {
            ListaCantosDelCamino cantosDelCamino = new ListaCantosDelCamino();
            contenedorCanto.setText(cantosDelCamino.ObtenerCanto(numeroCanto));
            tituloCanto.setText(numeroCanto + "-" + nombreCanto);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.botonPlayAudio:

                if(nombreDelHimnario.equals("CantosEHimnosEspirituales")) {
                    if (playOn == false) {

                        //■
                        botonAudio.setText("■");

                        if (numeroCanto.equals("1"))
                            mPlayer = MediaPlayer.create(this, R.raw.uno);
                        if (numeroCanto.equals("2"))
                            mPlayer = MediaPlayer.create(this, R.raw.dos);
                        if (numeroCanto.equals("3"))
                            mPlayer = MediaPlayer.create(this, R.raw.tres);
                        if (numeroCanto.equals("4"))
                            mPlayer = MediaPlayer.create(this, R.raw.cuatro);
                        if (numeroCanto.equals("5"))
                            mPlayer = MediaPlayer.create(this, R.raw.cinco);

                        mPlayer.start();
                        playOn = true;
                    } else {
                        botonAudio.setText("►");
                        playOn = false;
                        mPlayer.stop();
                    }
                }

                if(nombreDelHimnario.equals("CantosDelCamino")) {

                    if (playOn == false) {

                        botonAudio.setText("■");

                        if (numeroCanto.equals("1"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminouno);
                        if (numeroCanto.equals("2"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodos);
                        if (numeroCanto.equals("3"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminotres);
                        if (numeroCanto.equals("4"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminocuatro);
                        if (numeroCanto.equals("5"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminocinco);
                        if (numeroCanto.equals("6"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoseis);
                        if (numeroCanto.equals("7"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminosiete);
                        if (numeroCanto.equals("8"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoocho);
                        if (numeroCanto.equals("9"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminonueve);
                        if (numeroCanto.equals("10"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodiez);

                        if (numeroCanto.equals("11"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoonce);
                        if (numeroCanto.equals("12"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodoce);
                        if (numeroCanto.equals("13"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminotrece);
                        if (numeroCanto.equals("14"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminocatorce);
                        if (numeroCanto.equals("15"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoquince);
                        if (numeroCanto.equals("16"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodieciseis);
                        if (numeroCanto.equals("17"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodiecisiete);
                        if (numeroCanto.equals("18"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodieciocho);
                        if (numeroCanto.equals("19"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminodiecinueve);
                        if (numeroCanto.equals("20"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoveinte);
                        if (numeroCanto.equals("21"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoveintiuno);
                        if (numeroCanto.equals("22"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoveintidos);
                        if (numeroCanto.equals("23"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoveintitres);
                        if (numeroCanto.equals("24"))
                            mPlayer = MediaPlayer.create(this, R.raw.cantocaminoveinticuatro);


                        mPlayer.start();
                        playOn = true;
                    } else {
                        botonAudio.setText("►");
                        playOn = false;
                        mPlayer.stop();
                    }
                }

                break;

            //zoom

            case R.id.botonZoomIN:
                contenedorCanto.setTextSize(fontSizeDefault + 1);
                fontSizeDefault = fontSizeDefault + 1;
                break;

            case R.id.botonZoomOUT:
                contenedorCanto.setTextSize(fontSizeDefault-1);
                fontSizeDefault = fontSizeDefault - 1;
                break;

            default:break;

        }
    }
}