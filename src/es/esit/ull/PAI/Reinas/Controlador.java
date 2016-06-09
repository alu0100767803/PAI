/**
 * 
 */
package es.esit.ull.PAI.Reinas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * @author Jorge
 *
 */
public class Controlador {
	
	private final int TAMAÑO_TABLERO = 8;
	private Tablero tablero;
	private OchoReinas ochoReinas;
	ArrayList soluciones;
	int numeroSolucion;
	int[][] solucion;
	int[][] tab;
	int[][] pr;
	
	public Controlador() throws Exception{
		
		
		ochoReinas = new OchoReinas(TAMAÑO_TABLERO);
		solucion = new int[TAMAÑO_TABLERO][TAMAÑO_TABLERO];
		pr = nuevoTablero();
		for (int i = 0; i < TAMAÑO_TABLERO; i++){
			for(int j = 0; j < TAMAÑO_TABLERO; j++){
				System.out.print(pr[i][j] + " ");
			}
			System.out.println("");
		}
		
		solucion = crearTablero(TAMAÑO_TABLERO);
		
		tab = fusionar(pr, solucion);
		Tablero tablero = new Tablero(TAMAÑO_TABLERO, tab, ochoReinas, numeroSolucion);
		tablero.setVisible(true);
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
	public int[][] nuevoTablero(){
		ochoReinas.buscarSoluciones();
		soluciones = ochoReinas.getSolucionesPosibles();
		int[] aux  = (int[]) soluciones.get(getNumeroSolucion());
		for (int j = 0; j < aux.length; j++) {
			setTableroSolucion(j, aux[j]);
			
		}
		return solucion;
	}
	
	public void setTableroSolucion(int fila, int columna) {
		solucion[fila][columna] = -1;
	}
	
	public int getNumeroSolucion() {
		return numeroSolucion;
	}

	public void setNumeroSolucion(int numeroSolucion) {
		this.numeroSolucion = numeroSolucion;
	}

	public int[][] getSolucion() {
		return solucion;
	}

	public void setSolucion(int[][] solucion) {
		this.solucion = solucion;
	}

}
