
//#if -1816331745 
// Compilation Unit of /ActionSetTagDefinitionOwner.java 
 

//#if -2140607325 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -1822560504 
import java.awt.AWTEvent;
//#endif 


//#if 389049890 
import java.awt.event.ActionEvent;
//#endif 


//#if 1458224536 
import javax.swing.Action;
//#endif 


//#if 483598182 
import org.apache.log4j.Logger;
//#endif 


//#if -613357678 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1925366125 
import org.argouml.i18n.Translator;
//#endif 


//#if -1963832615 
import org.argouml.model.Model;
//#endif 


//#if 1886914652 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -580554056 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1256549789 
public class ActionSetTagDefinitionOwner extends 
//#if 708157985 
UndoableAction
//#endif 

  { 

//#if 1503124457 
private static final Logger LOG =
        Logger.getLogger(ActionSetTagDefinitionOwner.class);
//#endif 


//#if -1886716586 
public static final ActionSetTagDefinitionOwner SINGLETON =
        new ActionSetTagDefinitionOwner();
//#endif 


//#if 1567320690 
private static final long serialVersionUID = -5230402929326015086L;
//#endif 


//#if 1648429149 
public ActionSetTagDefinitionOwner()
    { 

//#if -298663766 
super(Translator.localize("Set"),
              ResourceLoaderWrapper.lookupIcon("Set"));
//#endif 


//#if 1121765838 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -782355090 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -494417610 
super.actionPerformed(e);
//#endif 


//#if 1567377253 
Object source = e.getSource();
//#endif 


//#if -1169591114 
LOG.info("Receiving " + e + "/" + e.getID() + "/"
                 + e.getActionCommand());
//#endif 


//#if 214909650 
if(source instanceof UMLComboBox2
                && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 

//#if -2021427226 
UMLComboBox2 combo = (UMLComboBox2) source;
//#endif 


//#if 1206011469 
Object o = combo.getSelectedItem();
//#endif 


//#if 1332969390 
final Object tagDefinition = combo.getTarget();
//#endif 


//#if 622526928 
LOG.info("Set owner to " + o);
//#endif 


//#if 1448990808 
if(Model.getFacade().isAStereotype(o)
                    && Model.getFacade().isATagDefinition(tagDefinition))//1
{ 

//#if -1999723691 
Model.getCoreHelper().setOwner(tagDefinition, o);
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

