package com.JHOB.x00177919;

public class Documento {
    private String nombre;
    private String numero;

    //metodos

    public Documento(String nombre1, String numero) {
        this.nombre = nombre1;
        this.numero = numero;
    }

    public String getNombreDocumento() {
        return nombre;
    }

    public String getNumero() {
        return numero;
    }

}
