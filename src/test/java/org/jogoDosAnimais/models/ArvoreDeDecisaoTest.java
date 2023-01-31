package org.jogoDosAnimais.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.jogoDosAnimais.factorys.NoAnimalFactory;

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
	public void deveAdicionarNovoAnimalNaoViveNaAgua() throws Exception {
		String oqueFaz = "É um felino";
		String animal = "Leão";
		arvoreDeDecisao.add(animalNoFactory.create(oqueFaz, animal));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um felino?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Leão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Leão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Leão");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
	}
	
	@Test
	public void deveAdicionarNovoAnimalNaoÉTubarao() throws Exception {
		String oqueFaz = "É um mamifero";
		String animal = "Baleia";
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			arvoreDeDecisao.add(animalNoFactory.create(oqueFaz, animal));
		}
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um mamifero?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Baleia?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um mamifero?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
	}
	
	@Test
	public void deveAdicionarBaleiaMacacoETigre() throws Exception {
		String corre = "Corre";
		String macaco = "Macaco";
		String eMamifero = "É um mamifero";
		String baleia = "Baleia";
		String eFelino = "é felino";
		String tigre = "Tigre";
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			arvoreDeDecisao.add(animalNoFactory.create(corre, macaco));
		}
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Corre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Macaco?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tubarão?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			
		}
		arvoreDeDecisao.add(animalNoFactory.create(eMamifero, baleia));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou É um mamifero?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Baleia?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Baleia");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Corre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Macaco?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			
		}
		arvoreDeDecisao.add(animalNoFactory.create(eFelino, tigre));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Corre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é felino?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tigre");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Tigre?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tigre");
		arvoreDeDecisao.inicio();
		arvoreDeDecisao.nao();
		arvoreDeDecisao.sim();
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Macaco?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Macaco");
	}
	
	@Test
	public void deveAdicionarGriloEPorco() throws Exception {
		String pula = "Pula";
		String grilo = "Grilo";
		String oinc = "Faz oinc";
		String porco = "Porco";
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			
		}
		arvoreDeDecisao.add(animalNoFactory.create(pula, grilo));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Pula?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Grilo");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Grilo?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Grilo");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Pula?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Grilo");
		try {
			arvoreDeDecisao.nao();
		} catch (Exception e) {
			
		}
		arvoreDeDecisao.add(animalNoFactory.create(oinc, porco));
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Faz oinc?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Porco");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Porco?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Porco");
		arvoreDeDecisao.inicio();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou vive na Água?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Tubarão");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Faz oinc?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Porco");
		arvoreDeDecisao.nao();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou Pula?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Grilo");
		arvoreDeDecisao.sim();
		assertEquals(arvoreDeDecisao.getAtual().getPergunta(), "O animal que você pensou é Grilo?");
		assertEquals(arvoreDeDecisao.getAtual().getAnimal(), "Grilo");
	}
}
