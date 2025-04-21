import javax.swing.*;
import java.awt.*;

public class CarroApp extends JFrame {

    // Atributos do carro
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    
    // Construtor da classe CarroApp
    public CarroApp(String marca, String modelo, int ano, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;

        setTitle("Figura de Carro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    // Método para desenhar a figura do carro
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Desenho do carro (simples)
        g.setColor(Color.decode(cor)); // Define a cor do carro
        g.fillRect(150, 200, 300, 50); // Corpo do carro
        g.setColor(Color.BLACK);
        g.fillOval(170, 230, 40, 40); // Roda esquerda
        g.fillOval(370, 230, 40, 40); // Roda direita

        // Janela do carro
        g.setColor(Color.WHITE);
        g.fillRect(220, 190, 160, 30); // Janela central

        // Cabeçalho do carro (teto)
        g.setColor(Color.decode(cor));
        g.fillRect(200, 170, 200, 30); // Teto

        // Desenho do parabrisa
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[]{240, 360, 320}, new int[]{170, 170, 140}, 3); // Parabrisa

        // Texto com informações do carro
        g.setColor(Color.BLACK);
        g.drawString("Marca: " + marca, 20, 30);
        g.drawString("Modelo: " + modelo, 20, 50);
        g.drawString("Ano: " + ano, 20, 70);
        g.drawString("Cor: " + cor, 20, 90);
    }

    // Método principal para executar o código
    public static void main(String[] args) {
        // Criando uma instância da classe CarroApp com dados do carro
        CarroApp app = new CarroApp("Toyota", "Corolla", 2020, "#FF6347"); // Exemplo de cor #FF6347 (Tomato)
        app.setVisible(true); // Torna a janela visível
    }
}
