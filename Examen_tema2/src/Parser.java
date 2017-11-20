
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

	private Document dom = null;
	private ArrayList<Taller> concesionarios = new ArrayList<Taller>();

	public Parser() {
		
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();		
		NodeList n1 = docEle.getElementsByTagName("taller");
		
		if (n1 !=null && n1.getLength() > 0 ) {
			for (int i=0; i < n1.getLength(); i++) {				
				Element elTaller = (Element) n1.item(i);			
				Taller taller = new Taller();
				NodeList n2 = elTaller.getElementsByTagName("nombre");
				
				if (n2 !=null && n2.getLength() > 0 ){
					Element elNombre = (Element) n2.item(0);
					String nombre = elNombre.getFirstChild().getNodeValue();
					System.out.println(nombre);
					taller.setNombre(nombre);}

					
					NodeList n3 = elTaller.getElementsByTagName("direccion");
					
					if (n3 !=null && n3.getLength() > 0 ) {
										
							Element elDireccion = (Element) n3.item(0);		
							
							NodeList n4 = elDireccion.getElementsByTagName("nombre");
				
							if (n4 !=null && n4.getLength() > 0 ) {
												
									Element elNombre2 = (Element) n4.item(0);
									String nombre2 = elNombre2.getFirstChild().getNodeValue();
									System.out.println(nombre2);
									taller.getDireccion().add(nombre2);}
									
									NodeList n5 = elTaller.getElementsByTagName("poblacion");
									
									if (n5 !=null && n5.getLength() > 0 ) {
												
											Element elPoblacion = (Element) n5.item(0);
											String poblacion = elPoblacion.getFirstChild().getNodeValue();
											System.out.println(poblacion);
											taller.getDireccion().add(poblacion);}}
				
						
					NodeList n6 = elTaller.getElementsByTagName("coches");
					if (n6 !=null && n6.getLength() > 0 ) {										
							Element elCoches = (Element) n6.item(0);										
							NodeList n7 = elCoches.getElementsByTagName("coche");
						
							if (n7 !=null && n7.getLength() > 0 ) {
								for (int j=0; j < n7.getLength(); j++) {				
									Element elCoche = (Element) n7.item(j);			
									Coche coche = new Coche();
									NodeList n8 = elCoche.getElementsByTagName("marca");
									
									if (n8 !=null && n8.getLength() > 0 ) {
										
										Element elMarca = (Element) n8.item(0);
										String marca = elMarca.getFirstChild().getNodeValue();
										coche.setMarca(marca);
										System.out.println(marca);}
									
									NodeList n9 = elCoche.getElementsByTagName("modelo");
									
									if (n9 !=null && n9.getLength() > 0 ) {
										
										Element elModelo = (Element) n9.item(0);
										String modelo = elModelo.getFirstChild().getNodeValue();
										System.out.println(modelo);
										coche.setModelo(modelo);}
									
								
								}
						}
			
			}
					concesionarios.add(taller);}
			
			}
			
		}
			
	
	public void print() {

		Iterator it = concesionarios.iterator();
		while (it.hasNext()) {
			Taller t = (Taller) it.next();
			t.print();
			System.out.println("\n");
		}
	}	
		
		
}
