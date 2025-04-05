import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TalherApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField tipoField, materialField, tamanhoField;
    private JLabel resultadoLabel;

    public TalherApp() {
        // Configuração da janela
        setTitle("Cadastro de Talher");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Componentes de entrada de dados
        JLabel tipoLabel = new JLabel("Tipo (Faca, Garfo, Colher):");
        tipoField = new JTextField(10);
        
        JLabel materialLabel = new JLabel("Material (Ex: Inox, Plástico):");
        materialField = new JTextField(10);

        JLabel tamanhoLabel = new JLabel("Tamanho (Pequeno/Médio/Grande):");
        tamanhoField = new JTextField(10);

        JButton submitButton = new JButton("Criar Talher");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarTalher();
            }
        });

        // Adicionando os componentes ao painel
        inputPanel.add(tipoLabel);
        inputPanel.add(tipoField);
        inputPanel.add(materialLabel);
        inputPanel.add(materialField);
        inputPanel.add(tamanhoLabel);
        inputPanel.add(tamanhoField);
        inputPanel.add(submitButton);

        // Painel para exibir o resultado
        JPanel resultPanel = new JPanel();
        resultadoLabel = new JLabel("Informações do Talher aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarTalher() {
        // Coleta os dados dos campos de texto
        String tipo = tipoField.getText();
        String material = materialField.getText();
        String tamanho = tamanhoField.getText();

        // Valida se todos os campos foram preenchidos
        if (tipo.isEmpty() || material.isEmpty() || tamanho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Talher com os dados
            Talher talher = new Talher(tipo, material, tamanho);
            
            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Tipo:</b> " + talher.getTipo() +
                                   "<br><b>Material:</b> " + talher.getMaterial() +
                                   "<br><b>Tamanho:</b> " + talher.getTamanho() + "</html>");

            // Redesenha a tela para exibir a figura do talher
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Desenha os talheres com base nos dados inseridos
        if (!tipoField.getText().isEmpty() && !materialField.getText().isEmpty() && !tamanhoField.getText().isEmpty()) {
            String tipoTalher = tipoField.getText().toLowerCase(); // Tipo do talher (garfo, faca, colher)
            String material = materialField.getText(); // Material do talher
            String tamanho = tamanhoField.getText(); // Tamanho do talher

            // Define a cor do talher baseado no material
            if ("inox".equalsIgnoreCase(material)) {
                g.setColor(Color.GRAY); // Inox
            } else if ("plástico".equalsIgnoreCase(material)) {
                g.setColor(Color.YELLOW); // Plástico
            } else {
                g.setColor(Color.BLACK); // Cor padrão para outros materiais
            }

            // Desenhando o talher dependendo do tipo
            if ("garfo".equals(tipoTalher)) {
                desenhaGarfo(g, tamanho);
            } else if ("faca".equals(tipoTalher)) {
                desenhaFaca(g, tamanho);
            } else if ("colher".equals(tipoTalher)) {
                desenhaColher(g, tamanho);
            }
        }
    }

    // Desenha um Garfo
    private void desenhaGarfo(Graphics g, String tamanho) {
        int x = 200, y = 200;
        int altura = 100;

        if ("pequeno".equalsIgnoreCase(tamanho)) {
            altura = 50;
        } else if ("grande".equalsIgnoreCase(tamanho)) {
            altura = 150;
        }

        // Corpo do garfo (pode ser um retângulo)
        g.fillRect(x + 20, y, 10, altura);

        // Ponta do garfo (três dentes)
        g.fillRect(x, y + altura - 20, 10, 20); // Dente esquerdo
        g.fillRect(x + 10, y + altura - 20, 10, 20); // Dente do meio
        g.fillRect(x + 20, y + altura - 20, 10, 20); // Dente direito
    }

    // Desenha uma Faca
    private void desenhaFaca(Graphics g, String tamanho) {
        int x = 200, y = 200;
        int comprimento = 120;

        if ("pequeno".equalsIgnoreCase(tamanho)) {
            comprimento = 60;
        } else if ("grande".equalsIgnoreCase(tamanho)) {
            comprimento = 180;
        }

        // Corpo da faca (pode ser um retângulo)
        g.fillRect(x + 20, y, 10, comprimento);

        // Lâmina da faca (parte superior)
        g.setColor(Color.GRAY);
        g.fillRect(x - 10, y + 10, 40, comprimento / 5);
    }

    // Desenha uma Colher
    private void desenhaColher(Graphics g, String tamanho) {
        int x = 200, y = 200;
        int comprimento = 120;

        if ("pequeno".equalsIgnoreCase(tamanho)) {
            comprimento = 60;
        } else if ("grande".equalsIgnoreCase(tamanho)) {
            comprimento = 180;
        }

        // Corpo da colher (pode ser um retângulo)
        g.fillRect(x + 20, y, 10, comprimento);

        // Parte da colher (forma oval)
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x - 20, y + comprimento - 40, 50, 30); // Parte arredondada da colher
    }

    public static void main(String[] args) {
        new TalherApp(); // Inicia a aplicação
    }
}

class Talher {
    private String tipo;
    private String material;
    private String tamanho;

    public Talher(String tipo, String material, String tamanho) {
        this.tipo = tipo;
        this.material = material;
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public String getTamanho() {
        return tamanho;
    }
}

