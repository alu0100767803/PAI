/**
 * 
 */
package es.esit.ull.PAI.Practica13;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 12/05/2016
 * Asignatura: Programaci�n de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que crea el panel de botones de la aplicaci�n
 */

public class PanelBotones extends JPanel{
	
	private final int ANCHO_ICONO = 32;
  private final int ALTO_ICONO = -1;
	
	private final String INICIO = "Inicio";
	private final String FIN = "Fin";
	private final String PAUSA = "Pausar";
	private final String REANUDAR = "Reanudar";
	private final String PASO = "Paso";
	private final String VELOCIDAD  = "Velocidad:     -";
	private final String MAS = "+";
	private final int NUMERO_COLUMNAS = 5;
	private final String REPETICIONES = "Repeticiones: ";
	private final String BLINKER = "Blinker";
	private final String GLIDER = "Glider";
	private final String DIEHARD = "Diehard";
	
	private JButton inicio;
	private JButton fin;
	private JButton pausa;
	private JButton paso;
	private JButton reanudar;
	private JSlider velocidad;
	private JButton informacion;
	private JLabel textVelIzquierda;
	private JLabel textVelDerecha;
	private JLabel textoRepeticiones;
	private JComboBox patronCelular;
	
	private JTextField repeticiones;
	
	private ImageIcon icono;
	private ImageIcon iconoEscala;
	
	public PanelBotones(){
		setLayout(new GridLayout(2, 1));
		
		icono = new ImageIcon("i.png");
    iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(getANCHO_ICONO(), getALTO_ICONO(), java.awt.Image.SCALE_DEFAULT));
		
		inicio = new JButton(getINICIO());
		fin = new JButton(getFIN());
		pausa = new JButton(getPAUSA());
		reanudar = new JButton(getREANUDAR());
		paso = new JButton(getPASO());
		velocidad = new JSlider();
		informacion = new JButton(iconoEscala);
		textVelIzquierda = new JLabel(getVELOCIDAD());
		textVelDerecha = new JLabel(getMAS());
		textoRepeticiones = new JLabel(getREPETICIONES());
		repeticiones = new JTextField(getNUMERO_COLUMNAS());
		patronCelular = new JComboBox();
		
		patronCelular.addItem(getBLINKER());
		patronCelular.addItem(getGLIDER());
		patronCelular.addItem(getDIEHARD());
		
		informacion.setBorder(null);
		informacion.setContentAreaFilled(false);
		
		JPanel arriba = new JPanel();
		JPanel abajo = new JPanel();
		
		arriba.add(getTextVelIzquierda());
		arriba.add(velocidad);
		arriba.add(getTextVelDerecha());
		
		abajo.add(inicio);
		abajo.add(fin);
		abajo.add(pausa);
		abajo.add(reanudar);
		abajo.add(paso);
		abajo.add(textoRepeticiones);
		abajo.add(repeticiones);
		abajo.add(patronCelular);
		abajo.add(informacion);
		
		add(arriba);
		add(abajo);
	}

	/*
	 * -------------------------------------- Getters y Setters ----------------------------------------------------------
	 */
	
	public JButton getInicio() {
		return inicio;
	}

	public void setInicio(JButton inicio) {
		this.inicio = inicio;
	}

	public JButton getFin() {
		return fin;
	}

	public void setFin(JButton fin) {
		this.fin = fin;
	}

	public JButton getPausa() {
		return pausa;
	}

	public void setPausa(JButton pausa) {
		this.pausa = pausa;
	}

	public JButton getPaso() {
		return paso;
	}

	public void setPaso(JButton paso) {
		this.paso = paso;
	}

	public String getINICIO() {
		return INICIO;
	}

	public String getFIN() {
		return FIN;
	}

	public String getPAUSA() {
		return PAUSA;
	}

	public String getPASO() {
		return PASO;
	}

	public JButton getReanudar() {
		return reanudar;
	}

	public void setReanudar(JButton reanudar) {
		this.reanudar = reanudar;
	}

	public JSlider getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(JSlider velocidad) {
		this.velocidad = velocidad;
	}

	public String getREANUDAR() {
		return REANUDAR;
	}

	public JButton getInformacion() {
		return informacion;
	}

	public void setInformacion(JButton informacion) {
		this.informacion = informacion;
	}

	public ImageIcon getIcono() {
		return icono;
	}

	public void setIcono(ImageIcon icono) {
		this.icono = icono;
	}

	public ImageIcon getIconoEscala() {
		return iconoEscala;
	}

	public void setIconoEscala(ImageIcon iconoEscala) {
		this.iconoEscala = iconoEscala;
	}

	public int getANCHO_ICONO() {
		return ANCHO_ICONO;
	}

	public int getALTO_ICONO() {
		return ALTO_ICONO;
	}

	public JLabel getTextVelIzquierda() {
		return textVelIzquierda;
	}

	public void setTextVelIzquierda(JLabel textVelIzquierda) {
		this.textVelIzquierda = textVelIzquierda;
	}

	public JLabel getTextVelDerecha() {
		return textVelDerecha;
	}

	public void setTextVelDerecha(JLabel textVelDerecha) {
		this.textVelDerecha = textVelDerecha;
	}

	public String getVELOCIDAD() {
		return VELOCIDAD;
	}

	public String getMAS() {
		return MAS;
	}

	public JTextField getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(JTextField repeticiones) {
		this.repeticiones = repeticiones;
	}

	public String getREPETICIONES() {
		return REPETICIONES;
	}

	public int getNUMERO_COLUMNAS() {
		return NUMERO_COLUMNAS;
	}

	public JLabel getTextoRepeticiones() {
		return textoRepeticiones;
	}

	public void setTextoRepeticiones(JLabel textoRepeticiones) {
		this.textoRepeticiones = textoRepeticiones;
	}

	public JComboBox getPatronCelular() {
		return patronCelular;
	}

	public void setPatronCelular(JComboBox patronCelular) {
		this.patronCelular = patronCelular;
	}

	public String getBLINKER() {
		return BLINKER;
	}

	public String getGLIDER() {
		return GLIDER;
	}

	public String getDIEHARD() {
		return DIEHARD;
	}
	
	

	
}
