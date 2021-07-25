package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import controller.SemesterController;
import dto.Activity;
import dto.Discipline;
import gui.content.ContentGUI;

/** Implementa as a��es de um bot�o de uma disciplina. */
public class DisciplineButtonListener implements ActionListener {

	// Atributos
	private ContentGUI content;
	private SemesterController semester;
	private Discipline discipline;
	
	// Construtor do gatilho
	public DisciplineButtonListener(ContentGUI content, SemesterController semester, Discipline discipline) {
		this.content = content;
		this.semester = semester;
		this.discipline = discipline;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Iterator<Activity> iterator = semester.getActivitiesIterator(
			(Activity a) -> a.getDisciplineId().compareTo(discipline.getId()) == 0
		);
		content.displayDiscipline(discipline, iterator);
	}

}
