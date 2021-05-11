
//#if 1460183237 
// Compilation Unit of /ActionSetMultiplicity.java 
 

//#if 1639087281 
package org.argouml.uml.ui;
//#endif 


//#if -1265648645 
import java.awt.event.ActionEvent;
//#endif 


//#if 2044589169 
import javax.swing.Action;
//#endif 


//#if -1681413158 
import org.argouml.i18n.Translator;
//#endif 


//#if -282470511 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1472189403 
public abstract class ActionSetMultiplicity extends 
//#if 397515492 
UndoableAction
//#endif 

  { 

//#if -1276163139 
public void actionPerformed(ActionEvent e)
    { 

//#if -1594403008 
super.actionPerformed(e);
//#endif 


//#if 1043364591 
Object source = e.getSource();
//#endif 


//#if -1990001995 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1412985766 
Object selected = ((UMLComboBox2) source).getSelectedItem();
//#endif 


//#if -515097223 
Object target = ((UMLComboBox2) source).getTarget();
//#endif 


//#if 1778039482 
if(target != null && selected != null)//1
{ 

//#if 1133150761 
setSelectedItem(selected, target);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -7099570 
protected ActionSetMultiplicity()
    { 

//#if 410790722 
super(Translator.localize("Set"), null);
//#endif 


//#if -719092403 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 1277539558 
public abstract void setSelectedItem(Object item, Object target);
//#endif 

 } 

//#endif 


//#endif 

