// Compilation Unit of /ActionSetStructuralFeatureMultiplicity.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionSetMultiplicity;
public class ActionSetStructuralFeatureMultiplicity extends ActionSetMultiplicity
  { 
private static final ActionSetStructuralFeatureMultiplicity SINGLETON =
        new ActionSetStructuralFeatureMultiplicity();
protected ActionSetStructuralFeatureMultiplicity()
    { 
super();
} 

public static ActionSetStructuralFeatureMultiplicity getInstance()
    { 
return SINGLETON;
} 

public void setSelectedItem(Object item, Object target)
    { 
if(target != null
                && Model.getFacade().isAStructuralFeature(target))//1
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


