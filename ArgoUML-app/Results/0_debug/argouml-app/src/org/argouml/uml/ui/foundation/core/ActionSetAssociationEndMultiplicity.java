
//#if 962299033 
// Compilation Unit of /ActionSetAssociationEndMultiplicity.java 
 

//#if 238251665 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1106889740 
import org.argouml.model.Model;
//#endif 


//#if 1470783771 
import org.argouml.uml.ui.ActionSetMultiplicity;
//#endif 


//#if -1271090775 
public class ActionSetAssociationEndMultiplicity extends 
//#if -732354955 
ActionSetMultiplicity
//#endif 

  { 

//#if 1984580601 
private static final ActionSetAssociationEndMultiplicity SINGLETON =
        new ActionSetAssociationEndMultiplicity();
//#endif 


//#if 228330922 
public void setSelectedItem(Object item, Object target)
    { 

//#if -1511657474 
if(target != null && Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if -2104644638 
if(Model.getFacade().isAMultiplicity(item))//1
{ 

//#if -554874272 
if(!item.equals(Model.getFacade().getMultiplicity(target)))//1
{ 

//#if -401155421 
Model.getCoreHelper().setMultiplicity(target, item);
//#endif 

} 

//#endif 

} 
else

//#if 1019525422 
if(item instanceof String)//1
{ 

//#if -1902831419 
if(!item.equals(Model.getFacade().toString(
                                     Model.getFacade().getMultiplicity(target))))//1
{ 

//#if 1190192121 
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

//#if 860112787 
Model.getCoreHelper().setMultiplicity(target, null);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -127282668 
public static ActionSetAssociationEndMultiplicity getInstance()
    { 

//#if -485294963 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1391611559 
public ActionSetAssociationEndMultiplicity()
    { 

//#if 500650007 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

