package com.JHOB.x00177919;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws ErrorInputDataException, InputMismatchException {

        //datos utilizados
        int opcion = 0;
        int trabajo = 0;
        String nombre = "";
        String puesto = "";
        double salario = 0.0;
        Empresa empresa;
        String nombreEmpresa= "";
        String nombreD = "";
        int numero = 0;
        int mesesContrato = 0;
        int telefono = 0;
        String eliminar = "";

        ArrayList<Empleado> em = new ArrayList<>();
        CalculadoraImpuestos imp = new CalculadoraImpuestos();
        ArrayList<Documento> documento = new ArrayList<>();

        //empieza la codificacion

        System.out.print("Nombre de la empresa: ");
        nombreEmpresa = scan.nextLine();

        empresa = new Empresa(nombreEmpresa);


        do {
            try{
                System.out.print( "\nMenu Principal\n" + "1.Agregar empleado\n" + "2.Despedir empleado\n"
                        + "3.ver lista de empleados\n" +
                        "4.Calcular sueldo\n" + "5.Mostrar totales\n" + "0.salir\n" + "Su opcion: ");

                opcion = scan.nextByte(); scan.nextLine();

            }
            catch (InputMismatchException ex){
                System.out.println("Ingrese numeros");
            }
            finally {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del empleado: ");
                        nombre = scan.nextLine();


                        //verificador de que el problema se resolvio o no
                        boolean flag = false;
                        try {
                            flag = false;
                            System.out.print("Puesto del empleado\n 1.ServicioProfesional \t 2.Plaza fija\nSu opcion:");
                            trabajo = scan.nextByte();
                            scan.nextLine();

                            if (trabajo == 1) {
                                flag = true;
                                puesto = "Servicio profesional";

                                System.out.print("Meses de servicio: ");
                                mesesContrato = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Digite salario: ");
                                salario = scan.nextDouble();
                                scan.nextLine();

                                if (salario < 0) {
                                    throw new ErrorInvalidDataException("No existe salario negativo");
                                }

                                ServicioProfesional SP = new ServicioProfesional(nombre, puesto, salario, mesesContrato);
                                empresa.addEmpleado(SP);

                                System.out.println("Ingreso de identificacion");
                                System.out.println("cuantos documetos va a querer llenar?");
                                int doc = scan.nextInt();
                                scan.nextLine();

                                em = empresa.getPlanilla();

                                for (int i = 0; i < doc; i++) {
                                    System.out.print("Nombre de identificacion: ");
                                    nombreD = scan.nextLine();

                                    System.out.print("Numero de identificacion: ");
                                    numero = scan.nextInt();
                                    scan.nextLine();

                                    String aux = numero + "";

                                    String finalNombre = nombre;

                                    String finalNombreD = nombreD;
                                    String finalNumero = aux;

                                    em.forEach(s -> {
                                        if (s.nombreEmpleado == finalNombre) {
                                            s.addDocumento(new Documento(finalNombreD, finalNumero));
                                        }
                                    });
                                }


                            } else if (trabajo == 2) {
                                flag = true;
                                puesto = "Plaza fija";

                                System.out.print("Telefono ");
                                telefono = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Digite salario: ");
                                salario = scan.nextDouble();
                                scan.nextLine();

                                if (salario < 0) {
                                    throw new ErrorInvalidDataException("No existe salario negativo");
                                }

                                System.out.print("Nombre de identificacion: ");
                                nombreD = scan.nextLine();

                                System.out.print("Numero de identificacion: ");
                                numero = scan.nextInt();
                                scan.nextLine();

                                String aux = numero + "";

                                PlazaFija PF = new PlazaFija(nombre, puesto, salario, telefono);
                                empresa.addEmpleado(PF);

                            }

                            if (flag == false)
                                throw new ErrorInvalidDataException("Dato invalido ingreselo de nuevo");
                        }

                        catch(ErrorInvalidDataException ex){
                            System.out.println(ex.getMessage());
                        }

                        catch(InputMismatchException ex){
                            System.out.println("El valor no concuerda");
                        } finally{
                            break;

                        }
                    case 2:
                        em = empresa.getPlanilla();

                        System.out.println("usuario a eliminar: ");
                        eliminar = scan.nextLine();

                        String finalEliminar = eliminar;
                        em.removeIf(s -> s.nombreEmpleado.equals(finalEliminar));

                        empresa.setPlanilla(em);

                        break;
                    case 3:
                        em = empresa.getPlanilla();

                        em.forEach(s -> System.out.println(s.info()));
                        documento.forEach(s -> System.out.println(s.getNombreDocumento() + s.getNumero()));


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
        }
        while (opcion != 0);


    }

    static String menu(){
        return "\nMenu Principal\n" + "1.Agregar empleado\n" + "2.Despedir empleado\n" + "3.ver lista de empleados\n" +
                "4.Calcular sueldo\n" + "5.Mostrar totales\n" + "0.salir\n" + "Su opcion: ";
    }

}

