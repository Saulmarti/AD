package dir;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		

		comparar("","");
	}
	
	
	public static void localizar(){
		
	}
	
	public static void comparar(String fichero1, String fichero2){
		File f1 = new File(fichero1);
		int total1 = 0;
		File f2 = new File(fichero1);
		int total2 = 0;
		
		String[] arrArchivos1 = f1.list();
		 total1 = arrArchivos1.length;
		
		String[] arrArchivos2 = f2.list();
		 total2 = arrArchivos2.length;
		 
		if(total1>total2) {
			System.out.println("El directorio "+fichero1+" contiene más ficheros.");	
		}else if(total2>total1) {
			System.out.println("El directorio "+fichero2+" contiene más ficheros.");
			
		}else {
			System.out.println("Los dos directorios contienen los mismos ficheros.");
		}
		
	}

}
