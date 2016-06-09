
package es.esit.ull.PAI.Practica11;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea un panel con los valores de todos los elementos de cada tiro parabolico
 */
public class PanelResultados extends JPanel {
	
	private final String TIEMPO = "Tiempo: ";
	private final String SEGUNDOS = " segundos";
	private final String X_FINAL = "x Final: ";
	private final String METROS = " metros";
	private final String Y_FINAL = "y Final: ";
	private final String ACELERACION_X = "Aceleracion x: ";
	private final String ACELERACION_Y = "Aceleracion y: -";
	private final String METROS_SEGUNDOS = "metros / segundos";
	private final String CUADRADO = "^2";
	private final String X_INICIAL = "x Inicial: ";
	private final String Y_INICIAL = "y Inicial: ";
	private final String ALTURA_MAX = "Altura max: ";
	private final String ANGULO = "Angulo: ";
	private final String GRADOS = " º";
	private final String VELOCIDAD = "Velocidad: ";
	private final String VELOCIDAD_INICIAL = "Velocidad inicial ";
	private final String CARACTER_X = "x: ";
	private final String CARACTER_Y = "y: ";
	private final String VELOCIDAD_FINAL = "Velocidad final ";
	
	private JLabel tiempo;
	private JLabel xFinal;
	private JLabel yFinal;
	private JLabel aceleracionX;
	private JLabel aceleracionY;
	private JLabel xInicial;
	private JLabel yInicial;
	private JLabel alturaMax;
	
	private JLabel angulo;
	private JLabel velocidad;
	private JLabel velocidadInicialX;
	private JLabel velocidadInicialY;
	private JLabel velocidadFinalX;
	private JLabel velocidadFinalY;
	
	public PanelResultados(){
		setLayout(new GridLayout(15, 1));
		tiempo = new JLabel();
		xFinal = new JLabel();
		yFinal = new JLabel();
		aceleracionX = new JLabel();
		aceleracionY = new JLabel();
		xInicial = new JLabel();
		yInicial = new JLabel();
		alturaMax = new JLabel();
		angulo = new JLabel();
		velocidad = new JLabel();
		velocidadInicialX = new JLabel();
		velocidadInicialY  = new JLabel();
		velocidadFinalX = new JLabel();
		velocidadFinalY = new JLabel();
		
		add(tiempo);
		add(xInicial);
		add(yInicial);
		add(aceleracionX);
		add(aceleracionY);
		add(xFinal);
		add(yFinal);
		add(alturaMax);
		add(angulo);
		add(velocidad);
		add(velocidadInicialX);
		add(velocidadInicialY);
		add(velocidadFinalX);
		add(velocidadFinalY);
	}
	
	public void borrar(){
		getTiempo().setText("");
		getxFinal().setText("");
		getyFinal().setText("");
		getAceleracionX().setText("");
		getAceleracionY().setText("");
		getxInicial().setText("");
		getyInicial().setText("");
		getAlturaMax().setText("");
		getAngulo().setText("");
		getVelocidad().setText("");
		getVelocidadInicialX().setText("");
		getVelocidadInicialY().setText("");
		getVelocidadFinalX().setText("");
		getVelocidadFinalY().setText("");
	}
	
	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public void setVelocidadFinalY(double velocidad){
		getVelocidadFinalY().setText(getVELOCIDAD_FINAL() + getCARACTER_Y() + velocidad + getMETROS_SEGUNDOS());
		repaint();
	}
	
	public void setVelocidadFinalX(double velocidad){
		getVelocidadFinalX().setText(getVELOCIDAD_FINAL() + getCARACTER_X() + velocidad + getMETROS_SEGUNDOS());
		repaint();
	}
	
	public void setVelocidadInicialY(double velocidad){
		getVelocidadInicialY().setText(getVELOCIDAD_INICIAL() + getCARACTER_Y() + velocidad + getMETROS_SEGUNDOS());
		repaint();
	}
	
	public void setVelocidadInicialX(double velocidad){
		getVelocidadInicialX().setText(getVELOCIDAD_INICIAL() + getCARACTER_X() + velocidad + getMETROS_SEGUNDOS());
		repaint();
	}
	
	public void setVelocidad(double velocidad){
		getVelocidad().setText(getVELOCIDAD() + velocidad + getMETROS_SEGUNDOS());
		repaint();
	}
	
	public void setAngulo(double angulo){
		getAngulo().setText(getANGULO() + angulo + getGRADOS()); 
	}
	
	public void setAlturaMax(double alturaMax){
		getAlturaMax().setText(getALTURA_MAX() + alturaMax + getMETROS());
		repaint();
	}
	
	public void setXFinal(double xFinal){
		getxFinal().setText(getX_FINAL() + xFinal + getMETROS()); 
		repaint();
	}
	
