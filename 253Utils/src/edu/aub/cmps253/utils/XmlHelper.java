package edu.aub.cmps253.utils;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlHelper {
	File file;
	DocumentBuilderFactory documentBuilderFactory;
	DocumentBuilder documentBuilder;
	org.w3c.dom.Document document;
	
	public XmlHelper(String fileName){
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			file = new File(fileName);
			document = documentBuilder.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getElement(String element){
		return document.getElementsByTagName(element).item(0).getTextContent();
	}
}