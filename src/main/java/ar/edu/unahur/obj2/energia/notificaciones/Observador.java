package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public interface Observador {

    public void reaccionar(BateriaAlmacenamiento cuenta, String tipoTransferencia, double energia);
}
