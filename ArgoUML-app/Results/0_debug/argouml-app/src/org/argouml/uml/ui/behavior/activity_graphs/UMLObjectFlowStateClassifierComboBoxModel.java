
//#if -435193407 
// Compilation Unit of /UMLObjectFlowStateClassifierComboBoxModel.java 
 

//#if -1114785364 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 223202911 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1318935042 
import java.util.ArrayList;
//#endif 


//#if -723088481 
import java.util.Collection;
//#endif 


//#if -1138537967 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1951697934 
import org.argouml.model.Model;
//#endif 


//#if -1792424475 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -1730548634 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1609953179 
public class UMLObjectFlowStateClassifierComboBoxModel extends 
//#if 1677065571 
UMLComboBoxModel2
//#endif 

  { 

//#if -419143194 
protected boolean isValidElement(Object o)
    { 

//#if 1923707159 
return Model.getFacade().isAClassifier(o);
//#endif 

} 

//#endif 


//#if -1410981979 
public void modelChanged(UmlChangeEvent evt)
    { 

//#if 1778270473 
buildingModel = true;
//#endif 


//#if 1882307269 
buildModelList();
//#endif 


//#if -1124951460 
buildingModel = false;
//#endif 


//#if -1726453629 
setSelectedItem(getSelectedModelElement());
//#endif 

} 

//#endif 


//#if 1981120188 
public UMLObjectFlowStateClassifierComboBoxModel()
    { 

//#if -657789433 
super("type", false);
//#endif 

} 

//#endif 


//#if -1771231601 
protected Object getSelectedModelElement()
    { 

//#if 1916447918 
if(getTarget() != null)//1
{ 

//#if -1829047613 
return Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if 1605114302 
return null;
//#endif 

} 

//#endif 


//#if -1465324091 
protected void buildModelList()
    { 

//#if 2104152548 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if -808832839 
Collection newList =
            new ArrayList(Model.getCoreHelper().getAllClassifiers(model));
//#endif 


//#if -42328699 
if(getTarget() != null)//1
{ 

//#if -5913978 
Object type = Model.getFacade().getType(getTarget());
//#endif 


//#if 1662239142 
if(type != null)//1

//#if 902570380 
if(!newList.contains(type))//1
{ 

//#if -1361093035 
newList.add(type);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 636291204 
setElements(newList);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

