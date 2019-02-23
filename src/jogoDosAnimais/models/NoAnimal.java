package jogoDosAnimais.models;

public class NoAnimal extends No<NoAnimal>{
	
	private final String animal;
	
	public NoAnimal(String pergunta, String animal) {
		super(pergunta);
		this.animal = animal;
	}
	
	public String getAnimal() {
		return animal;
	}

}
