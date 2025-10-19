package view;
import javax.swing.*;
import java.awt.*;
import service.AcademiaService;

public class TelaPlano extends JFrame {
    private JTextField txtIdAluno, txtIdInstrutor, txtDescricao, txtDuracao;
    private JTextArea areaLista;
    private AcademiaService service = new AcademiaService();

    public TelaPlano() {
        setTitle("Gerenciar Planos de Treino");
        setSize(450, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));

        painel.add(new JLabel("ID Aluno:"));
        txtIdAluno = new JTextField();
        painel.add(txtIdAluno);

        painel.add(new JLabel("ID Instrutor:"));
        txtIdInstrutor = new JTextField();
        painel.add(txtIdInstrutor);

        painel.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        painel.add(txtDescricao);

        painel.add(new JLabel("Duração (semanas):"));
        txtDuracao = new JTextField();
        painel.add(txtDuracao);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Planos");
        painel.add(btnCadastrar);
        painel.add(btnListar);

        areaLista = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLista);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarPlano());
        btnListar.addActionListener(e -> listarPlanos());
    }

    private void cadastrarPlano() {
        try {
            int idAluno = Integer.parseInt(txtIdAluno.getText());
            int idInstrutor = Integer.parseInt(txtIdInstrutor.getText());
            String descricao = txtDescricao.getText();
            int duracao = Integer.parseInt(txtDuracao.getText());

            service.cadastrarPlano(idAluno, idInstrutor, descricao, duracao);
            JOptionPane.showMessageDialog(this, "Plano cadastrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void listarPlanos() {
        areaLista.setText("");
        service.getPlanos().forEach(p -> areaLista.append(p + "\n"));
    }
}
