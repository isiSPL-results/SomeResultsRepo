
//#if -2091287928 
// Compilation Unit of /PropPanelNamespace.java 
 

//#if -1980077361 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1256629061 
import javax.swing.ImageIcon;
//#endif 


//#if -1280471622 
import javax.swing.JScrollPane;
//#endif 


//#if 1763358026 
import org.argouml.model.Model;
//#endif 


//#if 285846488 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1522233027 
import org.argouml.uml.ui.ScrollList;
//#endif 


//#if -1382115050 
public abstract class PropPanelNamespace extends 
//#if -1831174219 
PropPanelModelElement
//#endif 

  { 

//#if -2026859027 
private JScrollPane ownedElementsScroll;
//#endif 


//#if 529464777 
private static UMLNamespaceOwnedElementListModel ownedElementListModel =
        new UMLNamespaceOwnedElementListModel();
//#endif 


//#if 989777524 
public void addClass()
    { 

//#if -1069278281 
Object target = getTarget();
//#endif 


//#if -885021440 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if -1394296774 
Object ns = target;
//#endif 


//#if -140978706 
Object ownedElem = Model.getCoreFactory().buildClass();
//#endif 


//#if 2085769895 
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
//#endif 


//#if 1628919508 
TargetManager.getInstance().setTarget(ownedElem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -493401342 
public void addPackage()
    { 

//#if 1570741723 
Object target = getTarget();
//#endif 


//#if -1622627036 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if -965535658 
Object ns = target;
//#endif 


//#if 2117591099 
Object ownedElem = Model.getModelManagementFactory()
                               .createPackage();
//#endif 


//#if 2089538755 
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
//#endif 


//#if -900830664 
TargetManager.getInstance().setTarget(ownedElem);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1877973168 
public PropPanelNamespace(String panelName, ImageIcon icon)
    { 

//#if -158259140 
super(panelName, icon);
//#endif 

} 

//#endif 


//#if -647031765 
public JScrollPane getOwnedElementsScroll()
    { 

//#if 56694968 
if(ownedElementsScroll == null)//1
{ 

//#if 1414462281 
ownedElementsScroll =
                new ScrollList(ownedElementListModel, true, false);
//#endif 

} 

//#endif 


//#if 1885672717 
return ownedElementsScroll;
//#endif 

} 

//#endif 


//#if -634965899 
public void addInterface()
    { 

//#if -1364171878 
Object target = getTarget();
//#endif 


//#if -479978141 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if -2049714651 
Object ns = target;
//#endif 


//#if -1794024108 
Object ownedElem = Model.getCoreFactory().createInterface();
//#endif 


//#if -674883822 
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
//#endif 


//#if 1466491465 
TargetManager.getInstance().setTarget(ownedElem);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

