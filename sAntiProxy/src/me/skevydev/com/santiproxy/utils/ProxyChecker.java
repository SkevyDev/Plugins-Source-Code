package me.skevydev.com.santiproxy.utils;

import java.net.URL;
import java.util.Scanner;

public class ProxyChecker {

	private Integer totalProxy = 0;
	
	public boolean isProxy(String ip) {
		try {
			String str = "";
			Scanner s = new Scanner(new URL("http://proxycheck.io/v1/" + ip + "&vpn=1&asn=1&node=0&time=0")
					.openStream());
			while(s.hasNextLine()) {
				str += s.nextLine();
			}
			s.close();
			return str.contains("\"proxy\": \"yes\"");
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Integer getTotalProxy() {
		return totalProxy;
	}
	
	public void setTotalProxy(int value) {
		totalProxy = value;
	}
	
}