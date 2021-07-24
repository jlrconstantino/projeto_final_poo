package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.SemesterController;
import dto.Discipline;
import gui.listeners.DisciplineButtonListener;
import gui.listeners.HomeButtonListener;
import utils.ImageResizer;

/** Menu lateral */
public class LeftMenuGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 4L;
	private SemesterController currentSemester;
	private ContentGUI contentReference;
	private JPanel disciplineDisplay;
	
	// Construtor do painel
	public LeftMenuGUI(ContentGUI contentReference) {
		
		// Registra a refer�ncia (utilizada para os gatilhos de bot�o)
		this.contentReference = contentReference;
		
		// Mostrador em forma de lista vertical
		this.setBorder(new EmptyBorder(70, 20, 0, 0));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// R�tulo da lista
		JLabel mainLabel = new JLabel("Disciplinas");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel do r�tulo da lista
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setPreferredSize(new Dimension(180, 30));
		mainPanel.setMaximumSize(new Dimension(180, 30));
		mainPanel.add(mainLabel);
		this.add(mainPanel);
		
		// R�tulo do bot�o de in�cio
		URL homeIconURL = getClass().getResource("../images/home.jpg");
		ImageIcon homeIcon = ImageResizer.getAndResize(homeIconURL, "Home", 20, 20); 
		JLabel homeLabel = new JLabel("Home", homeIcon, JLabel.CENTER);
		
		// Bot�o de in�cio
		JButton homeButton = new JButton();
		homeButton.setLayout(new BorderLayout());
		homeButton.setBackground(new Color(160, 160, 160));
		homeButton.setPreferredSize(new Dimension(180, 35));
		homeButton.addActionListener(
			new HomeButtonListener(contentReference)
		);
		homeButton.add(homeLabel, BorderLayout.CENTER);
		
		// Painel de in�cio
		JPanel homePanel = new JPanel(new BorderLayout());
		homePanel.setMaximumSize(new Dimension(180, 35));
		homePanel.add(homeButton, BorderLayout.CENTER);
		this.add(homePanel);
		
		// Mostrador de disciplinas
		disciplineDisplay = new JPanel();
		disciplineDisplay.setLayout(new BoxLayout(disciplineDisplay, BoxLayout.Y_AXIS));
		disciplineDisplay.setBackground(Color.LIGHT_GRAY);
		
		// Lista de rolagem das disciplinas
		JScrollPane scroller = new JScrollPane(disciplineDisplay);
		scroller.setMaximumSize(new Dimension(180, 450));
		this.add(scroller);
	}
	
	
	// Adiciona uma nova disciplina
	public void addDiscipline(Discipline discipline) {
		JButton button = new JButton(discipline.getId());
		button.setMaximumSize(new Dimension(178, 36));
		button.setBorder(BorderFactory.createCompoundBorder(
				new EmptyBorder(2, 2, 0, 2), 
				BorderFactory.createLineBorder(new Color(100, 100, 100))
		));
		button.setBackground(new Color(200, 200, 200));
		button.setForeground(new Color(70, 70, 70));
		button.addActionListener(
			new DisciplineButtonListener(
				contentReference, discipline
			)
		);
		disciplineDisplay.add(button);
	}
	
	
	// Remove todas as disciplinas do painel
	public void cleanDisciplines() {
		disciplineDisplay.removeAll();
		disciplineDisplay.repaint();
	}
	
	
	// Aciona a visualiza��o das disciplinas do semestre
	public void displaySemester(SemesterController sc) {
		if(currentSemester != sc) {
			currentSemester = sc;
			cleanDisciplines();
			Iterator<Discipline> iterator = sc.getDisciplineIterator();
			while(iterator.hasNext())
				addDiscipline(iterator.next());
		}
	}
}
