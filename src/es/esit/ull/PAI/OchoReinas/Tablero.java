package es.esit.ull.PAI.OchoReinas;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 26/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea el tablero
 */

public class Tablero extends JPanel implements KeyListener, ActionListener {
	private final int REINA = -1;	// Valor que diferencia la reina de las demás.
	private final int CERO = 0;	// Valor que representara la casilla blanco
	private final int UNO = 1;	// Valor que representara la casilla negra
	private final int DIVISOR = 2;	// Valor del divisor para obtener el 0 o el 1
	private final int TAMANYO;	// Tamaño el tablero
	
	private OchoReinas ochoReinas;	// Clase que gestiona el problema.
	private int numeroSolucion = CERO;	// Numero de la solucion actual
	private ArrayList soluciones;	
	private int[][] tablero;	// tablero con las reinas colocadas
	private final int[][] molde;	// tablero molde, representa el tablero original sin reinas


	public Tablero(int tamanyo, OchoReinas ochoReinas) throws Exception {
		
		TAMANYO = tamanyo;
		tablero = crearTablero(TAMANYO);
		molde = crearTablero(TAMANYO);
		this.ochoReinas = ochoReinas;
		

		
		new JPanel();
		addKeyListener(this);
		setFocusable(true);

		setLayout(new GridLayout(getTAMANYO(), getTAMANYO()));
		solucionar();
		pintarTablero();    
	}
	
	/**
	 * Metodo que obtiene la siguiente solucion
	 * @throws Exception
	 */
	private void solucionar() throws Exception {
		ochoReinas.buscarSoluciones();
		setSoluciones(ochoReinas.getSolucionesPosibles());	// devuelve un ArrayList con todas las soluciones del problema
		int[] aux  = (int[]) soluciones.get(getNumeroSolucion());	// devuelve un vector de enteros con las columnas donde hay que situar un -1
		for (int j = 0; j < aux.length; j++) {
			setTableroReina(j, aux[j]);	// Coloca en la fila i, columna aux[j] un -1
		}
	}
	
	/**
	 * Metodo que devuelve el tablero que obtiene la solucion al estado original
	 */
	private void resetear() {
	  for (int i = 0; i < getTAMANYO(); i++) {
      for (int j = 0; j < getTAMANYO(); j++) {
        setTableroElem(i, j, getElemMolde(i, j));
      }
    }
	}
	
	/**
	 * Metodo que actualiza el panel del tablero
	 * @throws Exception
	 */
	private void actualizar() throws Exception {
		resetear();
		solucionar();
		removeAll();
		validate();
		new JPanel();
		setLayout(new GridLayout(getTAMANYO(), getTAMANYO()));
		pintarTablero();

	}

	/**
	 * Metodo que crea un tablero del tamaño especificado
	 * @param tamanyo
	 * @return
	 */
	public int[][] crearTablero(int tamanyo){
		int[][] tablero = new int[tamanyo][tamanyo];
		int elemento;
		for(int i = 0; i < tamanyo; i++){
			for(int j = 0; j < tamanyo; j++){
				
				if(i % getDIVISOR() == getCERO()){
					elemento = j % getDIVISOR();	
				}
				else{
					if( j % getDIVISOR() == getCERO())
						elemento = getUNO();
					else
						elemento = getCERO();					
				}
				tablero[i][j] = elemento;
			}
		}
		return tablero;
	}
	
	/**
	 * Metodo que pinta el tablero
	 */
	public void pintarTablero(){
		for(int i = 0; i < getTAMANYO(); i++){
			for(int j = 0; j < getTAMANYO(); j++){
				if(getTableroElemento(i, j) == getCERO()){
					Blanca blanca = new Blanca();
					add(blanca);
				}
				else if(getTableroElemento(i, j) == getUNO()){
					Negra negra = new Negra();
					add(negra);
				}
				else if(getTableroElemento(i, j) == getREINA()){
					Reina reina = new Reina();
					add(reina);
				}
				validate();
			}
		}
	}

	private int getTAMANYO() {
		return TAMANYO;
	}
	private int getNumeroSolucion() {
		return numeroSolucion;
	}
	private void setNumeroSolucion(int numeroSolucion) {
		this.numeroSolucion = numeroSolucion;
	}
	private int getTableroElemento(int fila, int columna) {
		return tablero[fila][columna];
	}
	private void setTableroReina(int fila, int columna) {
		tablero[fila][columna] = getREINA();
	}
	
	private void setTableroElem(int fila, int columna, int elem){
		tablero[fila][columna] = elem;
	}

	private OchoReinas getProblema() {
		return ochoReinas;
	}
	private void setProblema(OchoReinas ochoReinas) {
		this.ochoReinas = ochoReinas;
	}
	private ArrayList getSoluciones() {
		return soluciones;
	}
	private void setSoluciones(ArrayList soluciones) {
		this.soluciones = soluciones;
	}
	private int[][] getTablero() {
		return tablero;
	}
	private void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
	
	private int getElemMolde(int i, int j){
		return molde[i][j];
	}
	
	private int getREINA() {
		return REINA;
	}
	

	public int getCERO() {
		return CERO;
	}

	public int getUNO() {
		return UNO;
	}
	
	public int getDIVISOR() {
		return DIVISOR;
	}

	public OchoReinas getOchoReinas() {
		return ochoReinas;
	}

	public void setOchoReinas(OchoReinas ochoReinas) {
		this.ochoReinas = ochoReinas;
	}

	public int[][] getMolde() {
		return molde;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		System.out.println("Presionó: " + (char) key);
			setNumeroSolucion(getNumeroSolucion() + 1);
				try {
				if(getOchoReinas().getSolucionesPosibles().size() > getNumeroSolucion())
					actualizar();
				else
					System.out.println("No hay mas soluciones");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint(); 
	}
}