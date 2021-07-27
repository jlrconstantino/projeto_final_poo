package gui.content;

import java.awt.CardLayout;

import javax.swing.JPanel;

/** GUI da interface central. */
public class CentralPanelGUI extends JPanel {
	
	// ID do painel
	private static final long serialVersionUID = 9L;
	
	// Atributos para alternar visualização dos paineis centrais
	private JPanel centralPanel;
	private CardLayout centralPanelLayout;
	
	// Constantes para visualização dos paineis
	private static final String SHOW_CONTENT = "content";
	private static final String SHOW_DISCIPLINE_ADDER = "discipline_adder";

	// Construtor 
	public CentralPanelGUI() {
		
		// Painel central
		centralPanelLayout = new CardLayout();
		centralPanel = new JPanel(centralPanelLayout);
		this.add(centralPanel);
	}
	
	// Adiciona conteúdo
	public void addContent(ContentGUI content) {
		centralPanel.add(content, SHOW_CONTENT);
	}
	
	// Adiciona o gerenciador de adição de disciplinas
	public void addDisciplineAdder(DisciplineAdderGUI disciplineAdder) {
		centralPanel.add(disciplineAdder, SHOW_DISCIPLINE_ADDER);
	}
	
	// Implementa a visualização do conteúdo do semestre
	public void showContent() {
		centralPanelLayout.show(centralPanel, SHOW_CONTENT);
	}
	
	// Implementa a visualização do adicionador de disciplinas
	public void showDisciplineAdder() {
		centralPanelLayout.show(centralPanel, SHOW_DISCIPLINE_ADDER);
	}
}
