import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
