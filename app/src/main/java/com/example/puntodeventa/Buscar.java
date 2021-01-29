package com.example.puntodeventa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {
    EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        et1 = (EditText) findViewById(R.id.txtCd);
        et2 = (EditText) findViewById(R.id.txtNm);
        et3 = (EditText) findViewById(R.id.txtPv);
        et4 = (EditText) findViewById(R.id.txtPu);
    }
    public void modificar(View view){
        BaseD bdD = new BaseD(this, "bd1", null, 1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();

        String codigo =et1.getText().toString();
        String nombre =et1.getText().toString();
        String precioP =et1.getText().toString();
        String precioU =et1.getText().toString();

        if(BaseDatos!=null){
            BaseDatos.execSQL("UPDATE productos SET nombre='"+nombre+"', precioP='"+precioP+"', precioU='"+precioU+"' WHERE Codigo='"+codigo+"' ");
            BaseDatos.close();
        }

        Toast.makeText(this, "Se modifico correctamente", Toast.LENGTH_SHORT).show();
    }
    public void buscar(View view){
        BaseD bdD = new BaseD(this, "bd1", null, 1);
        SQLiteDatabase BaseDatos = bdD.getWritableDatabase();

        String codigo =et1.getText().toString();


        if(!codigo.isEmpty()){
            Cursor fila = BaseDatos.rawQuery("select nombe, precioP, precioU from productos where codigo=" +codigo, null);
            if(fila.moveToFirst()){
                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
                et4.setText(fila.getString(2));

                BaseDatos.close();
            }
        }
        else {
            Toast.makeText(this, "Se modifico codigo no encodntrado", Toast.LENGTH_SHORT).show();
            et1.setText("");
        }


    }



}