
//#if -1779059709 
// Compilation Unit of /ActionNewStereotype.java 
 

//#if 1136298244 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -1092415839 
import java.awt.event.ActionEvent;
//#endif 


//#if -298901033 
import java.util.Collection;
//#endif 


//#if -727102185 
import javax.swing.Action;
//#endif 


//#if -606163468 
import org.argouml.i18n.Translator;
//#endif 


//#if 1344926224 
import org.argouml.kernel.Project;
//#endif 


//#if 1417842393 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -777219398 
import org.argouml.model.Model;
//#endif 


//#if 565606504 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 727747037 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -545164623 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2079977458 
public class ActionNewStereotype extends 
//#if -574019312 
AbstractActionNewModelElement
//#endif 

  { 

//#if -1730111966 
public void actionPerformed(ActionEvent e)
    { 

//#if 246386115 
Object t = TargetManager.getInstance().getTarget();
//#endif 


//#if -1600382557 
if(t instanceof Fig)//1
{ 

//#if 1393713267 
t = ((Fig) t).getOwner();
//#endif 

} 

//#endif 


//#if 64353586 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -211950590 
Object model = p.getModel();
//#endif 


//#if 581900921 
Collection models = p.getModels();
//#endif 


//#if -298823116 
Object newStereo = Model.getExtensionMechanismsFactory()
                           .buildStereotype(
                               Model.getFacade().isAModelElement(t) ? t : null,
                               (String) null,
                               model,
                               models
                           );
//#endif 


//#if 1214966068 
if(Model.getFacade().isAModelElement(t))//1
{ 

//#if 2095120335 
Object ns = Model.getFacade().getNamespace(t);
//#endif 


//#if -1580456730 
if(Model.getFacade().isANamespace(ns))//1
{ 

//#if 636060191 
Model.getCoreHelper().setNamespace(newStereo, ns);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1706935699 
TargetManager.getInstance().setTarget(newStereo);
//#endif 


//#if 1209408594 
super.actionPerformed(e);
//#endif 

} 

//#endif 


//#if -775990615 
public ActionNewStereotype()
    { 

//#if -730838240 
super("button.new-stereotype");
//#endif 


//#if -207942658 
putValue(Action.NAME, Translator.localize("button.new-stereotype"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

