package ar.edu.unahur.obj2.energia.operaciones;

import java.util.ArrayList;
import java.util.List;

public class Rutina implements Operable {

    private List<Operable> loteDeOperaciones = new ArrayList<>();
    private Boolean ejecutado = Boolean.FALSE;

    @Override
    public void ejecutar() throws ReservaExcedidaException {
        List<Operable> operacionesEjecutadas = new ArrayList<>();
        try {
            for (Operable operacion : loteDeOperaciones) {
                operacion.ejecutar();
                operacionesEjecutadas.add(operacion);
            }
            ejecutado = Boolean.TRUE;
        } catch (ReservaExcedidaException e) {
            for (int i = operacionesEjecutadas.size() - 1; i >= 0; i--) {
                operacionesEjecutadas.get(i).deshacer();
            }
            throw new ReservaExcedidaException("La rutina falló y se revirtieron las operaciones: " + e.getMessage(), e);
        }
       
    }

    // El lote se comporta igual que un comando concreto: ejecutable una vez, deshacible una vez, reversible.

    @Override
    public void deshacer() {
        if (ejecutado){
            for (int i = loteDeOperaciones.size() - 1; i >= 0; i--) {
                loteDeOperaciones.get(i).deshacer();
            }
            ejecutado = Boolean.FALSE;
        }
    }

    // Si el lote ya fue ejecutado, agregarle más operaciones rompe la semántica de "comando ejecutable una sola vez".
    public void agregarOperacionALote(Operable operacion){
        if (ejecutado) {
            throw new OperacionInvalidaException("No se pueden agregar operaciones a un lote ya ejecutado");
        }
        loteDeOperaciones.add(operacion);
    }

    public void removerOperacionDeLote(Operable operacion) {
        if (ejecutado) {
            throw new OperacionInvalidaException("No se pueden remover operaciones de un lote ya ejecutado");
        }
        loteDeOperaciones.remove(operacion);
    }

}
