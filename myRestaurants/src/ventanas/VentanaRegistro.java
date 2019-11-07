package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
/**/
public class VentanaRegistro extends JFrame{
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JPasswordField textContrasenya;
	private JPasswordField textConfirmarContrasenya;
	private JTextField textTelefono;
	private JRadioButton usuario;
	private JRadioButton gestor;
	private JButton botonRegistro;
	private JButton botonAtras;
	
	//Hay que vincularlo con la BD
	public VentanaRegistro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JPanel izquierda = new JPanel(new GridLayout(9,2));
		JPanel derecha = new JPanel();
		JPanel arriba = new JPanel(new GridLayout(2,9));
		JPanel abajo = new JPanel();
		
		JPanel abajoDerecha = new JPanel();
		abajoDerecha.add(abajo,derecha);
		
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		cp.add(izquierda, BorderLayout.WEST);
		cp.add(derecha, BorderLayout.EAST);
		cp.add(arriba, BorderLayout.NORTH);
		cp.add(abajo, BorderLayout.SOUTH);
		cp.add(abajoDerecha);
		
	
		

		JRadioButton usuario = new JRadioButton("Usuario");
		JRadioButton gestor = new JRadioButton("Administrador");

		JPanel panelTipo = new JPanel();
		panelTipo.add(usuario);
		panelTipo.add(gestor);
		
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(usuario);
		grupo.add(gestor);

		
		textNombre = new JTextField();
		
		//textNombre.setBounds(300, 300, 10, 5);
		textApellidos = new JTextField();
		textUsuario = new JTextField();
		textCorreo = new JTextField();
		textContrasenya = new JPasswordField();
		textConfirmarContrasenya = new JPasswordField();
		textTelefono = new JTextField();
		
		
		JButton botonRegistro = new JButton("Registrarse ");
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
		
		
		izquierda.add(new JLabel("                    Tipo de usuario:"));
		izquierda.add(panelTipo);
		izquierda.add(new JLabel("                    Nombre:"));
		izquierda.add(textNombre);
		izquierda.add(new JLabel("                    Apellidos:"));
		izquierda.add(textApellidos);
		izquierda.add(new JLabel("                    Usuario:"));
		izquierda.add(textUsuario);
		izquierda.add(new JLabel("                    Correo:"));
		izquierda.add(textCorreo);
		izquierda.add(new JLabel("                    Contraseña:"));
		izquierda.add(textContrasenya);
		izquierda.add(new JLabel("                    Confirmar Contraseña:"));
		izquierda.add(textConfirmarContrasenya);
		izquierda.add(new JLabel("                    Telefono:"));
		izquierda.add(textTelefono);	
		
		abajo.add(botonAtras);
		abajo.add(new JLabel("                              "));
		abajo.add(botonRegistro);
		
		
		
		
		/*
		this.setTitle("Registro");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setSize(1000, 600);
		this.setVisible(true);
*/
	
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaRegistro();

				
			}
		});
	}
	
}