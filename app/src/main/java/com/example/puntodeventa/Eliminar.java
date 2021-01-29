package com.example.puntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        et1 = (EditText) findViewById(R.id.txtCdo);
    }

    public void Borrar(View view){
        BaseD bdD = new BaseD(this, "bd1", null, 1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();

        String codigo =et1.getText().toString();


        if(BaseDatos!=null){
            BaseDatos.execSQL("DElete from productos WHERE codigo='"+codigo+"'");

        }
        Toast.makeText(this, "Se elimino correctamente", Toast.LENGTH_SHORT).show();

    }

}