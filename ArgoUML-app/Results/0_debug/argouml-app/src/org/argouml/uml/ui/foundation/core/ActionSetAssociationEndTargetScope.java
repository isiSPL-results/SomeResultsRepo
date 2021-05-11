
//#if -1442507139 
// Compilation Unit of /ActionSetAssociationEndTargetScope.java 
 

//#if -2042750329 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -81239207 
import java.awt.event.ActionEvent;
//#endif 


//#if 67819983 
import javax.swing.Action;
//#endif 


//#if 675541052 
import org.argouml.i18n.Translator;
//#endif 


//#if 928921858 
import org.argouml.model.Model;
//#endif 


//#if -1053415861 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 860635375 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -919032285 
public class ActionSetAssociationEndTargetScope extends 
//#if 1647396040 
UndoableAction
//#endif 

  { 

//#if 1912003973 
private static final ActionSetAssociationEndTargetScope SINGLETON =
        new ActionSetAssociationEndTargetScope();
//#endif 


//#if -382333736 
protected ActionSetAssociationEndTargetScope()
    { 

//#if 1838914934 
super(Translator.localize("Set"), null);
//#endif 


//#if 253024409 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 2029545188 
public static ActionSetAssociationEndTargetScope getInstance()
    { 

//#if 1712070115 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 62769753 
public void actionPerformed(ActionEvent e)
    { 

//#if 991975931 
super.actionPerformed(e);
//#endif 


//#if 354885976 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -1376141455 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -1855964569 
Object target = source.getTarget();
//#endif 


//#if 2029837642 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 1427258407 
Object m = target;
//#endif 


//#if -1430500239 
Model.getCoreHelper().setStatic(m, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

