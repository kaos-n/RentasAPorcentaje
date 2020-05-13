package com.example.rentasaporcentaje.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Ingresos {

public double ingtotal(){
    return ingresoTotal;

    }

    public Ingresos(JSONObject objetoJSON) throws JSONException {

        basc = objetoJSON.getInt("Basc");

        KR = objetoJSON.getInt("KR");
        pel = objetoJSON.getInt("Pel");
        vid = objetoJSON.getInt("Vid");
        chic = objetoJSON.getInt("Chic");
        sill = objetoJSON.getInt("Sill");
        cab = objetoJSON.getInt("Cab");
        bascWM = objetoJSON.getInt("Basc_WM");
        KRWM = objetoJSON.getInt("KR_WM");
        pelWM = objetoJSON.getInt("Pel_WM");
        vidWM = objetoJSON.getInt("Vid_WM");
        chicWM = objetoJSON.getInt("Chic_WM");
        totalequipos = objetoJSON.getInt("Total_Equipos");

        ingresoPV = objetoJSON.getDouble("Ingreso_PV");
        rentaPV = objetoJSON.getDouble("Renta_PV");
        ingresoWM = objetoJSON.getDouble("Ingreso_WM");
        rentaWM = objetoJSON.getDouble("Renta_WM");
        ingresoTotal = objetoJSON.getDouble("Ingreso_Total");
        rentaTotal = objetoJSON.getDouble("Renta_Total");


    }

    public int basc, KR, pel, vid, chic, sill, cab, bascWM, KRWM, pelWM, vidWM, chicWM, totalequipos;
    public double ingresoPV, rentaPV, ingresoWM, rentaWM, ingresoTotal, rentaTotal;

}
