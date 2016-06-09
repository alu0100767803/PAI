/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase principal para emplear la bola movil
 */
package es.esit.ull.PAI.Practica8;

import javax.swing.JFrame;

public class MainBolaMovil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int intervalo = Integer.parseInt(args[0]);
			Ventana ventana = new Ventana(intervalo);
		}
		catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("ERROR: Hace falta 1 parametro");
			System.out.println("Forma de ejecutar:");
			System.out.println("java MainBolaMovil tamaño_intervalo");
		}
		catch(NumberFormatException e2){
			System.out.println("ERROR: El parametro ha de ser numerico");
			System.out.println("Forma de ejecutar:");
			System.out.println("java MainBolaMovil tamaño_intervalo"); 
		}

	}
}
