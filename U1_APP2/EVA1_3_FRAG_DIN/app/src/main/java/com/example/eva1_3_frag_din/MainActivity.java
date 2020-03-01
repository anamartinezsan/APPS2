package com.example.eva1_3_frag_din;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void click2(View view) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        frag2 dos= new frag2();
        ft.replace(R.id.fragmento, dos);
        ft.commit();
    }

    public void click1(View view) {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        frag1 uno= new frag1();
        ft.replace(R.id.fragmento, uno);
        ft.commit();
    }
}
