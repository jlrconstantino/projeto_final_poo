package mean;

import java.util.Iterator;

/**
 * Implementa o cômputo de médias aritméticas a 
 * partir de lista de valores de ponto flutuante.
 * */
public class ArithmeticMeanCalculator extends MeanCalculator {
	
	// Construtor padrão
	public ArithmeticMeanCalculator() { super(); }
	
	// Cômputo da média aritmética
	@Override 
	public float getMean() {
		
		// Variáveis locais
		float output = (float) 0.0;
		int valuesAmount = 0;
		Iterator<Float> iterator = super.getValuesIterator();
		
		// Itera ao longo da lista, somando seus valores
		while(iterator.hasNext()) {
			output += iterator.next();
			++valuesAmount;
		}
		
		// Retorna a média aritmética
		return output / valuesAmount;
	}

}
