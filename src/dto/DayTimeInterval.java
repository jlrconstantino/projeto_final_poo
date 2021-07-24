package dto;

import java.time.DayOfWeek;

/** Representa um intervalo temporal, recebendo um dia 
 * da semana, e dois horários: de início, e de finalização */
public class DayTimeInterval {
	
	// Atributos
	private DayOfWeek day;
	private String interval;
	
	/** A variável "interval" deve seguir o padrão "hh:mm - hh:mm" */
	public DayTimeInterval(DayOfWeek day, String interval){
		this.day = day;
		this.interval = interval;
	}
	
	// Métodos acessores
	public DayOfWeek getDay() { return day; }
	public String getInterval() { return interval; }
}
