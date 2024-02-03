import java.awt.Graphics;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Fenetre extends JFrame {
	Panneau2 pan = new Panneau2();
	Bouton bouton = new Bouton("Bouton");
	 private JPanel container = new JPanel(); 
	private static int i;
	Fenetre()
	{
		this.setTitle("Animation");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		container.add(bouton, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);
	
		
	}
	private void go()
	{
		while(true)
		{
		
			pan.setPosX(0);
			for(i =0;i<pan.getWidth();i++)
			{
				 int x = pan.getPosX();
				 x++;
				 pan.setPosY(pan.getHeight());
				 pan.setPosX(x);
				 pan.repaint();
				 try
				 {
					 Thread.sleep(5);
				 }
				 catch(InterruptedException e)
				 {
					 e.printStackTrace();
				 }
				 if(x==pan.getWidth()-1)
				 {
					 for(i=0;i<pan.getWidth();i++)
					 {
						 x--;
						 pan.setPosY(pan.getHeight());
						 pan.setPosX(x);
						 pan.repaint();
						 try
						 {
							 Thread.sleep(5);
						 }
						 catch(InterruptedException e)
						 {
							 e.printStackTrace();
						 } 
					 }
				 }
					 
			}
		 }
}
}