
//#if -1711557802 
// Compilation Unit of /SettingsTabModules.java 
 

//#if 222789551 
package org.argouml.moduleloader;
//#endif 


//#if -435121404 
import java.awt.BorderLayout;
//#endif 


//#if 77091666 
import java.util.Iterator;
//#endif 


//#if -1473881182 
import java.util.List;
//#endif 


//#if 1303270382 
import javax.swing.JLabel;
//#endif 


//#if 1418144478 
import javax.swing.JPanel;
//#endif 


//#if -309856449 
import javax.swing.JScrollPane;
//#endif 


//#if 1532310100 
import javax.swing.JTable;
//#endif 


//#if 561701557 
import javax.swing.JTextField;
//#endif 


//#if -45500965 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -939966173 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if 2133403529 
import org.argouml.i18n.Translator;
//#endif 


//#if -1136782041 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if 1639092247 
class SettingsTabModules extends 
//#if 2039456753 
JPanel
//#endif 

 implements 
//#if -294515861 
GUISettingsTabInterface
//#endif 

  { 

//#if 2037188381 
private JTable table;
//#endif 


//#if 1360005930 
private JTextField fieldAllExtDirs;
//#endif 


//#if -589501334 
private String[] columnNames = {
        Translator.localize("misc.column-name.module"),
        Translator.localize("misc.column-name.enabled"),
    };
//#endif 


//#if 1971679125 
private Object[][] elements;
//#endif 


//#if 728078168 
private static final long serialVersionUID = 8945027241102020504L;
//#endif 


//#if -1391190419 
SettingsTabModules()
    { 
} 

//#endif 


//#if -141846388 
public JPanel getTabPanel()
    { 

//#if 644904970 
if(table == null)//1
{ 

//#if -1251852358 
setLayout(new BorderLayout());
//#endif 


//#if 1969530580 
table = new JTable(new ModuleTableModel());
//#endif 


//#if -975878113 
table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//#endif 


//#if 340015659 
table.setShowVerticalLines(true);
//#endif 


//#if -1691031427 
add(new JScrollPane(table), BorderLayout.CENTER);
//#endif 


//#if -125411171 
int labelGap = 10;
//#endif 


//#if -531808978 
int componentGap = 5;
//#endif 


//#if -71275966 
JPanel top = new JPanel(new LabelledLayout(labelGap, componentGap));
//#endif 


//#if -442431607 
JLabel label = new JLabel(
                Translator.localize("label.extension-directories"));
//#endif 


//#if -69243904 
JTextField j = new JTextField();
//#endif 


//#if 5394337 
fieldAllExtDirs = j;
//#endif 


//#if 1050997293 
fieldAllExtDirs.setEnabled(false);
//#endif 


//#if 2127390548 
label.setLabelFor(fieldAllExtDirs);
//#endif 


//#if -2133692717 
top.add(label);
//#endif 


//#if 1887469471 
top.add(fieldAllExtDirs);
//#endif 


//#if -1603649296 
add(top, BorderLayout.NORTH);
//#endif 

} 

//#endif 


//#if 1371186325 
return this;
//#endif 

} 

//#endif 


//#if -344970575 
public void handleSettingsTabCancel()
    { 
} 

//#endif 


//#if -998729936 
public String getTabKey()
    { 

//#if 2143589260 
return "tab.modules";
//#endif 

} 

//#endif 


//#if 101382484 
public void handleResetToDefault()
    { 
} 

//#endif 


//#if 1995374196 
public void handleSettingsTabSave()
    { 

//#if 1305998067 
if(elements != null)//1
{ 

//#if -1570583154 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if 968259807 
ModuleLoader2.setSelected(
                    (String) elements[i][0],
                    ((Boolean) elements[i][1]).booleanValue());
//#endif 

} 

//#endif 


//#if -224850730 
ModuleLoader2.doLoad(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1149720102 
public void handleSettingsTabRefresh()
    { 

//#if 1942681568 
table.setModel(new ModuleTableModel());
//#endif 


//#if 1480369343 
StringBuffer sb = new StringBuffer();
//#endif 


//#if 436200934 
List locations = ModuleLoader2.getInstance().getExtensionLocations();
//#endif 


//#if 1729022970 
for (Iterator it = locations.iterator(); it.hasNext();) //1
{ 

//#if -414870068 
sb.append((String) it.next());
//#endif 


//#if 510014029 
sb.append("\n");
//#endif 

} 

//#endif 


//#if -313954134 
fieldAllExtDirs.setText(sb.substring(0, sb.length() - 1).toString());
//#endif 

} 

//#endif 


//#if 1564404776 
class ModuleTableModel extends 
//#if -759994019 
AbstractTableModel
//#endif 

  { 

//#if -136546445 
private static final long serialVersionUID = -5970280716477119863L;
//#endif 


//#if 1728848742 
public int getRowCount()
        { 

//#if 1187000266 
return elements.length;
//#endif 

} 

//#endif 


//#if 1565674696 
public void setValueAt(Object ob, int row, int col)
        { 

//#if 1230637686 
elements[row][col] = ob;
//#endif 

} 

//#endif 


//#if 1297876873 
public Object getValueAt(int row, int col)
        { 

//#if -1638077630 
if(row < elements.length)//1
{ 

//#if -453751328 
return elements[row][col];
//#endif 

} 
else
{ 

//#if -72251559 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 115941069 
public String getColumnName(int col)
        { 

//#if -444800855 
return columnNames[col];
//#endif 

} 

//#endif 


//#if 769344458 
public int getColumnCount()
        { 

//#if 298244166 
return columnNames.length;
//#endif 

} 

//#endif 


//#if 1105886256 
public boolean isCellEditable(int row, int col)
        { 

//#if -1593064761 
return col >= 1 && row < elements.length;
//#endif 

} 

//#endif 


//#if -2029295541 
public Class getColumnClass(int col)
        { 

//#if -1875863604 
switch (col) //1
{ 
case 0://1


//#if 240084457 
return String.class;
//#endif 


case 1://1


//#if -945127412 
return Boolean.class;
//#endif 


default://1


//#if 1381395322 
return null;
//#endif 


} 

//#endif 

} 

//#endif 


//#if -142134127 
public ModuleTableModel()
        { 

//#if -1170570541 
Object[] arr = ModuleLoader2.allModules().toArray();
//#endif 


//#if -1833119019 
elements = new Object[arr.length][2];
//#endif 


//#if 1372751241 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -1377518105 
elements[i][0] = arr[i];
//#endif 


//#if 1851578690 
elements[i][1] =
                    Boolean.valueOf(ModuleLoader2.isSelected((String) arr[i]));
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

