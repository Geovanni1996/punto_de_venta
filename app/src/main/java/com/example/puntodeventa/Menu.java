package com.example.puntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void alta (View view){
        Intent intent = new Intent(Menu.this, Registrar.class);
        startActivityForResult(intent, 0);
        finish();

    }

    public void Modificar (View view){
        Intent intent = new Intent(Menu.this, Buscar.class);
        startActivityForResult(intent, 0);
        finish();

    }

    public void Buscar (View view){
        Intent intent = new Intent(Menu.this, Buscar.class);
        startActivityForResult(intent, 0);
        finish();

    }


    public void eliminar (View view){
        Intent intent = new Intent(Menu.this, Eliminar.class);
        startActivityForResult(intent, 0);
        finish();
    }
}