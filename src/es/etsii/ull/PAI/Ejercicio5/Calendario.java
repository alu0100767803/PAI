/**
 * 
 */
package es.etsii.ull.PAI.Ejercicio5;

import java.util.Calendar;

/**
 * @author Jorge
 *
 */
public class Calendario {
	
	private Calendar prueba;;
	private int dia;
	private int mes;
	private int anyo;
	
	public Calendario(String cadena){
	  dia = 0;
	  mes = 0;
	  anyo = 0;
	  separacion(cadena);
	}

	public void separacion(String cadena){
	  String[] fecha = cadena.split("/");
      anyo = new Integer(fecha[2]);
	  mes = new Integer(fecha[1]);
	  dia = new Integer(fecha[0]);
	  
	  prueba.setLenient(false);
	  prueba.set(anyo, mes, dia);
	}
}
