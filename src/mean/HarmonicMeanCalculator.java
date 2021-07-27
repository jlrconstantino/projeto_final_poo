package mean;

import java.util.Iterator;

/**
 * Implementa o cômputo de médias ponderadas a 
 * partir de lista de valores de ponto flutuante.
 * */
public class HarmonicMeanCalculator extends MeanCalculator {

	// Quantidade de elementos
	private int amountOfValues;

	// Construtor padrão
	public HarmonicMeanCalculator() {
		super();
		setAmountOfValues(amountOfValues);
	}

	public void setAmountOfValues(int amountOfValues) {
		this.amountOfValues = amountOfValues;
	}

	public boolean addValue(int value) {
		return(super.addValue(value));
	}

	/** Remove um valor e um peso das listas. */
	public boolean removeValue(int value) {
		return(super.removeValue(value));
	}

	
	// Cômputo da média harmônica
	@Override 
	public float getMean() {
		float output = 0.0F;
		Iterator<Float> iteratorValues = super.getValuesIterator();
		while(iteratorValues.hasNext()) {
			output += 1/iteratorValues.next();
		}
		return amountOfValues/output;
	}

}