
//#if 1423663097 
// Compilation Unit of /PropPanelElementResidence.java 
 

//#if 273898941 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -674051726 
import org.argouml.i18n.Translator;
//#endif 


//#if 1116085560 
import org.argouml.model.Model;
//#endif 


//#if 530350714 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 2043466220 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1945161928 
class ElementResidenceResidentListModel extends 
//#if -630151067 
UMLModelElementListModel2
//#endif 

  { 

//#if 1055050375 
protected boolean isValidElement(Object element)
    { 

//#if -218674716 
return Model.getFacade().isAElementResidence(getTarget());
//#endif 

} 

//#endif 


//#if 758573139 
protected void buildModelList()
    { 

//#if -2136503233 
if(getTarget() != null)//1
{ 

//#if 1736610333 
removeAllElements();
//#endif 


//#if 2037193389 
addElement(Model.getFacade().getResident(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 481756480 
public ElementResidenceResidentListModel()
    { 

//#if -1041839019 
super("resident");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -551794149 
public class PropPanelElementResidence extends 
//#if 844692620 
PropPanelModelElement
//#endif 

  { 

//#if -458097125 
public PropPanelElementResidence()
    { 

//#if -820796808 
super("label.element-residence", lookupIcon("ElementResidence"));
//#endif 


//#if -294668498 
add(getVisibilityPanel());
//#endif 


//#if -2116820578 
addSeparator();
//#endif 


//#if -521672729 
addField(Translator.localize("label.container"),
                 getSingleRowScroll(new ElementResidenceContainerListModel()));
//#endif 


//#if -809415995 
addField(Translator.localize("label.resident"),
                 getSingleRowScroll(new ElementResidenceResidentListModel()));
//#endif 


//#if 1637213100 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1683860927 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -608912435 
class ElementResidenceContainerListModel extends 
//#if 111805153 
UMLModelElementListModel2
//#endif 

  { 

//#if -184414461 
protected boolean isValidElement(Object element)
    { 

//#if -128461148 
return Model.getFacade().isAElementResidence(getTarget());
//#endif 

} 

//#endif 


//#if -1878612785 
protected void buildModelList()
    { 

//#if -414984483 
if(getTarget() != null)//1
{ 

//#if -282632624 
removeAllElements();
//#endif 


//#if 1480249163 
addElement(Model.getFacade().getContainer(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1918529429 
public ElementResidenceContainerListModel()
    { 

//#if -1809295138 
super("container");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

