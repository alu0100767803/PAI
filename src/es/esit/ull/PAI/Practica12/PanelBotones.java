package es.esit.ull.PAI.Practica12;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{

	private final int ANCHO_ICONO = 32;
  private final int ALTO_ICONO = -1;
	
	private JButton informacion;
	private ImageIcon icono;
	private ImageIcon iconoEscala;
	
	public PanelBotones(){
		icono = new ImageIcon("i.PNG");
    iconoEscala = new ImageIcon(icono.getImage().getScaledInstance(getANCHO_ICONO(), getALTO_ICONO(), java.awt.Image.SCALE_DEFAULT));
    
		informacion = new JButton(iconoEscala);
		informacion.setBorder(null);
		/*informacion.setOpaque(true);
		informacion.setBackground(null);*/
		informacion.setContentAreaFilled(false);
		add(informacion);

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

}
