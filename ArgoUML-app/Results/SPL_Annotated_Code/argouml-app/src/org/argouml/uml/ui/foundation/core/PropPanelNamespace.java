// Compilation Unit of /PropPanelNamespace.java 
 
package org.argouml.uml.ui.foundation.core;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.ScrollList;
public abstract class PropPanelNamespace extends PropPanelModelElement
  { 
private JScrollPane ownedElementsScroll;
private static UMLNamespaceOwnedElementListModel ownedElementListModel =
        new UMLNamespaceOwnedElementListModel();
public void addClass()
    { 
Object target = getTarget();
if(Model.getFacade().isANamespace(target))//1
{ 
Object ns = target;
Object ownedElem = Model.getCoreFactory().buildClass();
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
TargetManager.getInstance().setTarget(ownedElem);
} 

} 

public void addPackage()
    { 
Object target = getTarget();
if(Model.getFacade().isANamespace(target))//1
{ 
Object ns = target;
Object ownedElem = Model.getModelManagementFactory()
                               .createPackage();
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
TargetManager.getInstance().setTarget(ownedElem);
} 

} 

public PropPanelNamespace(String panelName, ImageIcon icon)
    { 
super(panelName, icon);
} 

public JScrollPane getOwnedElementsScroll()
    { 
if(ownedElementsScroll == null)//1
{ 
ownedElementsScroll =
                new ScrollList(ownedElementListModel, true, false);
} 

return ownedElementsScroll;
} 

public void addInterface()
    { 
Object target = getTarget();
if(Model.getFacade().isANamespace(target))//1
{ 
Object ns = target;
Object ownedElem = Model.getCoreFactory().createInterface();
Model.getCoreHelper().addOwnedElement(ns, ownedElem);
TargetManager.getInstance().setTarget(ownedElem);
} 

} 

 } 


