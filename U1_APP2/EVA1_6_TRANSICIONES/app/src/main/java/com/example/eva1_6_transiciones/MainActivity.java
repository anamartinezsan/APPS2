package com.example.eva1_6_transiciones;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
Intent inLlamar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setExitTransition(new Slide().setDuration(500));
        //getWindow().setEnterTransition(new Slide().setDuration(500));
        setContentView(R.layout.activity_main);
        inLlamar=new Intent(this,dos.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void click(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(inLlamar, ActivityOptions.makeSceneTransitionAnimation(this.toBundle()));
        }

    }
}
