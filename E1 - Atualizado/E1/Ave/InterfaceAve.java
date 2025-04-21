package E1.Ave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceAve {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Ave");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblEspecie = new JLabel("Espécie:");
        lblEspecie.setBounds(30, 20, 100, 25);
        frame.add(lblEspecie);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 60, 100, 25);
        frame.add(lblCor);

        JLabel lblEnvergadura = new JLabel("Envergadura (cm):");
        lblEnvergadura.setBounds(30, 100, 150, 25);
        frame.add(lblEnvergadura);

        // Campos de texto
        JTextField txtEspecie = new JTextField();
        txtEspecie.setBounds(170, 20, 180, 25);
        frame.add(txtEspecie);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(170, 60, 180, 25);
        frame.add(txtCor);

        JTextField txtEnvergadura = new JTextField();
        txtEnvergadura.setBounds(170, 100, 180, 25);
        frame.add(txtEnvergadura);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Ave");
        btnCadastrar.setBounds(30, 150, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 150, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar a ave
        final Ave[] ave = new Ave[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String especie = txtEspecie.getText();
                String cor = txtCor.getText();
                String envergaduraStr = txtEnvergadura.getText();

                try {
                    double envergadura = Double.parseDouble(envergaduraStr);

                    if (!especie.isEmpty() && !cor.isEmpty()) {
                        ave[0] = new Ave(especie, cor, envergadura);
                        JOptionPane.showMessageDialog(frame, "Ave cadastrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Envergadura inválida. Use números.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ave[0] != null) {
                    JOptionPane.showMessageDialog(frame, ave[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma ave cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}

