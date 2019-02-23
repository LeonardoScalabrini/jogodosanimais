package jogoDosAnimais.models;

public class ArvoreDeDecisao <T extends No<T>>{

	private T primeiro;
	private T atual;
	
	public ArvoreDeDecisao(T no) {
		this.primeiro = no;
		atual = this.primeiro;
	}
	
	public void inicio(){
		atual = primeiro;
	}
	
	public void sim() throws Exception{
		T no = atual.getSim();
		
		if(no == null)
			throw new Exception();

		atual = no;		
	}
	
	public void nao() throws Exception{
		T no = atual.getNao();
		
		if(no == null)
			throw new Exception();

		atual = no;
	}
	
	public T getAtual() {
		return atual;
	}
	
	public void add(T no) {
		no.setNao(atual);
		primeiro = no;
	}
}
