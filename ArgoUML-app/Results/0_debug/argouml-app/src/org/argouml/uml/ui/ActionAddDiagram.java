
//#if -1103675203 
// Compilation Unit of /ActionAddDiagram.java 
 

//#if -1977910373 
package org.argouml.uml.ui;
//#endif 


//#if 629146065 
import java.awt.event.ActionEvent;
//#endif 


//#if -41010937 
import java.util.Collection;
//#endif 


//#if -565940153 
import javax.swing.Action;
//#endif 


//#if 777568791 
import org.apache.log4j.Logger;
//#endif 


//#if -102662525 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1222648004 
import org.argouml.i18n.Translator;
//#endif 


//#if -1228479168 
import org.argouml.kernel.Project;
//#endif 


//#if -1103714903 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1669862006 
import org.argouml.model.Model;
//#endif 


//#if 702297641 
import org.argouml.ui.explorer.ExplorerEventAdaptor;
//#endif 


//#if 770116504 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -898101175 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1092859027 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -751179929 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 2132820388 
public abstract class ActionAddDiagram extends 
//#if -167400049 
UndoableAction
//#endif 

  { 

//#if -549096293 
private static final Logger LOG =
        Logger.getLogger(ActionAddDiagram.class);
//#endif 


//#if -68387480 
public abstract boolean isValidNamespace(Object ns);
//#endif 


//#if 1072784209 
protected Object findNamespace()
    { 

//#if -311082273 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 2123069628 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1928431842 
Object ns = null;
//#endif 


//#if -1323355947 
if(target == null || !Model.getFacade().isAModelElement(target)
                || Model.getModelManagementHelper().isReadOnly(target))//1
{ 

//#if 1943475170 
Collection c = p.getRoots();
//#endif 


//#if -1912038073 
if((c != null) && !c.isEmpty())//1
{ 

//#if 517769532 
target = c.iterator().next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1966472350 
if(Model.getFacade().isANamespace(target))//1
{ 

//#if 1436681668 
ns = target;
//#endif 

} 
else
{ 

//#if -485808191 
Object owner = null;
//#endif 


//#if -1889616661 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -1759814819 
owner = Model.getFacade().getOwner(target);
//#endif 


//#if 194044336 
if(owner != null && Model.getFacade().isANamespace(owner))//1
{ 

//#if -116518319 
ns = owner;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1041881197 
if(ns == null && Model.getFacade().isAModelElement(target))//1
{ 

//#if -2013042888 
owner = Model.getFacade().getNamespace(target);
//#endif 


//#if 593719603 
if(owner != null && Model.getFacade().isANamespace(owner))//1
{ 

//#if 268353553 
ns = owner;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1389395128 
if(ns == null)//1
{ 

//#if -917739057 
ns = p.getRoot();
//#endif 

} 

//#endif 


//#if 513343103 
return ns;
//#endif 

} 

//#endif 


//#if 713942364 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1518147160 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1689886179 
Object ns = findNamespace();
//#endif 


//#if 1861936754 
if(ns != null && isValidNamespace(ns))//1
{ 

//#if 358554967 
super.actionPerformed(e);
//#endif 


//#if 2044117445 
DiagramSettings settings =
                p.getProjectSettings().getDefaultDiagramSettings();
//#endif 


//#if 629221494 
ArgoDiagram diagram = createDiagram(ns, settings);
//#endif 


//#if -141819669 
p.addMember(diagram);
//#endif 


//#if 805164425 
ExplorerEventAdaptor.getInstance().modelElementAdded(ns);
//#endif 


//#if 643866317 
TargetManager.getInstance().setTarget(diagram);
//#endif 

} 
else
{ 

//#if 1331924172 
LOG.error("No valid namespace found");
//#endif 


//#if 1249231112 
throw new IllegalStateException("No valid namespace found");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1548578420 
@Deprecated
    public ArgoDiagram createDiagram(@SuppressWarnings("unused") Object ns)
    { 

//#if 669440176 
return null;
//#endif 

} 

//#endif 


//#if 682039555 
public ActionAddDiagram(String s)
    { 

//#if 411149535 
super(Translator.localize(s),
              ResourceLoaderWrapper.lookupIcon(s));
//#endif 


//#if 2047693524 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(s));
//#endif 

} 

//#endif 


//#if -254016433 
public ArgoDiagram createDiagram(Object owner, DiagramSettings settings)
    { 

//#if -1692780969 
ArgoDiagram d = createDiagram(owner);
//#endif 


//#if 383494121 
d.setDiagramSettings(settings);
//#endif 


//#if 450930109 
return d;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

