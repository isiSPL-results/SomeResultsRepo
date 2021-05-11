package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Selection;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.undo.UndoableAction;
public class ActionEdgesDisplay extends UndoableAction
  { 
private static UndoableAction showEdges = new ActionEdgesDisplay(true,
            Translator.localize("menu.popup.add.all-relations"));
private static UndoableAction hideEdges = new ActionEdgesDisplay(false,
            Translator.localize("menu.popup.remove.all-relations"));
private boolean show;
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
ArgoDiagram d = DiagramUtils.getActiveDiagram();
Editor ce = Globals.curEditor();
MutableGraphModel mgm = (MutableGraphModel) ce.getGraphModel();
Enumeration e = ce.getSelectionManager().selections().elements();
while (e.hasMoreElements()) //1
{ 
Selection sel = (Selection) e.nextElement();
Object owner = sel.getContent().getOwner();
if(show)//1
{ 
mgm.addNodeRelatedEdges(owner);
} 
else
{ 
List edges = mgm.getInEdges(owner);
edges.addAll(mgm.getOutEdges(owner));
Iterator e2 = edges.iterator();
while (e2.hasNext()) //1
{ 
Object edge = e2.next();
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 
edge = Model.getFacade().getAssociation(edge);
} 
Fig fig = d.presentationFor(edge);
if(fig != null)//1
{ 
fig.removeFromDiagram();
} 
} 
} 
} 
} 
public static UndoableAction getShowEdges()
    { 
return showEdges;
} 
@Override
    public boolean isEnabled()
    { 
return true;
} 
protected ActionEdgesDisplay(boolean showEdge, String desc)
    { 
super(desc, null);
putValue(Action.SHORT_DESCRIPTION, desc);
show = showEdge;
} 
public static UndoableAction getHideEdges()
    { 
return hideEdges;
} 

 } 
