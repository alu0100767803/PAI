/**
 * 
 */
package es.esit.ull.PAI.SimonDice;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author alu4487
 *
 */
public class Botones extends JPanel{
	
	private final String START = "Start";
	private final String END = "End";
	
	private JButton Start;
	private JButton End;
	
	public Botones(){
		Start = new JButton(getSTART());
		End = new JButton(getEND());
		
		add(Start);
		add(End);
	}

	public JButton getStart() {
		return Start;
	}

	public void setStart(JButton start) {
		Start = start;
	}

	public JButton getEnd() {
		return End;
	}

	public void setEnd(JButton end) {
		End = end;
	}

	public String getSTART() {
		return START;
	}

	public String getEND() {
		return END;
	}
	
	

}
