package view;
import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import service.AcademiaService;

public class TelaFrequencia extends JFrame {
    private JTextField txtIdAluno, txtData;
    private JCheckBox checkPresenca;
    private JTextArea areaLista;
    private AcademiaService service = new AcademiaService();

    public TelaFrequencia() {
        setTitle("Gerenciar Frequência");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(5, 2, 5, 5));

        painel.add(new JLabel("ID do Aluno:"));
        txtIdAluno = new JTextField();
        painel.add(txtIdAluno);

        painel.add(new JLabel("Data (AAAA-MM-DD):"));
        txtData = new JTextField();
        painel.add(txtData);

        painel.add(new JLabel("Presença:"));
        checkPresenca = new JCheckBox("Presente");
        painel.add(checkPresenca);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnListar = new JButton("Listar Frequência");
        painel.add(btnRegistrar);
        painel.add(btnListar);

        areaLista = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLista);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> registrarFrequencia());
        btnListar.addActionListener(e -> listarFrequencias());
    }

    private void registrarFrequencia() {
        try {
            int idAluno = Integer.parseInt(txtIdAluno.getText());
            Date data = Date.valueOf(txtData.getText());
            boolean presenca = checkPresenca.isSelected();

            service.registrarFrequencia(idAluno, data, presenca);
            JOptionPane.showMessageDialog(this, "Frequência registrada!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    private void listarFrequencias() {
        areaLista.setText("");
        service.getFrequencias().forEach(f -> areaLista.append(f + "\n"));
    }
}
