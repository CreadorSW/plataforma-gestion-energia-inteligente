package ar.edu.unahur.obj2.energia.operaciones;

public class ControladorOperaciones {

    private Operable ultimoComando;
    
    public void ejecutar(Operable comando){
        comando.ejecutar();
        ultimoComando = comando;
    }


}
