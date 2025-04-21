package E1.Carro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCarro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Carro");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 20, 100, 25);
        frame.add(lblModelo);

        JLabel lblAno = new JLabel("Ano:");
        lblAno.setBounds(30, 60, 100, 25);
        frame.add(lblAno);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 100, 100, 25);
        frame.add(lblCor);

        // Campos de texto
        JTextField txtModelo = new JTextField();
        txtModelo.setBounds(100, 20, 200, 25);
        frame.add(txtModelo);

        JTextField txtAno = new JTextField();
        txtAno.setBounds(100, 60, 200, 25);
        frame.add(txtAno);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(100, 100, 200, 25);
        frame.add(txtCor);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Carro");
        btnCadastrar.setBounds(30, 150, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 150, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar o carro
        final Carro[] carro = new Carro[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo = txtModelo.getText();
                String anoStr = txtAno.getText();
                String cor = txtCor.getText();

                try {
                    int ano = Integer.parseInt(anoStr);
                    carro[0] = new Carro(modelo, ano, cor);
                    JOptionPane.showMessageDialog(frame, "Carro cadastrado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ano inválido. Digite um número.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carro[0] != null) {
                    JOptionPane.showMessageDialog(frame, carro[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhum carro cadastrado ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}

