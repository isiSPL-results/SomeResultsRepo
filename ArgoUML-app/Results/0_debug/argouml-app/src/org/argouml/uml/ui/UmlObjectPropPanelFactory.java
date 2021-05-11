
//#if 434470479 
// Compilation Unit of /UmlObjectPropPanelFactory.java 
 

//#if 1807766184 
package org.argouml.uml.ui;
//#endif 


//#if -493849065 
import org.argouml.model.Model;
//#endif 


//#if -676659996 
import org.argouml.uml.ui.foundation.core.PropPanelElementResidence;
//#endif 


//#if -2141466618 
import org.argouml.uml.ui.model_management.PropPanelElementImport;
//#endif 


//#if -661705630 
class UmlObjectPropPanelFactory implements 
//#if 2074055108 
PropPanelFactory
//#endif 

  { 

//#if -2124933144 
private PropPanel getMultiplicityPropPanel(Object object)
    { 

//#if 2001841386 
return null;
//#endif 

} 

//#endif 


//#if -2036992981 
public PropPanel createPropPanel(Object object)
    { 

//#if -1855704041 
if(Model.getFacade().isAExpression(object))//1
{ 

//#if 1296421363 
return getExpressionPropPanel(object);
//#endif 

} 

//#endif 


//#if 1794282302 
if(Model.getFacade().isAMultiplicity(object))//1
{ 

//#if -495766981 
return getMultiplicityPropPanel(object);
//#endif 

} 

//#endif 


//#if -918849802 
if(Model.getFacade().isAElementImport(object))//1
{ 

//#if -529665732 
return new PropPanelElementImport();
//#endif 

} 

//#endif 


//#if -1481745879 
if(Model.getFacade().isAElementResidence(object))//1
{ 

//#if 1066228719 
return new PropPanelElementResidence();
//#endif 

} 

//#endif 


//#if 321299033 
return null;
//#endif 

} 

//#endif 


//#if -510809233 
private PropPanel getExpressionPropPanel(Object object)
    { 

//#if -1911513306 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

