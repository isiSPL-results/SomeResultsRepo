
//#if -1028921811 
// Compilation Unit of /ProjectActions.java 
 

//#if -1692928906 
package org.argouml.ui;
//#endif 


//#if -1901405722 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 296517346 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1363936230 
import java.util.Collection;
//#endif 


//#if -323543898 
import java.util.List;
//#endif 


//#if 822236004 
import javax.swing.AbstractAction;
//#endif 


//#if -2388688 
import javax.swing.SwingUtilities;
//#endif 


//#if 556845956 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -518968059 
import org.argouml.i18n.Translator;
//#endif 


//#if 1209191647 
import org.argouml.kernel.Project;
//#endif 


//#if -421282518 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1078533455 
import org.argouml.kernel.UndoManager;
//#endif 


//#if 1493630506 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -364067810 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 705025335 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 2084391818 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 864328628 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 455417279 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if -566629251 
import org.argouml.uml.diagram.ui.ActionRemoveFromDiagram;
//#endif 


//#if -2025412166 
import org.tigris.gef.base.Editor;
//#endif 


//#if -507788993 
import org.tigris.gef.base.Globals;
//#endif 


//#if 842202743 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -95682238 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1613173791 
public final class ProjectActions implements 
//#if -2037538725 
TargetListener
//#endif 

