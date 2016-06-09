
package es.esit.ull.PAI.Practica11;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un problema del tiro parabolico y realiza los calculos pertinentes para dibujarlo y obtener todos sus datos
 */
public class TiroParabolico {
	
	private double xInicial;											// posicion x inicial
	private double aceleracionX;											// aceleracion para x
	private double velocidadInicialX;										// velocidad inical de x
	private double velocidadFinalX;											// velocidad final de x
	private double xFinal;											// posicion final de x
	
	private double yInicial;											// posicion y inicial
	private double aceleracionY;											// aceleracion para y
	private double velocidadInicialY;										// velocidad inicial de y
	private double velocidadFinalY;											// velocidad final de y
	private double yFinal;											// posicion final de y
	
	private double tiempo;											// tiempo transcurrido
	private double angulo;
	private double velocidadLanzamiento;
	private double alturaMaxima;
	
	private Color colorTiro;
	
	private ArrayList<Point> vectorPuntos;					// vector de puntos
	
	/**
	 * Las formulas a emplear son:
	 * Vox = v * cos(angulo)
	 * Voy = v * sin(angulo)
	 * Vfx = v * cos(angulo) + ax * t
	 * Vfy = 
	 */
	public TiroParabolico(){
		xInicial = 0;																	//
		aceleracionX = 0;															// 
		velocidadInicialX = 0;												//
		velocidadFinalX = 0;													//
		xFinal = 0;
		
		yInicial = 0;																	//
		aceleracionY = 9.8;														//
		velocidadInicialY = 0;												//
		velocidadFinalY = 0;													//
		yFinal = 0;																		//
		
		tiempo = 0;																		//
		angulo = 45;																	//
		velocidadLanzamiento = 60;										//
		alturaMaxima = 0;															//
		
		vectorPuntos = new ArrayList<Point>();
		colorTiro = Color.BLACK;
	}
	
	public void calcular(){
		calcularVelocidadInicialX();
		calcularVelocidadInicialY();
		calcularVelocidadFinalX();
		calcularTiempo();
		calcularVelocidadFinalY();
		calcularXFinal();
		calcularAlturaMax();
		calcularPuntos();
	}
	
	public void calcularVelocidadInicialX(){		
		double velocidad = getVelocidadLanzamiento() * Math.cos(Math.toRadians(getAngulo()));
		setVelocidadInicialX(velocidad);
	}
	
	public void calcularVelocidadInicialY(){
		double velocidad = getVelocidadLanzamiento() * Math.sin(Math.toRadians(getAngulo()));
		setVelocidadInicialY(velocidad);
	}
	
	public void calcularVelocidadFinalX(){
		double velocidad = getVelocidadLanzamiento() * Math.cos(Math.toRadians(getAngulo()));
		setVelocidadFinalX(velocidad);
	}
	
	public void calcularVelocidadFinalY(){
		double velocidad = getVelocidadInicialY() - getAceleracionY() * getTiempo();
		setVelocidadFinalY(velocidad);
	}
	
	public void calcularXFinal(){
		double x = getxInicial() + getVelocidadInicialX() * getTiempo() 
									+ (getAceleracionX() * (getTiempo() * getTiempo())) / 2;
		setxFinal(x);
	}
	
	public void calcularAlturaMax(){
		double altura = (Math.pow(getVelocidadInicialY(), 2) * Math.pow(Math.sin(Math.toRadians(getAngulo())), 2)) / (2 * getAceleracionY());
		altura = getyInicial() + altura;
		setAlturaMaxima(altura);
	}
	
	public void calcularPuntos(){
		int x,y;
		double tiempo = getTiempo();
		Point punto;
		double i = 0;
		while(i <= tiempo){//for(int i = 0; i <= tiempo; i++){
			x = (int) (getxInicial() + getVelocidadInicialX() * i + (getAceleracionX() * (i * i)) / 2);
			y = (int) (getyInicial() + getVelocidadInicialY() * i - (getAceleracionY() * (i * i) / 2));
			punto = new Point(x, y);
			
			getVectorPuntos().add(punto);
			i += 0.2;
			
		}
	}
	
	public void calcularTiempo(){
		
		double a = - getAceleracionY() / 2;
		double b = getVelocidadInicialY();
		double c = getyInicial();
		
		double tiempo = ecuacion(a, b, c);
		setTiempo(tiempo);
	}
	

	public double ecuacion(double a, double b, double c){
		double x1;
		double x2;
		
		x1 = (- b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		x2 = (- b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		
		if( x1 > 0)
			return x1;
		else 
			return x2;	
	}
	
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public double getxInicial() {
		return xInicial;
	}

	public void setxInicial(double xInicial) {
		this.xInicial = xInicial;
	}

	public double getAceleracionX() {
		return aceleracionX;
	}

	public void setAceleracionX(double aceleracionX) {
		this.aceleracionX = aceleracionX;
	}

	public double getVelocidadInicialX() {
		return velocidadInicialX;
	}

	public void setVelocidadInicialX(double velocidadInicialX) {
		this.velocidadInicialX = velocidadInicialX;
	}

	public double getVelocidadFinalX() {
		return velocidadFinalX;
	}

	public void setVelocidadFinalX(double velocidadFinalX) {
		this.velocidadFinalX = velocidadFinalX;
	}

	public double getxFinal() {
		return xFinal;
	}

	public void setxFinal(double xFinal) {
		this.xFinal = xFinal;
	}

	public double getyInicial() {
		return yInicial;
	}

	public void setyInicial(double yInicial) {
		this.yInicial = yInicial;
	}

	public double getAceleracionY() {
		return aceleracionY;
	}

	public void setAceleracionY(double aceleracionY) {
		this.aceleracionY = aceleracionY;
	}

	public double getVelocidadInicialY() {
		return velocidadInicialY;
	}

	public void setVelocidadInicialY(double velocidadInicialY) {
		this.velocidadInicialY = velocidadInicialY;
	}

	public double getVelocidadFinalY() {
		return velocidadFinalY;
	}

	public void setVelocidadFinalY(double velocidadFinalY) {
		this.velocidadFinalY = velocidadFinalY;
	}

	public double getyFinal() {
		return yFinal;
	}

	public void setyFinal(double yFinal) {
		this.yFinal = yFinal;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public double getVelocidadLanzamiento() {
		return velocidadLanzamiento;
	}

	public void setVelocidadLanzamiento(double velocidadLanzamiento) {
		this.velocidadLanzamiento = velocidadLanzamiento;
	}

	public double getAlturaMaxima() {
		return alturaMaxima;
	}

	public void setAlturaMaxima(double alturaMaxima) {
		this.alturaMaxima = alturaMaxima;
	}

	public ArrayList<Point> getVectorPuntos() {
		return vectorPuntos;
	}

	public void setVectorPuntos(ArrayList<Point> vectorPuntos) {
		this.vectorPuntos = vectorPuntos;
	}

	public Color getColorTiro() {
		return colorTiro;
	}

	public void setColorTiro(Color colorTiro) {
		this.colorTiro = colorTiro;
	}
	
}
