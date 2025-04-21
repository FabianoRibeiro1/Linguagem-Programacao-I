package E1.Cachorro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCachorro {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Cachorro");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 20, 100, 25);
        frame.add(lblNome);

        JLabel lblRaca = new JLabel("Raça:");
        lblRaca.setBounds(30, 60, 100, 25);
        frame.add(lblRaca);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(30, 100, 100, 25);
        frame.add(lblIdade);

        // Campos de texto
        JTextField txtNome = new JTextField();
        txtNome.setBounds(130, 20, 200, 25);
        frame.add(txtNome);

        JTextField txtRaca = new JTextField();
        txtRaca.setBounds(130, 60, 200, 25);
        frame.add(txtRaca);

        JTextField txtIdade = new JTextField();
        txtIdade.setBounds(130, 100, 200, 25);
        frame.add(txtIdade);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Cachorro");
        btnCadastrar.setBounds(30, 150, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 150, 150, 30);
        frame.add(btnMostrar);

        // Variável para armazenar o cachorro
        final Cachorro[] cachorro = new Cachorro[1];

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String raca = txtRaca.getText();
                String idadeStr = txtIdade.getText();

                try {
                    int idade = Integer.parseInt(idadeStr);

                    if (!nome.isEmpty() && !raca.isEmpty()) {
                        cachorro[0] = new Cachorro(nome, raca, idade);
                        JOptionPane.showMessageDialog(frame, "Cachorro cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Idade inválida. Use apenas números.");
                }
            }
        });

        // Ação do botão de mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cachorro[0] != null) {
                    JOptionPane.showMessageDialog(frame, cachorro[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhum cachorro cadastrado ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}

