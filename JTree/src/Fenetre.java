import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Fenetre extends JFrame {

	private JTree arbre;
	public Fenetre(){
	this.setSize(300, 300);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Les arbres");
	//On invoque la méthode de construction de notre arbre
	buildTree();
	this.setVisible(true);
	}
	private void buildTree(){
	//Création d'une racine
	DefaultMutableTreeNode racine = new
	DefaultMutableTreeNode("Racine");
	//Nous allons ajouter des branches et des feuilles à notre racine
	for(int i = 1; i < 12; i++){
	DefaultMutableTreeNode rep = new DefaultMutableTreeNode("Noeud N°"+i);
	//S'il s'agit d'un nombre pair, on rajoute une branche
	if((i%2) == 0){
	//Et une branche en plus ! Une !
	for(int j = 1; j < 5; j++){
	DefaultMutableTreeNode rep2 = new
	DefaultMutableTreeNode("Fichier enfant N°" + j);
	//Cette fois, on ajoute nos feuilles
	for(int k = 1; k < 5; k++)
	rep2.add(new DefaultMutableTreeNode("Sous Fichier enfant N°"+ k));
	rep.add(rep2);
	}
	}
	//On ajoute la feuille ou la branche à la racine
	racine.add(rep);
	}
	//On crée, avec notre hiérarchie, un arbre
	arbre = new JTree(racine);
	//Que nous plaçons sur le ContentPane de notre JFrame à l'aide d'un scroll
	this.getContentPane().add(new JScrollPane(arbre));
	}
//	public static void main(String[] args){
//	Fenetre fen = new Fenetre();
//}
	}
