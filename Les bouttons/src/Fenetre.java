import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Fenetre extends JFrame {
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("1");
	Fenetre()
	{
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setRows(3);
		gl.setHgap(5);
		gl.setVgap(5);
		this.setLayout(gl);
		this.setTitle("Bouton");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(bouton);
		this.getContentPane().add(new JButton("2"));
		this.getContentPane().add(new JButton("3"));
		this.getContentPane().add(new JButton("4"));
		this.getContentPane().add(new JButton("5"));
		this.getContentPane().add(new JButton("5"));
		this.setVisible(true);
		bouton.setBackground(Color.red);
	}

}
