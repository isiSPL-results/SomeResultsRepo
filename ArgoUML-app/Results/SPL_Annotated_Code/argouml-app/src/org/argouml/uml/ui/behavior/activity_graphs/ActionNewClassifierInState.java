// Compilation Unit of /ActionNewClassifierInState.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
class ActionNewClassifierInState extends UndoableAction
  { 
private Object choiceClass = Model.getMetaTypes().getState();
public boolean isEnabled()
    { 
boolean isEnabled = false;
Object t = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object type = Model.getFacade().getType(t);
if(Model.getFacade().isAClassifier(type))//1
{ 
if(!Model.getFacade().isAClassifierInState(type))//1
{ 
Collection states = Model.getModelManagementHelper()
                                        .getAllModelElementsOfKindWithModel(type,
                                                choiceClass);
if(states.size() > 0)//1
{ 
isEnabled = true;
} 

} 

} 

} 

return isEnabled;
} 

public void actionPerformed(ActionEvent e)
    { 
Object ofs = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAObjectFlowState(ofs))//1
{ 
Object type = Model.getFacade().getType(ofs);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
type = Model.getFacade().getType(type);
} 

if(Model.getFacade().isAClassifier(type))//1
{ 
Collection c = Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(type, choiceClass);
Collection states = new ArrayList(c);
PropPanelObjectFlowState.removeTopStateFrom(states);
if(states.size() < 1)//1
{ 
return;
} 

Object state = pickNicestStateFrom(states);
if(state != null)//1
{ 
states.clear();
states.add(state);
} 

super.actionPerformed(e);
Object cis = Model.getActivityGraphsFactory()
                             .buildClassifierInState(type, states);
Model.getCoreHelper().setType(ofs, cis);
TargetManager.getInstance().setTarget(cis);
} 

} 

} 

private Object pickNicestStateFrom(Collection states)
    { 
if(states.size() < 2)//1
{ 
return states.iterator().next();
} 

Collection simples = new ArrayList();
Collection composites = new ArrayList();
Iterator i;
i = states.iterator();
while (i.hasNext()) //1
{ 
Object st = i.next();
String name = Model.getFacade().getName(st);
if(Model.getFacade().isASimpleState(st)
                    && !Model.getFacade().isAObjectFlowState(st))//1
{ 
simples.add(st);
if(name != null
                        && (name.length() > 0))//1
{ 
return st;
} 

} 

} 

i = states.iterator();
while (i.hasNext()) //2
{ 
Object st = i.next();
String name = Model.getFacade().getName(st);
if(Model.getFacade().isACompositeState(st)
                    && !Model.getFacade().isASubmachineState(st))//1
{ 
composites.add(st);
if(name != null
                        && (name.length() > 0))//1
{ 
return st;
} 

} 

} 

if(simples.size() > 0)//1
{ 
return simples.iterator().next();
} 

if(composites.size() > 0)//1
{ 
return composites.iterator().next();
} 

return states.iterator().next();
} 

public ActionNewClassifierInState()
    { 
super();
} 

 } 


