
//#if -43623805 
// Compilation Unit of /ActionSetModelElementStereotype.java 
 

//#if -1364314448 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 992298256 
import java.awt.event.ActionEvent;
//#endif 


//#if -63268986 
import java.util.Collection;
//#endif 


//#if 354706054 
import javax.swing.Action;
//#endif 


//#if -404535963 
import org.argouml.i18n.Translator;
//#endif 


//#if 960531115 
import org.argouml.model.Model;
//#endif 


//#if 1748653614 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -641500250 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1206074804 
public class ActionSetModelElementStereotype extends 
//#if -605431190 
UndoableAction
//#endif 

  { 

//#if -522933695 
private static final ActionSetModelElementStereotype SINGLETON =
        new ActionSetModelElementStereotype();
//#endif 


//#if -960037766 
protected ActionSetModelElementStereotype()
    { 

//#if -248374856 
super(Translator.localize("Set"), null);
//#endif 


//#if -1671843305 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 284534216 
public static ActionSetModelElementStereotype getInstance()
    { 

//#if -820327274 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 300773111 
public void actionPerformed(ActionEvent e)
    { 

//#if -1367414594 
super.actionPerformed(e);
//#endif 


//#if 135898349 
Object source = e.getSource();
//#endif 


//#if -1397080048 
Collection oldStereo = null;
//#endif 


//#if 490684232 
Object newStereo = null;
//#endif 


//#if -2081997105 
Object target = null;
//#endif 


//#if 1811498675 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1411904581 
UMLComboBox2 combo = (UMLComboBox2) source;
//#endif 


//#if -1687518205 
if(Model.getFacade().isAStereotype(combo.getSelectedItem()))//1
{ 

//#if -2102711619 
newStereo = combo.getSelectedItem();
//#endif 

} 

//#endif 


//#if -2016317345 
if(Model.getFacade().isAModelElement(combo.getTarget()))//1
{ 

//#if 210330484 
target = combo.getTarget();
//#endif 


//#if -1019628491 
oldStereo = Model.getFacade().getStereotypes(target);
//#endif 

} 

//#endif 


//#if -1527252291 
if("".equals(combo.getSelectedItem()))//1
{ 

//#if 1691273558 
newStereo = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1468779355 
if(oldStereo != null && !oldStereo.contains(newStereo)
                && target != null)//1
{ 

//#if -2060617303 
if(newStereo != null)//1
{ 

//#if -2126490078 
Model.getCoreHelper().addStereotype(target, newStereo);
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

