
//#if -848106167 
// Compilation Unit of /ActionSetClassifierRoleMultiplicity.java 
 

//#if 363140856 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 492061155 
import org.argouml.model.Model;
//#endif 


//#if 510489636 
import org.argouml.uml.ui.ActionSetMultiplicity;
//#endif 


//#if 142398365 
public class ActionSetClassifierRoleMultiplicity extends 
//#if -356381796 
ActionSetMultiplicity
//#endif 

  { 

//#if 1310088952 
private static final ActionSetClassifierRoleMultiplicity SINGLETON =
        new ActionSetClassifierRoleMultiplicity();
//#endif 


//#if -1496261616 
public static ActionSetClassifierRoleMultiplicity getInstance()
    { 

//#if -1578260579 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 169866091 
public ActionSetClassifierRoleMultiplicity()
    { 

//#if 1126065485 
super();
//#endif 

} 

//#endif 


//#if 486883 
public void setSelectedItem(Object item, Object target)
    { 

//#if -2004736462 
if(target != null
                && Model.getFacade().isAClassifierRole(target))//1
{ 

//#if 928558444 
if(Model.getFacade().isAMultiplicity(item))//1
{ 

//#if -913620263 
if(!item.equals(Model.getFacade().getMultiplicity(target)))//1
{ 

//#if -196849755 
Model.getCoreHelper().setMultiplicity(target, item);
//#endif 

} 

//#endif 

} 
else

//#if 1901087144 
if(item instanceof String)//1
{ 

//#if -1833961787 
if(!item.equals(Model.getFacade().toString(
                                     Model.getFacade().getMultiplicity(target))))//1
{ 

//#if 622384242 
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

//#if -989173037 
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

