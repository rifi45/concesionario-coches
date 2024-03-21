package es.madrid.parla.tierno.entrada_aleatorios_datos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static int leerNumero(){
        int numero = 0; 
        boolean comprobar = false;

        do{
            try{
                numero = scanner.nextInt();
    
                if(numero < 0) throw new InputMismatchException();
                comprobar = true;
            }catch(InputMismatchException e){
                System.out.println("HA SUCEDIDO UN ERROR");
                System.out.print("INTRODUZCA EL DATO DE NUEVO : ");
            }finally{
                scanner.nextLine();
            }
        }while(comprobar == false);

        return numero;
    }


    public static String leerTexto(){
        return scanner.nextLine();
    }

    public static boolean LeerSiNO(){
        String cadena = "";
        while(true){
            cadena = scanner.nextLine();
            if(cadena.equalsIgnoreCase("si")) return true;
                if(cadena.equalsIgnoreCase("no")) return false;
                System.out.println("HA SUCEDIDO UN ERROR");
                    System.out.print("INTRODUZCA EL DATO DE NUEVO : ");
        }
    }

    public static Double leerDouble(){
        Double numero = 0.0;
        boolean comprobar = false;

        do{
            try{
                numero = scanner.nextDouble();
    
                if(numero < 0) throw new InputMismatchException();
                comprobar = true;
            }catch(InputMismatchException e){
                System.out.println("HA SUCEDIDO UN ERROR");
                    System.out.print("INTRODUZCA EL DATO DE NUEVO : ");
            }finally{
                scanner.nextLine();
            }
        }while(comprobar == false);

        return numero;
    }
}
