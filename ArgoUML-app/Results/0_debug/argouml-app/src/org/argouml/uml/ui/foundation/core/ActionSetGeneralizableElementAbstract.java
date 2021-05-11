
//#if 415708380 
// Compilation Unit of /ActionSetGeneralizableElementAbstract.java 
 

//#if 934721218 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1613559618 
import java.awt.event.ActionEvent;
//#endif 


//#if 1194308660 
import javax.swing.Action;
//#endif 


//#if 418248567 
import org.argouml.i18n.Translator;
//#endif 


//#if -141879875 
import org.argouml.model.Model;
//#endif 


//#if -1295771642 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 679588180 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1511524436 
public class ActionSetGeneralizableElementAbstract extends 
//#if -702587995 
UndoableAction
//#endif 

  { 

//#if -2061347152 
private static final ActionSetGeneralizableElementAbstract SINGLETON =
        new ActionSetGeneralizableElementAbstract();
//#endif 


//#if 1647347549 
public static ActionSetGeneralizableElementAbstract getInstance()
    { 

//#if 2010650579 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 2102474268 
public void actionPerformed(ActionEvent e)
    { 

//#if 1867843651 
super.actionPerformed(e);
//#endif 


//#if -1070871536 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -804416281 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -509155407 
Object target = source.getTarget();
//#endif 


//#if -1717765073 
if(Model.getFacade().isAGeneralizableElement(target)
                    || Model.getFacade().isAOperation(target)
                    || Model.getFacade().isAReception(target))//1
{ 

//#if -246064069 
Model.getCoreHelper().setAbstract(target, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 986273051 
protected ActionSetGeneralizableElementAbstract()
    { 

//#if -739184957 
super(Translator.localize("Set"), null);
//#endif 


//#if -1546886996 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

