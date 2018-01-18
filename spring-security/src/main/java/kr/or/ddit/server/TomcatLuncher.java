package kr.or.ddit.server;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatLuncher {
	public static void main(String[] args) throws ServletException, LifecycleException {
		int port = 8080;
		String webContext = "target/classes/";
		
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(port);
		
		tomcat.addWebapp("/", new File(webContext).getAbsolutePath());
		tomcat.start();
		tomcat.getServer().await();

	}
}
