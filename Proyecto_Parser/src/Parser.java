import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	
	private Document dom=null;
	private ArrayList<Libro> biblioteca=null;
	
	public Parser() {
		biblioteca = new ArrayList<Libro>();
	}

	public void parseFicheroXml (String fichero) {
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
			try {
				DocumentBuilder db=dbf.newDocumentBuilder();
				 dom = db.parse(fichero);
			} catch (SAXException e) {	
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			
		}
	
	public void parseDocument() {
		
		Element docEle = dom.getDocumentElement();	
		NodeList n1 = docEle.getElementsByTagName("libro");
		
		if (n1 !=null && n1.getLength() > 0 ) {
			for (int i=0; i < n1.getLength(); i++) {
				
				Element el = (Element) n1.item(i);
				
				Libro l = getLibro(el);
				
				biblioteca.add(l);
			}
			
		}
		
	
	}

	private Libro getLibro(Element libroEle) {
		
		String titulo = getTextValue(libroEle,"titulo");
		ArrayList <String> autor = getArrayValue(libroEle,"autor","nombre");
		String año = getAttribute(libroEle,"titulo", "anyo");
		String editor = getTextValue(libroEle,"editor");
		String paginas = getTextValue(libroEle,"paginas");
		
		Libro e = new Libro( titulo, autor, año, editor, paginas );
		
		return e;
	}
	
	


	private ArrayList<String> getArrayValue(Element ele, String tagName, String tagSubName) {
		ArrayList <String> autor = new ArrayList();
		String textVal=null;
		NodeList nl = ele.getElementsByTagName(tagName);
		
		if(nl != null && nl.getLength() > 0) {
			
			for(int i=0;i<nl.getLength();i++){
				
			Element el = (Element)nl.item(i);	
			NodeList nl2 = ele.getElementsByTagName(tagSubName);
		
		if(nl2 != null && nl2.getLength() > 1){
			for(int e=0;e<nl2.getLength();e++){
			Element nombre = (Element) nl2.item(e);
			
			textVal = nombre.getFirstChild().getNodeValue();
			autor.add(textVal);}}}
		}
		
		
		return autor;
	}

	private String getAttribute(Element ele, String tagName, String tagAtt) {
		String textVal=null;
		
		NodeList nl = ele.getElementsByTagName(tagName);
	
		if(nl != null && nl.getLength() > 0) {
			Node AttNode = nl.item(0);
			Element AttElement = (Element) AttNode;
			textVal = AttElement.getAttribute(tagAtt);
		}
		
		
		return textVal;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal=null;
		
		NodeList nl = ele.getElementsByTagName(tagName);
		
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		
		
		return textVal;
	}
		
	
	public void print() {
		
		Iterator it = biblioteca.iterator();
		while(it.hasNext()) {
			Libro l=(Libro) it.next();
			l.print();
		}
	}

	}


