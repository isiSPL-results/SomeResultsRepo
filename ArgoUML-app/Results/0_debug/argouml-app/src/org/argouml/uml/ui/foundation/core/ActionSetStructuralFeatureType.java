
//#if -1434691809 
// Compilation Unit of /ActionSetStructuralFeatureType.java 
 

//#if -2020579774 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -722605762 
import java.awt.event.ActionEvent;
//#endif 


//#if -1552739148 
import javax.swing.Action;
//#endif 


//#if -2026952969 
import org.argouml.i18n.Translator;
//#endif 


//#if 2026898749 
import org.argouml.model.Model;
//#endif 


//#if -726196544 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1493954092 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1760329742 
public class ActionSetStructuralFeatureType extends 
//#if 1916652156 
UndoableAction
//#endif 

  { 

//#if -1201186311 
private static final ActionSetStructuralFeatureType SINGLETON =
        new ActionSetStructuralFeatureType();
//#endif 


//#if 987979534 
protected ActionSetStructuralFeatureType()
    { 

//#if -2122570218 
super(Translator.localize("Set"), null);
//#endif 


//#if -199975943 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -2073524471 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1231504048 
super.actionPerformed(e);
//#endif 


//#if 1896914175 
Object source = e.getSource();
//#endif 


//#if 883103050 
Object oldClassifier = null;
//#endif 


//#if 60227267 
Object newClassifier = null;
//#endif 


//#if -1354517475 
Object attr = null;
//#endif 


//#if 927468741 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1482470789 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if 1772992619 
Object o = box.getTarget();
//#endif 


//#if -480341981 
if(Model.getFacade().isAStructuralFeature(o))//1
{ 

//#if -668321887 
attr = o;
//#endif 


//#if -134050487 
oldClassifier = Model.getFacade().getType(attr);
//#endif 

} 

//#endif 


//#if 822201007 
o = box.getSelectedItem();
//#endif 


//#if -540812809 
if(Model.getFacade().isAClassifier(o))//1
{ 

//#if -1440520964 
newClassifier = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1730423620 
if(newClassifier != oldClassifier && attr != null)//1
{ 

//#if -74862260 
Model.getCoreHelper().setType(attr, newClassifier);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -479179642 
public static ActionSetStructuralFeatureType getInstance()
    { 

//#if -15402492 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

