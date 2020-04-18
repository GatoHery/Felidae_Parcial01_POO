package com.JHOB.x00177919;

public class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double AFP ;

    //metodos
    CalculadoraImpuestos(){}

    public double calcularPago(Empleado empleado){
        double renta = 0;
        double pagoFinal = 0;
        double AFP = 0;
        double ISSS = 0;
        double restante = 0;

        if(empleado.puesto == "Servicio profesional"){
            renta = empleado.salario;
            renta *= 0.1;

            totalRenta += renta;
            pagoFinal = empleado.salario - renta;

        }
        else if(empleado.puesto == "Plaza fija") {
            AFP = empleado.salario;
            AFP *= 0.0625;

            this.AFP += AFP;

            ISSS = empleado.salario;
            ISSS *= 0.03;

            totalISSS += ISSS;
            restante = empleado.salario - AFP - ISSS;

            if(restante >= 0.01 && restante <= 472){
                renta = 0;
                totalRenta += renta;
                System.out.println("No hay descuento!");
                pagoFinal = restante - renta;

            }
            else if(restante >= 472.01 && restante <= 895.24){
                renta = 0.1*(restante - 472) + 17.67;
                totalRenta += renta;
                System.out.println("Su descuento de renta es: " + renta );
                pagoFinal = restante - renta;

            }
            else if(restante >= 895.25 && restante <= 2038.10){
                renta = 0.2*(restante - 895.24) + 60;
                totalRenta += renta;
                System.out.println("Su descuento de renta es : " + renta);
                pagoFinal = restante - renta;

            }
            else if(restante >= 2038.11){
                renta = 0.3*(restante -2038.10) + 288.57;
                totalRenta += renta;
                System.out.println("Su descuento de renta es : " + renta);
                pagoFinal = restante - renta;

            }
            return pagoFinal;
        }
        return pagoFinal;
    }

    public String mostrarTotales(){
        return "Totales:\n " + "AFP: " + this.AFP + "\nISSS: " + totalISSS + "\nRenta: " + totalRenta ;


    }

}
