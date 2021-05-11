// Compilation Unit of /ActionSetTagDefinitionMultiplicity.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionSetMultiplicity;
public class ActionSetTagDefinitionMultiplicity extends ActionSetMultiplicity
  { 
public ActionSetTagDefinitionMultiplicity()
    { 
super();
} 

public void setSelectedItem(Object item, Object target)
    { 
if(target != null
                && Model.getFacade().isATagDefinition(target))//1
{ 
if(Model.getFacade().isAMultiplicity(item))//1
{ 
if(!item.equals(Model.getFacade().getMultiplicity(target)))//1
{ 
Model.getCoreHelper().setMultiplicity(target, item);
} 

} 
else
if(item instanceof String)//1
{ 
if(!item.equals(Model.getFacade().toString(
                                     Model.getFacade().getMultiplicity(target))))//1
{ 
Model.getCoreHelper().setMultiplicity(
                        target,
                        Model.getDataTypesFactory().createMultiplicity(
                            (String) item));
} 

} 
else
{ 
Model.getCoreHelper().setMultiplicity(target, null);
} 


} 

} 

 } 


