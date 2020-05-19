//import javax.swing.text.Document;
//import javax.lang.model.element.Element;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.w3c.dom.Element;

public class generateXML 
{

	public static void main(String[] args) throws Exception 
	{
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = fact.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element rootElement = doc.createElement("employees");
		Element employeeElement = doc.createElement("employee");
		Element nameElement = doc.createElement("name");
		Element surnameElement = doc.createElement("surname");
		Element IDElement = doc.createElement("ID");
		Element cellElement = doc.createElement("cell");
		Element emailElement = doc.createElement("email");
		
		Text t1 = doc.createTextNode("Lawrence");
		Text t2 = doc.createTextNode("Newman");
		Text t3 = doc.createTextNode("44674");
		Text t4 = doc.createTextNode("0837242844");
		Text t5 = doc.createTextNode("lawrence.new@gmail.com");
		
		nameElement.appendChild(t1);
		surnameElement.appendChild(t2);
		IDElement.appendChild(t3);
		cellElement.appendChild(t4);
		emailElement.appendChild(t5);
		
		employeeElement.appendChild(nameElement);
		employeeElement.appendChild(surnameElement);
		employeeElement.appendChild(IDElement);
		employeeElement.appendChild(cellElement);
		employeeElement.appendChild(emailElement);
		
		rootElement.appendChild(employeeElement);
		doc.appendChild(rootElement);
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("C:\\Users\\Aubuti Lebo\\eclipse-workspace\\GeneratingXML\\bin\\employees.xml")));
		
		System.out.println("XML Generated.Check it under C:\\Users\\Aubuti Lebo\\eclipse-workspace\\GeneratingXML\\bin\\employees.xml");
	}

}
