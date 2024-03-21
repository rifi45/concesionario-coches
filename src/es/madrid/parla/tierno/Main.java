package es.madrid.parla.tierno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import es.madrid.parla.tierno.entrada_aleatorios_datos.*;
import es.madrid.parla.tierno.modelo.*;
import es.madrid.parla.tierno.dao_bbdd.*;

/*
 * @autor Mohamed Afallah
 * @version 1.0
 */

public class Main {

    static ArrayList<Tienda> tiendas = new ArrayList<>();
    
    static Random random = new Random();
    public static void main(String[] args) throws Exception {
        int opcion = 0;
        tiendas = DAOBaseDatos.visualizarTiendas();
        DAOBaseDatos.visualizarVehiculo(tiendas);
        do{
        System.out.print("1-CREAR UNA TIENDA\n2-CREAR VEHICULO\n3-CONSULTAR VEHICULOS\n4-ALQUILAR O DEVOLVER UN VEHICULO\n5-SALIR\nOPCION:");
        opcion = Entrada.leerNumero();

        switch (opcion) {
            case 1:
                crearTienda();
                break;
            case 2:
                crearVehiculos();
                break;
            case 3:
                mostrarVehiculosDisponibles();
                break;
            case 4:
                alquilarDevolver();
                break;
            case 5:
                System.out.println("SALIENDO ......");
                break;
        
            default:
            System.out.println("INTRODUZCA UNA OPCION VALIDA");
                break;
        }

        }while(opcion != 5);
    }

    //metodo para crear una tienda
    private static void crearTienda() throws ClassNotFoundException, SQLException{
        boolean comprobarNombre = false;
        boolean comprobarURL = false;
        String nombre = "";
        String direccion = "";
        do{
            System.out.print("INTRODUZCA EL NOMBRE DE LA TIENDA: ");
            nombre = Entrada.leerTexto();
            comprobarNombre = comprobarNombre(nombre);
        }while(comprobarNombre == false);
        do{
            System.out.print("INTRODUZCA LA DIRECCION URL DE LA TIENDA: ");
            direccion = Entrada.leerTexto();
            comprobarURL = comprobarURL(direccion);
        }while(comprobarURL == false);


        Tienda tienda = new Tienda(nombre, direccion);
        DAOBaseDatos.insertarTiendas(tienda);

        tiendas.add(tienda);

    }

     //metodo que sirve para crear un vehiculo
     private static void crearVehiculos() throws ClassNotFoundException, SQLException{
        int numeroTienda = elegirTienda();
        int opcionVehiculoCrear = elegirTipoVehiculo();

        if(opcionVehiculoCrear == 1){
            Vehiculo coche = crearCoche();
            tiendas.get(numeroTienda).crearVehiculos(coche);
            DAOBaseDatos.insertarVehiculo(tiendas.get(numeroTienda).getNombre(), coche);
        }else if(opcionVehiculoCrear == 2){
            Vehiculo camion = crearCamion();
            tiendas.get(numeroTienda).crearVehiculos(camion);
            DAOBaseDatos.insertarVehiculo(tiendas.get(numeroTienda).getNombre(), camion);

        }else if(opcionVehiculoCrear == 3){
            Vehiculo futgoneta = crearFurgoneta();
            tiendas.get(numeroTienda).crearVehiculos(futgoneta);
            DAOBaseDatos.insertarVehiculo(tiendas.get(numeroTienda).getNombre(), futgoneta);
            
        }else if(opcionVehiculoCrear == 4){
            Vehiculo moto = crearMoto();
            tiendas.get(numeroTienda).crearVehiculos(moto);
            DAOBaseDatos.insertarVehiculo(tiendas.get(numeroTienda).getNombre(), moto);
        }
    }

