package mean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de abstra��o de uma metodologia de c�mputo de m�dia final. 
 * Mant�m uma lista interna de valores-base de ponto flutuante.
 * */
public abstract class MeanCalculator {
	
	// Armazena os valores-base e seus respectivos pesos
	private List<Float> values;
	private List<Float> weights;
	
	// Construtor
	public MeanCalculator() {
		values = new ArrayList<Float>();
		weights = new ArrayList<Float>();
	}
	
	/** Gera um iterador para a lista de valores-base. */
	protected Iterator<Float> getValuesIterator(){
		return values.iterator();
	}
	
	/** Gera um iterador para a lista de pesos. */
	protected Iterator<Float> getWeightsIterator(){
		return weights.iterator();
	}
	
	/** Insere um novo valor � lista. */
	public boolean addValue(float value) {
		return values.add(value);
	}
	
	/** Insere um novo valor e um novo peso �s listas. */
	public boolean addValue(float value, float weight) {
		boolean output = values.add(value);
		if(output == true) {
			output = weights.add(weight);
			if(output == false)
				values.remove(value);
		}
		return output;
	}
	
	/** Remove um valor da lista. */
	public boolean removeValue(float value) {
		return values.remove(value);
	}
	
	/** Remove um valor e um peso das listas. */
	public boolean removeValue(float value, float weight) {
		boolean output = values.remove(value);
		if(output == true)
			output = weights.remove(weight);
		return output;
	}
	
	/** M�todo de c�lculo da m�dia final. */
	public abstract float getMean();
}
