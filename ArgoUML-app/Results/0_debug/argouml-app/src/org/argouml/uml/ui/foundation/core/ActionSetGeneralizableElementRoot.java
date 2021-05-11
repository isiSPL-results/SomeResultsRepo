
//#if 354173462 
// Compilation Unit of /ActionSetGeneralizableElementRoot.java 
 

//#if -690691789 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 630401837 
import java.awt.event.ActionEvent;
//#endif 


//#if -1277905501 
import javax.swing.Action;
//#endif 


//#if 1261576936 
import org.argouml.i18n.Translator;
//#endif 


//#if 474522030 
import org.argouml.model.Model;
//#endif 


//#if -2026691849 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 1319892163 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1199165539 
public class ActionSetGeneralizableElementRoot extends 
//#if 20882444 
UndoableAction
//#endif 

  { 

//#if 1434342103 
private static final ActionSetGeneralizableElementRoot SINGLETON =
        new ActionSetGeneralizableElementRoot();
//#endif 


//#if 755739140 
public static ActionSetGeneralizableElementRoot getInstance()
    { 

//#if 1948083881 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1595711595 
public void actionPerformed(ActionEvent e)
    { 

//#if 1376727543 
super.actionPerformed(e);
//#endif 


//#if -58998564 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 684689507 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if 285469621 
Object target = source.getTarget();
//#endif 


//#if 748981299 
if(Model.getFacade().isAGeneralizableElement(target)
                    || Model.getFacade().isAOperation(target)
                    || Model.getFacade().isAReception(target))//1
{ 

//#if 1707087242 
Model.getCoreHelper().setRoot(target, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -274691070 
protected ActionSetGeneralizableElementRoot()
    { 

//#if -1417238433 
super(Translator.localize("Set"), null);
//#endif 


//#if -976644208 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

