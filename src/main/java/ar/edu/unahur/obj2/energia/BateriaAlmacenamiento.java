package ar.edu.unahur.obj2.energia;

import java.util.List;

import ar.edu.unahur.obj2.energia.notificaciones.Observador;
import ar.edu.unahur.obj2.energia.operaciones.ReservaExcedidaException;

public class BateriaAlmacenamiento {
    private final String identificador;
    private double nivelDeEnergia;
    private List<Observador> sistemasPerifericos;

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

    public void notificarObservadores(String tipoOperacion, double energia){
        sistemasPerifericos.forEach(o -> o.reaccionar(this, tipoOperacion, energia));
    }

    public void agregarObservador(Observador observador){
        this.sistemasPerifericos.add(observador);
    }

    public void removerObservador(Observador observador){
        this.sistemasPerifericos.remove(observador);
    }

    public List<Observador> getObservadores(){
        return sistemasPerifericos;
    }
    
}
