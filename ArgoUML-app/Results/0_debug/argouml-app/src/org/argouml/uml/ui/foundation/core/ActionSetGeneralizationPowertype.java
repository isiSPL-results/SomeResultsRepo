
//#if 2087376196 
// Compilation Unit of /ActionSetGeneralizationPowertype.java 
 

//#if -2113926377 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 447385801 
import java.awt.event.ActionEvent;
//#endif 


//#if -1417054401 
import javax.swing.Action;
//#endif 


//#if -116952884 
import org.argouml.i18n.Translator;
//#endif 


//#if 915964306 
import org.argouml.model.Model;
//#endif 


//#if -1426295275 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1774059937 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1016637843 
public class ActionSetGeneralizationPowertype extends 
//#if -1144185214 
UndoableAction
//#endif 

  { 

//#if 258875455 
private static final ActionSetGeneralizationPowertype SINGLETON =
        new ActionSetGeneralizationPowertype();
//#endif 


//#if 1051566864 
public static ActionSetGeneralizationPowertype getInstance()
    { 

//#if -1895770481 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 283167416 
protected ActionSetGeneralizationPowertype()
    { 

//#if -1141410837 
super(Translator.localize("Set"), null);
//#endif 


//#if 1149144708 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 842488207 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -733418525 
super.actionPerformed(e);
//#endif 


//#if -479235374 
Object source = e.getSource();
//#endif 


//#if 1381188573 
Object oldClassifier = null;
//#endif 


//#if 558312790 
Object newClassifier = null;
//#endif 


//#if -1512551675 
Object gen = null;
//#endif 


//#if -1872142440 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1357121141 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if 2039636645 
Object o = box.getTarget();
//#endif 


//#if 1849800770 
if(Model.getFacade().isAGeneralization(o))//1
{ 

//#if 1306561973 
gen = o;
//#endif 


//#if 498698006 
oldClassifier = Model.getFacade().getPowertype(gen);
//#endif 

} 

//#endif 


//#if 1088845033 
o = box.getSelectedItem();
//#endif 


//#if 2106960637 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if -1727397148 
newClassifier = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1098678824 
if(newClassifier != oldClassifier && gen != null)//1
{ 

//#if 900126538 
Model.getCoreHelper().setPowertype(gen, newClassifier);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

