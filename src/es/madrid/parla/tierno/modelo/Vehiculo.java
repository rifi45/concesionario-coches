package es.madrid.parla.tierno.modelo;

public class Vehiculo {
    protected String marca;
    protected String matricula;
    protected String modelo;
    protected int anio;
    protected boolean estadoVehiculo;

    public Vehiculo(String marca, String matricula, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.matricula = matricula;
        this.estadoVehiculo = true;
    }

    public void alquilar() {
        setEstadoVehiculo(false);
    } 
    public void devolver(){
        setEstadoVehiculo(true);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(boolean estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

    
}
