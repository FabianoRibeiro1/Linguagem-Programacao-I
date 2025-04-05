import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasaApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField corField, tipoField, tamanhoField;
    private JLabel resultadoLabel;

    public CasaApp() {
        // Configuração da janela
        setTitle("Cadastro de Casa");
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
        
        JLabel tipoLabel = new JLabel("Tipo de Casa (Simples/Dupla):");
        tipoField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Casa");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarCasa();
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
        resultadoLabel = new JLabel("Informações da Casa aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarCasa() {
        // Coleta os dados dos campos de texto
        String cor = corField.getText();
        String tipo = tipoField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (cor.isEmpty() || tipo.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Casa com os dados
            Casa casa = new Casa(cor, tipo, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tipo:</b> " + casa.getTipo() +
                                   "<br><b>Cor:</b> " + casa.getCor() +
                                   "<br><b>Tamanho:</b> " + casa.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura da casa
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha a figura da casa após os dados serem preenchidos
        if (!corField.getText().isEmpty() && !tipoField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String corCasa = corField.getText(); // Cor da casa
            g.setColor(Color.decode(corCasa)); // Define a cor da casa

            // Desenho da base da casa (retângulo)
            g.fillRect(150, 150, 100, 100); // Corpo da casa

            // Telhado (depende do tipo de casa)
            if ("Dupla".equalsIgnoreCase(tipoField.getText())) {
                g.setColor(Color.BLACK); // Cor preta para o telhado
                g.fillPolygon(new int[]{150, 200, 250}, new int[]{150, 100, 150}, 3); // Telhado em duas águas
            } else {
                g.setColor(Color.BLACK); // Cor preta para o telhado
                g.fillPolygon(new int[]{150, 200, 250}, new int[]{150, 100, 150}, 3); // Telhado simples
            }

            // Tamanho da casa: altera o tamanho do corpo da casa
            if ("Grande".equalsIgnoreCase(tamanhoField.getText())) {
                g.fillRect(130, 130, 140, 140); // Corpo da casa maior
            } else if ("Pequeno".equalsIgnoreCase(tamanhoField.getText())) {
                g.fillRect(160, 160, 80, 80); // Corpo da casa menor
            }
        }
    }

    public static void main(String[] args) {
        new CasaApp(); // Inicia a aplicação
    }
}

class Casa {
    private String cor;
    private String tipo;
    private String tamanho;

    public Casa(String cor, String tipo, String tamanho) {
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
