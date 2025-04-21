import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CachorroApp extends JFrame {

    // Campos de texto para entrada de dados
    private JTextField nomeField, idadeField, racaField;
    private JLabel resultadoLabel;

    // Atributo Cachorro para armazenar os dados do cachorro
    private Cachorro cachorro;

    public CachorroApp() {
        // Configuração da janela
        setTitle("Cadastro de Cachorro");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new BorderLayout());

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Componentes de entrada de dados
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(10);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField(10);

        JLabel racaLabel = new JLabel("Raça:");
        racaField = new JTextField(10);

        JButton submitButton = new JButton("Criar Cachorro");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarCachorro();
            }
        });

        // Adicionando os componentes ao painel
        inputPanel.add(nomeLabel);
        inputPanel.add(nomeField);
        inputPanel.add(idadeLabel);
        inputPanel.add(idadeField);
        inputPanel.add(racaLabel);
        inputPanel.add(racaField);
        inputPanel.add(submitButton);

        // Painel para exibir o resultado
        JPanel resultPanel = new JPanel();
        resultadoLabel = new JLabel("Informações do Cachorro aparecerão aqui.");
        resultPanel.add(resultadoLabel);

        // Adicionando os painéis à janela
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void criarCachorro() {
        // Coleta os dados dos campos de texto
        String nome = nomeField.getText();
        String idade = idadeField.getText();
        String raca = racaField.getText();

        // Valida se todos os campos foram preenchidos
        if (nome.isEmpty() || idade.isEmpty() || raca.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Cria um objeto Cachorro com os dados
            cachorro = new Cachorro(nome, Integer.parseInt(idade), raca);

            // Exibe as informações no painel
            resultadoLabel.setText("<html><b>Nome:</b> " + cachorro.getNome() +
                                   "<br><b>Idade:</b> " + cachorro.getIdade() +
                                   "<br><b>Raça:</b> " + cachorro.getRaca() + "</html>");

            // Redesenha a tela para exibir a figura do cachorro
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (cachorro != null) {
            // Desenha o cachorro após os dados serem preenchidos
            g.setColor(Color.BLACK); // Cor do corpo do cachorro
            g.fillRoundRect(150, 250, 200, 100, 50, 50); // Corpo do cachorro

            // Cabeça do cachorro
            g.setColor(Color.PINK);
            g.fillOval(170, 180, 100, 100); // Cabeça

            // Olhos
            g.setColor(Color.BLACK);
            g.fillOval(190, 210, 10, 10); // Olho esquerdo
            g.fillOval(220, 210, 10, 10); // Olho direito

            // Focinho
            g.setColor(Color.BLACK);
            g.fillOval(200, 240, 20, 20); // Focinho

            // Orelhas
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{170, 160, 190}, new int[]{190, 170, 200}, 3); // Orelha esquerda
            g.fillPolygon(new int[]{270, 280, 240}, new int[]{190, 170, 200}, 3); // Orelha direita

            // Patas
            g.setColor(Color.BLACK);
            g.fillRoundRect(170, 340, 20, 40, 10, 10); // Pata esquerda
            g.fillRoundRect(210, 340, 20, 40, 10, 10); // Pata direita
            g.fillRoundRect(230, 340, 20, 40, 10, 10); // Pata esquerda
            g.fillRoundRect(270, 340, 20, 40, 10, 10); // Pata direita

            // Cauda
            g.setColor(Color.BLACK);
            g.drawLine(350, 290, 400, 250); // Cauda
        }
    }

    public static void main(String[] args) {
        new CachorroApp(); // Inicia a aplicação
    }
}

class Cachorro {
    private String nome;
    private int idade;
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getRaca() {
        return raca;
    }
}
