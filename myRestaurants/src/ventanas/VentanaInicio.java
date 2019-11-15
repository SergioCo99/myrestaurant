package ventanas;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ventanas.ImagenInicio;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class VentanaInicio extends JFrame{
	/**/
	private static final long serialVersionUID = 1L;
	JButton Jbt;
	JButton Jbt2;
	JButton Jbt3;
	JButton Hscr;
	
	public VentanaInicio(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ImagenInicio v = new ImagenInicio();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		// labels and buttons
			
		Jbt = new JButton("Administrador");
		Jbt2 = new JButton("Comensal");
		Hscr = new JButton("Crear usuario");
		
		// set panels
			
		JPanel sel	= new JPanel(new FlowLayout(FlowLayout.LEFT , 200, 400));
		JPanel sel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT , 200, 400));
		JPanel sel3 = new JPanel(new FlowLayout(FlowLayout.CENTER , 100, 50));
		// set panel colors
		sel.setOpaque(false);
		sel2.setOpaque(false);
		sel3.setOpaque(false);
		
		// add to sel Panel 
		
		sel.add(Jbt);
		Jbt.setBackground(Color.WHITE);
		sel2.add(Jbt2);
		Jbt2.setBackground(Color.WHITE);
		sel3.add(Hscr);
		Hscr.setBackground(Color.orange);
		
		
		// add panels to frame 
			
		add(sel,BorderLayout.EAST);
		add(sel2,BorderLayout.WEST);
		add(sel3,BorderLayout.SOUTH);

		// set size
		setSize(1000,600);
		// set frame default on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//hacer frame visible
		setVisible(true);
		
		Jbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VInicSesAdm v1 = new VInicSesAdm();
				v1.setSize(1000, 600);
				v1.setVisible(true);
				v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v1.setTitle("MyRestaurant");
				dispose();				
			}});
		Jbt2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				VInicSesUsu v1 = new VInicSesUsu();
				v1.setSize(1000, 600);
				v1.setVisible(true);
				v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v1.setTitle("MyRestaurant");
				dispose();
			}
		}
		);
	
		
		Hscr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				VentanaRegistro v1 = new VentanaRegistro();
				v1.setSize(1000, 600);
				v1.setVisible(true);
				v1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				v1.setTitle("MyRestaurant");
				dispose();
			}
		}
		);
	}

	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable( ) {

			@Override
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

}