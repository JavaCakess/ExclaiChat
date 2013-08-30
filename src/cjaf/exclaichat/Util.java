package cjaf.exclaichat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.JTextComponent;

public class Util {
	public static File configFile = new File("config.txt");
	
	public static String getUsername() {
		return value("username", 0);
	}
	
	public static void setUsername(String s) {
		wr_value("username", 0, s);
	}
	
	public static String join(String[] array) {
		String result = "";
		for (String s : array) {
			result = result.concat(s);
		}
		return result;
	}
	
	public static String join(String[] array, String regex) {
		String result = "";
		for (String s : array) {
			result = result.concat(s + regex);
		}
		return result;
	}
	
	public static void wr_variable(String name, int params) {
		ArrayList<String> data = IOTools.readFile(configFile);
		String p = "";
		for (int z = 0; z < params; z++) {
			p = p.concat(";");
		}
		data.add("#" + name + " " + p);
		IOTools.writeToFile(configFile, data);
	}
	
	public static void wr_variable(String name, String params) {
		ArrayList<String> data = IOTools.readFile(configFile);
		data.add("#" + name + " " + params);
		IOTools.writeToFile(configFile, data);
	}
	
	public static void wr_value(String string, int i, String param) {
		ArrayList<String> data = IOTools.readFile(configFile);
		for (int z = 0; z < data.size(); z++) {
			String it = data.get(z);
			if (it.startsWith("#" + string)) {
				String[] args = it.substring(("#" + string).length() + 1).split(";");
				if (i >= args.length) {
					throw new RuntimeException("i is greater than the amount of arguments!");
				}
				args[z] = param;
				System.out.println("durr");
				data.set(z, join(args));
				return;
			}
		}
		data.add("#" + string);
		IOTools.writeToFile(configFile, data);
		return;
	}
	
	public static String value(String string, int i) {
		ArrayList<String> data = IOTools.readFile(configFile);
		for (String it : data) {
			if (it.startsWith("#" + string)) {
				String[] args = it.substring(("#" + string).length() + 1).split(";");
				if (i >= args.length) {
					throw new RuntimeException("i is greater than the amount of arguments!");
				}
				return args[i];
			}
		}
		return null;
	}

	public static String time(Date d) {
		String result = "";
		int h = d.getHours();
		int m = d.getMinutes();
		int s = d.getSeconds();
		
		if (h < 10) {
			result = result.concat("0");
		}
		result = result.concat("" + h + ":");
		if (m < 10) {
			result = result.concat("0");
		}
		result = result.concat("" + m + ":");
		if (s < 10) {
			result = result.concat("0");
		}
		result = result.concat("" + s);
		return result;
	}
	
	public static int getLineCount(JTextComponent txtComp) {
	    return txtComp.getText().split("\n").length-1;
	}
	
	public static String getIp() throws Exception {
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = in.readLine();
            return ip;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

	public static boolean canParseInt(String text) {
		try {
			int result = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
