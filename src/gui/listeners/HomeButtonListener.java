package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.content.ContentGUI;

/** Realiza a a��o do bot�o de in�cio */
public class HomeButtonListener implements ActionListener {

	// Refer�ncia para o GUI de conte�do
	private ContentGUI contentReference;
	
	// Construtor do gatilho
	public HomeButtonListener(ContentGUI contentReference) {
		this.contentReference = contentReference;
	}
	
	// Muda a visualiza��o para o tipo "home"
	@Override
	public void actionPerformed(ActionEvent e) {
		contentReference.displayHome();
	}
}
