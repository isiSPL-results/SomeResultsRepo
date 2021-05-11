
//#if 1802243476 
// Compilation Unit of /ActionSetAssociationEndNavigable.java 
 

//#if 1760355081 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1088970601 
import java.awt.event.ActionEvent;
//#endif 


//#if 1660040461 
import javax.swing.Action;
//#endif 


//#if -499361090 
import org.argouml.i18n.Translator;
//#endif 


//#if -1012648828 
import org.argouml.model.Model;
//#endif 


//#if -1676574771 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -817799123 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2042305287 
public class ActionSetAssociationEndNavigable extends 
//#if 2041415446 
UndoableAction
//#endif 

  { 

//#if -1688186349 
private static final ActionSetAssociationEndNavigable SINGLETON =
        new ActionSetAssociationEndNavigable();
//#endif 


//#if -702967170 
public static ActionSetAssociationEndNavigable getInstance()
    { 

//#if 284882526 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1501369502 
protected ActionSetAssociationEndNavigable()
    { 

//#if -24502693 
super(Translator.localize("action.set"), null);
//#endif 


//#if 86154852 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 


//#if -1486414901 
public void actionPerformed(ActionEvent e)
    { 

//#if 1542982059 
super.actionPerformed(e);
//#endif 


//#if -1156659288 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 506850656 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if 1677839448 
Object target = source.getTarget();
//#endif 


//#if 1679963387 
if(Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if -2025795117 
Object m = target;
//#endif 


//#if -843812716 
Model.getCoreHelper().setNavigable(m, source.isSelected());
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

