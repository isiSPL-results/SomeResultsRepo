
//#if -501954600 
// Compilation Unit of /ActionSetGeneralizableElementLeaf.java 
 

//#if 740143653 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1519919611 
import java.awt.event.ActionEvent;
//#endif 


//#if -1985193359 
import javax.swing.Action;
//#endif 


//#if -1228143142 
import org.argouml.i18n.Translator;
//#endif 


//#if -1893872224 
import org.argouml.model.Model;
//#endif 


//#if -60932887 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 1366048145 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -556029301 
public class ActionSetGeneralizableElementLeaf extends 
//#if -1665729318 
UndoableAction
//#endif 

  { 

//#if -744872403 
private static final ActionSetGeneralizableElementLeaf SINGLETON =
        new ActionSetGeneralizableElementLeaf();
//#endif 


//#if -160466996 
protected ActionSetGeneralizableElementLeaf()
    { 

//#if -1160299732 
super(Translator.localize("Set"), null);
//#endif 


//#if 758394403 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -1914770809 
public void actionPerformed(ActionEvent e)
    { 

//#if -401198646 
super.actionPerformed(e);
//#endif 


//#if -944766615 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -561698486 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -343705170 
Object target = source.getTarget();
//#endif 


//#if 131638572 
if(Model.getFacade().isAGeneralizableElement(target)
                    || Model.getFacade().isAOperation(target)
                    || Model.getFacade().isAReception(target))//1
{ 

//#if 219753017 
Model.getCoreHelper().setLeaf(target, source.isSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 753782998 
public static ActionSetGeneralizableElementLeaf getInstance()
    { 

//#if -1812517561 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

