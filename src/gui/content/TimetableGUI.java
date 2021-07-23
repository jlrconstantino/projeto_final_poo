package gui.content;

/** Interface de grade horária */
public class TimetableGUI extends ContentBlockGUI {

	// Constantes
	private static final long serialVersionUID = 6L;
	private static final String[] labels = {
		"Horário", "Segunda-feira", "Terça-feira", 
		"Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"
	};
	
	// Construtor do painel
	public TimetableGUI() {
		super("Grade Horária", labels, 7);
	}
}
