package es.madrid.parla.tierno.modelo;

public class Coche extends Vehiculo{
    private int numeroPuertas;
    private String tipoCombustible;
    private boolean estadoMaletero;
    
    public Coche(String marca, String matricula, String modelo, int anio, int numeroPuertas, String tipoCombustible) {
        super(marca, matricula, modelo, anio);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
        this.estadoMaletero = false;
    }

    public void abrirMaletero(){
        if(isEstadoMaletero() == true){
            System.out.println("MALETERO ESTA ABIERTO, SOLO PUEDE CERRARLO");
        }else{
            setEstadoMaletero(true);
            System.out.println("MALETERO ABIERTO");
        }
        
    }

    public void cerrarMaletero(){
        if(isEstadoMaletero() == false){
            System.out.println("MALETERO ESTA CERRADO, SOLO PUEDE ABRIRLO");
        }else{
            setEstadoMaletero(false);
            System.out.println("MALETERO CERRADO");
        }

    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public boolean isEstadoMaletero() {
        return estadoMaletero;
    }

    public void setEstadoMaletero(boolean estadoMaletero) {
        this.estadoMaletero = estadoMaletero;
    }

    

    
}
