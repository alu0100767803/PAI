package es.etsii.ull.PAI.Serpiente;

import java.util.*;

/**
 * @author Jorge
 *
 */
public class MainSerpiente {

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
		for (int i = 0; i < 10; i++){
			System.out.println("Soy la serpiente " + serpientes.get(i).reptar());
		}
		
		System.out.println("Hay " + serpientes.get(9).getNumSerpiente() + " serpientes");
		
	}

}
