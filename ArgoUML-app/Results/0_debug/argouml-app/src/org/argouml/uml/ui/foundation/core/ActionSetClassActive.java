
//#if -51775587 
// Compilation Unit of /ActionSetClassActive.java 
 

//#if -1419442650 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1153374426 
import java.awt.event.ActionEvent;
//#endif 


//#if -380919728 
import javax.swing.Action;
//#endif 


//#if 293858011 
import org.argouml.i18n.Translator;
//#endif 


//#if 1439324961 
import org.argouml.model.Model;
//#endif 


//#if -1096173206 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1613109904 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 167138745 
public class ActionSetClassActive extends 
//#if -606070456 
UndoableAction
//#endif 

  { 

//#if -1937287899 
private static final ActionSetClassActive SINGLETON =
        new ActionSetClassActive();
//#endif 


//#if 2116315631 
public static ActionSetClassActive getInstance()
    { 

//#if 540859333 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1608267795 
protected ActionSetClassActive()
    { 

//#if -1406513192 
super(Translator.localize("Set"), null);
//#endif 


//#if -558458889 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 256837081 
public void actionPerformed(ActionEvent e)
    { 

//#if -831353537 
super.actionPerformed(e);
//#endif 


//#if -1763615084 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -1943366095 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if 1576319911 
Object target = source.getTarget();
//#endif 


//#if 379051960 
if(Model.getFacade().isAClass(target))//1
{ 

//#if 1763453070 
Object m = target;
//#endif 


//#if 1020980848 
Model.getCoreHelper().setActive(m, source.isSelected());
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

