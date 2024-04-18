import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class Transferir implements ActionListener {
    private JButton depositarButton, voltarButton;
    private JFrame frame;
    private JTextField saldoTextField, destinoTextField;

    public Transferir() {
        frame = new JFrame("Transferir");

        depositarButton = new JButton("Transferir");
        voltarButton = new JButton("Voltar");

        depositarButton.addActionListener(this);
        voltarButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        voltarButton.setBounds(250, 350, 150, 40);
        voltarButton.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(voltarButton);

        depositarButton.setBounds(420, 350, 150, 40);
        depositarButton.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(depositarButton);

        saldoTextField = new JTextField();
        saldoTextField.setBounds(300, 200, 200, 30);
        frame.add(saldoTextField);

        destinoTextField = new JTextField();
        destinoTextField.setBounds(300, 300, 200, 30);
        frame.add(destinoTextField);

        JLabel saldoLabel = new JLabel("Saldo:");
        saldoLabel.setBounds(212, 200, 80, 30);
        frame.add(saldoLabel);

        JLabel destinoLabel = new JLabel("Destino:");
        destinoLabel.setBounds(200, 300, 80, 30);
        frame.add(destinoLabel);

        frame.setVisible(true);

        // Aplica o filtro para aceitar apenas números no campo de saldo
        ((AbstractDocument) saldoTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositarButton) {
            // Aqui você pode acessar os valores dos campos de texto
            String saldo = saldoTextField.getText();
            String destino = destinoTextField.getText();

            // Realize as operações de depósito com os valores obtidos
            // Exemplo: realizarDeposito(saldo, destino);

            System.out.println("Depositar clicado!");
        } else if (e.getSource() == voltarButton) {
            System.out.println("Voltar clicado!");
            frame.dispose(); // Fecha a janela ao clicar no botão Voltar
            // Adicione aqui o código para voltar à tela anterior
            new Perfil();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Transferir();
            }
        });
    }
}
