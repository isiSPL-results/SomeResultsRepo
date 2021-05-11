// Compilation Unit of /UMLStimulusActionTextProperty.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import org.argouml.model.Model;
public class UMLStimulusActionTextProperty  { 
private String thePropertyName;
boolean isAffected(PropertyChangeEvent event)
    { 
String sourceName = event.getPropertyName();
return (thePropertyName == null
                || sourceName == null
                || sourceName.equals(thePropertyName));
} 

public void setProperty(UMLUserInterfaceContainer container,
                            String newValue)
    { 
Object stimulus = container.getTarget();
if(stimulus != null)//1
{ 
String oldValue = getProperty(container);
if(newValue == null
                    || oldValue == null
                    || !newValue.equals(oldValue))//1
{ 
if(newValue != oldValue)//1
{ 
Object action =
                        Model.getFacade().getDispatchAction(stimulus);
Model.getCoreHelper().setName(action, newValue);
String dummyStr = Model.getFacade().getName(stimulus);
Model.getCoreHelper().setName(stimulus, dummyStr);
} 

} 

} 

} 

void targetChanged()
    { 
} 

public String getProperty(UMLUserInterfaceContainer container)
    { 
String value = null;
Object stimulus = container.getTarget();
if(stimulus != null)//1
{ 
Object action = Model.getFacade().getDispatchAction(stimulus);
if(action != null)//1
{ 
value = Model.getFacade().getName(action);
} 

} 

return value;
} 

public UMLStimulusActionTextProperty(String propertyName)
    { 
thePropertyName = propertyName;
} 

 } 


