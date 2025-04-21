package E1.Carro;

public class Carro {
    private String modelo;
    private int ano;
    private String cor;

    public Carro(String modelo, int ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getDados() {
        return "Modelo: " + modelo + "\nAno: " + ano + "\nCor: " + cor;
    }
}
