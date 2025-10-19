package view;
import javax.swing.*;
import java.awt.*;
import service.AcademiaService;

public class TelaInstrutor extends JFrame {
    private JTextField txtNome, txtEsp;
    private JTextArea areaLista;
    private AcademiaService service = new AcademiaService();

    public TelaInstrutor() {
        setTitle("Gerenciar Instrutores");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("Especialidade:"));
        txtEsp = new JTextField();
        painel.add(txtEsp);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar Instrutores");
        painel.add(btnCadastrar);
        painel.add(btnListar);

        areaLista = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLista);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarInstrutor());
        btnListar.addActionListener(e -> listarInstrutores());
    }

    private void cadastrarInstrutor() {
        try {
            String nome = txtNome.getText();
            String esp = txtEsp.getText();
            service.cadastrarInstrutor(nome, esp);
            JOptionPane.showMessageDialog(this, "Instrutor cadastrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void listarInstrutores() {
        areaLista.setText("");
        service.getInstrutores().forEach(i -> areaLista.append(i + "\n"));
    }
}
