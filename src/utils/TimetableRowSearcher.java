package utils;

import dto.TimetableRow;
import generic.interfaces.TwoTypedComparator;

/** Usado para pesquisar uma linha de grade horária. */
public class TimetableRowSearcher implements TwoTypedComparator<String, TimetableRow> {
	@Override
	public int compare(String t, TimetableRow s) {
		return t.compareTo(s.getLabel());
	}
}
