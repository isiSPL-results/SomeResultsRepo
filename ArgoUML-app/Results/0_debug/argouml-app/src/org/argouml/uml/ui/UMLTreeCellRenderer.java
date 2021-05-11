
//#if 987053245 
// Compilation Unit of /UMLTreeCellRenderer.java 
 

//#if -968987961 
package org.argouml.uml.ui;
//#endif 


//#if 475365496 
import java.awt.Component;
//#endif 


//#if 1329443640 
import javax.swing.Icon;
//#endif 


//#if -2089125977 
import javax.swing.JLabel;
//#endif 


//#if -1722061699 
import javax.swing.JTree;
//#endif 


//#if -1497819728 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if 1575845949 
import javax.swing.tree.DefaultTreeCellRenderer;
//#endif 


//#if -1245076817 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1570298896 
import org.argouml.i18n.Translator;
//#endif 


//#if 569861814 
import org.argouml.model.Model;
//#endif 


//#if -1426017578 
import org.argouml.uml.diagram.ui.UMLDiagram;
//#endif 


//#if -724609627 
public class UMLTreeCellRenderer extends 
//#if 550607356 
DefaultTreeCellRenderer
//#endif 

  { 

//#if -1579461808 
private static String name = Translator.localize("label.name");
//#endif 


//#if -185228121 
private static String typeName = Translator.localize("label.type");
//#endif 


//#if -1007470248 
@Override
    public Component getTreeCellRendererComponent(
        JTree tree,
        Object value,
        boolean sel,
        boolean expanded,
        boolean leaf,
        int row,
        boolean hasFocusParam)
    { 

//#if 1594586309 
if(value instanceof DefaultMutableTreeNode)//1
{ 

//#if 709761071 
value = ((DefaultMutableTreeNode) value).getUserObject();
//#endif 

} 

//#endif 


//#if -376351000 
Component r =
            super.getTreeCellRendererComponent(
                tree,
                value,
                sel,
                expanded,
                leaf,
                row,
                hasFocusParam);
//#endif 


//#if -1264998239 
if(value != null && r instanceof JLabel)//1
{ 

//#if 530449442 
JLabel lab = (JLabel) r;
//#endif 


//#if -1420701425 
Icon icon = ResourceLoaderWrapper.getInstance().lookupIcon(value);
//#endif 


//#if -301813593 
if(icon != null)//1
{ 

//#if -1091951860 
lab.setIcon(icon);
//#endif 

} 

//#endif 


//#if 569279722 
String type = null;
//#endif 


//#if 1133064995 
if(Model.getFacade().isAModelElement(value))//1
{ 

//#if -227615476 
type = Model.getFacade().getUMLClassName(value);
//#endif 

} 
else

//#if -11347136 
if(value instanceof UMLDiagram)//1
{ 

//#if -730924513 
type = ((UMLDiagram) value).getLabelName();
//#endif 

} 

//#endif 


//#endif 


//#if -311146968 
if(type != null)//1
{ 

//#if 547487356 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -1993989642 
buf.append("<html>");
//#endif 


//#if 1039218712 
buf.append(name);
//#endif 


//#if -1641313299 
buf.append(' ');
//#endif 


//#if 1488125562 
buf.append(lab.getText());
//#endif 


//#if -128006821 
buf.append("<br>");
//#endif 


//#if 219929202 
buf.append(typeName);
//#endif 


//#if 1838221125 
buf.append(' ');
//#endif 


//#if 1233247495 
buf.append(type);
//#endif 


//#if 857366811 
lab.setToolTipText(buf.toString());
//#endif 

} 
else
{ 

//#if -1914337380 
lab.setToolTipText(lab.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1719782271 
return r;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

