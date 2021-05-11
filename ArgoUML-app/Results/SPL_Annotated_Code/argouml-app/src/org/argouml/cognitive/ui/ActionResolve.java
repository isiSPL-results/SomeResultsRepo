// Compilation Unit of /ActionResolve.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
public class ActionResolve extends ToDoItemAction
  { 
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
DismissToDoItemDialog dialog = new DismissToDoItemDialog();
dialog.setTarget(getRememberedTarget());
dialog.setVisible(true);
} 

public ActionResolve()
    { 
super("action.resolve-item", true);
} 

 } 

//#endif 


