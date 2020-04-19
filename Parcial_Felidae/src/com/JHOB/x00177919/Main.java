package com.JHOB.x00177919;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Empleado empleado;
    public static void main(String[] args) throws ErrorInputDataException, InputMismatchException {

        //datos utilizados
        int opcion = 0;
        int trabajo = 0;
        String nombreEmpleado = "";
        String puesto = "";
        double salario = 0.0;
        Empresa empresa;
        String nombreEmpresa= "";
        String nombreD = "";
        String numero = "";
        int mesesContrato = 0;
        int extension = 0;
        String eliminar = "";

        ArrayList<Empleado> em = new ArrayList<>();
        CalculadoraImpuestos imp = new CalculadoraImpuestos();
        ArrayList<Documento> dm = new ArrayList<>();

        //empieza la codificacion

        System.out.print("Nombre de la empresa: ");
        nombreEmpresa = scan.nextLine();

        empresa = new Empresa(nombreEmpresa);


        do {
            boolean continuar = false;
            do{
                try{
                    continuar = false;

                    System.out.print(menu());
                    opcion = scan.nextByte(); scan.nextLine();

                }
                catch (InputMismatchException ex){
                    scan.nextLine();
                    System.out.println("Ingrese numeros...");
                    continuar = true;
                }

            }
            while (continuar);

            switch (opcion) {
                case 1:
                    System.out.print("\nNombre del empleado: ");
                    nombreEmpleado = scan.nextLine();
                    System.out.print("Puesto del empleado: ");
                    puesto = scan.nextLine();


                    //verificador de que el problema se resolvio o no
                    boolean flag = false;
                    do {
                        try {
                            flag = false;
                            System.out.print("\nContrato del empleado \n1.Servicio Profesional \n2.Plaza fija \nSu opcion:");
                            trabajo = scan.nextByte();
                            scan.nextLine();

                            if (trabajo == 1) {
                                System.out.print("Digite salario: ");
                                salario = scan.nextDouble();
                                scan.nextLine();

                                System.out.print("Meses de servicio: ");
                                mesesContrato = scan.nextInt();
                                scan.nextLine();

                                if (salario <= 0) {
                                    throw new ErrorInvalidDataException("Ingrese un salario valido");
                                }

                                ServicioProfesional SP = new ServicioProfesional(nombreEmpleado, puesto, salario, mesesContrato);
                                empresa.addEmpleado(SP);

                                System.out.println("\nIngreso de identificacion");
                                System.out.print("Cuantos documetos desea ingresar? ");
                                int doc = scan.nextInt();
                                scan.nextLine();

                                for (int i = 0; i < doc; i++) {
                                    System.out.print("Nombre de identificacion: ");
                                    nombreD = scan.nextLine();

                                    System.out.print("Numero de identificacion: ");
                                    numero = scan.nextLine();

                                    empleado = new ServicioProfesional(nombreD, numero);
                                }


                            } else if (trabajo == 2) {
                                System.out.print("Digite salario: ");
                                salario = scan.nextDouble();
                                scan.nextLine();

                                System.out.print("Telefono ");
                                extension = scan.nextInt();
                                scan.nextLine();

                                if (salario <= 0) {
                                    throw new ErrorInvalidDataException("Ingresar un salario valido");
                                }
                                PlazaFija PF = new PlazaFija(nombreEmpleado, puesto, salario, extension);
                                empresa.addEmpleado(PF);

                                System.out.println("\nIngreso de identificacion");
                                System.out.print("Cuantos documetos desea ingresar? ");
                                int docu = scan.nextInt();
                                scan.nextLine();

                                for (int i = 0; i < docu; i++) {
                                    System.out.print("Nombre de identificacion: ");
                                    nombreD = scan.nextLine();

                                    System.out.print("Numero de identificacion: ");
                                    numero = scan.nextLine();

                                    empleado = new PlazaFija(nombreD, numero);

                                }


                            }
                        } catch (ErrorInvalidDataException ex) {
                            System.out.println(ex.getMessage());
                            flag = true;
                        } catch (InputMismatchException ex) {
                            scan.nextLine(); System.out.println("El valor no concuerda");
                            flag= true;
                        }

                    }while (flag);
                    break;
                case 2:
                    em = empresa.getPlanilla();

                    System.out.println("Empleado a despedir: ");
                    eliminar = scan.nextLine();

                    String finalEliminar = eliminar;
                    em.removeIf(s -> s.nombreEmpleado.equals(finalEliminar));

                    empresa.setPlanilla(em);
                    break;
                case 3:
                    em = empresa.getPlanilla();

                    em.forEach(s -> System.out.println("\nDatos del empleado\n" + s.toString()));
                    dm.forEach(s-> System.out.println("\nDocumentos\n " + s.toString()));


                    break;
                case 4:
                    em = empresa.getPlanilla();
                    for (Empleado e : em) {
                        System.out.println("Empleado: " + e.nombreEmpleado);
                        System.out.println("Puesto: " + e.puesto);
                        System.out.println("Su sueldo es de: " + imp.calcularPago(e));
                        System.out.println("\n");
                    }

                    break;
                case 5:
                    System.out.println(imp.mostrarTotales());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Valor incorrecto");
            }


        }
        while (opcion != 0);
    }

    static String menu(){
        return "\nMenu Principal\n" + "1.Agregar empleado\n" + "2.Despedir empleado\n" + "3.ver lista de empleados\n" +
                "4.Calcular sueldo\n" + "5.Mostrar totales\n" + "0.salir\n" + "Su opcion: ";
    }

}


