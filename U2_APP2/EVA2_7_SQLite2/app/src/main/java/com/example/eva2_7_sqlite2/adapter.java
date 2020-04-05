package com.example.eva2_7_sqlite2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolderDatos> {
    private List<item> listDatos= new ArrayList<>();
    private Context context;

    private ArrayList<item>itemArrayList;

    public adapter(Context context,ArrayList<item>listDatos) {
        this.listDatos = listDatos;
        this.context = context;
        this.itemArrayList=listDatos;
    }

    @NonNull
    @Override
    public adapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        item item=listDatos.get(position);
        holder.id.setText(String.valueOf(item.getId()));
        holder.nombre.setText(item.getNombre());
        holder.tel.setText(String.valueOf(item.getTel()));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void agregarItem(item item1) {
        listDatos.add(item1);
        this.notifyDataSetChanged();

    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        private TextView id,nombre,tel;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.txtVwid);
            nombre=itemView.findViewById(R.id.txtVwname);
            tel=itemView.findViewById(R.id.txtVwtel);

        }

    }
}
