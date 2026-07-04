package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class NotificacionAdministrador implements Observador {    

    @Override
    public void reaccionar(BateriaAlmacenamiento bateria, String tipoOperacion, double energia) {
        System.out.println("Se ha realizado una  " +tipoOperacion + " de " + energia + " kWh en su bateria"+ bateria.getIdentificador());
    }
    
}
