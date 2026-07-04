package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.operaciones.ControladorOperaciones;
import ar.edu.unahur.obj2.energia.operaciones.OperacionCarga;
import ar.edu.unahur.obj2.energia.operaciones.OperacionConsumo;
import ar.edu.unahur.obj2.energia.operaciones.OperacionInvalidaException;
import ar.edu.unahur.obj2.energia.operaciones.ReservaExcedidaException;
import ar.edu.unahur.obj2.energia.operaciones.Rutina;

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

     @Test
    void dadaUnaRutina_SeEjecutaLaRutinaYElNivelDeEnergiaQuedaRegistrado() throws ReservaExcedidaException {
        Rutina rutina1 = new Rutina();
        rutina1.agregarOperacionALote(carga7000);
        rutina1.agregarOperacionALote(consumo5000);
        rutina1.agregarOperacionALote(consumo16000);
        rutina1.agregarOperacionALote(carga9000);

        controlador.ejecutar(rutina1);

        assertEquals(5000, bateria1.getNivelDeEnergia(), 0.001);
    }

    @Test
    void dadaUnaRutina_SeEjecutaYSePuedeDeshacer() throws ReservaExcedidaException {
        Rutina rutina1 = new Rutina();
        rutina1.agregarOperacionALote(carga7000);
        rutina1.agregarOperacionALote(consumo5000);
        rutina1.agregarOperacionALote(consumo16000);
        rutina1.agregarOperacionALote(carga9000);

        controlador.ejecutar(rutina1);
        controlador.deshacer();

        assertEquals(10000, bateria1.getNivelDeEnergia());
    }

    @Test
    void dadaUnaCarga_SeLograRevertirConExito() throws ReservaExcedidaException {
        controlador.ejecutar(carga7000);
        controlador.deshacer();

        assertEquals(10000, bateria1.getNivelDeEnergia());
    }


    @Test
    void dadaUnaCargaConEnergiaNegativa_SeLanzaOperacionInvalidaException() {
        assertThrows(OperacionInvalidaException.class, () -> new OperacionCarga(bateria1, -1000));
    }

    @Test
    void dadoUnConsumoQueSuperaLaReserva_SeLanzaReservaExcedidaException() {
        OperacionConsumo consumoExcesivo = new OperacionConsumo(bateria1, 70000);

        assertThrows(ReservaExcedidaException.class, () -> controlador.ejecutar(consumoExcesivo));
    }
}


