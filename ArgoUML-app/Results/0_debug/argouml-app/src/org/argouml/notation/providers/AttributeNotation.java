
//#if 1165711766 
// Compilation Unit of /AttributeNotation.java 
 

//#if 936884929 
package org.argouml.notation.providers;
//#endif 


//#if -337796839 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1446541617 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1267989529 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1330503288 
import org.argouml.model.Model;
//#endif 


//#if -507689704 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1303558275 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1698981584 
public abstract class AttributeNotation extends 
//#if -148473098 
NotationProvider
//#endif 

  { 

//#if -821029900 
protected AttributeNotation()
    { 
} 

//#endif 


//#if -1441801265 
@Override
    public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if -156507312 
addElementListener(listener, modelElement);
//#endif 


//#if -456077892 
if(Model.getFacade().isAAttribute(modelElement))//1
{ 

//#if -48427706 
for (Object uml : Model.getFacade().getStereotypes(modelElement)) //1
{ 

//#if -726277952 
addElementListener(listener, uml);
//#endif 

} 

//#endif 


//#if -492539132 
Object type = Model.getFacade().getType(modelElement);
//#endif 


//#if -381912719 
if(type != null)//1
{ 

//#if -1681329847 
addElementListener(listener, type);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2094332116 
@Override
    public void updateListener(PropertyChangeListener listener,
                               Object modelElement, PropertyChangeEvent pce)
    { 

//#if -1921222439 
if(pce.getSource() == modelElement
                && ("stereotype".equals(pce.getPropertyName())
                    || ("type".equals(pce.getPropertyName()))))//1
{ 

//#if -1375733203 
if(pce instanceof AddAssociationEvent)//1
{ 

//#if -1426512047 
addElementListener(listener, pce.getNewValue());
//#endif 

} 

//#endif 


//#if 1532025370 
if(pce instanceof RemoveAssociationEvent)//1
{ 

//#if 144193347 
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


//#endif 

