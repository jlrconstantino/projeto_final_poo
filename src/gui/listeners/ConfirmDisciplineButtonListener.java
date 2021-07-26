package gui.listeners;
import java.awt.event.ActionListener;

import gui.content.DisciplineAdderGUI;
import gui.content.LeftMenuGUI;
import gui.content.MainGUI;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controller.SemesterController;
import dto.Discipline;

public class ConfirmDisciplineButtonListener implements ActionListener{

    private DisciplineAdderGUI disciplineGUI;

    private MainGUI mainGui;

    public ConfirmDisciplineButtonListener(DisciplineAdderGUI disciplineADDGUI, MainGUI mainGUI)
    {
        this.disciplineGUI = disciplineADDGUI;
        this.mainGui = mainGUI;
    }

    @Override
	public void actionPerformed(ActionEvent e) {

        if(this.disciplineGUI.getDisciplineName() == null || this.disciplineGUI.getDisciplineCode() == ""){
            JOptionPane.showMessageDialog(null, "Selecione um semestre para adicionar a materia primeiramente");
        }
        else
        {
            Discipline newDiscipline = new Discipline(disciplineGUI.getDisciplineName(), disciplineGUI.getDisciplineCode());
            
            LeftMenuGUI leftMenu = this.mainGui.getLeftMenu();
            SemesterController currentSemester = leftMenu.getCurrentSemester();
            currentSemester.addDiscipline(newDiscipline);
    
            leftMenu.addDiscipline(currentSemester, newDiscipline);
        }
            this.disciplineGUI.clearInputs();
            this.mainGui.showContent();        
    }
    
}
