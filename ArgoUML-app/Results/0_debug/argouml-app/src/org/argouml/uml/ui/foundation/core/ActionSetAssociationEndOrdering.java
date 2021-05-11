
//#if -165062584 
// Compilation Unit of /ActionSetAssociationEndOrdering.java 
 

//#if -767220346 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -985911942 
import java.awt.event.ActionEvent;
//#endif 


//#if 2079806704 
import javax.swing.Action;
//#endif 


//#if -1599509957 
import org.argouml.i18n.Translator;
//#endif 


//#if -279541119 
import org.argouml.model.Model;
//#endif 


//#if 910198986 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 1455970832 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -275046925 
public class ActionSetAssociationEndOrdering extends 
//#if 448816833 
UndoableAction
//#endif 

  { 

//#if -262949818 
private static final ActionSetAssociationEndOrdering SINGLETON =
        new ActionSetAssociationEndOrdering();
//#endif 


//#if -1016829062 
protected ActionSetAssociationEndOrdering()
    { 

//#if 2034083197 
super(Translator.localize("Set"), null);
//#endif 


//#if -38487886 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -1977113984 
public void actionPerformed(ActionEvent e)
    { 

//#if -953189895 
super.actionPerformed(e);
//#endif 


//#if -65520358 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 188474283 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -224040595 
Object target = source.getTarget();
//#endif 


//#if 217224912 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 1577284459 
Object m = target;
//#endif 


//#if 932942342 
if(source.isSelected())//1
{ 

//#if 1224304748 
Model.getCoreHelper().setOrdering(m,
                                                      Model.getOrderingKind().getOrdered());
//#endif 

} 
else
{ 

//#if -2080292244 
Model.getCoreHelper().setOrdering(m,
                                                      Model.getOrderingKind().getUnordered());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1262471530 
public static ActionSetAssociationEndOrdering getInstance()
    { 

//#if 2036747530 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

