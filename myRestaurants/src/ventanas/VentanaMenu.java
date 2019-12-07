package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class VentanaMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	JPanel jp;
	
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1,2));
		setBounds(100, 100, 450, 300);
		ImagenMenu v = new ImagenMenu();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		jp = new JPanel();
		
		agregarmenu();		
		panelesrestaurantes();
	}
	public void agregarmenu(){
		  JMenuBar barra=new JMenuBar();
		  JMenu archivo=new JMenu("Opciones");
		  JMenu ayuda=new JMenu("Ayuda");
		  JMenuItem salir=new JMenuItem("Salir");
		  JMenuItem abrir=new JMenuItem("Abrir");
		  JMenuItem guardar=new JMenuItem("Guardar");
		  JMenuItem Acercade=new JMenuItem("Acerca de la aplicación");
		  barra.add(archivo);
		  barra.add(ayuda);
		  archivo.add(salir);
		  archivo.add(abrir);
		  archivo.add(guardar);
		  ayuda.add(Acercade);
		  setJMenuBar(barra);
		  
		 
		  //Estaría bien hacer esto
		  //barra.add(new JTextField("Hola, "+ nombreUsuario));
		  
		  Acercade.addActionListener((new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(rootPane, "Aplicación creada por: \n"
							+ "Jokin Martin \n"
							+ "Sergio López \n"
							+ "Sergio Cogollos \n"
							+ "Alumnos de 3º de Ingeniería Inforamtica en la Universidad de Deusto");
					
				}
			}));
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
