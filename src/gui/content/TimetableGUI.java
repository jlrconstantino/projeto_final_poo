package gui.content;

import java.awt.Color;
import java.util.Iterator;

import controller.SemesterController;
import dto.TimetableRow;

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
	
	@Override
	public void displaySemester(SemesterController sc) {
		
		// Validação e atualização do semestre atual
		if(super.isCurrentSemester(sc) == false) {
			super.setCurrentSemester(sc);
			
			// Limpeza de painel
			super.clean();
			
			// Iteração ao longo dos elementos
			Iterator<TimetableRow> iterator = sc.getTimetableIterator();
			while(iterator.hasNext()) {
				TimetableRow row = iterator.next();
				String values[] = row.getValues();
				
				// Célula de rotulação (horário)
				super.addCell(row.getLabel(), new Color(200, 200, 200), new Color(20, 20, 20));
				
				// Cria células para as siglas das disciplinas
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
