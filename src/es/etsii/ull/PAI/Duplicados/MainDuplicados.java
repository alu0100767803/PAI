/**
 * 
 */
package es.etsii.ull.PAI.Duplicados;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Programa principal para usar la clase Duplicados
 */
public class MainDuplicados {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try{
			final int ANCHO = 300;
			final int ALTO = 200;
			
			Duplicados frame = new Duplicados(args[0]);
			frame.setTitle("Analizador de duplicados");
			frame.setSize(ANCHO, ALTO);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
			
			frame.mostrar();
			
		}
		
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("Hace falta 1 parámetro");
			System.out.println("La forma correcta de usarse es: ");
			System.out.println("Ej: java MainDuplicados.java Cadena.txt");
		}
		
		catch(IllegalArgumentException e2){
			System.out.println("El parametro ha de ser un fichero de texto");
		}
	}

}
