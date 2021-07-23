package gui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gui.listeners.DisciplineButtonListener;
import gui.listeners.HomeButtonListener;
import utils.ImageResizer;

/** Menu lateral */
public class LeftMenuGUI extends JPanel {

	// Atributos
	private static final long serialVersionUID = 4L;
	private ContentGUI contentReference;
	private JPanel disciplineDisplay;
	private GridBagConstraints gbc;
	
	// Construtor do painel
	public LeftMenuGUI(ContentGUI contentReference) {
		
		// Registra a referência (utilizada para os gatilhos de botão)
		this.contentReference = contentReference;
		
		// Mostrador em forma de lista vertical
		this.setBorder(new EmptyBorder(70, 20, 0, 0));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Rótulo da lista
		JLabel mainLabel = new JLabel("Disciplinas");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font(mainLabel.getFont().getName(), Font.BOLD, 14));
		
		// Painel do rótulo da lista
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		mainPanel.setPreferredSize(new Dimension(180, 30));
		mainPanel.setMaximumSize(new Dimension(180, 30));
		mainPanel.add(mainLabel);
		this.add(mainPanel);
		
		// Rótulo do botão de início
		URL homeIconURL = getClass().getResource("../images/home.jpg");
		ImageIcon homeIcon = ImageResizer.getAndResize(homeIconURL, "Home", 20, 20); 
		JLabel homeLabel = new JLabel("Home", homeIcon, JLabel.CENTER);
		
		// Botão de início
		JButton homeButton = new JButton();
		homeButton.setLayout(new BorderLayout());
		homeButton.setBackground(new Color(160, 160, 160));
		homeButton.setPreferredSize(new Dimension(180, 35));
		homeButton.addActionListener(
			new HomeButtonListener(contentReference)
		);
		homeButton.add(homeLabel, BorderLayout.CENTER);
		
		// Painel de início
		JPanel homePanel = new JPanel(new BorderLayout());
		homePanel.setMaximumSize(new Dimension(180, 35));
		homePanel.add(homeButton, BorderLayout.CENTER);
		this.add(homePanel);
		
		// Mostrador de disciplinas
		disciplineDisplay = new JPanel(new GridBagLayout());
		disciplineDisplay.setBackground(Color.LIGHT_GRAY);
		gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weighty = 450;
		gbc.insets = new Insets(2, 0, 0, 0);
		
		// Lista de rolagem das disciplinas
		JScrollPane scroller = new JScrollPane(disciplineDisplay);
		scroller.setMaximumSize(new Dimension(180, 450));
		this.add(scroller);
	}
	
	
	// Adiciona uma nova disciplina
	public void addDiscipline(String name) {
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(170, 35));
		button.setBackground(new Color(200, 200, 200));
		button.setForeground(new Color(70, 70, 70));
		button.addActionListener(
			new DisciplineButtonListener(contentReference)
		);
		disciplineDisplay.add(button, gbc);
	}
	
	
	// Remove todas as disciplinas do painel
	public void cleanDisciplines() {
		disciplineDisplay.removeAll();
		disciplineDisplay.repaint();
	}
}
