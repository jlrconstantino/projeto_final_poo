package gui.content;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** Quadro principal da aplica��o. */
public class MainGUI extends JFrame {

	// ID do quadro
	private static final long serialVersionUID = 1L;
	
	// Atributos para alternar visualiza��o dos paineis centrais
	private JPanel centralPanel;
	private CardLayout centralPanelLayout;
	
	// Constantes para visualiza��o dos paineis
	private static final String SHOW_CONTENT = "content";
	private static final String SHOW_DISCIPLINE_ADDER = "discipline_adder";
	
	// Construtor do quadro
	public MainGUI (
		TopMenuGUI topMenu, 
		LeftMenuGUI leftMenu, 
		ContentGUI content
	) throws IOException {

		// Tamanho e localiza��o
		this.setSize(1024, 640);
		this.setLocation(60, 60);
		
		// Opera��es de fechamento e de redimensionamento
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// Menu superior
		this.add(topMenu);
		
		// Quadro inferior
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		bottomPanel.add(leftMenu, BorderLayout.LINE_START);
		
		// Painel central
		centralPanelLayout = new CardLayout();
		centralPanel = new JPanel(centralPanelLayout);
		centralPanel.add(content, SHOW_CONTENT);
		centralPanel.add(new DisciplineAdderGUI(), SHOW_DISCIPLINE_ADDER);
		bottomPanel.add(centralPanel, BorderLayout.CENTER);
		this.add(bottomPanel);
		
		// Por padr�o, inicia com visualiza��o do conte�do
		showContent();
	}
	
	// Implementa a visualiza��o do conte�do do semestre
	public void showContent() {
		centralPanelLayout.show(centralPanel, SHOW_CONTENT);
	}
	
	// Implementa a visualiza��o do adicionador de disciplinas
	public void showDisciplineAdder() {
		centralPanelLayout.show(centralPanel, SHOW_DISCIPLINE_ADDER);
	}
}
