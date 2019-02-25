package jogoDosAnimais.models;

import jogoDosAnimais.strategys.PerguntaStrategy;

public class No <T>{
	
	private T sim;
	private T nao;
	private final PerguntaStrategy perguntaStrategy;
	
	public No(PerguntaStrategy perguntaStrategy) {
		this.perguntaStrategy = perguntaStrategy;
	}
	
	public String getPergunta() {
		return perguntaStrategy.getPergunta();
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
