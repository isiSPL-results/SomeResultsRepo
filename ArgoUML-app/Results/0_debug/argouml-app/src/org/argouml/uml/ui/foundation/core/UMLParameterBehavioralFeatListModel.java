
//#if 523673099 
// Compilation Unit of /UMLParameterBehavioralFeatListModel.java 
 

//#if -848956654 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -277460467 
import org.argouml.model.Model;
//#endif 


//#if 741633079 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2018777300 
public class UMLParameterBehavioralFeatListModel extends 
//#if -1981620192 
UMLModelElementListModel2
//#endif 

  { 

//#if 1405720431 
protected boolean isValidElement(Object o)
    { 

//#if 1665468872 
return Model.getFacade().getBehavioralFeature(getTarget()) == o;
//#endif 

} 

//#endif 


//#if -1615557647 
public UMLParameterBehavioralFeatListModel()
    { 

//#if 2006051616 
super("behavioralFeature");
//#endif 

} 

//#endif 


//#if -452932978 
protected void buildModelList()
    { 

//#if 570470126 
if(getTarget() != null)//1
{ 

//#if -1210593006 
removeAllElements();
//#endif 


//#if 1195962709 
addElement(Model.getFacade().getBehavioralFeature(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

