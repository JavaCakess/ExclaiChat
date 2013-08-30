package cjaf.exclaichat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExclaiSetupServer extends JFrame{
	ExclaiGUI eg;
	
	JLabel port;
	JTextField portText;
	
	JLabel name;
	JTextField nameText;
	
	JButton go;
	JPanel pane;

	public ExclaiSetupServer(ExclaiGUI eg) {
		super("Host Server");
		this.eg = eg;
		
		setUpGUI();
		setUpWindowProperties();
		
	}
	
	public void setUpGUI() {
		pane = new JPanel();
		pane.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		port = new JLabel("Port:");
		pane.add(port);
		
		portText = new JTextField("5556");
		pane.add(portText);
		
		name = new JLabel(" Name:");
		pane.add(name);
		
		nameText = new JTextField("My awesome server");
		pane.add(nameText);
		
		go = new JButton("Host");
		pane.add(go, BorderLayout.PAGE_END);
		add(pane, BorderLayout.NORTH);
		
		
		go.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					int port = 0;
					if (Util.canParseInt(portText.getText())) {
						 Integer.parseInt(portText.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Invalid port", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					String serverName = nameText.getText();
					if (serverName.isEmpty()) {
						 java.awt.Toolkit.getDefaultToolkit().beep();
						 return;
					}
					hostServer(port, serverName);
				}
			}
		);
	}

	public void hostServer(int port, String name) {
		/*
		 * Code for setting up the server.
		 */
		eg.server = new Server(eg, port, name);
		if (eg.server.wasFailed()) {
			return;
		}
		eg.server.start();
		this.setVisible(false);
	}

	public void setUpWindowProperties() {
		setSize(300, 175);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
