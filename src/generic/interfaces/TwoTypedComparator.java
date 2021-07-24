package generic.interfaces;

@FunctionalInterface
public interface TwoTypedComparator<S, T> {
	/**
	 * Deve retornar <0, 0 e >0 se o primeiro registro for, l�gica e respectivamente, 
	 * priorit�rio, semelhante ou n�o priorit�rio em rela��o ao segundo.
	 * */
	public abstract int compare(S t, T s);
}
