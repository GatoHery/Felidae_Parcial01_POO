package com.JHOB.x00177919;

public class ServicioProfesional extends Empleado {
    private int mesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public ServicioProfesional(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public ServicioProfesional(String nombreD, String numero) {

    }


    public int getMesesContrato() {
        return mesesContrato;
    }
    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreEmpleado + "\nPuesto: " + puesto + "\nTipo de contrato: Servicio Profesional"
                + "\nSalario: " + salario + "\nTiempo de contrato: " + mesesContrato + " meses" ;
    }
}
