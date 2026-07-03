package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public abstract class Operacion implements Operable {
    // final porque las operaciones/comandos se van a ejecutar una sola vez.
    protected final BateriaAlmacenamiento bateria;
    protected final double energia;


    // Un Comando comienza "no ejecutado"
    protected Boolean ejecutado = Boolean.FALSE;

    public Operacion(BateriaAlmacenamiento bateria, double energia){
        this.bateria = bateria;
        this.energia = energia;
    }

}
