package dados;

import java.util.List;

import beans.Estacionamento;

public interface IRepositorioEstacionamento {

	void adicionar(Estacionamento novoObj);
	List<Estacionamento> listar();
	void atualizar(Estacionamento newObj);
	void remover(Estacionamento obj);
	

}
