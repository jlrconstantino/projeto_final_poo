package dto;

import java.time.LocalDate;

import utils.ActivityType;

public class Activity {
	
	// Atributos
	private String name;
	private LocalDate date;
	private String disciplineId;
	private ActivityType type;
	private String status;
	
	// Construtor
	public Activity(String name, LocalDate date, String disciplineId, ActivityType type, String status) {
		super();
		this.name = name;
		this.date = date;
		this.disciplineId = disciplineId;
		this.type = type;
		this.status = status;
	}

	// Métodos acessores (somente leitura)
	public String getName() { return name; }
	public LocalDate getDate() { return date; }
	public String getDisciplineId() { return disciplineId; }
	public ActivityType getType() { return type; }
	public String getStatus() { return status; }
}
