package model;
import java.sql.Date;

public class Pagamento {
	private int id;
	private int idAluno;
	private double valor;
	private Date dataPagamento;
	private String status;
	
	public Pagamento(int id, int idAluno, double valor, Date dataPagamento, String status) {
		super();
		this.id = id;
		this.idAluno = idAluno;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
    public String toString() {
        return id + " - Aluno: " + idAluno + " | Valor: R$" + valor + " | " + status;
    }
}
