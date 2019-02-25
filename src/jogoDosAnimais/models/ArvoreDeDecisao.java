package jogoDosAnimais.models;

public class ArvoreDeDecisao <T extends No<T>>{

	private T primeiro;
	private T atual;
	private T anterior;
	
	public ArvoreDeDecisao(T no) {
		this.primeiro = no;
		atual = this.primeiro;
	}
	
	public void inicio(){
		atual = primeiro;
		anterior = null;
	}
	
	public void sim() throws Exception{
		T no = atual.getSim();
		
		if(no == null)
			throw new Exception();
		
		anterior = atual;
		atual = no;		
	}
	
	public void nao() throws Exception{
		T no = atual.getNao();
		
		if(no == null)
			throw new Exception();
		
		anterior = atual;
		atual = no;
	}
	
	public T getAtual() {
		return atual;
	}
	
	public void add(T no) {
		
		if (anterior == null) {
			primeiro.setNao(no);
			return;
		}
		
		no.setNao(atual);
		
		if(anterior.getSim().equals(atual)) {
			anterior.setSim(no);
			return;
		}
		
		anterior.setNao(no);
	}
}
