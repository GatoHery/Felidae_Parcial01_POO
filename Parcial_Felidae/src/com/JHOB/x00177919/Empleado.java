package com.JHOB.x00177919;

import java.util.ArrayList;

public class Empleado {
    protected String nombreEmpleado;
    protected String puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;



    //metodos de la clase
    public Empleado(String nombre, String puesto, double salario) {
        this.nombreEmpleado = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
    }

    public Empleado(){}

    public String getNombre() {
        return nombreEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumento(Documento archivo){
        documentos.add(archivo);
    }

    public void removeDocumento(String nombre){

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
