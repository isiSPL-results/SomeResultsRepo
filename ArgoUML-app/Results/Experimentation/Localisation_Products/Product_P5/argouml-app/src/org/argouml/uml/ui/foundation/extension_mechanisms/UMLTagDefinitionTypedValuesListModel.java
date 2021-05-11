package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
class UMLTagDefinitionTypedValuesListModel extends UMLModelElementListModel2
  { 
public UMLTagDefinitionTypedValuesListModel()
    { 
super("typedValue");
} 
protected boolean isValidElement(Object element)
    { 
Iterator i = Model.getFacade().getTypedValues(getTarget()).iterator();
while (i.hasNext()) //1
{ 
if(element.equals(Model.getFacade().getModelElementContainer(
                                   i.next())))//1
{ 
return true;
} 
} 
return false;
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
Collection typedValues = Model.getFacade().getTypedValues(
                                         getTarget());
Collection taggedValues = new HashSet();
for (Iterator i = typedValues.iterator(); i.hasNext();) //1
{ 
taggedValues.add(Model.getFacade().getModelElementContainer(
                                     i.next()));
} 
setAllElements(taggedValues);
} 
} 

 } 
