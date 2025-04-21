package E1.Casa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCasa {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Casa");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(30, 20, 100, 25);
        frame.add(lblEndereco);

        JLabel lblQuartos = new JLabel("Nº de Quartos:");
        lblQuartos.setBounds(30, 60, 100, 25);
        frame.add(lblQuartos);

        JLabel lblGaragem = new JLabel("Possui Garagem?");
        lblGaragem.setBounds(30, 100, 120, 25);
        frame.add(lblGaragem);

        // Campos de texto
        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(150, 20, 200, 25);
        frame.add(txtEndereco);

        JTextField txtQuartos = new JTextField();
        txtQuartos.setBounds(150, 60, 200, 25);
        frame.add(txtQuartos);

        JCheckBox chkGaragem = new JCheckBox();
        chkGaragem.setBounds(150, 100, 50, 25);
        frame.add(chkGaragem);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Casa");
        btnCadastrar.setBounds(30, 160, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 160, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar a casa
        final Casa[] casa = new Casa[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String endereco = txtEndereco.getText();
                String quartosStr = txtQuartos.getText();
                boolean possuiGaragem = chkGaragem.isSelected();

                try {
                    int quartos = Integer.parseInt(quartosStr);

                    if (!endereco.isEmpty()) {
                        casa[0] = new Casa(endereco, quartos, possuiGaragem);
                        JOptionPane.showMessageDialog(frame, "Casa cadastrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número de quartos inválido.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (casa[0] != null) {
                    JOptionPane.showMessageDialog(frame, casa[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma casa cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}

