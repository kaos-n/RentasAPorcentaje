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
import android.widget.TextView;

import com.example.rentasaporcentaje.R;

import static com.example.rentasaporcentaje.R.*;

public class Fragment_inicio extends Fragment {

    private String usuario;
    private Button BtnRentas;
    public TextView txtBienvenido;

    public Fragment_inicio() {
        // Required empty public constructor
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Fragment_login:
                Navigation.findNavController(getView()).navigate(id.Fragment_login);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            usuario = getArguments().getString("user");
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(layout.fragment_inicio, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Fragment_login.user = new Usuario().getfullname();

        txtBienvenido = view.findViewById(id.txtBienvenido);
        BtnRentas = view.findViewById(id.btnRentas);

        txtBienvenido.setText("Bienvenido \n"+ Fragment_login.usuarioactual.getfullname());

        BtnRentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(id.ir_a_rentas);
            }
        });

    }

}
