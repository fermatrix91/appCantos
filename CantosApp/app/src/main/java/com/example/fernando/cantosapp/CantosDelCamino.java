package com.example.fernando.cantosapp;

/**
 * Created by Fernando on 17/07/2016.
 */
public class CantosDelCamino {
    public String numero;
    public String nombre;


    public CantosDelCamino()
    {
        super();
    }

    public CantosDelCamino(String numero, String nombre)
    {
        super();
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getName() {
        return nombre;
    }
    public String getNumero()
    {
        return numero;
    }
}
