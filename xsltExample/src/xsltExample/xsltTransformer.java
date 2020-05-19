package xsltExample;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class xsltTransformer 
{

	public static void main(String[] args)
	{
		String xslFile = "xmltoHtml.xsl";
		String inputFile = "people.xml";
		String outputFile = "People.html";
		
		
		StreamSource xslcode = new StreamSource(new File(xslFile));
		Source input = new StreamSource(new File(inputFile));
		Result output = new StreamResult(new File(outputFile));

		TransformerFactory tf = TransformerFactory.newInstance();
		try
		{
		
			Transformer trans = tf.newTransformer(xslcode);
			trans.transform(input, output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("HTML File created succefully under src with the name People.html");	
		
		
	}

}
