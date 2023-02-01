package beans;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Usuario implements Serializable{

	private String login;
	private String senha;
	private ArrayList<Veiculo> veiculosPossuidos = new ArrayList<>();	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
