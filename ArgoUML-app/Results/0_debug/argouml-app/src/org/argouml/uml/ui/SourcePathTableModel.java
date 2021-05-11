
//#if -710791656 
// Compilation Unit of /SourcePathTableModel.java 
 

//#if 635602459 
package org.argouml.uml.ui;
//#endif 


//#if -1056218483 
import java.io.File;
//#endif 


//#if -626491769 
import java.util.Collection;
//#endif 


//#if -354049737 
import java.util.Iterator;
//#endif 


//#if -1350159363 
import javax.swing.table.DefaultTableModel;
//#endif 


//#if 580291735 
import org.apache.log4j.Logger;
//#endif 


//#if -63657148 
import org.argouml.i18n.Translator;
//#endif 


//#if -1867139062 
import org.argouml.model.Model;
//#endif 


//#if -724875838 
class SourcePathTableModel extends 
//#if 2129525033 
DefaultTableModel
//#endif 

  { 

//#if 1211535167 
static final int MODEL_ELEMENT_COLUMN = 0;
//#endif 


//#if -1803513865 
static final int NAME_COLUMN = 1;
//#endif 


//#if 1393612293 
static final int TYPE_COLUMN = 2;
//#endif 


//#if 575948671 
static final int SOURCE_PATH_COLUMN = 3;
//#endif 


//#if 137340086 
private static final Logger LOG =
        Logger.getLogger(SourcePathTableModel.class);
//#endif 


//#if 1009112747 
public boolean isCellEditable(int rowIndex, int columnIndex)
    { 

//#if 1806754716 
return columnIndex == SOURCE_PATH_COLUMN;
//#endif 

} 

//#endif 


//#if 1613724354 
public SourcePathTableModel(SourcePathController srcPathCtrl)
    { 

//#if 1113263282 
super(new Object[][] {
              }, new String[] {
                  " ", Translator.localize("misc.name"),
                  Translator.localize("misc.type"),
                  Translator.localize("misc.source-path"),
              });
//#endif 


//#if -921812947 
String strModel = Translator.localize("misc.model");
//#endif 


//#if 1064830387 
String strPackage = Translator.localize("misc.package");
//#endif 


//#if 1912320719 
String strClass = Translator.localize("misc.class");
//#endif 


//#if -925010547 
String strInterface = Translator.localize("misc.interface");
//#endif 


//#if 1661592141 
Collection elems = srcPathCtrl.getAllModelElementsWithSourcePath();
//#endif 


//#if 1493433128 
Iterator iter = elems.iterator();
//#endif 


//#if -2014521260 
while (iter.hasNext()) //1
{ 

//#if 989638432 
Object me = iter.next();
//#endif 


//#if -1526849349 
File path = srcPathCtrl.getSourcePath(me);
//#endif 


//#if -1831225052 
if(path != null)//1
{ 

//#if 485422270 
String type = "";
//#endif 


//#if -1979029505 
String name = Model.getFacade().getName(me);
//#endif 


//#if -69252965 
if(Model.getFacade().isAModel(me))//1
{ 

//#if -1488947326 
type = strModel;
//#endif 

} 
else

//#if 566107572 
if(Model.getFacade().isAPackage(me))//1
{ 

//#if -990279595 
type = strPackage;
//#endif 


//#if 1567465097 
Object parent = Model.getFacade().getNamespace(me);
//#endif 


//#if 720574974 
while (parent != null) //1
{ 

//#if 1942934520 
if(Model.getFacade().getNamespace(parent) != null)//1
{ 

//#if -1116122883 
name =
                                Model.getFacade().getName(parent) + "." + name;
//#endif 

} 

//#endif 


//#if 1187598406 
parent = Model.getFacade().getNamespace(parent);
//#endif 

} 

//#endif 

} 
else

//#if -1939437166 
if(Model.getFacade().isAClass(me))//1
{ 

//#if -677396592 
type = strClass;
//#endif 

} 
else

//#if 784982124 
if(Model.getFacade().isAInterface(me))//1
{ 

//#if -1238339809 
type = strInterface;
//#endif 

} 
else
{ 

//#if -367181293 
LOG.warn("Can't assign a type to this model element: "
                             + me);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -383238456 
addRow(new Object[] {
                           me, name, type, path.toString(),
                       });
//#endif 

} 
else
{ 

//#if 1188983348 
LOG.warn("Unexpected: the source path for " + me + " is null!");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 585976446 
public String getMEName(int rowIndex)
    { 

//#if -137580785 
return (String) getValueAt(rowIndex, NAME_COLUMN);
//#endif 

} 

//#endif 


//#if 975669807 
public String getMEType(int rowIndex)
    { 

//#if -1218895529 
return (String) getValueAt(rowIndex, TYPE_COLUMN);
//#endif 

} 

//#endif 


//#if -1094247940 
public Object getModelElement(int rowIndex)
    { 

//#if 901782959 
return getValueAt(rowIndex, MODEL_ELEMENT_COLUMN);
//#endif 

} 

//#endif 


//#if -726712055 
public String getMESourcePath(int rowIndex)
    { 

//#if -1435360783 
return (String) getValueAt(rowIndex, SOURCE_PATH_COLUMN);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

