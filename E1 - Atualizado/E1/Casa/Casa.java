package E1.Casa;

public class Casa {
    private String endereco;
    private int quartos;
    private boolean possuiGaragem;

    public Casa(String endereco, int quartos, boolean possuiGaragem) {
        this.endereco = endereco;
        this.quartos = quartos;
        this.possuiGaragem = possuiGaragem;
    }

    public String getDados() {
        return "Endereço: " + endereco +
               "\nQuartos: " + quartos +
               "\nPossui garagem: " + (possuiGaragem ? "Sim" : "Não");
    }
}
