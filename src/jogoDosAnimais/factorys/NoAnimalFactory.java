package jogoDosAnimais.factorys;

import jogoDosAnimais.builders.NoAnimalBuilder;
import jogoDosAnimais.models.NoAnimal;

public class NoAnimalFactory {

	public NoAnimal create(String oqueFaz, String animal) {
		
		return new NoAnimalBuilder().animal(animal).oqueFaz(oqueFaz).create();
	}
	
}
