package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import gui.content.CentralPanelGUI;
import gui.content.UserNameChangerGUI;

/** Gatilho do botão de modificar nome de usuário. */
public class UserNameChangerListener implements ActionListener {

	// Atributos
	private CentralPanelGUI centralPanel;
	private UserNameChangerGUI userNameChangerGUI;
	private JLabel userNameLabel;
	
	// Construtor do gatilho
	public UserNameChangerListener(CentralPanelGUI centralPanel, UserNameChangerGUI userNameChangerGUI, JLabel userNameLabel) {
		this.centralPanel = centralPanel;
		this.userNameChangerGUI = userNameChangerGUI;
		this.userNameLabel = userNameLabel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		userNameChangerGUI.setText(userNameLabel.getText());
		centralPanel.showUserNameChanger();
	}

}
