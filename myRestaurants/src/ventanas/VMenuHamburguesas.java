package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class VMenuHamburguesas extends JFrame{
	private static final long serialVersionUID = 1L;

	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	JButton nuevaBusqueda;
	
	public VMenuHamburguesas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,1));
		setBounds(100, 100, 450, 300);
		Hamburguesa v = new Hamburguesa();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		agregarmenu();	
		tabla();
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu nuevaBusqueda = new JMenu("Nueva B�squeda");
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem nuevaB = new JMenuItem("Nueva B�squeda");
		  JMenuItem salir=new JMenuItem("Salir");
		  JMenuItem entrarAdmin=new JMenuItem("Entrar como Admin");
		  JMenuItem Acercade=new JMenuItem("Acerca de la aplicacion");
		  barra.add(nuevaBusqueda);
		  barra.add(archivo);
		  barra.add(ayuda);
		  nuevaBusqueda.add(nuevaB);
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
		 
		  //Estaria bien hacer esto
		  //barra.add(new JTextField("Hola, "+ nombreUsuario));
		  
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
		  
		  //Boton salir
		  salir.addActionListener((new ActionListener() {
				
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
		  
		  nuevaB.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int dialogButton = JOptionPane.showConfirmDialog(null, "�Quieres realizar nueva b�squeda?", "Nueva B�squeda", JOptionPane.YES_NO_OPTION);

						if(dialogButton == JOptionPane.YES_OPTION) {
							VentanaMenu v = new VentanaMenu();
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
		  
		  
		  entrarAdmin.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int dialogButton = JOptionPane.showConfirmDialog(null, "Vas a cerrar sesi�n y entrar con una cuenta de administrador\n"
							+ "                                   �Est�s seguro?", "Administrador", JOptionPane.YES_NO_OPTION);

						if(dialogButton == JOptionPane.YES_OPTION) {
							VInicSesAdm v = new VInicSesAdm();
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

	public void tabla() {
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Horario Apertura");
		modelo.addColumn("Horario Cierre");
		modelo.addColumn("Tel�fono");
		modelo.addColumn("Tipo de Comida");
		
		
		String[]p2= {"MCarrones", "14", "23", "900 000 008", "Hamburgueseria"};
		String[]p3= {"Deliciosas", "14", "23",  "900 000 009", "Hamburgueseria"};
		String[]p4= {"Juanita", "12", "22", "900 000 0010", "Hamburgueseria"};

		modelo.addRow(p2);
		modelo.addRow(p3);
		modelo.addRow(p4);

		
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		tabla.setBounds(12, 250, 650, 75);
		setSize(450, 750);
		scroll.setBounds(12, 250, 650, 75);
		
		add(scroll);
		setLayout(null);
		setVisible(true);
		
		tabla.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            // your valueChanged overridden method 
		        	if(table.isRowSelected(0))
		        	JOptionPane.showMessageDialog(rootPane, "Hamburgueseria McBurguer\n"
		        			+ "Abrimos todos los d�as\n"
		        			+ "Hamburguesas 100% vacuno\n"
		        			+ "Normal 5�\n"
		        			+ "Especial 6.5�\n"
		        			+ "McBurguer 8�");
		        	if(table.isRowSelected(1))
			        JOptionPane.showMessageDialog(rootPane,  "Hamburgueseria Deliciosas\n"
		        			+ "De Martes a Domingo\n"
		        			+ "Abierto todos los d�as\n"
		        			+ "Normal 5.50�\n"
		        			+ "Especial 6.50�\n"
		        			+ "XXL 9.50�");
		        	if(table.isRowSelected(2))
				    JOptionPane.showMessageDialog(rootPane, "Hamburgueser�a Juanita\n"
		        			+ "Abierto todos los d�as\n"
		        			+ "Como en casa\n"
		        			+ "Normal 5.50�\n"
		        			+ "Especial 6.50�\n"
		        			+ "XXL 9.50�");
					
		        }
		    }
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {/**/
				// TODO Auto-generated method stub
				new VentanaMenu();

				
			}
		});
	}
	
	
	
	
	
	

}
