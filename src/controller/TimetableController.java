package controller;

import java.util.Iterator;

import dto.DayTimeInterval;
import dto.TimetableRow;
import generic.collections.Treap;
import utils.TimetableRowSearcher;

/** Respons�vel por controlar a grade hor�ria. */
public class TimetableController {
	
	// �rvore de tuplas; prefer�vel � lista devido � verifica��o customizada de exist�ncia
	private static final TimetableRowSearcher customCMP = new TimetableRowSearcher();
	private Treap<TimetableRow> rows;
	
	// Construtor
	public TimetableController() {
		rows = new Treap<TimetableRow>();
	}
	
	// Adiciona um novo elemento
	public boolean addCell(DayTimeInterval dti, String label) {
		TimetableRow row = rows.access(dti.getInterval(), customCMP);
		if(row != null) {
			row.addValue(label, dti.getDay().getValue() - 1);
			return true;
		}else{
			row = new TimetableRow(dti.getInterval());
			row.addValue(label, dti.getDay().getValue() - 1);
			rows.add(row);
		}
		return false;
	}
	
	// Retorna um iterador para as linhas
	public Iterator<TimetableRow> getRowsIterator(){
		return rows.iterator();
	}
}
