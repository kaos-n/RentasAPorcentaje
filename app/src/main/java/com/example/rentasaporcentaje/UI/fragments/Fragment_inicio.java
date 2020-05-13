package com.example.rentasaporcentaje.UI.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentasaporcentaje.R;
import com.example.rentasaporcentaje.models.Usuario;
import com.example.rentasaporcentaje.web_methods.Web_Service;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Fragment_inicio extends Fragment {

    private String usuario;
    private Button BtnRentas;
    public TextView txtBienvenido;

    public Fragment_inicio() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getString("user");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Fragment_login.user = new Usuario().getfullname();

        txtBienvenido = view.findViewById(R.id.txtBienvenido);
        BtnRentas = view.findViewById(R.id.btnRentas);

        txtBienvenido.setText("Bienvenido \n"+ Fragment_login.usuarioactual.getfullname());

        BtnRentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.ir_a_rentas);
            }
        });

    }

}
