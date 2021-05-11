// Compilation Unit of /CheckboxTableModel.java 
 
package org.argouml.ui;
import javax.swing.table.AbstractTableModel;
public class CheckboxTableModel extends AbstractTableModel
  { 
private Object[][] elements;
private String columnName1, columnName2;
private static final long serialVersionUID = 111532940880908401L;
public Class getColumnClass(int col)
    { 
if(col == 0)//1
{ 
return String.class;
} 
else
if(col == 1)//1
{ 
return Boolean.class;
} 
else
if(col == 2)//1
{ 
return Object.class;
} 



return null;
} 

public boolean isCellEditable(int row, int col)
    { 
return col == 1 && row < elements.length;
} 

public int getColumnCount()
    { 
return 2;
} 

public int getRowCount()
    { 
return elements.length;
} 

public CheckboxTableModel(
        Object[] labels, Object[] data,
        String colName1, String colName2)
    { 
elements = new Object[labels.length][3];
for (int i = 0; i < elements.length; i++) //1
{ 
elements[i][0] = labels[i];
elements[i][1] = Boolean.TRUE;
if(data != null && i < data.length)//1
{ 
elements[i][2] = data[i];
} 
else
{ 
elements[i][2] = null;
} 

} 

columnName1 = colName1;
columnName2 = colName2;
} 

public void setValueAt(Object ob, int row, int col)
    { 
elements[row][col] = ob;
} 

public Object getValueAt(int row, int col)
    { 
if(row < elements.length && col < 3)//1
{ 
return elements[row][col];
} 
else
{ 
throw new IllegalArgumentException("Index out of bounds");
} 

} 

public String getColumnName(int col)
    { 
if(col == 0)//1
{ 
return columnName1;
} 
else
if(col == 1)//1
{ 
return columnName2;
} 


return null;
} 

 } 


