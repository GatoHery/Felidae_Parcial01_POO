package com.JHOB.x00177919;

public class ServicioProfesional extends Empleado{
    private int mesesContrato;

    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public ServicioProfesional(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public String info(){
        return "Nombre: " + nombreEmpleado + "\nPuesto: " + puesto + "\nSalario: " + salario +
                "\nContrato: " + mesesContrato + " meses";
    }
}
