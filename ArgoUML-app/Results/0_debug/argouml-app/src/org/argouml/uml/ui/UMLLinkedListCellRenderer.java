
//#if 1864230143 
// Compilation Unit of /UMLLinkedListCellRenderer.java 
 

//#if -196108464 
package org.argouml.uml.ui;
//#endif 


//#if -1300818225 
import java.awt.Component;
//#endif 


//#if 429657598 
import javax.swing.JLabel;
//#endif 


//#if 429756998 
import javax.swing.JList;
//#endif 


//#if -991656281 
public class UMLLinkedListCellRenderer extends 
//#if -1373371661 
UMLListCellRenderer2
//#endif 

  { 

//#if -1991843709 
private static final long serialVersionUID = -710457475656542074L;
//#endif 


//#if 1467730596 
public UMLLinkedListCellRenderer(boolean showIcon)
    { 

//#if -1078483539 
super(showIcon);
//#endif 

} 

//#endif 


//#if -2132735706 
public UMLLinkedListCellRenderer(boolean showIcon, boolean showPath)
    { 

//#if 1221087840 
super(showIcon, showPath);
//#endif 

} 

//#endif 


//#if 1417538529 
public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus)
    { 

//#if -1008147552 
JLabel label = (JLabel) super.getListCellRendererComponent(
                           list, value, index, isSelected, cellHasFocus);
//#endif 


//#if 1439391632 
label.setText("<html><u>" + label.getText() + "</html>");
//#endif 


//#if -748386956 
return label;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

