package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.Activity;
import gui.content.ActivityAdderGUI;
import gui.content.CentralPanelGUI;

/** Gatilho do modificador de disciplina. */
public class ModifyActivityListener implements ActionListener {

	// Referência para os GUIs necessários
	private CentralPanelGUI centralPanel;
	private ActivityAdderGUI activityAdder;
	
	// Atividade a ser modificada
	private Activity activity;
	
	// Construtor do gatilho
	public ModifyActivityListener(CentralPanelGUI centralPanel, ActivityAdderGUI activityAdder, Activity activity) {
		this.centralPanel = centralPanel;
		this.activityAdder = activityAdder;
		this.activity = activity;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		centralPanel.showActivityAdder();
		activityAdder.rebuild(activity);
	}
}
