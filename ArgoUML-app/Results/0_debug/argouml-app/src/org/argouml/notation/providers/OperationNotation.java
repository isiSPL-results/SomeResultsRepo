
//#if -1125662615 
// Compilation Unit of /OperationNotation.java 
 

//#if -223169190 
package org.argouml.notation.providers;
//#endif 


//#if -790859936 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 432946984 
import java.beans.PropertyChangeListener;
//#endif 


//#if -683874368 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 295010833 
import org.argouml.model.Model;
//#endif 


//#if 1954555551 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -719443114 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 2003592052 
public abstract class OperationNotation extends 
//#if 2006880819 
NotationProvider
//#endif 

  { 

//#if 2059712975 
@Override
    public void updateListener(PropertyChangeListener listener,
                               Object modelElement, PropertyChangeEvent pce)
    { 

//#if 1024060375 
if(pce.getSource() == modelElement
                && ("stereotype".equals(pce.getPropertyName())
                    || "parameter".equals(pce.getPropertyName())
                    || "taggedValue".equals(pce.getPropertyName())))//1
{ 

//#if -2044253469 
if(pce instanceof AddAssociationEvent)//1
{ 

//#if 806586024 
addElementListener(listener, pce.getNewValue());
//#endif 

} 

//#endif 


//#if 1408132516 
if(pce instanceof RemoveAssociationEvent)//1
{ 

//#if -177536832 
removeElementListener(listener, pce.getOldValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1402517893 
if(!Model.getUmlFactory().isRemoved(modelElement))//1
{ 

//#if -1597628945 
for (Object param : Model.getFacade().getParameters(modelElement)) //1
{ 

//#if 1559600180 
if(pce.getSource() == param
                        && ("type".equals(pce.getPropertyName())))//1
{ 

//#if -1689248605 
if(pce instanceof AddAssociationEvent)//1
{ 

//#if -1091752759 
addElementListener(listener, pce.getNewValue());
//#endif 

} 

//#endif 


//#if -1146414108 
if(pce instanceof RemoveAssociationEvent)//1
{ 

//#if 1075385348 
removeElementListener(listener, pce.getOldValue());
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


//#if -1150537911 
public OperationNotation(Object operation)
    { 

//#if 419562173 
if(!Model.getFacade().isAOperation(operation)
                && !Model.getFacade().isAReception(operation))//1
{ 

//#if 1865966318 
throw new IllegalArgumentException(
                "This is not an Operation or Reception.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -232849908 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -1601962286 
addElementListener(listener, modelElement);
//#endif 


//#if 938128005 
if(Model.getFacade().isAOperation(modelElement))//1
{ 

//#if -635010056 
for (Object uml : Model.getFacade().getStereotypes(modelElement)) //1
{ 

//#if -1120539844 
addElementListener(listener, uml);
//#endif 

} 

//#endif 


//#if 1409915199 
for (Object uml : Model.getFacade().getParameters(modelElement)) //1
{ 

//#if 1648943977 
addElementListener(listener, uml);
//#endif 


//#if 2127135174 
Object type = Model.getFacade().getType(uml);
//#endif 


//#if 1290344946 
if(type != null)//1
{ 

//#if 2063215162 
addElementListener(listener, type);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1096411327 
for (Object uml : Model.getFacade()
                    .getTaggedValuesCollection(modelElement)) //1
{ 

//#if -2017239768 
addElementListener(listener, uml);
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

