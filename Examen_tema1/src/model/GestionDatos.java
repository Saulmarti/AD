package model;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionDatos {


	public GestionDatos() {

	}

	//TODO: Implementa una funci�n para abrir ficheros
	private BufferedReader abrirFichero(File fichero) throws FileNotFoundException, IOException {
		if(puedeLeer(fichero)) 
			return new BufferedReader(new FileReader(fichero));
		else
			
			throw new IOException(); 
	}
	
	
	private boolean puedeLeer(File fichero) {
		// TODO Auto-generated method stub
	
		return fichero.canRead();
	}

	//TODO: Implementa una funci�n para cerrar ficheros
	
	private void cerrarFichero(BufferedReader bf) throws IOException {
		bf.close();
	}	
		

	
	
	public boolean compararContenido (String fichero1, String fichero2)throws IOException{
		
		File f1 = new File(fichero1);
		File f2 = new File(fichero2);
		
		boolean iguales = false;
		
		if (!existeFichero(f1))
			throw new FileNotFoundException(f1.getName());
		
		if (!existeFichero(f2))
			throw new FileNotFoundException(f2.getName());
		
		if (tama�oFichero(f1) == tama�oFichero(f2)) {
			BufferedReader br1 = abrirFichero(f1);
			BufferedReader br2 = abrirFichero(f2);
			// Comparamos el contenido de los ficheros linea a linea
			iguales = compararLineas(br1, br2);
			cerrarFichero(br1);
			cerrarFichero(br2);
		}
		
		return false;
		
		
		
		
		 
	}
	
	private Object tama�oFichero(File fichero) {
		// TODO Auto-generated method stub
		return fichero.length() ;
	}

	private boolean compararLineas(BufferedReader br1, BufferedReader br2) {
		// TODO Auto-generated method stub
		String lineaF1;
		String lineaF2;
		
		try {
			while (((lineaF1 = br1.readLine()) != null) && ((lineaF2 = br2.readLine())!= null)) {
				if (!lineaF1.equals(lineaF2))
					return false;  
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;

	}

	private boolean existeFichero(File fichero) {
		// TODO Auto-generated method stub
		return fichero.exists();
	}

	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws FileNotFoundException, IOException{
		//TODO: Implementa la funci�n
		File f1 = new File(fichero1);
		String linea;
		int contador = 0;
		int ultima_aparicion = 0;
		
		if( !existeFichero(f1) )
			try {
				throw new FileNotFoundException(f1.getName());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			BufferedReader br1 = abrirFichero(f1);
		
		
		while ((linea = br1.readLine() ) !=null ){
			contador++;
			if(linea.equalsIgnoreCase(palabra)){
				if(primera_aparicion){
					return contador;
				}else{
					ultima_aparicion = contador;
				}
			}else
				ultima_aparicion = -1;
		}
		
		return ultima_aparicion;
	}	
	
	public int copiarFichero(String entrada, String salida) throws IOException {
        FileInputStream fi;       
        FileOutputStream fo;
        int bytesRead = 0;
        int bytesCopiados = 0;
        byte[] buffer;
        
    
        fi = new FileInputStream(entrada);
        fo = new FileOutputStream(salida);
        
                 
        buffer = new byte[4096];
        while( (bytesRead = fi.read(buffer)) != -1 ){
        		bytesCopiados = bytesRead;
        		fo.write(buffer, 0, bytesRead);
        }
        
        fi.close();
        fo.close();
		return bytesCopiados;  
        
        
	}
	
	public void guardar_Libro(String titulo, String autor, String a�o, String editor, String paginas) throws IOException {
		ClaseLibro libro = new ClaseLibro(titulo, autor, a�o, editor, paginas);
		FileOutputStream fo = null;
		ObjectOutputStream salida = null;
			

		fo = new FileOutputStream("Libros\\"+titulo);
		salida = new ObjectOutputStream(fo);

		salida.writeObject(libro);
	
		if (fo != null)
			System.err.println("Guardado");
			fo.close();
		if (salida != null)
			System.err.println("Guardado2");
			salida.close();
	}
	
	
	public ClaseLibro recuperar_Libro(String id) throws IOException, ClassNotFoundException {
		FileInputStream fi = null;
		ObjectInputStream entrada = null;
		ClaseLibro libro = null;

		fi = new FileInputStream("Libros\\"+id);
		entrada = new ObjectInputStream(fi);
	
		libro = (ClaseLibro) entrada.readObject();
	
		if (fi != null)
			fi.close();
		System.err.println("Recuperado");
		if (entrada != null)
			System.err.println("Recuperado2");
			entrada.close();	
	
		return libro;
	}

	public void Cerrar(Closeable Cerrar) {
		try {
			if (Cerrar != null) {
				Cerrar.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

	public ArrayList<ClaseLibro> recuperar_todos() {
		File file = new File("Libros");
		File[] ficheros;
		
		ArrayList<ClaseLibro> libros = new ArrayList<ClaseLibro>();
		ficheros = file.listFiles();
		for (int i=0; i<ficheros.length; i++){
			try {
				libros.add(recuperar_Libro(ficheros[i].getName()));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return libros;		
	}
	public String palabraMasLarga(String fichero1) throws IOException {
		
		String palabra = null;
		String palabra2=null;
		String palabraes=null;
		int num=0;
		
		File file = new File(fichero1);
		Scanner sc = null;
		sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			 Scanner sc2 = new Scanner(sc.nextLine()); 
			 
			 palabra = sc2.next();
			 num=palabra.length();
			 
			 while (sc2.hasNext()){
				 
				 palabra2 = sc2.next();			 
				 
				 if(palabra2.length()>num){								 
					 System.out.println(palabra2);
						palabraes=palabra2;
				 }else{
					 System.out.println(palabra);
					 palabraes= palabra;
				 }}
			 }
		
		return palabraes;

}
	
	public void modificarA�o(String fichero, String nuevoA�o) throws IOException, ClassNotFoundException {

		ClaseLibro libro = recuperar_Libro(fichero);

		libro.setA�o(nuevoA�o);
		File f = new File("Libros\\"+fichero);
		f.delete();
		
		guardar_Libro(libro.getTitulo(),libro.getAutor(),libro.getA�o(),libro.getEditor(),libro.getPaginas());

	}
	
}

