package org.jogoDosAnimais;

import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import org.jogoDosAnimais.factorys.NoAnimalFactory;
import org.jogoDosAnimais.models.ArvoreDeDecisao;
import org.jogoDosAnimais.models.NoAnimal;

public class Main {

	private static NoAnimalFactory animalNoFactory = new NoAnimalFactory();
	private static ArvoreDeDecisao<NoAnimal> arvoreDeDecisao = new ArvoreDeDecisao<NoAnimal>(
			animalNoFactory.create("vive na Água", "Tubarão"));

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Pense em um Animal!");
		while (true) {

			Integer result = confirmaAnimal();
			
			if (CLOSED_OPTION == result || CANCEL_OPTION == result) {
				break;
			}
			
			if (YES_OPTION == result) {

				try {
					arvoreDeDecisao.sim();
					continue;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Acertei!");

					if (!reiniciarJogo())
						break;

					continue;
				}

			}

			if (NO_OPTION == result) {

				try {
					arvoreDeDecisao.nao();
					continue;
				} catch (Exception e) {
					
					String animal = qualAnimalVocePensou();

					if (animal == null)
						break;

					String pergunta = oqueFazAnimal(animal);

					if (pergunta == null)
						break;

					NoAnimal novoAnimal = animalNoFactory.create(pergunta, animal);
					arvoreDeDecisao.add(novoAnimal);

					if (!reiniciarJogo())
						break;

					continue;
				}
			}

		}
	}

	private static boolean reiniciarJogo() {
		if (!continuarJogando())
			return false;

		arvoreDeDecisao.inicio();
		showMessageDialog(null, "Pense em um Animal!");

		return true;
	}
	
	private static boolean continuarJogando() {
		return YES_OPTION == showConfirmDialog(null, "Quer continuar Jogando?", "Jogo dos Animais", YES_NO_OPTION);
	}
	
	private static Integer confirmaAnimal() {
		Integer result = showConfirmDialog(null, arvoreDeDecisao.getAtual().getPergunta(), "Jogo dos Animais", YES_NO_OPTION);
		
		if ((CLOSED_OPTION == result || CANCEL_OPTION == result) && continuarJogando())
			result = confirmaAnimal();
		
		return result;
	}
	
	private static String qualAnimalVocePensou() {
		String animal = showInputDialog("Qual Animal você pensou?");

		if (animal == null && continuarJogando())
			animal = qualAnimalVocePensou();
		
		return animal;
	}
	
	private static String oqueFazAnimal(String animal) {
		String oqueFaz = showInputDialog("Um(a) " + animal + "____" + "mas um(a) " + arvoreDeDecisao.getAtual().getAnimal() + " não?");

		if (oqueFaz == null && continuarJogando())
			oqueFaz = oqueFazAnimal(animal);
		
		return oqueFaz;
	}
}
