
//#if -2012137806 
// Compilation Unit of /ActionSetCompositeStateConcurrent.java 
 

//#if -888221353 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1589212269 
import java.awt.event.ActionEvent;
//#endif 


//#if -1887944989 
import javax.swing.Action;
//#endif 


//#if 919929256 
import org.argouml.i18n.Translator;
//#endif 


//#if 1135140974 
import org.argouml.model.Model;
//#endif 


//#if 348692919 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1768620541 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -558534925 

//#if 1775457346 
@Deprecated
//#endif 

public class ActionSetCompositeStateConcurrent extends 
//#if 1097836453 
UndoableAction
//#endif 

  { 

//#if 680020868 
private static final ActionSetCompositeStateConcurrent SINGLETON =
        new ActionSetCompositeStateConcurrent();
//#endif 


//#if -257005028 
public void actionPerformed(ActionEvent e)
    { 

//#if 919103334 
super.actionPerformed(e);
//#endif 


//#if 1878275917 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -1062950713 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if 319197137 
Object target = source.getTarget();
//#endif 


//#if -1462769180 
if(Model.getFacade().isACompositeState(target))//1
{ 

//#if 2040653343 
Object compositeState = target;
//#endif 


//#if -17105276 
Model.getStateMachinesHelper().setConcurrent(
                    compositeState,
                    !Model.getFacade().isConcurrent(compositeState));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1908752569 
public static ActionSetCompositeStateConcurrent getInstance()
    { 

//#if 1443182041 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 173801713 
protected ActionSetCompositeStateConcurrent()
    { 

//#if -1688876394 
super(Translator.localize("action.set"), null);
//#endif 


//#if 1414619081 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

