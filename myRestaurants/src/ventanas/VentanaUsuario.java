package ventanas;


import java.awt.*;
import javax.swing.*;

public class VentanaUsuario extends JFrame{

	protected static final String ACEPTAR = "Aceptar";
	protected static final String CANCELAR = "Cancelar";
	protected static final String stringNombreUsuario = "Usuario: ";
	protected static final String stringCorreo = "Correo: ";
	protected static final String stringContrasenya	= "Contrasenya: ";
	protected static final String stringTelefono = "Telefono:";
	protected static final String stringDireccion	= "Direccion: ";
	protected static final String stringTipo			= "Tipo: ";
	
	
	
	private	JPanel Panel;
	private	JTextField nombreUsuario;
	private	JTextField correo;
	private JTextField contrasenya;
	private	JTextField telefono;
	private	JTextField direccion;
	private JComboBox tipo;
	private JLabel LnombreUsuario;
	private JLabel Lcorreo;
	private JLabel Lcontrasenya;
	private JLabel Ltelefono;
	private JLabel Ldireccion;
	private JLabel Ltipo;
	private JComponent botones;
	
	
	public VentanaUsuario() {
		
		setLayout(new BorderLayout());
		
		nombreUsuario = new JTextField(50);
		correo = new JTextField(50);
		contrasenya = new JTextField(50);
		telefono = new JTextField(50);
		direccion = new JTextField(50);
		tipo= new JComboBox();
		tipo.addItem("Administrador");
		tipo.addItem("Usuario");
		
		

		
		LnombreUsuario=new JLabel(stringNombreUsuario);
		LnombreUsuario.setLabelFor(nombreUsuario);
		Lcorreo=new JLabel(stringCorreo);
		Lcorreo.setLabelFor(correo);
		Lcontrasenya=new JLabel(stringContrasenya);
		Lcontrasenya.setLabelFor(contrasenya);
		Ltelefono=new JLabel(stringTelefono);
		Ltelefono.setLabelFor(telefono);
		Ldireccion=new JLabel(stringDireccion);
		Ldireccion.setLabelFor(direccion);
		Ltipo=new JLabel(stringTipo);
		Ltipo.setLabelFor(tipo);
		
		Panel= new JPanel();
		GridLayout gridpanel = new GridLayout();
		GridBagConstraints c= new GridBagConstraints();
		
		JLabel[] labels = {LnombreUsuario,Lcorreo, Lcontrasenya, Ltelefono, Ldireccion };
	    JTextField[] textFields = {nombreUsuario,correo, contrasenya, telefono, direccion};
		/*addLabelTextRows(labels, textFields, gridpanel, Panel);
		



		
		
		
		private void addLabelTextRows(JLabel[] labels,
				  JTextField[] textFields,
				  GridLayout gridpanel,
				  Container c) 
{
		
}*/
		this.setVisible(true);
		this.setSize(650,300);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		
		
	}
	
	
	
	
}
