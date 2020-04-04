package com.example.eva2_4_files_resources;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
TextView loremipsum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loremipsum= findViewById(R.id.textView);
    }
    @Override
    protected void onStart(){
        super.onStart();
        InputStream is = getResources().openRawResource(R.raw.loremipsum);
        InputStreamReader isr= new InputStreamReader(is);
        BufferedReader br= new BufferedReader(isr);
        String scade;
        while(true){
            try {
                if ((scade= br.readLine())!=null){
                    loremipsum.append(scade);
                    loremipsum.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
