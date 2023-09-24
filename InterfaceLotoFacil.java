package lotofacil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceLotoFacil extends JFrame {
    private JButton btnAposta0a100;
    private JButton btnApostaAZ;
    private JButton btnApostaParImpar;

    public InterfaceLotoFacil() {
        // Configurações da janela
        setTitle("LOTOFÁCIL");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botão para aposta de 0 a 100
        btnAposta0a100 = new JButton("Apostar de 0 a 100");
        btnAposta0a100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAposta0a100();
            }
        });
        add(btnAposta0a100);

        // Botão para aposta de A à Z
        btnApostaAZ = new JButton("Apostar de A à Z");
        btnApostaAZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarApostaAZ();
            }
        });
        add(btnApostaAZ);

        // Botão para aposta em Par ou Ímpar
        btnApostaParImpar = new JButton("Apostar em Par ou Ímpar");
        btnApostaParImpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarApostaParImpar();
            }
        });
        add(btnApostaParImpar);
    }

    private void realizarAposta0a100() {
        String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
        try {
            int numeroApostado = Integer.parseInt(input);

            if (numeroApostado >= 0 && numeroApostado <= 100) {
                int numeroSorteado = (int) (Math.random() * 101);

                if (numeroApostado == numeroSorteado) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Tente novamente.");
        }
    }

    private void realizarApostaAZ() {
        String input = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z:");
        if (input != null && input.length() == 1) {
            char letraApostada = input.toUpperCase().charAt(0);
            char letraPremiada = 'J'; // Substitua pela sua letra premiada

            if (Character.isLetter(letraApostada)) {
                if (letraApostada == letraPremiada) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aposta inválida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Digite uma única letra.");
        }
    }

    private void realizarApostaParImpar() {
        String input = JOptionPane.showInputDialog(null, "Digite um número inteiro:");
        try {
            int numeroParaApostar = Integer.parseInt(input);

            if (numeroParaApostar % 2 == 0) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Tente novamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfaceLotoFacil lotofacil = new InterfaceLotoFacil();
                lotofacil.setVisible(true);
            }
        });
    }
}
