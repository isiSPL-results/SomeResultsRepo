// Compilation Unit of /SourcePathDialog.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import org.argouml.i18n.Translator;
import org.argouml.util.ArgoDialog;
public class SourcePathDialog extends ArgoDialog
 implements ActionListener
  { 
private SourcePathController srcPathCtrl = new SourcePathControllerImpl();
private SourcePathTableModel srcPathTableModel =
        srcPathCtrl.getSourcePathSettings();
private JTable srcPathTable;
private JButton delButton;
private ListSelectionModel rowSM;
public SourcePathDialog()
    { 
super(
            Translator.localize("action.generate-code-for-project"),
            ArgoDialog.OK_CANCEL_OPTION,
            true);
srcPathTable = new JTable();
srcPathTable.setModel(srcPathTableModel);
srcPathTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
TableColumn elemCol = srcPathTable.getColumnModel().getColumn(0);
elemCol.setMinWidth(0);
elemCol.setMaxWidth(0);
delButton = new JButton(Translator.localize("button.delete"));
delButton.setEnabled(false);
addButton(delButton, 0);
rowSM = srcPathTable.getSelectionModel();
rowSM.addListSelectionListener(new SelectionListener());
delButton.addActionListener(this);
setContent(new JScrollPane(srcPathTable));
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() == getOkButton())//1
{ 
buttonOkActionPerformed();
} 

if(e.getSource() == delButton)//1
{ 
deleteSelectedSettings();
} 

} 

private void buttonOkActionPerformed()
    { 
srcPathCtrl.setSourcePath(srcPathTableModel);
} 

private int[] getSelectedIndexes()
    { 
int firstSelectedRow = rowSM.getMinSelectionIndex();
int lastSelectedRow = rowSM.getMaxSelectionIndex();
LinkedList selectedIndexesList = new LinkedList();
int numSelectedRows = 0;
for (int i = firstSelectedRow; i <= lastSelectedRow; i++) //1
{ 
if(rowSM.isSelectedIndex(i))//1
{ 
numSelectedRows++;
selectedIndexesList.add(Integer.valueOf(i));
} 

} 

int[] indexes = new int[selectedIndexesList.size()];
java.util.Iterator it = selectedIndexesList.iterator();
for (int i = 0; i < indexes.length && it.hasNext(); i++) //1
{ 
indexes[i] = ((Integer) it.next()).intValue();
} 

return indexes;
} 

private void deleteSelectedSettings()
    { 
int[] selectedIndexes = getSelectedIndexes();
StringBuffer msg = new StringBuffer();
msg.append(Translator.localize("dialog.source-path-del.question"));
for (int i = 0; i < selectedIndexes.length; i++) //1
{ 
msg.append("\n");
msg.append(srcPathTableModel.getMEName(selectedIndexes[i]));
msg.append(" (");
msg.append(srcPathTableModel.getMEType(selectedIndexes[i]));
msg.append(")");
} 

int res = JOptionPane.showConfirmDialog(this,
                                                msg.toString(),
                                                Translator.localize("dialog.title.source-path-del"),
                                                JOptionPane.OK_CANCEL_OPTION);
if(res == JOptionPane.OK_OPTION)//1
{ 
int firstSel = rowSM.getMinSelectionIndex();
for (int i = 0; i < selectedIndexes.length && firstSel != -1; i++) //1
{ 
srcPathCtrl.deleteSourcePath(srcPathTableModel
                                             .getModelElement(firstSel));
srcPathTableModel.removeRow(firstSel);
firstSel = rowSM.getMinSelectionIndex();
} 

delButton.setEnabled(false);
} 

} 

class SelectionListener implements ListSelectionListener
  { 
public void valueChanged(javax.swing.event.ListSelectionEvent e)
        { 
if(!delButton.isEnabled())//1
{ 
delButton.setEnabled(true);
} 

} 

 } 

 } 


