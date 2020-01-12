package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class VentanaMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	private JRadioButton comidaChina;
	private JRadioButton comidaCasera;
	private JRadioButton comidaHamburgueseria;
	private JRadioButton comidaPizzeria;
	private JRadioButton comidaSidreria;
	private JRadioButton comidaChuletas;
	private JButton buscar;
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,1));
		setBounds(100, 100, 450, 300);
		ImagenMenu v = new ImagenMenu();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		agregarmenu();	
		panelbuscar();
		panelesrestaurantes();
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem salir=new JMenuItem("Salir");
		  JMenuItem entrarAdmin=new JMenuItem("Entrar como Admin");
		  JMenuItem Acercade=new JMenuItem("Acerca de la aplicacion");
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

	public void panelbuscar() {
		JPanel izquierda = new JPanel(new GridLayout(9, 2));
		izquierda.setOpaque(false);
		izquierda.setBackground(Color.GREEN);
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(izquierda, BorderLayout.WEST);
		
		
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("                                "));
		izquierda.add(new JLabel("Seleccione el tipo de comida que desea:"));
		izquierda.add(new JLabel("                                "));

		
		/*
		 * 
		 * JRadioButton r1=new JRadioButton("A) Male");    
JRadioButton r2=new JRadioButton("B) Female");    
r1.setBounds(75,50,100,30);    
r2.setBounds(75,100,100,30);    
ButtonGroup bg=new ButtonGroup();    
bg.add(r1);bg.add(r2);    
f.add(r1);f.add(r2);  */
		JRadioButton comidaChuletas = new JRadioButton("Chuletas");
		JRadioButton comidaChina = new JRadioButton("China");
		JRadioButton comidaCasera = new JRadioButton("Comida Casera");
		JRadioButton comidaHamburgueseria = new JRadioButton("Hamburguesas");
		JRadioButton comidaPizzeria = new JRadioButton("Pizza");
		JRadioButton comidaSidreria = new JRadioButton("Sidreria");
		comidaChuletas.setBounds(400, 210, 150, 40);
		comidaChina.setBounds(200, 70, 150, 40);
		comidaCasera.setBounds(400, 70, 150, 40);
		comidaHamburgueseria.setBounds(200, 140, 150, 40);
		comidaPizzeria.setBounds(400, 140, 150, 40);
		comidaSidreria.setBounds(200, 210, 150, 40);
		ButtonGroup bg = new ButtonGroup();
		bg.add(comidaChuletas);
		bg.add(comidaChina);
		bg.add(comidaCasera);
		bg.add(comidaHamburgueseria);
		bg.add(comidaPizzeria);
		bg.add(comidaSidreria);
		

		
		izquierda.add(comidaChuletas);
		//comidaChuletas.setBackground(Color.RGBtoHSB(r, g, b, hsbvals));
		comidaChuletas.setOpaque(false);
		
		izquierda.add(comidaChina);
		comidaChina.setOpaque(false);


		izquierda.add(comidaCasera);
		comidaCasera.setOpaque(false);

		
		izquierda.add(comidaHamburgueseria);
		comidaHamburgueseria.setOpaque(false);

	
		izquierda.add(comidaPizzeria);
		comidaPizzeria.setOpaque(false);

		izquierda.add(comidaSidreria);
		comidaSidreria.setOpaque(false);
		
		izquierda.add(new JLabel("Precio hasta:"));
		izquierda.add(new JLabel("                      "));

		//izquierda.add(new JButton("Buscar"));
		
		JSlider sliderPrecio = new JSlider(JSlider.HORIZONTAL, 0, 70, 0);
		sliderPrecio.setInverted(false); //se invierte el relleno del JSlider (desde donde comienza)
		sliderPrecio.setPaintTicks(true); //las rayitas que marcan los nï¿½meros
		sliderPrecio.setMajorTickSpacing(10); // de cuanto en cuanto los nï¿½meros en el slider
		sliderPrecio.setMinorTickSpacing(5); //las rayitas de cuanto en cuanto
		sliderPrecio.setPaintLabels(true); //si se ve los nï¿½meros del slider
		
		izquierda.add(sliderPrecio);
		izquierda.add(new JLabel("                      "));
		izquierda.add(new JLabel("                      "));
		izquierda.add(new JLabel("                      "));
		buscar = new JButton("Buscar");
		buscar.setBackground(Color.ORANGE);
		buscar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(comidaChuletas.isSelected()) {
					VMenuChuletas v = new VMenuChuletas();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				
				if(comidaHamburgueseria.isSelected()) {
					VMenuHamburguesas v = new VMenuHamburguesas();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				
				if(comidaChina.isSelected()) {
					VMenuChina v = new VMenuChina();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				if(comidaCasera.isSelected()) {
					VMenuCasera v = new VMenuCasera();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				
				if(comidaPizzeria.isSelected()) {
					VMenuPizza v = new VMenuPizza();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				if(comidaSidreria.isSelected()) {
					VMenuPizza v = new VMenuPizza();
					v.setSize(1000, 600);
					v.setVisible(true);
					v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					v.setTitle("MyRestaurant");
					dispose();
				}
				
			}
		}
		);
		izquierda.add(buscar);
		
		
	
	}
	
	
	public void panelesrestaurantes() {
		/*JPanel panel = new JPanel();
		
		this.setSize(50, 25);
		panel.setBackground(Color.WHITE);
		this.getContentPane().add(panel);
	*/
		 //panel de intentos
		
		JPanel panelIzq = new JPanel();
	    panelIzq.setSize(500,470);
	    panelIzq.setLayout(new GridLayout(4,1));
	        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(500,117);
        panel.setBackground(Color.lightGray);
		this.getContentPane().add(panel);
        panelIzq.add(panel);

		
		
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
