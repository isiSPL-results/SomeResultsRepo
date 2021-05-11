
//#if -1147689654 
// Compilation Unit of /UMLAssociationEndRoleBaseListModel.java 
 

//#if -1031462660 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -2131593753 
import org.argouml.model.Model;
//#endif 


//#if -1536029539 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 572629207 
public class UMLAssociationEndRoleBaseListModel extends 
//#if 1316234818 
UMLModelElementListModel2
//#endif 

  { 

//#if -715247696 
protected void buildModelList()
    { 

//#if 1978580888 
removeAllElements();
//#endif 


//#if -1136218687 
if(getTarget() != null
                && Model.getFacade().getBase(getTarget()) != null)//1
{ 

//#if -765206241 
addElement(Model.getFacade().getBase(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1961072756 
public UMLAssociationEndRoleBaseListModel()
    { 

//#if 2136176930 
super("base");
//#endif 

} 

//#endif 


//#if 1049952161 
protected boolean isValidElement(Object base)
    { 

//#if -1331627632 
if(!Model.getFacade().isAAssociationEnd(base))//1
{ 

//#if -390556191 
return false;
//#endif 

} 

//#endif 


//#if -1340854828 
Object assocEndRole = getTarget();
//#endif 


//#if 1712965911 
Object assocRole =
            Model.getFacade().getAssociation(assocEndRole);
//#endif 


//#if -1541557392 
return Model.getFacade().getConnections(
                   Model.getFacade().getBase(assocRole))
               .contains(base);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

