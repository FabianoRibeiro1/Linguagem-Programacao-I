import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlorApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField corField, tipoField, tamanhoField;
    private JLabel resultadoLabel;

    public FlorApp() {
        // Configuração da janela
        setTitle("Cadastro de Flor");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Componentes de entrada de dados
        JLabel corLabel = new JLabel("Cor (Hexadecimal):");
        corField = new JTextField(10);
        
        JLabel tipoLabel = new JLabel("Tipo de Flor (Ex: Rosa, Margarida):");
        tipoField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Flor");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarFlor();
            }
        });

        // Adicionando os componentes ao painel
        inputPanel.add(corLabel);
        inputPanel.add(corField);
        inputPanel.add(tipoLabel);
        inputPanel.add(tipoField);
        inputPanel.add(tamanhoLabel);
        inputPanel.add(tamanhoField);
        inputPanel.add(submitButton);

        // Painel para exibir o resultado
        JPanel resultPanel = new JPanel();
        resultadoLabel = new JLabel("Informações da Flor aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarFlor() {
        // Coleta os dados dos campos de texto
        String cor = corField.getText();
        String tipo = tipoField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (cor.isEmpty() || tipo.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Flor com os dados
            Flor flor = new Flor(cor, tipo, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tipo:</b> " + flor.getTipo() +
                                   "<br><b>Cor:</b> " + flor.getCor() +
                                   "<br><b>Tamanho:</b> " + flor.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura da flor
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura da flor após os dados serem preenchidos
        if (!corField.getText().isEmpty() && !tipoField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String corFlor = corField.getText(); // Cor da flor
            g.setColor(Color.decode(corFlor)); // Define a cor da flor

            // Desenhando a flor
            int x = 200, y = 200;
            int petalSize = 40;

            // Desenhando pétalas
            g.fillOval(x, y - petalSize, petalSize, petalSize); // Cima
            g.fillOval(x + petalSize, y, petalSize, petalSize); // Direita
            g.fillOval(x, y + petalSize, petalSize, petalSize); // Baixo
            g.fillOval(x - petalSize, y, petalSize, petalSize); // Esquerda

            // Desenhando o centro da flor
            g.setColor(Color.YELLOW); // Cor do centro
            g.fillOval(x - 20, y - 20, 40, 40); // Centro

            // Tamanho da flor: altera a escala das pétalas
            if ("Grande".equalsIgnoreCase(tamanhoField.getText())) {
                petalSize = 70; // Aumenta o tamanho das pétalas
            } else if ("Pequeno".equalsIgnoreCase(tamanhoField.getText())) {
                petalSize = 30; // Diminui o tamanho das pétalas
            }
        }
    }

    public static void main(String[] args) {
        new FlorApp(); // Inicia a aplicação
    }
}

class Flor {
    private String cor;
    private String tipo;
    private String tamanho;

    public Flor(String cor, String tipo, String tamanho) {
        this.cor = cor;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanho() {
        return tamanho;
    }
}
