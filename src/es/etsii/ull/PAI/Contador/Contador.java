package es.etsii.ull.PAI.Contador;

import java.io.*;
import java.util.*;

/**
 * @author Jorge
 *
 */
public class Contador {
	
	private Map<String, Integer> mapa;
	
	public Contador(String fichero) throws IOException, FileNotFoundException{
		mapa = new HashMap<String, Integer>();
		
		BufferedReader reader = new BufferedReader(new FileReader(fichero));
    String linea;
    
    
    while((linea = reader.readLine()) != null){
    	StringTokenizer st = new StringTokenizer(linea,"\\,;:.?()[]/\" ");
    	while (st.hasMoreTokens()) { 
    		String token = st.nextToken();
    		if (encontrarCadena(token.toLowerCase())) 
    			mapa.put(token.toLowerCase(), mapa.get(token) + 1);
         else 
          mapa.put(token.toLowerCase(), 1);
      }
    
    }
    
	}
	
  public boolean encontrarCadena(String token) {
    if (mapa.containsKey(token.toLowerCase())) 
      return true;
     else 
      return false;
  }
  
  public void mostrar() {
  	Iterator<String> iterador = mapa.keySet().iterator();
		System.out.println("Caedena     Repeticiones");
		while(iterador.hasNext()){
			Object cadena = iterador.next();
			System.out.println(cadena + "     " + mapa.get(cadena));
		}

  }
  

}
	
