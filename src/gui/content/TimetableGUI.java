package gui.content;

/** Interface de grade hor�ria */
public class TimetableGUI extends ContentBlockGUI {

	// Constantes
	private static final long serialVersionUID = 6L;
	private static final String[] labels = {
		"Hor�rio", "Segunda-feira", "Ter�a-feira", 
		"Quarta-feira", "Quinta-feira", "Sexta-feira", "S�bado"
	};
	
	// Construtor do painel
	public TimetableGUI() {
		super("Grade Hor�ria", labels, 7);
	}
}
