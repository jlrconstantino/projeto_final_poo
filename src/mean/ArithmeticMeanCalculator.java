package mean;

import java.util.Iterator;

/**
 * Implementa o c�mputo de m�dias aritm�ticas a 
 * partir de lista de valores de ponto flutuante.
 * */
public class ArithmeticMeanCalculator extends MeanCalculator {
	
	// Construtor padr�o
	public ArithmeticMeanCalculator() { super(); }
	
	// C�mputo da m�dia aritm�tica
	@Override 
	public float getMean() {
		
		// Vari�veis locais
		float output = (float) 0.0;
		int valuesAmount = 0;
		Iterator<Float> iterator = super.getValuesIterator();
		
		// Itera ao longo da lista, somando seus valores
		while(iterator.hasNext()) {
			output += iterator.next();
			++valuesAmount;
		}
		
		// Retorna a m�dia aritm�tica
		return output / valuesAmount;
	}

}
