package view;
import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema da Academia");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnAluno = new JButton("Gerenciar Alunos");
        JButton btnInstrutor = new JButton("Gerenciar Instrutores");
        JButton btnPlano = new JButton("Gerenciar Planos de Treino");
        JButton btnFrequencia = new JButton("Gerenciar Frequência");
        JButton btnSair = new JButton("Sair");

        painel.add(btnAluno);
        painel.add(btnInstrutor);
        painel.add(btnPlano);
        painel.add(btnFrequencia);
        painel.add(btnSair);

        add(painel);

        // Ações dos botões
        btnAluno.addActionListener(e -> new TelaAluno().setVisible(true));
        btnInstrutor.addActionListener(e -> new TelaInstrutor().setVisible(true));
        btnPlano.addActionListener(e -> new TelaPlano().setVisible(true));
        btnFrequencia.addActionListener(e -> new TelaFrequencia().setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }
}
