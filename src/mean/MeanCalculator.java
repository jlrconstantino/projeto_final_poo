package mean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe de abstração de uma metodologia de cômputo de média final. 
 * Mantém uma lista interna de valores-base de ponto flutuante.
 * */
public abstract class MeanCalculator {
	
	// Valores-base
	private List<Float> values;
	
	// Construtor
	public MeanCalculator() {
		values = new ArrayList<Float>();
	}
	
	/** Gera um iterador para a lista de valores-base. */
	protected Iterator<Float> getValuesIterator(){
		return values.iterator();
	}
	
	/** Insere um novo valor à lista. */
	public boolean addValue(float value) {
		return values.add(value);
	}
	
	/** Remove um valor da lista. */
	public boolean removeValue(float value) {
		return values.remove(value);
	}
	
	/** Método de cálculo da média final. */
	public abstract float getMean();
}
