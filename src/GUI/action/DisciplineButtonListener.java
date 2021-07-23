package GUI.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.content.ContentGUI;

/** Implementa as a��es de um bot�o de uma disciplina. */
public class DisciplineButtonListener implements ActionListener {

	// Refer�ncia para a GUI de conte�do
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
