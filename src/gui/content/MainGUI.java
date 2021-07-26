package gui.content;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.listeners.AddDisciplineButtonListener;

/** Quadro principal da aplicação. */
public class MainGUI extends JFrame {

	// ID do quadro
	private static final long serialVersionUID = 1L;
	
	// Atributos para alternar visualização dos paineis centrais
	private JPanel centralPanel;
	private CardLayout centralPanelLayout;
	
	// Constantes para visualização dos paineis
	private static final String SHOW_CONTENT = "content";
	private static final String SHOW_DISCIPLINE_ADDER = "discipline_adder";

	private LeftMenuGUI leftMenu;
	private DisciplineAdderGUI disciplineAdder;
	
	// Construtor do quadro
	public MainGUI (
		TopMenuGUI topMenu, 
		LeftMenuGUI leftMenu, 
		ContentGUI content,
		DisciplineAdderGUI disciplineAdder
	) throws IOException {

		this.leftMenu = leftMenu;
		this.disciplineAdder = disciplineAdder;

		// Tamanho e localização
		this.setSize(1024, 640);
		this.setLocation(60, 60);
		
		// Operações de fechamento e de redimensionamento
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// Menu superior
		this.add(topMenu);

		
		// Quadro inferior
		JPanel bottomPanel = new JPanel(new BorderLayout());

		// Rotulo do botao de dicionar disciplina
		JLabel addDisciplineLabel = new JLabel("+ Adicionar disciplina", JLabel.LEFT);		
		// Botão de adicionar disciplina
		JButton addDisciplineButton = new JButton();
		addDisciplineButton.setLayout(new BorderLayout());
		addDisciplineButton.setBackground(new Color(160, 160, 160));
		addDisciplineButton.setSize(new Dimension(180, 35));
		addDisciplineButton.addActionListener(
			new AddDisciplineButtonListener(this, leftMenu)
		);
		addDisciplineButton.add(addDisciplineLabel, BorderLayout.CENTER);
		// Painel do adicionar disciplina
		JPanel addDisciplinePanel = new JPanel(new BorderLayout());
		addDisciplinePanel.setMaximumSize(new Dimension(180, 35));
		addDisciplinePanel.add(addDisciplineButton, BorderLayout.CENTER);

		bottomPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		leftMenu.add(addDisciplinePanel);

		bottomPanel.add(leftMenu, BorderLayout.LINE_START);

		
		// Painel central
		centralPanelLayout = new CardLayout();
		centralPanel = new JPanel(centralPanelLayout);
		centralPanel.setBorder(new EmptyBorder(75, 0, 0, 0));
		centralPanel.add(content, SHOW_CONTENT);
		centralPanel.add(disciplineAdder, SHOW_DISCIPLINE_ADDER);
		bottomPanel.add(centralPanel, BorderLayout.CENTER);
		this.add(bottomPanel);
		
		// Por padrão, inicia com visualização do conteúdo
		showContent();
	}
	
	// Implementa a visualização do conteúdo do semestre
	public void showContent() {
		centralPanelLayout.show(centralPanel, SHOW_CONTENT);
	}
	
	// Implementa a visualização do adicionador de disciplinas
	public void showDisciplineAdder() {
		disciplineAdder.setSemester(this);
		centralPanelLayout.show(centralPanel, SHOW_DISCIPLINE_ADDER);
	}

}
