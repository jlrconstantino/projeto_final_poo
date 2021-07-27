package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.content.CentralPanelGUI;
import gui.content.ContentGUI;

/** Realiza a ação do botão de início */
public class HomeButtonListener implements ActionListener {

	// Referências para as GUIS
	private ContentGUI content;
	private CentralPanelGUI centralPanel;
	
	// Construtor do gatilho
	public HomeButtonListener(CentralPanelGUI centralPanel, ContentGUI content) {
		this.centralPanel = centralPanel;
		this.content = content;
	}
	
	// Muda a visualização para o tipo "home"
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showContent();
		content.displayHome();
	}
}
