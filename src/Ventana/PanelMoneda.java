package Ventana;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Funciones.*;
import java.awt.event.ActionEvent;

public class PanelMoneda extends JFrame {

	public JTextField cantidad;
	public JPanel panelMonedas;
	public JComboBox monedaInicial = new JComboBox();
	public JComboBox monedaFinal = new JComboBox();
	public JLabel resultadoMoneda;
	public FuncionesMoneda funcion =new FuncionesMoneda();
	public JLabel infoMonedas1;
	public JLabel infoMonedas2;
	public double[] informa;

	
	public PanelMoneda() {
		panelMonedas = new JPanel();
		panelMonedas.setVisible(true);
		panelMonedas.setBounds(10, 177, 629, 291);
				
		panelMonedas.setLayout(null);
		
		JLabel instruccionesMonedas = new JLabel("Escribe la cantidad que quieres convertir y selecciona las monedas correspondientes");
		instruccionesMonedas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		instruccionesMonedas.setBounds(20, 11, 511, 23);
		panelMonedas.add(instruccionesMonedas);
		
		cantidad = new JTextField();
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		cantidad.setBounds(35, 79, 103, 29);
		panelMonedas.add(cantidad);
		cantidad.setColumns(10);
		
		
		String[] monedas = {"Pesos Mx", "Dólares", "Euros", "Libras", "Yen", "Won"};
		
		
		monedaInicial.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		monedaInicial.setModel(new DefaultComboBoxModel(monedas));
		monedaInicial.setSelectedIndex(0);
		monedaInicial.setBounds(148, 79, 115, 27);
		panelMonedas.add(monedaInicial);
		monedaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculo();
				informacion();
			}
		});
		
		
		monedaFinal.setModel(new DefaultComboBoxModel(monedas));
		monedaFinal.setSelectedIndex(1);
		monedaFinal.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		monedaFinal.setBounds(449, 81, 125, 27);
		panelMonedas.add(monedaFinal);
		monedaFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculo();
				informacion();
			}
		});
		
		resultadoMoneda = new JLabel("0.0");
		resultadoMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoMoneda.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		resultadoMoneda.setBounds(336, 83, 103, 23);
		panelMonedas.add(resultadoMoneda);
		
				
		JLabel igual = new JLabel("=");
		igual.setHorizontalAlignment(SwingConstants.CENTER);
		igual.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		igual.setBounds(281, 83, 45, 22);
		panelMonedas.add(igual);
		
		infoMonedas1 = new JLabel("info de conversión");
		infoMonedas1.setHorizontalAlignment(SwingConstants.CENTER);
		infoMonedas1.setFont(new Font("High Tower Text", Font.PLAIN, 18));
		infoMonedas1.setBounds(180, 165, 300, 25);
		panelMonedas.add(infoMonedas1);
		
		infoMonedas2 = new JLabel("info de conversión 2");
		infoMonedas2.setHorizontalAlignment(SwingConstants.CENTER);
		infoMonedas2.setFont(new Font("High Tower Text", Font.PLAIN, 18));
		infoMonedas2.setBounds(180, 220, 300, 25);
		panelMonedas.add(infoMonedas2);
		
		oyenteDinero();
		informacion();
	}

	
	public void oyenteDinero() {
		KeyListener eventoTeclado = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {	
				calculo();
			}
			
		};
		cantidad.addKeyListener(eventoTeclado);
	}
	
	private void calculo() {
		double resulta;
		String entrada = cantidad.getText();
		String moneda1 = (String) monedaInicial.getSelectedItem();
		String moneda2 = (String) monedaFinal.getSelectedItem();
		if(entrada.length()>0 && entrada.substring(0).matches("[0-9]*\\.?[0-9]*")) {
			double x = Double.parseDouble(entrada);
			resulta = funcion.ConvertirMoneda(x, moneda1, moneda2);
			resulta = (double) Math.round(resulta *100d)/100;
			resultadoMoneda.setText(String.valueOf(resulta));
		} else {
			cantidad.setText(null);
			resultadoMoneda.setText("0.0");
		}
	}
	
	private void informacion() {
		String moneda1 = (String) monedaInicial.getSelectedItem();
		String moneda2 = (String) monedaFinal.getSelectedItem();
		informa=funcion.informa(moneda1, moneda2);
		infoMonedas1.setText("1 "+ moneda1 + "  equivale a  "+(double) Math.round(informa[0] *100d)/100+"  "+moneda2);
		infoMonedas2.setText("1 "+ moneda2 + "  equivale a  "+(double) Math.round(informa[1] *100d)/100+"  "+moneda1);
	}
	
	
}

// Esto estaba antes en la validación del número, pero faltaba la opción de introducir decimales.
/*	
try {
	double x = Double.parseDouble(entrada);
	if(x >=0 ) {
		resulta = funcion.ConvertirMoneda(x, moneda1, moneda2);
		resulta = (double) Math.round(resulta *100d)/100;
		resultadoMoneda.setText(String.valueOf(resulta));
		}
} catch (Exception en) {
    cantidad.setText(null);
    resultadoMoneda.setText("0.0");
}
	*/
