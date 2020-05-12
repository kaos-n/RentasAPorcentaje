package com.example.rentasaporcentaje.UI.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
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
    private Button btnVolver;
    private TextView TxtDetalle;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fecha = getArguments().getString("fecha");
        }
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
        TxtDetalle.setText("Detalle "+fecha);


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.regresar);
            }
        });
    }
}
