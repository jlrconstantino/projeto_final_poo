package generic.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

	// Atributo para leitura de buffer
	private static BufferedReader br;
	
	// Construtor para buffer padrão
	public InputReader(){
		InputStreamReader isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}
	
	// Construtor para buffer específico
	public InputReader(InputStreamReader isr) {
		br = new BufferedReader(isr);
	}
	
	/**
	 * Realiza leitura de uma linha do buffer armazenado pela classe.
	 * @return string lida do buffer se bem sucedido
	 * @throws IOException
	*/
	public String readLine() throws IOException {
		return br.readLine();
	}
	
	/**
	 * Realiza leitura de um inteiro do buffer armazenado pela classe.
	 * @return inteiro lido se bem sucedido
	 * @throws IOException
	 * @throws NumberFormatException
	*/
	public int readInt() throws IOException, NumberFormatException {
		String input = readLine();
		int output = Integer.parseInt(input);
		return output;
	}
	
	/**
	 * Realiza leitura de um double do buffer armazenado pela classe.
	 * @return valor lido se bem sucedido
	 * @throws IOException
	 * @throws NumberFormatException
	*/
	public double readDouble() throws IOException, NumberFormatException {
		String input = readLine();
		double output = Double.parseDouble(input);
		return output;
	}
}
