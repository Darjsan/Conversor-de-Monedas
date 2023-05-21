package Ventana;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Funciones.*;

public class Menu extends JFrame implements ActionListener {
	public JTextField cantidad;
	public JPanel panelPrincipal;
	private JToggleButton convierteMonedas;
	private JToggleButton convertirTemperatura;
	public PanelMoneda monedasPanel;
	public PanelTemperatura tempPanel;

	
	public Menu() {
		setBounds(50, 50, 670, 560);
		setTitle("Conversiones");
		monedasPanel = new PanelMoneda();
		tempPanel = new PanelTemperatura();
			
		colocarPanelPrincipal();
		colocarMenu();
		panelPrincipal.add(monedasPanel.panelMonedas);
		panelPrincipal.add(tempPanel.panelTemperatura);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void colocarPanelPrincipal() {
		panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);
		
		JLabel Titulo = new JLabel("Conversor");
		Titulo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 32));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(120, 11, 210, 55);
		panelPrincipal.add(Titulo);
	}
	
	private void colocarMenu() {
		convierteMonedas = new JToggleButton("Conversor de Monedas");
		convierteMonedas.setSelected(true);
		convierteMonedas.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		convierteMonedas.setBounds(100, 95, 187, 23);
		panelPrincipal.add(convierteMonedas);
		convierteMonedas.addActionListener(this);
		
		convertirTemperatura = new JToggleButton("Conversor de Temperatura");
		convertirTemperatura.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		convertirTemperatura.setBounds(320, 95, 221, 23);
		panelPrincipal.add(convertirTemperatura);
		convertirTemperatura.addActionListener(this);
		
		ButtonGroup grupoMenu = new ButtonGroup();
		grupoMenu.add(convierteMonedas);
		grupoMenu.add(convertirTemperatura);
	}
	
	//sobreescribimos el método del listener
		@Override
	    public void actionPerformed(ActionEvent e) {
	        
	        if(e.getSource() == convierteMonedas){
	        	monedasPanel.panelMonedas.setVisible(true);
	        	tempPanel.panelTemperatura.setVisible(false);
	        }else if(e.getSource() == convertirTemperatura){
	        	monedasPanel.panelMonedas.setVisible(false);
	        	tempPanel.panelTemperatura.setVisible(true);
	        }else {
	            JOptionPane.showMessageDialog(null, e.getActionCommand());
	        }
	        
	    }
}
