package com.example.puntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText et;
    private EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText)findViewById(R.id.edituser);
        et2 = (EditText)findViewById(R.id.edittPassword);

        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        et.setText(preferences.getString("user", ""));

        if(preferences.contains("user"))
        {
            Intent intent = new Intent(this, Splash.class);
            startActivity(intent);
            finish();
        }

    }

    public void ingresar(View view){
        SharedPreferences preferences = getSharedPreferences("Datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String DatosS = et.getText().toString();
        String pass = et2.getText().toString();

        editor.putString("email", DatosS);
        editor.putString("passwor", pass);

        editor.commit();

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);
        finish();
    }
}