    //metodo que sirve para crear un coche
    private static Coche crearCoche(){
        boolean comprobarMatricula = false;
        String matricula = "0000XXX";
        
        do{
            System.out.print("INTRODUZCA LA MATRICULA: ");
            matricula = Entrada.leerTexto();
            comprobarMatricula = comprobarMatricula(matricula);
        }while(comprobarMatricula == false);

        //DATOS QUE ALEATORIOS PARA ESTOS 3 ATRIBUTOS
        String marca = VehiculosDatosAleatorios.marcas[random.nextInt(4)];
        String modelo = VehiculosDatosAleatorios.modelos[random.nextInt(4)];
        int anio = VehiculosDatosAleatorios.anios[random.nextInt(4)];
        System.out.print("INTRODUZCA EL NUMERO DE PUERTAS: ");
        int numeroPuertas = Entrada.leerNumero();
        System.out.print("INTRODUZCA TIPO DE COMBUSTTIBLE: ");
        String tipoCombustible = Entrada.leerTexto();

        Coche coche  = new Coche(marca, matricula, modelo, anio, numeroPuertas, tipoCombustible);
        
        return coche;
        
    }

    //Metodo que sirve para crear un camion
    private static Camion crearCamion(){
        boolean comprobarMatricula = false;
        String matricula = "0000XXX";
        
        do{
            System.out.print("INTRODUZCA LA MATRICULA: ");
            matricula = Entrada.leerTexto();
            comprobarMatricula = comprobarMatricula(matricula);
        }while(comprobarMatricula == false);

        String marca = VehiculosDatosAleatorios.marcas[random.nextInt(4)];
        String modelo = VehiculosDatosAleatorios.modelos[random.nextInt(4)];
        int anio = VehiculosDatosAleatorios.anios[random.nextInt(4)];
        System.out.print("INTRODUZCA EL NUMERO DE PUERTAS: ");
        Double capacidadCarga = Entrada.leerDouble();
        System.out.print("INTRODUZCA TIPO DE REMOLQUE: ");
        String tipoRemolque = Entrada.leerTexto();

        Camion camion = new Camion(marca, matricula, modelo, anio, capacidadCarga, tipoRemolque);

        return camion;
    }

    //Metodo que sirve para crear una furgoneta
    private static Furgoneta crearFurgoneta(){
        boolean comprobarMatricula = false;
        String matricula = "";
        
        do{
            System.out.print("INTRODUZCA LA MATRICULA: ");
            matricula = Entrada.leerTexto();
            comprobarMatricula = comprobarMatricula(matricula);
        }while(comprobarMatricula == false);

        String marca = VehiculosDatosAleatorios.marcas[random.nextInt(4)];
        String modelo = VehiculosDatosAleatorios.modelos[random.nextInt(4)];
        int anio = VehiculosDatosAleatorios.anios[random.nextInt(4)];
        System.out.print("INTRODUZCA EL NUMERO DE PUERTAS: ");
        Double capacidadCarga = Entrada.leerDouble();
        
        Furgoneta furgoneta = new Furgoneta(marca, matricula, modelo, anio, capacidadCarga);

        return furgoneta;
    }
    //Metodo que sirve para crear una moto
    private static Moto crearMoto(){
        boolean comprobarMatricula = false;
        String matricula = "0000XXX";
        
        do{
            System.out.print("INTRODUZCA LA MATRICULA: ");
            matricula = Entrada.leerTexto();
            comprobarMatricula = comprobarMatricula(matricula);
        }while(comprobarMatricula == false);

        String marca = VehiculosDatosAleatorios.marcas[random.nextInt(4)];
        String modelo = VehiculosDatosAleatorios.modelos[random.nextInt(4)];
        int anio = VehiculosDatosAleatorios.anios[random.nextInt(4)];
        System.out.print("INTRODUZCA LA CILINDRADA: ");
        int cilindrada = Entrada.leerNumero();
        System.out.print("INTRODUZCA TIPO DE TRANSMISION: ");
        String tipoTransmision = Entrada.leerTexto();

        Moto moto = new Moto(marca, matricula, modelo, anio, cilindrada, tipoTransmision);

        return moto;
    }

