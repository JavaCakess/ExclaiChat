package cjaf.exclaichat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ExclaiMenu extends JMenuBar{

	JMenu visuals;
	JMenu connections;
	;;JMenuItem host;
	ExclaiGUI eg;
	public ExclaiMenu(ExclaiGUI eg) {
		this.eg = eg;
		visuals = new JMenu("Visuals");
		add(visuals);
		connections = new JMenu("Connections");
			host = new JMenuItem("Host Server");
			connections.add(host);
			
		host.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					hostServer();
				}
			}
		);
		add(connections);
	}
	
	public void hostServer() {
		new ExclaiSetupServer(eg);
	}
}
