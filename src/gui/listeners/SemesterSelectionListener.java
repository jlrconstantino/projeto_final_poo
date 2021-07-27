package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import controller.SemesterController;
import gui.content.CentralPanelGUI;
import gui.content.ContentGUI;
import gui.content.LeftMenuGUI;

public class SemesterSelectionListener implements ActionListener {

	// Semestre mantido pelo botão
	private SemesterController semesterController;
	
	// Nome do semestre
	private String label;
	
	// Referências externas
	private LeftMenuGUI leftMenu;
	private ContentGUI content;
	private CentralPanelGUI centralPanel;
	private JMenu semesterMenu;
	
	// Construtor do gatilho
	public SemesterSelectionListener (
		SemesterController semesterController, 
		LeftMenuGUI leftMenu, 
		ContentGUI content, 
		CentralPanelGUI centralPanel, 
		JMenu semesterMenu, 
		String label
	){
		this.semesterController = semesterController;
		this.leftMenu = leftMenu;
		this.content = content;
		this.centralPanel = centralPanel;
		this.semesterMenu = semesterMenu;
		this.label = label;
	}
	
	// Ativa a visualização do semestre
	@Override
	public void actionPerformed(ActionEvent e) {
		semesterMenu.setText(label);
		centralPanel.showContent();
		leftMenu.displaySemester(semesterController);
		content.displaySemester(semesterController);
	}
}
