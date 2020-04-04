package com.example.eva2_5_files;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
EditText edTxt;
final String ARCHIVO="mi_archivo.txt";
String sRutaSD;
final int PERMISO_ESCRITURA=1000;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxt=findViewById(R.id.edTxt);
        sRutaSD= getExternalFilesDir(null).getPath();//Environment.getExternalStorageDirectory().getAbsolutePath();
        Toast.makeText(this, sRutaSD, Toast.LENGTH_LONG).show();

        if(ActivityCompat.checkSelfPermission(this, permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISO_ESCRITURA);

        }
    }
    public void onRead(View v){
        try  {
            File file= new File(getExternalFilesDir(null),ARCHIVO);
            //FileInputStream fis=new FileInputStream(sRutaSD);
            //InputStream is = openFileInput(ARCHIVO);
            FileInputStream fis= new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            String scade;
            //while (scade)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void onWrite(){
        String scade=edTxt.getText().toString();
        try {
            File file= new File(getExternalFilesDir(null),ARCHIVO);
            //FileOutputStream fos=new FileOutputStream(sRutaSD);
            FileOutputStream fos= new FileOutputStream(file);
            //OutputStream os = openFileOutput(ARCHIVO, 0);
            OutputStreamWriter osw= new OutputStreamWriter(fos);
            BufferedWriter bw =new BufferedWriter(osw);
            bw.write(scade);
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
