package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class VentanaMenu extends JFrame {
	
	private JMenuBar menubar;
	private JMenu menu1;
	private JMenuItem menuitem1, menuitem2, menuitem3;
	
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		ImagenMenu v = new ImagenMenu();
		v.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setLayout(new BorderLayout(0, 0));
		setContentPane(v);
		
		/*JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu1 = new JMenu("Opciones");
		menubar.add(menu1);
		*/
		
		
		
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
