package dto;

/** Classe do usuário. */
public class Student {

	// Atributos
	private String name;
	private String id;
	
	// Construtor
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	// Métodos acessores
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getId() { return id; }
}
