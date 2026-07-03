package ar.edu.unahur.obj2.energia.operaciones;

import java.util.ArrayList;
import java.util.List;

public class Rutina implements Operable {

    private List<Operable> loteDeOperaciones = new ArrayList<>();
    private Boolean ejecutado = Boolean.FALSE;

    @Override
    public void ejecutar() {
        if (!ejecutado){
            loteDeOperaciones.forEach(Operable::ejecutar);
            ejecutado = Boolean.TRUE;
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

}
