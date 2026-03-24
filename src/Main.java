import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame janela = new JFrame();

        janela.setTitle("Calculadora do Otavio");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Calculadora Java", JLabel.CENTER);

        JLabel labelNumero1 = new JLabel("Primeiro número:");
        JLabel labelNumero2 = new JLabel("Segundo número:");
        JLabel labelResultado = new JLabel("Resultado: ", JLabel.CENTER);

        JTextField campoNumero1 = new JTextField();
        JTextField campoNumero2 = new JTextField();

        campoNumero1.setPreferredSize(new Dimension(120, 25));
        campoNumero2.setPreferredSize(new Dimension(120, 25));

        JButton botaoSomar = new JButton("Somar");
        JButton botaoSubtrair = new JButton("Subtrair");
        JButton botaoMultiplicar = new JButton("Multiplicar");
        JButton botaoDividir = new JButton("Dividir");
        JButton botaoLimpar = new JButton("Limpar");

        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        painelCampos.add(labelNumero1);
        painelCampos.add(campoNumero1);
        painelCampos.add(labelNumero2);
        painelCampos.add(campoNumero2);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 5, 5, 5));
        painelBotoes.add(botaoSomar);
        painelBotoes.add(botaoSubtrair);
        painelBotoes.add(botaoMultiplicar);
        painelBotoes.add(botaoDividir);
        painelBotoes.add(botaoLimpar);

        JPanel painelCentral = new JPanel(new BorderLayout(10, 10));
        painelCentral.add(painelCampos, BorderLayout.CENTER);
        painelCentral.add(painelBotoes, BorderLayout.SOUTH);

        botaoSomar.addActionListener(e -> calcular(campoNumero1, campoNumero2, labelResultado, "+"));
        botaoSubtrair.addActionListener(e -> calcular(campoNumero1, campoNumero2, labelResultado, "-"));
        botaoMultiplicar.addActionListener(e -> calcular(campoNumero1, campoNumero2, labelResultado, "*"));
        botaoDividir.addActionListener(e -> calcular(campoNumero1, campoNumero2, labelResultado, "/"));

        botaoLimpar.addActionListener(e -> {
            campoNumero1.setText("");
            campoNumero2.setText("");
            labelResultado.setText("Resultado: ");
        });

        janela.add(titulo, BorderLayout.NORTH);
        janela.add(painelCentral, BorderLayout.CENTER);
        janela.add(labelResultado, BorderLayout.SOUTH);

        janela.setVisible(true);
    }

    public static void calcular(JTextField campoNumero1, JTextField campoNumero2, JLabel labelResultado, String operacao) {
        try {
            double numero1 = Double.parseDouble(campoNumero1.getText());
            double numero2 = Double.parseDouble(campoNumero2.getText());
            double resultado = 0;

            if (operacao.equals("+")) {
                resultado = numero1 + numero2;
            } else if (operacao.equals("-")) {
                resultado = numero1 - numero2;
            } else if (operacao.equals("*")) {
                resultado = numero1 * numero2;
            } else if (operacao.equals("/")) {
                if (numero2 == 0) {
                    labelResultado.setText("Erro: não pode dividir por zero!");
                    return;
                }
                resultado = numero1 / numero2;
            }

            labelResultado.setText("Resultado: " + resultado);

        } catch (NumberFormatException erro) {
            labelResultado.setText("Erro: digite apenas números!");
        }
    }
}