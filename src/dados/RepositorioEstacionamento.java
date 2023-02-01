package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Estacionamento;


public class RepositorioEstacionamento implements Serializable, IRepositorioEstacionamento{

	private static final long serialVersionUID = 1L;
	private ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
	private static RepositorioEstacionamento instance;
	private String filename;

	
	public static RepositorioEstacionamento getInstance() {
		
		if(instance == null) {
			
			instance = new RepositorioEstacionamento();
			
		}
		
		return instance;
	}


	public void adicionar(Estacionamento novoObj) {

		if (!this.estacionamentos.contains(novoObj)) {
			this.estacionamentos.add(novoObj);

			RepositorioArquivo.salvarArquivo(estacionamentos, this.filename);

		}

	}



	public List<Estacionamento> listar() {
		return Collections.unmodifiableList(this.estacionamentos);
	}

	public void remover(Estacionamento obj) {

		if (this.estacionamentos.contains(obj)) {
			this.estacionamentos.remove(this.estacionamentos.indexOf(obj));
		}

		RepositorioArquivo.salvarArquivo(estacionamentos, this.filename);

	}

	public void atualizar(Estacionamento newObj) {

		if (this.estacionamentos.contains(newObj)) {

			int indice = this.estacionamentos.indexOf(newObj);
			this.estacionamentos.set(indice, newObj);

		}

		RepositorioArquivo.salvarArquivo(estacionamentos, this.filename);
	}

	public List<Estacionamento> getElementos() {

		return estacionamentos;

	}

	public void setUsuarios(ArrayList<Estacionamento> usuarios) {

		this.estacionamentos = usuarios;

	}

	public String getFilename() {

		return filename;

	}

	public void setFilename(String filename) {

		this.filename = filename;

	}
	
}


