package generic.interfaces;

@FunctionalInterface
public interface TwoTypedComparator<S, T> {
	/**
	 * Deve retornar <0, 0 e >0 se o primeiro registro for, lógica e respectivamente, 
	 * prioritário, semelhante ou não prioritário em relação ao segundo.
	 * */
	public abstract int compare(S t, T s);
}
