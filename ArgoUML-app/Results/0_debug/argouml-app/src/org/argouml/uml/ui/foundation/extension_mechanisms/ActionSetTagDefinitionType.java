
//#if 1879122492 
// Compilation Unit of /ActionSetTagDefinitionType.java 
 

//#if -605298584 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 858705597 
import java.awt.event.ActionEvent;
//#endif 


//#if -1194006221 
import javax.swing.Action;
//#endif 


//#if -972358485 
import org.apache.log4j.Logger;
//#endif 


//#if -250941096 
import org.argouml.i18n.Translator;
//#endif 


//#if 875178014 
import org.argouml.model.Model;
//#endif 


//#if -51064671 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1972172717 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -241445723 
public class ActionSetTagDefinitionType extends 
//#if -642365511 
UndoableAction
//#endif 

  { 

//#if 2070521398 
private static final ActionSetTagDefinitionType SINGLETON =
        new ActionSetTagDefinitionType();
//#endif 


//#if 573792420 
private static final Logger LOG =
        Logger.getLogger(ActionSetTagDefinitionType.class);
//#endif 


//#if 2114377013 
public static ActionSetTagDefinitionType getInstance()
    { 

//#if -1314738641 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1697084678 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1016536611 
super.actionPerformed(e);
//#endif 


//#if 1895437586 
Object source = e.getSource();
//#endif 


//#if -1011877736 
LOG.debug("Receiving " + e + "/" + e.getID() + "/"
                  + e.getActionCommand());
//#endif 


//#if 2043491492 
String oldType = null;
//#endif 


//#if 1650978013 
String newType = null;
//#endif 


//#if 1140316676 
Object tagDef = null;
//#endif 


//#if 1397604824 
if(source instanceof UMLComboBox2)//1
{ 

//#if -2044396641 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -1610286420 
Object t = box.getTarget();
//#endif 


//#if -92700368 
if(Model.getFacade().isATagDefinition(t))//1
{ 

//#if 937918104 
tagDef = t;
//#endif 


//#if 886281572 
oldType = (String) Model.getFacade().getType(tagDef);
//#endif 

} 

//#endif 


//#if -703750438 
newType = (String) box.getSelectedItem();
//#endif 


//#if 634735414 
LOG.debug("Selected item is " + newType);
//#endif 

} 

//#endif 


//#if -137496185 
if(newType != null && !newType.equals(oldType) && tagDef != null)//1
{ 

//#if 1210962155 
LOG.debug("New type is " + newType);
//#endif 


//#if -1398054495 
Model.getExtensionMechanismsHelper().setTagType(tagDef, newType);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -448250779 
protected ActionSetTagDefinitionType()
    { 

//#if -401473744 
super(Translator.localize("Set"), null);
//#endif 


//#if -534567521 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

