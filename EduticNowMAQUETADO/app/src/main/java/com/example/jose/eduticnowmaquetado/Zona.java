package com.example.jose.eduticnowmaquetado;

/**
 * Created by JoseLHM on 23/05/2016.
 */
public class Zona {

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getRadio_() {
        return radio_;
    }

    public void setRadio_(int radio_) {
        this.radio_ = radio_;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double latitud;
    public double longitud;
    public int radio_;
    public String informacion;
    public  int nivel;

    public  Zona(double lt,double lg,int r,String info, int niv)
    {
        this.latitud =lt;
        this.longitud = lg;
        this.radio_ =r;
        this.informacion = info;
        this.nivel = niv;
    }
}
