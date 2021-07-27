package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SemesterController;
import gui.content.TopMenuGUI;

/** Gatilho do botão de adicionar semestre. */
public class SemesterCreatorListener implements ActionListener {
	
	// Referências externas
	private TopMenuGUI topMenu;

	// Construtor do gatilho
	public SemesterCreatorListener(TopMenuGUI topMenu){
		this.topMenu = topMenu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		topMenu.addSemester(new SemesterController());
	}

}
