package ar.edu.unahur.obj2.energia;

public class BateriaAlmacenamiento {
    private final String identificador;
    private double nivelDeEnergia;

    public BateriaAlmacenamiento(String identificador, double nivelDeEnergia){
        this.identificador = identificador;
        this.nivelDeEnergia = nivelDeEnergia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getNivelDeEnergia() {
        return nivelDeEnergia;
    }

    public void cargar(double energia){
        this.nivelDeEnergia += energia;
    }

    public void consumir(double energia){
        this.nivelDeEnergia -=energia;
    }
    
}
