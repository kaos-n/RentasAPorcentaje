package com.example.rentasaporcentaje;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Rentas_por_mes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rentas_por_mes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnMostrar;
    private Button btnDetalle;
    private TextView TxtMes;
    private TextView LblIngreso, LblRenta, txtIngreso, txtRenta;

    public Rentas_por_mes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Rentas_por_mes.
     */
    // TODO: Rename and change types and number of parameters
    public static Rentas_por_mes newInstance(String param1, String param2) {
        Rentas_por_mes fragment = new Rentas_por_mes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rentas_por_mes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnMostrar = view.findViewById(R.id.btnMostrar);
        TxtMes = view.findViewById(R.id.txtMes);
        LblIngreso = view.findViewById(R.id.LblIngreso);
        LblRenta = view.findViewById(R.id.LblRenta);
        txtIngreso = view.findViewById(R.id.TxtIngreso);
        txtRenta = view.findViewById(R.id.txtRenta);
        btnDetalle = view.findViewById(R.id.BtnDetalle);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LblIngreso.setVisibility(View.VISIBLE);
                LblRenta.setVisibility(View.VISIBLE);
                txtIngreso.setVisibility(View.VISIBLE);
                txtRenta.setVisibility(View.VISIBLE);
                btnDetalle.setVisibility(View.VISIBLE);
            }


        });
        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.ir_a_detalle);
            }
        });
    }
}
