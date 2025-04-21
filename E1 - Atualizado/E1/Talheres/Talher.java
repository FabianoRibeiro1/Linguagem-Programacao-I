package E1.Talheres;

public class Talher {
    private String tipo;
    private String material;
    private boolean reutilizavel;

    public Talher(String tipo, String material, boolean reutilizavel) {
        this.tipo = tipo;
        this.material = material;
        this.reutilizavel = reutilizavel;
    }

    public String getDados() {
        return "Tipo: " + tipo +
               "\nMaterial: " + material +
               "\nÉ reutilizável: " + (reutilizavel ? "Sim" : "Não");
    }
}

