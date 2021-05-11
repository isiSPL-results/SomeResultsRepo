
//#if 1671604998 
// Compilation Unit of /ActionSetParameterType.java 
 

//#if -1641443013 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1897845285 
import java.awt.event.ActionEvent;
//#endif 


//#if 1980945563 
import javax.swing.Action;
//#endif 


//#if 1897618160 
import org.argouml.i18n.Translator;
//#endif 


//#if -379642442 
import org.argouml.model.Model;
//#endif 


//#if -989417927 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -511892549 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1672260567 
public class ActionSetParameterType extends 
//#if 281257835 
UndoableAction
//#endif 

  { 

//#if -369744920 
private static final ActionSetParameterType SINGLETON =
        new ActionSetParameterType();
//#endif 


//#if 1661618191 
protected ActionSetParameterType()
    { 

//#if -1115074417 
super(Translator.localize("Set"), null);
//#endif 


//#if -678119072 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -1013208025 
public static ActionSetParameterType getInstance()
    { 

//#if 138206748 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1965922248 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1219716077 
super.actionPerformed(e);
//#endif 


//#if -417591204 
Object source = e.getSource();
//#endif 


//#if -960644121 
Object oldClassifier = null;
//#endif 


//#if -1783519904 
Object newClassifier = null;
//#endif 


//#if 1567347599 
Object para = null;
//#endif 


//#if 218944290 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1430075845 
UMLComboBox2 box = ((UMLComboBox2) source);
//#endif 


//#if 703572938 
Object o = box.getTarget();
//#endif 


//#if -1694467790 
if(Model.getFacade().isAParameter(o))//1
{ 

//#if -169259186 
para = o;
//#endif 


//#if -185763844 
oldClassifier = Model.getFacade().getType(para);
//#endif 

} 

//#endif 


//#if -247218674 
o = box.getSelectedItem();
//#endif 


//#if -177655688 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if 800497753 
newClassifier = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1672167368 
if(newClassifier != null
                && newClassifier != oldClassifier
                && para != null)//1
{ 

//#if 267426864 
Model.getCoreHelper().setType(para, newClassifier);
//#endif 


//#if 1713277816 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

