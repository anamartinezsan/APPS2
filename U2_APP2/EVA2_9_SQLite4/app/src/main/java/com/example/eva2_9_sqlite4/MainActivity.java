package com.example.eva2_9_sqlite4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGuardar;
    EditText etId, etNombres, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);

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
    }
}
