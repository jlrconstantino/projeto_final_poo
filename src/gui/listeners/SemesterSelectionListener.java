package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import controller.SemesterController;
import gui.content.ContentGUI;
import gui.content.LeftMenuGUI;

public class SemesterSelectionListener implements ActionListener {

	// Atributos (referências externas)
	private SemesterController semesterController;
	private LeftMenuGUI leftMenuReference;
	private ContentGUI contentReference;
	private JMenu semesterMenu;
	private String label;
	
	// Construtor do gatilho
	public SemesterSelectionListener (
		SemesterController semesterController, 
		LeftMenuGUI leftMenuReference, 
		ContentGUI contentReference, 
		JMenu semesterMenu, 
		String label
	){
		this.semesterController = semesterController;
		this.leftMenuReference = leftMenuReference;
		this.contentReference = contentReference;
		this.semesterMenu = semesterMenu;
		this.label = label;
	}
	
	// Ativa a visualização do semestre
	@Override
	public void actionPerformed(ActionEvent e) {
		semesterMenu.setText(label);
		leftMenuReference.displaySemester(semesterController);
		contentReference.displaySemester(semesterController);
	}
}
