package es.etsii.ull.PAI.MapSerpiente;

import es.etsii.ull.PAI.Serpiente.Serpiente;
import java.util.*;

/**
 * @author Jorge
 *
 */
public class SerpienteMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Serpiente serpiente1 = new Serpiente();
		Serpiente serpiente2 = new Serpiente();
		Serpiente serpiente3 = new Serpiente();
		
		Serpiente serpiente4 = new Serpiente();
		Map<String, Serpiente> mapaSerpiente = new TreeMap<String, Serpiente>();
		mapaSerpiente.put("serpiente1", serpiente1 );
		mapaSerpiente.put("serpiente2", serpiente2);
		mapaSerpiente.put("serpiente3", serpiente3);
		mapaSerpiente.put("serpiente4", serpiente4);
		
		Iterator<String> iterador = mapaSerpiente.keySet().iterator();
		System.out.println("Serpiente     Valor");
		while(iterador.hasNext()){
			Object nombreSerpiente = iterador.next();
			System.out.println(nombreSerpiente + "     " + mapaSerpiente.get(nombreSerpiente).reptar());
		}

	}

}
