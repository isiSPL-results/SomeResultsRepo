
//#if -600309030 
// Compilation Unit of /UMLTransitionSourceListModel.java 
 

//#if -1215006468 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1608584339 
import org.argouml.model.Model;
//#endif 


//#if -1015637647 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 136815516 
public class UMLTransitionSourceListModel extends 
//#if 287787996 
UMLModelElementListModel2
//#endif 

  { 

//#if -1422793629 
public UMLTransitionSourceListModel()
    { 

//#if 805037178 
super("source");
//#endif 

} 

//#endif 


//#if 410056778 
protected void buildModelList()
    { 

//#if -1642964614 
removeAllElements();
//#endif 


//#if 2110095685 
addElement(Model.getFacade().getSource(getTarget()));
//#endif 

} 

//#endif 


//#if 1040452734 
protected boolean isValidElement(Object element)
    { 

//#if -92177841 
return element == Model.getFacade().getSource(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

