package com.example.eva1_8_escenas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
Scene escenaA, escenaB;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup reemplazar=findViewById(R.id.lay2);
        escenaA=Scene.getSceneForLayout(reemplazar, R.layout.escena_a, this);
        escenaB=Scene.getSceneForLayout(reemplazar, R.layout.escena_b, this);
        Transition fade= new Fade();
        TransitionManager.go(escenaA);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void miClick(View v){
        Transition slide=new Slide();
        TransitionManager.go(escenaB,slide);
    }
}
