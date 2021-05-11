package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLModelElementElementResidenceListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAElementResidence(o)
               && Model.getFacade().getElementResidences(getTarget()).contains(o);
} 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getElementResidences(getTarget()));
} 
public UMLModelElementElementResidenceListModel()
    { 
super("elementResidence");
} 

 } 
