package utils;

public enum ActivityType {
	
	// Valores
	ASSESSMENT, WORK, EXERCISE, OTHER;
	
	// Representação literal
	public String toString() {
		switch(this) {
			case ASSESSMENT: return new String("Avaliação");
			case WORK: return new String("Trabalho");
			case EXERCISE: return new String("Exercício");
			case OTHER: return new String("Outro");
			default: return new String("NaN");
		}
	}
}
