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

public class ParserFichero {
	private Document dom=null;
	private ArrayList<Fichero> acciones=null;
	
	public ParserFichero() {
		acciones = new ArrayList<Fichero>();
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
		NodeList n1 = docEle.getElementsByTagName("accion");
		
		if (n1 !=null && n1.getLength() > 0 ) {
			for (int i=0; i < n1.getLength(); i++) {
				
				Element el = (Element) n1.item(i);
				
				Fichero l = getFichero(el);
				
				acciones.add(l);
			}
			}
		
			
		}
		
	
	

	private Fichero getFichero(Element ficheroEle) {
		
		String nombre = getTextValue(ficheroEle,"nombre");
		ArrayList <String> cantidad = getArrayValue(ficheroEle,"compra","cantidad");
		ArrayList <String> precio = getArrayValue(ficheroEle,"compra","precio");
		
		Fichero e = new Fichero(nombre,cantidad,precio);
		
		return e;
	}
	
	


	private ArrayList<String> getArrayValue(Element ele, String tagName, String tagSubName) {
		ArrayList <String> accion = new ArrayList();
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
			accion.add(textVal);}}}}
		
		
		
		return accion;
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
		
		Iterator it = acciones.iterator();
		while(it.hasNext()) {
			Fichero l=(Fichero) it.next();
			l.print();
		}
	}

	}
