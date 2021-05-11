
//#if 1386310847 
// Compilation Unit of /ActionSetMetaClass.java 
 

//#if 303809260 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -1623539783 
import java.awt.event.ActionEvent;
//#endif 


//#if 302482671 
import java.util.Collection;
//#endif 


//#if -252733905 
import javax.swing.Action;
//#endif 


//#if -876130405 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 108863452 
import org.argouml.i18n.Translator;
//#endif 


//#if 736114850 
import org.argouml.model.Model;
//#endif 


//#if -1729880795 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -689160881 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1840590163 
public class ActionSetMetaClass extends 
//#if 1848854118 
UndoableAction
//#endif 

  { 

//#if -1759771623 
public static final ActionSetMetaClass SINGLETON =
        new ActionSetMetaClass();
//#endif 


//#if 460338811 
public void actionPerformed(ActionEvent e)
    { 

//#if -1010145229 
super.actionPerformed(e);
//#endif 


//#if -125625566 
Object source = e.getSource();
//#endif 


//#if -1484585770 
Object newBase = null;
//#endif 


//#if -1544190431 
Object stereo = null;
//#endif 


//#if 548911080 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1427511070 
UMLComboBox2 combo = (UMLComboBox2) source;
//#endif 


//#if 1045154186 
stereo = combo.getTarget();
//#endif 


//#if 777100859 
if(Model.getFacade().isAStereotype(stereo))//1
{ 

//#if -1301723509 
Collection oldBases = Model.getFacade().getBaseClasses(stereo);
//#endif 


//#if -798723200 
newBase = combo.getSelectedItem();
//#endif 


//#if 1894198287 
if(newBase != null)//1
{ 

//#if -1694398594 
if(!oldBases.contains(newBase))//1
{ 

//#if -2146557184 
Model.getExtensionMechanismsHelper().addBaseClass(
                            stereo,
                            newBase);
//#endif 

} 
else
{ 

//#if 70939469 
if(newBase != null && newBase.equals(""))//1
{ 

//#if -2089419042 
Model.getExtensionMechanismsHelper().addBaseClass(
                                stereo, "ModelElement");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1659238403 
public ActionSetMetaClass()
    { 

//#if 2006050544 
super(Translator.localize("Set"),
              ResourceLoaderWrapper.lookupIcon("Set"));
//#endif 


//#if -79779564 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

