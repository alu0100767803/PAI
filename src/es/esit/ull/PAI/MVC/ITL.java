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
 * Comentario: Clase para la Lira Italiana, hereda de la clase Moneda
 */
public class ITL extends Moneda {
	
	private float itl;	// Valor en Liras Italianas
	final private float ITL = 1936.27f;	// Valor de 1 Euro en Liras Italianas
	final private String NOMBRE = "Ital. Lira";	// Nombre de la moneda
	
	public ITL(float euros) {
		super(euros);
		itl = eurosAItl();
	}
	
	/**
	 * Metodo que convierte los Euros en Liras Italianas
	 * @return
	 */
	public float eurosAItl() {
		return getEuros() * getFACTOR();
	}
	
	public float getValor() {
		return itl;
	}
	public void setValor(float itl) {
		this.itl = itl;
	}
	public float getFACTOR() {
		return ITL;
	}
	
	public String getNOMBRE(){
		return NOMBRE;
	}

	
}
