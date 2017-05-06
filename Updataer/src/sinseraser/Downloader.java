package sinseraser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;

public class Downloader {

	static String page;
	public static void main(String [] args){
		try {
			//System.out.println(downloadPage("http://www.edk.org.pl/trasy.html"));
			page=downloadPage("http://www.edk.org.pl/trasy.html");
			
			parseXml(page);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


		
		
		
		
	}
	
	public static String downloadPage(String hostName) throws Exception {
		URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    StringBuilder page = new StringBuilder();

	    try {
	        url = new URL(hostName);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

	        while ((line = br.readLine()) != null) {
	        	page.append(line);
				page.append("\n");
	        }
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
		return page.toString();
	}

	public static void parseXml(String page) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException, XPathExpressionException{
		String parser = "//tbody[@id='fbody']/tr";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		page = page.replaceAll( "&([^;]+(?!(?:\\w|;)))", "&amp;$1" );
		Document doc = (Document) builder.parse(new ByteArrayInputStream(page.getBytes("UTF-8")));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile(parser);
		
		System.out.println(expr.toString());
	}
	
	
	
}