	public void setYFinal(double yFinal){
		getyFinal().setText(getY_FINAL() + yFinal + getMETROS());
		repaint();
	}
	
	public void setTiempo(double tiempo){
		getTiempo().setText(getTIEMPO() + tiempo + getSEGUNDOS());
		repaint();
	}
	
	public void setAceleracionX(double aceleracionX){
		getAceleracionX().setText(getACELERACION_X() + aceleracionX + getMETROS_SEGUNDOS() + getCUADRADO());
		repaint();
	}
	
	public void setAceleracionY(double aceleracionY){
		getAceleracionY().setText(getACELERACION_Y() + aceleracionY + getMETROS_SEGUNDOS() + getCUADRADO());
		repaint();
	}
	
	public void setXInicial(double xInicial){
		getxInicial().setText(getX_INICIAL() + xInicial + getMETROS());
		repaint();
	}
	
	public void setYInicial(double yInicial){
		getyInicial().setText(getY_INICIAL() + yInicial + getMETROS()); 
		repaint();
	}
	

	public JLabel getTiempo() {
		return tiempo;
	}

	public void setTiempo(JLabel tiempo) {
		this.tiempo = tiempo;
	}

	public String getTIEMPO() {
		return TIEMPO;
	}

	public String getSEGUNDOS() {
		return SEGUNDOS;
	}

	public JLabel getxFinal() {
		return xFinal;
	}

	public void setxFinal(JLabel xFinal) {
		this.xFinal = xFinal;
	}

	public String getX_FINAL() {
		return X_FINAL;
	}

	public String getMETROS() {
		return METROS;
	}

	public JLabel getyFinal() {
		return yFinal;
	}

	public void setyFinal(JLabel yFinal) {
		this.yFinal = yFinal;
	}

	public String getY_FINAL() {
		return Y_FINAL;
	}

	public JLabel getAceleracionX() {
		return aceleracionX;
	}

	public void setAceleracionX(JLabel aceleracionX) {
		this.aceleracionX = aceleracionX;
	}

	public JLabel getAceleracionY() {
		return aceleracionY;
	}

	public void setAceleracionY(JLabel aceleracionY) {
		this.aceleracionY = aceleracionY;
	}

	public String getACELERACION_X() {
		return ACELERACION_X;
	}

	public String getMETROS_SEGUNDOS() {
		return METROS_SEGUNDOS;
	}

	public String getCUADRADO() {
		return CUADRADO;
	}

	public String getACELERACION_Y() {
		return ACELERACION_Y;
	}

	public JLabel getxInicial() {
		return xInicial;
	}

	public void setxInicial(JLabel xInicial) {
		this.xInicial = xInicial;
	}

	public JLabel getyInicial() {
		return yInicial;
	}

	public void setyInicial(JLabel yInicial) {
		this.yInicial = yInicial;
	}

	public String getX_INICIAL() {
		return X_INICIAL;
	}

	public String getY_INICIAL() {
		return Y_INICIAL;
	}

	public JLabel getAlturaMax() {
		return alturaMax;
	}

	public void setAlturaMax(JLabel alturaMax) {
		this.alturaMax = alturaMax;
	}

	public String getALTURA_MAX() {
		return ALTURA_MAX;
	}

	public JLabel getAngulo() {
		return angulo;
	}

	public void setAngulo(JLabel angulo) {
		this.angulo = angulo;
	}

	public String getANGULO() {
		return ANGULO;
	}

	public String getGRADOS() {
		return GRADOS;
	}

	public JLabel getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(JLabel velocidad) {
		this.velocidad = velocidad;
	}

	public JLabel getVelocidadInicialX() {
		return velocidadInicialX;
	}

	public void setVelocidadInicialX(JLabel velocidadInicialX) {
		this.velocidadInicialX = velocidadInicialX;
	}

	public JLabel getVelocidadInicialY() {
		return velocidadInicialY;
	}

	public void setVelocidadInicialY(JLabel velocidadInicialY) {
		this.velocidadInicialY = velocidadInicialY;
	}

	public JLabel getVelocidadFinalX() {
		return velocidadFinalX;
	}

	public void setVelocidadFinalX(JLabel velocidadFinalX) {
		this.velocidadFinalX = velocidadFinalX;
	}

	public JLabel getVelocidadFinalY() {
		return velocidadFinalY;
	}

	public void setVelocidadFinalY(JLabel velocidadFinalY) {
		this.velocidadFinalY = velocidadFinalY;
	}

	public String getVELOCIDAD() {
		return VELOCIDAD;
	}

	public String getVELOCIDAD_INICIAL() {
		return VELOCIDAD_INICIAL;
	}

	public String getCARACTER_X() {
		return CARACTER_X;
	}

	public String getCARACTER_Y() {
		return CARACTER_Y;
	}

	public String getVELOCIDAD_FINAL() {
		return VELOCIDAD_FINAL;
	}

	
	
}
