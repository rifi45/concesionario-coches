package es.madrid.parla.tierno.modelo;

public class Furgoneta extends Vehiculo{
    private Double capacidadCarga;
    private Double cargaEncima;

    public Furgoneta(String marca, String matricula, String modelo, int anio, Double capacidadCarga) {
        super(marca,matricula, modelo, anio);
        this.capacidadCarga = capacidadCarga;
        this.cargaEncima = 0.0;
    }

    public void cargarMercancia(Double peso){
        if(this.cargaEncima > 0){
            System.out.println("EL FURGON ESTA CARGADO DESCARGUELO");
        }else{
            if(peso > this.capacidadCarga){
                System.out.print("EL FURGON NO SOPORTA LA CARGA METIDA");
            }else{
                this.cargaEncima = peso;
                System.out.println("FURGON CARGADO");
            }
        }
    }
    public void descargarMercancia(){

    }

    public Double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(Double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public Double getCargaEncima() {
        return cargaEncima;
    }

    public void setCargaEncima(Double cargaEncima) {
        this.cargaEncima = cargaEncima;
    }
    
}
