package ventanas;
 
import javax.swing.JFrame;

public class VentanaPrincipal {
 
    public static void main(String[] args) {
  
       VentanaInicio v = new VentanaInicio();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
     }
 
}
