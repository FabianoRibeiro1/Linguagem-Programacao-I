import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VasoApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField corField, tipoField, tamanhoField;
    private JLabel resultadoLabel;

    public VasoApp() {
        // Configuração da janela
        setTitle("Cadastro de Vaso");
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
        
        JLabel tipoLabel = new JLabel("Tipo de Vaso (Cônico/Redondo):");
        tipoField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Vaso");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarVaso();
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
        resultadoLabel = new JLabel("Informações do Vaso aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarVaso() {
        // Coleta os dados dos campos de texto
        String cor = corField.getText();
        String tipo = tipoField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (cor.isEmpty() || tipo.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Vaso com os dados
            Vaso vaso = new Vaso(cor, tipo, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tipo:</b> " + vaso.getTipo() +
                                   "<br><b>Cor:</b> " + vaso.getCor() +
                                   "<br><b>Tamanho:</b> " + vaso.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura do vaso
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura do vaso após os dados serem preenchidos
        if (!corField.getText().isEmpty() && !tipoField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String corVaso = corField.getText(); // Cor do vaso
            g.setColor(Color.decode(corVaso)); // Define a cor do vaso

            // Desenha o vaso (depende do tipo de vaso)
            if ("Cônico".equalsIgnoreCase(tipoField.getText())) {
                // Vaso cônico (triângulo invertido)
                g.fillPolygon(new int[]{150, 250, 200}, new int[]{150, 150, 250}, 3); // Base do vaso cônico
                g.fillRect(170, 250, 60, 30); // Base do vaso cônico (base retangular)
            } else {
                // Vaso redondo (circular)
                g.fillOval(150, 150, 100, 150); // Corpo do vaso redondo
            }

            // Tamanho do vaso: altera o tamanho do vaso desenhado
            if ("Grande".equalsIgnoreCase(tamanhoField.getText())) {
                g.fillOval(130, 130, 140, 200); // Corpo do vaso maior
            } else if ("Pequeno".equalsIgnoreCase(tamanhoField.getText())) {
                g.fillOval(160, 160, 80, 120); // Corpo do vaso menor
            }
        }
    }

    public static void main(String[] args) {
        new VasoApp(); // Inicia a aplicação
    }
}

class Vaso {
    private String cor;
    private String tipo;
    private String tamanho;

    public Vaso(String cor, String tipo, String tamanho) {
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
