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
 * Comentario: Clase que controlara el modelo y la vista
 */
public class Controlador {
	
	public Controlador(float euros){
	Moneda dm = new DM(euros);	// Marco Alemán
	Moneda bef = new BEF(euros);	// Franco Belga
	Moneda frf = new FRF(euros);// Franco Francés
	Moneda iep = new IEP(euros);	// Libra Irlandesa
	Moneda itl = new ITL(euros);	// Lira Italiana
	Moneda usd = new USD(euros);	// Dolar Estadounidense
	

	
	Conversor conversor = new Conversor();
	conversor.addCasilla(dm);
	conversor.addCasilla(bef);
	conversor.addCasilla(frf);
	conversor.addCasilla(iep);
	conversor.addCasilla(itl);
	conversor.addCasilla(usd);
	
	conversor.setVisible(true);
	
	}

}
