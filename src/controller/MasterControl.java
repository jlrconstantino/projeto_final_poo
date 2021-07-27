package controller;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import dto.Activity;
import dto.DayTimeInterval;
import dto.Discipline;
import utils.ActivityType;
import utils.DisciplineCSVParser;
import gui.content.CentralPanelGUI;
import gui.content.ContentGUI;
import gui.content.DisciplineAdderGUI;
import gui.content.LeftMenuGUI;
import gui.content.MainGUI;
import gui.content.TopMenuGUI;
import mean.ArithmeticMeanCalculator;

/** Controla a interface principal da aplicação. */
public class MasterControl {
	
	// Interfaces gráficas usadas para adicionar os semestres artificiais
	private static TopMenuGUI topMenu;
	private static LeftMenuGUI leftMenu;
	private static ContentGUI content;
	
	// Contém todas as disciplinas que possam ser adicionadas à grade
	private static HashMap<String, Discipline> availableDisciplines;
	
	// Cria dois semestres artificialmente para testes de interface
	private static void createTestSemesters() {
		
		// Variáveis locais
		SemesterController s1, s2;
		Discipline discipline;
		Activity activity;
		List<DayTimeInterval> offerings;
		
		// Inicializaçãoo dos semestres
		s1 = new SemesterController();
		s2 = new SemesterController();
		
		// Semestre 1: disciplina 1
		discipline = availableDisciplines.get("7500039");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.MONDAY, "08:10 - 09:50"));
		offerings.add(new DayTimeInterval(DayOfWeek.FRIDAY, "10:10 - 11:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 1: disciplina 2
		discipline = availableDisciplines.get("SMA0801");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.MONDAY, "10:10 - 11:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 1: disciplina 3
		discipline = availableDisciplines.get("SCC0604");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.MONDAY, "14:10 - 16:00"));
		offerings.add(new DayTimeInterval(DayOfWeek.FRIDAY, "08:10 - 09:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 1: disciplina 4
		discipline = availableDisciplines.get("SEL0354");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.TUESDAY, "08:10 - 09:50"));
		offerings.add(new DayTimeInterval(DayOfWeek.THURSDAY, "10:10 - 11:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 1: disciplina 5
		discipline = availableDisciplines.get("SMM0318");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.WEDNESDAY, "14:10 - 16:00"));
		offerings.add(new DayTimeInterval(DayOfWeek.SATURDAY, "08:10 - 09:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 1: disciplina 6
		discipline = availableDisciplines.get("FCI0760");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.WEDNESDAY, "08:10 - 09:50"));
		offerings.add(new DayTimeInterval(DayOfWeek.THURSDAY, "08:10 - 09:50"));
		discipline.setOfferings(offerings);
		s1.addDiscipline(discipline);
		
		// Semestre 2: disciplina 1
		discipline = availableDisciplines.get("SMA0375");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.TUESDAY, "08:10 - 09:50"));
		offerings.add(new DayTimeInterval(DayOfWeek.THURSDAY, "14:20 - 16:00"));
		discipline.setOfferings(offerings);
		s2.addDiscipline(discipline);
		
		// Semestre 2: disciplina 2
		discipline = availableDisciplines.get("FCM0117");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.MONDAY, "08:10 - 09:50"));
		offerings.add(new DayTimeInterval(DayOfWeek.FRIDAY, "16:20 - 18:00"));
		discipline.setOfferings(offerings);
		s2.addDiscipline(discipline);
		
		// Semestre 2: disciplina 3
		discipline = availableDisciplines.get("SSC0642");
		discipline.setMeanCalculator(new ArithmeticMeanCalculator());
		offerings = new ArrayList<DayTimeInterval>();
		offerings.add(new DayTimeInterval(DayOfWeek.WEDNESDAY, "16:20 - 18:00"));
		offerings.add(new DayTimeInterval(DayOfWeek.SATURDAY, "10:10 - 11:50"));
		discipline.setOfferings(offerings);
		s2.addDiscipline(discipline);
		
		// Semestre 1: atividades
		activity = new Activity("Prova A", LocalDate.parse("2021-07-21"), "FCI0760", ActivityType.ASSESSMENT, "Pendente");
		s1.addActivity(activity);
		activity = new Activity("Prova B", LocalDate.parse("2021-11-29"), "SEL0354", ActivityType.ASSESSMENT, "Pendente");
		s1.addActivity(activity);
		activity = new Activity("Prova C", LocalDate.parse("2021-04-02"), "7500039", ActivityType.ASSESSMENT, "Finalizada");
		s1.addActivity(activity);
		activity = new Activity("Trabalho X", LocalDate.parse("2021-09-16"), "SCC0604", ActivityType.WORK, "Em progresso");
		s1.addActivity(activity);
		activity = new Activity("Trabalho Y", LocalDate.parse("2021-11-08"), "7500039", ActivityType.WORK, "Finalizado");
		s1.addActivity(activity);
		activity = new Activity("Exercício 1", LocalDate.parse("2021-12-06"), "7500039", ActivityType.OTHER, "Em progresso");
		s1.addActivity(activity);
		activity = new Activity("Exercício 2", LocalDate.parse("2021-09-24"), "SEL0354", ActivityType.OTHER, "Finalizado");
		s1.addActivity(activity);
		activity = new Activity("Outro", LocalDate.parse("2021-02-18"), "SMA0801", ActivityType.OTHER, "Pendente");
		s1.addActivity(activity);
		
		// Semestre 2: atividades
		activity = new Activity("Prova S", LocalDate.parse("2021-10-23"), "SMA0375", ActivityType.ASSESSMENT, "Pendente");
		s2.addActivity(activity);
		activity = new Activity("Prova T", LocalDate.parse("2021-09-30"), "SSC0642", ActivityType.ASSESSMENT, "Finalizada");
		s2.addActivity(activity);
		activity = new Activity("Trabalho Z", LocalDate.parse("2021-10-14"), "FCM0117", ActivityType.WORK, "Em progresso");
		s2.addActivity(activity);
		
		// Adição dos semestres à interface
		topMenu.addSemester(s1, leftMenu, content);
		topMenu.addSemester(s2, leftMenu, content);
	}
	
	
	/** Inicializa a aplicação. 
	 * @throws IOException */
	public static void main(String[] args) throws IOException {
		
		// Aquisição das disciplinas adicionáveis
		availableDisciplines = DisciplineCSVParser.parse("data/disciplinas_usp_sao_carlos.csv");
		
		// Força a utilização do Locale brasileiro
		Locale.setDefault(new Locale("pt", "BR"));
		
		// Painel central
		CentralPanelGUI centralPanel = new CentralPanelGUI();
		
		// Menu superior
		topMenu = new TopMenuGUI("Usuário de Testes");
		
		// Conteúdo
		content = new ContentGUI();
		
		// Menu lateral
		leftMenu = new LeftMenuGUI(centralPanel, content);
		
		// Adição do conteúdo do painel central
		centralPanel.addContent(content);
		centralPanel.addDisciplineAdder(new DisciplineAdderGUI(leftMenu, centralPanel));
		centralPanel.showContent();
		
		// Quadro da aplicação
		MainGUI mainGUI = new MainGUI(topMenu, leftMenu, centralPanel);
		
		// Adição dos dados de teste
		createTestSemesters();
		
		// Inicialização da visualização
		mainGUI.setVisible(true);
	}
}
