package view;
import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import service.AcademiaService;

public class TelaAluno extends JFrame {
    private JTextField txtNome, txtCpf, txtData;
    private JTextArea areaLista;
    private AcademiaService service = new AcademiaService();

    public TelaAluno() {
        setTitle("Gerenciar Alunos");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(6, 2, 5, 5));

        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        painel.add(txtCpf);

        painel.add(new JLabel("Data de Ingresso (AAAA-MM-DD):"));
        txtData = new JTextField();
        painel.add(txtData);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Alunos");

        painel.add(btnCadastrar);
        painel.add(btnListar);

        areaLista = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLista);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarAluno());
        btnListar.addActionListener(e -> listarAlunos());
    }

    private void cadastrarAluno() {
        try {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            Date data = Date.valueOf(txtData.getText());
            service.cadastrarAluno(nome, cpf, data);
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void listarAlunos() {
        areaLista.setText("");
        service.getAlunos().forEach(a -> areaLista.append(a + "\n"));
    }
}
