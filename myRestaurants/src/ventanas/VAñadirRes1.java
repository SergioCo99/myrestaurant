package ventanas;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class VAņadirRes1 extends javax.swing.JPanel {
	public VAņadirRes1() {
		this.setSize(1000, 600);
	 }
	
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("VAņadirRes1.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
		
	}
}
