package org.jogoDosAnimais.factorys;

import org.jogoDosAnimais.builders.NoAnimalBuilder;
import org.jogoDosAnimais.models.NoAnimal;

public class NoAnimalFactory {

	public NoAnimal create(String oqueFaz, String animal) {
		
		return new NoAnimalBuilder().animal(animal).oqueFaz(oqueFaz).create();
	}
	
}
