
//#if -1414536145 
// Compilation Unit of /ActionSetObjectFlowStateClassifier.java 
 

//#if -1644989960 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -2043841099 
import java.awt.event.ActionEvent;
//#endif 


//#if 1722655782 
import org.argouml.model.Model;
//#endif 


//#if -1000356695 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 28784459 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 749048059 
public class ActionSetObjectFlowStateClassifier extends 
//#if -1617746224 
UndoableAction
//#endif 

  { 

//#if 1873838399 
public ActionSetObjectFlowStateClassifier()
    { 

//#if -2367315 
super();
//#endif 

} 

//#endif 


//#if -811024047 
public void actionPerformed(ActionEvent e)
    { 

//#if -896712097 
Object source = e.getSource();
//#endif 


//#if 1036620458 
Object oldClassifier = null;
//#endif 


//#if 213744675 
Object newClassifier = null;
//#endif 


//#if -1474722769 
Object m = null;
//#endif 


//#if 167334437 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1708352298 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -330487623 
Object ofs = box.getTarget();
//#endif 


//#if 1002445030 
if(Model.getFacade().isAObjectFlowState(ofs))//1
{ 

//#if -150630829 
oldClassifier = Model.getFacade().getType(ofs);
//#endif 


//#if -550596965 
m = ofs;
//#endif 

} 

//#endif 


//#if 1497472651 
Object cl = box.getSelectedItem();
//#endif 


//#if 1283172014 
if(Model.getFacade().isAClassifier(cl))//1
{ 

//#if 163642648 
newClassifier = cl;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -265965860 
if(newClassifier != oldClassifier
                && m != null
                && newClassifier != null)//1
{ 

//#if 1519310875 
super.actionPerformed(e);
//#endif 


//#if -163627666 
Model.getCoreHelper().setType(m, newClassifier);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

