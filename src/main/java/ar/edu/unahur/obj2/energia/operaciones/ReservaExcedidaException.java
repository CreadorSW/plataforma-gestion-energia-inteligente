package ar.edu.unahur.obj2.energia.operaciones;

/**
 * ReservaExcedidaException
 */
public class ReservaExcedidaException extends Exception {
    public ReservaExcedidaException(String mensaje) {
        super(mensaje);
    }

    // Esto lo vimos en clase
    public ReservaExcedidaException(String mensaje, Throwable causa) {
            super(mensaje, causa);
    }
}
