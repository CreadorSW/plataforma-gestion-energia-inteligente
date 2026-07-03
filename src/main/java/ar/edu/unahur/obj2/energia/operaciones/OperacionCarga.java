package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class OperacionCarga extends Operacion {
    public OperacionCarga(BateriaAlmacenamiento bateria, double energia) {
        super(bateria, energia);
        
    }

    @Override
    public void ejecutar() {
        if (!ejecutado){
            bateria.cargar(energia);
            ejecutado = Boolean.TRUE;
        }       
    }


    @Override
    public void deshacer() {
        if (ejecutado){
            bateria.consumir(energia);
            ejecutado = Boolean.FALSE;
        }
    }

}
