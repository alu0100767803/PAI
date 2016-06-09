/**
 * 
 */
package es.etsii.ull.PAI.Loteria;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.*;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 08/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que recibira un numero y comprobará si coincide con el numero ganador
 */
public class Loteria extends JFrame {
	
	int centenas;	// valor correspondiente a las centenas del premio
	int decenas;	// valor correspondiente a las decimas del premio
	int unidades;	// valor correspondiente a las unidades del premio
	
	boolean premio1;	// indicara si el premio ganado es el 1
	boolean premio2;	// indicara si el premio ganado es el 2
	boolean premio3;	// indicara si el premio ganado es el 3
	boolean premio4;	// indicara si el premio ganado es el 4
	
	ArrayList<Integer> nGanador = new ArrayList<Integer>(); // Array con la combinacion ganadora
	ArrayList<Integer> nUsuario = new ArrayList<Integer>();	// Array con la combinacion del usuario
	
	public Loteria(int n1, int n2, int n3){
		nGanador = new ArrayList<Integer>();
		nUsuario = new ArrayList<Integer>();
		
		setPremio1(false);

		
		generarPremio();
		
		setLayout (new GridLayout(4 , 2 , 5 , 5)); // la ventana se divide en una matriz de 3x2
		add(new JLabel("Centenas: "));
		add(new JTextField(8));
		add(new JLabel("Decenas: "));
		add(new JTextField(8));
		add(new JLabel("Unidades: "));
		add(new JTextField(8));
		add(new JButton("Comprobar"));
		
		nGanador.add(getCentenas());
		nGanador.add(getDecenas());
		nGanador.add(getUnidades());
		
		nUsuario.add(n1);
		nUsuario.add(n2);
		nUsuario.add(n3);
				
		boletos();
		comprobar();
		tipoPremio();
		
	}
	
	/**
	 * Devuelve el valor de premio1
	 * @return 
	 */
	public boolean isPremio1() {
		return premio1;
	}

	/**
	 * Da un valor a premio1, que se lo pasamos por parametro
	 * @param premio1
	 */
	public void setPremio1(boolean premio1) {
		this.premio1 = premio1;
	}

	
	/**
	 * Devuelve el valor de las centenas
	 * @return
	 */
	public int getCentenas() {
		return centenas;
	}

	/**
	 * Introduce el valor de centenas, valor pasado por parametro
	 * @param centenas
	 */
	public void setCentenas(int centenas) {
		this.centenas = centenas;
	}

	/**
	 * Devuelve el valor de las decenas
	 * @return
	 */
	public int getDecenas() {
		return decenas;
	}

	/**
	 * Introduce el valor de decenas, valor pasado por parametro
	 */
	public void setDecenas(int decenas) {
		this.decenas = decenas;
	}

	/**
	 * Devuelve el valor de unidades
	 * @return
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Introduce el valor de las unidades, valor pasado por parametro
	 * @param unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Genera un numero aleatorio entre el 0 y el 9
	 * @return
	 */
	public int nAleatorio(){
		return (int) (Math.random() * 9 + 0);
	}

	/**
	 * Genera 3 numeros aleatorios que formararn el numero ganador
	 */
	public void generarPremio(){
		setCentenas(nAleatorio());
		setDecenas(nAleatorio());
		setUnidades(nAleatorio());
	}
	
	/**
	 * Comprueba si los numeros ganadores coinciden con los numeros que introdujo el usuario
	 */
	public void comprobar(){
		if(nGanador.get(0) == nUsuario.get(0) &&
				nGanador.get(1) == nUsuario.get(1) &&
				nGanador.get(2) == nUsuario.get(2))
			setPremio1(true);
		else{
			
				
			int cont = 3;
			for(int i = 0; i < cont && i >= 0; i++)
				for(int j = 0; j < cont && i >= 0; j++)
					if(nGanador.get(i) == nUsuario.get(j)){
						nGanador.remove(i);
						nUsuario.remove(j);
						i--;
						j--;
						cont--;
						
					}
		}		
		
	}
	
	/**
	 * Calcula e imprime el resultado de la comprobacion de los dos boletos
	 */
	public void tipoPremio(){
		if(isPremio1())
			System.out.println("Ha ganado el premio gordo: 10000 €");
		else if(nUsuario.isEmpty())
			System.out.println("Premio: 3000 €");
		else if(nUsuario.size() == 1)
			System.out.println("Premio: 2000 €");
		else if(nUsuario.size() == 2)
			System.out.println("Premio: 1000 €");
		else 
			System.out.println("No ha ganado ningun premio");
	}
	
	/**
	 * Imprime los numeros ganadores y los numeros introducidos por el usuario
	 */
	public void boletos(){
		Iterator  itUsuario =  nUsuario.iterator();
		Iterator itGanador = nGanador.iterator();
		System.out.println("Sus numeros son: ");
		while(itUsuario.hasNext())
			System.out.print(itUsuario.next());
		
		System.out.println("");
		System.out.println("Los numeros ganadores son: ");
		while(itGanador.hasNext())
			System.out.print(itGanador.next());
		System.out.println("");
		
		
	}



}
