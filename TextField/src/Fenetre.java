import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JTextField jt = new JTextField("Valeurs par defaut");
	private JLabel label = new JLabel("Un JTexField");
	public Fenetre(){
	this.setTitle("Animation");
	this.setSize(500, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	container.setBackground (Color.white);
	container.setLayout(new BorderLayout());
	JPanel top = new JPanel();
	Font police = new Font("Arial", Font.BOLD, 14);
	jt.setFont(police);
	jt.setBackground(Color.DARK_GRAY);
	jt.setForeground(Color.white);
	jt.setPreferredSize(new Dimension(300, 200));
	top.add(label);
	top.add(jt);
	container.add(top, BorderLayout.NORTH);
	this.setContentPane(container);
	this.setVisible(true);
	}
}
