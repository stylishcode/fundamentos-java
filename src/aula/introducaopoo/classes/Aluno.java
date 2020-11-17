package aula.introducaopoo.classes;

import java.util.ArrayList;
import java.util.List;

import aula.herancapolimorfinterfaces.classesAbstratas.Pessoa;
import aula.introducaopoo.constantes.StatusAluno;

/*Esta é nossa classe/objeto que representa o aluno*/
public class Aluno extends Pessoa {

	private String matricula;
	private String nomeEscola;
	private String dataMatricula;
	private String serieMatriculado;

	private List<Disciplina> disciplina = new ArrayList<Disciplina>();

	/* Cria os dados na memória, sendo o construtor padrão do Java */
	public Aluno() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public double getMediaNota() {
		double soma = 0.0;
		for (Disciplina disciplina : disciplina) {
			/*
			 * soma com a média das notas (4 notas) de cada disciplina que o método
			 * getMediaNotas retorna
			 */
			soma += disciplina.getMediaNotas();
		}
		/*
		 * Retorna a média (soma de todas as disciplinas (4 notas cada) / total de
		 * disciplinas)
		 */
		return soma / disciplina.size();
	}

	public boolean getAlunoAprovado() {
		return getMediaNota() >= 70 ? true : false;
	}

	public String getAlunoAprovadoString() {
		if (getMediaNota() >= 50) {
			if (getMediaNota() >= 70) {
				return StatusAluno.APROVADO;
			}
			return StatusAluno.RECUPERACAO;
		}
		return StatusAluno.REPROVADO;
	}

	/* Método abstrato de Pessoa */
	@Override
	public double salario() {
		return 1500.00;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", rg=" + rg
				+ ", cpf=" + cpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + ", matricula=" + matricula
				+ ", nomeEscola=" + nomeEscola + ", dataMatricula=" + dataMatricula + ", serieMatriculado="
				+ serieMatriculado + ", disciplina=" + disciplina + "]";
	}

}
