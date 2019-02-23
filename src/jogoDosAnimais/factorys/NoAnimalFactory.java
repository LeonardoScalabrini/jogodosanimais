package jogoDosAnimais.factorys;

import jogoDosAnimais.models.NoAnimal;

public class NoAnimalFactory {

	public NoAnimal create(String oquefaz, String animal) {
		
		String perguntaOqueFaz = "O animal que você pensou " + oquefaz +"?";
		String perguntaAnimal = "O animal que você pensou é " + animal + "?";
		
		NoAnimal novaPergunta = new NoAnimal(perguntaOqueFaz, animal);
		NoAnimal confirmacao = new NoAnimal(perguntaAnimal, animal);
		
		novaPergunta.setSim(confirmacao);
		
		return novaPergunta;
	}
	
}
