

import java.io.Serializable;

public class Libro implements Serializable{
	
	
	private String titulo=null;
	private String autor=null;
	private String a�o=null;
	private String editor=null;
	private String paginas=null;
	
	
	public Libro(String titulo, String autor, String a�o, String editor, String paginas) {
		super();
		
		this.titulo = titulo;
		this.autor = autor;
		this.a�o = a�o;
		this.editor = editor;
		this.paginas = paginas;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getA�o() {
		return a�o;
	}
	public void setA�o(String a�o) {
		this.a�o = a�o;
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

	public void print() {
		System.out.println("Titulo: "+titulo+" Autor: "+autor+" A�o: "+a�o+" Editor: "+editor+" Paginas: "+paginas);
		
	}
	
	
}
	
	
	
			
	