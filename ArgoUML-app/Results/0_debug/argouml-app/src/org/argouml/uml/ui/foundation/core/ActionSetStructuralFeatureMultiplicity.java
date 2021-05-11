
//#if 182520188 
// Compilation Unit of /ActionSetStructuralFeatureMultiplicity.java 
 

//#if -1433884889 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1298221662 
import org.argouml.model.Model;
//#endif 


//#if -1211165115 
import org.argouml.uml.ui.ActionSetMultiplicity;
//#endif 


//#if 289911218 
public class ActionSetStructuralFeatureMultiplicity extends 
//#if -154742760 
ActionSetMultiplicity
//#endif 

  { 

//#if -850025692 
private static final ActionSetStructuralFeatureMultiplicity SINGLETON =
        new ActionSetStructuralFeatureMultiplicity();
//#endif 


//#if -126846680 
protected ActionSetStructuralFeatureMultiplicity()
    { 

//#if 1154360657 
super();
//#endif 

} 

//#endif 


//#if 1280259510 
public static ActionSetStructuralFeatureMultiplicity getInstance()
    { 

//#if 1886662940 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1450423577 
public void setSelectedItem(Object item, Object target)
    { 

//#if -205806272 
if(target != null
                && Model.getFacade().isAStructuralFeature(target))//1
{ 

//#if 284487107 
if(Model.getFacade().isAMultiplicity(item))//1
{ 

//#if 1274853648 
if(!item.equals(Model.getFacade().getMultiplicity(target)))//1
{ 

//#if -2083244975 
Model.getCoreHelper().setMultiplicity(target, item);
//#endif 

} 

//#endif 

} 
else

//#if -383194704 
if(item instanceof String)//1
{ 

//#if 1926253594 
if(!item.equals(Model.getFacade().toString(
                                     Model.getFacade().getMultiplicity(target))))//1
{ 

//#if 200266625 
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

//#if -2090506940 
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

