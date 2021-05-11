
//#if 474966352 
// Compilation Unit of /UMLTagDefinitionTypedValuesListModel.java 
 

//#if 920021931 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 1834924048 
import java.util.Collection;
//#endif 


//#if -714117004 
import java.util.HashSet;
//#endif 


//#if 1337895168 
import java.util.Iterator;
//#endif 


//#if -1805179423 
import org.argouml.model.Model;
//#endif 


//#if -894894877 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 955404456 
class UMLTagDefinitionTypedValuesListModel extends 
//#if -461885576 
UMLModelElementListModel2
//#endif 

  { 

//#if -1355625640 
public UMLTagDefinitionTypedValuesListModel()
    { 

//#if -712805279 
super("typedValue");
//#endif 

} 

//#endif 


//#if -1740961254 
protected boolean isValidElement(Object element)
    { 

//#if -1202291382 
Iterator i = Model.getFacade().getTypedValues(getTarget()).iterator();
//#endif 


//#if -406623305 
while (i.hasNext()) //1
{ 

//#if -2092409482 
if(element.equals(Model.getFacade().getModelElementContainer(
                                   i.next())))//1
{ 

//#if 1617405589 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1861902475 
return false;
//#endif 

} 

//#endif 


//#if 1261350374 
protected void buildModelList()
    { 

//#if 1344478009 
if(getTarget() != null)//1
{ 

//#if -86768932 
Collection typedValues = Model.getFacade().getTypedValues(
                                         getTarget());
//#endif 


//#if 2144092536 
Collection taggedValues = new HashSet();
//#endif 


//#if 826658208 
for (Iterator i = typedValues.iterator(); i.hasNext();) //1
{ 

//#if -2013296234 
taggedValues.add(Model.getFacade().getModelElementContainer(
                                     i.next()));
//#endif 

} 

//#endif 


//#if 158271535 
setAllElements(taggedValues);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

