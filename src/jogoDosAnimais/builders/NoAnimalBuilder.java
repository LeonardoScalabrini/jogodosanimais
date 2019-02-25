package jogoDosAnimais.builders;

import jogoDosAnimais.models.NoAnimal;
import jogoDosAnimais.strategys.EAnimalStrategy;
import jogoDosAnimais.strategys.OqueFazAnimalStrategy;

public class NoAnimalBuilder {
	
	private String oqueFaz = new String();
	private String animal = new String();
	
	public NoAnimalBuilder animal(String animal) {
		this.animal = animal;
		return this;
	}
	
	public NoAnimalBuilder oqueFaz(String oqueFaz) {
		this.oqueFaz = oqueFaz;
		return this;
	}
	
	public NoAnimal create() {
		NoAnimal noAnimal = new NoAnimal(new OqueFazAnimalStrategy(oqueFaz), animal);
		noAnimal.setSim(new NoAnimal(new EAnimalStrategy(animal), animal));
		return noAnimal;
	}
	
}
