
//#if -973032551 
// Compilation Unit of /PropPanelSubsystem.java 
 

//#if 1805348379 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -823607752 
import java.awt.event.ActionEvent;
//#endif 


//#if 518489006 
import javax.swing.Action;
//#endif 


//#if -717002486 
import javax.swing.JList;
//#endif 


//#if -1340163341 
import javax.swing.JScrollPane;
//#endif 


//#if -863047363 
import org.argouml.i18n.Translator;
//#endif 


//#if 1613734311 
import org.argouml.kernel.Project;
//#endif 


//#if 1482389346 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1703666307 
import org.argouml.model.Model;
//#endif 


//#if 984619519 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -458596812 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 253916964 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -439158087 
import org.argouml.uml.ui.foundation.core.UMLClassifierFeatureListModel;
//#endif 


//#if 1665648691 
public class PropPanelSubsystem extends 
//#if 194908093 
PropPanelPackage
//#endif 

  { 

//#if 1577237388 
private JScrollPane featureScroll;
//#endif 


//#if -70289895 
private static UMLClassifierFeatureListModel featureListModel =
        new UMLClassifierFeatureListModel();
//#endif 


//#if 142812616 
private static final long serialVersionUID = -8616239241648089917L;
//#endif 


//#if -763571796 
public JScrollPane getFeatureScroll()
    { 

//#if 203899166 
if(featureScroll == null)//1
{ 

//#if -1742427510 
JList list = new UMLLinkedList(featureListModel);
//#endif 


//#if 1769358972 
featureScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 425100543 
return featureScroll;
//#endif 

} 

//#endif 


//#if -312428656 
public PropPanelSubsystem()
    { 

//#if -971639569 
super("label.subsystem", lookupIcon("Subsystem"));
//#endif 


//#if -623820704 
addField(Translator.localize("label.available-features"),
                 getFeatureScroll());
//#endif 


//#if 710302781 
addAction(new ActionNewOperation());
//#endif 

} 

//#endif 


//#if 1882938044 
private static class ActionNewOperation extends 
//#if 100875720 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1017443547 
private static final String ACTION_KEY = "button.new-operation";
//#endif 


//#if 178406630 
private static final long serialVersionUID = -5149342278246959597L;
//#endif 


//#if 828986612 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 447258308 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 942136370 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if 1127587449 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 89938240 
Object returnType = p.getDefaultReturnType();
//#endif 


//#if -400531872 
Object newOper =
                    Model.getCoreFactory()
                    .buildOperation(target, returnType);
//#endif 


//#if -1998141942 
TargetManager.getInstance().setTarget(newOper);
//#endif 


//#if -2081119847 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2091358918 
public ActionNewOperation()
        { 

//#if -366669186 
super(ACTION_KEY);
//#endif 


//#if 1901788596 
putValue(Action.NAME, Translator.localize(ACTION_KEY));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

