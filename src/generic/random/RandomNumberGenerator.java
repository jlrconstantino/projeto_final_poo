package generic.random;

import java.util.Calendar;

/**
 * Produz números pseudoaleatórios por meio 
 * da metodologia das congruências lineares.
 * */
public class RandomNumberGenerator {

	// Atributos do gerador congruencial
	private final long PRIME = 2147483648L;
	private final long WEIGHT = 843314861;
	private final long BIAS = 453816693;
	private long seed;
	
	/* Construtor padrão: utiliza o tempo 
	instantâneo para geração da semente */
	public RandomNumberGenerator() {
		seed = Calendar.getInstance().getTimeInMillis() % PRIME;
	}
	
	// Utiliza uma semente informada pelo usuário
	public RandomNumberGenerator(int seed) {
		if(seed >= 0)
			this.seed = seed;
		else
			this.seed = -seed;
	}
	
	// Atualiza a semente para um valor informado
	public void setSeed(int seed) {
		if(seed >= 0)
			this.seed = seed;
		else
			this.seed = -seed;
	}
	
	/** 
	 * Retorna um valor de ponto flutuante 
	 * contido no intervalo [0,1[. 
	 * */
	public double getRandom() {
		seed = (WEIGHT * seed + BIAS) % PRIME;
		return (double) seed / PRIME;
	}
	
	/** 
	 * Retorna um valor de ponto flutuante 
	 * contido no intervalo [0,max[. 
	 * */
	public double getRandom(int max) {
		return getRandom() * max;
	}
	
	/** 
	 * Retorna um valor de ponto flutuante 
	 * contido no intervalo [min,max[. 
	 * */
	public double getRandom(int min, int max) {
		double interval = max - min;
		return min + getRandom() * interval;
	}
		
	/** 
	 * Retorna um valor inteiro contido no intervalo [0,max[. 
	 * */
	public int getRandomInt(int max) {
		return (int) (getRandom() * max);
	}
	
	/** 
	 * Retorna um valor inteiro contido no intervalo [min,max]. 
	 * */
	public int getRandomInt(int min, int max) {
		int interval = max - min;
		return min + (int) (getRandom() * interval);
	}
}
