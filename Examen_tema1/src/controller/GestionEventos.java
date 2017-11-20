package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_modificar,actionListener_numpalabras,actionListener_comparar, actionListener_buscar, actionListener_copiar, actionListener_guardar_Libro, actionListener_recuperar_Libro,actionListener_recuperar_todos;

	public GestionEventos(GestionDatos model, LaunchView view) {
		this.model = model;
		this.view = view;
	}

	public void contol() {
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		view.getComparar().addActionListener(actionListener_comparar);
		
		actionListener_modificar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_modificar();
			}
		};
		view.getBtnmodificar().addActionListener(actionListener_modificar);
		
		actionListener_numpalabras = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_numLetrasPalabras();
			}
		};
		view.getBtnnumpalabras().addActionListener(actionListener_numpalabras);

		actionListener_copiar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_copiarFichero();
			}
		};
		view.getCopiar().addActionListener(actionListener_copiar);
		
		
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				call_buscarPalabra();
			}
		};
		view.getBuscar().addActionListener(actionListener_buscar);
		
		actionListener_guardar_Libro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_guardar_Libro();
			}
		};
		
		view.getbtnGuardarLibro().addActionListener(actionListener_guardar_Libro);
		
		actionListener_recuperar_Libro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_recuperar_Libro();
			}
		};
		view.getbtnRecuperarLibro().addActionListener(actionListener_recuperar_Libro);
		
		actionListener_recuperar_todos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_recuperar_todos();
			}
		};
		view.getbtnRecuperarLibros().addActionListener(actionListener_recuperar_todos);
	}

	protected void call_modificar() {
	
		try {
			model.modificarAño(view.getTitulo().getText(), view.getAño().getText());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			view.showError("Hubo un error leyendo los ficheros");
		}
		
	}

	private void call_compararContenido() {
		
		String fichero1 = view.getFichero1().getText();
		String fichero2 = view.getFichero2().getText();
		boolean iguales;

		// TODO: Llamar a la función compararContenido de GestionDatos
		
		try {
			iguales = model.compararContenido(fichero1, fichero2);
			
			if(iguales)
				view.getTextArea().setText("Los ficheros son iguales");
			else
				view.getTextArea().setText("Los ficheros no son iguales");
			
			// TODO: Gestionar excepciones
		} catch (FileNotFoundException e) {
			if (fichero1.length() == 0) {
				view.showError("El campo \"Fichero 1\" está vacío");
		} else if (fichero2.length() == 0) {
				view.showError("El campo \"Fichero 2\" está vacío");
		} else
			view.showError("No existe el fichero \""+e.getMessage()+"\"");
			
		}catch (IOException e) {
			view.showError("Error");
		}

	}

	private void call_buscarPalabra() {
		String fichero1 = view.getFichero1().getText();
		String palabra = view.getPalabra().getText().trim();
		boolean primera_aparicion = view.getPrimera().isSelected();
		int resultado;

		// TODO: Llamar a la función buscarPalabra de GestionDatos

		
		try {
			resultado = model.buscarPalabra(fichero1, palabra, primera_aparicion);			
			if (resultado > 0) {
				if (primera_aparicion)
					view.getTextArea().setText("\""+palabra+"\""+" aparece por primera vez en la linea "+resultado);
				else
					view.getTextArea().setText("\""+palabra+"\""+" aparece por última vez en la linea "+resultado);
			} else if (resultado == -1) {
				view.getTextArea().setText("No se ha encontrado ninguna coincidencia");
			}
			
		}  catch (FileNotFoundException e) {
			if (fichero1.length() == 0)
			// TODO: Gestionar excepciones		
				view.showError("Introduce un nombre de fichero en el campo \"Fichero 1\"");
			else
				view.showError("No existe ningún fichero llamado \""+e.getMessage()+"\"");
		} catch (IOException e) {
			view.showError("Error");
		}
		
		
		
	}
	
	private void call_copiarFichero() {
		String fichero1 = view.getFichero1().getText();
		String fichero2 = view.getFichero2().getText();
		int bytesCopiados = 0;
		
		try {
			bytesCopiados = model.copiarFichero(fichero1, fichero2);
			view.getTextArea().setText("Nuevo fichero creado: \""+fichero2+"\". Se han copiado "+bytesCopiados+" bytes.");
		} catch (IOException e) {
			view.showError("Error");
		}
	}
	
	private void call_guardar_Libro() {
		String titulo,autor,año,editor,paginas;
		
		titulo = view.getTitulo().getText();
		autor = view.getAutor().getText();
		año = view.getAño().getText();
		editor = view.getEditor().getText();
		paginas = view.getPaginas().getText();
		
		
		if (titulo.length() != 0) {		
			try {
				model.guardar_Libro( titulo, autor, año, editor, paginas);
				view.getTextArea().setText("Libro creado \nTitulo: "+titulo+" Autor: "+autor+" Año: "+año+" Editor: "+editor+" Paginas: "+paginas);
			} catch (IOException e) {
				view.showError("Error");
			}
		} else
			view.showError("Rellena los campos");
		
	}
	
	private void call_recuperar_Libro()  {
		String titulo;
		ClaseLibro libro;
		
		titulo = view.getTitulo().getText();
		if (titulo.length() != 0) {		
			
	
				try {
					libro = model.recuperar_Libro(titulo);
					view.getTextArea().setText(libro.toString());
				} catch (ClassNotFoundException e) {
					view.getTextArea().setText("No se ha podido recuperar el libro");
				
				} catch (IOException e) {
					view.getTextArea().setText("Error");
					
				}
				
			
			}	
		}	
	
	private void call_recuperar_todos() {
		ArrayList<ClaseLibro> libros = new ArrayList<ClaseLibro>();
		StringBuilder resultado = new StringBuilder();

		try {
			libros = model.recuperar_todos();
			resultado.append(libros.size()+" Libros:\n");
			for (int i=0; i<libros.size(); i++){
				resultado.append("Titulo: ");
				resultado.append(libros.get(i).getTitulo()+"\n");
			}
			view.getTextArea().setText(resultado.toString());
		} catch (Exception e) {
			view.showError("Error");
		}
	}
	
	private void call_numLetrasPalabras() {
		try {
			view.getTextArea().setText(model.palabraMasLarga(view.getFichero1().getText()));
			
		}catch (IOException e) {
			view.showError("Error");
		}
		
	}
	}


