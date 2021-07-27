package utils;

public enum ActivityType {
	
	// Valores
	ASSESSMENT, WORK, OTHER;
	
	// Representação literal
	public String toString() {
		switch(this) {
			case ASSESSMENT: return new String("Avaliação");
			case WORK: return new String("Trabalho");
			default: return new String("Outro");
		}
	}
}
