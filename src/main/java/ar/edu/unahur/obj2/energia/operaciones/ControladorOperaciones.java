package ar.edu.unahur.obj2.energia.operaciones;

public class ControladorOperaciones {

    private Operable ultimoComando;
    
    public void ejecutar(Operable comando) throws ReservaExcedidaException{
        comando.ejecutar();
        ultimoComando = comando;
    }

    public void deshacer(){
        if (ultimoComando != null){
            ultimoComando.deshacer();
            ultimoComando = null;
        }
        
    }


}
