package es.madrid.parla.tierno.modelo;


public class Camion extends Vehiculo{
    private Double capacidadCarga;
    private String tipoRemolque;
    private Double cargaEncima;

    public Camion(String marca, String matricula, String modelo, int anio, Double capacidadCarga, String tipoRemolque) {
        super(marca, matricula, modelo, anio);
        this.capacidadCarga = capacidadCarga;
        this.tipoRemolque = tipoRemolque;
        this.cargaEncima = 0.0;
    }

    public void cargarMercancia(Double peso){
        if(this.cargaEncima > 0){
            System.out.println("EL CAMION ESTA CARGADO DESCARGUELO");
        }else{
            if(peso > this.capacidadCarga){
                System.out.print("EL CAMION NO SOPORTA LA CARGA METIDA");
            }else{
                this.cargaEncima = peso;
                System.out.println("CAMION CARGADO");
            }
        }
    }

    public void descargarMercancia(){
        
        if(this.cargaEncima == 0.0){
            System.out.println("CAMION ESTA DESCARGADO");
        }else{
            this.cargaEncima = 0.0;
            System.out.println("SE HA DESCARGADO EL CAMION");
        }
    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getTipoRemolque() {
        return tipoRemolque;
    }

    public void setTipoRemolque(String tipoRemolque) {
        this.tipoRemolque = tipoRemolque;
    }

    public Double getCargaEncima() {
        return cargaEncima;
    }

    public void setCargaEncima(Double cargaEncima) {
        this.cargaEncima = cargaEncima;
    }

    

    
    
}
