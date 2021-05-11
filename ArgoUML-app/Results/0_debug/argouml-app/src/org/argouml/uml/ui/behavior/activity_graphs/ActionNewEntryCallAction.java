
//#if -221750744 
// Compilation Unit of /ActionNewEntryCallAction.java 
 

//#if -948873412 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -2128026631 
import java.awt.event.ActionEvent;
//#endif 


//#if 201227362 
import org.argouml.model.Model;
//#endif 


//#if -904487488 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1684921969 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -183635125 
class ActionNewEntryCallAction extends 
//#if -1809682577 
UndoableAction
//#endif 

  { 

//#if 257235346 
public void actionPerformed(ActionEvent e)
    { 

//#if -1372950827 
super.actionPerformed(e);
//#endif 


//#if -1617285719 
Object t = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1148106728 
Object ca = Model.getCommonBehaviorFactory().createCallAction();
//#endif 


//#if 580422622 
Model.getStateMachinesHelper().setEntry(t, ca);
//#endif 


//#if -2003589686 
TargetManager.getInstance().setTarget(ca);
//#endif 

} 

//#endif 


//#if -1383125727 
public ActionNewEntryCallAction()
    { 

//#if -1213934181 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

