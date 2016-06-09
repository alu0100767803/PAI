
package es.esit.ull.PAI.Reinas;

import java.util.ArrayList;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 26/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que controlara el modelo y la vista
 */

public class OchoReinas {
  private final int REINA = -1;	// Valor si es reina
  private final int TAMANYO;	// Tamaño del tablero
  private final int TAMANYO_DIAGONAL;	// Tamaño de la diagonal

  private boolean[] vectorFilas;	// Vector con las filas.
  private boolean[] vectorColumnas;	// Vector con las columnas.
  private boolean[] diagonalSuperior;	// Vector con la diagonal superior.
  private boolean[] diagonalInferior;	// Vector con la diagonal inferior.
  private int[] solucionIndividual;	// Vector con la solución.
  private boolean existeSolucion;	// Hay solucion.
  private ArrayList solucionesPosibles = new ArrayList();    // Array con las soluciones.
                                 

  public OchoReinas(int tamanyo) throws Exception {

    TAMANYO = tamanyo;
    TAMANYO_DIAGONAL = 2 * TAMANYO - 1;
    vectorFilas = new boolean[getTAMANYO()];
    vectorColumnas = new boolean[getTAMANYO()];
    solucionIndividual = new int[getTAMANYO()];
    diagonalInferior = new boolean[getTAMANYO_DIAGONAL()];
    diagonalSuperior = new boolean[getTAMANYO_DIAGONAL()];
    
    resetear();
  }

  private void resetear() {
   
    for (int i = 0; i < getTAMANYO(); i++){
    	setVectorFilas(i, true);
    	setVectorColumnas(i, true);
    	setSolucionIndividual(i, getREINA());
    }
    for (int i = 0; i < getTAMANYO_DIAGONAL(); i++){
    	setDiagonalInferior(i, true);
      setDiagonalSuperior(i, true);
    }
    setExisteSolucion(false); 
  }

  private void buscarSolucion(int fila) {
    int col = 0;
    while (col < getTAMANYO() && !isExisteSolucion()) {
      if (getVectorFilas(fila) && getVectorColumnas(col)                  
          && getDiagonalInferior(col - fila + getTAMANYO() - 1)
          && getDiagonalSuperior(col + fila)){
        
        setSolucionIndividual(fila, col);
        setVectorFilas(fila, false);
        setVectorColumnas(col, false);
        setDiagonalInferior(col - fila + getTAMANYO() - 1, false);
        setDiagonalSuperior(col + fila, false);

        if (fila == getTAMANYO() - 1 && solucionNueva(getSolucionIndividual())) {
          setExisteSolucion(true);
        } else {

          if (fila + 1 < getTAMANYO()) {
            buscarSolucion(fila + 1); 
          }

          if (!isExisteSolucion()) {
            setSolucionIndividual(fila, getREINA());
            setVectorFilas(fila, true);
            setVectorColumnas(col, true);
            setDiagonalInferior(col - fila + getTAMANYO() - 1, true);
            setDiagonalSuperior(col + fila, true);
          }
        }
      }
      col++;
    }
  }

  public void buscarSoluciones() {
    boolean isSolucion = true;
    while (isSolucion) {
      buscarSolucion(0);
      if (solucionNueva(getSolucionIndividual())) {
        isSolucion = true;
        agregarSolucion();
      } else {
        isSolucion = false;
      }
      resetear();
    }
  }

  private void agregarSolucion() {
    getSolucionesPosibles().add(getSolucionIndividual());  
  }

  private boolean solucionNueva(int[] nuevaSolucion) {
    if (nuevaSolucion[0] == getREINA()) 
    	return false;
    boolean esNueva = true;
    int i = 0;
    while (i < getSolucionesPosibles().size() && esNueva) { 
      int[] sol = (int[]) getSolucionesPosibles().get(i);
      esNueva = !sonIguales(sol,nuevaSolucion);
      i++;
    }
    return esNueva;
  }

  private  boolean sonIguales (int[] vector1, int[] vector2) {
    int i = 0;
    int j = 0;
    boolean iguales = true;        
    while ((i < vector1.length) && (j < vector2.length)) {
      if (vector1[i] != vector2[j]) {
        return false;
      }
      i++;
      j++;            
    }
    return iguales;
  }

  public int[] obtenerSiguienteSolucion(int indice) {
    int[] aux  = (int[]) getSolucionesPosibles().get(indice);
    return aux;
  }
  private boolean[] getVectorFilas() {
    return vectorFilas;
  }

  private void setVectorFilas(boolean[] vectorFilas) {
    this.vectorFilas = vectorFilas;
  }

  private boolean getVectorFilas(int indice) {
    return vectorFilas[indice];
  }

  private void setVectorFilas(int indice, boolean elemento) {
    vectorFilas[indice] = elemento;
  }

  private boolean[] getVectorColumnas() {
    return vectorColumnas;
  }

  private boolean getVectorColumnas(int indice) {
    return vectorColumnas[indice];
  }

  private void setVectorColumnas(boolean[] vectorColumnas) {
    this.vectorColumnas = vectorColumnas;
  }

  private void setVectorColumnas(int indice, boolean elemento) {
    vectorColumnas[indice] = elemento;
  }

  private boolean[] getDiagonalSuperior() {
    return diagonalSuperior;
  }

  private boolean getDiagonalSuperior(int indice) {
    return diagonalSuperior[indice];
  }

  private void setDiagonalSuperior(boolean[] diagonalSuperior) {
    this.diagonalSuperior = diagonalSuperior;
  }

  private void setDiagonalSuperior(int indice, boolean elemento) {
    diagonalSuperior[indice] = elemento;
  }

  private boolean[] getDiagonalInferior() {
    return diagonalInferior;
  }

  private boolean getDiagonalInferior(int indice) {
    return diagonalInferior[indice];
  }

  private void setDiagonalInferior(boolean[] diagonalInferior) {
    this.diagonalInferior = diagonalInferior;
  }

  private void setDiagonalInferior(int indice, boolean elemento) {
    diagonalInferior[indice] = elemento;
  }

  private int[] getSolucionIndividual() {
    return solucionIndividual;
  }

  private int getSolucionIndividual(int indice) {
    return solucionIndividual[indice];
  }

  private void setSolucionIndividual(int[] solucion) {
    this.solucionIndividual = solucion;
  }

  private void setSolucionIndividual(int indice, int elemento) {
    solucionIndividual[indice] = elemento;
  }

  private boolean isExisteSolucion() {
    return existeSolucion;
  }

  private void setExisteSolucion(boolean existeSolucion) {
    this.existeSolucion = existeSolucion;
  }

  public ArrayList getSolucionesPosibles() {
    return solucionesPosibles;
  }

  private void setSolucionesPosibles(ArrayList soluciones) {
    this.solucionesPosibles = soluciones;
  }


  public int getREINA() {
		return REINA;
	}

	private int getTAMANYO() {
    return TAMANYO;
  }

	public int getTAMANYO_DIAGONAL() {
		return TAMANYO_DIAGONAL;
	}

}