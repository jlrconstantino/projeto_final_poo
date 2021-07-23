package dto;

/** 
 * Classe que representa uma disciplina 
 * qualquer, com nome e sigla. 
 * */
public class Discipline {
	
	// Atributos
	private String id;
	private String name;
	
	// Construtor
	public Discipline(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// Métodos acessores (somente leitura)
	public String getId() { return id; }
	public String getName() { return name; }
}
