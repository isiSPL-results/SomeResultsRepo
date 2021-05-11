
//#if -1189424283 
// Compilation Unit of /UMLComponentResidentListModel.java 
 

//#if 226478691 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 916706014 
import org.argouml.model.Model;
//#endif 


//#if -243711994 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -569241874 
import java.util.ArrayList;
//#endif 


//#if -589360669 
import java.util.Iterator;
//#endif 


//#if -401519480 
public class UMLComponentResidentListModel extends 
//#if -1241805257 
UMLModelElementListModel2
//#endif 

  { 

//#if -2096506477 
public UMLComponentResidentListModel()
    { 

//#if -690162952 
super("resident");
//#endif 

} 

//#endif 


//#if -631859931 
protected void buildModelList()
    { 

//#if 1790288074 
if(Model.getFacade().isAComponent(getTarget()))//1
{ 

//#if -1850969303 
Iterator it = Model.getFacade()
                          .getResidentElements(getTarget()).iterator();
//#endif 


//#if 800575444 
ArrayList list = new ArrayList();
//#endif 


//#if -1799133263 
while (it.hasNext()) //1
{ 

//#if 2083056179 
list.add(Model.getFacade().getResident(it.next()));
//#endif 

} 

//#endif 


//#if 15522235 
setAllElements(list);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1429188282 
protected boolean isValidElement(Object o)
    { 

//#if -1174063615 
return (Model.getFacade().isAModelElement(o));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

