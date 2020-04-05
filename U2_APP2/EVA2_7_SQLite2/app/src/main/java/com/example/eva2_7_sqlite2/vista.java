package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class vista extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<item> itemArrayList;
private adapter adapter;
AyudaBD sqlLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);
        recyclerView=findViewById(R.id.recycler);
        itemArrayList= new ArrayList<>();
        sqlLite=new AyudaBD(this);

        RecyclerView recyclerView= findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(adapter);
        mostrarDatos();
    }



    public void mostrarDatos(){
        SQLiteDatabase sqLiteDatabase=sqlLite.getReadableDatabase();
        item item=null;
        Cursor cursor=sqLiteDatabase.rawQuery("select * from item",null);
        while (cursor.moveToNext()){
            item= new item();
            item.setId(cursor.getString(0));
            item.setNombre(cursor.getString(1));
            item.setTel(cursor.getString(2));
            adapter.agregarItem(item);
        }
    }
}
