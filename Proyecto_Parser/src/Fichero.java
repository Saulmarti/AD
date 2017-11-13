import java.io.Serializable;
import java.util.ArrayList;

public class Fichero implements Serializable {

	private String nombre=null;
	ArrayList <String> cantidad=null;
	ArrayList <String> precio=null;
	
	
	public Fichero(String nombre, ArrayList <String> cantidad, ArrayList <String> precio) {
		
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.precio=precio;
		
	}
	
	
	public Fichero() {
	

	}

	
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public ArrayList<String> getCantidad() {
		return cantidad;
	}


	

	public ArrayList<String> getPrecio() {
		return precio;
	}
	
	public String getListaCantidad() {
			
			StringBuilder listaCantidad = new StringBuilder();
			
			for(int i=0; i<cantidad.size(); i++) {
				listaCantidad.append(cantidad.get(i));
				if(!(cantidad.size() ==  (i+1))) {
					listaCantidad.append(", ");
				}
			}
			
			return listaCantidad.toString();
		}
	
	public StringBuilder getListaPrecio() {
		
		StringBuilder listaPrecio = new StringBuilder();
		
		for(int i=0; i<precio.size(); i++) {
			listaPrecio.append(precio.get(i));
			if(!(precio.size() ==  (i+1))) {
				listaPrecio.append(", ");
			}
		}
		
		return listaPrecio;
	}


	
	public void print() {
		System.out.println("Nombre: "+nombre+", Cantidad: "+getListaCantidad()+" Precio: "+getListaPrecio());
		
	}

}
