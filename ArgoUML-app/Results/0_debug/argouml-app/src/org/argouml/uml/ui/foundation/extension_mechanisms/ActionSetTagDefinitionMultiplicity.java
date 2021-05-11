
//#if -447325921 
// Compilation Unit of /ActionSetTagDefinitionMultiplicity.java 
 

//#if 1142527055 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -1354699643 
import org.argouml.model.Model;
//#endif 


//#if 1719345602 
import org.argouml.uml.ui.ActionSetMultiplicity;
//#endif 


//#if -601767773 
public class ActionSetTagDefinitionMultiplicity extends 
//#if -1917821978 
ActionSetMultiplicity
//#endif 

  { 

//#if -693626481 
public ActionSetTagDefinitionMultiplicity()
    { 

//#if 957850558 
super();
//#endif 

} 

//#endif 


//#if 1399110105 
public void setSelectedItem(Object item, Object target)
    { 

//#if -1016803440 
if(target != null
                && Model.getFacade().isATagDefinition(target))//1
{ 

//#if -760463782 
if(Model.getFacade().isAMultiplicity(item))//1
{ 

//#if -1955737712 
if(!item.equals(Model.getFacade().getMultiplicity(target)))//1
{ 

//#if -2033036260 
Model.getCoreHelper().setMultiplicity(target, item);
//#endif 

} 

//#endif 

} 
else

//#if 388433247 
if(item instanceof String)//1
{ 

//#if 552591213 
if(!item.equals(Model.getFacade().toString(
                                     Model.getFacade().getMultiplicity(target))))//1
{ 

//#if 498493683 
Model.getCoreHelper().setMultiplicity(
                        target,
                        Model.getDataTypesFactory().createMultiplicity(
                            (String) item));
//#endif 

} 

//#endif 

} 
else
{ 

//#if 444701866 
Model.getCoreHelper().setMultiplicity(target, null);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

