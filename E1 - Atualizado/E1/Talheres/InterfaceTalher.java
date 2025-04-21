package E1.Talheres;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceTalher {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Talher");
        frame.setSize(400, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 20, 100, 25);
        frame.add(lblTipo);

        JLabel lblMaterial = new JLabel("Material:");
        lblMaterial.setBounds(30, 60, 100, 25);
        frame.add(lblMaterial);

        JLabel lblReutilizavel = new JLabel("É reutilizável?");
        lblReutilizavel.setBounds(30, 100, 120, 25);
        frame.add(lblReutilizavel);

        // Campos de entrada
        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(130, 20, 200, 25);
        frame.add(txtTipo);

        JTextField txtMaterial = new JTextField();
        txtMaterial.setBounds(130, 60, 200, 25);
        frame.add(txtMaterial);

        JCheckBox chkReutilizavel = new JCheckBox();
        chkReutilizavel.setBounds(150, 100, 50, 25);
        frame.add(chkReutilizavel);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Talher");
        btnCadastrar.setBounds(30, 160, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 160, 150, 30);
        frame.add(btnMostrar);

        // Armazena o talher cadastrado
        final Talher[] talher = new Talher[1];

        // Ação do botão cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = txtTipo.getText();
                String material = txtMaterial.getText();
                boolean reutilizavel = chkReutilizavel.isSelected();

                if (!tipo.isEmpty() && !material.isEmpty()) {
                    talher[0] = new Talher(tipo, material, reutilizavel);
                    JOptionPane.showMessageDialog(frame, "Talher cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (talher[0] != null) {
                    JOptionPane.showMessageDialog(frame, talher[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhum talher cadastrado ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}
