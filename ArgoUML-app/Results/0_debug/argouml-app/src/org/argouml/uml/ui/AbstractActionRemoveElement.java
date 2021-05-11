
//#if 1387513796 
// Compilation Unit of /AbstractActionRemoveElement.java 
 

//#if -1366851352 
package org.argouml.uml.ui;
//#endif 


//#if 1254886746 
import javax.swing.Action;
//#endif 


//#if 806127889 
import org.argouml.i18n.Translator;
//#endif 


//#if -1482049217 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -174685097 
import org.argouml.model.Model;
//#endif 


//#if 2072182394 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1227289585 

//#if -1527048129 
@UmlModelMutator
//#endif 

public class AbstractActionRemoveElement extends 
//#if 440403622 
UndoableAction
//#endif 

  { 

//#if -1454826278 
private Object target;
//#endif 


//#if -1415483187 
private Object objectToRemove;
//#endif 


//#if 244136394 
public void setTarget(Object theTarget)
    { 

//#if 531042662 
target = theTarget;
//#endif 


//#if 1091886240 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if -1756895639 
protected AbstractActionRemoveElement(String name)
    { 

//#if 307045394 
super(Translator.localize(name),
              null);
//#endif 


//#if 884318541 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
//#endif 

} 

//#endif 


//#if 1361588261 
protected AbstractActionRemoveElement()
    { 

//#if -948407676 
this(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if 693884302 
public Object getTarget()
    { 

//#if -559742667 
return target;
//#endif 

} 

//#endif 


//#if 2123639216 
public void setObjectToRemove(Object theObjectToRemove)
    { 

//#if 33269216 
objectToRemove = theObjectToRemove;
//#endif 


//#if 2110275020 
setEnabled(isEnabled());
//#endif 

} 

//#endif 


//#if 804647931 
public Object getObjectToRemove()
    { 

//#if -1316775628 
return objectToRemove;
//#endif 

} 

//#endif 


//#if -1306995853 
@Override
    public boolean isEnabled()
    { 

//#if -1560389680 
return getObjectToRemove() != null
               && !Model.getModelManagementHelper().isReadOnly(
                   getObjectToRemove()) && getTarget() != null
               && !Model.getModelManagementHelper().isReadOnly(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

