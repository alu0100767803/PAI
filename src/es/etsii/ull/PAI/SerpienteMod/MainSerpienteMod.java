package es.etsii.ull.PAI.SerpienteMod;
import es.etsii.ull.PAI.Serpiente.Serpiente;

import java.util.*;

/**
 * @author Jorge
 *
 */
public class MainSerpienteMod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Serpiente> serpientes = new ArrayList<Serpiente>();
		Serpiente serpiente;
		for (int i = 0; i< 10; i++){
			serpiente = new Serpiente();
			serpientes.add(serpiente);
		}
		
		Iterator<Serpiente> iterador = serpientes.iterator();
		while (iterador.hasNext()) {
			serpiente = iterador.next();
			System.out.println("Soy la serpiente " + serpiente.getIdSerpiente());
		}

	}

}
