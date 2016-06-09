/**
 * @author Jorge
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 09/04/2016
 * Asignatura: Programación de Aplicaciones Interactivas
 * Version: 1
 * Comentario: Clase que testea las clases
 */
package es.esit.ull.PAI.Practica8;

import static org.junit.Assert.*;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BolaMovilTest {

	private FrameFixture frame;
	private Ventana ventana;
	private Bola bola;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ventana = new Ventana(90);
		frame = new FrameFixture(ventana);
		bola = new Bola(10);
	}

	@Test
	public void comprobarBotones() {

		for(int i = 0; i < 8; i++)
			frame.button("botonDer").click();
		for(int i = 0; i < 5; i++)
			frame.button("botonAba").click();
		for(int i = 0; i < 8; i++)
			frame.button("botonIzq").click();
		for(int i = 0; i < 5; i++)
			frame.button("botonArr").click();
	}
	
	@Test
	public void comprobarIntervalo(){
		bola.setIntervalo(20);
		assertTrue(bola.getIntervalo() == 20);
	}
	
	@After
	public void clean() {
		frame.cleanUp();
	}

}
