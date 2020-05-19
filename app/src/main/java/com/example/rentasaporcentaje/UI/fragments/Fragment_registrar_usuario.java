package com.example.rentasaporcentaje.UI.fragments;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.rentasaporcentaje.R;
import com.example.rentasaporcentaje.models.Usuario;
import com.example.rentasaporcentaje.web_methods.Web_Service;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_registrar_usuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_registrar_usuario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String usuario, password, nombre, apellido;
    private EditText txtUsuario, txtPassword, txtNombre, txtApellido;
    private Button btnRegistrar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_registrar_usuario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_registrar_usuario.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_registrar_usuario newInstance(String param1, String param2) {
        Fragment_registrar_usuario fragment = new Fragment_registrar_usuario();
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
        return inflater.inflate(R.layout.fragment_registrar_usuario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtUsuario=view.findViewById(R.id.txtUsuarioBD);
        txtPassword=view.findViewById(R.id.txtContrasenaBD);
        txtNombre = view.findViewById(R.id.txtNombreBD);
        txtApellido = view.findViewById(R.id.txtApellidoBD);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                usuario = txtUsuario.getText().toString();
                password = txtPassword.getText().toString();
                nombre = txtNombre.getText().toString();
                apellido = txtApellido.getText().toString();

                if (usuario.equals("") || password.equals("") || nombre.equals("") || apellido.equals("")) {
                    Toast.makeText(getActivity(), "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        final String resultado = enviarDatosGET(usuario,password,nombre,apellido);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonResponse = new JSONObject(resultado);
                                    boolean exitoso = jsonResponse.getBoolean("exitoso");
                                    if (exitoso) {
                                        Toast.makeText(getActivity(),"Usuario dado de alta", Toast.LENGTH_LONG).show();
                                        Navigation.findNavController(v).navigate(R.id.ira_login);
                                    }
                                     else{
                                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                        builder.setMessage("Error al registrar al usuario").setNegativeButton("Reintentar",null).create().show();
                                        Toast.makeText(getActivity(), "Algo salio mal, reintentalo", Toast.LENGTH_SHORT).show();
                                }
                            }catch (JSONException ex){
                                    ex.printStackTrace();

                                }

                            }
                        });

                    }

                };
                tr.start();

            }
        });

    }


    public String enviarDatosGET (String usuario, String password, String nombre, String apellido) {

        URL url = null;
        String linea;
        int respuesta = 0;
        String resul = null;

        try {
            url = new URL("http://10.0.2.2/conexionBD/registrar.php?usuario=" + usuario + "&password=" + password + "&nombre=" + nombre + "&apellido="+apellido);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("usuario",usuario);
            parameters.put("password",password);
            parameters.put("nombre",nombre);
            parameters.put("apellido",apellido);

            resul = Web_Service.getJsonPOSTmethod("http://10.0.2.2/conexionBD/registrar.php",parameters);


        } catch (Exception e) {
            Log.e("Fragment_registrar", "Error: " +e.getMessage());
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