package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Usuario;

public class RepositorioUsuario implements Serializable,IRepositorioUsuario{

	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private static RepositorioUsuario instance = new RepositorioUsuario();
	private String filename;
	
	
	public boolean verificarUsuarioExiste(String login) {
		
		for(Usuario u: this.usuarios) {
			if(u.getLogin().equals(login)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Usuario verificarUsuario(String login) {
		
		for(Usuario u : this.usuarios) {
			if(u.getLogin().equals(login)) {
				return u;
			}
		}
		
		return null;
	}


	public void adicionar(Usuario novoObj) {

		if (!this.usuarios.contains(novoObj)) {
			this.usuarios.add(novoObj);

			RepositorioArquivo.salvarArquivo(usuarios, this.filename);

		}

	}

	public List<Usuario> listar() {
		
		return Collections.unmodifiableList(this.usuarios);
		
	}

	public void remover(Usuario obj) {

		if (this.usuarios.contains(obj)) {
			
			this.usuarios.remove(this.usuarios.indexOf(obj));
			
		}

		RepositorioArquivo.salvarArquivo(usuarios, this.filename);

	}

	public void atualizar(Usuario newObj) {

		if (this.usuarios.contains(newObj)) {

			int indice = this.usuarios.indexOf(newObj);
			this.usuarios.set(indice, newObj);

		}

		RepositorioArquivo.salvarArquivo(usuarios, this.filename);
		
	}

	public List<Usuario> getElementos() {

		return usuarios;

	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {

		this.usuarios = usuarios;

	}

	public String getFilename() {

		return filename;

	}

	public void setFilename(String filename) {

		this.filename = filename;

	}

	
}


