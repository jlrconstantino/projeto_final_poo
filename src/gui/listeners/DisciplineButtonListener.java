package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import controller.SemesterController;
import dto.Activity;
import dto.Discipline;
import gui.content.CentralPanelGUI;
import gui.content.ContentGUI;

/** Implementa as ações de um botão de uma disciplina. */
public class DisciplineButtonListener implements ActionListener {

	// Atributos
	private CentralPanelGUI centralPanel;
	private ContentGUI content;
	private SemesterController semester;
	private Discipline discipline;
	
	// Construtor do gatilho
	public DisciplineButtonListener(CentralPanelGUI centralPanel, ContentGUI content, SemesterController semester, Discipline discipline) {
		this.centralPanel = centralPanel;
		this.content = content;
		this.semester = semester;
		this.discipline = discipline;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showContent();
		Iterator<Activity> iterator = semester.getActivitiesIterator(
			(Activity a) -> a.getDisciplineId().compareTo(discipline.getId()) == 0
		);
		content.displayDiscipline(discipline, iterator);
	}

}
