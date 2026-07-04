package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class AlarmaReservaCritica implements Observador {

    @Override
    public void reaccionar(BateriaAlmacenamiento bateria, String tipoOperacion, double energia) {
        if (bateria.getNivelDeEnergia() < 0) {
            System.out.println("Batería " + bateria.getIdentificador()
                + " en reserva crítica: " + bateria.getNivelDeEnergia() + " kWh");
        }
    }
}
