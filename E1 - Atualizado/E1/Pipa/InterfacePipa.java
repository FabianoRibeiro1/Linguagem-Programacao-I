package E1.Pipa;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfacePipa {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Pipa");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 20, 100, 25);
        frame.add(lblCor);

        JLabel lblTamanho = new JLabel("Tamanho:");
        lblTamanho.setBounds(30, 60, 100, 25);
        frame.add(lblTamanho);

        JLabel lblTipoLinha = new JLabel("Tipo de Linha:");
        lblTipoLinha.setBounds(30, 100, 100, 25);
        frame.add(lblTipoLinha);

        // Campos de texto
        JTextField txtCor = new JTextField();
        txtCor.setBounds(130, 20, 200, 25);
        frame.add(txtCor);

        JTextField txtTamanho = new JTextField();
        txtTamanho.setBounds(130, 60, 200, 25);
        frame.add(txtTamanho);

        JTextField txtTipoLinha = new JTextField();
        txtTipoLinha.setBounds(130, 100, 200, 25);
        frame.add(txtTipoLinha);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Pipa");
        btnCadastrar.setBounds(30, 150, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 150, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar a pipa
        final Pipa[] pipa = new Pipa[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cor = txtCor.getText();
                String tamanho = txtTamanho.getText();
                String tipoLinha = txtTipoLinha.getText();

                if (!cor.isEmpty() && !tamanho.isEmpty() && !tipoLinha.isEmpty()) {
                    pipa[0] = new Pipa(cor, tamanho, tipoLinha);
                    JOptionPane.showMessageDialog(frame, "Pipa cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pipa[0] != null) {
                    JOptionPane.showMessageDialog(frame, pipa[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma pipa cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}
