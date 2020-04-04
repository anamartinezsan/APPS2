package com.example.eva2_6_sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGuardar, btnBuscar, btnActualizar, btnBorrar;
    EditText etId, etNombres, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnActualizar  = (Button)findViewById(R.id.btnActulizar);

        etId = (EditText)findViewById(R.id.etId);
        etNombres = (EditText)findViewById(R.id.etNombres);
        etTelefono = (EditText)findViewById(R.id.etTelefono);

        final AyudaBD ayudabd = new AyudaBD(getApplicationContext());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_ID,etId.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRES, etNombres.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_TELEFONOS, etTelefono.getText().toString());

                Long IdGuardado = db.insert(AyudaBD.DatosTabla.NOMBRE_TABLA, AyudaBD.DatosTabla.COLUMNA_ID, valores);
                Toast.makeText(getApplicationContext(), "Se guardó el dato: "+IdGuardado, Toast.LENGTH_LONG).show();

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                SQLiteDatabase db = ayudabd.getReadableDatabase();
                String[] argsel = {etId.getText().toString()};
                String[] projection = {AyudaBD.DatosTabla.COLUMNA_NOMBRES, AyudaBD.DatosTabla.COLUMNA_TELEFONOS};
                Cursor c = db.query(AyudaBD.DatosTabla.NOMBRE_TABLA, projection, AyudaBD.DatosTabla.COLUMNA_ID+"=?",argsel,null,null,null);

                c.moveToFirst();
                etNombres.setText(c.getString(0));
                etTelefono.setText(c.getString(1));
                }
                catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "El objeto no existe", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnBorrar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = ayudabd.getWritableDatabase();
                String Selection = AyudaBD.DatosTabla.COLUMNA_ID+"=?";
                String[] argsel = {etId.getText().toString()};

                db.delete(AyudaBD.DatosTabla.NOMBRE_TABLA,Selection,argsel);





            }
        });

        btnActualizar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = ayudabd.getWritableDatabase();
                ContentValues valores = new ContentValues();
                valores.put(AyudaBD.DatosTabla.COLUMNA_NOMBRES, etNombres.getText().toString());
                valores.put(AyudaBD.DatosTabla.COLUMNA_TELEFONOS, etTelefono.getText().toString());
                String[] argsel = {etId.getText().toString()};
                String Selection = AyudaBD.DatosTabla.COLUMNA_ID+"=?";

                int count = db.update(AyudaBD.DatosTabla.NOMBRE_TABLA,valores,Selection,argsel);

            }
        });
    }
}
