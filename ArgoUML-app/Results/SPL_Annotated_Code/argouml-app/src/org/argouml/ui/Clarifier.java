// Compilation Unit of /Clarifier.java 
 
package org.argouml.ui;
import javax.swing.Icon;
import org.tigris.gef.presentation.Fig;

//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 

public interface Clarifier extends Icon
  { 
public void setFig(Fig f);
public boolean hit(int x, int y);

//#if COGNITIVE 
public void setToDoItem(ToDoItem i);
//#endif 

 } 


