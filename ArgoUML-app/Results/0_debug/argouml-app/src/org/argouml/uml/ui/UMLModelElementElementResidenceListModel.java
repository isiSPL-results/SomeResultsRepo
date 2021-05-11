
//#if -119803727 
// Compilation Unit of /UMLModelElementElementResidenceListModel.java 
 

//#if -2031349865 
package org.argouml.uml.ui;
//#endif 


//#if -693755002 
import org.argouml.model.Model;
//#endif 


//#if 2103262300 
public class UMLModelElementElementResidenceListModel extends 
//#if -111889209 
UMLModelElementListModel2
//#endif 

  { 

//#if -392563787 
protected void buildModelList()
    { 

//#if -1696139474 
setAllElements(Model.getFacade().getElementResidences(getTarget()));
//#endif 

} 

//#endif 


//#if -1147487274 
protected boolean isValidElement(Object o)
    { 

//#if -798664300 
return Model.getFacade().isAElementResidence(o)
               && Model.getFacade().getElementResidences(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if -527480021 
public UMLModelElementElementResidenceListModel()
    { 

//#if -778180010 
super("elementResidence");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

