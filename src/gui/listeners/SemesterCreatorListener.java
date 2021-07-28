package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SemesterController;
import gui.content.CentralPanelGUI;
import gui.content.ContentGUI;
import gui.content.TopMenuGUI;

/** Gatilho do botão de adicionar semestre. */
public class SemesterCreatorListener implements ActionListener {
	
	// Referências externas
	private TopMenuGUI topMenu;
	private ContentGUI content;
	private CentralPanelGUI centralPanel;

	// Construtor do gatilho
	public SemesterCreatorListener(ContentGUI content, TopMenuGUI topMenu, CentralPanelGUI centralPanel){
		this.topMenu = topMenu;
		this.content = content;
		this.centralPanel = centralPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showContent();
		content.displayHome();
		topMenu.addSemester(new SemesterController());
	}

}
