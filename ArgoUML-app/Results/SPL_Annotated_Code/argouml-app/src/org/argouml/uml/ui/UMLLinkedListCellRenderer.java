// Compilation Unit of /UMLLinkedListCellRenderer.java 
 
package org.argouml.uml.ui;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
public class UMLLinkedListCellRenderer extends UMLListCellRenderer2
  { 
private static final long serialVersionUID = -710457475656542074L;
public UMLLinkedListCellRenderer(boolean showIcon)
    { 
super(showIcon);
} 

public UMLLinkedListCellRenderer(boolean showIcon, boolean showPath)
    { 
super(showIcon, showPath);
} 

public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus)
    { 
JLabel label = (JLabel) super.getListCellRendererComponent(
                           list, value, index, isSelected, cellHasFocus);
label.setText("<html><u>" + label.getText() + "</html>");
return label;
} 

 } 


