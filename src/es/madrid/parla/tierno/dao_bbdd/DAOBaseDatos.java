package es.madrid.parla.tierno.dao_bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.madrid.parla.tierno.modelo.*;

public class DAOBaseDatos {
    
    public static Connection conectarBD() throws ClassNotFoundException, SQLException{
        return ConexionDB.connect();
    }

    public static void insertarTiendas(Tienda tienda) throws ClassNotFoundException, SQLException{
        String nombre = tienda.getNombre();
        String direccion = tienda.getDireccion();

        Connection cnx = conectarBD();
        String sql = "INSERT INTO TIENDA VALUES(ID_TIENDA_SECUENCIA.NEXTVAL, ?, ?)";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.executeUpdate();
            System.out.println("Se insertó el registro en la tabla TIENDA.");
        }
    }

    public static ArrayList<Tienda> visualizarTiendas() throws ClassNotFoundException, SQLException{
        ArrayList<Tienda> tiendas = new ArrayList<>();
        String nombre = "";
        String direccion = "";

        Connection cnx = conectarBD();
        String sql = "SELECT * FROM TIENDA";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                nombre = resultSet.getString("NOMBRE");
                direccion = resultSet.getString("DIRECCION");
                Tienda tienda = new Tienda(nombre, direccion);
                tiendas.add(tienda);
            }
        }

        return tiendas;
    }

    public static void insertarVehiculo(String nombreTienda, Vehiculo vehiculo) throws ClassNotFoundException, SQLException{
        Connection cnx = ConexionDB.connect();
        int idTienda = obtenerTienda(nombreTienda, cnx);
        if(vehiculo instanceof Coche){
            insertarCoche(cnx, vehiculo, idTienda);
        }else if(vehiculo instanceof Camion){
            insertarCamion(cnx, vehiculo, idTienda);
        }else if(vehiculo instanceof Furgoneta){
            insertarFurgoneta(cnx, vehiculo, idTienda);
        }else if(vehiculo instanceof Moto){
            insertarMoto(cnx, vehiculo, idTienda);
        }
    }

    private static void insertarCoche(Connection cnx, Vehiculo vehiculo, int idTienda) throws SQLException{
        String sqlCoche = "INSERT INTO VEHICULO (ID_VEHICULO, MATRICULA, MARCA, MODELO, NUMERO_PUERTAS, TIPO_COMBUSTIBLE, ID_TIENDA, ID_TIPO_VEHICULO) VALUES (ID_VEHICULO_SECUENCIA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int numeroPuertas = ((Coche) vehiculo).getNumeroPuertas();
        String tipoCombustible = ((Coche) vehiculo).getTipoCombustible();
        int id_tipo_vehiculo = 1;


        try (PreparedStatement preparedStatement = cnx.prepareStatement(sqlCoche)) {
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setInt(4, numeroPuertas);
            preparedStatement.setString(5, tipoCombustible);
            preparedStatement.setInt(6, idTienda);
            preparedStatement.setInt(7, id_tipo_vehiculo);

            preparedStatement.executeUpdate();
            System.out.println("Se insertó el registro en la tabla Vehiculo.");
        }

    }

    private static void insertarCamion(Connection cnx, Vehiculo vehiculo, int idTienda) throws SQLException{
        String sqlCamion = "INSERT INTO VEHICULO (ID_VEHICULO, MATRICULA, MARCA, MODELO, CAPACIDAD_CARGA, TIPO_REMOLOQUE, ID_TIENDA, ID_TIPO_VEHICULO) VALUES (ID_VEHICULO_SECUENCIA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        Double capacidadCarga = ((Camion) vehiculo).getCapacidadCarga();
        String tipoRemolque = ((Camion) vehiculo).getTipoRemolque();
        int id_tipo_vehiculo = 3;


        try (PreparedStatement preparedStatement = cnx.prepareStatement(sqlCamion)) {
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setDouble(4, capacidadCarga);
            preparedStatement.setString(5, tipoRemolque);
            preparedStatement.setInt(6, idTienda);
            preparedStatement.setInt(7, id_tipo_vehiculo);

            preparedStatement.executeUpdate();
            System.out.println("Se insertó el registro en la tabla Vehiculo.");
        }

    }

    private static void insertarFurgoneta(Connection cnx, Vehiculo vehiculo, int idTienda) throws SQLException{
        String sqlFurgoneta = "INSERT INTO VEHICULO (ID_VEHICULO, MATRICULA, MARCA, MODELO, CAPACIDAD_CARGA, ID_TIENDA, ID_TIPO_VEHICULO) VALUES (ID_VEHICULO_SECUENCIA.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        Double capacidadCarga = ((Furgoneta) vehiculo).getCapacidadCarga();
        int id_tipo_vehiculo = 2;


        try (PreparedStatement preparedStatement = cnx.prepareStatement(sqlFurgoneta)) {
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setDouble(4, capacidadCarga);
            preparedStatement.setInt(5, idTienda);
            preparedStatement.setInt(6, id_tipo_vehiculo);

            preparedStatement.executeUpdate();
            System.out.println("Se insertó el registro en la tabla Vehiculo.");
        }

    }

    private static void insertarMoto(Connection cnx, Vehiculo vehiculo, int idTienda) throws SQLException{
        String sqlMoto = "INSERT INTO VEHICULO (ID_VEHICULO, MATRICULA, MARCA, MODELO, CILINDRADA, TIPO_COMBUSTIBLE, ID_TIENDA, ID_TIPO_VEHICULO) VALUES (ID_VEHICULO_SECUENCIA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        String matricula = vehiculo.getMatricula();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        int cilindrada = ((Moto) vehiculo).getCilindrada();
        String tipoCombustible = ((Moto) vehiculo).getTipoTransmision();
        int id_tipo_vehiculo = 4;


        try (PreparedStatement preparedStatement = cnx.prepareStatement(sqlMoto)) {
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, marca);
            preparedStatement.setString(3, modelo);
            preparedStatement.setInt(4, cilindrada);
            preparedStatement.setString(5, tipoCombustible);
            preparedStatement.setInt(6, idTienda);
            preparedStatement.setInt(7, id_tipo_vehiculo);

            preparedStatement.executeUpdate();
            System.out.println("Se insertó el registro en la tabla Vehiculo.");
        }

    }

    


    private static int obtenerTienda(String nombreTienda, Connection cnx) throws ClassNotFoundException, SQLException{
        int idTienda = 0;

        String sql = "SELECT ID_TIENDA FROM TIENDA WHERE NOMBRE = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
            preparedStatement.setString(1, nombreTienda);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idTienda = resultSet.getInt("ID_TIENDA");
                }
            }
        }

        return idTienda;
    }

    public static void visualizarVehiculo(ArrayList<Tienda> tiendas) throws ClassNotFoundException, SQLException{
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Camion camion = null;
        Coche coche = null;
        Furgoneta furgon = null;
        Moto moto = null;
        Connection cnx = conectarBD();
        String sql = "SELECT * FROM VEHICULO";
        String matricula = "";
        String marca = "";
        String modelo = "";
        Double capacidadCarga = 0.0;
        String tipoRemolque = "";
        int numeroPuertas = 0;
        String tipoCombustible = "";
        int cilindrada = 0;
        int id_tipo_vehiculo = 0;
        int id_tienda = 0;




        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                matricula = resultSet.getString("MATRICULA");
                marca = resultSet.getString("MARCA");
                modelo = resultSet.getString("MODELO");
                capacidadCarga = resultSet.getDouble("CAPACIDAD_CARGA");
                tipoRemolque = resultSet.getString("TIPO_REMOLQUE");
                numeroPuertas = resultSet.getInt("NUMERO_PUERTAS");
                tipoCombustible = resultSet.getString("TIPO_COMBUSTIBLE");
                cilindrada = resultSet.getInt("CILINDRADA");
                id_tipo_vehiculo = resultSet.getInt("ID_TIPO_VEHICULO");
                id_tienda = resultSet.getInt("ID_TIENDA");

                String nombreTienda = obetenerNombreTienda(id_tienda, cnx);
                int posicionTienda = devolverPosicionTienda(tiendas, nombreTienda);
                if(id_tipo_vehiculo == 1){
                    coche = new Coche(marca, matricula, modelo, id_tienda, numeroPuertas, tipoCombustible);
                    tiendas.get(posicionTienda).crearVehiculos(coche);
                }else if(id_tipo_vehiculo == 2){
                    furgon = new Furgoneta(marca, matricula, modelo, id_tienda, capacidadCarga);
                    tiendas.get(posicionTienda).crearVehiculos(furgon);
                }else if(id_tipo_vehiculo == 3){
                    camion = new Camion(marca, matricula, modelo, id_tienda, capacidadCarga, tipoRemolque);
                    tiendas.get(posicionTienda).crearVehiculos(camion);
                }else if(id_tipo_vehiculo == 4){
                    moto = new Moto(marca, matricula, modelo, id_tienda, cilindrada, tipoCombustible);
                    tiendas.get(posicionTienda).crearVehiculos(moto);
                }

                


            }
        }

    }

    private static String obetenerNombreTienda(int id, Connection cnx) throws SQLException{
        String nomnbreTienda = "";

        String sql = "SELECT NOMBRE FROM TIENDA WHERE ID_TIENDA = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    nomnbreTienda = resultSet.getString("NOMBRE");
                }
            }
        }

        return nomnbreTienda;
    }

    private static int devolverPosicionTienda(ArrayList<Tienda> tiendas, String nombre){
        int posicion = 0;
        for(int i = 0; i < tiendas.size(); i++){
            if(tiendas.get(i).getNombre().equalsIgnoreCase(nombre)){
                posicion = i;
            }
        }
        return posicion;
    }

}
