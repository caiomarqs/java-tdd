package aula1.servico;

import aula1.Lance;
import aula1.Leilao;

public class Avaliador {
	
	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;

	
	public void avalia(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorLance ) maiorLance = lance.getValor();
			if(lance.getValor() < menorLance) menorLance  = lance.getValor();
		}
	}
	
	public double avaliaMedia(Leilao leilao) {
		Double total = 0.0; 
		for(Lance lance : leilao.getLances()) {
			total += lance.getValor();
		}
		return total / leilao.getLances().size();
	}
	
	
	public double getMaiorLance() {
		return maiorLance;
	}
	
	public double getMenorLance() {
		return menorLance;
	}
}
