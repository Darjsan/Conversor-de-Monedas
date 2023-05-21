package Funciones;

public class FuncionesTemperatura {

	
	public double convertirTemp(double temp, String direccion) {
		double resultado=0;
		switch(direccion) {
        case "CentToFahr":
        	resultado=temp*1.8+32;
        	break;
        case "FahrToCent":
            resultado=(temp-32)/1.8;
            break;
        }
		return resultado;
	}
}
