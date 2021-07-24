package dto;

import java.time.DayOfWeek;

/** Representa um intervalo temporal, recebendo um dia 
 * da semana, e dois hor�rios: de in�cio, e de finaliza��o */
public class DayTimeInterval {
	
	// Atributos
	private DayOfWeek day;
	private String interval;
	
	/** A vari�vel "interval" deve seguir o padr�o "hh:mm - hh:mm" */
	public DayTimeInterval(DayOfWeek day, String interval){
		this.day = day;
		this.interval = interval;
	}
	
	// M�todos acessores
	public DayOfWeek getDay() { return day; }
	public String getInterval() { return interval; }
}
