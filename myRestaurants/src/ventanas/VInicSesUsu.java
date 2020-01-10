package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class VInicSesUsu extends JFrame{

	private static final long serialVersionUID = 1L;

	private JTextField textCorreo;
	private JPasswordField textContrasenya;
	private boolean escrito1;
	
	public VInicSesUsu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ImagenIniSesion v = new ImagenIniSesion();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		JPanel izquierda = new JPanel(new GridLayout(9,2));
		JPanel derecha = new JPanel();
		JPanel arriba = new JPanel(new GridLayout(2,9));
		JPanel abajo = new JPanel();
		
		JPanel abajoDerecha = new JPanel();
		abajoDerecha.add(abajo,derecha);
		// set panel colors
		izquierda.setOpaque(false);
		derecha.setOpaque(false);
		arriba.setOpaque(false);
		abajo.setOpaque(false);
		abajoDerecha.setOpaque(false);
		

		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		cp.add(izquierda, BorderLayout.WEST);
		cp.add(derecha, BorderLayout.EAST);
		cp.add(arriba, BorderLayout.NORTH);
		cp.add(abajo, BorderLayout.SOUTH);
		cp.add(abajoDerecha);
		
		
		textCorreo = new JTextField("Ejemplo: antonio@gmail.com");
		textCorreo.setBounds(250, 50, 300, 30);
		escrito1 = false;
		textCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito1 == false) {
					textCorreo.setText("");
					escrito1 = true;
				}
			}
		});
		textContrasenya = new JPasswordField();
	

		JButton botonAcceder = new JButton("Acceder ");
		botonAcceder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String correo = textCorreo.getText();
				
				
				if(correo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")&& textContrasenya.getPassword().length != 0 ){//linkearlo con la bd
					VentanaMenu v = new VentanaMenu();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();	
				} else {
					JOptionPane.showMessageDialog(rootPane, "Introduce todos los datos por favor!");
				}
							
			}
		});
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio v = new VentanaInicio();
				v.setSize(1000, 600);
				v.setVisible(true);
				v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v.setTitle("MyRestaurant");
				dispose();
				
			}
		});
		
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                    Correo:"));
		izquierda.add(textCorreo);
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                    Contraseña:    "));
		izquierda.add(textContrasenya);
		
		abajo.add(botonAtras);
		abajo.add(new JLabel("                              "));
		abajo.add(botonAcceder);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VInicSesUsu();

				
			}
		});
	}
	
}