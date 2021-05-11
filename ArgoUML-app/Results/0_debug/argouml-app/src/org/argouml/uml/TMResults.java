
//#if -1839917005 
// Compilation Unit of /TMResults.java 
 

//#if -484518662 
package org.argouml.uml;
//#endif 


//#if 324975272 
import java.util.List;
//#endif 


//#if -745903007 
import javax.swing.table.AbstractTableModel;
//#endif 


//#if -1477057981 
import org.argouml.i18n.Translator;
//#endif 


//#if 1366312585 
import org.argouml.model.Model;
//#endif 


//#if -1713379991 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -1162581190 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 451591710 
public class TMResults extends 
//#if -1218763050 
AbstractTableModel
//#endif 

  { 

//#if 1019353785 
private List rowObjects;
//#endif 


//#if 878468048 
private List<UMLDiagram> diagrams;
//#endif 


//#if 842714290 
private boolean showInDiagramColumn;
//#endif 


//#if -973010862 
private static final long serialVersionUID = -1444599676429024575L;
//#endif 


//#if -955615889 
public Class getColumnClass(int c)
    { 

//#if -1896381232 
return String.class;
//#endif 

} 

//#endif 


//#if -1333271439 
public String getColumnName(int c)
    { 

//#if 1595794735 
if(c == 0)//1
{ 

//#if -886614603 
return Translator.localize("dialog.find.column-name.type");
//#endif 

} 

//#endif 


//#if 1596718256 
if(c == 1)//1
{ 

//#if -1546155906 
return Translator.localize("dialog.find.column-name.name");
//#endif 

} 

//#endif 


//#if 1597641777 
if(c == 2)//1
{ 

//#if 1628710486 
return Translator.localize(showInDiagramColumn
                                       ? "dialog.find.column-name.in-diagram"
                                       : "dialog.find.column-name.description");
//#endif 

} 

//#endif 


//#if 1598565298 
if(c == 3)//1
{ 

//#if 543960758 
return Translator.localize("dialog.find.column-name.description");
//#endif 

} 

//#endif 


//#if -1274308944 
return "XXX";
//#endif 

} 

//#endif 


//#if -2059428183 
public boolean isCellEditable(int row, int col)
    { 

//#if 409522780 
return false;
//#endif 

} 

//#endif 


//#if 1726159921 
public int getColumnCount()
    { 

//#if 216778325 
return showInDiagramColumn ? 4 : 3;
//#endif 

} 

//#endif 


//#if -275028260 
public TMResults()
    { 

//#if 442919690 
showInDiagramColumn = true;
//#endif 

} 

//#endif 


//#if 238451807 
public int getRowCount()
    { 

//#if -715294959 
if(rowObjects == null)//1
{ 

//#if 1672246336 
return 0;
//#endif 

} 

//#endif 


//#if 743961880 
return rowObjects.size();
//#endif 

} 

//#endif 


//#if 641105182 
public TMResults(boolean showTheInDiagramColumn)
    { 

//#if 1752506482 
showInDiagramColumn = showTheInDiagramColumn;
//#endif 

} 

//#endif 


//#if 1695154069 
public void setTarget(List results, List theDiagrams)
    { 

//#if -736805929 
rowObjects = results;
//#endif 


//#if -574684682 
diagrams = theDiagrams;
//#endif 


//#if -1675386286 
fireTableStructureChanged();
//#endif 

} 

//#endif 


//#if -1001435622 
private Object countNodesAndEdges(Diagram d)
    { 

//#if 775381307 
int numNodes = d.getNodes().size();
//#endif 


//#if 1372553243 
int numEdges = d.getEdges().size();
//#endif 


//#if -1058546125 
Object[] msgArgs = {Integer.valueOf(numNodes),
                            Integer.valueOf(numEdges),
                           };
//#endif 


//#if -2063744723 
return Translator.messageFormat("dialog.nodes-and-edges", msgArgs);
//#endif 

} 

//#endif 


//#if -1206420112 
public Object getValueAt(int row, int col)
    { 

//#if 1175100709 
if(row < 0 || row >= rowObjects.size())//1
{ 

//#if -1528219365 
return "bad row!";
//#endif 

} 

//#endif 


//#if 1830558475 
if(col < 0 || col >= (showInDiagramColumn ? 4 : 3))//1
{ 

//#if -637479850 
return "bad col!";
//#endif 

} 

//#endif 


//#if 1080706538 
Object rowObj = rowObjects.get(row);
//#endif 


//#if -1061525404 
if(rowObj instanceof Diagram)//1
{ 

//#if -1108746103 
Diagram d = (Diagram) rowObj;
//#endif 


//#if 425622151 
switch (col) //1
{ 
case 0 ://1


//#if -1170676815 
if(d instanceof UMLDiagram)//1
{ 

//#if -1142690711 
return ((UMLDiagram) d).getLabelName();
//#endif 

} 

//#endif 


//#if 1651193311 
return null;
//#endif 


case 1 ://1


//#if -549425479 
return d.getName();
//#endif 


case 2 ://1


//#if 1396203671 
return showInDiagramColumn
                       ? Translator.localize("dialog.find.not-applicable")
                       : countNodesAndEdges(d);
//#endif 


case 3 ://1


//#if -679095623 
return countNodesAndEdges(d);
//#endif 


default://1

} 

//#endif 

} 

//#endif 


//#if 128685734 
if(Model.getFacade().isAModelElement(rowObj))//1
{ 

//#if -312184484 
Diagram d = null;
//#endif 


//#if 1269685922 
if(diagrams != null)//1
{ 

//#if 567819684 
d = diagrams.get(row);
//#endif 

} 

//#endif 


//#if 2141491826 
switch (col) //1
{ 
case 0 ://1


//#if 1436055814 
return Model.getFacade().getUMLClassName(rowObj);
//#endif 


case 1 ://1


//#if -259572056 
return Model.getFacade().getName(rowObj);
//#endif 


case 2 ://1


//#if -1736989783 
return (d == null)
                       ? Translator.localize("dialog.find.not-applicable")
                       : d.getName();
//#endif 


case 3 ://1


//#if -1152467521 
return "docs";
//#endif 


default://1

} 

//#endif 

} 

//#endif 


//#if -1589606539 
switch (col) //1
{ 
case 0 ://1


//#if -1981716267 
if(rowObj == null)//1
{ 

//#if -30117535 
return "";
//#endif 

} 

//#endif 


//#if -1561655730 
String clsName = rowObj.getClass().getName();
//#endif 


//#if -1318627261 
int lastDot = clsName.lastIndexOf(".");
//#endif 


//#if 1247822089 
return clsName.substring(lastDot + 1);
//#endif 


case 1 ://1


//#if 1513335786 
return "";
//#endif 


case 2 ://1


//#if -1400519515 
return "??";
//#endif 


case 3 ://1


//#if 1016736107 
return "docs";
//#endif 


default://1

} 

//#endif 


//#if 932667525 
return "unknown!";
//#endif 

} 

//#endif 


//#if 162463408 
@Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

