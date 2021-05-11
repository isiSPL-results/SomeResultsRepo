// Compilation Unit of /UMLComponentResidentListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
import java.util.ArrayList;
import java.util.Iterator;
public class UMLComponentResidentListModel extends UMLModelElementListModel2
  { 
public UMLComponentResidentListModel()
    { 
super("resident");
} 

protected void buildModelList()
    { 
if(Model.getFacade().isAComponent(getTarget()))//1
{ 
Iterator it = Model.getFacade()
                          .getResidentElements(getTarget()).iterator();
ArrayList list = new ArrayList();
while (it.hasNext()) //1
{ 
list.add(Model.getFacade().getResident(it.next()));
} 

setAllElements(list);
} 

} 

protected boolean isValidElement(Object o)
    { 
return (Model.getFacade().isAModelElement(o));
} 

 } 


