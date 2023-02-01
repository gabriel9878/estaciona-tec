package negocio;


import java.io.Serializable;

import beans.Estacionamento;
import beans.Vaga;
import beans.Veiculo;
import dados.IRepositorioEstacionamento;



public class ControladorEstacionamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public IRepositorioEstacionamento gerenciadorEstacionamento;
	
	
	public ControladorEstacionamento(IRepositorioEstacionamento instanciaEstacionamento) {
		this.gerenciadorEstacionamento = instanciaEstacionamento;
	}
	
   
	public void estacionarVeiculo(Veiculo veiculo,Vaga v,Estacionamento e) {
		
		if(gerenciadorEstacionamento.listar().contains(e)) {
			
			for(int i = 0;i < 100;i++) {
				
				if(e.getVagas()[i].isDisponibilidade()) {
					
					e.getVagas()[i] = v;
					e.getVagas()[i].setVeiculoEstacionado(veiculo);
					e.getVagas()[i].setID(i);
					e.getVagas()[i].setDisponibilidade(false);
					break;

					
				} 
				
			}
				
		}
						
	}
	
	//Equivalente a "desestacionar"
	public void removerVeiculoVaga(Veiculo veiculo,Vaga vaga,Estacionamento e) {
		
		if(gerenciadorEstacionamento.listar().contains(e)) {
			
			for(int i = 0; i < 100;i++) {
				
				if(e.getVagas()[i].getID() == vaga.getID() && e.getVagas()[i].getVeiculoEstacionado().equals(veiculo)) {
					
					this.realizarCobranca(e,vaga);
					e.getVagas()[i].setVeiculoEstacionado(null);
					e.getVagas()[i].setID(-1);
					
				} 
				
			}
				
		}
						
	}
	
	public void realizarCobranca(Estacionamento e, Vaga v) {
		
		if(gerenciadorEstacionamento.listar().contains(e) && !v.equals(null)) {
			
			e.getCaixa().setSaldo(this.calcularDebito(v) + e.getCaixa().getSaldo());
				
		}
		
		
		
	}
	
	public double calcularDebito(Vaga v) {
		
		double debito = 0;
		
		if(v.getTempoUtilizado() <= 1) {
			
			debito = 10;
			
		}
		
		else if(v.getTempoUtilizado() <= 3) {
			
			debito = 15;
			
		}
		
		else {
		
			debito = 15 + 1.2 * (v.getTempoUtilizado() - 3);
			
		}
		
		
		return debito;
		
		
		
	}
	
	/*
	public static void main(String[] args) {
		
		

		
	}*/
				
}