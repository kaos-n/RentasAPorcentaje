package com.example.rentasaporcentaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //findViewById(R.id.btnAceptar).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_action,null));



    }

    @Override
    public void onClick(View view) {
        NavDirections action = Fragment_loginDirections.nextAction();
        Navigation.findNavController(view).navigate(action);


    }
}
