
//#if 969293008 
// Compilation Unit of /ActionResolve.java 
 

//#if 126483672 
package org.argouml.cognitive.ui;
//#endif 


//#if 1383838330 
import java.awt.event.ActionEvent;
//#endif 


//#if 1465885199 
public class ActionResolve extends 
//#if 1095606317 
ToDoItemAction
//#endif 

  { 

//#if 1777158442 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -959401604 
super.actionPerformed(ae);
//#endif 


//#if 1776410896 
DismissToDoItemDialog dialog = new DismissToDoItemDialog();
//#endif 


//#if -963838112 
dialog.setTarget(getRememberedTarget());
//#endif 


//#if -819197913 
dialog.setVisible(true);
//#endif 

} 

//#endif 


//#if 1211152 
public ActionResolve()
    { 

//#if 741526986 
super("action.resolve-item", true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

