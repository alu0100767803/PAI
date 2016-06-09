/**
 * 
 */
package es.esit.ull.PAI.Reinas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class Tablero extends JPanel implements KeyListener, ActionListener{
	final private int TAMAÑO;
	final private int ANCHO = 300;
	final private int ALTO = 300;


	private Blanca blanca;
	private Reina reina;
	private Negra negra;
	private int[][] tablero;
	private int[][] tableroSolucion;
	OchoReinas ochoReinas;
	private int nSoluciones;
	private int[][] solucion;
	
	public Tablero(int tamanyo, int[][] sol, OchoReinas problema, int nSolucion) {
		TAMAÑO = tamanyo;
		tableroSolucion = sol;
		ochoReinas = problema;
		tablero = crearTablero(TAMAÑO);
		this.nSoluciones = nSolucion;
		solucion = new int[TAMAÑO][TAMAÑO];
		
		new JPanel();


		pintarTablero(tableroSolucion);
		addKeyListener(this);
		setFocusable(true);
		
	}	
	
	public int getnSoluciones() {
		return nSoluciones;
	}

	public void setnSoluciones(int nSoluciones) {
		this.nSoluciones = nSoluciones;
	}

	private int getTAMAÑO() {
		return TAMAÑO;
	}
	
	public void nuevoPanel(int[][] tab){
		removeAll();
		pintarTablero(tab);
	}
	public void pintarTablero(int[][] tab){
		for(int i = 0; i < getTAMAÑO(); i++){
			for(int j = 0; j < getTAMAÑO(); j++){
				if(tab[i][j] == 0){
					blanca = new Blanca();
					add(blanca);
				}
				else if(tab[i][j] == 1){
					negra = new Negra();
					add(negra);
				}
				else if(tab[i][j] == -1){
					reina = new Reina();
					add(reina);
				}
				validate();
			}
		}
	}
	
	public int[][] nuevoTablero(){
		ochoReinas.buscarSoluciones();
		ArrayList soluciones = ochoReinas.getSolucionesPosibles();
		int[] aux  = (int[]) soluciones.get(getnSoluciones());
		for (int j = 0; j < aux.length; j++) {
			setTableroSolucion(j, aux[j]);			
		}
		return solucion;
	}
	
	public void actualizar(){
		int[][] sol;
		int[][] tab;
		
		sol = nuevoTablero();
		tab = fusionar(sol, tablero);
		removeAll();
		validate();
		new JPanel();
		setLayout(new GridLayout(getTAMAÑO(), getTAMAÑO()));
		pintarTablero(tab);
	}
			
	public int[][] crearTablero(int tamanyo){
		int[][] tablero = new int[tamanyo][tamanyo];
		int elemento;
		for(int i = 0; i < tamanyo; i++){
			for(int j = 0; j < tamanyo; j++){
				
				if(i % 2 == 0){
					elemento = j % 2;
	
				}
				else{
					if( j % 2 == 0)
						elemento = 1;
					else
						elemento = 0;
					
				}
				tablero[i][j] = elemento;
			}
		}
		return tablero;
	}
		
	public int[][] fusionar(int[][] a, int [][] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b.length; j++){
				if(a[i][j] == -1){
					b[i][j] = -1;
				}
			}
		}
		return b;
	}
	

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int [][] tablero) {
		this.tablero = tablero;
	}

	public int[][] getTableroSolucion() {
		return tableroSolucion;
	}

	public void setTableroSolucion(int[][] tableroSolucion) {
		this.tableroSolucion = tableroSolucion;
	}
	
	public void setTableroSolucion(int fila, int columna) {
		solucion[fila][columna] = -1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		setnSoluciones(getnSoluciones() + 1);
		repaint();
		System.out.println("Presionó Enter!" + (char) key);
		actualizar();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
