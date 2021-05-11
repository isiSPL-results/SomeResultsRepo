
//#if -2112408670 
// Compilation Unit of /ActionSetActionAsynchronous.java 
 

//#if 1800404 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 696369602 
import java.awt.event.ActionEvent;
//#endif 


//#if -686182088 
import javax.swing.Action;
//#endif 


//#if -988389645 
import org.argouml.i18n.Translator;
//#endif 


//#if -1305830599 
import org.argouml.model.Model;
//#endif 


//#if -1120640638 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -377936296 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1983979973 
public class ActionSetActionAsynchronous extends 
//#if 1266352542 
UndoableAction
//#endif 

  { 

//#if -722917181 
private static final ActionSetActionAsynchronous SINGLETON =
        new ActionSetActionAsynchronous();
//#endif 


//#if -1372294250 
private static final long serialVersionUID = 1683440096488846000L;
//#endif 


//#if 323684931 
public void actionPerformed(ActionEvent e)
    { 

//#if 762145703 
super.actionPerformed(e);
//#endif 


//#if 679615788 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -1328490103 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -1804913841 
Object target = source.getTarget();
//#endif 


//#if -1986885682 
if(Model.getFacade().isAAction(target))//1
{ 

//#if 1824061268 
Object m = target;
//#endif 


//#if -1697717578 
Model.getCommonBehaviorHelper().setAsynchronous(
                    m,
                    source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1304209945 
protected ActionSetActionAsynchronous()
    { 

//#if -1618018624 
super(Translator.localize("action.set"), null);
//#endif 


//#if 1228872799 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 


//#if -35726173 
public static ActionSetActionAsynchronous getInstance()
    { 

//#if 2092781401 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

