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
		String outputFile = "people.html";
		
		StreamSource xslcode = new StreamSource(new File(xslFile));
		StreamSource input = new StreamSource(new File(inputFile));
		StreamSource output = new StreamSource(new File(outputFile));

		TransformerFactory tf = TransformerFactory.newInstance();
		
		try
		{
			Transformer trans = tf.newTransformer(xslcode);
			trans.transform(input, (Result) output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("HTML File created succefully.\nCheck it under src with the name People.html ");	
		

	}

}
