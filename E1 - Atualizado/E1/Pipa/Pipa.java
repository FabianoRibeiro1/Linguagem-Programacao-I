package E1.Pipa;

public class Pipa {
    private String cor;
    private String tamanho;
    private String tipoLinha;

    public Pipa(String cor, String tamanho, String tipoLinha) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.tipoLinha = tipoLinha;
    }

    public String getDados() {
        return "Cor: " + cor + "\nTamanho: " + tamanho + "\nTipo de Linha: " + tipoLinha;
    }
}
