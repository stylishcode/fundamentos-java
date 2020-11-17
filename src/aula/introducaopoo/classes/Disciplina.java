package aula.introducaopoo.classes;

import java.util.Arrays;

/*Essa classe servirá para todas as instâncias de notas e matérias*/
public class Disciplina {

	private String codigoDisciplina;
	private String disciplina;
	/* Cada disciplina terá 4 notas durante o ano inteiro */
	private double[] notas = new double[4];

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public double getMediaNotas() {
		double media = 0.0;
		for (int pos = 0; pos < notas.length; pos++) {
			media += notas[pos];
		}
		return media / notas.length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDisciplina == null) ? 0 : codigoDisciplina.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigoDisciplina == null) {
			if (other.codigoDisciplina != null)
				return false;
		} else if (!codigoDisciplina.equals(other.codigoDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [disciplina=" + disciplina + ", notas=" + Arrays.toString(notas) + "]";
	}

}
