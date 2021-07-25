package dto;

/** Representa uma nota */
public class Grade {
	
	// Atributos
	private String label;
	private float value;
	
	// Construtores
	public Grade(String label) {
		this.label = label;
		value = (float) 0.0;
	}
	public Grade(String label, float value) {
		this.label = label;
		this.value = value;
	}
	
	// Métodos acessores
	public String getLabel() { return label; }
	public float getValue() { return value; }
	public void setValue(float value) { this.value = value; }
}
