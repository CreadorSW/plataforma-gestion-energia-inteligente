package ar.edu.unahur.obj2.energia;

import ar.edu.unahur.obj2.energia.operaciones.ReservaExcedidaException;

public class BateriaAlmacenamiento {
    private final String identificador;
    private double nivelDeEnergia;

    public BateriaAlmacenamiento(String identificador, double nivelDeEnergia){
        this.identificador = identificador;
        this.nivelDeEnergia = nivelDeEnergia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getNivelDeEnergia() {
        return nivelDeEnergia;
    }

    public void cargar(double energia){
        this.nivelDeEnergia += energia;
    }

    public void consumir(double energia) throws ReservaExcedidaException {
        if (this.nivelDeEnergia - energia < -5000) {
            throw new ReservaExcedidaException("El overdraft permitido es de -5000 kWh");
        }
        this.nivelDeEnergia -=energia;
    }

    // Lo creé para el método deshacer de Operación Carga. 
    public void deshacerCarga(double energia){
        this.nivelDeEnergia -=energia;
    }
    
}
