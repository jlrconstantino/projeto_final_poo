package gui.content;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SemesterController;
import dto.Activity;

/** Mostrador do painel da disciplina corrente. */
public class ContentGUI extends JPanel {

	// Atributos
	private CardLayout bottomLayout;
	private JPanel bottomPanel;
	private ActivitiesGUI activities;
	private TimetableGUI timetable;
	private GradesGUI grades;
	private boolean homeView;
	
	// Constantes de identificação
	private static final long serialVersionUID = 6L;
	public static final String HOME_DISPLAY = "home";
	public static final String DISCIPLINE_DISPLAY = "discipline";
	
	// Construtor do painel
	public ContentGUI() {
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Painel superior
		JPanel topPanel = new JPanel(new CardLayout());
		topPanel.setBorder(new EmptyBorder(75, 0, 0, 0));
		topPanel.setPreferredSize(new Dimension(760, 370));
		topPanel.setMaximumSize(new Dimension(760, 370));
		activities = new ActivitiesGUI();
		topPanel.add(activities);
		this.add(topPanel);
		
		// Painel inferior
		bottomLayout = new CardLayout();
		bottomPanel = new JPanel(bottomLayout);
		bottomPanel.setBorder(new EmptyBorder(25, 0, 0, 0));
		bottomPanel.setPreferredSize(new Dimension(760, 370));
		bottomPanel.setMaximumSize(new Dimension(760, 370));
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
		if(homeView == false)
			activities.clean();
		bottomLayout.show(bottomPanel, HOME_DISPLAY);
		homeView = true;
	}
	
	
	// Muda a visualização para o tipo "disciplina"
	public void displayDiscipline() {
		if(homeView == true)
			activities.clean();
		bottomLayout.show(bottomPanel, DISCIPLINE_DISPLAY);
		homeView = false;
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
