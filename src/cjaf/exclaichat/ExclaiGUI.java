package cjaf.exclaichat;

import java.awt.BorderLayout;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ExclaiGUI extends JFrame{

	public JTextField field;
	public ExclaiMenu em;
	public JTabbedPane tabbedPane;
	public HomePane home;
	public User user;
	public Server server;

	public ExclaiGUI () {
		super("ExclaiChat v1.0.0");

		setUpGUI();
		setUpWindowProperties();
	}

	public void setUpGUI() {
		//GUI related variables
		em = new ExclaiMenu(this);
		setJMenuBar(em);

		field = new JTextField();
		add(field, BorderLayout.SOUTH);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		home = new HomePane();
		tabbedPane.addTab("Home", home);
		add(tabbedPane);

		//Non-GUI related variables
		String userName = Util.getUsername();
		if (userName == null) {
			userName = "user";
			Util.wr_variable("username", userName);
		}
		try {
			user = new User(userName, InetAddress.getByName(Util.getIp()));
		} catch (Exception e) {
			e.printStackTrace();
			home.err("Failed to get host name");
		}
		System.out.println(userName);
		home.info("Welcome to ExclaiChat, " + user.getUsername() + "!");
	}

	public void setUpWindowProperties() {
		setSize(500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}


}
