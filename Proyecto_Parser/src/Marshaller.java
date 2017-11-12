
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {
	
	private Document dom = null;
	private ArrayList<Libro> libros = null;


	public Marshaller(ArrayList<Libro> l) {
		libros = l;
	
	}

	public void crearDocumento() {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder db = dbf.newDocumentBuilder();


			dom = db.newDocument();		
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}

	}
	
	public void crearArbolDOM() {

		Element docEle = dom.createElement("libros");
		dom.appendChild(docEle);

	
		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
		
			Element Ele = setLibro(l);
			docEle.appendChild(Ele);
		}

	}
	
	private Element setLibro(Libro l) {

		Element Ele = dom.createElement("libro");
		

		

		Element tituloEle = dom.createElement("titulo");		
		Text tituloTexto = dom.createTextNode(l.getTitulo());
		tituloEle.appendChild(tituloTexto);
		Ele.appendChild(tituloEle);
		
		Attr añoEle = dom.createAttribute("anyo");		
		Text añoTexto = dom.createTextNode(l.getAño());
		añoEle.appendChild(añoTexto);
		tituloEle.setAttributeNode(añoEle);
		
		Element autorEle = dom.createElement("autor");		
		Text autorTexto = dom.createTextNode(l.getAutores());
		Ele.appendChild(autorEle);
		
		Element nombreEle = dom.createElement("nombre");		
		Text nombreTexto = dom.createTextNode(l.getListaAutores().get(0));
		nombreEle.appendChild(nombreTexto);
		
		
		Element nombreEle2 = dom.createElement("nombre");
		if(l.getListaAutores().size()>1){
			Text nombreTexto2 = dom.createTextNode(l.getListaAutores().get(1));
			nombreEle2.appendChild(nombreTexto2);
			autorEle.appendChild(nombreEle);
			autorEle.appendChild(nombreEle2);
		
		}else{
			autorEle.appendChild(nombreEle);
		}
		
		
		Element editorEle = dom.createElement("editor");		
		Text editorTexto = dom.createTextNode(l.getEditor());
		editorEle.appendChild(editorTexto);
		Ele.appendChild(editorEle);
		
		Element paginasEle = dom.createElement("paginas");		
		Text paginasTexto = dom.createTextNode(l.getPaginas());
		paginasEle.appendChild(paginasTexto);
		Ele.appendChild(paginasEle);
		
		return Ele;
	}
	

	public void escribirDocumentAXml(File file) throws TransformerException {

	
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

	
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);

	}

}