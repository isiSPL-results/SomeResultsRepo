
//#if 1148248600 
// Compilation Unit of /PropPanelInclude.java 
 

//#if -2082935349 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 644960068 
import javax.swing.JList;
//#endif 


//#if 912176445 
import org.argouml.model.Model;
//#endif 


//#if -612133567 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -961014358 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1328281328 
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
//#endif 


//#if -346370574 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 939291890 
public class PropPanelInclude extends 
//#if 150925365 
PropPanelRelationship
//#endif 

  { 

//#if -1427767742 
private static final long serialVersionUID = -8235207258195445477L;
//#endif 


//#if 1964727196 
public Object getBase()
    { 

//#if -140145509 
Object base   = null;
//#endif 


//#if 1745599628 
Object      target = getTarget();
//#endif 


//#if -897290846 
if(Model.getFacade().isAInclude(target))//1
{ 

//#if -1259926196 
base = Model.getFacade().getBase(target);
//#endif 

} 

//#endif 


//#if 939713382 
return base;
//#endif 

} 

//#endif 


//#if -575421639 
public void setBase(Object/*MUseCase*/ base)
    { 

//#if -1239230627 
Object target = getTarget();
//#endif 


//#if -1763518925 
if(Model.getFacade().isAInclude(target))//1
{ 

//#if 1032590317 
Model.getUseCasesHelper().setBase(target, base);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 548851189 
public PropPanelInclude()
    { 

//#if -93616938 
super("label.include", lookupIcon("Include"));
//#endif 


//#if 1017726140 
addField("label.name", getNameTextField());
//#endif 


//#if 646924052 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if -1707772453 
addSeparator();
//#endif 


//#if -823168690 
addField("label.usecase-base",
                 getSingleRowScroll(new UMLIncludeBaseListModel()));
//#endif 


//#if 1830049166 
addField("label.addition",
                 getSingleRowScroll(new UMLIncludeAdditionListModel()));
//#endif 


//#if 1082553843 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -2072930565 
addAction(new ActionNewStereotype());
//#endif 


//#if 955856830 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1882031847 
public void setAddition(Object/*MUseCase*/ addition)
    { 

//#if 636120642 
Object target = getTarget();
//#endif 


//#if 295329240 
if(Model.getFacade().isAInclude(target))//1
{ 

//#if 374893843 
Model.getUseCasesHelper().setAddition(target, addition);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2048812025 
public Object getAddition()
    { 

//#if -1395809410 
Object addition   = null;
//#endif 


//#if -2117658860 
Object target = getTarget();
//#endif 


//#if 878786090 
if(Model.getFacade().isAInclude(target))//1
{ 

//#if 1075118420 
addition = Model.getFacade().getAddition(target);
//#endif 

} 

//#endif 


//#if 1764346659 
return addition;
//#endif 

} 

//#endif 


//#if -718595733 
public boolean isAcceptableUseCase(Object/*MModelElement*/ modElem)
    { 

//#if 1774816965 
return Model.getFacade().isAUseCase(modElem);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

