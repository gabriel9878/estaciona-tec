import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import beans.Estacionamento;
import beans.Usuario;
import beans.Vaga;
import beans.Veiculo;
import dados.RepositorioEstacionamento;
import negocio.ControladorEstacionamento;
import negocio.ControladorUsuario;



public class ControladorPrincipal {
	
	private static ControladorPrincipal instance;
	private static Usuario usuarioAtiv;
	private ControladorUsuario controladorUsuario;
	private ControladorEstacionamento controladorEstacionamento;
	
	//CONSTRUCTOR
	public ControladorPrincipal() {
		
		controladorEstacionamento = new ControladorEstacionamento(RepositorioEstacionamento.getInstance());
		
	}
	
	//FUN�AO NO PADR�O SINGLETON
	public static ControladorPrincipal getInstance() {
		if(instance == null) {
			instance = new ControladorPrincipal();
		}
		
		return instance;
	}
	
	
	public static Usuario getUsuarioInstancia() {
		return usuarioAtiv;
	}
	
	
	public void login(String email, String senha) {
		if(instance != null && usuarioAtiv == null) {
			usuarioAtiv = this.controladorUsuario.login(email, senha);
		}
	}
	
	public void logout() {
		if(instance != null && usuarioAtiv != null) {
			usuarioAtiv = null;
		}
	}
	
	
	public void cadastrarUsuario(Usuario usuario){
		
		this.controladorUsuario.cadastrar(usuario);
		
	}
	
	public void atualizarUsuario(Usuario usuario) {
		this.controladorUsuario.atualizar(usuario);
	}
	
	public boolean existeUsuario(String email) {
		return this.controladorUsuario.verificarUsuarioExiste(email);
	}
	
	public void removerConta(Usuario usuario) {
		this.controladorUsuario.remover(usuario);
	}
	
}	