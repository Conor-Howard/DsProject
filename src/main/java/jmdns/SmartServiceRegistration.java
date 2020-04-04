package jmdns;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SmartServiceRegistration {

	public static void main(String[] args) throws InterruptedException {
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			ServiceInfo laptop = ServiceInfo.create("_http._tcp.local", "laptop", 30031, "Control the Laptop");
			jmdns.registerService(laptop);		
			
			ServiceInfo microphone = ServiceInfo.create("_http._tcp.local", "microphone", 40041, "Control the Microphone");
			jmdns.registerService(microphone);
			
			ServiceInfo thermostat = ServiceInfo.create("_http._tcp.local", "thermostat", 50051, "Control the thermostat");
			jmdns.registerService(thermostat);
			
			Thread.sleep(25000);
			
			jmdns.unregisterAllServices();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
