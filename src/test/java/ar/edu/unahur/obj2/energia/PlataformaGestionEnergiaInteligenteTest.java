package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.operaciones.ControladorOperaciones;
import ar.edu.unahur.obj2.energia.operaciones.OperacionCarga;
import ar.edu.unahur.obj2.energia.operaciones.OperacionConsumo;
import ar.edu.unahur.obj2.energia.operaciones.ReservaExcedidaException;

public class PlataformaGestionEnergiaInteligenteTest {
    private ControladorOperaciones controlador;
    private BateriaAlmacenamiento bateria1;
    private OperacionCarga carga7000;
    private OperacionConsumo consumo5000;
    private OperacionConsumo consumo16000;
    private OperacionCarga carga9000;

    @BeforeEach
    void objetosParaTest() {
        controlador = new ControladorOperaciones();
        bateria1 = new BateriaAlmacenamiento("BAT-1234", 10000);
        carga7000 = new OperacionCarga(bateria1, 7000);
        consumo5000 = new OperacionConsumo(bateria1, 5000);
        consumo16000 = new OperacionConsumo(bateria1, 16000);
        carga9000 = new OperacionCarga(bateria1, 9000);
    }

    @Test
    void dadaUnaBateria_SeHacenTransferenciasYNivelDeEnergiaQuedaRegistrado() throws ReservaExcedidaException{
        controlador.ejecutar(carga7000);
        controlador.ejecutar(consumo5000);
        controlador.ejecutar(consumo16000);
        controlador.ejecutar(carga9000);
        assertEquals(5000, bateria1.getNivelDeEnergia());
    }

}


