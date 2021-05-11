
//#if -1813385968 
// Compilation Unit of /ActionNewDiagram.java 
 

//#if -131381717 
package org.argouml.uml.ui;
//#endif 


//#if -1264437951 
import java.awt.event.ActionEvent;
//#endif 


//#if -1060564041 
import javax.swing.Action;
//#endif 


//#if 593544359 
import org.apache.log4j.Logger;
//#endif 


//#if 90875155 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1643881644 
import org.argouml.i18n.Translator;
//#endif 


//#if 1172904112 
import org.argouml.kernel.Project;
//#endif 


//#if -1823951815 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1853886438 
import org.argouml.model.Model;
//#endif 


//#if -528323175 
import org.argouml.ui.explorer.ExplorerEventAdaptor;
//#endif 


//#if 1519673096 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1556038951 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1603687721 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2143757515 
public abstract class ActionNewDiagram extends 
//#if 264294591 
UndoableAction
//#endif 

  { 

//#if -527151988 
private static final Logger LOG =
        Logger.getLogger(ActionNewDiagram.class);
//#endif 


//#if -589289855 
protected Object findNamespace()
    { 

//#if 1366008542 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1721183528 
return p.getRoot();
//#endif 

} 

//#endif 


//#if 6569100 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -945402918 
super.actionPerformed(e);
//#endif 


//#if -1182399302 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -259746747 
Object ns = findNamespace();
//#endif 


//#if -768779820 
if(ns != null && isValidNamespace(ns))//1
{ 

//#if -700478004 
ArgoDiagram diagram = createDiagram(ns);
//#endif 


//#if -1174101931 
assert (diagram != null)
            : "No diagram was returned by the concrete class";
//#endif 


//#if 1998537178 
p.addMember(diagram);
//#endif 


//#if -489080684 
ExplorerEventAdaptor.getInstance().modelElementAdded(
                diagram.getNamespace());
//#endif 


//#if 1259504380 
TargetManager.getInstance().setTarget(diagram);
//#endif 

} 
else
{ 

//#if 433379951 
LOG.error("No valid namespace found");
//#endif 


//#if 2040717099 
throw new IllegalStateException("No valid namespace found");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1925040115 
protected abstract ArgoDiagram createDiagram(Object namespace);
//#endif 


//#if 2105126938 
public boolean isValidNamespace(Object ns)
    { 

//#if 667299924 
return true;
//#endif 

} 

//#endif 


//#if -1900279172 
protected static Object createCollaboration(Object namespace)
    { 

//#if 1106014500 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1718361161 
if(Model.getFacade().isAUMLElement(target)
                && Model.getModelManagementHelper().isReadOnly(target))//1
{ 

//#if 1880993826 
target = namespace;
//#endif 

} 

//#endif 


//#if 1889329518 
Object collaboration = null;
//#endif 


//#if -2121183226 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -438732409 
Object ns = Model.getFacade().getNamespace(
                            Model.getFacade().getOwner(target));
//#endif 


//#if 1666528741 
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(ns, target);
//#endif 

} 
else

//#if -1758256616 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if -1809159705 
Object ns = Model.getFacade().getNamespace(target);
//#endif 


//#if 1483049031 
collaboration =
                Model.getCollaborationsFactory().buildCollaboration(ns, target);
//#endif 

} 
else
{ 

//#if 514016960 
collaboration =
                Model.getCollaborationsFactory().createCollaboration();
//#endif 


//#if -57405810 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 1785458301 
namespace = target;
//#endif 

} 
else
{ 

//#if 1587473167 
if(Model.getFacade().isAModelElement(target))//1
{ 

//#if -321066083 
Object ns = Model.getFacade().getNamespace(target);
//#endif 


//#if 1689041827 
if(Model.getFacade().isANamespace(ns))//1
{ 

//#if -1633833019 
namespace = ns;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 301348609 
Model.getCoreHelper().setNamespace(collaboration, namespace);
//#endif 


//#if -2107933822 
Model.getCoreHelper().setName(collaboration,
                                          "unattachedCollaboration");
//#endif 

} 

//#endif 


//#endif 


//#if -373295627 
return collaboration;
//#endif 

} 

//#endif 


//#if 1982929553 
protected ActionNewDiagram(String name)
    { 

//#if -1777111438 
super(Translator.localize(name),
              ResourceLoaderWrapper.lookupIcon(name));
//#endif 


//#if 1525530251 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

