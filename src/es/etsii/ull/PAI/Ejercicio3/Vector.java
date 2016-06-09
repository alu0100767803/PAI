package es.etsii.ull.PAI.Ejercicio3;

import java.io.*;
import java.util.*;

/**
 * @author Jorge
 *
 */
public class Vector {
	
	  private ArrayList<Double> vector; //Vector con todos los elementos
	  private double min;  // elemento más pequeño
	  private double max; // elemento más grande
	  
	  /**
	   * Constructor de la clase Vector con los elementos
	   * @param cadena cadena con los elementos para hallar el rango
	   * @throws IOException capturas excepciones de entrada/salida
	   */
	  public Vector(String cadena) throws IOException{
	    vector = new ArrayList<Double>();
	    min = 0.0;
	    max = 0.0;
	    
	    BufferedReader reader = new BufferedReader(new FileReader(cadena));
	    String linea = reader.readLine();
	    String [] token = linea.split("\\s");
	    for ( int i = 0; i < token.length; i++)
	      vector.add(Double.parseDouble(token[i]));
	  }
	  
	  /**
	   * Calcula el rango entre el máximo y el mínimo
	   * @return double, devuelve el rango
	   */
	  public double rango(){
	    for (int i = 0; i < vector.size(); i++){
	      if (vector.get(i) > max)
	        max = vector.get(i);
	      else if (vector.get(i) < min )
	    	min = vector.get(i);
	    }
	    return max - min;
 	  }
}
