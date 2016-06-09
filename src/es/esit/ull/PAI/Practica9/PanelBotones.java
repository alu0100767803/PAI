/**
 * 
 */
package es.esit.ull.PAI.Practica9;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jorge
 *
 */
public class PanelBotones extends JPanel {
	
	private final String EMPEZAR = "Empezar";																	
	private final String FINALIZAR = "Finalizar";	
	private final String PAUSAR = "Pausar";
	private final String REANUDAR = "Reanudar";
	private final String PASO = "Paso";
	private final String TODO = "Todo";
	
	private JButton empezar;																						// Boton que va a iniciar la ejecucion del camino
	private JButton finalizar;																					// Boton que va a finalizar la ejecucion del camino
	private JButton pausar;																							// Boton que va a pausar la ejecucion del camino
	private JButton reanudar;																						// Boton que va a reanudar la ejecucion del camino
	private JButton paso;																								// Boton que va a ejecutar el camino paso a paso
	private JButton todo;																								// Boton que va a mostrar todo el camino de golpe
	
	public PanelBotones(){
		empezar = new JButton(getEMPEZAR());
		finalizar = new JButton(getFINALIZAR());
		pausar = new JButton(getPAUSAR());
		reanudar = new JButton(getREANUDAR());
		paso = new JButton(getPASO());
		todo = new JButton(getTODO());
		
		
		setLayout(new GridLayout(3, 1));
		
		JPanel arriba = new JPanel();
		JPanel centro = new JPanel();
		JPanel abajo = new JPanel();
		
		arriba.add(empezar);
		arriba.add(finalizar);
		centro.add(pausar);
		centro.add(reanudar);
		abajo.add(paso);
		abajo.add(todo);
		
		add(arriba);
		add(centro);
		add(abajo);
	}

	public JButton getEmpezar() {
		return empezar;
	}

	public void setEmpezar(JButton empezar) {
		this.empezar = empezar;
	}

	public JButton getFinalizar() {
		return finalizar;
	}

	public void setFinalizar(JButton finalizar) {
		this.finalizar = finalizar;
	}

	public JButton getPausar() {
		return pausar;
	}

	public void setPausar(JButton pausar) {
		this.pausar = pausar;
	}

	public JButton getReanudar() {
		return reanudar;
	}

	public void setReanudar(JButton reanudar) {
		this.reanudar = reanudar;
	}

	public JButton getPaso() {
		return paso;
	}

	public void setPaso(JButton paso) {
		this.paso = paso;
	}

	public String getEMPEZAR() {
		return EMPEZAR;
	}

	public String getFINALIZAR() {
		return FINALIZAR;
	}

	public String getPAUSAR() {
		return PAUSAR;
	}

	public String getREANUDAR() {
		return REANUDAR;
	}

	public String getPASO() {
		return PASO;
	}

	public String getTODO() {
		return TODO;
	}

	public JButton getTodo() {
		return todo;
	}

	public void setTodo(JButton todo) {
		this.todo = todo;
	}

	
}
