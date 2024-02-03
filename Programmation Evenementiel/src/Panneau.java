import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Panneau extends JPanel {
	public static int i;
	public void paintComponent(Graphics g)
	{
		int x = this.getWidth()/4;
		int y = this.getHeight()/4;
		System.out.println("la largeur est x = "+this.getWidth()+"et la hauteur est "+this.getHeight());
		i++;
		System.out.println("je suis executer "+i+" fois");
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			Graphics2D g2d = (Graphics2D)g;
			GradientPaint gp = new GradientPaint(0, 0,
			Color.cyan, 30, 30, Color.pink, true);
			g2d.setPaint(gp);
			Font font = new Font("Comics Sans MS", Font.BOLD,
			20);
			g2d.setFont(font);
			g2d.drawString("ATAPONFOUET SONKENG PRINCE CARLOS", this.getWidth()/2 - 70, this.getHeight()/2);
			gp = new GradientPaint(-40, -40, Color.red, 100,
			100, Color.white, false);
			g2d.setPaint(gp);
			font = new Font("Arial Black", Font.PLAIN, 30);
			g2d.setFont(font);
			g2d.drawString("Moi j'aime bien programmer orienter objet en java", 5, 65);
			g2d.drawString("Design pattern", 10, 100);
			g2d.drawString("Pattern Factory", 10, 150);
			g2d.drawString("Genericité et reflexiviter", 10, 200);
			g2d.drawString("Maitrise des éxceptions et Threads synchronisation", 10, 250);
			g2d.drawString("Securisation des données avec API regex", 10, 300);
			g2d.drawString("Bref la programmations évenementiels.", 10, 400);
			System.out.println(this.getX());

}}
