package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Estacionamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5029851334405242771L;
	private String ID;
	private Vaga[] vagas = new Vaga[100];
	private Caixa caixa;
	private ArrayList<Cliente> clientesAtivos = new ArrayList<>();
	
	public String getID() {
		
		return ID;
		
	}
	
	public void setID(String iD) {
		
		ID = iD;
		
	}
	
	public Vaga[] getVagas() {
		
		return vagas;
		
	}
	public void setVagas(Vaga[] vagas) {
		
		this.vagas = vagas;
		
	}
	
	public Caixa getCaixa() {
		
		return caixa;
		
	}
	
	public void setCaixa(Caixa caixa) {
		
		this.caixa = caixa;
		
	}
	
	public ArrayList<Cliente> getClientesAtivos() {
		
		return clientesAtivos;
		
	}
	
	public void setClientesAtivos(ArrayList<Cliente> clientesAtivos) {
		
		this.clientesAtivos = clientesAtivos;
		
	}

	@Override
	public String toString() {
		return "Estacionamento [ID=" + ID + ", vagas=" + Arrays.toString(vagas) + ", caixa=" + caixa
				+ ", clientesAtivos=" + clientesAtivos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (caixa == null) {
			if (other.caixa != null)
				return false;
		} else if (!caixa.equals(other.caixa))
			return false;
		if (clientesAtivos == null) {
			if (other.clientesAtivos != null)
				return false;
		} else if (!clientesAtivos.equals(other.clientesAtivos))
			return false;
		if (!Arrays.equals(vagas, other.vagas))
			return false;
		return true;
	}
	
}
