
//#if 542852686 
// Compilation Unit of /SourcePathDialog.java 
 

//#if -1546665252 
package org.argouml.uml.ui;
//#endif 


//#if 1290420080 
import java.awt.event.ActionEvent;
//#endif 


//#if 1698018584 
import java.awt.event.ActionListener;
//#endif 


//#if 1558014285 
import java.util.LinkedList;
//#endif 


//#if -611517570 
import javax.swing.JButton;
//#endif 


//#if 1650306067 
import javax.swing.JOptionPane;
//#endif 


//#if -220756805 
import javax.swing.JScrollPane;
//#endif 


//#if 615130968 
import javax.swing.JTable;
//#endif 


//#if -84365055 
import javax.swing.ListSelectionModel;
//#endif 


//#if -531514516 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 125612886 
import javax.swing.table.TableColumn;
//#endif 


//#if 247305989 
import org.argouml.i18n.Translator;
//#endif 


//#if -1651914142 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -683002907 
public class SourcePathDialog extends 
//#if 958107923 
ArgoDialog
//#endif 

 implements 
//#if -299002468 
ActionListener
//#endif 

  { 

//#if -1779978924 
private SourcePathController srcPathCtrl = new SourcePathControllerImpl();
//#endif 


//#if 399298112 
private SourcePathTableModel srcPathTableModel =
        srcPathCtrl.getSourcePathSettings();
//#endif 


//#if -778463327 
private JTable srcPathTable;
//#endif 


//#if -385514327 
private JButton delButton;
//#endif 


//#if -61057933 
private ListSelectionModel rowSM;
//#endif 


//#if 615212932 
public SourcePathDialog()
    { 

//#if 1533284534 
super(
            Translator.localize("action.generate-code-for-project"),
            ArgoDialog.OK_CANCEL_OPTION,
            true);
//#endif 


//#if 1603275302 
srcPathTable = new JTable();
//#endif 


//#if -633384074 
srcPathTable.setModel(srcPathTableModel);
//#endif 


//#if -1298572819 
srcPathTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 460526359 
TableColumn elemCol = srcPathTable.getColumnModel().getColumn(0);
//#endif 


//#if 382664875 
elemCol.setMinWidth(0);
//#endif 


//#if -91761191 
elemCol.setMaxWidth(0);
//#endif 


//#if -1507616179 
delButton = new JButton(Translator.localize("button.delete"));
//#endif 


//#if 1752639621 
delButton.setEnabled(false);
//#endif 


//#if -1361903626 
addButton(delButton, 0);
//#endif 


//#if -689257313 
rowSM = srcPathTable.getSelectionModel();
//#endif 


//#if -102740040 
rowSM.addListSelectionListener(new SelectionListener());
//#endif 


//#if -1665747994 
delButton.addActionListener(this);
//#endif 


//#if -582591178 
setContent(new JScrollPane(srcPathTable));
//#endif 

} 

//#endif 


//#if 1747017787 
public void actionPerformed(ActionEvent e)
    { 

//#if 73130065 
super.actionPerformed(e);
//#endif 


//#if -1501017478 
if(e.getSource() == getOkButton())//1
{ 

//#if 958725322 
buttonOkActionPerformed();
//#endif 

} 

//#endif 


//#if 2109811314 
if(e.getSource() == delButton)//1
{ 

//#if -1347898458 
deleteSelectedSettings();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 425649880 
private void buttonOkActionPerformed()
    { 

//#if 1418121712 
srcPathCtrl.setSourcePath(srcPathTableModel);
//#endif 

} 

//#endif 


//#if -2065320496 
private int[] getSelectedIndexes()
    { 

//#if 582243234 
int firstSelectedRow = rowSM.getMinSelectionIndex();
//#endif 


//#if 845862982 
int lastSelectedRow = rowSM.getMaxSelectionIndex();
//#endif 


//#if 1708821073 
LinkedList selectedIndexesList = new LinkedList();
//#endif 


//#if -1181429856 
int numSelectedRows = 0;
//#endif 


//#if -1506930630 
for (int i = firstSelectedRow; i <= lastSelectedRow; i++) //1
{ 

//#if -634849022 
if(rowSM.isSelectedIndex(i))//1
{ 

//#if 929366 
numSelectedRows++;
//#endif 


//#if 34802601 
selectedIndexesList.add(Integer.valueOf(i));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2015981126 
int[] indexes = new int[selectedIndexesList.size()];
//#endif 


//#if 551968794 
java.util.Iterator it = selectedIndexesList.iterator();
//#endif 


//#if 1336691930 
for (int i = 0; i < indexes.length && it.hasNext(); i++) //1
{ 

//#if 2057278062 
indexes[i] = ((Integer) it.next()).intValue();
//#endif 

} 

//#endif 


//#if 306517864 
return indexes;
//#endif 

} 

//#endif 


//#if 1612441039 
private void deleteSelectedSettings()
    { 

//#if -610371414 
int[] selectedIndexes = getSelectedIndexes();
//#endif 


//#if -44920962 
StringBuffer msg = new StringBuffer();
//#endif 


//#if 2145773888 
msg.append(Translator.localize("dialog.source-path-del.question"));
//#endif 


//#if -1487441025 
for (int i = 0; i < selectedIndexes.length; i++) //1
{ 

//#if -1892823486 
msg.append("\n");
//#endif 


//#if -1425055722 
msg.append(srcPathTableModel.getMEName(selectedIndexes[i]));
//#endif 


//#if 1045697900 
msg.append(" (");
//#endif 


//#if 246626181 
msg.append(srcPathTableModel.getMEType(selectedIndexes[i]));
//#endif 


//#if 1045727691 
msg.append(")");
//#endif 

} 

//#endif 


//#if -512281871 
int res = JOptionPane.showConfirmDialog(this,
                                                msg.toString(),
                                                Translator.localize("dialog.title.source-path-del"),
                                                JOptionPane.OK_CANCEL_OPTION);
//#endif 


//#if 1305204060 
if(res == JOptionPane.OK_OPTION)//1
{ 

//#if -1919006619 
int firstSel = rowSM.getMinSelectionIndex();
//#endif 


//#if -336729348 
for (int i = 0; i < selectedIndexes.length && firstSel != -1; i++) //1
{ 

//#if -1148871691 
srcPathCtrl.deleteSourcePath(srcPathTableModel
                                             .getModelElement(firstSel));
//#endif 


//#if 1765483080 
srcPathTableModel.removeRow(firstSel);
//#endif 


//#if -2097098853 
firstSel = rowSM.getMinSelectionIndex();
//#endif 

} 

//#endif 


//#if -1141948750 
delButton.setEnabled(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1400056378 
class SelectionListener implements 
//#if -1093339652 
ListSelectionListener
//#endif 

  { 

//#if -1215625426 
public void valueChanged(javax.swing.event.ListSelectionEvent e)
        { 

//#if 681948779 
if(!delButton.isEnabled())//1
{ 

//#if -1582494126 
delButton.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

