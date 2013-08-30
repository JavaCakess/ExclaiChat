package cjaf.exclaichat;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{

	Socket sock;
	PrintWriter writer;
	BufferedReader reader;
	ExclaiGUI eg;
	Server server;
	
	public ClientHandler(Server server, ExclaiGUI eg, Socket sock) {
		this.eg = eg;
		this.sock = sock;
		this.server = server;
		try {
			writer = new PrintWriter(sock.getOutputStream());
			reader = new BufferedReader(
					new InputStreamReader(sock.getInputStream())
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				eg.home.append(line);
			}
		} catch (IOException ioe) {

		}
	}
}
