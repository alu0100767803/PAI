/**
 * 
 */
package es.esit.ull.PAI.AgujaBuffon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author alu4487
 *
 */
public class PanelBotones extends JPanel{
	
	private final String DROP1 = "Drop1";
	private final String DROP10 = "Drop10";
	private final String DROP100 = "Drop100";
	private final String DROP1000 = "Drop1000";
	private final String NUMERO_AGUJAS = "Número de agujas:";
	private final String DROP = "Drop";
	
	private JButton drop1;
	private JButton drop10;
	private JButton drop100;
	private JButton drop1000;
	private JLabel textonAgujas;
	private JTextField nAgujas;
	private JButton drop;
	
	public PanelBotones(){
		drop1 = new JButton(getDROP1());
		drop10 = new JButton(getDROP10());
		drop100 = new JButton(getDROP100());
		drop1000 = new JButton(getDROP1000());
		textonAgujas = new JLabel(getNUMERO_AGUJAS());
		nAgujas = new JTextField();
		drop = new JButton(getDROP());
		
		nAgujas.setColumns(5);
		
		add(drop1);
		add(drop10);
		add(drop100);
		add(drop1000);
		add(textonAgujas);
		add(nAgujas);
		add(drop);
	}

	public JButton getDrop1() {
		return drop1;
	}

	public void setDrop1(JButton drop1) {
		this.drop1 = drop1;
	}

	public JButton getDrop10() {
		return drop10;
	}

	public void setDrop10(JButton drop10) {
		this.drop10 = drop10;
	}

	public JButton getDrop100() {
		return drop100;
	}

	public void setDrop100(JButton drop100) {
		this.drop100 = drop100;
	}

	public JButton getDrop1000() {
		return drop1000;
	}

	public void setDrop1000(JButton drop1000) {
		this.drop1000 = drop1000;
	}

	public String getDROP1() {
		return DROP1;
	}

	public String getDROP10() {
		return DROP10;
	}

	public String getDROP100() {
		return DROP100;
	}

	public String getDROP1000() {
		return DROP1000;
	}

	public JLabel getTextonAgujas() {
		return textonAgujas;
	}

	public void setTextonAgujas(JLabel textonAgujas) {
		this.textonAgujas = textonAgujas;
	}

	public String getNUMERO_AGUJAS() {
		return NUMERO_AGUJAS;
	}

	public JTextField getnAgujas() {
		return nAgujas;
	}

	public void setnAgujas(JTextField nAgujas) {
		this.nAgujas = nAgujas;
	}

	public JButton getDrop() {
		return drop;
	}

	public void setDrop(JButton drop) {
		this.drop = drop;
	}

	public String getDROP() {
		return DROP;
	}
	
	

}
