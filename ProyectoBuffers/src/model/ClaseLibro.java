package model;

import java.io.Serializable;

public class ClaseLibro implements Serializable{
	
	private String id=null;
	private String titulo=null;
	private String autor=null;
	private String año=null;
	private String editor=null;
	private String paginas=null;
	
	
	public ClaseLibro(String id, String titulo, String autor, String año, String editor, String paginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.editor = editor;
		this.paginas = paginas;
	}
	
	@Override
	public String toString() {
		String infoLibro = "Titulo: "+titulo+"\n Autor: "+autor+"\n Año: "+año+"\n Editor: "+editor+"\n Páginas: "+paginas;
		return infoLibro;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	
	
			
	

}
