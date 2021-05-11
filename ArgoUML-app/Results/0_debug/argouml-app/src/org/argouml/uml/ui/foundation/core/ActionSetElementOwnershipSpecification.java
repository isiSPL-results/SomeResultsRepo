
//#if -232448141 
// Compilation Unit of /ActionSetElementOwnershipSpecification.java 
 

//#if 1900090328 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -722109720 
import java.awt.event.ActionEvent;
//#endif 


//#if 1125380190 
import javax.swing.Action;
//#endif 


//#if -2011575667 
import org.argouml.i18n.Translator;
//#endif 


//#if 1956111315 
import org.argouml.model.Model;
//#endif 


//#if 855928860 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -397649538 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 2136209497 
public class ActionSetElementOwnershipSpecification extends 
//#if -523567475 
UndoableAction
//#endif 

  { 

//#if 1437252138 
private static final ActionSetElementOwnershipSpecification SINGLETON =
        new ActionSetElementOwnershipSpecification();
//#endif 


//#if 1181783288 
public static ActionSetElementOwnershipSpecification getInstance()
    { 

//#if -1029742817 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1785242150 
protected ActionSetElementOwnershipSpecification()
    { 

//#if 1230624592 
super(Translator.localize("Set"), null);
//#endif 


//#if -809883265 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 1821583412 
public void actionPerformed(ActionEvent e)
    { 

//#if 1488216592 
super.actionPerformed(e);
//#endif 


//#if 18589155 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -306192198 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -1451306946 
Object target = source.getTarget();
//#endif 


//#if -717486634 
if(Model.getFacade().isAModelElement(target)
                    || Model.getFacade().isAElementImport(target))//1
{ 

//#if 1096335244 
Object m = target;
//#endif 


//#if 1146986895 
Model.getModelManagementHelper().setSpecification(m,
                        !Model.getFacade().isSpecification(m));
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

