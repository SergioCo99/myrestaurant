package ventanas;
 
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal {
	  
		
    public static void main(String[] args) {
  
        VentanaInicio v = new VentanaInicio();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
        
        VentanaRegistro v1 = new VentanaRegistro();
        v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VInicSesUsu v2 = new VInicSesUsu();
        v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
       
        VInicSesAdm v3 = new VInicSesAdm();
        v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

     }
 
}
