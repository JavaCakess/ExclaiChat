package cjaf.exclaichat;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JLabelField extends Container{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;
	JTextField field;
	
	public JLabelField(JTextField field, JLabel label) {
		this.label = label;
		this.field = field;
		add(label);
		add(field);
	}
	
	public JLabelField(String field, String label) {
		this.label = new JLabel(label);
		this.field = new JTextField(field);
		add(this.label);
		add(this.field);
	}
}
