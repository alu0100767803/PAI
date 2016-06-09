package es.etsii.ull.PAI.Ejercicio5;

import java.util.regex.*;
import static java.lang.System.exit;


/**
 * @author Jorge
 *
 */
public class Fecha {
	
  private int dia;
  private int mes;
  private int anyo;
  
  /**
   * Constructor de la clase Fecha
   * @param cadena cadena con la fecha
   */
  public Fecha(String cadena){
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
	
	//Comprobacion de si la fecha es correcta
	if ((anyo > 0) && (anyo < 2016)){
      if (mes < 12){
	    if ((mes == 02) && (anyo % 4 == 0) && (dia < 29)){}
	    else if ((mes == 2) && (anyo % 4 != 0) &&(dia < 28)){}
	    else if ((mes <= 7) && (mes % 2 == 0) && (dia < 30)){}
	    else if ((mes <= 7) && (mes % 2 == 1) && (dia < 31)){}
	    else if ((mes > 7) && (mes % 2 == 0) && (dia < 31)){}
	    else if ((mes > 7) && (mes % 2 == 1) && (dia < 30)){}
	    
	    else {
	      System.out.println("Dia erroneo");
	      exit(0);	      
	    }
      }
      else{
        System.out.println("Mes erroneo");
    	exit(0);  
      }
	}
	
	else{
	  System.out.println("Año erroneo");
	  exit(0);
	}
  }


  public void diferencia(Fecha fec){
	int anios = 0; //almacena los años que han pasado 
	int mesesPorAnio = 0; // 
	int diasPorMes = 0;
	int diasTipoMes = 0; //almacena el tipo de dias dependiendo del mes
	
	if (mes == 2) {
		// Febrero
		if ((fec.anyo % 4 == 0) && ((fec.anyo % 100 != 0) || (fec.anyo % 400 == 0)))
			// Bisiesto
			diasPorMes = 29;
		else 
			diasTipoMes = 28;
		
	} else if (mes <= 7) {
		// De Enero a Julio los meses pares tienen 30 y los impares 31
		if (mes % 2 == 0) 
			diasTipoMes = 30;
		else
			diasTipoMes = 31;
	} else if (mes > 7) {
		// De Julio a Diciembre los meses pares tienen 31 y los impares 30
		if (mes % 2 == 0) 
			diasTipoMes = 31;
		else
			diasTipoMes = 30;
	}
	
	if ((anyo > fec.anyo) || (anyo == fec.anyo && mes > fec.mes) || (anyo == fec.anyo && mes == fec.mes && dia > fec.dia)) {
		int aux = anyo;
		anyo = fec.anyo;
		fec.anyo = aux;
		aux = mes;
		mes = fec.mes;
		fec.mes = aux;
		aux = dia;
		dia = fec.dia;
		fec.dia = aux;
		
	} 
	
	if (mes <= fec.mes) {
	  anios = fec.anyo - anyo;
	  if (dia <= fec.dia) {
		mesesPorAnio = fec.mes - mes; 
        diasPorMes = fec.dia - dia;
	  } 
	  else if (fec.mes == mes){
		 anios = anios--;
		 mesesPorAnio = (fec.mes - mes - 1 + 12) % 12;
		 diasPorMes = diasTipoMes - (dia - fec.dia);
	   }
	} 
	else {
	  anios = fec.anyo - anyo - 1;
	  if (dia > fec.dia) {
	    mesesPorAnio = fec.mes - mes - 1 + 12;
		diasPorMes = diasTipoMes - (dia - fec.dia);	
	  } 
	  else {
	    mesesPorAnio = fec.mes - mes + 12;
		diasPorMes = fec.dia - dia;
	  }	
	}
	System.out.println("Han pasado " + anios + " Años, " + mesesPorAnio + " Meses y " + diasPorMes + " Días.");
   }

}
	
	/*Pattern pat_dia = Pattern.compile("^[0-2][0-9] | ^[3][0-1]");
	Pattern pat_mes = Pattern.compile("^[0][0-9] | ^[1][0-2]");
	Pattern pat_anyo = Pattern.compile("^[0-1][0-9][0-9][0-9]$");
	Pattern anyo_1 = Pattern.compile("^[2][0][0][0-9]"); 
	Pattern anyo_2 = Pattern.compile("^[2][0][1][0-6]");
	Matcher mat_dia = pat_dia.matcher(fecha[0]);
	Matcher mat_mes = pat_mes.matcher(fecha[1]);
	Matcher mat_anyo = pat_anyo.matcher(fecha[2]);
	
	System.out.println(fecha[2]);
	System.out.println(mat_anyo.matches());
	if((mat_anyo.matches()) || (anyo_2.matches()))
	  anyo = new Integer(fecha[2]);
	else {
	  System.out.println("Año invalido");
	  exit(0);	
	}
	
	if(mat_mes.matches()){
      mes = new Integer(fecha[1]);
	}
	else {
	  System.out.println("Mes invalido");
	  exit(0);	
     }
	
	int aux = new Integer(fecha[0]);
	if((mat_dia.matches()) && (mes == 02) && (anyo % 4 == 0) )
      dia = new Integer(fecha[0]);
	if ((mat_dia.matches()) && (mes <= 07) && (mes % 2 == 0) && (aux < 30))
	  dia = aux;
	if ((mat_dia.matches())  && (mes > 07) && (mes % 2 == 1) && (aux < 30))
	  dia = aux;
	else{
	  System.out.println("Dia invalido");
	  exit(0);*/

  /*public void diferencia(Fecha fecha){
    
  }*/

  
  
