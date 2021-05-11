// Compilation Unit of /PerspectiveComboBox.java 
 
package org.argouml.ui.explorer;
import javax.swing.JComboBox;
public class PerspectiveComboBox extends JComboBox
 implements PerspectiveManagerListener
  { 
public void addPerspective(Object perspective)
    { 
addItem(perspective);
} 

public PerspectiveComboBox()
    { 
this.setMaximumRowCount(9);
PerspectiveManager.getInstance().addListener(this);
} 

public void removePerspective(Object perspective)
    { 
removeItem(perspective);
} 

 } 


