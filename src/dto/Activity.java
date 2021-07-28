package dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import utils.ActivityType;

public class Activity implements Comparable<Activity> {
	
	// Atributos
	private String name;
	private LocalDate date;
	private String disciplineId;
	private ActivityType type;
	private String status;
	private float grade;
	private float weight;
	
	// Construtores
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status, float grade, float weight) {
		super();
		this.name = name;
		this.date = date;
		this.disciplineId = disciplineId;
		this.type = type;
		this.status = status;
		this.grade = grade;
		this.weight = weight;
	}
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status, float grade) {
		this(name, date, disciplineId, type, status, grade, 1.0f);
	}
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status) {
		this(name, date, disciplineId, type, status, 0.0f, 1.0f);
	}

	// Métodos acessores
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public LocalDate getDate() { return date; }
	public void setDate(LocalDate date) { this.date = date; }
	
	public String getDisciplineId() { return disciplineId; }
	public void setDisciplineId(String disciplineId) { this.disciplineId = disciplineId; }
	
	public ActivityType getType() { return type; }
	public void setType(ActivityType type) { this.type = type; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public float getGrade() { return grade; }
	public void setGrade(float grade) { this.grade = grade; }
	
	public float getWeight() { return weight; }
	public void setWeight(float weight) { this.weight = weight; }

	@Override
	public int compareTo(Activity o) {
		return date.format(DateTimeFormatter.BASIC_ISO_DATE).compareTo(
			o.getDate().format(DateTimeFormatter.BASIC_ISO_DATE)
		);
	}
}
