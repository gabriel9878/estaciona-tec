package negocio;

import beans.Usuario;
import dados.IRepositorioUsuario;

public class ControladorUsuario {
	
	private IRepositorioUsuario gerenciadorUsuario;
	
	//Constructor
	public ControladorUsuario(IRepositorioUsuario instanciaUsuario) {
		
		this.gerenciadorUsuario = instanciaUsuario;
		
	}
	
	//METODOS
	public Usuario login(String login, String senha) {
		
		if(this.gerenciadorUsuario.verificarUsuarioExiste(login)) {
			Usuario usuario = this.gerenciadorUsuario.verificarUsuario(login);
			if(usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
		
	}
	
	
	public void cadastrar(Usuario usuario){
		
		if(usuario == null) {
			throw new IllegalArgumentException("parametro incorreto.");
			
		}else if(!this.gerenciadorUsuario.verificarUsuarioExiste(usuario.getLogin())) {
			this.gerenciadorUsuario.adicionar(usuario);
			
		}
		
	}
	
	/*Usado para excluir a conta do usuario.
	 *o usuario pode excluir a propria conta caso queria, Pensando ainda nisso.
	 *esse remover vai servir pra excluir a conta atual de qualquer jeito.
	*/
	public void remover(Usuario usuario) {
		if(this.gerenciadorUsuario.verificarUsuarioExiste(usuario.getLogin())) {
			this.gerenciadorUsuario.remover(usuario);
		}else {
			//Usuario n�o existe no banco de dados
			System.out.println("Usu�rio n�o encontrado.");
		}
		
	}
	
	public boolean verificarUsuarioExiste(String login) {
		return this.gerenciadorUsuario.verificarUsuarioExiste(login);
		
	}
	
	//atualiza as informa��es do usuario.
	//n�o fa�o verifica��o aqui pois o usuario logado n�o pode ser null.
	public void atualizar(Usuario usuario) {
		this.gerenciadorUsuario.atualizar(usuario);
		
	}




	
}
