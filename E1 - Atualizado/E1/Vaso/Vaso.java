package E1.Vaso;

public class Vaso {
    private String material;
    private String cor;
    private boolean possuiPlantas;

    public Vaso(String material, String cor, boolean possuiPlantas) {
        this.material = material;
        this.cor = cor;
        this.possuiPlantas = possuiPlantas;
    }

    public String getDados() {
        return "Material: " + material +
               "\nCor: " + cor +
               "\nPossui plantas: " + (possuiPlantas ? "Sim" : "Não");
    }
}

