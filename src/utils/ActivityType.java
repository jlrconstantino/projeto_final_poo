package utils;

public enum ActivityType {
	
	// Valores
	ASSESSMENT, WORK, EXERCISE, OTHER;
	
	// Representa��o literal
	public String toString() {
		switch(this) {
			case ASSESSMENT: return new String("Avalia��o");
			case WORK: return new String("Trabalho");
			case EXERCISE: return new String("Exerc�cio");
			case OTHER: return new String("Outro");
			default: return new String("NaN");
		}
	}
}
