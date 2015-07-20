package dta;

import  org.junit.Assert;



import org.junit.Test;

public class dtaRestServerInfoTest {

	@Test
	public void testProtocol(){
		RestServerInfoHelper helper = new RestServerInfoHelper();
		String protocol = helper.getDtaRestServerInfo().getProtocol();

		Assert.assertEquals("http", protocol);
	}
	
	@Test
	public void testHost(){
		RestServerInfoHelper helper = new RestServerInfoHelper();
		String host = helper.getDtaRestServerInfo().getHost();

		Assert.assertEquals("localhost", host);
	}
	
	@Test
	public void testPort(){
		RestServerInfoHelper helper = new RestServerInfoHelper();
		String port = helper.getDtaRestServerInfo().getPort();

		Assert.assertEquals("8080", port);
	}

}
