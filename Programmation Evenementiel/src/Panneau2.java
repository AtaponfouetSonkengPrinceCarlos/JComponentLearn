import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.GradientPaint;

public class Panneau2 extends JPanel {
	public static int i;
	private int posX = 0;
	private  int posY = this.getHeight();
	public void paintComponent(Graphics g){
		System.out.println("la largeur est x = "+this.getWidth()+"et la hauteur est "+this.getHeight());
		i++;
		System.out.println("je suis executer "+i+" fois");
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		Graphics2D g2d = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0, 0,Color.cyan, 30, 30, Color.pink, true);
		g2d.setPaint(gp);
		Font font = new Font("Comics Sans MS", Font.BOLD,25);
		g2d.setFont(font);
		g2d.drawString("ATAPONFOUET SONKENG PRINCE CARLOS", posX, posY);
	}
	public int getPosX() {
	return posX;
	}
	public void setPosX(int posX) {
	this.posX = posX;
	}
	public int getPosY() {
	return posY;
	}
	public void setPosY(int posY) {
	this.posY = posY;
	}
}
