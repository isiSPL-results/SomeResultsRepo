package org.argouml.moduleloader;
import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.i18n.Translator;
import org.tigris.swidgets.LabelledLayout;
class SettingsTabModules extends JPanel
 implements GUISettingsTabInterface
  { 
private JTable table;
private JTextField fieldAllExtDirs;
private String[] columnNames = {
        Translator.localize("misc.column-name.module"),
        Translator.localize("misc.column-name.enabled"),
    };
private Object[][] elements;
private static final long serialVersionUID = 8945027241102020504L;
SettingsTabModules()
    { 
} 
public JPanel getTabPanel()
    { 
if(table == null)//1
{ 
setLayout(new BorderLayout());
table = new JTable(new ModuleTableModel());
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
table.setShowVerticalLines(true);
add(new JScrollPane(table), BorderLayout.CENTER);
int labelGap = 10;
int componentGap = 5;
JPanel top = new JPanel(new LabelledLayout(labelGap, componentGap));
JLabel label = new JLabel(
                Translator.localize("label.extension-directories"));
JTextField j = new JTextField();
fieldAllExtDirs = j;
fieldAllExtDirs.setEnabled(false);
label.setLabelFor(fieldAllExtDirs);
top.add(label);
top.add(fieldAllExtDirs);
add(top, BorderLayout.NORTH);
} 
return this;
} 
public void handleSettingsTabCancel()
    { 
} 
public String getTabKey()
    { 
return "tab.modules";
} 
public void handleResetToDefault()
    { 
} 
public void handleSettingsTabSave()
    { 
if(elements != null)//1
{ 
for (int i = 0; i < elements.length; i++) //1
{ 
ModuleLoader2.setSelected(
                    (String) elements[i][0],
                    ((Boolean) elements[i][1]).booleanValue());
} 
ModuleLoader2.doLoad(false);
} 
} 
public void handleSettingsTabRefresh()
    { 
table.setModel(new ModuleTableModel());
StringBuffer sb = new StringBuffer();
List locations = ModuleLoader2.getInstance().getExtensionLocations();
for (Iterator it = locations.iterator(); it.hasNext();) //1
{ 
sb.append((String) it.next());
sb.append("\n");
} 
fieldAllExtDirs.setText(sb.substring(0, sb.length() - 1).toString());
} 
class ModuleTableModel extends AbstractTableModel
  { 
private static final long serialVersionUID = -5970280716477119863L;
public int getRowCount()
        { 
return elements.length;
} 
public void setValueAt(Object ob, int row, int col)
        { 
elements[row][col] = ob;
} 
public Object getValueAt(int row, int col)
        { 
if(row < elements.length)//1
{ 
return elements[row][col];
} 
else
{ 
return null;
} 
} 
public String getColumnName(int col)
        { 
return columnNames[col];
} 
public int getColumnCount()
        { 
return columnNames.length;
} 
public boolean isCellEditable(int row, int col)
        { 
return col >= 1 && row < elements.length;
} 
public Class getColumnClass(int col)
        { 
switch (col) //1
{ 
case 0://1

return String.class;

case 1://1

return Boolean.class;

default://1

return null;

} 
} 
public ModuleTableModel()
        { 
Object[] arr = ModuleLoader2.allModules().toArray();
elements = new Object[arr.length][2];
for (int i = 0; i < elements.length; i++) //1
{ 
elements[i][0] = arr[i];
elements[i][1] =
                    Boolean.valueOf(ModuleLoader2.isSelected((String) arr[i]));
} 
} 

 } 

 } 
