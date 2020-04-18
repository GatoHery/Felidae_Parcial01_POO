package com.JHOB.x00177919;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;


    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }


    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void addEmpleado(Empleado empleado){
        planilla.add(empleado);
    }

    public void quitEmpleado(String eliminar){
        planilla.removeIf(s-> s.nombreEmpleado == eliminar);

    }

    public void setPlanilla(ArrayList<Empleado> planilla) {
        this.planilla = planilla;
    }
}
