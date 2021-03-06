package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import alimentacion.Producto;
import baseDeDatos.BdMyRestaurants;
import restaurante.Restaurante;

import javax.swing.JScrollPane;



public class VMisRestaurantes extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	private JList<Restaurante> listaRestaurante= new JList<>();

	public VMisRestaurantes() {
		
		super("Mi tabla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ImagenIniSesion v = new ImagenIniSesion();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		agregarmenu();
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Horario Apertura");
		modelo.addColumn("Horario Cierre");
		modelo.addColumn("Direcci�n");
		modelo.addColumn("Tel�fono");
		modelo.addColumn("Tipo de Comida");
		
		
		String[]p1= {"Como en Casa", "8", "23", "Calle Agapito", "900 000 000", "ComidaCasera"};
		String[]p2= {"Paco", "10", "22", "Calle Mayor", "900 000 001", "Chuletas"};
		String[]p3= {"MCarrones", "14", "23", "Calle Colesterol", "900 000 008", "Hamburgueseria"};
		
		modelo.addRow(p1);
		modelo.addRow(p2);
		modelo.addRow(p3);
		
		
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		tabla.setBounds(12, 250, 650, 75);
		setSize(450, 750);
		scroll.setBounds(12, 250, 650, 75);
		//JLIST
		JScrollPane listScrollPane = new JScrollPane(listaRestaurante);
		add(listScrollPane, BorderLayout.SOUTH);
		listaRestaurante.setModel(new DefaultListModel<Restaurante>());
		listaRestaurante.setEnabled(true);
		
		
		VMisRestaurantes parent = this;
		parent.addWindowListener(new WindowAdapter() {//metemos el jList en 'parent' EJERCICIO-4
			
			public void windowOpened(WindowEvent e) {//TODO:Swing
				Connection con = BdMyRestaurants.initBD();
				Statement st = BdMyRestaurants.usarBD(con);
				List<Restaurante> restaurantes = BdMyRestaurants.loadRestaurantes(st);
				DefaultListModel<Restaurante> model = (DefaultListModel<Restaurante>) listaRestaurante.getModel();
				for(Restaurante restaurante : restaurantes) {//El nuevo delante
					model.addElement(restaurante);
				}
				BdMyRestaurants.cerrarBD(con, st);
			}
		});
		add(scroll);
		setLayout(null);
		setVisible(true);
		
		
		
	}
	
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem salir=new JMenuItem("Atr�s");
		  JMenuItem entrarAdmin=new JMenuItem("Entrar como Usuario");
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
							VInicSesUsu v = new VInicSesUsu();
							v.setSize(1000, 600);
							v.setVisible(true);
							v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							v.setTitle("MyRestaurant");
							dispose();
					
				}
				
			}));
		  
		 }
	
	public static void main(String[] a) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VMisRestaurantes();

				
			}
		});
	}
}

