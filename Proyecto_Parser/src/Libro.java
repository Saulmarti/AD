

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Libro implements Serializable{
	
	
	private String titulo=null;
	ArrayList <String> autores=null;
	private String año=null;
	private String editor=null;
	private String paginas=null;
	
	
	public Libro(String titulo, ArrayList <String>  autores, String año, String editor, String paginas) {
		super();
		
		this.titulo = titulo;
		this.autores = autores;
		this.año = año;
		this.editor = editor;
		this.paginas = paginas;
	}
	
	
	public Libro() {
	
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList <String> getListaAutores() {
		
		return autores;
	}
	
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}



	public String getAutores() {
		
		StringBuilder listaAutores = new StringBuilder();
		
		for(int i=0; i<autores.size(); i++) {
			listaAutores.append(autores.get(i));
			if(!(autores.size() ==  (i+1))) {
				listaAutores.append(", ");
			}
		}
		
		return listaAutores.toString();
	}
	
public void print() {
		
		System.out.println("Titulo: "+titulo+" Autor: "+getAutores()+" Año: "+año+" Editor: "+editor+" Paginas: "+paginas);
		
	}
	
	
}
	
	
	
			
	