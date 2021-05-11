
//#if 711184520 
// Compilation Unit of /ActionNewClassifierInState.java 
 

//#if -812737912 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -555441595 
import java.awt.event.ActionEvent;
//#endif 


//#if 132815270 
import java.util.ArrayList;
//#endif 


//#if 1161904251 
import java.util.Collection;
//#endif 


//#if -1259450325 
import java.util.Iterator;
//#endif 


//#if 1464353174 
import org.argouml.model.Model;
//#endif 


//#if 1459897356 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -587148325 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -608583652 
class ActionNewClassifierInState extends 
//#if -806591672 
UndoableAction
//#endif 

  { 

//#if -598757303 
private Object choiceClass = Model.getMetaTypes().getState();
//#endif 


//#if 908912909 
public boolean isEnabled()
    { 

//#if 324259452 
boolean isEnabled = false;
//#endif 


//#if -582520528 
Object t = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1301224683 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -1857237981 
Object type = Model.getFacade().getType(t);
//#endif 


//#if -1465070379 
if(Model.getFacade().isAClassifier(type))//1
{ 

//#if -1379324084 
if(!Model.getFacade().isAClassifierInState(type))//1
{ 

//#if 662509997 
Collection states = Model.getModelManagementHelper()
                                        .getAllModelElementsOfKindWithModel(type,
                                                choiceClass);
//#endif 


//#if -1461287259 
if(states.size() > 0)//1
{ 

//#if -1364260674 
isEnabled = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2062039202 
return isEnabled;
//#endif 

} 

//#endif 


//#if 1388968921 
public void actionPerformed(ActionEvent e)
    { 

//#if 1716363826 
Object ofs = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -723624301 
if(Model.getFacade().isAObjectFlowState(ofs))//1
{ 

//#if 1447580084 
Object type = Model.getFacade().getType(ofs);
//#endif 


//#if -542535124 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -846136498 
type = Model.getFacade().getType(type);
//#endif 

} 

//#endif 


//#if -479042466 
if(Model.getFacade().isAClassifier(type))//1
{ 

//#if -567451879 
Collection c = Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(type, choiceClass);
//#endif 


//#if 741067768 
Collection states = new ArrayList(c);
//#endif 


//#if -2007008592 
PropPanelObjectFlowState.removeTopStateFrom(states);
//#endif 


//#if -491966711 
if(states.size() < 1)//1
{ 

//#if 1952524184 
return;
//#endif 

} 

//#endif 


//#if -1128182188 
Object state = pickNicestStateFrom(states);
//#endif 


//#if -696566022 
if(state != null)//1
{ 

//#if -1852537423 
states.clear();
//#endif 


//#if -1963160136 
states.add(state);
//#endif 

} 

//#endif 


//#if -1068943523 
super.actionPerformed(e);
//#endif 


//#if -1491313557 
Object cis = Model.getActivityGraphsFactory()
                             .buildClassifierInState(type, states);
//#endif 


//#if -1581954005 
Model.getCoreHelper().setType(ofs, cis);
//#endif 


//#if -278495027 
TargetManager.getInstance().setTarget(cis);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 271821839 
private Object pickNicestStateFrom(Collection states)
    { 

//#if -1096644431 
if(states.size() < 2)//1
{ 

//#if -2024658253 
return states.iterator().next();
//#endif 

} 

//#endif 


//#if 768539193 
Collection simples = new ArrayList();
//#endif 


//#if -1012734752 
Collection composites = new ArrayList();
//#endif 


//#if 722394512 
Iterator i;
//#endif 


//#if -411207228 
i = states.iterator();
//#endif 


//#if -624898390 
while (i.hasNext()) //1
{ 

//#if -786105690 
Object st = i.next();
//#endif 


//#if 1458908668 
String name = Model.getFacade().getName(st);
//#endif 


//#if -351877020 
if(Model.getFacade().isASimpleState(st)
                    && !Model.getFacade().isAObjectFlowState(st))//1
{ 

//#if 1071514567 
simples.add(st);
//#endif 


//#if 244176228 
if(name != null
                        && (name.length() > 0))//1
{ 

//#if 2089717862 
return st;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1027754482 
i = states.iterator();
//#endif 


//#if -1959599161 
while (i.hasNext()) //2
{ 

//#if -949171441 
Object st = i.next();
//#endif 


//#if -511248525 
String name = Model.getFacade().getName(st);
//#endif 


//#if 1293772480 
if(Model.getFacade().isACompositeState(st)
                    && !Model.getFacade().isASubmachineState(st))//1
{ 

//#if -1261201213 
composites.add(st);
//#endif 


//#if 6687197 
if(name != null
                        && (name.length() > 0))//1
{ 

//#if -1082435621 
return st;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1812519708 
if(simples.size() > 0)//1
{ 

//#if -1355210553 
return simples.iterator().next();
//#endif 

} 

//#endif 


//#if 696322019 
if(composites.size() > 0)//1
{ 

//#if 480814864 
return composites.iterator().next();
//#endif 

} 

//#endif 


//#if 2073515316 
return states.iterator().next();
//#endif 

} 

//#endif 


//#if 1307658111 
public ActionNewClassifierInState()
    { 

//#if 1849685482 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

