package Ventana;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Funciones.FuncionesMoneda;
import Funciones.FuncionesTemperatura;
import java.awt.event.KeyAdapter;

public class PanelTemperatura extends JFrame {

	public JPanel panelTemperatura;
	public JTextField entradaCentigrado;
	public JTextField entradaFahrenheit;
	public JLabel salidaFahrenheit;
	public JLabel salidaCentigrados;
	public FuncionesTemperatura funcion =new FuncionesTemperatura();
	
	public PanelTemperatura() {
		panelTemperatura = new JPanel();
		panelTemperatura.setVisible(false);  // en esta parte se dehabilitará la vista del panel
		panelTemperatura.setBounds(10, 177, 629, 291);
		panelTemperatura.setLayout(null);
		
		JLabel InstrrucionTemperatura = new JLabel("Escribe la temperatura que deseas convertir en el recuadro correspondiente");
		InstrrucionTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		InstrrucionTemperatura.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		InstrrucionTemperatura.setBounds(38, 26, 531, 37);
		panelTemperatura.add(InstrrucionTemperatura);
		
		entradaCentigrado = new JTextField();
		entradaCentigrado.setBounds(65, 108, 125, 26);
		panelTemperatura.add(entradaCentigrado);
		entradaCentigrado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double resulta;
				String cantidad = entradaCentigrado.getText();
				
				if(cantidad.length()>0 && cantidad.substring(0).matches("^[-]?[0-9]*\\.?[0-9]*")) {
					
					if (cantidad.length()==1 && cantidad.substring(0).matches("[-]")) {
						
					} else {
						double x = Double.parseDouble(cantidad);
						resulta = funcion.convertirTemp(x, "CentToFahr");
						resulta = (double) Math.round(resulta *100d)/100;
						salidaFahrenheit.setText("es igual a:   "+String.valueOf(resulta));
						} 
				}else {
					entradaCentigrado.setText(null);
					salidaFahrenheit.setText("0.0");
				}
			}
		});
		
		entradaFahrenheit = new JTextField();
		entradaFahrenheit.setColumns(10);
		entradaFahrenheit.setBounds(65, 174, 125, 26);
		panelTemperatura.add(entradaFahrenheit);
		entradaFahrenheit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double resulta;
				String cantidad = entradaFahrenheit.getText();
				
				if(cantidad.length()>0 && cantidad.substring(0).matches("^[-]?[0-9]*\\.?[0-9]*")) {
					
					if (cantidad.length()==1 && cantidad.substring(0).matches("[-]")) {
						
					} else {
						double x = Double.parseDouble(cantidad);
						resulta = funcion.convertirTemp(x, "FahrToCent");
						resulta = (double) Math.round(resulta *100d)/100;
						salidaCentigrados.setText("es igual a:   "+String.valueOf(resulta));
						} 
				}else {
					entradaFahrenheit.setText(null);
					salidaCentigrados.setText("0.0");
				}
			}
		});
		
		JLabel gradosC1 = new JLabel("°C");
		gradosC1.setHorizontalAlignment(SwingConstants.CENTER);
		gradosC1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		gradosC1.setBounds(200, 105, 68, 26);
		panelTemperatura.add(gradosC1);
		
		salidaFahrenheit = new JLabel("es igual a:   ");
		salidaFahrenheit.setHorizontalAlignment(SwingConstants.LEFT);
		salidaFahrenheit.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		salidaFahrenheit.setBounds(300, 108, 190, 26);
		panelTemperatura.add(salidaFahrenheit);
		
		JLabel gradosF1 = new JLabel("°F");
		gradosF1.setHorizontalAlignment(SwingConstants.CENTER);
		gradosF1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		gradosF1.setBounds(467, 105, 68, 26);
		panelTemperatura.add(gradosF1);
		
		JLabel gradosF2 = new JLabel("°F");
		gradosF2.setHorizontalAlignment(SwingConstants.CENTER);
		gradosF2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		gradosF2.setBounds(200, 174, 68, 26);
		panelTemperatura.add(gradosF2);
		
		salidaCentigrados = new JLabel("es igual a:   ");
		salidaCentigrados.setHorizontalAlignment(SwingConstants.LEFT);
		salidaCentigrados.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		salidaCentigrados.setBounds(300, 174, 190, 26);
		panelTemperatura.add(salidaCentigrados);
		
		JLabel gradosC2 = new JLabel("°C");
		gradosC2.setHorizontalAlignment(SwingConstants.CENTER);
		gradosC2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		gradosC2.setBounds(467, 174, 68, 26);
		panelTemperatura.add(gradosC2);
		
		JLabel formulaTemp = new JLabel("°F = (1.8) °C + 32");
		formulaTemp.setHorizontalAlignment(SwingConstants.CENTER);
		formulaTemp.setBounds(225, 229, 180, 51);
		panelTemperatura.add(formulaTemp);
		
	}
	
}
