package org.jogoDosAnimais.strategys;

public class OqueFazAnimalStrategy implements PerguntaStrategy{
	
	private final String faz;
	
	public OqueFazAnimalStrategy(String faz) {
		this.faz = faz;
	}
	
	@Override
	public String getPergunta() {
		return "O animal que você pensou " + faz +"?";
	}

}
