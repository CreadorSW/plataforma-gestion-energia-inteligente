package ar.edu.unahur.obj2.energia.notificaciones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.BateriaAlmacenamiento;

public class RegistroCentralDeAuditoria implements Observador{

    private List<String> operaciones = new ArrayList<>();

        @Override
        public void reaccionar(BateriaAlmacenamiento bateria, String tipoOperacion, double energia) {
            String registro = "Batería " + bateria.getIdentificador()
                + " " + tipoOperacion + " de " + energia + " kWh";
            System.out.println(registro);
            operaciones.add(registro);
        }

        public List<String> getOperaciones() {
            return operaciones;
        }
}
