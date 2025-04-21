package E1.Flores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceFlor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Flor");
        frame.setSize(400, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 20, 100, 25);
        frame.add(lblNome);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 60, 100, 25);
        frame.add(lblCor);

        JLabel lblPerfumada = new JLabel("É perfumada?");
        lblPerfumada.setBounds(30, 100, 120, 25);
        frame.add(lblPerfumada);

        // Campos de entrada
        JTextField txtNome = new JTextField();
        txtNome.setBounds(130, 20, 200, 25);
        frame.add(txtNome);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(130, 60, 200, 25);
        frame.add(txtCor);

        JCheckBox chkPerfumada = new JCheckBox();
        chkPerfumada.setBounds(150, 100, 50, 25);
        frame.add(chkPerfumada);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Flor");
        btnCadastrar.setBounds(30, 160, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 160, 150, 30);
        frame.add(btnMostrar);

        // Armazena a flor cadastrada
        final Flor[] flor = new Flor[1];

        // Ação do botão cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cor = txtCor.getText();
                boolean perfumada = chkPerfumada.isSelected();

                if (!nome.isEmpty() && !cor.isEmpty()) {
                    flor[0] = new Flor(nome, cor, perfumada);
                    JOptionPane.showMessageDialog(frame, "Flor cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flor[0] != null) {
                    JOptionPane.showMessageDialog(frame, flor[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma flor cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}

