
//#if 904357684 
// Compilation Unit of /ActionEdgesDisplay.java 
 

//#if -965145079 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -516092248 
import java.awt.event.ActionEvent;
//#endif 


//#if 1090562355 
import java.util.Enumeration;
//#endif 


//#if 1035915150 
import java.util.Iterator;
//#endif 


//#if 1435260382 
import java.util.List;
//#endif 


//#if -754236386 
import javax.swing.Action;
//#endif 


//#if 79998669 
import org.argouml.i18n.Translator;
//#endif 


//#if 819914771 
import org.argouml.model.Model;
//#endif 


//#if -1906932398 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1687329516 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -1313353998 
import org.tigris.gef.base.Editor;
//#endif 


//#if 91177735 
import org.tigris.gef.base.Globals;
//#endif 


//#if 925024043 
import org.tigris.gef.base.Selection;
//#endif 


//#if 807295515 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 827940618 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1017392446 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -747218313 
public class ActionEdgesDisplay extends 
//#if -1988262531 
UndoableAction
//#endif 

  { 

//#if -346806459 
private static UndoableAction showEdges = new ActionEdgesDisplay(true,
            Translator.localize("menu.popup.add.all-relations"));
//#endif 


//#if -1054710424 
private static UndoableAction hideEdges = new ActionEdgesDisplay(false,
            Translator.localize("menu.popup.remove.all-relations"));
//#endif 


//#if -2117650672 
private boolean show;
//#endif 


//#if 326496223 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1941536194 
super.actionPerformed(ae);
//#endif 


//#if 387560843 
ArgoDiagram d = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1076874626 
Editor ce = Globals.curEditor();
//#endif 


//#if -1001630283 
MutableGraphModel mgm = (MutableGraphModel) ce.getGraphModel();
//#endif 


//#if -1011305765 
Enumeration e = ce.getSelectionManager().selections().elements();
//#endif 


//#if -290502540 
while (e.hasMoreElements()) //1
{ 

//#if 2013128979 
Selection sel = (Selection) e.nextElement();
//#endif 


//#if 243877939 
Object owner = sel.getContent().getOwner();
//#endif 


//#if -1033556723 
if(show)//1
{ 

//#if 1978511163 
mgm.addNodeRelatedEdges(owner);
//#endif 

} 
else
{ 

//#if -735160122 
List edges = mgm.getInEdges(owner);
//#endif 


//#if -1760351121 
edges.addAll(mgm.getOutEdges(owner));
//#endif 


//#if -860276064 
Iterator e2 = edges.iterator();
//#endif 


//#if -630054726 
while (e2.hasNext()) //1
{ 

//#if 1812754734 
Object edge = e2.next();
//#endif 


//#if -1959171639 
if(Model.getFacade().isAAssociationEnd(edge))//1
{ 

//#if 955788205 
edge = Model.getFacade().getAssociation(edge);
//#endif 

} 

//#endif 


//#if -284637034 
Fig fig = d.presentationFor(edge);
//#endif 


//#if -103643043 
if(fig != null)//1
{ 

//#if -334655666 
fig.removeFromDiagram();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1579787704 
public static UndoableAction getShowEdges()
    { 

//#if -2023023033 
return showEdges;
//#endif 

} 

//#endif 


//#if 673816380 
@Override
    public boolean isEnabled()
    { 

//#if -153164663 
return true;
//#endif 

} 

//#endif 


//#if -2090180388 
protected ActionEdgesDisplay(boolean showEdge, String desc)
    { 

//#if 1664131937 
super(desc, null);
//#endif 


//#if 1580875982 
putValue(Action.SHORT_DESCRIPTION, desc);
//#endif 


//#if -2011622041 
show = showEdge;
//#endif 

} 

//#endif 


//#if 1071217619 
public static UndoableAction getHideEdges()
    { 

//#if -1895275809 
return hideEdges;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

