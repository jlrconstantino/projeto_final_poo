package controller;

import java.util.Iterator;

import dto.Activity;
import dto.DayTimeInterval;
import dto.Discipline;
import dto.TimetableRow;
import generic.collections.Treap;

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
	
	// Adição de uma nova disciplina
	public boolean addDiscipline(Discipline d) {
		
		// Adição à árvore de disciplinas
		boolean successFlag = disciplines.add(d);
		
		// Adição dos horários de oferecimento à grade horária
		if(successFlag == true) {
			Iterator<DayTimeInterval> offerings = d.getOfferingsIterator();
			while(offerings.hasNext())
				timetable.addCell(offerings.next(), d.getId());
		}
		return successFlag;
	}
	
	// Adição de uma atividade
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
	
	// Retorna iterador para as linhas da grade horária
	public Iterator<TimetableRow> getTimetableIterator(){
		return timetable.getRowsIterator();
	}
}