    private static int mostrarVehiculosDisponibles(){
        int numeroTienda = elegirTienda();

        if(!tiendas.isEmpty()){
            if(!tiendas.get(numeroTienda).getVehiculos().isEmpty()){
                System.out.println("TIENDA: " + tiendas.get(numeroTienda).getNombre());
                System.out.println("--------------------------------------");
                for(int i = 0; i < tiendas.get(numeroTienda).getVehiculos().size(); i++){
                    if(tiendas.get(numeroTienda).getVehiculos().get(i) instanceof Coche){
                        System.out.println("EL VEHICULO ES UN COCHE");
                        mostrarInformacionVehiculo(numeroTienda, i);
                    }else if(tiendas.get(numeroTienda).getVehiculos().get(i) instanceof Camion){
                        System.out.println("EL VEHICULO ES UN CAMION");
                        mostrarInformacionVehiculo(numeroTienda, i);
                    }else if(tiendas.get(numeroTienda).getVehiculos().get(i) instanceof Furgoneta){
                        System.out.println("EL VEHICULO ES UNA FURGONETA");
                        mostrarInformacionVehiculo(numeroTienda, i);
                    }else if(tiendas.get(numeroTienda).getVehiculos().get(i) instanceof Moto){
                        System.out.println("EL VEHICULO ES UNA MOTO");
                        mostrarInformacionVehiculo(numeroTienda, i);
                    }
                    
                }
            }else{
                System.out.println("---NO HAY VEHICULOS DISPONIBLES---");
                numeroTienda = -1;
            }
        }

        return numeroTienda;
    }

    //METODO PARA MOSTRAR INFORMACION
    private static void mostrarInformacionVehiculo(int numeroTienda, int i){
        System.out.println("MATRICULA: " + tiendas.get(numeroTienda).getVehiculos().get(i).getMatricula());
        System.out.println("MARCA: " + tiendas.get(numeroTienda).getVehiculos().get(i).getMarca());
        System.out.println("MODELO: " + tiendas.get(numeroTienda).getVehiculos().get(i).getModelo());
        String estadoVehiculo = (tiendas.get(numeroTienda).getVehiculos().get(i).isEstadoVehiculo())? "SI" : "NO" ;
        System.out.println("DISPONIBLE: " + estadoVehiculo);
        System.out.println("--------------------------------------");
    }

    private static void alquilarDevolver(){
        int opcion = 0;

            System.out.print("1-ALQUILAR\n2-DEVOLVER\nOPCION:");
            opcion = Entrada.leerNumero();
            switch (opcion) {
                case 1:
                    alquilarODevolverUnVehiculo("alquilar");
                    break;
                case 2:
                    alquilarODevolverUnVehiculo("devolver");
                    break;       
                default:
                    System.out.println("OPCION NO ES VALIDA");
                    break;
            }
    }

    private static void alquilarODevolverUnVehiculo(String opcion){
        String matricula = "";
        int numeroTienda = mostrarVehiculosDisponibles();
        boolean matriculaEncontrada = false;
        boolean alquilado = false;
        boolean devuelto = false; 

        if(numeroTienda != -1){
            System.out.print("INTRODUZCA LA MATRICULA DEL VEHICULO QUE DESEA ALQUILAR : ");
            matricula = Entrada.leerTexto();
            for(int i = 0; i < tiendas.get(numeroTienda).getVehiculos().size(); i++){
                if(tiendas.get(numeroTienda).getVehiculos().get(i).getMatricula().equalsIgnoreCase(matricula)){
                    matriculaEncontrada = true;
                    if(opcion.equals("alquilar")){
                        if(tiendas.get(numeroTienda).getVehiculos().get(i).isEstadoVehiculo() == true){
                            tiendas.get(numeroTienda).getVehiculos().get(i).alquilar();
                            System.out.println("SE HA ALQUILADO EL VEHICULO");
                        }else{
                            alquilado = true;
                        }
                    }else if(opcion.equals("devolver")){
                        if(tiendas.get(numeroTienda).getVehiculos().get(i).isEstadoVehiculo() == false){
                            tiendas.get(numeroTienda).getVehiculos().get(i).devolver();
                            System.out.println("SE HA DEVUELTO EL VEHICULO");
                        }else{
                            devuelto = true;
                        }
                    }
                }
            }
            if(!matriculaEncontrada){
                System.out.println("NO SE ENCONTRO LA MATRICULA");
            }
            if(alquilado){
                System.out.println("NO PUEDE ALQUILAR UN VEHICULO ALQUILADO");
            }
            if (devuelto) {
                System.out.println("NO PUEDE DEVOLVER UN VEHICULO QUE ESTA DISPONIBLE PARA ALQUILAR");
            }
        }   
    }


