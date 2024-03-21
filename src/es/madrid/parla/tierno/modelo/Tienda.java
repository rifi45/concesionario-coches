package es.madrid.parla.tierno.modelo;

import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private String direccion;
    private ArrayList<Vehiculo> vehiculos;

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.vehiculos = new ArrayList<>();
    }
    public void crearVehiculos (Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
   

    
}
