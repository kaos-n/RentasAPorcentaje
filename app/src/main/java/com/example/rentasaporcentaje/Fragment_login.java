package com.example.rentasaporcentaje;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class Fragment_login extends Fragment {

    private EditText txtUsuario, txtContrasena;
    private Button btnAceptar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtUsuario = view.findViewById(R.id.txtUsuario);
        txtContrasena = view.findViewById(R.id.txtContrasena);
        btnAceptar = view.findViewById(R.id.btnAceptar);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtUsuario.getText().toString();
                String contrasena = txtContrasena.getText().toString();

                if (usuario.equals("") || contrasena.equals("")) {
                    Toast.makeText(getActivity(), "Debes ingresar tu usuario y contraseña", Toast.LENGTH_SHORT).show();
                } else {

                    Navigation.findNavController(v).navigate(R.id.next_action);
                }

            }
        });


    }
}