package generic.interfaces;

@FunctionalInterface
public interface Filter<T> {
	/**
	 * Filtra um registro segundo certo algoritmo, retornando 
	 * true se ele for válido, ou false em situação oposta.
	 * */
	public abstract boolean filter(T a);
}
