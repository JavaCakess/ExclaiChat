package cjaf.exclaichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 * Home pane for the GUI.
 */
public class HomePane extends JPanel{
	
	private JTextPane area;
	private Document doc;
	StyleContext cont = StyleContext.getDefaultStyleContext();
	AttributeSet black = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
	AttributeSet grey = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(60, 60, 60));
	int hlOption = 1;
	public HomePane() {
		area = new JTextPane();
		doc = new DefaultStyledDocument();
		area.setDocument(doc);
		add(area, BorderLayout.CENTER);
		area.setEditable(false);
		setLayout(new BorderLayout());
		add(new JScrollPane(area));
	}
	
	public void info(String message) {
		if (hlOption == 0) 
			append(Util.time(new Date()) + " [INFO] " + message + "\n", black);
		else
			append(Util.time(new Date()) + " [INFO] " + message + "\n", grey);
		hlOption = Util.getLineCount(area) % 2;
	}
	public void warning(String message) {
		if (hlOption == 0) 
			append(Util.time(new Date()) + " [WARNING] " + message + "\n", black);
		else
			append(Util.time(new Date()) + " [WARNING] " + message + "\n", grey);
		hlOption = Util.getLineCount(area) % 2;
	}
	public void err(String message) {
		if (hlOption == 0) 
			append(Util.time(new Date()) + " [ERROR] " + message + "\n", black);
		else
			append(Util.time(new Date()) + " [ERROR] " + message + "\n", grey);
		hlOption = Util.getLineCount(area) % 2;
	}
	
	public void append(String msg) {
		try {
			doc.insertString(doc.getLength(), msg, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public void append2(String msg) {
		if (hlOption == 0) 
			append(Util.time(new Date()) + "  " + msg + "\n", black);
		else
			append(Util.time(new Date()) + "  " + msg + "\n", grey);
	}
	
	public void append(String msg, AttributeSet attr) {
		try {
			doc.insertString(doc.getLength(), msg, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	
}
