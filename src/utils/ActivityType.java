package utils;

public enum ActivityType {
	
	// Valores
	ASSESSMENT, WORK, OTHER;
	
	// Representa��o literal
	public String toString() {
		switch(this) {
			case ASSESSMENT: return new String("Avalia��o");
			case WORK: return new String("Trabalho");
			default: return new String("Outro");
		}
	}
}
