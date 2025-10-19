package service;
import java.sql.Date;
import java.util.List;
import dao.*;
import model.*;

public class AcademiaService {
    private AlunoDAO alunoDAO = new AlunoDAO();
    private InstrutorDAO instrutorDAO = new InstrutorDAO();
    private PlanoTreinoDAO planoDAO = new PlanoTreinoDAO();
    private FrequenciaDAO freqDAO = new FrequenciaDAO();

    // ALUNO
    public void cadastrarAluno(String nome, String cpf, Date data) {
        alunoDAO.inserir(new Aluno(nome, cpf, data));
    }
    public List<Aluno> getAlunos() { return alunoDAO.listar(); }

    // INSTRUTOR
    public void cadastrarInstrutor(String nome, String esp) {
        instrutorDAO.inserir(new Instrutor(nome, esp));
    }
    public List<Instrutor> getInstrutores() { return instrutorDAO.listar(); }

    // PLANO
    public void cadastrarPlano(int idAluno, int idInstrutor, String desc, int semanas) {
        planoDAO.inserir(new PlanoTreino(idAluno, idInstrutor, desc, semanas));
    }
    public List<PlanoTreino> getPlanos() { return planoDAO.listar(); }

    // FREQUÊNCIA
    public void registrarFrequencia(int idAluno, Date data, boolean presenca) {
        freqDAO.inserir(new Frequencia(idAluno, data, presenca));
    }
    public List<Frequencia> getFrequencias() { return freqDAO.listar(); }
}
