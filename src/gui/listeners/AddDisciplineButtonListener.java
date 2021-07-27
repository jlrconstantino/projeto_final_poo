package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.content.CentralPanelGUI;
import gui.content.LeftMenuGUI;

/** Realiza a ação do botão de adicionar disciplina. */
public class AddDisciplineButtonListener implements ActionListener {

	// Referências para os paineis
    private CentralPanelGUI centralPanel;
    private LeftMenuGUI leftMenu;
	
	// Construtor do gatilho
	public AddDisciplineButtonListener(CentralPanelGUI centralPanel, LeftMenuGUI leftMenu) {
        this.centralPanel = centralPanel;
        this.leftMenu = leftMenu;
	}
	
	// Muda a visualização para o painel de adicionar disciplina
	@Override
	public void actionPerformed(ActionEvent e) {
        if(leftMenu.getCurrentSemester() == null)
            JOptionPane.showMessageDialog(null, "Selecione um semestre para adicionar a materia primeiramente");
		else
        {
            this.centerPanelReference.showDisciplineAdder();
        }
	}
}