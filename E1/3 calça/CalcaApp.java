import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcaApp extends JFrame {

    // Atributos da calça
    private JTextField tamanhoField, corField, modeloField;
    private JLabel resultadoLabel;

    public CalcaApp() {
        // Configuração da janela
        setTitle("Cadastro de Calça");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Componentes de entrada de dados
        JLabel tamanhoLabel = new JLabel("Tamanho:");
        tamanhoField = new JTextField(10);
        
        JLabel corLabel = new JLabel("Cor (Hexadecimal):");
        corField = new JTextField(10);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloField = new JTextField(10);

        JButton submitButton = new JButton("Criar Calça");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarCalca();
            }
        });

        // Adicionando os componentes ao painel
        inputPanel.add(tamanhoLabel);
        inputPanel.add(tamanhoField);
        inputPanel.add(corLabel);
        inputPanel.add(corField);
        inputPanel.add(modeloLabel);
        inputPanel.add(modeloField);
        inputPanel.add(submitButton);

        // Painel para exibir o resultado
        JPanel resultPanel = new JPanel();
        resultadoLabel = new JLabel("Informações da Calça aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarCalca() {
        // Coleta os dados dos campos de texto
        String tamanho = tamanhoField.getText();
        String cor = corField.getText();
        String modelo = modeloField.getText();

        // Valida se todos os campos foram preenchidos
        if (tamanho.isEmpty() || cor.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Calca com os dados
            Calca calca = new Calca(tamanho, cor, modelo);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tamanho:</b> " + calca.getTamanho() +
                                   "<br><b>Cor:</b> " + calca.getCor() +
                                   "<br><b>Modelo:</b> " + calca.getModelo() + "</html>");

            // Redesenha a tela para exibir a figura da calça
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura da calça apenas após o formulário ser preenchido
        if (!tamanhoField.getText().isEmpty() && !corField.getText().isEmpty() && !modeloField.getText().isEmpty()) {
            String corCalca = corField.getText(); // Cor da calça
            g.setColor(Color.decode(corCalca)); // Define a cor da calça
            g.fillRect(150, 200, 100, 200); // Corpo da calça
            g.fillRect(150, 250, 40, 100); // Perna esquerda
            g.fillRect(210, 250, 40, 100); // Perna direita
            g.setColor(Color.BLACK);
            g.fillRect(150, 150, 100, 20); // Cós
            g.setColor(Color.GRAY);
            g.fillOval(195, 165, 10, 10); // Botão
        }
    }

    public static void main(String[] args) {
        new CalcaApp(); // Inicia a aplicação
    }
}

class Calca {
    private String tamanho;
    private String cor;
    private String modelo;

    public Calca(String tamanho, String cor, String modelo) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }
}
