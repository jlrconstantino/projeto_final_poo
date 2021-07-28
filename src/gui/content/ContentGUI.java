package gui.content;

import java.awt.CardLayout;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SemesterController;
import dto.Activity;
import dto.Discipline;

/** Mostrador do painel da disciplina corrente. */
public class ContentGUI extends JPanel {

	// Atributos
	private CardLayout bottomLayout;
	private JPanel bottomPanel;
	private ActivitiesGUI activities;
	private TimetableGUI timetable;
	private GradesGUI grades;
	private boolean homeView;
	private Discipline lastDiscipline;
	
	// Constantes de identificação
	private static final long serialVersionUID = 6L;
	public static final String HOME_DISPLAY = "home";
	public static final String DISCIPLINE_DISPLAY = "discipline";
	
	// Construtor do painel
	public ContentGUI(CentralPanelGUI centralPanel, ActivityAdderGUI activityAdder) {
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Painel superior
		JPanel topPanel = new JPanel();
		activities = new ActivitiesGUI(centralPanel, activityAdder);
		topPanel.add(activities);
		this.add(topPanel);
		
		// Painel inferior
		bottomLayout = new CardLayout();
		bottomPanel = new JPanel(bottomLayout);
		bottomPanel.setBorder(new EmptyBorder(15, 0, 0, 0));
		timetable = new TimetableGUI();
		grades = new GradesGUI();
		bottomPanel.add(timetable, HOME_DISPLAY);
		bottomPanel.add(grades, DISCIPLINE_DISPLAY);
		this.add(bottomPanel);
		
		// Por padrão, inicia com visualização de "home"
		homeView = true;
		displayHome();
	}
	
	
	// Muda a visualização para o tipo "home"
	public void displayHome() {
		activities.displayCurrentSemester();
		bottomLayout.show(bottomPanel, HOME_DISPLAY);
		homeView = true;
	}
	
	
	/** Muda a visualização para o tipo "disciplina".
	 * @param discipline = referência para a disciplina de interesse;
	 * @param iterator = iterador para as atividades associadas a essa atividade. */
	public void displayDiscipline(Discipline discipline, Iterator<Activity> iterator) {
		if(lastDiscipline != discipline || homeView == true) {
			lastDiscipline = discipline;
			grades.displayDiscipline(discipline, iterator);
			activities.displayDiscipline(discipline);
			if(homeView == true) {
				bottomLayout.show(bottomPanel, DISCIPLINE_DISPLAY);
				homeView = false;
			}
		}
	}
	
	
	// Adição de nova atividade
	public void addActivity(Activity a) {
		activities.addActivity(a);
	}
	
	
	// Habilita a visualização do semestre informado
	public void displaySemester(SemesterController sc) {
		activities.displaySemester(sc);
		timetable.displaySemester(sc);
	}
}
