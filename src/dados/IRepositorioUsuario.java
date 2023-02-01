package dados;

import java.util.List;

import beans.Usuario;

public interface IRepositorioUsuario {

	void adicionar(Usuario novoObj);
	public List<Usuario> listar();
	void remover(Usuario obj);
	void atualizar(Usuario newObj);
	boolean verificarUsuarioExiste(String email);
	Usuario verificarUsuario(String login);
	
}
