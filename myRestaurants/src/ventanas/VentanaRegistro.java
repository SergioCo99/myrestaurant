package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
/**/
public class VentanaRegistro extends JFrame{
	private JTextField textNombre;
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JTextField textContrasenya;
	private JTextField textTelefono;
	private JRadioButton usuario;
	private JRadioButton gestor;
	private JButton botonRegistro;
	private JButton botonAtras;
	
	//Hay que vincularlo con la BD
	public VentanaRegistro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ImagenRegistro v = new ImagenRegistro();
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
		
	
		

		JRadioButton usuario = new JRadioButton("Usuario");
		usuario.setOpaque(false);
		JRadioButton gestor = new JRadioButton("Administrador");
		gestor.setOpaque(false);

		JPanel panelTipo = new JPanel();
		panelTipo.add(usuario);
		panelTipo.add(gestor);
		panelTipo.setOpaque(false);
		
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(usuario);
		grupo.add(gestor);

		
		textNombre = new JTextField();
		
		//textNombre.setBounds(300, 300, 10, 5);

		textUsuario = new JTextField();
		textCorreo = new JTextField();
		textContrasenya = new JTextField();
	    JPasswordField contrasenya = new JPasswordField();
	    contrasenya.setEchoChar('*');
	    if(textContrasenya.getText() != contrasenya.getText()) {
	    	System.out.println("Tiene que ser lo mismo");//Arreglar
	    }
	    	
	    	
	    
		textTelefono = new JTextField();
		
		
		
		JButton botonRegistro = new JButton("Registrarse ");
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
				public void actionPerformed(ActionEvent e) {
					String crearNombre = textNombre.getText();
					String crearUsuario = textUsuario.getText();
					String crearCorreo = textUsuario.getText();
					char[] crearContrasenya = textContrasenya.getText().toCharArray();
					String crearTelefono = textTelefono.getText();

					if (crearNombre.matches("^[a-zA-Z]*$") && !crearNombre.isEmpty()&& crearCorreo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" // Dos lineas para validar si es
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && !crearCorreo.isEmpty() && !crearContrasenya.equals("") && crearTelefono.matches("^[0-9]*$")){
						VentanaMenu vM = new VentanaMenu();
						vM.setSize(1000, 600);
						v.setVisible(true);
						vM.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						vM.setTitle("Menú");
						dispose();
		
						System.out.println("Nombre:" + crearNombre + ", Usuario:" + crearUsuario + ", Correo:" + crearCorreo  + ", Telefono:" + crearTelefono); 
						
					} else if (!crearNombre.matches("^[a-zA-Z]*$") || crearNombre.isEmpty()) {
						System.out.println("Nombre:" + crearNombre+ " Nombre no valido");
					} else if (!crearCorreo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 																	
							+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") 
							|| crearCorreo.isEmpty()) {
						System.out.println("Correo:" + crearCorreo + "Correo no valido");
					} else if (crearContrasenya.equals("")) {
						System.out.println("Contrasenya:" + crearContrasenya + " Contraseña no valida");
					} else if(!crearTelefono.matches("^[0-9]*$")|| crearTelefono.isEmpty()) {
						System.out.println("Telefono:" + crearTelefono + " Telefono no valido");
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
		
		izquierda.add(new JLabel("                    Tipo de usuario:"));
		izquierda.add(panelTipo);
		izquierda.add(new JLabel("                    Nombre:"));
		izquierda.add(textNombre);
		izquierda.add(new JLabel("                    Usuario:"));
		izquierda.add(textUsuario);
		izquierda.add(new JLabel("                    Correo:"));
		izquierda.add(textCorreo);
		izquierda.add(new JLabel("                    Contraseña:"));
		izquierda.add(textContrasenya);
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