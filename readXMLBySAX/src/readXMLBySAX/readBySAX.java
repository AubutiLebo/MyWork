package readXMLBySAX;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class readBySAX extends DefaultHandler
{
	
	public void startDocument()
	{
		System.out.println("Document Starts here.");
	}
	
	public void startElement(String url, String localName, String qName, Attributes attribute)
	{
		System.out.println("<" + qName + ">");
	}
	public void characters(char[] ch, int start, int length)
	{
		System.out.println(new String(ch, start,length));

	}
	
	public void endElement(String url, String localName, String qName)
	{
		System.out.println("</" + qName + ">");
	}
	
	public void endDocument()
	{
		System.out.println("Document Ends here.");
	}


	public static void main(String[] args) throws Exception
	{
		SAXParserFactory fact = SAXParserFactory.newInstance();
		SAXParser saxParser = fact.newSAXParser();
		saxParser.parse(new FileInputStream("people.xml"), new readBySAX());
		
		
	}

}
