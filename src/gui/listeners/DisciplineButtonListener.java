package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.Discipline;
import gui.content.ContentGUI;

/** Implementa as ações de um botão de uma disciplina. */
public class DisciplineButtonListener implements ActionListener {

	// Atributos
	private ContentGUI contentReference;
	private Discipline discipline;
	
	// Construtor do gatilho
	public DisciplineButtonListener(ContentGUI contentReference, Discipline discipline) {
		this.contentReference = contentReference;
		this.discipline = discipline;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		contentReference.displayDiscipline();
	}

}
