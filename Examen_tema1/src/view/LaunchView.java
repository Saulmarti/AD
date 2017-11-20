package view;

import java.awt.Dimension;

import javax.swing.*;

public class LaunchView extends JFrame {

	private JButton btnmodificar,btnnumpalabras,comparar,buscar,copiar,btnGuardarLibro,btnRecuperarLibro,btnRecuperarLibros;
	private JTextArea textArea;
	private JTextField fichero1,fichero2,palabra,titulo,autor,año,editor,paginas,numpalabras;
	private JLabel label_numpalabras,label_f1,label_f2,label_pal,label_titulo,label_autor,label_año,label_editor,label_paginas;
	private JCheckBox primera;
	
	private JPanel panel;
	
	public LaunchView() {
		
		setBounds(200,200,1000,450);
		setTitle("Proyecto Buffers");	
		panel = new JPanel();
		
		comparar = new JButton("Comparar contenido");
		comparar.setPreferredSize(new Dimension(150, 26));
		
		btnnumpalabras = new JButton("Numero palabras");
		btnnumpalabras.setPreferredSize(new Dimension(150, 26));
		
		buscar = new JButton("Buscar palabra");
		buscar.setPreferredSize(new Dimension(150, 26));
		
		copiar = new JButton("Copiar fichero");
		copiar.setPreferredSize(new Dimension(150, 26));
		
		btnGuardarLibro = new JButton("Guardar libro");
		btnGuardarLibro.setPreferredSize(new Dimension(150, 26));
		
		btnmodificar = new JButton("Modificar libro");
		btnmodificar.setPreferredSize(new Dimension(150, 26));
		
		btnRecuperarLibro = new JButton("Recuperar libro");
		btnRecuperarLibro.setPreferredSize(new Dimension(150, 26));
		
		btnRecuperarLibros = new JButton("Recuperar todos los libros");
		btnRecuperarLibros.setPreferredSize(new Dimension(200, 26));
					
		fichero1 = new JTextField("",10);
		fichero2 = new JTextField("",10);
		palabra = new JTextField("",10);
		titulo = new JTextField("",10);
		autor = new JTextField("",10);
		año = new JTextField("",10);
		editor = new JTextField("",10);
		paginas = new JTextField("",10);
		numpalabras = new JTextField("",10);
		
		label_f1 = new JLabel("Fichero 1:");
		label_f2 = new JLabel("Fichero 2:");
		label_pal = new JLabel("Palabra:");
		label_titulo = new JLabel("Titulo:");
		label_autor = new JLabel("Autor:");
		label_año = new JLabel("Año:");
		label_editor = new JLabel("Editor:");
		label_paginas = new JLabel("Paginas:");
		label_numpalabras = new JLabel("N letras:");
		
		
		
		primera = new JCheckBox("Primera aparición");

		textArea = new JTextArea(20, 80);
		textArea.setBounds(50,50,50,50);
		textArea.setEditable(false);		
		
		panel.add(comparar);
		panel.add(buscar);
		panel.add(copiar);
		panel.add(label_f1);
		panel.add(fichero1);
		panel.add(label_f2);
		panel.add(fichero2);
		panel.add(label_pal);
		panel.add(palabra);
		panel.add(primera);
		panel.add(btnGuardarLibro);
		panel.add(btnRecuperarLibro);
		panel.add(label_titulo);
		panel.add(titulo);
		panel.add(label_autor);
		panel.add(autor);
		panel.add(label_año);
		panel.add(año);
		panel.add(label_editor);
		panel.add(editor);
		panel.add(label_paginas);
		panel.add(paginas);
		panel.add(btnRecuperarLibros);
		panel.add(label_numpalabras);
		panel.add(numpalabras);
		panel.add(btnnumpalabras);
		panel.add(btnmodificar);
		panel.add(textArea);
	
		
	
		
        // Añadimos el JPanel al JFrame
        this.getContentPane().add(panel);		
		
	}	
	
	public JButton getbtnGuardarLibro() {
		return btnGuardarLibro;
	}

	public void setbtnGuardarLibro(JButton guardarLibro) {
		this.btnGuardarLibro = guardarLibro;
	}

	public JButton getbtnRecuperarLibro() {
		return btnRecuperarLibro;
	}

	public void setbtnRecuperarLibro(JButton recuperarLibro) {
		this.btnRecuperarLibro = recuperarLibro;
	}
	
	public JButton getbtnRecuperarLibros() {
		return btnRecuperarLibros;
	}

	public void setbtnRecuperarLibros(JButton recuperarLibros) {
		this.btnRecuperarLibros = recuperarLibros;
	}

	public JButton getComparar() {
		return comparar;
	}

	public void setComparar(JButton comparar) {
		this.comparar = comparar;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
			
	public JTextField getFichero1() {
		return fichero1;
	}

	public void setFichero1(JTextField fichero1) {
		this.fichero1 = fichero1;
	}

	public JTextField getFichero2() {
		return fichero2;
	}

	public void setFichero2(JTextField fichero2) {
		this.fichero2 = fichero2;
	}
	
	public JTextField getPalabra() {
		return palabra;
	}

	public void setPalabra(JTextField palabra) {
		this.palabra = palabra;
	}
	public JCheckBox getPrimera() {
		return primera;
	}

	public void setPrimera(JCheckBox primera) {
		this.primera = primera;
	}
	
	public JButton getCopiar() {
		return copiar;
	}

	public void setCopiar(JButton copiar) {
		this.copiar = copiar;
	}


	public JTextField getTitulo() {
		return titulo;
	}

	public void setTitulo(JTextField titulo) {
		this.titulo = titulo;
	}

	public JTextField getAutor() {
		return autor;
	}

	public void setAutor(JTextField autor) {
		this.autor = autor;
	}

	public JTextField getAño() {
		return año;
	}

	public void setAño(JTextField año) {
		this.año = año;
	}

	public JTextField getEditor() {
		return editor;
	}

	public void setEditor(JTextField editor) {
		this.editor = editor;
	}

	public JTextField getPaginas() {
		return paginas;
	}

	public void setPaginas(JTextField paginas) {
		this.paginas = paginas;
	}

	public void showError(String m){
		JOptionPane.showMessageDialog(this.panel,
			    m,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}

	public JButton getBtnnumpalabras() {
		return btnnumpalabras;
	}

	public void setBtnnumpalabras(JButton btnnumpalabras) {
		this.btnnumpalabras = btnnumpalabras;
	}

	public JTextField getNumpalabras() {
		return numpalabras;
	}

	public void setNumpalabras(JTextField numpalabras) {
		this.numpalabras = numpalabras;
	}

	public JButton getBtnmodificar() {
		return btnmodificar;
	}

	public void setBtnmodificar(JButton btnmodificar) {
		this.btnmodificar = btnmodificar;
	}


}
