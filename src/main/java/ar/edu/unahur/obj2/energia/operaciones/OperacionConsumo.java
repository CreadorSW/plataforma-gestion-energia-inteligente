package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class OperacionConsumo extends Operacion {

    public OperacionConsumo(BateriaAlmacenamiento bateria, double energia) {
        super(bateria, energia);
        
    }

    @Override
    public void ejecutar() throws ReservaExcedidaException {
        if (!ejecutado){
            bateria.consumir(energia);
            ejecutado = Boolean.TRUE;
        }       
    }


    @Override
    public void deshacer() {
        if (ejecutado){
            bateria.cargar(energia);
            ejecutado = Boolean.FALSE;
        }
    }

}
