package com.example.rentasaporcentaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAceptar;
    private TextView txtBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


    }
    //esta deberia ser la forma de pasar datos
    /*
     @Override
    public void onClick(View view) {
       EditText amountTv = (EditText) getView().findViewById(R.id.editTextAmount);
       int amount = Integer.parseInt(amountTv.getText().toString());
       ConfirmationAction action =
               SpecifyAmountFragmentDirections.confirmationAction()
       action.setAmount(amount)
       Navigation.findNavController(view).navigate(action);
    }

     */

    @Override
    public void onClick(View view) {

        EditText txtBienvenido = (EditText)getView().findViewById(R.id.txtBienvenido);
        int usuario = Integer.parseInt(txtBienvenido.getText().toString());
        Fragment_loginDirections.NextAction action = Fragment_loginDirections.nextAction()action.setUsuario(usuario));
        Navigation.findNavController(view).navigate(action);


    }
}
