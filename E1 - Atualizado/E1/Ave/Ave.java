package E1.Ave;

public class Ave {
    private String especie;
    private String cor;
    private double envergadura;

    public Ave(String especie, String cor, double envergadura) {
        this.especie = especie;
        this.cor = cor;
        this.envergadura = envergadura;
    }

    public String getDados() {
        return "Espécie: " + especie + "\nCor: " + cor + "\nEnvergadura: " + envergadura + " cm";
    }
}