    //comprobar que el nombre sea unico para cada tienda.
    private static boolean comprobarNombre(String nombre){
        boolean comprobado = true;
        for(int i = 0; i < tiendas.size(); i++){
            if(tiendas.get(i).getNombre().equalsIgnoreCase(nombre)){
                comprobado = false;
                System.out.println("-----NOMBRE EXISTENTE-----");
                break;
            }else{
                comprobado = true;
            }
        }
        return comprobado;
    }

    //comprobar que la URL introducida por el usuario tenga el formato correcto
    private static boolean comprobarURL(String direccion){
        boolean comprobado = false;

        if(direccion.contains(".com")){
            comprobado = true;
        }else{
            System.out.println("-----LA URL NO TIENE EL FORMATO .COM-----");
            comprobado = false;
        }

        return comprobado;
    }

    //Comprobar que la matricula no existe en ninguna de las tiendas que hay.
    private static boolean comprobarMatricula(String matricula){
        boolean comprobado = true;
        String matriculaExistente = "";

        if(matricula.length() == 7){
            // COMPROBAR FORMATO CORRECTO
            if (Character.isDigit(matricula.charAt(0))&&Character.isDigit(matricula.charAt(1)) && Character.isDigit(matricula.charAt(2))
                && Character.isDigit(matricula.charAt(3)) && Character.isLetter(matricula.charAt(4)) && Character.isLetter(matricula.charAt(5)) 
                && Character.isLetter(matricula.charAt(6))
            ) {
                if (!tiendas.isEmpty()) {
                    for(int i = 0; i < tiendas.size(); i++){
                        if(!tiendas.get(i).getVehiculos().isEmpty()){                     
                            for(int j = 0 ; j < tiendas.get(i).getVehiculos().size(); j++){
                                if(tiendas.get(i).getVehiculos().get(j).getMatricula().equalsIgnoreCase(matricula)){
                                    comprobado = false;
                                    matriculaExistente = "existe";
                                    break;
                                }
                            } 
                        }else{
                            comprobado = true;
                        }
                        if(comprobado == false){
                            break;
                        }
                    }
                }
            }else{
                System.out.println("LA MATRICULA DEBE TIENE EL FORMATO 0000XXX");
                comprobado = false;
            }

            if(matriculaExistente.equalsIgnoreCase("existe")){
                System.out.println("----MATRICULA EXISTE----");
            }
            
        }else{
            System.out.println("LA MATRICULA DEBE TENER 7 CARACTERES");
            comprobado = false;
        }


        return comprobado;
    }

    //Metodo que sirve para devolver la posicion de la tienda eligida
    private static int elegirTienda(){
        int opcion = 0;
        int indice = 0;
        if(!tiendas.isEmpty()){
            do{
                indice = 0;
                for(int i = 0; i < tiendas.size(); i++){
                    System.out.println((i + 1) + " - " + tiendas.get(i).getNombre());
                    indice++;
                }
                System.out.print("OPCION:");
                opcion = Entrada.leerNumero();
                if(opcion <= 0 || opcion > indice){
                    System.out.println("-----ELIJA UNA OPCION CORRECTA-----");
                }
            }while(opcion <= 0 || opcion > indice);
        }else{
            System.out.println("-----NO HAY TIENDAS DISPONIBLES-----");
        }
        return opcion - 1;
    }

    public static int elegirTipoVehiculo(){
        int opcion = 0;

        if(!tiendas.isEmpty()){
            do{
                System.out.print("1-COCHE\n2-CAMION\n3-FURGONETA\n4-MOTO\nOPCION: ");
                opcion = Entrada.leerNumero();
            }while(opcion <= 0 || opcion > 4);
        }
        
        return opcion;
    }

}

