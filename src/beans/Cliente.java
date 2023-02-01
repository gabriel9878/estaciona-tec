package beans;

public class Cliente extends Usuario{
	
	private String CPF;
	private String nome;
	private double debito;
	
	public String getCPF() {
		
		return this.CPF;
		
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	
	public double getDebito() {
		return debito;
	}
	
	public void setDebito(double debito) {
		this.debito = debito;
	}

	@Override
	public String toString() {
		return "Cliente [CPF=" + CPF + ", nome=" + nome + ", debito=" + debito + "]";
	}
	
	
	
}
