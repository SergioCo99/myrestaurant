package ventanas;


import java.awt.*;
import javax.swing.*;

public class VentanaUsuario extends JFrame{

	protected static final String ACEPTAR = "Aceptar";
	protected static final String CANCELAR = "Cancelar";
    protected static final String stringNombre		= "Nombre: ";
	protected static final String stringApellidos	= "Apellidos: ";
	protected static final String stringNombreUsuario			= "Usuario: ";
	protected static final String stringContrasenya	= "Contrasenya: ";
	protected static final String stringTelefono		= "Telefono: ";
	protected static final String stringDireccion	= "Direccion: ";
	protected static final String stringTipo			= "Tipo: ";
	
	
	
	private	JPanel Panel;
	private	JTextField Nombre;
	private	JTextField Apellidos;
	private	JTextField nombreUsuario;
	private JTextField contrasenya;
	private	JTextField telefono;
	private	JTextField direccion;
	private JComboBox tipo;
	private JLabel Lnombre;
	private JLabel Lapellidos;
	private JLabel LnombreUsuario;
	private JLabel Lcontrasenya;
	private JLabel Ltelefono;
	private JLabel Ldireccion;
	private JLabel Ltipo;
	private JComponent botones;
	
	
	public VentanaUsuario() {
		
		setLayout(new BorderLayout());
		
		Nombre = new JTextField(50);
		Apellidos = new JTextField(50);
		nombreUsuario = new JTextField(50);
		contrasenya = new JTextField(50);
		telefono = new JTextField(50);
		direccion = new JTextField(50);
		tipo= new JComboBox();
		tipo.addItem("Administrador");
		tipo.addItem("Usuario");
		
		
		Lnombre=new JLabel(stringNombre);
		Lnombre.setLabelFor(Nombre);
		Lapellidos=new JLabel(stringApellidos);
		Lapellidos.setLabelFor(Apellidos);
		LnombreUsuario=new JLabel(stringNombreUsuario);
		LnombreUsuario.setLabelFor(nombreUsuario);
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
		
		JLabel[] labels = {Lnombre, Lapellidos, LnombreUsuario, Lcontrasenya, Ltelefono, Ldireccion };
	    JTextField[] textFields = {Nombre,Apellidos, nombreUsuario, contrasenya, telefono, direccion};
		addLabelTextRows(labels, textFields, gridpanel, Panel);
		



		
		
		
		private void addLabelTextRows(JLabel[] labels,
				  JTextField[] textFields,
				  GridLayout gridpanel,
				  Container c) 
{
		
}
		this.setVisible(true);
		this.setSize(650,300);
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		
		
		
	}
	
	
	
	
}
