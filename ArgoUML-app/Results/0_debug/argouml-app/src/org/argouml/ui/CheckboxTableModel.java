
//#if -1024906636 
// Compilation Unit of /CheckboxTableModel.java 
 

//#if -284204404 
package org.argouml.ui;
//#endif 


//#if -1522436215 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -2038596699 
public class CheckboxTableModel extends 
//#if -1012611535 
AbstractTableModel
//#endif 

  { 

//#if -286039726 
private Object[][] elements;
//#endif 


//#if 400897670 
private String columnName1, columnName2;
//#endif 


//#if 42862141 
private static final long serialVersionUID = 111532940880908401L;
//#endif 


//#if -1367193353 
public Class getColumnClass(int col)
    { 

//#if 2028482349 
if(col == 0)//1
{ 

//#if -672105561 
return String.class;
//#endif 

} 
else

//#if -1647574858 
if(col == 1)//1
{ 

//#if -430075709 
return Boolean.class;
//#endif 

} 
else

//#if -2098970073 
if(col == 2)//1
{ 

//#if 1765115007 
return Object.class;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -776457074 
return null;
//#endif 

} 

//#endif 


//#if -2088264444 
public boolean isCellEditable(int row, int col)
    { 

//#if -330214018 
return col == 1 && row < elements.length;
//#endif 

} 

//#endif 


//#if 1852018806 
public int getColumnCount()
    { 

//#if -82822873 
return 2;
//#endif 

} 

//#endif 


//#if -1818560966 
public int getRowCount()
    { 

//#if -36077307 
return elements.length;
//#endif 

} 

//#endif 


//#if 930476862 
public CheckboxTableModel(
        Object[] labels, Object[] data,
        String colName1, String colName2)
    { 

//#if 414361668 
elements = new Object[labels.length][3];
//#endif 


//#if -11058483 
for (int i = 0; i < elements.length; i++) //1
{ 

//#if -288716273 
elements[i][0] = labels[i];
//#endif 


//#if -111002558 
elements[i][1] = Boolean.TRUE;
//#endif 


//#if -1002672688 
if(data != null && i < data.length)//1
{ 

//#if 1736091874 
elements[i][2] = data[i];
//#endif 

} 
else
{ 

//#if -168876764 
elements[i][2] = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 992352300 
columnName1 = colName1;
//#endif 


//#if -804599028 
columnName2 = colName2;
//#endif 

} 

//#endif 


//#if -1406498660 
public void setValueAt(Object ob, int row, int col)
    { 

//#if -2113605976 
elements[row][col] = ob;
//#endif 

} 

//#endif 


//#if 668643893 
public Object getValueAt(int row, int col)
    { 

//#if -1918922243 
if(row < elements.length && col < 3)//1
{ 

//#if 1086340711 
return elements[row][col];
//#endif 

} 
else
{ 

//#if -175802110 
throw new IllegalArgumentException("Index out of bounds");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 778043257 
public String getColumnName(int col)
    { 

//#if -2064227524 
if(col == 0)//1
{ 

//#if 989706875 
return columnName1;
//#endif 

} 
else

//#if -2137532581 
if(col == 1)//1
{ 

//#if 1939661547 
return columnName2;
//#endif 

} 

//#endif 


//#endif 


//#if 747774045 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

