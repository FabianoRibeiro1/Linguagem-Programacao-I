package E1.Maça;

public class Maca {
    private String tipo;
    private String cor;
    private boolean madura;

    public Maca(String tipo, String cor, boolean madura) {
        this.tipo = tipo;
        this.cor = cor;
        this.madura = madura;
    }

    public String getDados() {
        return "Tipo: " + tipo +
               "\nCor: " + cor +
               "\nEstá madura: " + (madura ? "Sim" : "Não");
    }
}
