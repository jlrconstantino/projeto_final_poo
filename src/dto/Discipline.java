package dto;

/** 
 * Classe que representa uma disciplina 
 * qualquer, com nome, departamento e sigla. 
 * */
public class Discipline {
	
	// Atributos
	private String id;
	private String name;
	private String department;
	
	// Construtor
	public Discipline(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	// Métodos acessores (somente leitura)
	public String getId() { return id; }
	public String getName() { return name; }
	public String getDepartment() { return department; }
}
