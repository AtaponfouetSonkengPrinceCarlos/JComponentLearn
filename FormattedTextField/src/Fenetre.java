import javax.swing.JFrame;
import javax.swing.JTextField ;
import javax.swing.JFormattedTextField ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.JButton;
import java.text.NumberFormat;
import java.awt.Color;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.awt.Font;
public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JFormattedTextField jtf;
	private JTextField jtf1 = new JTextField ();
	private JLabel label = new JLabel("Telephone fr");
	private JButton b = new JButton ("OK");
	public Fenetre(){
		try{
			MaskFormatter tel = new MaskFormatter("***-***-***-***");
			jtf = new JFormattedTextField (tel);
			}catch(ParseException e){
			e.printStackTrace();
			}
	this.setTitle("Animation");
	this.setSize(500, 500);
	container.setBackground (Color.white);
	container.setLayout(new BorderLayout());
	JPanel top = new JPanel();
	Font police = new Font("Arial", Font.BOLD, 14);
	jtf.setFont(police);
	jtf.setPreferredSize(new Dimension(200, 30));
	jtf1.setPreferredSize(new Dimension(200, 30));
	jtf.setForeground (Color.BLUE);
	b.addActionListener(new BoutonListener());
	top.add(label);
	top.add(jtf);
	top.add(jtf1);
	top.add(b);
	this.setContentPane(top);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	}
	class BoutonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			System.out.println((Double.valueOf(jtf1.getText()).doubleValue()+0.5));
			System.out.println("Téléphone FR : " +
					jtf.getText());
					if(jtf.getText().matches("^237-6[\\d]{2}(-[\\d]{3}){2}$")){
					System.out.println("Numéro de téléphone OK ! !");
					}
					else{
					System.out.println("Numéro de téléphone PAS OK !!");
					String str = jtf.getText().replaceAll("\\w", "0");
					jtf.setText(str);
					}
		}
		}
	}
	

