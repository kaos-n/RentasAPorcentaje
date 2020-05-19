package com.example.rentasaporcentaje.UI.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.rentasaporcentaje.R;
import com.example.rentasaporcentaje.models.Usuario;
import com.example.rentasaporcentaje.web_methods.Web_Service;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_login extends Fragment {

    public static Usuario usuarioactual;
    private EditText txtUsuario;
    private EditText txtContrasena;
    private Button btnAceptar, btnRegistrar;
    //final String url = "http://10.0.2.2/conexionBD/conexion.php";


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtUsuario = view.findViewById(R.id.txtUsuario);
        txtContrasena = view.findViewById(R.id.txtContrasena);
        btnAceptar = view.findViewById(R.id.btnAceptar);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_registrar_usuario);
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(final View v) {
                final String usuario = txtUsuario.getText().toString();
                final String contrasena = txtContrasena.getText().toString();



                if (usuario.equals("") || contrasena.equals("")) {
                    Toast.makeText(getActivity(), "Debes ingresar tu usuario y contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                Thread tr = new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        final String resultado = enviarDatosGET(usuario,contrasena);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Usuario[] usuarios = new Gson().fromJson(resultado,Usuario[].class);
                                if (usuarios.length>0){
                                    //txtUsuario = getView().findViewById(R.id.txtUsuario);
                                    //usuario = txtUsuario.getText().toString();
                                    Fragment_login.usuarioactual = usuarios[0];

                                    Bundle bundle = new Bundle();
                                    bundle.putString("user",usuario);
                                    Navigation.findNavController(v).navigate(R.id.next_action, bundle);
                                }else{
                                    Toast.makeText(getActivity(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }

                };
                tr.start();

            }
        });


    }


    public String enviarDatosGET (String usu, String pass) {

        URL url = null;
        String linea;
        int respuesta = 0;
        String resul = null;

        try {
            url = new URL("http://10.0.2.2/conexionBD/login.php?usu=" + usu + "&pass=" + pass);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            HashMap<String, String> parameters = new HashMap<>();
            parameters.put("usu",usu);
            parameters.put("pass",pass);

            resul = Web_Service.getJsonPOSTmethod("http://10.0.2.2/conexionBD/login.php",parameters);


        } catch (Exception e) {
            Log.e("Fragment_login", "Error: " +e.getMessage());
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