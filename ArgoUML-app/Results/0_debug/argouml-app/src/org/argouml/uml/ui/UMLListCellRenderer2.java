
//#if 1503803627 
// Compilation Unit of /UMLListCellRenderer2.java 
 

//#if -1714561167 
package org.argouml.uml.ui;
//#endif 


//#if -1072705906 
import java.awt.Component;
//#endif 


//#if -568408799 
import java.util.Iterator;
//#endif 


//#if 1033112817 
import java.util.List;
//#endif 


//#if -1699748629 
import javax.swing.DefaultListCellRenderer;
//#endif 


//#if 657769917 
import javax.swing.JLabel;
//#endif 


//#if -532715865 
import javax.swing.JList;
//#endif 


//#if -186516394 
import javax.swing.UIManager;
//#endif 


//#if 1751870681 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -290173286 
import org.argouml.i18n.Translator;
//#endif 


//#if -1915297441 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 34109024 
import org.argouml.model.Model;
//#endif 


//#if -1715787837 
public class UMLListCellRenderer2 extends 
//#if -1507093241 
DefaultListCellRenderer
//#endif 

  { 

//#if -240849149 
private boolean showIcon;
//#endif 


//#if -234439465 
private boolean showPath;
//#endif 


//#if -588767496 
public UMLListCellRenderer2(boolean showTheIcon, boolean showThePath)
    { 

//#if -342096322 
updateUI();
//#endif 


//#if 584769389 
setAlignmentX(LEFT_ALIGNMENT);
//#endif 


//#if 1885456982 
showIcon = showTheIcon;
//#endif 


//#if 1482377214 
showPath = showThePath;
//#endif 

} 

//#endif 


//#if -1045246820 
public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus)
    { 

//#if -885672465 
if(Model.getFacade().isAUMLElement(value))//1
{ 

//#if 595494665 
String text = makeText(value);
//#endif 


//#if -1031850556 
setText(text);
//#endif 


//#if -497743043 
if(showIcon)//1
{ 

//#if 1719401126 
setComponentOrientation(list.getComponentOrientation());
//#endif 


//#if 1540040561 
if(isSelected)//1
{ 

//#if -1565335513 
setForeground(list.getSelectionForeground());
//#endif 


//#if -420323715 
setBackground(list.getSelectionBackground());
//#endif 

} 
else
{ 

//#if 1290917208 
setForeground(list.getForeground());
//#endif 


//#if 615100280 
setBackground(list.getBackground());
//#endif 

} 

//#endif 


//#if 169982140 
setEnabled(list.isEnabled());
//#endif 


//#if 1943541286 
setFont(list.getFont());
//#endif 


//#if 1421075502 
setBorder((cellHasFocus) ? UIManager
                          .getBorder("List.focusCellHighlightBorder")
                          : noFocusBorder);
//#endif 


//#if -697715315 
setIcon(ResourceLoaderWrapper.getInstance()
                        .lookupIcon(value));
//#endif 

} 
else
{ 

//#if -1022106184 
return super.getListCellRendererComponent(list, text, index,
                        isSelected, cellHasFocus);
//#endif 

} 

//#endif 

} 
else

//#if 790613429 
if(value instanceof String)//1
{ 

//#if 117108552 
return super.getListCellRendererComponent(list, value, index,
                    isSelected, cellHasFocus);
//#endif 

} 
else

//#if 571916515 
if(value == null || value.equals(""))//1
{ 

//#if 1210980259 
JLabel label = new JLabel(" ");
//#endif 


//#if -629914784 
label.setIcon(null);
//#endif 


//#if -779071657 
return label;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -313763066 
return this;
//#endif 

} 

//#endif 


//#if -1544285699 
public UMLListCellRenderer2(boolean showTheIcon)
    { 

//#if 1366265715 
this(showTheIcon, true);
//#endif 

} 

//#endif 


//#if -1908013523 
public String makeText(Object value)
    { 

//#if 193790923 
if(value instanceof String)//1
{ 

//#if 1643801290 
return (String) value;
//#endif 

} 

//#endif 


//#if 644368499 
String name = null;
//#endif 


//#if 12304617 
if(Model.getFacade().isAParameter(value))//1
{ 

//#if 766264655 
Object type = Model.getFacade().getType(value);
//#endif 


//#if 1982205140 
name = getName(value);
//#endif 


//#if 687690743 
String typeName = null;
//#endif 


//#if -830207162 
if(type != null)//1
{ 

//#if -2097100448 
typeName = Model.getFacade().getName(type);
//#endif 

} 

//#endif 


//#if -1812492888 
if(typeName != null || "".equals(typeName))//1
{ 

//#if -1649337878 
name = Translator.localize(
                           "misc.name.withType",
                           new Object[] {name, typeName});
//#endif 

} 

//#endif 


//#if -1048235594 
return name;
//#endif 

} 

//#endif 


//#if 1511823766 
if(Model.getFacade().isAUMLElement(value))//1
{ 

//#if -887709700 
try //1
{ 

//#if -762182738 
name = getName(value);
//#endif 


//#if 545059880 
if(Model.getFacade().isAStereotype(value))//1
{ 

//#if 1791360197 
String baseString = "";
//#endif 


//#if 1803022688 
Iterator bases =
                        Model.getFacade().getBaseClasses(value).iterator();
//#endif 


//#if -1881804621 
if(bases.hasNext())//1
{ 

//#if 909289516 
baseString = makeText(bases.next());
//#endif 


//#if -1396246997 
while (bases.hasNext()) //1
{ 

//#if 1102561389 
baseString = Translator.localize(
                                             "misc.name.baseClassSeparator",
                                             new Object[] {baseString,
                                                           makeText(bases.next())
                                                          }
                                         );
//#endif 

} 

//#endif 

} 

//#endif 


//#if -70652123 
name = Translator.localize(
                               "misc.name.withBaseClasses",
                               new Object[] {name, baseString});
//#endif 

} 
else

//#if 1496132195 
if(showPath)//1
{ 

//#if 990947834 
List pathList =
                        Model.getModelManagementHelper().getPathList(value);
//#endif 


//#if 1276796627 
String path;
//#endif 


//#if 623918575 
if(pathList.size() > 1)//1
{ 

//#if 2021497634 
path = (String) pathList.get(0);
//#endif 


//#if 663976625 
for (int i = 1; i < pathList.size() - 1; i++) //1
{ 

//#if -708745942 
String n = (String) pathList.get(i);
//#endif 


//#if -1987337184 
path = Translator.localize(
                                       "misc.name.pathSeparator",
                                       new Object[] {path, n});
//#endif 

} 

//#endif 


//#if 1744114345 
name = Translator.localize(
                                   "misc.name.withPath",
                                   new Object[] {name, path});
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#if 745225841 
catch (InvalidElementException e) //1
{ 

//#if -613115055 
name = Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 25459933 
if(Model.getFacade().isAMultiplicity(value))//1
{ 

//#if 1425228507 
name = Model.getFacade().getName(value);
//#endif 

} 
else
{ 

//#if -143100728 
name = makeTypeName(value);
//#endif 

} 

//#endif 


//#endif 


//#if -249189856 
return name;
//#endif 

} 

//#endif 


//#if -1918668611 
private String makeTypeName(Object elem)
    { 

//#if 1475837668 
if(Model.getFacade().isAUMLElement(elem))//1
{ 

//#if -625081185 
return Model.getFacade().getUMLClassName(elem);
//#endif 

} 

//#endif 


//#if 1395730892 
return null;
//#endif 

} 

//#endif 


//#if 2115382837 
private String getName(Object value)
    { 

//#if -1396324930 
String name = Model.getFacade().getName(value);
//#endif 


//#if -1563838093 
if(name == null || name.equals(""))//1
{ 

//#if -1294285339 
name = Translator.localize(
                       "misc.name.unnamed",
                       new Object[] {makeTypeName(value)});
//#endif 

} 

//#endif 


//#if 999592603 
return name;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

