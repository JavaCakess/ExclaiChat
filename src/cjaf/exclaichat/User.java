package cjaf.exclaichat;

import java.net.InetAddress;

public class User {

	private String username;
	private final InetAddress address;
	
	public User(String username, InetAddress address) {
		this.username = username;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public InetAddress getAddress() {
		return address;
	}
}
