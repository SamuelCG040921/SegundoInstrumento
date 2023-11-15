
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	ModeloDatos miData;
	double descuentoFormula;
	public Procesos() {
		miData = new ModeloDatos();
		iniciar();
	}

	private void iniciar() {
			String msj = "Desea ingresar otro empleado? \n";
			msj+= "1. Si \n";
			msj+= "2. No \n";
			msj+= "Ingrese su opcion";
			int opcion;
			do {
				ingresarDatos();
				opcion = Integer.parseInt(JOptionPane.showInputDialog(msj));
			} while (opcion != 2 );
			miData.imprimirMapa();
		
		}
		
	
	public void ingresarDatos() {
		String documento,nombre;
		double salario, descuento;
		int estrato;
		ArrayList<String> listaPersonas = new ArrayList<String>();
		documento = JOptionPane.showInputDialog("Ingrese su documento");
		nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		estrato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su estrato entre 1 y 6: "));
		salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su salario actual: "));
		descuento = calcularDescuento(estrato,salario);
		
		
		
		listaPersonas.add(documento);
		listaPersonas.add(nombre);
		listaPersonas.add(estrato+"");
		listaPersonas.add(salario+"");
		listaPersonas.add(descuento+"");
		
		miData.guardarDatos(listaPersonas);
		
		System.out.println("Hola "+nombre+" con documento "+documento+" usted es de estrato "+estrato+", su salario es $"+salario+" y su descuento es de $"+descuento);
		
		
	}
	
	
	
	public double calcularDescuento(int estrato, double salario) {
		if(estrato >=1 && estrato <=2) {
			descuentoFormula = salario * 0.02;
		}else if(estrato>=3 && estrato <=4) {
			descuentoFormula = salario * 0.04;
		}else if(estrato == 5) {
			descuentoFormula = salario * 0.08;
		}else if(estrato == 6) {
			descuentoFormula = salario * 0.10;
		}
		return descuentoFormula;
	}
}