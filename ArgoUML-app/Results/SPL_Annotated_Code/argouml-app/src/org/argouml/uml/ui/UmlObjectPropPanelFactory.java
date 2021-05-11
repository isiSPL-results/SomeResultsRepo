// Compilation Unit of /UmlObjectPropPanelFactory.java 
 
package org.argouml.uml.ui;
import org.argouml.model.Model;
import org.argouml.uml.ui.foundation.core.PropPanelElementResidence;
import org.argouml.uml.ui.model_management.PropPanelElementImport;
class UmlObjectPropPanelFactory implements PropPanelFactory
  { 
private PropPanel getMultiplicityPropPanel(Object object)
    { 
return null;
} 

public PropPanel createPropPanel(Object object)
    { 
if(Model.getFacade().isAExpression(object))//1
{ 
return getExpressionPropPanel(object);
} 

if(Model.getFacade().isAMultiplicity(object))//1
{ 
return getMultiplicityPropPanel(object);
} 

if(Model.getFacade().isAElementImport(object))//1
{ 
return new PropPanelElementImport();
} 

if(Model.getFacade().isAElementResidence(object))//1
{ 
return new PropPanelElementResidence();
} 

return null;
} 

private PropPanel getExpressionPropPanel(Object object)
    { 
return null;
} 

 } 


