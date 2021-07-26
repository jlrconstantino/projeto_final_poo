package controller;

import java.util.Iterator;

import dto.Activity;
import dto.DayTimeInterval;
import dto.Discipline;
import dto.TimetableRow;
import generic.collections.Treap;
import generic.interfaces.Filter;

/** Representa e gerencia um semestre. */
public class SemesterController {

	// Atributos
	private Treap<Discipline> disciplines;
	private Treap<Activity> activities;
	private TimetableController timetable;
	
	// Construtor
	public SemesterController() {
		disciplines = new Treap<Discipline>();
		activities = new Treap<Activity>();
		timetable = new TimetableController();
	}
	
	// Adi��o de uma nova disciplina
	public boolean addDiscipline(Discipline d) {
		
		// Adi��o � �rvore de disciplinas
		boolean successFlag = disciplines.add(d);
		
		// Adi��o dos hor�rios de oferecimento � grade hor�ria
		if(successFlag == true && d.getOfferingsIterator() != null) {
			Iterator<DayTimeInterval> offerings = d.getOfferingsIterator();
			while(offerings.hasNext())
				timetable.addCell(offerings.next(), d.getId());
		}
		return successFlag;
	}
	
	// Adi��o de uma atividade
	public boolean addActivity(Activity a) {
		return activities.add(a);
	}
	
	// Retorna iterador para as disciplinas
	public Iterator<Discipline> getDisciplineIterator(){
		return disciplines.iterator();
	}
	
	// Retorna iterador para as atividades
	public Iterator<Activity> getActivitiesIterator(){
		return activities.iterator();
	}
	
	// Retorna iterador filtrado para as atividades
	public Iterator<Activity> getActivitiesIterator(Filter<Activity> filter){
		return activities.iterator(filter);
	}
	
	// Retorna iterador para as linhas da grade hor�ria
	public Iterator<TimetableRow> getTimetableIterator(){
		return timetable.getRowsIterator();
	}
}

