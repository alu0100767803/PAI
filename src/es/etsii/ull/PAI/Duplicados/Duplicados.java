package es.etsii.ull.PAI.Duplicados;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que muestra por pantalla las palabras no duplicadas
 */

public class Duplicados extends JFrame {
	
	private Map<String, Integer> mapa;  // Mapa que va a contener las palabras del texto 
																			// y las veces que se repite
	
	public Duplicados(String fichero) throws IOException, FileNotFoundException{
		mapa = new TreeMap<String, Integer>();
		
		setLayout (new FlowLayout(FlowLayout.LEFT, 10, 20));
  	add(new JLabel("Fichero a analizar"));
  	add(new JTextField(8));
  	add(new JButton("Analizar"));
		
		BufferedReader reader = new BufferedReader(new FileReader(fichero));
    String linea;
    
    while((linea = reader.readLine()) != null){
    	StringTokenizer st = new StringTokenizer(linea," ");
    	while (st.hasMoreTokens()) { 
    		String token = st.nextToken();
    		
    		if (encontrarCadena(token.toLowerCase()))
    			borrarClave(token);
         else 
        	 setClaveMapa(token.toLowerCase(), 1);
      }
    
    }
  }
	
	/**
	 * Devuelve el valor del keyset del TreeMap
	 * @return
	 */
  public Set<String> getKeySet() {
		return mapa.keySet();
	}

  /**
   * Introduce una clave y su valor en el TreeMap
   * @param clave
   * @param valor
   */
	public void setClaveMapa(String clave, Integer valor) {
		mapa.put(clave, valor);
	}
	
	/**
	 * Borra una clave del TreeMap
	 * @param clave
	 */
	public void borrarClave(String clave){
		mapa.remove(clave);
	}

	/**
	 * Devuelve si la cadena que le pasamos esta ya en el TreeMap
	 * @param token
	 * @return
	 */
	public boolean encontrarCadena(String token) {
  	if (mapa.containsKey(token.toLowerCase())) 
  		return true;
    else 
      return false;
    }
  
	/**
	 * Muestra el TreeMap de forma invertida
	 */
  public void mostrar() {
  	Stack<String> palabra = new Stack<String>(); // pila para sacar los elementos del TreeMap de forma inversa
  	Iterator<String> iterador = getKeySet().iterator();
		System.out.println("Caedenas No Duplicadas");
		while(iterador.hasNext()){
			Object cadena = iterador.next();
				palabra.push((String) cadena);
		}
		
		iterador = palabra.iterator();
		while(iterador.hasNext()){
			System.out.println(palabra.pop());
		}

  }
}
