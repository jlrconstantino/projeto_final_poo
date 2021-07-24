package gui.content;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import controller.SemesterController;
import dto.Activity;

/** Interface das atividades. */
public class ActivitiesGUI extends ContentBlockGUI {

	// Constantes
	private static final long serialVersionUID = 5L;
	private static final String[] labels = {
		"Atividade", "Data", "Disciplina", "Tipo", "Status"
	};
	
	// Construtor do painel
	public ActivitiesGUI() {
		super("Atividades", labels, 5);
	}
	
	// Adição de nova atividade
	public void addActivity(Activity activity) {
		super.addCell(activity.getName());
		super.addCell (
			activity.getDate().format (
				DateTimeFormatter.ofPattern("dd/MM/yyyy")
			)
		);
		super.addCell(activity.getDisciplineId());
		super.addCell(activity.getType().toString());
		super.addCell(activity.getStatus());
	}
	
	@Override
	public void displaySemester(SemesterController sc) {
		if(super.isCurrentSemester(sc) == false) {
			super.setCurrentSemester(sc);
			super.clean();
			Iterator<Activity> iterator = sc.getActivitiesIterator();
			while(iterator.hasNext())
				addActivity(iterator.next());
		}
	}
}
