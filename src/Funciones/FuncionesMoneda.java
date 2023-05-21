package Funciones;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class FuncionesMoneda {

	Map<String, Double> tipoMonedas;
		
	public double ConvertirMoneda (double cantidad, String monedaInicial, String monedaFinal ) {
		double resultado=0;
		tipoMonedas = new HashMap<>();
		
		// Se declara lo que cada unidad de moneda extranjera equivale en pesos Mexicanos
		tipoMonedas.put("Pesos Mx", 1.0);
		tipoMonedas.put("Dólares", 17.8);
		tipoMonedas.put("Euros", 19.26);
		tipoMonedas.put("Libras", 22.15);
		tipoMonedas.put("Yen", 0.13);
		tipoMonedas.put("Won", 0.013);	
		
		resultado=cantidad*tipoMonedas.get(monedaInicial)/tipoMonedas.get(monedaFinal);
		return resultado;
	}
	
	public double[] informa(String monedaInicial, String monedaFinal) {
		double[] info = {0,0};
		info[0]=ConvertirMoneda(1, monedaInicial, monedaFinal);
		info[1]=ConvertirMoneda(1, monedaFinal, monedaInicial);
		
		return info;
		
	}
}

