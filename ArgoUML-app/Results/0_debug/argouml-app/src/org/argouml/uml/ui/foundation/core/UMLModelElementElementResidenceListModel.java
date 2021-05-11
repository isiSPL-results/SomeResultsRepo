
//#if -863163571 
// Compilation Unit of /UMLModelElementElementResidenceListModel.java 
 

//#if 747715495 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 830605858 
import org.argouml.model.Model;
//#endif 


//#if -2080834750 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 680185664 
public class UMLModelElementElementResidenceListModel extends 
//#if 82459066 
UMLModelElementListModel2
//#endif 

  { 

//#if -864085111 
protected boolean isValidElement(Object o)
    { 

//#if 1101650092 
return Model.getFacade().isAElementResidence(o)
               && Model.getFacade().getElementResidences(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 1932379944 
protected void buildModelList()
    { 

//#if -2115695291 
setAllElements(Model.getFacade().getElementResidences(getTarget()));
//#endif 

} 

//#endif 


//#if -1602231080 
public UMLModelElementElementResidenceListModel()
    { 

//#if 1419504326 
super("elementResidence");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

