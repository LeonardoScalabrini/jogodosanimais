package org.jogoDosAnimais.models;

import org.jogoDosAnimais.strategys.PerguntaStrategy;

public class NoAnimal extends No<NoAnimal>{
	
	private final String animal;
	
	public NoAnimal(PerguntaStrategy perguntaStrategy, String animal) {
		super(perguntaStrategy);
		this.animal = animal;
	}
	
	public String getAnimal() {
		return animal;
	}

}
