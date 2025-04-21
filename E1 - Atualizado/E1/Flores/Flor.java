package E1.Flores;

public class Flor {
    private String nome;
    private String cor;
    private boolean perfumada;

    public Flor(String nome, String cor, boolean perfumada) {
        this.nome = nome;
        this.cor = cor;
        this.perfumada = perfumada;
    }

    public String getDados() {
        return "Nome: " + nome +
               "\nCor: " + cor +
               "\nÉ perfumada: " + (perfumada ? "Sim" : "Não");
    }
}

