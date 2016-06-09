package es.esit.ull.PAI.MVC;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMVC {
	Moneda bef;
	Moneda dm;
	Moneda frf;
	Moneda iep;
	Moneda itl;
	Moneda usd;
	Controlador controlador;

	@Before
	public void setUp() throws Exception {
		controlador = new Controlador(3.12f);
		bef = new BEF(3.12f);
		dm = new DM(3.12f);
		frf = new FRF(3.12f);
		iep = new IEP(3.12f);
		itl = new ITL(3.12f);
		usd = new USD(3.12f);	
	}
	
	
	@Test
	public void testNotNull(){
		System.out.println("Comprobando si se crea el controlador");
		assertNotNull(controlador);
	}

	@Test
	public void testEuros() {
		System.out.println("Comrpobando que el valor de los euros es correcto");
		assertTrue(bef.getEuros() == 3.12f);
		assertTrue(dm.getEuros() == 3.12f);
		assertTrue(frf.getEuros() == 3.12f);
		assertTrue(iep.getEuros() == 3.12f);
		assertTrue(itl.getEuros() == 3.12f);
		assertTrue(usd.getEuros() == 3.12f);
	}
	
	@Test
	public void testCambio() {
		System.out.println("Comprobando el valor del cambio");
		System.out.println(usd.getValor());
		assertTrue(bef.getValor() == 125.860794f);
		assertTrue(dm.getValor() == 6.1152f);
		assertTrue(frf.getValor() == 20.4672f);
		assertTrue(iep.getValor() == 2.4648f);
		assertTrue(itl.getValor() == 6041.162f);
		assertTrue(usd.getValor() == 3.4631999f);
		
	}

}
