package beans;

public class Vaga {

	int ID;
	private boolean disponibilidade = true;
	private Veiculo veiculoEstacionado;
	private Usuario utilizador;
	private double tempoUtilizado;
	
	public int getID() {
		
		return ID;
	}

	public void setID(int iD) {
		
		ID = iD;
	
	}

	
	public boolean isDisponibilidade() {
		
		return disponibilidade;
		
	}
	
	public void setDisponibilidade(boolean disponibilidade) {
		
		this.disponibilidade = disponibilidade;
		
	}
	
	public Veiculo getVeiculoEstacionado() {
		
		return veiculoEstacionado;
		
	}
	
	public void setVeiculoEstacionado(Veiculo veiculoEstacionado) {
		
		this.veiculoEstacionado = veiculoEstacionado;
		
	}
	
	public Usuario getUtilizador() {
		
		return utilizador;
		
	}
	
	public void setUtilizador(Usuario utilizador) {
		
		this.utilizador = utilizador;
		
	}
	
	public double getTempoUtilizado() {
		
		return tempoUtilizado;
		
	}

	public void setTempoUtilizado(double tempoUtilizado) {
		
		this.tempoUtilizado = tempoUtilizado;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (disponibilidade != other.disponibilidade)
			return false;
		if (utilizador == null) {
			if (other.utilizador != null)
				return false;
		} else if (!utilizador.equals(other.utilizador))
			return false;
		if (veiculoEstacionado == null) {
			if (other.veiculoEstacionado != null)
				return false;
		} else if (!veiculoEstacionado.equals(other.veiculoEstacionado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vaga [ID=" + ID + ", disponibilidade=" + disponibilidade + ", veiculoEstacionado=" + veiculoEstacionado
				+ ", utilizador=" + utilizador + ", tempoUtilizado=" + tempoUtilizado + "]";
	} 
	
	
	
}
