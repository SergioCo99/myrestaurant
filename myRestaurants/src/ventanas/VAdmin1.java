package ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class VAdmin1 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel relojito;
	public final static int ONE_SECOND = 1000;
	private final SimpleDateFormat clockFormat = new SimpleDateFormat("H:mm:ss");
	JButton misR;
	JButton nuevoR;
	
	
	public VAdmin1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		VAdmin v = new VAdmin();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		agregarmenu();
		
		misR = new JButton("Mis restaurantes");
		nuevoR = new JButton("Nuevo restaurante");
		
		JPanel sel	= new JPanel(new FlowLayout(FlowLayout.LEFT , 200, 400));
		JPanel sel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT , 200, 400));
		
		sel.setOpaque(false);
		sel2.setOpaque(false);
		
		sel2.add(misR);
		misR.setBackground(Color.WHITE);
		sel.add(nuevoR);
		nuevoR.setBackground(Color.WHITE);
		
		add(sel,BorderLayout.EAST);
		add(sel2,BorderLayout.WEST);
		
		setSize(1000,600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		misR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMisRestaurantes v1 = new VMisRestaurantes();
				v1.setSize(1000, 600);
				v1.setVisible(true);
				v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v1.setTitle("MyRestaurant");
				dispose();				
			}});
		
		nuevoR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAnyadirRest v1 = new VAnyadirRest();
				v1.setSize(1000, 600);
				v1.setVisible(true);
				v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v1.setTitle("MyRestaurant");
				dispose();	
			}});
		
		
		
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem salir=new JMenuItem("Atrás");
		  JMenuItem entrarAdmin=new JMenuItem("Entrar como Usuario");
		  JMenuItem Acercade=new JMenuItem("Acerca de la aplicación");
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
					JOptionPane.showMessageDialog(rootPane, "Aplicación creada por: \n"
							+ "Jokin Martin \n"
							+ "Sergio López \n"
							+ "Sergio Cogollos \n"
							+ "Alumnos de 3º de Ingeniería Informática en la Universidad de Deusto");
					
				}
			}));
		  
		  //Boton atrï¿½s
		  salir.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							VInicSesAdm v = new VInicSesAdm();
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
	
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			new VAdmin1();

			
		}
	});
}

}