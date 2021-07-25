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
	
	// Construtores
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status, float grade) {
		super();
		this.name = name;
		this.date = date;
		this.disciplineId = disciplineId;
		this.type = type;
		this.status = status;
		this.grade = grade;
	}
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status) {
		this(name, date, disciplineId, type, status, (float) 0.0);
	}

	// Métodos acessores
	public String getName() { return name; }
	public LocalDate getDate() { return date; }
	public String getDisciplineId() { return disciplineId; }
	public ActivityType getType() { return type; }
	public String getStatus() { return status; }
	public float getGrade() { return grade; }
	public void setGrade(float grade) { this.grade = grade; }

	@Override
	public int compareTo(Activity o) {
		return date.format(DateTimeFormatter.BASIC_ISO_DATE).compareTo(
			o.getDate().format(DateTimeFormatter.BASIC_ISO_DATE)
		);
	}
}
