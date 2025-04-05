import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PipaApp extends JFrame {

    // Componentes da GUI
    private JTextField corField;
    private JTextField tamanhoField;
    private JTextField linhaField;
    private JTextArea resultadoArea;
    private JButton instanciarButton;
    private JButton voarButton;
    private JButton descerButton;

    // Atributo da pipa
    private Pipa pipa;

    // Construtor da interface gráfica
    public PipaApp() {
        setTitle("Coletor de Dados da Pipa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(4, 2));

        panelEntrada.add(new JLabel("Cor da Pipa:"));
        corField = new JTextField();
        panelEntrada.add(corField);

        panelEntrada.add(new JLabel("Tamanho (metros):"));
        tamanhoField = new JTextField();
        panelEntrada.add(tamanhoField);

        panelEntrada.add(new JLabel("Tipo de Linha:"));
        linhaField = new JTextField();
        panelEntrada.add(linhaField);

        instanciarButton = new JButton("Criar Pipa");
        panelEntrada.add(instanciarButton);

        // Painel de controle da pipa
        JPanel panelControle = new JPanel();
        voarButton = new JButton("Fazer Pipa Voar");
        descerButton = new JButton("Fazer Pipa Descer");

        panelControle.add(voarButton);
        panelControle.add(descerButton);

        // Área para exibição do resultado
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        // Adicionando componentes na janela
        add(panelEntrada, BorderLayout.NORTH);
        add(panelControle, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Definindo ações dos botões
        instanciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coletando dados do usuário
                String cor = corField.getText();
                double tamanho = Double.parseDouble(tamanhoField.getText());
                String tipoDeLinha = linhaField.getText();

                // Instanciando a pipa
                pipa = new Pipa(cor, tamanho, tipoDeLinha);
                mostrarStatus();
            }
        });

        voarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pipa != null) {
                    pipa.voar();
                    mostrarStatus();
                } else {
                    JOptionPane.showMessageDialog(PipaApp.this, "Primeiro crie uma pipa!");
                }
            }
        });

        descerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pipa != null) {
                    pipa.descer();
                    mostrarStatus();
                } else {
                    JOptionPane.showMessageDialog(PipaApp.this, "Primeiro crie uma pipa!");
                }
            }
        });
    }

    // Exibe o status da pipa na área de texto
    private void mostrarStatus() {
        if (pipa != null) {
            resultadoArea.setText("Cor da Pipa: " + pipa.getCor() + "\n");
            resultadoArea.append("Tamanho da Pipa: " + pipa.getTamanho() + " metros\n");
            resultadoArea.append("Tipo de Linha: " + pipa.getTipoDeLinha() + "\n");
            resultadoArea.append("Está voando? " + (pipa.isEstaVoadora() ? "Sim" : "Não"));
        }
    }

    // Classe principal para rodar a aplicação
    public static void main(String[] args) {
        // Criando e mostrando a janela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PipaApp app = new PipaApp();
                app.setVisible(true);
            }
        });
    }
}

class Pipa {

    // Atributos da pipa
    private String cor;
    private double tamanho;
    private String tipoDeLinha;
    private boolean estaVoadora;

    // Construtor da classe Pipa
    public Pipa(String cor, double tamanho, String tipoDeLinha) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.tipoDeLinha = tipoDeLinha;
        this.estaVoadora = false;
    }

    // Métodos getters
    public String getCor() {
        return cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getTipoDeLinha() {
        return tipoDeLinha;
    }

    public boolean isEstaVoadora() {
        return estaVoadora;
    }

    // Métodos para controle da pipa
    public void voar() {
        if (!estaVoadora) {
            estaVoadora = true;
        }
    }

    public void descer() {
        if (estaVoadora) {
            estaVoadora = false;
        }
    }
}
