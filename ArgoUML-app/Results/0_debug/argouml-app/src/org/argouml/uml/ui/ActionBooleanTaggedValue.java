
//#if -542064237 
// Compilation Unit of /ActionBooleanTaggedValue.java 
 

//#if -945216008 
package org.argouml.uml.ui;
//#endif 


//#if 1139565780 
import java.awt.event.ActionEvent;
//#endif 


//#if 1129940554 
import javax.swing.Action;
//#endif 


//#if -134210015 
import org.argouml.i18n.Translator;
//#endif 


//#if -1405148825 
import org.argouml.model.Model;
//#endif 


//#if -111110294 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 450545140 
public class ActionBooleanTaggedValue extends 
//#if 1425555834 
UndoableAction
//#endif 

  { 

//#if 303724292 
private String tagName;
//#endif 


//#if -1505553826 
public ActionBooleanTaggedValue(String theTagName)
    { 

//#if 1263896449 
super(Translator.localize("Set"), null);
//#endif 


//#if 300208686 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 


//#if -2045403254 
tagName = theTagName;
//#endif 

} 

//#endif 


//#if 739491463 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 550903905 
super.actionPerformed(e);
//#endif 


//#if -1785055250 
if(!(e.getSource() instanceof UMLCheckBox2))//1
{ 

//#if -950576111 
return;
//#endif 

} 

//#endif 


//#if -1128491622 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -1676837956 
Object obj = source.getTarget();
//#endif 


//#if 624461365 
if(!Model.getFacade().isAModelElement(obj))//1
{ 

//#if -602641374 
return;
//#endif 

} 

//#endif 


//#if -1187202229 
boolean newState = source.isSelected();
//#endif 


//#if 659978183 
Object taggedValue = Model.getFacade().getTaggedValue(obj, tagName);
//#endif 


//#if -300049362 
if(taggedValue == null)//1
{ 

//#if 1409514696 
taggedValue =
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    tagName, "");
//#endif 


//#if -1694057258 
Model.getExtensionMechanismsHelper().addTaggedValue(
                obj, taggedValue);
//#endif 

} 

//#endif 


//#if 621044415 
if(newState)//1
{ 

//#if 809632419 
Model.getCommonBehaviorHelper().setValue(taggedValue, "true");
//#endif 

} 
else
{ 

//#if 1356616123 
Model.getCommonBehaviorHelper().setValue(taggedValue, "false");
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

