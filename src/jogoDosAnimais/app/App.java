package jogoDosAnimais.app;

import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import javax.swing.JOptionPane;

import jogoDosAnimais.factorys.NoAnimalFactory;
import jogoDosAnimais.models.ArvoreDeDecisao;
import jogoDosAnimais.models.NoAnimal;

public class App {

	private static NoAnimalFactory animalNoFactory = new NoAnimalFactory();
	private static ArvoreDeDecisao<NoAnimal> arvoreDeDecisao = new ArvoreDeDecisao<NoAnimal>(
			animalNoFactory.create("vive na Água", "Tubarão"));

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Pense em um Animal!");
		while (true) {

			NoAnimal item = arvoreDeDecisao.getAtual();

			Integer result = JOptionPane.showConfirmDialog(null, item.getPergunta(), "Jogo dos Animais", YES_NO_OPTION);

			if (YES_OPTION == result) {

				try {
					arvoreDeDecisao.sim();
					continue;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Acertei!");

					if (!continuarJogando())
						break;

					continue;
				}

			}

			if (NO_OPTION == result) {

				try {
					arvoreDeDecisao.nao();
					continue;
				} catch (Exception e) {

					String animal = JOptionPane.showInputDialog("Qual Animal você pensou?");

					if (animal == null && !continuarJogando())
						break;

					String pergunta = JOptionPane.showInputDialog("Um(a) " + animal + "____" + "mas um(a) "
							+ arvoreDeDecisao.getAtual().getAnimal() + " não?");

					if (pergunta == null && !continuarJogando())
						break;

					NoAnimal novoAnimal = animalNoFactory.create(pergunta, animal);
					arvoreDeDecisao.add(novoAnimal);

					if (!continuarJogando())
						break;

					continue;
				}
			}

			if (CLOSED_OPTION == result || CANCEL_OPTION == result) {

				if (!continuarJogando())
					break;
			}

		}
	}

	private static boolean continuarJogando() {
		Integer result = JOptionPane.showConfirmDialog(null, "Quer continuar Jogando?", "Jogo dos Animais",
				JOptionPane.YES_NO_OPTION);

		if (YES_OPTION != result)
			return false;

		arvoreDeDecisao.inicio();
		JOptionPane.showMessageDialog(null, "Pense em um Animal!");

		return true;
	}
}
