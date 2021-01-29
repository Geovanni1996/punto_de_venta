package com.example.puntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registrar extends AppCompatActivity {
    EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        et1 = (EditText) findViewById(R.id.txtCod);
        et2 = (EditText) findViewById(R.id.txtnom);
        et3 = (EditText) findViewById(R.id.txtprp);
        et4 = (EditText) findViewById(R.id.txtpru);
    }

    public void alta (View view){
        BaseD bdD = new BaseD(this, "bd1", null, 1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();

        String codigo =et1.getText().toString();
        String nombre =et2.getText().toString();
        String precioP =et3.getText().toString();
        String precioU =et4.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !precioP.isEmpty() && !precioU.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("PrecioP", precioP);
            registro.put("precioU", precioU);

            BaseDatos.insert("productos", null, registro);
            BaseDatos.close();

            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
        }else{
            if(codigo.isEmpty())
                et1.setError("Ingresa camopo");

            if(nombre.isEmpty())
                et2.setError("Ingresa camopo");

            if(precioP.isEmpty())
                et3.setError("Ingresa camopo");

            if(precioU.isEmpty())
                et4.setError("Ingresa camopo");

        }
    }

}