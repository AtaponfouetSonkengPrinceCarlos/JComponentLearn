import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
public class Fenetre extends JFrame {
	private JButton change = new JButton("Changer la taille");
	private JButton retablir = new JButton("Rétablir");
	private String[] comboData = {"Très bien", "Bien", "Mal"};
	private String supp = "Supprimer la ligne";
	JTable tableau;
	public Fenetre(){
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTable");
		this.setSize(600, 500);
		//Les données du tableau
		Object[][] data = { {"Cysboy", "6boy", comboData[0], new
			Boolean(true), supp},
			{"BZHHydde", "BZH", comboData[0], new Boolean(false), supp},
			{"IamBow", "BoW", comboData[0], new Boolean(false), supp},
			{"FunMan", "Year", comboData[0], new Boolean(true), supp}
			};
		String title[] = {"Pseudo", "Age", "Taille", "OK ?","Suppression"};
			JComboBox combo = new JComboBox(comboData);
			ZModel zModel = new ZModel(data, title);
			this.tableau = new JTable(zModel);
	   this.tableau.getColumn("Taille").setCellEditor(new DefaultCellEditor(combo));
	   this.tableau.getColumn("Age").setCellRenderer(new ButtonRenderer());
	   this.tableau.getColumn("Age").setCellEditor(new ButtonEditor(new JCheckBox()));
	   DefaultTableCellRenderer dcr = new DefaultTableCellRenderer();
	   this.tableau.getColumn("Taille").setCellRenderer(dcr);
	   this.tableau.getColumn("Suppression").setCellEditor(new
			   DeleteButtonEditor(new JCheckBox()));
		//On ajoute notre tableau à notre contentPane dans un scroll
		//Sinon les titres des colonnes ne s'afficheront pas! !
		this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
		JButton ajouter = new JButton("Ajouter une ligne");
		ajouter.addActionListener(new MoreListener());
		this.getContentPane().add(ajouter, BorderLayout.SOUTH);
		JPanel pan = new JPanel();
		change.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent arg0) {
		changeSize(200, 80);
		change.setEnabled(false);
		retablir.setEnabled(true);
		}
		});
		retablir.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent arg0) {
		changeSize(75,16);
		change.setEnabled(true);
		retablir.setEnabled(false);
		}
		});
		retablir.setEnabled(false);
		pan.add(change);
		pan.add(retablir);
		//On remplace cette ligne
		this.getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
		}
		public static void main(String[] args){
		Fenetre fen = new Fenetre();
		fen.setVisible(true);
		}
		public void changeSize(int width, int height){
			//On crée un objet TableColumn afin de travailler sur notrecolonne
			TableColumn col;
			for(int i = 0; i < tableau.getColumnCount(); i++){
			if(i == 1){
			//On récupère le modèle de la colonne
			col = tableau.getColumnModel().getColumn(i);
			//On lui affecte la nouvelle valeur
			col.setPreferredWidth(width);
			}
			}
			for(int i = 0; i < tableau.getRowCount(); i++){
			//On affecte la taille de la ligne à l'indice spécifié !
			if(i == 1)
			tableau.setRowHeight(i, height);
			}
			}
		class ZModel extends AbstractTableModel{
			private Object[][] data;
			private String[] title;
			/**
			* Constructeur
			* @param data
			* @param title
			*/
			public ZModel(Object[][] data, String[] title){
			this.data = data;
			this.title = title;
			}
			/**
			* Retourne le nombre de colonnes
			*/
			public int getColumnCount() {
			return this.title.length;
			}
			/**
			* Retourne le nombre de lignes
			*/
			public int getRowCount() {
			return this.data.length;
			}
			/**
			* Retourne la valeur à l'emplacement spécifié
			*/
			public Object getValueAt(int row, int col) {
				return this.data[row][col];
			}
			public String getColumnName(int col) {
				System.out.println("NNN"+title[col]);
				return this.title[col];
				}
			public void setValueAt(Object value, int row, int col) {
				//On interdit la modification sur certaine colonne !
				if(!this.getColumnName(col).equals("Age") &&
				!this.getColumnName(col).equals("Suppression"))
				this.data[row][col] = value;
				}
			public boolean isCellEditable(int row, int col){
					return true;
				}
			public void removeRow(int position){
				int indice = 0, indice2 = 0, nbRow = this.getRowCount()-1, nbCol
				= this.getColumnCount();
				Object temp[][] = new Object[nbRow][nbCol];
				for(Object[] value : this.data){
				if(indice != position){
				temp[indice2++] = value;
				System.out.println("temp remove content  "+temp[indice2-1]);
				System.out.println("position"+position);
				}
				System.out.println("Indice = " + indice);
				indice++;
				}
				this.data = temp;
				temp = null;
				//Cette méthode permet d'avertir le tableau que les données ontété modifiées
				//Ce qui permet une mise à jours complète du tableau
				this.fireTableDataChanged ();
				}
				/**
				* Permet d'ajouter une ligne dans le tableau
				* @param data
				*/
				public void addRow(Object[] data){
				int indice = 0, nbRow = this.getRowCount(), nbCol =
				this.getColumnCount();
				Object temp[][] = this.data;
				this.data = new Object[nbRow+1][nbCol];
				for(Object[] value : temp)
				this.data[indice++] = value;
				this.data[indice] = data;
				temp = null;
				//Cette méthode permet d'avertir le tableau que les données ontété modifiées
				//Ce qui permet une mise à jours complète du tableau
				this.fireTableDataChanged ();
				}
			}
		public class DeleteButtonEditor extends DefaultCellEditor {
			protected JButton button;
			private DeleteButtonListener bListener = new
			DeleteButtonListener();
			/**
			* Constructeur avec une checkBox
			* @param checkBox
			* @param count
			*/
			public DeleteButtonEditor(JCheckBox checkBox) {
			//Par défaut, ce type d'objet travaille avec un JCheckBox
			super(checkBox);
			//On crée à nouveau notre bouton
			button = new JButton();
			button.setOpaque(true);
			//On lui attribue un listener
			button.addActionListener(bListener);
			}
			public Component getTableCellEditorComponent(JTable table, Object
			value,
			boolean isSelected, int row, int column) {
			//On définit le numéro de lignes à notre listener
			bListener.setRow(row);
			//On passe aussi le tableau pour des actions potentielles
			bListener.setTable(table);
			//On réaffecte le libellé au bouton
			button.setText( (value ==null) ? "" : value.toString() );
			//On renvoie le bouton
			return button;
			}
			/**
			* Notre listener pour le bouton
			* @author CHerby
			*
			*/
			class DeleteButtonListener implements ActionListener{
			private int row;
			private JTable table;
			public void setRow(int row){this.row = row;}
			public void setTable(JTable table){this.table = table;}
			public void actionPerformed (ActionEvent event) {
			if(table.getRowCount() > 0){
			//On affiche un Zoli message mais vous pourriez faire les traitements que vous voulez
			System.out.println("coucou du bouton : " +
			((JButton)event.getSource()).getText() );
			//On affecte un nouveau libellé à une celulle de la ligne
			((ZModel)table.getModel()).removeRow(this.row);
			
			}}
			}

		}

		class MoreListener implements ActionListener{
			public void actionPerformed (ActionEvent event) {
			Object[] donnee = new Object[]{"Angelo", "Rennais", comboData[0],
			new Boolean(false), supp};
			((ZModel)tableau.getModel()).addRow(donnee);
			}}
}
