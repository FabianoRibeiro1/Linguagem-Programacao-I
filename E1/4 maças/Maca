import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MacaApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField corField, tipoField, tamanhoField;
    private JLabel resultadoLabel;

    public MacaApp() {
        // Configuração da janela
        setTitle("Cadastro de Maçã");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Componentes de entrada de dados
        JLabel corLabel = new JLabel("Cor (Hexadecimal):");
        corField = new JTextField(10);
        
        JLabel tipoLabel = new JLabel("Tipo de Maçã:");
        tipoField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Maçã");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarMaca();
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
        resultadoLabel = new JLabel("Informações da Maçã aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarMaca() {
        // Coleta os dados dos campos de texto
        String cor = corField.getText();
        String tipo = tipoField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (cor.isEmpty() || tipo.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Maca com os dados
            Maca maca = new Maca(cor, tipo, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tipo:</b> " + maca.getTipo() +
                                   "<br><b>Cor:</b> " + maca.getCor() +
                                   "<br><b>Tamanho:</b> " + maca.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura da maçã
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura da maçã após os dados serem preenchidos
        if (!corField.getText().isEmpty() && !tipoField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String corMaca = corField.getText(); // Cor da maçã
            g.setColor(Color.decode(corMaca)); // Define a cor da maçã

            // Desenho da maçã
            g.fillOval(150, 150, 100, 100); // Corpo da maçã (redonda)

            // Desenho do talo
            g.setColor(new Color(139, 69, 19)); // Cor marrom para o talo
            g.fillRect(195, 130, 10, 20); // Talo da maçã

            // Desenho da folha (opcional)
            g.setColor(Color.GREEN);
            g.fillPolygon(new int[]{200, 210, 220}, new int[]{130, 120, 130}, 3); // Folha

            // Exemplo de personalização: se o tamanho for "Grande", fazer a maçã maior
            if ("Grande".equalsIgnoreCase(tamanhoField.getText())) {
                g.fillOval(140, 140, 120, 120); // Corpo da maçã maior
            }
        }
    }

    public static void main(String[] args) {
        new MacaApp(); // Inicia a aplicação
    }
}

class Maca {
    private String cor;
    private String tipo;
    private String tamanho;

    public Maca(String cor, String tipo, String tamanho) {
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
