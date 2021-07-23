package mean;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa o c�mputo de m�dias ponderadas a 
 * partir de lista de valores de ponto flutuante.
 * */
public class WeightedMeanCalculator extends MeanCalculator {
	
	// Pesos
	private List<Float> weights;
	
	// Construtor padr�o
	public WeightedMeanCalculator() { 
		super();
		weights = new ArrayList<Float>();
	}
	
	/** Insere um novo valor e um novo peso �s listas. */
	public boolean addValue(float value, float weight) {
		boolean output = super.addValue(value);
		if(output == true) {
			output = weights.add(weight);
			if(output == false)
				super.removeValue(value);
		}
		return output;
	}
	
	/** Remove um valor e um peso das listas. */
	public boolean removeValue(float value, float weight) {
		boolean output = super.removeValue(value);
		if(output == true)
			output = weights.remove(weight);
		return output;
	}
	
	/** Insere um novo valor � lista. Considera peso unit�rio. */
	@Override
	public boolean addValue(float value) {
		return addValue(value, (float) 1.0);
	}
	
	/** Remove um valor da lista. Considera peso unit�rio. */
	@Override
	public boolean removeValue(float value) {
		return removeValue(value, (float) 1.0);
	}
	
	// C�mputo da m�dia ponderada
	@Override 
	public float getMean() {
		// TODO
		return 0;
	}

}