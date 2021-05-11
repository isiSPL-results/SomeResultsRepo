// Compilation Unit of /ActionAddContextSignal.java 
 
package org.argouml.uml.ui.behavior.common_behavior;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddContextSignal extends AbstractActionAddModelElement2
  { 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-contexts");
} 

public ActionAddContextSignal()
    { 
super();
} 

protected List getChoices()
    { 
List ret = new ArrayList();
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
if(getTarget() != null)//1
{ 
ret.addAll(Model.getModelManagementHelper()
                       .getAllBehavioralFeatures(model));
} 

return ret;
} 

protected List getSelected()
    { 
List ret = new ArrayList();
ret.addAll(Model.getFacade().getContexts(getTarget()));
return ret;
} 

protected void doIt(Collection selected)
    { 
Model.getCommonBehaviorHelper().setContexts(getTarget(), selected);
} 

 } 


