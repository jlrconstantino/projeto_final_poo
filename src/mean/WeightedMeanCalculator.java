package mean;

import java.util.Iterator;
import java.util.Vector;

/**
 * Implementa o cômputo de médias ponderadas a 
 * partir de lista de valores de ponto flutuante.
 * */
public class WeightedMeanCalculator extends MeanCalculator {
	
	// Pesos
	private final Vector<Float> weights;
	
	// Construtor padrão
	public WeightedMeanCalculator() { 
		super();
		weights = new Vector<Float>();
	}
	
	/** Insere um novo valor e um novo peso às listas. */
	public boolean addValue(float value, float weight) {
		boolean output = super.addValue(value);
		if(output) {
			output = weights.add(weight);
			if(!output)
				super.removeValue(value);
		}
		return output;
	}
	
	/** Remove um valor e um peso das listas. */
	public boolean removeValue(float value, float weight) {
		boolean output = super.removeValue(value);
		if(output)
			output = weights.remove(weight);
		return output;
	}
	
	/** Insere um novo valor à lista. Considera peso unitário. */
	@Override
	public boolean addValue(float value) {
		return addValue(value, (float) 1.0);
	}
	
	/** Remove um valor da lista. Considera peso unitário. */
	@Override
	public boolean removeValue(float value) {
		return removeValue(value, (float) 1.0);
	}
	
	// Cômputo da média ponderada
	@Override 
	public float getMean() {

		// Variáveis locais
		float outputWeight = 0;
		float output = 0;

		Iterator<Float> iteratorValues = super.getValuesIterator();
		Iterator<Float> iteratorWeights = this.getValuesIterator();

		while(iteratorValues.hasNext() && iteratorWeights.hasNext()) {
			output += iteratorValues.next() * iteratorWeights.next();
			outputWeight += iteratorWeights.next();
		}
		return output/outputWeight;
	}

}