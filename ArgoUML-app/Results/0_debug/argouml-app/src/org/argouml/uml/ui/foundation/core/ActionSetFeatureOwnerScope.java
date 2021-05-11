
//#if 1833200925 
// Compilation Unit of /ActionSetFeatureOwnerScope.java 
 

//#if -1939309457 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 28621937 
import java.awt.event.ActionEvent;
//#endif 


//#if 2041432807 
import javax.swing.Action;
//#endif 


//#if -213730780 
import org.argouml.i18n.Translator;
//#endif 


//#if 1608398570 
import org.argouml.model.Model;
//#endif 


//#if -93471693 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1629879801 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1622283799 
public class ActionSetFeatureOwnerScope extends 
//#if 1391564368 
UndoableAction
//#endif 

  { 

//#if -207415347 
private static final ActionSetFeatureOwnerScope SINGLETON =
        new ActionSetFeatureOwnerScope();
//#endif 


//#if 1947963758 
public static ActionSetFeatureOwnerScope getInstance()
    { 

//#if 341437958 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 700367313 
public void actionPerformed(ActionEvent e)
    { 

//#if 1956254130 
super.actionPerformed(e);
//#endif 


//#if -1447367039 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if 1807148751 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -724499767 
Object target = source.getTarget();
//#endif 


//#if -786888236 
if(Model.getFacade().isAFeature(target))//1
{ 

//#if 600570113 
Model.getCoreHelper().setStatic(target, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -199200386 
protected ActionSetFeatureOwnerScope()
    { 

//#if -1440046756 
super(Translator.localize("Set"), null);
//#endif 


//#if -1883713037 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

