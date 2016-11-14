package com.example.fernando.cantosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class HimnariosActivity extends ActionBarActivity implements View.OnClickListener {

    Button botonHimnosCantosEspirituales;
    Button botonHimnosCantosDelCamino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_himnarios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        botonHimnosCantosEspirituales = (Button) findViewById(R.id.botonHimnosYCanticosEspirituales);
        botonHimnosCantosEspirituales.setOnClickListener(this);

        botonHimnosCantosDelCamino = (Button)findViewById(R.id.botonCantosDelCamino);
        botonHimnosCantosDelCamino.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.botonHimnosYCanticosEspirituales:
                Intent intentEspirituales = new Intent(this,IndiceHimnariosActivity.class);
                intentEspirituales.putExtra("NOMBREHIMNARIO", "Himnos y Cánticos Espirituales");
                startActivity(intentEspirituales);

                break;

            case R.id.botonCantosDelCamino:
                Intent intentDelCamino = new Intent(this,IndiceHimnariosActivity.class);
                intentDelCamino.putExtra("NOMBREHIMNARIO", "Cantos del Camino");
                startActivity(intentDelCamino);
        }
    }
}
