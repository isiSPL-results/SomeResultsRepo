
//#if -987760790 
// Compilation Unit of /UMLMessageActivatorComboBoxModel.java 
 

//#if -1758308330 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 765256384 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 84590081 
import org.argouml.model.Model;
//#endif 


//#if -366890313 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -648783151 
public class UMLMessageActivatorComboBoxModel extends 
//#if 2113748146 
UMLComboBoxModel2
//#endif 

  { 

//#if 2038616495 
private Object interaction = null;
//#endif 


//#if 1261051488 
protected Object getSelectedModelElement()
    { 

//#if -8349068 
if(getTarget() != null)//1
{ 

//#if -595582206 
return Model.getFacade().getActivator(getTarget());
//#endif 

} 

//#endif 


//#if 985219640 
return null;
//#endif 

} 

//#endif 


//#if 1351886207 
public void setTarget(Object target)
    { 

//#if -1088031041 
if(Model.getFacade().isAMessage(getTarget()))//1
{ 

//#if 1102520228 
if(interaction != null)//1
{ 

//#if -716559851 
Model.getPump().removeModelEventListener(
                    this,
                    interaction,
                    "message");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1151429174 
super.setTarget(target);
//#endif 


//#if -128561110 
if(Model.getFacade().isAMessage(target))//1
{ 

//#if 738187606 
interaction = Model.getFacade().getInteraction(target);
//#endif 


//#if -1993548226 
if(interaction != null)//1
{ 

//#if 455567517 
Model.getPump().addModelEventListener(
                    this,
                    interaction,
                    "message");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -919032172 
protected void buildModelList()
    { 

//#if 1715059933 
Object target = getTarget();
//#endif 


//#if 263450770 
if(Model.getFacade().isAMessage(target))//1
{ 

//#if -1816226739 
Object mes = target;
//#endif 


//#if -1557786238 
removeAllElements();
//#endif 


//#if -267038653 
setElements(Model.getCollaborationsHelper()
                        .getAllPossibleActivators(mes));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -875517001 
protected boolean isValidElement(Object m)
    { 

//#if 672117483 
try //1
{ 

//#if 1886122658 
return ((Model.getFacade().isAMessage(m))
                    && m != getTarget()
                    && !Model.getFacade().getPredecessors(getTarget())
                    .contains(m)
                    && Model.getFacade().getInteraction(m) == Model
                    .getFacade().getInteraction(getTarget()));
//#endif 

} 

//#if -284659815 
catch (InvalidElementException e) //1
{ 

//#if 25950523 
return false;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1078174204 
public UMLMessageActivatorComboBoxModel()
    { 

//#if 1678300108 
super("activator", false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

