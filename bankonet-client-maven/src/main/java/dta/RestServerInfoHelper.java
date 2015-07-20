package dta;

import java.util.ResourceBundle;



public class RestServerInfoHelper {
	
	public dtaRestServerInfo getDtaRestServerInfo() {
		
			ResourceBundle prop = ResourceBundle.getBundle("server");
			
			String protocol = prop.getString("protocol");
			String host = prop.getString("host");
			String port = prop.getString("port");
			dtaRestServerInfo serverInfo = new dtaRestServerInfo (protocol,host,port);
			
			return serverInfo;
			
		
		
	}
}
