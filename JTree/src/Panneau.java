import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Panneau extends JPanel {
	private String texte = "Racine de l'arbre.";
	private JTextArea jta;
	public Panneau(){
	this.jta = new JTextArea(texte);
	this.setBackground(Color.white);
	this.add(jta);
	}
	public void setTexte(String texte) {
	this.jta.setText(texte);
	}
}
