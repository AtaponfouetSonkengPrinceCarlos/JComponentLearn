import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JComboBox combo = new JComboBox();
	private JLabel label = new JLabel("Une ComboBox");
	public Fenetre(){
	this.setTitle("Animation");
	this.setSize(300, 300);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	container.setBackground (Color.white);
	container.setLayout(new BorderLayout());
	String[] tab = {"Option 1", "Option 2", "Option 3", "Option4"};
	combo = new JComboBox(tab);
	//Ajout du listener
	combo.addActionListener(new ItemAction());
	combo.addItemListener(new ItemState());
	combo.setPreferredSize(new Dimension(100,20));
	combo.setForeground (Color.blue);
	JPanel top = new JPanel();
	top.add(label);
	top.add(combo);
	container.add(top, BorderLayout.NORTH);
	this.setContentPane(container);
	this.setVisible(true);
	}
	/**
	* Classe interne implémentant l'interface ItemListener
	*/
	class ItemState implements ItemListener{
	public void itemStateChanged (ItemEvent e) {
	System.out.println("événement déclenché sur: " + e.getItem());
	}
	}
	class ItemAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("ActionListener : actionsur " + combo.getSelectedItem());
		}
		}
	}
