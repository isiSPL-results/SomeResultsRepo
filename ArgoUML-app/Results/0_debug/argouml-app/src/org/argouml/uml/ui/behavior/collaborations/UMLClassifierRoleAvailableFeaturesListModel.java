
//#if 1241207089 
// Compilation Unit of /UMLClassifierRoleAvailableFeaturesListModel.java 
 

//#if 860080420 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -2103519838 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -560448862 
import java.util.Collection;
//#endif 


//#if -1821322705 
import java.util.Enumeration;
//#endif 


//#if -331634670 
import java.util.Iterator;
//#endif 


//#if -2027334850 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -1477918193 
import org.argouml.model.Model;
//#endif 


//#if -571399583 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1267231093 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2066252538 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1463370295 
public class UMLClassifierRoleAvailableFeaturesListModel extends 
//#if 472286028 
UMLModelElementListModel2
//#endif 

  { 

//#if -1725499462 
protected void buildModelList()
    { 

//#if 518149376 
setAllElements(Model.getCollaborationsHelper()
                       .allAvailableFeatures(getTarget()));
//#endif 

} 

//#endif 


//#if 353400550 
public UMLClassifierRoleAvailableFeaturesListModel()
    { 

//#if 1398112386 
super();
//#endif 

} 

//#endif 


//#if 858598382 
protected boolean isValidElement(Object element)
    { 

//#if 710492523 
return false;
//#endif 

} 

//#endif 


//#if -2142409819 
public void setTarget(Object target)
    { 

//#if -1774094742 
if(getTarget() != null)//1
{ 

//#if -1538148076 
Enumeration enumeration = elements();
//#endif 


//#if 1882831907 
while (enumeration.hasMoreElements()) //1
{ 

//#if -1197601100 
Object base = enumeration.nextElement();
//#endif 


//#if -2043610599 
Model.getPump().removeModelEventListener(
                    this,
                    base,
                    "feature");
//#endif 

} 

//#endif 


//#if -1710969578 
Model.getPump().removeModelEventListener(
                this,
                getTarget(),
                "base");
//#endif 

} 

//#endif 


//#if 1241865035 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if 932998760 
if(!Model.getFacade().isAModelElement(target))//1
{ 

//#if 136049310 
return;
//#endif 

} 

//#endif 


//#if -88710372 
setListTarget(target);
//#endif 


//#if 1811162119 
if(getTarget() != null)//2
{ 

//#if -365508241 
Collection bases = Model.getFacade().getBases(getTarget());
//#endif 


//#if -1353832974 
Iterator it = bases.iterator();
//#endif 


//#if 815116704 
while (it.hasNext()) //1
{ 

//#if -221828396 
Object base = it.next();
//#endif 


//#if -1325202016 
Model.getPump().addModelEventListener(
                    this,
                    base,
                    "feature");
//#endif 

} 

//#endif 


//#if 1142761927 
Model.getPump().addModelEventListener(
                this,
                getTarget(),
                "base");
//#endif 


//#if -406840100 
removeAllElements();
//#endif 


//#if 1091247647 
setBuildingModel(true);
//#endif 


//#if -920753333 
buildModelList();
//#endif 


//#if -565743978 
setBuildingModel(false);
//#endif 


//#if 184713725 
if(getSize() > 0)//1
{ 

//#if -18729519 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 101101141 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if 587985331 
if(e instanceof AddAssociationEvent)//1
{ 

//#if 241201199 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 

//#if -182493939 
Object clazz = getChangedElement(e);
//#endif 


//#if 2147016902 
addAll(Model.getFacade().getFeatures(clazz));
//#endif 


//#if -1526047376 
Model.getPump().addModelEventListener(
                    this,
                    clazz,
                    "feature");
//#endif 

} 
else

//#if -1746327624 
if(e.getPropertyName().equals("feature")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 

//#if -598333278 
addElement(getChangedElement(e));
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 1834158010 
if(e instanceof RemoveAssociationEvent)//1
{ 

//#if 1657731062 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 

//#if 6337478 
Object clazz = getChangedElement(e);
//#endif 


//#if -551544058 
Model.getPump().removeModelEventListener(
                    this,
                    clazz,
                    "feature");
//#endif 

} 
else

//#if 291659399 
if(e.getPropertyName().equals("feature")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 

//#if -1434144936 
removeElement(getChangedElement(e));
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if -1663634067 
super.propertyChange(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

