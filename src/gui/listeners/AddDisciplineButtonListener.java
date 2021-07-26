package gui.listeners;

import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import gui.content.ContentGUI;
import gui.content.LeftMenuGUI;
import gui.content.MainGUI;
import dto.Discipline;

/** Realiza a a��o do bot�o de in�cio */
public class AddDisciplineButtonListener implements ActionListener {

	// Refer�ncia para o GUI de conte�do
    private MainGUI centerPanelReference;
    private LeftMenuGUI leftMenuReference;
    private HashMap<String, Discipline> disciplines;
	
	// Construtor do gatilho
	public AddDisciplineButtonListener(MainGUI centerPanelReference, LeftMenuGUI leftMenuReference) {
		this.leftMenuReference = leftMenuReference;
        this.centerPanelReference = centerPanelReference;
	}
	
	// Muda a visualiza��o para o tipo "home"
	@Override
	public void actionPerformed(ActionEvent e) {
        if(leftMenuReference.getCurrentSemester() == null)
            JOptionPane.showMessageDialog(null, "Selecione um semestre para adicionar a materia primeiramente");
		else
        {
            //String disciplineQuery =(String) JOptionPane.showInputDialog(null, "Digite o código ou nome da disciplina.");

            this.centerPanelReference.showDisciplineAdder();
            // boolean DisciplineExists = disciplines.get(disciplineQuery) == null ? false: true;

            // if(!DisciplineExists)
            // {
            //     JOptionPane.showMessageDialog(centerPanelReference, "Disciplina não encontrada");
            //     return;
            // }


            // Discipline newDiscipline = disciplines.get(disciplineQuery);
            // this.leftMenuReference.getCurrentSemester().addDiscipline(newDiscipline);
            
            // this.leftMenuReference.displaySemester(this.leftMenuReference.getCurrentSemester());
        }
	}
}