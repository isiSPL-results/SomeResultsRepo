
//#if 855776456 
// Compilation Unit of /ActionSetBehavioralFeatureQuery.java 
 

//#if -2125081163 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 542030955 
import java.awt.event.ActionEvent;
//#endif 


//#if 891053281 
import javax.swing.Action;
//#endif 


//#if -1477920406 
import org.argouml.i18n.Translator;
//#endif 


//#if 1497549104 
import org.argouml.model.Model;
//#endif 


//#if -506025863 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 165242881 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1368911779 
public class ActionSetBehavioralFeatureQuery extends 
//#if 118005048 
UndoableAction
//#endif 

  { 

//#if -8858053 
private static final ActionSetBehavioralFeatureQuery SINGLETON =
        new ActionSetBehavioralFeatureQuery();
//#endif 


//#if -98336660 
public static ActionSetBehavioralFeatureQuery getInstance()
    { 

//#if -663175143 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 846057449 
public void actionPerformed(ActionEvent e)
    { 

//#if -1525312641 
super.actionPerformed(e);
//#endif 


//#if 174301268 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 1813646406 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -478380494 
Object target = source.getTarget();
//#endif 


//#if 1851608398 
if(Model.getFacade().isABehavioralFeature(target))//1
{ 

//#if 787988653 
Object m = target;
//#endif 


//#if 2138803815 
Model.getCoreHelper().setQuery(m, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1435722062 
protected ActionSetBehavioralFeatureQuery()
    { 

//#if 1600278245 
super(Translator.localize("Set"), null);
//#endif 


//#if -687605174 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

