
//#if 477372668 
// Compilation Unit of /UMLCreateActionClassifierListModel.java 
 

//#if -1987018762 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 124330711 
import org.argouml.model.Model;
//#endif 


//#if -629287507 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -364387531 
public class UMLCreateActionClassifierListModel extends 
//#if 1624723529 
UMLModelElementListModel2
//#endif 

  { 

//#if 1641655580 
private static final long serialVersionUID = -3653652920890159417L;
//#endif 


//#if 769087356 
protected boolean isValidElement(Object elem)
    { 

//#if -1880320830 
return Model.getFacade().isAClassifier(elem)
               && Model.getCommonBehaviorHelper()
               .getInstantiation(getTarget()) == elem;
//#endif 

} 

//#endif 


//#if 1316945463 
protected void buildModelList()
    { 

//#if -1589895827 
removeAllElements();
//#endif 


//#if 1474119149 
addElement(Model.getCommonBehaviorHelper()
                   .getInstantiation(getTarget()));
//#endif 

} 

//#endif 


//#if 282328627 
public UMLCreateActionClassifierListModel()
    { 

//#if 1236135032 
super("instantiation");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

