// Compilation Unit of /ActionNewDiagram.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.explorer.ExplorerEventAdaptor;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.tigris.gef.undo.UndoableAction;
public abstract class ActionNewDiagram extends UndoableAction
  { 
private static final Logger LOG =
        Logger.getLogger(ActionNewDiagram.class);
protected Object findNamespace()
    { 
Project p = ProjectManager.getManager().getCurrentProject();
return p.getRoot();
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Project p = ProjectManager.getManager().getCurrentProject();
Object ns = findNamespace();
if(ns != null && isValidNamespace(ns))//1
{ 
ArgoDiagram diagram = createDiagram(ns);
assert (diagram != null)
            : "No diagram was returned by the concrete class";
p.addMember(diagram);
ExplorerEventAdaptor.getInstance().modelElementAdded(
                diagram.getNamespace());
TargetManager.getInstance().setTarget(diagram);
} 
else
{ 
LOG.error("No valid namespace found");
throw new IllegalStateException("No valid namespace found");
} 

} 

protected abstract ArgoDiagram createDiagram(Object namespace);
public boolean isValidNamespace(Object ns)
    { 
return true;
} 

protected static Object createCollaboration(Object namespace)
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAUMLElement(target)
                && Model.getModelManagementHelper().isReadOnly(target))//1
{ 
target = namespace;
} 

Object collaboration = null;
if(Model.getFacade().isAOperation(target))//1
{ 
Object ns = Model.getFacade().getNamespace(
                            Model.getFacade().getOwner(target));
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(ns, target);
} 
else
if(Model.getFacade().isAClassifier(target))//1
{ 
Object ns = Model.getFacade().getNamespace(target);
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(ns, target);
} 
else
{ 
collaboration =
                Model.getCollaborationsFactory().createCollaboration();
if(Model.getFacade().isANamespace(target))//1
{ 
namespace = target;
} 
else
{ 
if(Model.getFacade().isAModelElement(target))//1
{ 
Object ns = Model.getFacade().getNamespace(target);
if(Model.getFacade().isANamespace(ns))//1
{ 
namespace = ns;
} 

} 

} 

Model.getCoreHelper().setNamespace(collaboration, namespace);
Model.getCoreHelper().setName(collaboration,
                                          "unattachedCollaboration");
} 


return collaboration;
} 

protected ActionNewDiagram(String name)
    { 
super(Translator.localize(name),
              ResourceLoaderWrapper.lookupIcon(name));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
} 

 } 


