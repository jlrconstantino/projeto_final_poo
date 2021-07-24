package dto;

/** Linha de uma grade hor�ria. */
public class TimetableRow implements Comparable<TimetableRow> {

	// Atributos
	private String label;
	private String values[];
	
	// Construtor
	public TimetableRow(String label) {
		this.label = label;
		values = new String[6];
	}
	
	// Adi��o de um novo valor
	public void addValue(String value, int pos) {
		if(pos < 0 || pos > 6)
			throw new IndexOutOfBoundsException();
		values[pos] = value;
	}
	
	// M�todos acessores
	public String getLabel() { return label; }
	public String[] getValues() { return values; }
	
	@Override
	public int compareTo(TimetableRow o) {
		return label.compareTo(o.getLabel());
	}
}
