
//#if -624941712 
// Compilation Unit of /UMLClassifierRoleAvailableContentsListModel.java 
 

//#if -1997066629 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if -163672341 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1398256853 
import java.util.Collection;
//#endif 


//#if -2023566650 
import java.util.Enumeration;
//#endif 


//#if 1995982555 
import java.util.Iterator;
//#endif 


//#if -347257387 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 1734146278 
import org.argouml.model.Model;
//#endif 


//#if 1362400362 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1404981506 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -870930665 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -2060522275 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1338316241 
public class UMLClassifierRoleAvailableContentsListModel extends 
//#if -599162992 
UMLModelElementListModel2
//#endif 

  { 

//#if 2023448114 
protected boolean isValidElement(Object element)
    { 

//#if -794440418 
return false;
//#endif 

} 

//#endif 


//#if 1183609645 
public UMLClassifierRoleAvailableContentsListModel()
    { 

//#if 1924205915 
super();
//#endif 

} 

//#endif 


//#if 1529491966 
protected void buildModelList()
    { 

//#if 1913807079 
setAllElements(
            Model.getCollaborationsHelper().allAvailableContents(getTarget()));
//#endif 

} 

//#endif 


//#if -292136774 
public void setTarget(Object theNewTarget)
    { 

//#if 358368325 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
//#endif 


//#if 2036235177 
if(Model.getFacade().isAModelElement(theNewTarget)
                || theNewTarget instanceof Diagram)//1
{ 

//#if -2144274201 
if(getTarget() != null)//1
{ 

//#if 1390640213 
Enumeration enumeration = elements();
//#endif 


//#if 1681185154 
while (enumeration.hasMoreElements()) //1
{ 

//#if -1759436482 
Object base = enumeration.nextElement();
//#endif 


//#if -1859049780 
Model.getPump().removeModelEventListener(
                        this,
                        base,
                        "ownedElement");
//#endif 

} 

//#endif 


//#if 210840663 
Model.getPump().removeModelEventListener(
                    this,
                    getTarget(),
                    "base");
//#endif 

} 

//#endif 


//#if 1593384168 
setListTarget(theNewTarget);
//#endif 


//#if -1024052118 
if(getTarget() != null)//2
{ 

//#if 72242971 
Collection bases = Model.getFacade().getBases(getTarget());
//#endif 


//#if -1992774242 
Iterator it = bases.iterator();
//#endif 


//#if 1346005580 
while (it.hasNext()) //1
{ 

//#if -908667703 
Object base =  it.next();
//#endif 


//#if 500842886 
Model.getPump().addModelEventListener(
                        this,
                        base,
                        "ownedElement");
//#endif 

} 

//#endif 


//#if -1020845413 
Model.getPump().addModelEventListener(
                    this,
                    getTarget(),
                    "base");
//#endif 

} 

//#endif 


//#if -1024022326 
if(getTarget() != null)//3
{ 

//#if -1058686216 
removeAllElements();
//#endif 


//#if -509248893 
setBuildingModel(true);
//#endif 


//#if 306111151 
buildModelList();
//#endif 


//#if 1358470834 
setBuildingModel(false);
//#endif 


//#if -437192935 
if(getSize() > 0)//1
{ 

//#if -2073003066 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1851704465 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if 1626434505 
if(e instanceof AddAssociationEvent)//1
{ 

//#if -1278606725 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 

//#if -355005950 
Object clazz = getChangedElement(e);
//#endif 


//#if 1838252770 
addAll(Model.getFacade().getOwnedElements(clazz));
//#endif 


//#if -1763813952 
Model.getPump().addModelEventListener(
                    this,
                    clazz,
                    "ownedElement");
//#endif 

} 
else

//#if -1859985047 
if(e.getPropertyName().equals("ownedElement")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 

//#if -1597230736 
addElement(getChangedElement(e));
//#endif 

} 

//#endif 


//#endif 

} 
else

//#if 1569287257 
if(e instanceof RemoveAssociationEvent)//1
{ 

//#if 700801718 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 

//#if -1302681749 
Object clazz = getChangedElement(e);
//#endif 


//#if -1661497552 
Model.getPump().removeModelEventListener(
                    this,
                    clazz,
                    "ownedElement");
//#endif 

} 
else

//#if -1654339848 
if(e.getPropertyName().equals("ownedElement")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 

//#if 353167750 
removeElement(getChangedElement(e));
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if 854895992 
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

