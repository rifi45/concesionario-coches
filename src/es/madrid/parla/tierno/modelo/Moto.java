package es.madrid.parla.tierno.modelo;

public class Moto extends Vehiculo{
    private int cilindrada;
    private String tipoTransmision;
    private int velocidad;

    public Moto(String marca, String matricula, String modelo, int anio, int cilindrada, String tipoTransmision) {
        super(marca, matricula, modelo, anio);
        this.cilindrada = cilindrada;
        this.tipoTransmision = tipoTransmision;
        this.velocidad = 0;
    }

    public void acelerar(int rapidez){
        this.velocidad = rapidez;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public String getTipoTransmision() {
        return tipoTransmision;
    }
    public void setTipoTransmision(String tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    

    

}
