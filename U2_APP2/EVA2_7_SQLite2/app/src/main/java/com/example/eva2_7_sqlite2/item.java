package com.example.eva2_7_sqlite2;

public class item {
    private String id;
    private String nombre;
    private String tel;

    public item(String id, String nombre, String tel) {

        this.id = id;
        this.nombre = nombre;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public item(){

    }
}
