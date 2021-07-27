package dto;

import java.util.Iterator;
import java.util.List;

import mean.MeanCalculator;
import mean.WeightedMeanCalculator;

/**
 * Representação da disciplina oferecida ao usuário: apresenta 
 * uma disciplina do banco de dados, porém apresenta informações 
 * específicas ao contexto em que está sendo lecionada.
 * */
public class Discipline implements Comparable<Discipline> {
	
	// Atributos
	private String name;
	private String id;
	private List<DayTimeInterval> offerings;
	private MeanCalculator meanCalculator;
	
	// Construtores
	public Discipline(String name, String id, List<DayTimeInterval> offerings, MeanCalculator meanCalculator) {
		this.name = name;
		this.id = id;
		this.offerings = offerings;
		this.meanCalculator = meanCalculator;
	}
	public Discipline(String name, String id) {
		this.name = name;
		this.id = id;
		this.offerings = null;
		this.meanCalculator = null;
	}
	
	// Métodos acessores
	public String getName() { return name; }
	public String getId() { return id; }
	public Iterator<DayTimeInterval> getOfferingsIterator(){
		if(offerings == null)
			return null;
		return offerings.iterator();
	}
	public void setOfferings(List<DayTimeInterval> offerings) {
		this.offerings = offerings;
	}
	public void setMeanCalculator(MeanCalculator meanCalculator) {
		this.meanCalculator = meanCalculator;
	}
	
	// Encapsulamento das responsabilidades da calculadora de média
	public void addGrade(float grade) {
		meanCalculator.addValue(grade);
	}
	public void addGrade(float grade, float weight) {
		if(meanCalculator instanceof WeightedMeanCalculator)
			((WeightedMeanCalculator) meanCalculator).addValue(grade, weight);
		else
			meanCalculator.addValue(grade);
	}
	public float getMean() {
		if(meanCalculator == null)
			throw new UnsupportedOperationException("There is no defined mean calculator.");
		return meanCalculator.getMean();
	}

	@Override
	public int compareTo(Discipline o) {
		return id.compareTo(o.getId());
	}
}
