package gui.content;

import java.awt.Color;
import java.util.Iterator;

import controller.SemesterController;
import dto.TimetableRow;

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
	
	@Override
	public void displaySemester(SemesterController sc) {
		
		// Valida��o e atualiza��o do semestre atual
		if(super.isCurrentSemester(sc) == false) {
			super.setCurrentSemester(sc);
			
			// Limpeza de painel
			super.clean();
			
			// Itera��o ao longo dos elementos
			Iterator<TimetableRow> iterator = sc.getTimetableIterator();
			while(iterator.hasNext()) {
				TimetableRow row = iterator.next();
				String values[] = row.getValues();
				
				// C�lula de rotula��o (hor�rio)
				super.addCell(row.getLabel(), new Color(200, 200, 200), new Color(20, 20, 20));
				
				// Cria c�lulas para as siglas das disciplinas
				for(int i = 0; i < values.length; ++i) {
					if(values[i] != null)
						super.addCell(values[i]);
					else
						super.addCell("");
				}
			}
		}
	}
}
