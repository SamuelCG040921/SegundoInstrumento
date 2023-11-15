
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	ModeloDatos miData;
	int cantPersonas,cantMayores,cantMenores;
	public Procesos() {
		miData = new ModeloDatos();
		iniciar();
	}

	private void iniciar() {
		cantPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas que desea ingresar"));
		for (int i = 0; i < cantPersonas; i++) {
			ingresarDatos();
		}
		
		miData.imprimirMapa();
		System.out.println("La cantidad de mayores de edad ingresados es: "+cantMayores);
		System.out.println("La cantidad de menores de edad ingresadis es: "+cantMenores);
		System.out.println("La cantidad total de personas ingresadas es: "+(cantMayores+cantMenores));
		System.out.println("La cantidad de personas a ingresar fue: "+cantPersonas);
		
	}
	
	public void ingresarDatos() {
		String documento,nombre,profesion;
		int edad;
		ArrayList<String> listaPersonas = new ArrayList<String>();
		documento = JOptionPane.showInputDialog("Ingrese su documento");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		profesion = JOptionPane.showInputDialog("Ingrese su profesion");
		edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
		validarEdad(edad);
		
		listaPersonas.add(documento);
		listaPersonas.add(nombre);
		listaPersonas.add(profesion);
		listaPersonas.add(edad+"");
		
		miData.guardarDatos(listaPersonas);
		
		System.out.println("Hola "+nombre+" con documento "+documento+" usted trabaja en "+profesion+" y tiene "+edad+" anios");
		
		
	}
	
	
	
	public void validarEdad(int edad) {
		if(edad >=18) {
			cantMayores++;
		}else if(edad<18) {
			cantMenores++;
		}
	
	}
}