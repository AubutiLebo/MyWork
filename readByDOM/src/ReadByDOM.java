

import java.io.File;

//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadByDOM
{

	public static void main(String[] args)
	{
		try
		{
			File xmlDoc = new File("people.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("person");
			for(int i = 0; i < nList.getLength(); i++)
			{
				Node nNode = nList.item(i);
				System.out.println("Node name : " + nNode.getNodeName() + " " + (i + 1));
				if(nNode.getNodeType() == Node.ELEMENT_NODE)
				{
					Element eElement = (Element)nNode;
					System.out.println("Person ID Number : " + eElement.getAttribute("idNum"));
					System.out.println("Person 1st Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Person last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Person age : " + eElement.getElementsByTagName("age").item(0).getTextContent());
					System.out.println("Person Occupation : " + eElement.getElementsByTagName("occupation").item(0).getTextContent());



					System.out.println("-------------------------------------------------");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());

		}

	}

}
