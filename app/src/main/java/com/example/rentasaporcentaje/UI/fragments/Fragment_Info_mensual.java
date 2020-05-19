package com.example.rentasaporcentaje.UI.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rentasaporcentaje.R;


public class Fragment_Info_mensual extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String FECHA = "strfecha";

    // TODO: Rename and change types of parameters

    private String fecha;
    private String mes, anio, basc, KR, pel, vid, chic, sill, cab, bascWM, KRWM, pelWM, vidWM, chicWM, totalequipos, ingresoPV, rentaPV, ingresoWM, rentaWM, ingresototal, rentatotal;
    private Button btnVolver;
    private TextView TxtDetalle, TxtIngCadenas, TxtRentaCad, TxtIngWM, TxtRentaWM, TxtIngreso, TxtRenta, TxtEquipos, LblBasc, LblKR, LblPel, LblVid, LblChic, LblSill, LblCab, LblBascWM, LblKRWM, LblPelWM, LblVidWM, LblChicWM, LblSillWM, LblCabWM;
    public Fragment_Info_mensual() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Info_mensual.
     */
    // TODO: Rename and change types and number of parameters
/*
    public static Fragment_Info_mensual newInstance(String param1, String param2) {
        Fragment_Info_mensual fragment = new Fragment_Info_mensual();
        Bundle args = new Bundle();
        args.putString(FECHA, FECHA);
        fragment.setArguments(args);
        return fragment;
    }
*/

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Fragment_login:
                Navigation.findNavController(getView()).navigate(R.id.Fragment_login);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mes = getArguments().getString("mes");
            anio = getArguments().getString("anio");
            basc = getArguments().getString("Basc");
            KR = getArguments().getString("KR");
            pel = getArguments().getString("Pel");
            vid = getArguments().getString("Vid");
            chic = getArguments().getString("Chic");
            sill = getArguments().getString("Sill");
            cab = getArguments().getString("Cab");
            bascWM = getArguments().getString("Basc_WM");
            KRWM = getArguments().getString("KR_WM");
            pelWM = getArguments().getString("Pel_WM");
            vidWM = getArguments().getString("Vid_WM");
            chicWM = getArguments().getString("Chic_WM");
            totalequipos = getArguments().getString("Total_Equipos");
            ingresoPV = getArguments().getString("Ingreso_PV");
            rentaPV = getArguments().getString("Renta_PV");
            ingresoWM = getArguments().getString("Ingreso_WM");
            rentaWM = getArguments().getString("Renta_WM");
            ingresototal = getArguments().getString("Ingreso_Total");
            rentatotal = getArguments().getString("Renta_Total");


        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_mensual, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnVolver = view.findViewById(R.id.BtnVolver);
        TxtDetalle = view.findViewById(R.id.TxtDetalle);
        TxtEquipos = view.findViewById(R.id.TxtEquipos);
        TxtIngCadenas = view.findViewById(R.id.TxtIngCadenas);
        TxtIngreso = view.findViewById(R.id.TxtIngreso);
        TxtIngWM = view.findViewById(R.id.TxtIngWM);
        TxtRenta = view.findViewById(R.id.TxtRenta);
        TxtRentaCad = view.findViewById(R.id.TxtRentaCad);
        TxtRentaWM = view.findViewById(R.id.TxtRentaWM);

        LblBasc = view.findViewById(R.id.LblBasc);
        LblBascWM = view.findViewById(R.id.LblBascWM);
        LblCab = view.findViewById(R.id.LblCab);
        LblCabWM = view.findViewById(R.id.LblCabWM);
        LblChic = view.findViewById(R.id.LblChic);
        LblChicWM = view.findViewById(R.id.LblChicWM);
        LblKR = view.findViewById(R.id.LblKR);
        LblKRWM = view.findViewById(R.id.LblKRWM);
        LblPel = view.findViewById(R.id.LblPel);
        LblPelWM = view.findViewById(R.id.LblPelWM);
        LblSill = view.findViewById(R.id.LblSill);
        LblSillWM = view.findViewById(R.id.LblSillWM);
        LblVid = view.findViewById(R.id.LblVid);
        LblVidWM = view.findViewById(R.id.LblVidWM);

        TxtDetalle.setText("Detalle "+ mes+" "+anio);
        TxtEquipos.setText(totalequipos);
        TxtIngCadenas.setText(ingresoPV);
        TxtIngreso.setText(ingresototal);
        TxtIngWM.setText(ingresoWM);
        TxtRenta.setText(rentatotal);
        TxtRentaCad.setText(rentaPV);
        TxtRentaWM.setText(rentaWM);

        LblBasc.setText("Básculas: "+basc);
        LblBascWM.setText("Básculas: "+bascWM);
        LblCab.setText("Cábina: "+cab);
        LblCabWM.setText("Cábina: 0");
        LblChic.setText("Chicleras: "+chic);
        LblChicWM.setText("Chicleras: "+chicWM);
        LblKR.setText("Kiddie Ride: "+KR);
        LblKRWM.setText("Kiddie Ride: "+KRWM);
        LblPel.setText("Pelucheras: "+pel);
        LblPelWM.setText("Pelucheras: "+pelWM);
        LblSill.setText("Sillones: "+sill);
        LblSillWM.setText("Sillones : 0");
        LblVid.setText("Videojuegos: "+vid);
        LblVidWM.setText("Videojuegos: "+vidWM);
        LblKR.setText("Kiddie Ride: "+KR);
        LblKRWM.setText("Kiddie Ride: "+KRWM);



        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.regresar);
            }
        });
    }
}
