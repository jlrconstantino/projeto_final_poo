package controller;

import java.io.IOException;
import java.time.LocalDate;

import dto.Activity;
import utils.ActivityType;
import GUI.content.ContentGUI;
import GUI.content.LeftMenuGUI;
import GUI.content.MainGUI;
import GUI.content.TopMenuGUI;

/** Controla a interface principal da aplicação. */
public class MasterControl {
	
	/** Inicializa a aplicação. 
	 * @throws IOException */
	public static void main(String[] args) throws IOException {
		
		// Interfaces gráficas
		TopMenuGUI topMenu = new TopMenuGUI("Usuário de Testes");
		ContentGUI content = new ContentGUI();
		LeftMenuGUI leftMenu = new LeftMenuGUI(content);
		MainGUI mainGUI = new MainGUI(topMenu, leftMenu, content);
		
		// Inicialização da visualização
		mainGUI.setVisible(true);
		
		// Adição de semestres
		topMenu.addSemester();
		topMenu.addSemester();
		
		// Adição de disciplinas ao menu lateral
		leftMenu.addDiscipline("SMA01342");
		leftMenu.addDiscipline("SCC00029");
		leftMenu.addDiscipline("SSC10017");
		leftMenu.addDiscipline("SMA01342");
		leftMenu.addDiscipline("SCC00029");
		leftMenu.addDiscipline("SSC10017");
		leftMenu.addDiscipline("SMA01342");
		leftMenu.addDiscipline("SCC00029");
		leftMenu.addDiscipline("SSC10017");
		leftMenu.addDiscipline("SMA01342");
		leftMenu.addDiscipline("SCC00029");
		leftMenu.addDiscipline("SSC10017");
		
		// Adição de atividades
		content.addActivity(new Activity(
			"Prova Z", LocalDate.now(), "SMA01342", ActivityType.ASSESSMENT, "Pendente"
		));
		content.addActivity(new Activity(
			"Trabalho X", LocalDate.now(), "SCC10017", ActivityType.WORK, "Feito"
		));
		content.addActivity(new Activity(
			"Exercício Y", LocalDate.now(), "SCC00029", ActivityType.EXERCISE, "Pendente"
		));
		content.addActivity(new Activity(
			"Reunião", LocalDate.now(), "SMA01342", ActivityType.OTHER, "Feito"
		));
		content.addActivity(new Activity(
			"Prova Z", LocalDate.now(), "SMA01342", ActivityType.ASSESSMENT, "Pendente"
		));
		content.addActivity(new Activity(
			"Trabalho X", LocalDate.now(), "SCC10017", ActivityType.WORK, "Feito"
		));
	}
}
