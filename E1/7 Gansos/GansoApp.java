import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GansoApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField corField, especieField, tamanhoField;
    private JLabel resultadoLabel;

    public GansoApp() {
        // Configuração da janela
        setTitle("Cadastro de Ganso");
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
        
        JLabel especieLabel = new JLabel("Espécie (Ex: Ganso Branco, Ganso Selvagem):");
        especieField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Ganso");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarGanso();
            }
        });

        // Adicionando os componentes ao painel
        inputPanel.add(corLabel);
        inputPanel.add(corField);
        inputPanel.add(especieLabel);
        inputPanel.add(especieField);
        inputPanel.add(tamanhoLabel);
        inputPanel.add(tamanhoField);
        inputPanel.add(submitButton);

        // Painel para exibir o resultado
        JPanel resultPanel = new JPanel();
        resultadoLabel = new JLabel("Informações do Ganso aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarGanso() {
        // Coleta os dados dos campos de texto
        String cor = corField.getText();
        String especie = especieField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (cor.isEmpty() || especie.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Ganso com os dados
            Ganso ganso = new Ganso(cor, especie, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Espécie:</b> " + ganso.getEspecie() +
                                   "<br><b>Cor:</b> " + ganso.getCor() +
                                   "<br><b>Tamanho:</b> " + ganso.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura do ganso
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura do ganso após os dados serem preenchidos
        if (!corField.getText().isEmpty() && !especieField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String corGanso = corField.getText(); // Cor do ganso
            g.setColor(Color.decode(corGanso)); // Define a cor do ganso

            // Desenhando a figura do ganso
            // Cabeça do ganso
            g.fillOval(200, 100, 50, 50); // Cabeça

            // Corpo do ganso
            g.fillOval(180, 150, 90, 120); // Corpo

            // Pescoço do ganso
            g.setColor(Color.decode(corGanso)); // Cor do pescoço
            g.fillRoundRect(240, 130, 20, 70, 10, 10); // Pescoço

            // Bico do ganso
            g.setColor(Color.ORANGE);
            g.fillPolygon(new int[]{240, 250, 240}, new int[]{150, 160, 170}, 3); // Bico

            // Desenha as asas do ganso (representadas como semi-ovais)
            g.setColor(Color.decode(corGanso)); // Cor das asas
            g.fillArc(150, 160, 120, 80, 180, 180); // Asa esquerda
            g.fillArc(180, 160, 120, 80, 0, 180); // Asa direita

            // Desenha a cauda do ganso (como um triângulo)
            g.setColor(Color.decode(corGanso)); // Cor da cauda
            g.fillPolygon(new int[]{200, 220, 240}, new int[]{230, 250, 230}, 3); // Cauda
        }
    }

    public static void main(String[] args) {
        new GansoApp(); // Inicia a aplicação
    }
}

class Ganso {
    private String cor;
    private String especie;
    private String tamanho;

    public Ganso(String cor, String especie, String tamanho) {
        this.cor = cor;
        this.especie = especie;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getEspecie() {
        return especie;
    }

    public String getTamanho() {
        return tamanho;
    }
}