, 
//#if -1387811153 
PropertyChangeListener
//#endif 

  { 

//#if 716924660 
private static ProjectActions theInstance;
//#endif 


//#if -417727458 
private final ActionUndo undoAction;
//#endif 


//#if 796371654 
private final AbstractAction redoAction;
//#endif 


//#if -1844848618 
private final ActionRemoveFromDiagram removeFromDiagram =
        new ActionRemoveFromDiagram(
        Translator.localize("action.remove-from-diagram"));
//#endif 


//#if 936567389 
public AbstractAction getRemoveFromDiagramAction()
    { 

//#if 1106489240 
return removeFromDiagram;
//#endif 

} 

//#endif 


//#if -1083089887 
public void targetAdded(TargetEvent e)
    { 

//#if -617703264 
determineRemoveEnabled();
//#endif 

} 

//#endif 


//#if 1097183847 
public static synchronized ProjectActions getInstance()
    { 

//#if -2132475729 
if(theInstance == null)//1
{ 

//#if -1187375374 
theInstance = new ProjectActions();
//#endif 

} 

//#endif 


//#if -1923947414 
return theInstance;
//#endif 

} 

//#endif 


//#if -335134380 
public AbstractAction getRedoAction()
    { 

//#if 1789122528 
return redoAction;
//#endif 

} 

//#endif 


//#if 1028123777 
public void targetRemoved(TargetEvent e)
    { 

//#if -1231614054 
determineRemoveEnabled();
//#endif 

} 

//#endif 


//#if -1918393597 
public void targetSet(TargetEvent e)
    { 

//#if -1155164559 
determineRemoveEnabled();
//#endif 

} 

//#endif 


//#if 1391567281 
public static void jumpToDiagramShowing(List targets)
    { 

//#if -389364330 
if(targets == null || targets.size() == 0)//1
{ 

//#if 1248559164 
return;
//#endif 

} 

//#endif 


//#if -1883852542 
Object first = targets.get(0);
//#endif 


//#if 329144348 
if(first instanceof ArgoDiagram && targets.size() > 1)//1
{ 

//#if -47517842 
setTarget(first);
//#endif 


//#if -975530692 
setTarget(targets.get(1));
//#endif 


//#if -980801172 
return;
//#endif 

} 

//#endif 


//#if 1076795736 
if(first instanceof ArgoDiagram && targets.size() == 1)//1
{ 

//#if -137807753 
setTarget(first);
//#endif 


//#if 886405557 
return;
//#endif 

} 

//#endif 


//#if 597561735 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1886829453 
if(project == null)//1
{ 

//#if 1995025544 
return;
//#endif 

} 

//#endif 


//#if 1449716633 
List<ArgoDiagram> diagrams = project.getDiagramList();
//#endif 


//#if 409934302 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -649181091 
if((target instanceof ArgoDiagram)
                && ((ArgoDiagram) target).countContained(targets) == targets.size())//1
{ 

//#if 1161117592 
setTarget(first);
//#endif 


//#if 642303510 
return;
//#endif 

} 

//#endif 


//#if 2044029154 
ArgoDiagram bestDiagram = null;
//#endif 


//#if 772433086 
int bestNumContained = 0;
//#endif 


//#if 2011319139 
for (ArgoDiagram d : diagrams) //1
{ 

//#if 2076625174 
int nc = d.countContained(targets);
//#endif 


//#if -622682630 
if(nc > bestNumContained)//1
{ 

//#if -1020711278 
bestNumContained = nc;
//#endif 


//#if -1746703779 
bestDiagram = d;
//#endif 

} 

//#endif 


//#if -1015155501 
if(nc == targets.size())//1
{ 

//#if 231266792 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1930220731 
if(bestDiagram != null)//1
{ 

//#if -1068870474 
if(!DiagramUtils.getActiveDiagram().equals(bestDiagram))//1
{ 

//#if 955967489 
setTarget(bestDiagram);
//#endif 

} 

//#endif 


//#if 1462566932 
setTarget(first);
//#endif 

} 

//#endif 


//#if -2142996606 
if(project.getRoots().contains(first))//1
{ 

//#if 1461508066 
setTarget(first);
//#endif 

} 

//#endif 


//#if 1525021243 
Object f = TargetManager.getInstance().getFigTarget();
//#endif 


//#if 1031933199 
if(f instanceof Fig)//1
{ 

//#if -777440748 
Globals.curEditor().scrollToShow((Fig) f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1059420730 
public AbstractAction getUndoAction()
    { 

//#if -1149132869 
return undoAction;
//#endif 

} 

//#endif 


//#if -83362659 
private static void setTarget(Object o)
    { 

//#if 539029722 
TargetManager.getInstance().setTarget(o);
//#endif 

} 

//#endif 


//#if -148456142 
private ProjectActions()
    { 

//#if -2003178376 
super();
//#endif 


//#if -739018930 
undoAction = new ActionUndo(
            Translator.localize("action.undo"),
            ResourceLoaderWrapper.lookupIcon("Undo"));
//#endif 


//#if 503735111 
undoAction.setEnabled(false);
//#endif 


//#if -828177726 
redoAction = new ActionRedo(
            Translator.localize("action.redo"),
            ResourceLoaderWrapper.lookupIcon("Redo"));
//#endif 


//#if 717058925 
redoAction.setEnabled(false);
//#endif 


//#if 880836895 
TargetManager.getInstance().addTargetListener(this);
//#endif 


//#if -1483155636 
ProjectManager.getManager().getCurrentProject().getUndoManager()
        .addPropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if -1655325003 
public void propertyChange(final PropertyChangeEvent evt)
    { 

//#if 79372920 
if(evt.getSource() instanceof UndoManager)//1
{ 

//#if 1270348241 
SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    if ("undoLabel".equals(evt.getPropertyName())) {
                        undoAction.putValue(AbstractAction.NAME, evt
                                            .getNewValue());
                    }
                    if ("redoLabel".equals(evt.getPropertyName())) {
                        redoAction.putValue(AbstractAction.NAME, evt
                                            .getNewValue());
                    }
                    if ("undoable".equals(evt.getPropertyName())) {
                        undoAction.setEnabled((Boolean) evt.getNewValue());
                    }
                    if ("redoable".equals(evt.getPropertyName())) {
                        redoAction.setEnabled((Boolean) evt.getNewValue());
                    }
                }
            });
//#endif 

} 

//#endif 

} 

//#endif 


//#if 31832716 
private void determineRemoveEnabled()
    { 

//#if 926833818 
Editor editor = Globals.curEditor();
//#endif 


//#if 601268144 
Collection figs = editor.getSelectionManager().getFigs();
//#endif 


//#if 175475081 
boolean removeEnabled = !figs.isEmpty();
//#endif 


//#if 1770865090 
GraphModel gm = editor.getGraphModel();
//#endif 


//#if 1360628580 
if(gm instanceof UMLMutableGraphSupport)//1
{ 

//#if 167044792 
removeEnabled =
                ((UMLMutableGraphSupport) gm).isRemoveFromDiagramAllowed(figs);
//#endif 

} 

//#endif 


//#if 752790915 
removeFromDiagram.setEnabled(removeEnabled);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

