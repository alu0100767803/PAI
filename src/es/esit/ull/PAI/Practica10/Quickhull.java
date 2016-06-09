/**
 * 
 */
package es.esit.ull.PAI.Practica10;

import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 23/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que realiza el algoritmo de Quickhull
 */
public class Quickhull {
	
	private final int PUNTOS_INICIALES = 20;
	
	ArrayList<Punto> vectorPuntos;												
	private int nPuntos;
	private int limiteX;
	private int limiteY;
	private ArrayList<Punto> puntosSolucion;								
	
	public Quickhull(int limiteX, int limiteY){
		vectorPuntos = new ArrayList<Punto>();
		nPuntos = getPUNTOS_INICIALES();
		this.limiteX = limiteY;
		this.limiteY = limiteY;
		puntosSolucion = new ArrayList<Punto>();
		rellenarVectorPuntos();
		
		
	}
	
	 public void calcular(){
		 int minPoint = -1;
		 int maxPoint = -1;
     int minX = Integer.MAX_VALUE;
     int maxX = Integer.MIN_VALUE;
     
     
     
     for (int i = 0; i < getVectorPuntos().size(); i++)
     {
         if (getVectorPuntos().get(i).getCoordX() < minX)
         {
             minX = getVectorPuntos().get(i).getCoordX();
             minPoint = i;
         }
         if (getVectorPuntos().get(i).getCoordX() > maxX)
         {
             maxX = getVectorPuntos().get(i).getCoordX();
             maxPoint = i;
         }
         
     }
         Punto punto1 = getVectorPuntos().get(minPoint);
         Punto punto2 = getVectorPuntos().get(maxPoint);
         
         ArrayList<Punto> solucionParcial = new ArrayList<Punto>();
         solucionParcial = (ArrayList<Punto>) getVectorPuntos().clone();
         
         getPuntosSolucion().add(punto1);
         getPuntosSolucion().add(punto2);
         solucionParcial.remove(punto1);
         solucionParcial.remove(punto2);
         
         ArrayList<Punto> izquierda = new ArrayList<Punto>();
         ArrayList<Punto> derecha = new ArrayList<Punto>();
         
         for(int i = 0; i < solucionParcial.size(); i++){
        	 Punto punto = solucionParcial.get(i);
        	 if(puntoLocalizacion(punto1, punto2, punto) == -1)
        		 izquierda.add(punto);
        	 else if(puntoLocalizacion(punto1, punto2, punto) == 1)
        		 derecha.add(punto);
        	 hullSet(punto1, punto2, derecha, getPuntosSolucion());
        	 hullSet(punto2, punto1, izquierda, getPuntosSolucion());
         }
         
	 }
         public void hullSet(Punto punto1, Punto punto2, 
        		 ArrayList<Punto> cardinal, ArrayList<Punto> puntosSolucion){
        	 int posicionIsercion = puntosSolucion.indexOf(punto2);
        	 if(cardinal.size() == 0)
        		 return;
        	 if(cardinal.size() == 1){
        		 Punto punto = cardinal.get(0);
        		 cardinal.remove(punto);
        		 puntosSolucion.add(posicionIsercion, punto);
        		 return;
        	 }
        	 
        	 int dist = Integer.MIN_VALUE;
        	 int PuntoLejano = -1;
        	 for(int i = 0; i < cardinal.size(); i++){
        		 Punto punto = cardinal.get(i);
        		 int distancia = distance(punto1, punto2, punto);
        		 if(distancia > dist){
        			 dist = distancia;
        			 PuntoLejano = i;
        		 }
        	 }
        	 
        	 Punto P = cardinal.get(PuntoLejano);
        	 cardinal.remove(PuntoLejano);
        	 puntosSolucion.add(posicionIsercion, P);
        	 
        	 ArrayList<Punto> izquierdaAP = new ArrayList<Punto>();
        	 for(int i = 0; i <cardinal.size(); i++){
        		 Punto M = cardinal.get(i);
        		 if(puntoLocalizacion(punto1, P, M) == 1){
        			 izquierdaAP.add(M);
        		 }
        	 }
        	 
        	 ArrayList<Punto> izquierdaPB = new ArrayList<Punto>();
        	 for(int i = 0; i < cardinal.size(); i++){
        		 Punto M = cardinal.get(i);
        		 if(puntoLocalizacion(P, punto2, M) == 1){
        			 izquierdaPB.add(M);
        		 }
        	 }
        	 
        	 hullSet(punto1, P, izquierdaAP, puntosSolucion);
        	 hullSet(P, punto2, izquierdaPB, puntosSolucion);
         }
       
	public void rellenarVectorPuntos(){
		borrar();
		int aleatorioX;
		int aleatorioY;
		Punto punto = null;
		for(int i = 0; i < getnPuntos(); i++){
			aleatorioX = (int)(Math.random() * getLimiteX());
			aleatorioY = (int)(Math.random() * getLimiteY());
			punto = new Punto(aleatorioX, aleatorioY);
			getVectorPuntos().add(punto);
		}
			
	}
	///////////////////////
	public int puntoLocalizacion(Punto punto1, Punto punto2, Punto punto3){
		int localizacion = (punto2.getCoordX() - punto1.getCoordX()) 
												* (punto3.getCoordY() - punto1.getCoordY()) 
												- (punto2.getCoordY() - punto1.getCoordY() 
														* punto3.getCoordX() - punto1.getCoordX());
		if(localizacion > 0)
			return 1;
		else if(localizacion == 0)
			return 0;
		else
			return -1;
	}
	
	public int distance(Punto punto1, Punto punto2, Punto punto3){
		int distancia_12X = punto2.getCoordX() - punto1.getCoordX();
		int distancia_12Y = punto2.getCoordY() - punto1.getCoordY();
		int distancia = distancia_12X * (punto1.getCoordY() - punto3.getCoordY()) 
										- distancia_12Y * (punto1.getCoordX() - punto3.getCoordX());
		if(distancia < 0)
			distancia = -distancia;
		return distancia;
	}
	
	///////////////////////////
	
	public void borrar(){
		getVectorPuntos().clear();
	}
	
	public void borrarSolucion(){
		getPuntosSolucion().clear();
	}

	public ArrayList<Punto> getVectorPuntos() {
		return vectorPuntos;
	}

	public void setVectorPuntos(ArrayList<Punto> vectorPuntos) {
		this.vectorPuntos = vectorPuntos;
	}

	public int getnPuntos() {
		return nPuntos;
	}

	public void setnPuntos(int nPuntos) {
		this.nPuntos = nPuntos;
	}
	
	public int getLimiteX() {
		return limiteX;
	}

	public int getLimiteY() {
		return limiteY;
	}

	public void mostrarPuntos(){
		for(int i = 0; i < getnPuntos(); i++){
			System.out.println("X = " + getCoordX(i) + "Y = " + getCoordY(i));
		}
	}
	
	public int getCoordX(int index){
		return getVectorPuntos().get(index).getCoordX();
	}
	
	public int getCoordY(int index){
		return getVectorPuntos().get(index).getCoordY();
	}

	public int getPUNTOS_INICIALES() {
		return PUNTOS_INICIALES;
	}

	public void setLimiteX(int limiteX) {
		this.limiteX = limiteX;
	}

	public void setLimiteY(int limiteY) {
		this.limiteY = limiteY;
	}

	public ArrayList<Punto> getPuntosSolucion() {
		return puntosSolucion;
	}

	public void setPuntosSolucion(ArrayList<Punto> puntosSolucion) {
		this.puntosSolucion = puntosSolucion;
	}
	
	

}
