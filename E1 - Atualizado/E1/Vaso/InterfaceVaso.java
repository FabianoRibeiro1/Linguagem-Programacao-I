package E1.Vaso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceVaso {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Vaso");
        frame.setSize(400, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblMaterial = new JLabel("Material:");
        lblMaterial.setBounds(30, 20, 100, 25);
        frame.add(lblMaterial);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 60, 100, 25);
        frame.add(lblCor);

        JLabel lblPlantas = new JLabel("Possui plantas?");
        lblPlantas.setBounds(30, 100, 120, 25);
        frame.add(lblPlantas);

        // Campos de entrada
        JTextField txtMaterial = new JTextField();
        txtMaterial.setBounds(130, 20, 200, 25);
        frame.add(txtMaterial);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(130, 60, 200, 25);
        frame.add(txtCor);

        JCheckBox chkPlantas = new JCheckBox();
        chkPlantas.setBounds(150, 100, 50, 25);
        frame.add(chkPlantas);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Vaso");
        btnCadastrar.setBounds(30, 160, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 160, 150, 30);
        frame.add(btnMostrar);

        // Armazena o vaso cadastrado
        final Vaso[] vaso = new Vaso[1];

        // Ação do botão cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String material = txtMaterial.getText();
                String cor = txtCor.getText();
                boolean possuiPlantas = chkPlantas.isSelected();

                if (!material.isEmpty() && !cor.isEmpty()) {
                    vaso[0] = new Vaso(material, cor, possuiPlantas);
                    JOptionPane.showMessageDialog(frame, "Vaso cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vaso[0] != null) {
                    JOptionPane.showMessageDialog(frame, vaso[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhum vaso cadastrado ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}
