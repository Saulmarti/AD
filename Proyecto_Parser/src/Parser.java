import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	
	private Document dom=null;
	private ArrayList<Libro> libros=null;
	
	public Parser() {
		libros = new ArrayList<Libro>();
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
				
				libros.add(l);
			}
			
		}
		
	
	}

	private Libro getLibro(Element libroEle) {
		
		String titulo = getTextValue(libroEle,"titulo");
		String autor = getTextValue(libroEle,"autor");
		String año = getTextValue(libroEle,"anyo");
		String editor = getTextValue(libroEle,"editor");
		String paginas = getTextValue(libroEle,"paginas");
		
		Libro e = new Libro( titulo, autor, año, editor, paginas );
		
		return e;
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
		
		Iterator it = libros.iterator();
		while(it.hasNext()) {
			Libro l=(Libro) it.next();
			l.print();
		}
	}

	}


