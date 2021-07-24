package generic.interfaces;

@FunctionalInterface
public interface Filter<T> {
	/**
	 * Filtra um registro segundo certo algoritmo, retornando 
	 * true se ele for v�lido, ou false em situa��o oposta.
	 * */
	public abstract boolean filter(T a);
}
