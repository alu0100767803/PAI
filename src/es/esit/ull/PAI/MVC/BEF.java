/**
 * 
 */
package es.esit.ull.PAI.MVC;

/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 13/03/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase para el Franco Belga, hereda de la clase Moneda
 */
public class BEF extends Moneda {
	
	private float bef;	// Valor en Francos Belgas
	final private float BEF = 40.34f;	// Valor de 1 Euro en Francos Belgas
	final private String NOMBRE = "Belg. Franc";	// Nombre de la moneda

	public BEF(float euros) {
		super(euros);
		bef = eurosABef();
	}

	/**
	 * Metodo que convierte los Euros en Francos Belgas
	 * @return
	 */
	public float eurosABef() {	
		return getEuros() * getFACTOR();
	}

	public float getValor() {
		return bef;
	}

	public void setValor(float bef) {
		this.bef = bef;
	}
	
	public float getFACTOR() {
		return BEF;
	}

	public String getNOMBRE(){
		return NOMBRE;
	}
}
