package com.example.eva1_5_fragnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        BtnFrag btnFrag = new BtnFrag();

        ft.replace(R.id.frmLyFrag, btnFrag);
        ft.commit();
    }

}
