package E1.Maça;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceMaca {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Maçã");
        frame.setSize(400, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Labels
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 20, 100, 25);
        frame.add(lblTipo);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(30, 60, 100, 25);
        frame.add(lblCor);

        JLabel lblMadura = new JLabel("Está madura?");
        lblMadura.setBounds(30, 100, 120, 25);
        frame.add(lblMadura);

        // Campos de entrada
        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(130, 20, 200, 25);
        frame.add(txtTipo);

        JTextField txtCor = new JTextField();
        txtCor.setBounds(130, 60, 200, 25);
        frame.add(txtCor);

        JCheckBox chkMadura = new JCheckBox();
        chkMadura.setBounds(150, 100, 50, 25);
        frame.add(chkMadura);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar Maçã");
        btnCadastrar.setBounds(30, 160, 150, 30);
        frame.add(btnCadastrar);

        JButton btnMostrar = new JButton("Mostrar Dados");
        btnMostrar.setBounds(200, 160, 150, 30);
        frame.add(btnMostrar);

        // Armazena a maçã cadastrada
        final Maca[] maca = new Maca[1];

        // Ação do botão cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = txtTipo.getText();
                String cor = txtCor.getText();
                boolean madura = chkMadura.isSelected();

                if (!tipo.isEmpty() && !cor.isEmpty()) {
                    maca[0] = new Maca(tipo, cor, madura);
                    JOptionPane.showMessageDialog(frame, "Maçã cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                }
            }
        });

        // Ação do botão mostrar dados
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maca[0] != null) {
                    JOptionPane.showMessageDialog(frame, maca[0].getDados());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma maçã cadastrada ainda.");
                }
            }
        });

        frame.setVisible(true);
    }
}
