package sinseraser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import org.w3c.*;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;

public class Downloader {

	

	
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

	
static String prepareXMLPage(String pageHTML) { 
	String result = ""; 
	Tidy tidy = new Tidy(); 
	tidy.setInputEncoding("UTF-8"); 
	tidy.setOutputEncoding("UTF-8"); 
	tidy.setWraplen(Integer.MAX_VALUE); 
	tidy.setPrintBodyOnly(true); 
	tidy.setXmlOut(true); 
	tidy.setSmartIndent(true);
	tidy.setQuiet(true);
	tidy.setShowErrors(0);
	tidy.setShowWarnings(false);
	tidy.setForceOutput(true);

	try (ByteArrayInputStream inputStream = 
			new ByteArrayInputStream(pageHTML.getBytes("UTF-8"));
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream())
	{
	    tidy.parseDOM(inputStream, outputStream);
		result = outputStream.toString("UTF-8");
	
	} catch (UnsupportedEncodingException e) {
	
	} catch (IOException e) {
	}
	
	StringBuilder builder = new StringBuilder();
	builder.append("<myroot>");
	builder.append(result);
	builder.append("</myroot>");

	return builder.toString();
}
	public static void parseXml(String page) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException, XPathExpressionException{
		String parser = "//tbody[@id='fbody']/tr";
		String parseLink = "//tbody[@id='fbody']/tr/td[1]/a/@href";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		org.w3c.dom.Document doc = builder.parse(new ByteArrayInputStream(page.getBytes("UTF-8")));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		
		
		
		
			
		NodeList test = (NodeList) xpath.compile(parser).evaluate(doc, XPathConstants.NODESET);
		NodeList links = (NodeList) xpath.compile(parseLink).evaluate(doc, XPathConstants.NODESET);
		System.out.println("liczba tras "+test.getLength()+" liczba linkow "+links.getLength());
		
		for(int i=0; i <test.getLength();i++){
			org.w3c.dom.Node nod = test.item(i);
			NodeList child = (NodeList) test.item(i);
			//System.out.println(child.item(1).getTextContent()+" "+child.item(3).getTextContent()+" "+child.item(5).getTextContent()+" "+child.item(7).getTextContent()+" "+child.item(9).getTextContent()+" "+links.item(i).getTextContent());

			for(int j=0; j<child.getLength(); j++){
				
				//System.out.println(child.item(1).getTextContent()+" "+child.item(3).getTextContent()+" "+child.item(5).getTextContent()+" "+child.item(7).getTextContent()+" "+child.item(9).getTextContent()+" "+links.item(i));
				TracksBase.tracksMap.put(i, new Track(child.item(1).getTextContent(),child.item(3).getTextContent(),child.item(5).getTextContent(),child.item(7).getTextContent(),child.item(9).getTextContent(),links.item(i).getTextContent() ));
				
			}
		}
		TracksBase.saveToFile();
		//System.out.println("ilosc tras "+test.getLength());
	}
	
	
	
}
