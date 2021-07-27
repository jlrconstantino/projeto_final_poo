package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MasterControl;
import gui.content.ActivityAdderGUI;
import gui.content.CentralPanelGUI;

/** Gatilho do botão de adicionar atividade. */
public class AddActivityListener implements ActionListener {

	// Referência para os GUIs necessários
	private CentralPanelGUI centralPanel;
	private ActivityAdderGUI activityAdder;
	
	// Construtor do gatilho
	public AddActivityListener(CentralPanelGUI centralPanel, ActivityAdderGUI activityAdder) {
		this.centralPanel = centralPanel;
		this.activityAdder = activityAdder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showActivityAdder();
		activityAdder.rebuild();
	}

}
