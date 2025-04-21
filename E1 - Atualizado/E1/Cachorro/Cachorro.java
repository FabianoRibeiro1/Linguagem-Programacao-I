package E1.Cachorro;

public class Cachorro {
    private String nome;
    private String raca;
    private int idade;

    public Cachorro(String nome, String raca, int idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    public String getDados() {
        return "Nome: " + nome + "\nRaça: " + raca + "\nIdade: " + idade + " anos";
    }
}

