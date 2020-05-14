package com.example.rentasaporcentaje.UI.fragments;

import android.content.pm.LabeledIntent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentasaporcentaje.R;
import com.example.rentasaporcentaje.models.Ingresos;
import com.example.rentasaporcentaje.models.Usuario;
import com.example.rentasaporcentaje.web_methods.Web_Service;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Rentas_por_mes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Rentas_por_mes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    private String mes, anio;
    private Button btnMostrar;
    private Button btnDetalle;
    private TextView TxtMes, LblIngreso, LblRenta, txtIngreso, txtRenta;
    public String basc, KR, pel, vid, chic, sill, cab, bascWM, KRWM, pelWM, vidWM, chicWM, totalequipos, ingresoPV, rentaPV, ingresoWM, rentaWM, ingresototal, rentatotal;


    private Spinner meses, anios;

    public Fragment_Rentas_por_mes() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Rentas_por_mes.
     */
    // TODO: Rename and change types and number of parameters
    /*public static Fragment_Rentas_por_mes newInstance(String param1, String param2) {
        Fragment_Rentas_por_mes fragment = new Fragment_Rentas_por_mes();
        Bundle args = new Bundle();
      //  args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        //}
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

        meses = view.findViewById(R.id.selmes);
        anios = view.findViewById(R.id.selanio);
        btnMostrar = view.findViewById(R.id.btnMostrar);
        TxtMes = view.findViewById(R.id.TxtMes);
        LblIngreso = view.findViewById(R.id.LblIngreso);
        LblRenta = view.findViewById(R.id.LblRenta);
        txtIngreso = view.findViewById(R.id.TxtIngreso);
        txtRenta = view.findViewById(R.id.txtRenta);
        btnDetalle = view.findViewById(R.id.BtnDetalle);

        final String[] selmeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        ArrayAdapter<String> adaptermeses = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, selmeses);
        meses.setAdapter(adaptermeses);

        final String[] selanio = {"2019", "2020"};
        ArrayAdapter<String> adapteranios = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, selanio);
        anios.setAdapter(adapteranios);

        meses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mes=(selmeses[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        anios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                anio=(selanio[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TxtMes.setText(mes + " " + anio);
                TxtMes.setVisibility(View.VISIBLE);
                LblIngreso.setVisibility(View.VISIBLE);
                LblRenta.setVisibility(View.VISIBLE);
                txtIngreso.setVisibility(View.VISIBLE);
                txtRenta.setVisibility(View.VISIBLE);
                btnDetalle.setVisibility(View.VISIBLE);


                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        final String resultado = enviarDatosGET(mes,anio);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {



                                    JsonParser parser = new JsonParser();
                                    JsonArray array = parser.parse(resultado).getAsJsonArray();
                                    for(JsonElement obj : array){
                                        JsonObject object = obj.getAsJsonObject();

                                        ingresototal = object.get("Ingreso_Total").getAsString();
                                        rentatotal = object.get("Renta_Total").getAsString();

                                        txtIngreso.setText(" $ "+ingresototal);
                                        txtRenta.setText(" $ "+rentatotal);

                                        basc = object.get("Basc").getAsString();
                                        KR = object.get("KR").getAsString();
                                        pel = object.get("Pel").getAsString();
                                        vid = object.get("Vid").getAsString();
                                        chic = object.get("Chic").getAsString();
                                        sill = object.get("Sill").getAsString();
                                        cab = object.get("Cab").getAsString();
                                        bascWM = object.get("Basc_WM").getAsString();
                                        KRWM = object.get("KR_WM").getAsString();
                                        pelWM = object.get("Pel_WM").getAsString();
                                        vidWM = object.get("Vid_WM").getAsString();
                                        chicWM = object.get("Chic_WM").getAsString();
                                        totalequipos = object.get("Total_Equipos").getAsString();
                                        ingresoPV = object.get("Ingreso_PV").getAsString();
                                        rentaPV = object.get("Renta_PV").getAsString();
                                        ingresoWM = object.get("Ingreso_WM").getAsString();
                                        rentaWM = object.get("Renta_WM").getAsString();


                                    }
                            }
                        });
                    }
                };
                tr.start();


                btnDetalle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        TxtMes = getView().findViewById(R.id.TxtMes);
                        String fecha = TxtMes.getText().toString();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("mes",mes);
                        bundle2.putString("anio",anio);
                        bundle2.putString("Basc",basc);
                        bundle2.putString("KR",KR);
                        bundle2.putString("Pel",pel);
                        bundle2.putString("Vid",vid);
                        bundle2.putString("Chic",chic);
                        bundle2.putString("Sill",sill);
                        bundle2.putString("Cab",cab);
                        bundle2.putString("Basc_WM",bascWM);
                        bundle2.putString("KR_WM",KRWM);
                        bundle2.putString("Pel_WM",pelWM);
                        bundle2.putString("Vid_WM",vidWM);
                        bundle2.putString("Chic_WM",chicWM);
                        bundle2.putString("Total_Equipos",totalequipos);
                        bundle2.putString("Ingreso_PV",ingresoPV);
                        bundle2.putString("Renta_PV",rentaPV);
                        bundle2.putString("Ingreso_WM",ingresoWM);
                        bundle2.putString("Renta_WM",rentaWM);
                        bundle2.putString("Ingreso_Total",ingresototal);
                        bundle2.putString("Renta_Total",rentatotal);


                        Navigation.findNavController(v).navigate(R.id.ir_a_detalle, bundle2);
                    }
                });
            }
        });
    }

    public String enviarDatosGET (String mes, String anio) {

        URL url = null;
        String linea;
        int respuesta = 0;
        String resul = null;

        try {
            url = new URL("http://10.0.2.2/conexionBD/ingresos.php?mes=" + mes + "&anio=" + anio);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("mes",mes);
            parameters.put("anio",anio);

            resul = Web_Service.getJsonPOSTmethod("http://10.0.2.2/conexionBD/ingresos.php",parameters);


        } catch (Exception e) {
            Log.e("Fragment_Rentas_por_mes", "Error: " +e.getMessage());
        }
        return resul.toString();
    }

    public int obtDatosJSON (String response){
        int res=0;
        try{
            JSONArray json = new JSONArray(response);
            if(json.length()>0){
                res=1;
            }
        } catch (Exception e){}

        return res;
    }
}