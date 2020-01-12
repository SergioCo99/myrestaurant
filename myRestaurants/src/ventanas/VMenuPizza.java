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

public class VMenuPizza extends JFrame{
	private static final long serialVersionUID = 1L;

	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	JButton nuevaBusqueda;
	
	public VMenuPizza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,1));
		setBounds(100, 100, 450, 300);
		Pizza v = new Pizza();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		agregarmenu();	
		tabla();
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu nuevaBusqueda = new JMenu("Nueva Búsqueda");
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem nuevaB = new JMenuItem("Nueva Búsqueda");
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
					JOptionPane.showMessageDialog(rootPane, "Aplicación creada por: \n"
							+ "Jokin Martin \n"
							+ "Sergio López \n"
							+ "Sergio Cogollos \n"
							+ "Alumnos de 3º de Ingeniería Informática en la Universidad de Deusto");
					
				}
			}));
		  
		  //Boton salir
		  salir.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int dialogButton = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION);

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
					int dialogButton = JOptionPane.showConfirmDialog(null, "¿Quieres realizar nueva búsqueda?", "Nueva Búsqueda", JOptionPane.YES_NO_OPTION);

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
					int dialogButton = JOptionPane.showConfirmDialog(null, "Vas a cerrar sesión y entrar con una cuenta de administrador\n"
							+ "                                   ¿Estás seguro?", "Administrador", JOptionPane.YES_NO_OPTION);

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
		modelo.addColumn("Teléfono");
		modelo.addColumn("Tipo de Comida");
		
		
		String[]p2= {"Luigi", "10", "22", "900 000 030", "Pizza"};
		String[]p3= {"Jose Mari", "14", "23",  "900 000 031", "Pizza"};
		String[]p4= {"Zafra", "12", "22", "900 000 032", "Pizza"};

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
		        	JOptionPane.showMessageDialog(rootPane, "Pizzería Luigi\n"
		        			+ "Abrimos todos los días\n"
		        			+ "Especialidad en masa fina\n"
		        			+ "Menú del día 10€\n"
		        			+ "Menú especial 25€\n"
		        			+ "Menu Luigi 30€");
		        	if(table.isRowSelected(1))
			        JOptionPane.showMessageDialog(rootPane,  "Pizzería Jose Mari\n"
		        			+ "De Martes a Domingo\n"
		        			+ "Si quieres comer bien, ven donde Chema\n"
		        			+ "Menú del día 9.50€\n"
		        			+ "Menú especial 15€\n"
		        			+ "Menu Chema 24.90€");
		        	if(table.isRowSelected(2))
				    JOptionPane.showMessageDialog(rootPane, "Pizzeria Zafra\n"
		        			+ "Abierto todos los días\n"
		        			+ "Sabor y tradición\n"
		        			+ "Menú del día 9.50€\n"
		        			+ "Menú especial 15€\n"
		        			+ "Menu Zafra 24.90€");
					
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
