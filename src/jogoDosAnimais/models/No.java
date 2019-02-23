package jogoDosAnimais.models;

public class No <T>{
	
	private T sim;
	private T nao;
	private final String pergunta;
	
	public No(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	
	public void setSim(T sim) {
		this.sim = sim;
	}

	public void setNao(T nao) {
		this.nao = nao;
	}
	
	public T getSim() {
		return sim;
	}

	public T getNao() {
		return nao;
	}
}
