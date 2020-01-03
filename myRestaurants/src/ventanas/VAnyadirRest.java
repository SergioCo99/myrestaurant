package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class VAnyadirRest extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textNombreRest;
	private JSpinner textHoraApertura;
	private JSpinner textHoraCierre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	//Tipos comida
	private JCheckBox comidaChina;
	private JCheckBox comidaCasera;
	private JCheckBox comidaHamburgueseria;
	private JCheckBox comidaPizzeria;
	private JCheckBox comidaSidreria;
	private JCheckBox comidaChuletas;

	boolean escrito1;
	boolean escrito2;
	boolean escrito3;
	boolean escrito4;
	boolean escrito5;
	
	private JLabel errorNombreRest;
	private JLabel errorHoraApertura;
	private JLabel errorHoraCierre;
	private JLabel errorDireccion;
	private JLabel errorTelefono;
	public static Logger BDLogger;
	
	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	public VAnyadirRest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,1));
		setBounds(100, 100, 450, 300);
		VAnyadirRes1 v = new VAnyadirRes1();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		
		JPanel izquierda = new JPanel(new GridLayout(14,2));
	
		// set panel colors
		izquierda.setOpaque(false);
		
		
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		cp.add(izquierda, BorderLayout.WEST);
		
		
		
		textNombreRest = new JTextField("Ejemplo: Restaurante Manolo");
		textNombreRest.setBounds(250, 50, 300, 30);
		escrito1 = false;
		textNombreRest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito1 == false) {
					textNombreRest.setText("");
					escrito1 = true;
				}
			}
		});

		// from 0 to 9, in 1.0 steps start value 5 
		SpinnerNumberModel horarioHI = new SpinnerNumberModel(8.0, 8.0, 23.0, 1.0); 
		
		textHoraApertura = new JSpinner(horarioHI);
		textHoraApertura.setBounds(250, 50, 300, 30);
		
		SpinnerNumberModel horarioHF = new SpinnerNumberModel(9.0, 9.0, 23.0, 1.0); 

		textHoraCierre = new JSpinner(horarioHF);
		textHoraCierre.setBounds(250, 50, 300, 30);
		
		
		textDireccion = new JTextField("Ejemplo: Calle Mayor 25, Murcia");
		textDireccion.setBounds(250, 50, 300, 30);
		escrito4 = false;
		textDireccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito4 == false) {
					textDireccion.setText("");
					escrito4 = true;
				}
			}
		});
		
		textTelefono = new JTextField("Ejemplo: 900 000 000");
		textTelefono.setBounds(250, 50, 300, 30);
		escrito5 = false;
		textTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (escrito5 == false) {
					textTelefono.setText("");
					escrito5 = true;
				}
			}
		});
		
		JCheckBox comidaChina = new JCheckBox("Comida China");
		comidaChina.setOpaque(false);
		
		JCheckBox comidaCasera = new JCheckBox("Comida Casera");
		comidaCasera.setOpaque(false);
		
		JCheckBox comidaHamburgueseria = new JCheckBox("Hamburgueser�a");
		comidaHamburgueseria.setOpaque(false);
		
		JCheckBox comidaPizzeria = new JCheckBox("Pizzeria");
		comidaPizzeria.setOpaque(false);

		JCheckBox comidaSidreria = new JCheckBox("Sidrer�a");
		comidaSidreria.setOpaque(false);
		

		JCheckBox comidaChuletas = new JCheckBox("Chuletas");
		comidaChuletas.setOpaque(false);

		
		
		
		JPanel panelTipoComida = new JPanel();
		panelTipoComida.add(comidaChina);
		panelTipoComida.add(comidaCasera);
		panelTipoComida.add(comidaHamburgueseria);
		panelTipoComida.add(comidaPizzeria);
		panelTipoComida.add(comidaSidreria);
		panelTipoComida.add(comidaChuletas);
		
		panelTipoComida.setOpaque(false);
		
		
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(comidaChina);
		grupo.add(comidaCasera);
		grupo.add(comidaHamburgueseria);
		grupo.add(comidaPizzeria);
		grupo.add(comidaSidreria);
		grupo.add(comidaChuletas);
		
		//Errores de registro
		errorNombreRest = new JLabel();
		errorNombreRest.setBounds(250, 80, 150, 30);
		errorNombreRest.setForeground(Color.RED);

		errorHoraApertura = new JLabel();
		errorHoraApertura.setBounds(250, 155, 150, 30);
		errorHoraApertura.setForeground(Color.RED);

		errorHoraCierre = new JLabel();
		errorHoraCierre.setBounds(250, 230, 150, 30);
		errorHoraCierre.setForeground(Color.RED);
		
		errorDireccion = new JLabel();
		errorDireccion.setBounds(250, 230, 150, 30);
		errorDireccion.setForeground(Color.RED);
		
		errorTelefono = new JLabel();
		errorTelefono.setBounds(250, 230, 150, 30);
		errorTelefono.setForeground(Color.RED);
		
		//CONECTAR CON BASE DE DATOS
		
		
		
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("  Nombre restaurante:"));
		izquierda.add(textNombreRest);
		izquierda.add(new JLabel("  Hora de apertura:"));
		izquierda.add(textHoraApertura);
		izquierda.add(new JLabel("  Hora de cierre:"));
		izquierda.add(textHoraCierre);
		izquierda.add(new JLabel("  Direcci�n:"));
		izquierda.add(textDireccion);
		izquierda.add(new JLabel("  Tel�fono:"));
		izquierda.add(textTelefono);
		izquierda.add(new JLabel("  Tipo de comida:"));
		izquierda.add(panelTipoComida);
		
		//Hacer JButton Crear Restaurante
		
		
		
		agregarmenu();	

		
		
		
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem salir=new JMenuItem("Atr�s");
		  JMenuItem entrarAdmin=new JMenuItem("Cerrar sesi�n");
		  JMenuItem Acercade=new JMenuItem("Acerca de la aplicaci�n");
		  barra.add(archivo);
		  barra.add(ayuda);
		  archivo.add(salir);
		  archivo.add(entrarAdmin);
		  ayuda.add(Acercade);
		  setJMenuBar(barra);
		
		  // Reloj
		  JMenu vacio=new JMenu("                                                                                                                                                                                                                       "
		  		+ "                                                 ");
		  barra.add(vacio);
		  JLabel relojito = new JLabel();
		  relojito.setFont(new Font(relojito.getFont().getName(), Font.BOLD, 15));
		  relojito.setBounds(640, 0, 100, 20);
		  barra.add(relojito);
			Timer timer = new Timer(ONE_SECOND, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					relojito.setText(clockFormat.format(new Date()));
					relojito.repaint();
				}
			});
			relojito.setText(clockFormat.format(new Date()));
			timer.start();
		 
		  
		  
		  //Boton acerca de
		  Acercade.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(rootPane, "Aplicaci�n creada por: \n"
							+ "Jokin Martin \n"
							+ "Sergio L�pez \n"
							+ "Sergio Cogollos \n"
							+ "Alumnos de 3� de Ingenier�a Inform�tica en la Universidad de Deusto");
					
				}
			}));
		  
		  //Boton atr�s
		  salir.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							VAdmin1 v = new VAdmin1();
							v.setSize(1000, 600);
							v.setVisible(true);
							v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							v.setTitle("MyRestaurant");
							dispose();
							
						}
				
				
			}));
		  
		  entrarAdmin.addActionListener((new ActionListener() {
			  @Override
				public void actionPerformed(ActionEvent e) {
					int dialogButton = JOptionPane.showConfirmDialog(null, "�Est�s seguro de que quieres cerrar sesi�n?", "Cerrar sesi�n", JOptionPane.YES_NO_OPTION);

						if(dialogButton == JOptionPane.YES_OPTION) {
							VentanaInicio v = new VentanaInicio();
							v.setSize(1000, 600);
							v.setVisible(true);
							v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							v.setTitle("MyRestaurant");
							dispose();
						}else {
							remove(dialogButton);
							
						}
				}
				
			}));
		 }
	
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			new VAnyadirRest();

			
		}
	});
}

}