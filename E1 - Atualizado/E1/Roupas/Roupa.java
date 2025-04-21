package E1.Roupas;

public class Roupa {
    private String tipo;
    private String tamanho;
    private String cor;

    public Roupa(String tipo, String tamanho, String cor) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public String getDados() {
        return "Tipo: " + tipo + "\nTamanho: " + tamanho + "\nCor: " + cor;
    }
}

