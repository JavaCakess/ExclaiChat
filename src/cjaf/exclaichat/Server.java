package cjaf.exclaichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread{

	private ServerSocket server;
	ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
	int port;
	ExclaiGUI eg;
	boolean failed = false;
	String name;
	public Server(ExclaiGUI eg, int port, String name) {
		this.port = port;
		this.eg = eg;
		this.name = name;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			//Exception handling
			eg.home.err("Failed to set up server.");
			failed = true;
		}
	}
	
	public boolean wasFailed() {
		return failed;
	}
	
	public void run() {
		while (true) {
			ClientHandler ch = null;
			try {
				ch = new ClientHandler(this, eg, server.accept());
			} catch (IOException e) {
				eg.home.warning("Failed to accept connection.");
			}
			ch.start();
			clients.add(ch);
		}
	}
}
