
//#if -1305005015 
// Compilation Unit of /UMLStimulusActionTextProperty.java 
 

//#if -1596925443 
package org.argouml.uml.ui;
//#endif 


//#if 500107813 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -2102179092 
import org.argouml.model.Model;
//#endif 


//#if -705011158 
public class UMLStimulusActionTextProperty  { 

//#if 1493144939 
private String thePropertyName;
//#endif 


//#if 773362639 
boolean isAffected(PropertyChangeEvent event)
    { 

//#if 232461780 
String sourceName = event.getPropertyName();
//#endif 


//#if -1688506174 
return (thePropertyName == null
                || sourceName == null
                || sourceName.equals(thePropertyName));
//#endif 

} 

//#endif 


//#if -2068222890 
public void setProperty(UMLUserInterfaceContainer container,
                            String newValue)
    { 

//#if -1281417911 
Object stimulus = container.getTarget();
//#endif 


//#if -1013739723 
if(stimulus != null)//1
{ 

//#if 1365395873 
String oldValue = getProperty(container);
//#endif 


//#if -749194303 
if(newValue == null
                    || oldValue == null
                    || !newValue.equals(oldValue))//1
{ 

//#if -1073563417 
if(newValue != oldValue)//1
{ 

//#if 1275255979 
Object action =
                        Model.getFacade().getDispatchAction(stimulus);
//#endif 


//#if 1517317602 
Model.getCoreHelper().setName(action, newValue);
//#endif 


//#if 526064747 
String dummyStr = Model.getFacade().getName(stimulus);
//#endif 


//#if 1497860566 
Model.getCoreHelper().setName(stimulus, dummyStr);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1947396349 
void targetChanged()
    { 
} 

//#endif 


//#if -48345915 
public String getProperty(UMLUserInterfaceContainer container)
    { 

//#if 1823819992 
String value = null;
//#endif 


//#if -44140923 
Object stimulus = container.getTarget();
//#endif 


//#if -398139279 
if(stimulus != null)//1
{ 

//#if -407921164 
Object action = Model.getFacade().getDispatchAction(stimulus);
//#endif 


//#if 1810496520 
if(action != null)//1
{ 

//#if -271788932 
value = Model.getFacade().getName(action);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 109600249 
return value;
//#endif 

} 

//#endif 


//#if -435338822 
public UMLStimulusActionTextProperty(String propertyName)
    { 

//#if 157584926 
thePropertyName = propertyName;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

