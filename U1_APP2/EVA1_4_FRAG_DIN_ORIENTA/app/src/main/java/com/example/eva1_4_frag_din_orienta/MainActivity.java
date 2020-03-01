package com.example.eva1_4_frag_din_orienta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
FrameLayout frmLyDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMessageFromFragToMain(){
        frmLyDetail=findViewById(R.id.frmLyDetail);
        if(frmLyDetail!=null){//landscape
            //crear fragmento dos dinámicamente
        }else{//portrait
            //lanzar la actividad secundaria con intento
        }

    }
}
