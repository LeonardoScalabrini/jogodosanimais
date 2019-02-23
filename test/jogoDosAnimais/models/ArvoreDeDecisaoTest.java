package jogoDosAnimais.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jogoDosAnimais.factorys.NoAnimalFactory;

public class ArvoreDeDecisaoTest {
	
	private NoAnimalFactory animalNoFactory = new NoAnimalFactory();
	private ArvoreDeDecisao<NoAnimal> arvoreDeDecisao;
	
	@Before
	public void Before() {
		String oqueFaz = "vive na Água";
		String animal = "Tubarão";
		this.arvoreDeDecisao = new ArvoreDeDecisao<NoAnimal>(animalNoFactory.create(oqueFaz, animal));
	}
	
	@Test()
	public void deveAdicionarTubaraoAoCriar() throws Exception{
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
	}
	
	@Test(expected=Exception.class)
	public void deveCadastrarNovoNo() throws Exception {
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
	}
	
	@Test(expected=Exception.class)
	public void acertouAnimal() throws Exception {
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
	}
	
	@Test
	public void deveAdicionarNovoNoSemNoAnterior() throws Exception {
		String oqueFaz = "É um felino";
		String animal = "Leão";
		arvoreDeDecisao.add(animalNoFactory.create(oqueFaz, animal));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um felino?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Leão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Leão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Leão");
		arvoreDeDecisao.inicio();
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
	}
	
	@Test
	public void deveAdicionarNovoNoComUmNo() throws Exception {
		String oqueFaz = "É um mamifero";
		String animal = "Baleia";
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			arvoreDeDecisao.add(animalNoFactory.create(oqueFaz, animal));
		}
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um mamifero?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Baleia?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um mamifero?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
	}
	
	@Test
	public void deveAdicionarNovoNoComVariosNos() throws Exception {
		String oqueFaz = "Corre";
		String animal = "Macaco";
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			arvoreDeDecisao.add(animalNoFactory.create(oqueFaz, animal));
		}
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Corre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Macaco?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			arvoreDeDecisao.add(animalNoFactory.create("é um felino", "Tigre"));
		}
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é um felino?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tigre");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tigre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tigre");
	}

}
