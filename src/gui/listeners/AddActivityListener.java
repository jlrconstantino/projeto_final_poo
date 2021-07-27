package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.content.CentralPanelGUI;

/** Gatilho do botão de adicionar atividade. */
public class AddActivityListener implements ActionListener {

	// Referência para o painel central
	private CentralPanelGUI centralPanel;
	
	// Construtor do gatilho
	public AddActivityListener(CentralPanelGUI centralPanel) {
		this.centralPanel = centralPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showActivityAdder();
	}

}
