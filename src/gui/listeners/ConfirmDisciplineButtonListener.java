package gui.listeners;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;

import gui.content.CentralPanelGUI;
import gui.content.DisciplineAdderGUI;
import gui.content.LeftMenuGUI;
import mean.ArithmeticMeanCalculator;
import mean.HarmonicMeanCalculator;
import mean.MeanCalculator;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controller.SemesterController;
import dto.DayTimeInterval;
import dto.Discipline;

public class ConfirmDisciplineButtonListener implements ActionListener{

	private LeftMenuGUI leftMenu;
    private DisciplineAdderGUI disciplineGUI;
    private CentralPanelGUI centralPanel;

    public ConfirmDisciplineButtonListener(LeftMenuGUI leftMenu, CentralPanelGUI centralPanel, DisciplineAdderGUI disciplineADDGUI)
    {
    	this.leftMenu = leftMenu;
        this.centralPanel = centralPanel;
        this.disciplineGUI = disciplineADDGUI;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
    	
        if(this.disciplineGUI.getDisciplineName() == null || this.disciplineGUI.getDisciplineCode() == ""){
            JOptionPane.showMessageDialog(null, "Selecione um semestre para adicionar a materia primeiramente");
        }
        else
        {
            Discipline newDiscipline = new Discipline(disciplineGUI.getDisciplineName(), disciplineGUI.getDisciplineCode());
            newDiscipline.setMeanCalculator(getMeanCalculatorByName(this.disciplineGUI.getSelectedMeanType()));
            for(int i = 0; i < this.disciplineGUI.getDaysVector().size(); i++)
            {
            	ArrayList<DayTimeInterval> offerings = new ArrayList<DayTimeInterval>();
            	String newDay = this.disciplineGUI.getDaysVector().get(i).getSelectedItem().toString();
            	
            	String interval = this.disciplineGUI.getHoursVector().get(i*2).getText();
            	interval += " : " + this.disciplineGUI.getMinutesVector().get(i*2).getText() + " - ";
            	interval += this.disciplineGUI.getHoursVector().get((i*2) + 1).getText();
            	interval += " : " + this.disciplineGUI.getMinutesVector().get((i*2) + 1).getText();
            	
            	
            	offerings.add(new DayTimeInterval(getDayByName(newDay), interval));
            	newDiscipline.setOfferings(offerings);
            }
            SemesterController currentSemester = leftMenu.getCurrentSemester();
            currentSemester.addDiscipline(newDiscipline);
            
    
            leftMenu.addDiscipline(currentSemester, newDiscipline);
            
        }
            this.disciplineGUI.clearInputs();
            this.centralPanel.showContent();     
    }

	private MeanCalculator getMeanCalculatorByName(String selectedMeanType) {
		switch (selectedMeanType) {
		case "Média Aritmética":
			return new ArithmeticMeanCalculator();
		
		case "Média Harmônica":
			return new HarmonicMeanCalculator();
			

		default:
			return new ArithmeticMeanCalculator();
		}
	}

	private DayOfWeek getDayByName(String newDay) {
		
		switch (newDay) {
		case "segunda-feira":
			return DayOfWeek.MONDAY;			
			
			
		case "terça-feira":
			return DayOfWeek.TUESDAY;			
			
		case "quarta-feira":
			return DayOfWeek.WEDNESDAY;			
		
		case "quinta-feira":
			return DayOfWeek.THURSDAY;			
		
		case "sexta-feira":
			return DayOfWeek.FRIDAY;			
		
		case "sabado":
			return DayOfWeek.SATURDAY;			
		
		case "domingo":
			return DayOfWeek.SUNDAY;

		default:
			return DayOfWeek.MONDAY;
		}
	}
    
}
