
//#if -392435417 
// Compilation Unit of /ActionSetFeatureOwner.java 
 

//#if -1551176927 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 583245183 
import java.awt.event.ActionEvent;
//#endif 


//#if 675125749 
import javax.swing.Action;
//#endif 


//#if -200279338 
import org.argouml.i18n.Translator;
//#endif 


//#if -977559396 
import org.argouml.model.Model;
//#endif 


//#if 2067589919 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 322303253 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -136516515 
public class ActionSetFeatureOwner extends 
//#if -1140748998 
UndoableAction
//#endif 

  { 

//#if 288318049 
private static final ActionSetFeatureOwner SINGLETON =
        new ActionSetFeatureOwner();
//#endif 


//#if 1175815719 
public void actionPerformed(ActionEvent e)
    { 

//#if -278331117 
super.actionPerformed(e);
//#endif 


//#if -1226900478 
Object source = e.getSource();
//#endif 


//#if 1836275981 
Object oldClassifier = null;
//#endif 


//#if 1013400198 
Object newClassifier = null;
//#endif 


//#if -724710309 
Object feature = null;
//#endif 


//#if -250300216 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1537421137 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -108084991 
Object o = box.getTarget();
//#endif 


//#if -797576580 
if(Model.getFacade().isAFeature(o))//1
{ 

//#if 1610632022 
feature = o;
//#endif 


//#if -1141395529 
oldClassifier = Model.getFacade().getOwner(feature);
//#endif 

} 

//#endif 


//#if -1058876603 
o = box.getSelectedItem();
//#endif 


//#if -1433513951 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if 315260376 
newClassifier = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -711230378 
if(newClassifier != oldClassifier
                && feature != null
                && newClassifier != null)//1
{ 

//#if 619988465 
Model.getCoreHelper().setOwner(feature, newClassifier);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 330649730 
protected ActionSetFeatureOwner()
    { 

//#if -2071991960 
super(Translator.localize("Set"), null);
//#endif 


//#if 637877351 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -883116384 
public static ActionSetFeatureOwner getInstance()
    { 

//#if 557618584 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

