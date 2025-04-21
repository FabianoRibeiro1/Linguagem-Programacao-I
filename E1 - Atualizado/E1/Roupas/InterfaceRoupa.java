package E1.Roupas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceRoupa {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Roupa");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 20, 100, 25);
        frame.add(lblTipo);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(30, 60, 100, 25);
        frame.add(lblTamanho);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 100, 100, 25);
        frame.add(lblCor);

        // Campos de texto
        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(130, 20, 200, 25);
        frame.add(txtTipo);

        JTextField txtTamanho = new JTextField();
        txtTamanho.setBounds(130, 60, 200, 25);
        frame.add(txtTamanho);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(130, 100, 200, 25);
        frame.add(txtCor);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Roupa");
        btnCadastrar.setBounds(30, 150, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 150, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar a roupa
        final Roupa[] roupa = new Roupa[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = txtTipo.getText();
                String tamanho = txtTamanho.getText();
                String cor = txtCor.getText();

                if (!tipo.isEmpty() && !tamanho.isEmpty() && !cor.isEmpty()) {
                    roupa[0] = new Roupa(tipo, tamanho, cor);
                    JOptionPane.showMessageDialog(frame, "Roupa cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (roupa[0] != null) {
                    JOptionPane.showMessageDialog(frame, roupa[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma roupa cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}
