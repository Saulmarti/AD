import java.util.ArrayList;

public class Taller {
	
	String nombre;
	ArrayList<Coche> coches = new ArrayList<Coche>();
	private Coche c = new Coche() ;
	ArrayList<String> direccion= new ArrayList<String>();
	
	public void print(){
		System.out.println(""+getNombre()+""+c.print()+""+getDireccion());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

	public void setCoches(ArrayList<Coche> coches) {
		this.coches = coches;
	}

	public ArrayList<String> getDireccion() {
		return direccion;
	}

	public void setDireccion(ArrayList<String>  direccion , String nombre2, String poblacion) {
		this.direccion = direccion;
		nombre2=nombre2;
		poblacion=poblacion;
	}

}
