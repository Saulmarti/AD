import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

public class Parser_Libro {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		do{
		System.out.println("1:Parsear      2:Serializar");
		num = teclado.nextInt();
		if(num==1){
			parsear();
			
		}else if(num==2){
			serializar();
		}else{System.out.println("Número incorrecto");}
	}while(num==0 || num!=3);
		}

	private static void serializar() {	
		Scanner teclado = new Scanner(System.in);
		
		String titulo=null,año=null,editor=null,paginas=null,autor=null,fichero=null;
		ArrayList <String> autores= new ArrayList<String>();
		
		System.out.println("Introduce el titulo del libro: ");
		titulo=teclado.nextLine();
		
		System.out.println("Introduce el autor del libro: ");
		autor=teclado.nextLine();
		autores.add(autor);

		System.out.println("Introduce el año del libro: ");
		año=teclado.nextLine();
		
		System.out.println("Introduce el editor del libro: ");
		editor=teclado.nextLine();
		
		System.out.println("Introduce las paginas del libro: ");
		paginas=teclado.nextLine();

		ArrayList<Libro> libros= new ArrayList<Libro>();
		
		System.out.println("Introduce el nombre en el que guardar: ");
		fichero=teclado.nextLine();
		
		
		libros.add(new Libro(titulo,autores,año,editor,paginas));
		
	Marshaller marshaller=new Marshaller(libros);
	marshaller.crearDocumento();
	marshaller.crearArbolDOM();
	
	File file = new File(fichero);
	try {
		marshaller.escribirDocumentAXml(file);
	} catch (TransformerException e) {
	
		e.printStackTrace();
	}
	}

	private static void parsear() {
		
		Scanner teclado = new Scanner(System.in);
		
		String fichero=null;
		
		System.out.println("Introduce el nombre del fichero a parsear: ");
		fichero=teclado.nextLine();
		
		Parser parser=new Parser();
		parser.parseFicheroXml(fichero);
		parser.parseDocument();
		parser.print();
		
	}
	

}


