package dto;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import mean.MeanCalculator;

/**
 * Representa��o da disciplina oferecida ao usu�rio: apresenta 
 * uma disciplina do banco de dados, por�m apresenta informa��es 
 * espec�ficas ao contexto em que est� sendo lecionada.
 * */
public class EnrolledDiscipline {
	
	// Atributos
	private String disciplineId;
	private List<LocalDate> offerings;
	private MeanCalculator meanCalculator;
	private boolean active;
	
	// Construtor
	public EnrolledDiscipline(String disciplineId, List<LocalDate> offerings, MeanCalculator meanCalculator) {
		this.disciplineId = disciplineId;
		this.offerings = offerings;
		this.meanCalculator = meanCalculator;
		this.active = true;
	}
	
	// M�todos acessores
	public String getDisciplineId() {
		return disciplineId;
	}
	public Iterator<LocalDate> getOfferingsIterator(){
		return offerings.iterator();
	}
	public float getMean() {
		return meanCalculator.getMean();
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
