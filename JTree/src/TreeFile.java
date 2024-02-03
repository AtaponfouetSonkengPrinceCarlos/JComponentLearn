import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
public class TreeFile extends JFrame {
	private JMenuItem eraseMenu ;
	private JButton bouton = new JButton("Ajouter");
	private DefaultTreeModel model;
	private DefaultTreeCellRenderer[] tCellRenderer = new DefaultTreeCellRenderer[3];
	private Panneau panneau = new Panneau();
	private String str;
	private JTree arbre;
	private DefaultMutableTreeNode racine;
	public TreeFile(String lookAndFeel){
	this.setSize(300, 300);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Les arbres");
	String title = (lookAndFeel.split("\\."))[(lookAndFeel.split("\\.").length - 1)];
			this.setTitle("Nom du 'look and feel : " + title);
//	this.tCellRenderer[0] = new DefaultTreeCellRenderer();
//	//Initialisation des images pour les actions fermer, ouvrir et
//	this.tCellRenderer[0].setClosedIcon(new ImageIcon("ferme.png"));
//	this.tCellRenderer[0].setOpenIcon(new ImageIcon("ouvert.png"));
//	this.tCellRenderer[0].setLeafIcon(new ImageIcon("feuille.png"));
	try {
		//On force à utiliser le look and feel du system
		UIManager.setLookAndFeel(lookAndFeel);
		//Ici on force tous les composants de notre fenêtre (this) à se
		SwingUtilities.updateComponentTreeUI(this);
	} catch (InstantiationException e) {
	} catch (ClassNotFoundException e) {
	} catch (UnsupportedLookAndFeelException e) {
	} catch (IllegalAccessException e) {}
	//On invoque la méthode de construction de notre arbre
	listRoot();
	bouton.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent event) {
			System.out.println("99999999999"+arbre.getLastSelectedPathComponent());
		if(arbre.getLastSelectedPathComponent() != null){
		JOptionPane jop = new JOptionPane();
		String nodeName = jop.showInputDialog("Saisir un nom de noeud");
		if(nodeName != null && !nodeName.trim().equals("")){
		DefaultMutableTreeNode parentNode =
		(DefaultMutableTreeNode)arbre.getLastSelectedPathComponent();
		DefaultMutableTreeNode childNode = new
		DefaultMutableTreeNode(nodeName);
		parentNode.add(childNode);
		model.insertNodeInto(childNode, parentNode,
		parentNode.getChildCount()-2);
		model.nodeChanged(parentNode);
		}
		}
		else{
		System.out.println("AUCUNE SELECTION ! ! !");
		}
		}
		});
		this.getContentPane().add(bouton, BorderLayout.SOUTH);
	this.setVisible(true);
	}
	
	private void listRoot(){
	this.racine = new DefaultMutableTreeNode("/");
	int count = 0,
			i=0;
	for(File file : File.listRoots())
	{
		DefaultMutableTreeNode lecteur = new DefaultMutableTreeNode(file.getAbsolutePath());
	try {
	for(File nom : file.listFiles()){
	DefaultMutableTreeNode node = new
	DefaultMutableTreeNode(nom.getName()+"\\");
	 str = nom.getName();
	lecteur.add(this.listFile(nom, node));
	}
	} catch (NullPointerException e) {}
	this.racine.add(lecteur);
	this.model = new DefaultTreeModel(this.racine);
	this.model.addTreeModelListener(new TreeModelListener() {
		/**
		* Méthode appelée lorsqu'un noeud a changé
		*/
		public void treeNodesChanged (TreeModelEvent evt) {
		System.out.println("Changement dans l'arbre");
		Object[] listNoeuds = evt.getChildren();
		int[] listIndices = evt.getChildIndices();
		for (int i = 0; i < listNoeuds.length; i++) {
		System.out.println("Index " + listIndices[i] + ",nouvelle valeur : "
		+ listNoeuds[i]);
		}
		}
		/**
		* Méthode appelée lorsqu'un noeud est inséré
		*/
		public void treeNodesInserted (TreeModelEvent event) {
		System.out.println("Un noeud a été inséré !" );
		}
		/**
		* Méthode appelée lorsqu'un noeud est supprimé
		*/
		public void treeNodesRemoved (TreeModelEvent event) {
		System.out.println("Un noeud a été retiré !" );
		}
		/**
		* Méthode appelée lorsque la structure d'un noeud a été modifiée
		*/
		public void treeStructureChanged (TreeModelEvent event) {
		System.out.println("La structure d'un noeud a changé !" );
		}
	});
	
	//Si nous avons parcouru plus de 50 dossiers, on sort
	//if(count > 50) {break;}
	//On crée, avec notre hiérarchie, un arbre
	arbre = new JTree(this.racine);
	arbre.setModel(model);
	arbre.setEditable(true);
	//arbre.setCellRenderer(this.tCellRenderer[0]);
	//Que nous plaçons sur le ContentPane de notre JFrame à l'aided'un scroll
	arbre.setRootVisible(false);
	arbre.addMouseListener(new MouseAdapter(){
		//Lorsque nous cliquons avec la souris
		public void mousePressed(MouseEvent event) {
		//Lors d'un clic droit
		if(event.getButton() == MouseEvent.BUTTON3){
		System.out.println("Clic droit détecté ! !");
		//Si on a cliqué sur l'arbre, on peut récupérer l'indice de la ligneavec cette méthode
		//Sinon, la méthode retourne -1
		if(arbre.getRowForLocation(event.getX(), event.getY()) != -1){
		//On peut récupérer le chemin du noeud qui a généré l'événement
		arbre.setSelectionPath(arbre.getPathForLocation(event.getX(),
		event.getY()));
		System.out.println("Noeud sélectionné : " +
		((DefaultMutableTreeNode)arbre.getLastSelectedPathComponent()).toString());
		//On peut donc en déduire le noeud et le parent
		DefaultMutableTreeNode node =
		(DefaultMutableTreeNode)arbre.getLastSelectedPathComponent();
		DefaultMutableTreeNode parentNode =
		(DefaultMutableTreeNode)node.getParent();
		//On n'a plus qu'à générer notre menu contextuel !
		JPopupMenu jpm = new JPopupMenu();
		eraseMenu = new JMenuItem("Effacer ce noeud");
		eraseMenu.addActionListener(new EraseMenuListener(parentNode, node));
		jpm.add(eraseMenu);
		jpm.show(arbre, event.getX(), event.getY());
		//Et le tour est joué ! ! !
		}
		}
		}
		});
	arbre.addTreeSelectionListener(new TreeSelectionListener(){
		public void valueChanged(TreeSelectionEvent event) {
		if(arbre.getLastSelectedPathComponent() != null){
		//La méthode getPath retourne un objet TreePath
			File file= new File(getAbsolutePath(event.getPath()));
			panneau.setTexte(getDescription(file));
		}
		}
		private String getAbsolutePath(TreePath treePath){
		String str = "";
		//On balaie le contenu de notre TreePath
		for(Object name : treePath.getPath()){
		//Si l'objet à un nom, on l'ajoute au chemin
		if(name.toString() != null)
		str += name.toString();
		}
		return str;
		}
		private String getDescription(File file){
			String str = "Chemin d'accès sur le disque : \n\t" +
					file.getAbsolutePath() + "\n";
					str += (file.isFile()) ? "Je suis un fichier.\nJe fais " +
					file.length() + " ko\n" : "Je suis un dossier.\n";
					str += "J'ai des droits : \n";
					str += "\t en lecture : " + ((file.canRead()) ? "Oui;" :
					"Non;");
					str += "\n\t en écriture : " + ((file.canWrite()) ? "Oui;" :
					"Non;");
					return str;
					}
		});
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(arbre), new JScrollPane(panneau));
			//On place le séparateur
			split.setDividerLocation(200);
			//On ajoute le tout
			this.getContentPane().add(split, BorderLayout.CENTER);
	}
	}
	private DefaultMutableTreeNode listFile(File file,
	DefaultMutableTreeNode node){
	int count = 0;
	if(file.isFile())
	return new DefaultMutableTreeNode(file.getName());
	else{
	for(File nom : file.listFiles()){
	count++;
	//pas plus de 5 enfants par noeud
	if(count < 5){
	DefaultMutableTreeNode subNode;
	if(nom.isDirectory()){
	subNode = new DefaultMutableTreeNode(nom.getName()+"\\");
	node.add(this.listFile(nom, subNode));
	}else{
	subNode = new DefaultMutableTreeNode(nom.getName());
	}
	node.add(subNode);
	}
	}
	return node;
	}
	}
	public static void main(String[] args){
		UIManager.LookAndFeelInfo[] looks =UIManager.getInstalledLookAndFeels();
				TreeFile fen;
				//On parcourt tout le tableau en passant le nom du look à utiliser
				for(int i = 0; i < looks.length; i++) {
				fen = new TreeFile(looks[i].getClassName());
				System.out.println(looks[i].getClassName());
				}
	}
	class EraseMenuListener implements ActionListener{
		//Nous allons nous servir de ces deux objets
		DefaultMutableTreeNode parentNode, node;
		public EraseMenuListener(DefaultMutableTreeNode parent,DefaultMutableTreeNode node){
		this.parentNode = parent;
		this.node = node;
		}
		//Ici, vous connaissez !
		public void actionPerformed (ActionEvent e) {
		model.removeNodeFromParent(this.node);
		model.nodeChanged(this.parentNode);
		}
		}
}
