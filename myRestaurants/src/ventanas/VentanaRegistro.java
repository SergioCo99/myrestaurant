package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import baseDeDatos.BdMyRestaurants;



import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
/**/
public class VentanaRegistro extends JFrame{
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JPasswordField textContrasenya;
	private JTextField textTelefono;
	private JRadioButton usuario;
	private JRadioButton gestor;
	private JButton botonRegistro;
	private JButton botonAtras;
	boolean escrito1;
	boolean escrito2;
	boolean escrito3;
	boolean escrito4;
	private JLabel errorNombre;
	private JLabel errorEmail;
	private JLabel errorContraseña;
	public static Logger BDLogger;

	
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

		
		
		
		
		
		//Nombre Usuario
		textUsuario = new JTextField("Ejemplo: Antonio99");
		textUsuario.setBounds(250, 50, 300, 30);
		escrito2 = false;
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito2 == false) {
					textUsuario.setText("");
					escrito2 = true;
				}
			}
		});
		
		//Email
		textCorreo = new JTextField("Ejemplo: antonio@gmail.com");
		textCorreo.setBounds(250, 125, 300, 30);
		escrito3 = false;
		textCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito3 == false) {
					textCorreo.setText("");
					escrito3 = true;
				}
			}
		});
		
		//Contraseña
		textContrasenya = new JPasswordField("");
	    JPasswordField contrasenya = new JPasswordField();
	    contrasenya.setEchoChar('*');
		textContrasenya.setBounds(250, 200, 300, 30);

		//Teléfono
		textTelefono = new JTextField("Ejemplo: 600 000 000");
		textTelefono.setBounds(250, 125, 300, 30);
		escrito4 = false;
		textTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito4 == false) {
					textTelefono.setText("");
					escrito4 = true;
				}
			}
		});
		
		//Errores de registro
		errorNombre = new JLabel();
		errorNombre.setBounds(250, 80, 150, 30);
		errorNombre.setForeground(Color.RED);

		errorEmail = new JLabel();
		errorEmail.setBounds(250, 155, 150, 30);
		errorEmail.setForeground(Color.RED);

		errorContraseña = new JLabel();
		errorContraseña.setBounds(250, 230, 150, 30);
		errorContraseña.setForeground(Color.RED);
		
		
		JButton botonRegistro = new JButton("Registrarse ");
		botonRegistro.addActionListener(new ActionListener() {
			
			@Override
				public void actionPerformed(ActionEvent e) {
					String crearUsuario = textUsuario.getText();
					String crearCorreo = textCorreo.getText();
					String crearContrasenya = textContrasenya.getText();
					String crearTelefono = textTelefono.getText();
					
					errorNombre.setText("");
					errorEmail.setText("");
					errorContraseña.setText("");
					
										  
					Connection conexion = BdMyRestaurants.conectar();
					Statement st = null;
					
					
					try {
						st = conexion.createStatement();
					} catch (SQLException e1) {
						e1.printStackTrace();
					

					if (crearCorreo.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && !crearCorreo.isEmpty() && !crearContrasenya.isEmpty() && crearTelefono.matches("^[0-9]*$") && BdMyRestaurants.existeUsuario(st, textCorreo.getText()) == true){
						errorNombre.setText("");
						errorEmail.setText("");
						errorContraseña.setText("");
					} else if (!crearUsuario.matches("^[a-zA-Z]*$") || crearUsuario.isEmpty()) {
						errorNombre.setText("Este nombre no es válido");
						JOptionPane.showMessageDialog(rootPane, "POr favor introduzca los datos correctamente");

					}else if (!crearCorreo.matches(
							"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
							|| crearCorreo.isEmpty()
							|| BdMyRestaurants.existeUsuario(st, textCorreo.getText()) == false) {
						errorEmail.setText("El Email no es válido");
						JOptionPane.showMessageDialog(rootPane, "POr favor introduzca los datos correctamente");

					}else if (crearContrasenya.isEmpty()) {
						errorContraseña.setText("La Contraseña no es válida");
						JOptionPane.showMessageDialog(rootPane, "POr favor introduzca los datos correctamente");

					}
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
		
	
	}
	
}