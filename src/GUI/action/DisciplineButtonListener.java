package GUI.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.content.ContentGUI;

/** Implementa as ações de um botão de uma disciplina. */
public class DisciplineButtonListener implements ActionListener {

	// Referência para a GUI de conteúdo
	private ContentGUI contentReference;
	
	// Construtor do gatilho
	public DisciplineButtonListener(ContentGUI contentReference) {
		this.contentReference = contentReference;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		contentReference.displayDiscipline();
	}

}
