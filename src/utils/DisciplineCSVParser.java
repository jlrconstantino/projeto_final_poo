package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import dto.Discipline;

/** Realiza leitura, convers�o e mapeamento de um CSV, 
 * em formato apropriado, para diferentes disciplinas */
public class DisciplineCSVParser {
	
	// Delimitador de campos do CSV
	public static final String COMMA_DELIMITER = new String(",");
	
	/** 
	 * A partir de um caminho especificado para um arquivo CSV, 
	 * far� sua leitura e convers�o para uma cole��o de disciplinas, 
	 * a qual ser� inserida em um HashMap e chaveado por ID - cujo 
	 * tipo � String.
	 * 
	 * Para tanto, o CSV deve estar internamente configurado de modo 
	 * � sua primeira coluna apresentar a sigla da disciplina, e � 
	 * sua �ltima coluna conter o nome dessa disciplina.
	 * @throws IOException 
	 * */
	public static HashMap<String, Discipline> parse(String csvPath) throws IOException{
		
		// Vari�veis locais e inicializa��o
		HashMap<String, Discipline> map = new HashMap<String, Discipline>();
		BufferedReader br = new BufferedReader(new FileReader(csvPath, StandardCharsets.UTF_8));
		String line;
		String[] values;
		Discipline discipline;
		
		// Leitura linha a linha
		do {
			line = br.readLine();
			if(line != null) {
				values = line.split(COMMA_DELIMITER);
				discipline = new Discipline(values[ values.length - 1 ], values[0]);
				map.put(values[0], discipline);
			}
		} while(line != null);
		
		// Finaliza��o
		br.close();
		return map;
	}
}
