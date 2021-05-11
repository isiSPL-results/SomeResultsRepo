package org.argouml.uml.ui;
import org.argouml.model.Model;
public class UMLModelElementElementResidenceListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getElementResidences(getTarget()));
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAElementResidence(o)
               && Model.getFacade().getElementResidences(getTarget()).contains(o);
} 
public UMLModelElementElementResidenceListModel()
    { 
super("elementResidence");
} 

 } 
