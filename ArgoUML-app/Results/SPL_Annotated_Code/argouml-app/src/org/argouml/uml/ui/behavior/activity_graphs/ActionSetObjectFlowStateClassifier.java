// Compilation Unit of /ActionSetObjectFlowStateClassifier.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import java.awt.event.ActionEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBox2;
import org.tigris.gef.undo.UndoableAction;
public class ActionSetObjectFlowStateClassifier extends UndoableAction
  { 
public ActionSetObjectFlowStateClassifier()
    { 
super();
} 

public void actionPerformed(ActionEvent e)
    { 
Object source = e.getSource();
Object oldClassifier = null;
Object newClassifier = null;
Object m = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object ofs = box.getTarget();
if(Model.getFacade().isAObjectFlowState(ofs))//1
{ 
oldClassifier = Model.getFacade().getType(ofs);
m = ofs;
} 

Object cl = box.getSelectedItem();
if(Model.getFacade().isAClassifier(cl))//1
{ 
newClassifier = cl;
} 

} 

if(newClassifier != oldClassifier
                && m != null
                && newClassifier != null)//1
{ 
super.actionPerformed(e);
Model.getCoreHelper().setType(m, newClassifier);
} 

} 

 } 


