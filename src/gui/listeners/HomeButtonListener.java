package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.content.ContentGUI;

/** Realiza a ação do botão de início */
public class HomeButtonListener implements ActionListener {

	// Referência para o GUI de conteúdo
	private ContentGUI contentReference;
	
	// Construtor do gatilho
	public HomeButtonListener(ContentGUI contentReference) {
		this.contentReference = contentReference;
	}
	
	// Muda a visualização para o tipo "home"
	@Override
	public void actionPerformed(ActionEvent e) {
		contentReference.displayHome();
	}
}
