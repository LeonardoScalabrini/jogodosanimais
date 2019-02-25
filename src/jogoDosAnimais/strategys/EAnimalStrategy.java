package jogoDosAnimais.strategys;

public class EAnimalStrategy implements PerguntaStrategy{
	
	private final String animal;
	
	public EAnimalStrategy(String animal) {
		this.animal = animal;
	}
	
	@Override
	public String getPergunta() {
		return "O animal que você pensou é " + animal + "?";
	}

}
