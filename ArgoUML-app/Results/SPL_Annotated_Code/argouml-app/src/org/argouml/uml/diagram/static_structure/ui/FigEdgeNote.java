// Compilation Unit of /FigEdgeNote.java 
 
package org.argouml.uml.diagram.static_structure.ui;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ui.ArgoFig;
import org.argouml.uml.diagram.ui.ArgoFigUtil;
import org.argouml.util.IItemUID;
import org.argouml.util.ItemUID;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdgePoly;
import org.tigris.gef.presentation.FigNode;
public class FigEdgeNote extends FigEdgePoly
 implements ArgoFig
, IItemUID
, PropertyChangeListener
  { 
private static final Logger LOG = Logger.getLogger(FigEdgeNote.class);
private Object comment;
private Object annotatedElement;
private DiagramSettings settings;
private ItemUID itemUid;
@Override
    public void setSourceFigNode(FigNode fn)
    { 
if(fn != null && Model.getFacade().isAComment(fn.getOwner()))//1
{ 
Object oldComment = comment;
if(oldComment != null)//1
{ 
removeElementListener(oldComment);
} 

comment = fn.getOwner();
if(comment != null)//1
{ 
addElementListener(comment);
} 

((CommentEdge) getOwner()).setComment(comment);
} 
else
if(fn != null
                   && !Model.getFacade().isAComment(fn.getOwner()))//1
{ 
annotatedElement = fn.getOwner();
((CommentEdge) getOwner()).setAnnotatedElement(annotatedElement);
} 


super.setSourceFigNode(fn);
} 

protected Object getSource()
    { 
Object theOwner = getOwner();
if(theOwner != null)//1
{ 
return ((CommentEdge) theOwner).getSource();
} 

return null;
} 

protected Object getDestination()
    { 
Object theOwner = getOwner();
if(theOwner != null)//1
{ 
return ((CommentEdge) theOwner).getDestination();
} 

return null;
} 

@Override
    public void propertyChange(PropertyChangeEvent pve)
    { 
modelChanged(pve);
} 

public void setItemUID(ItemUID newId)
    { 
itemUid = newId;
} 

public void setSettings(DiagramSettings theSettings)
    { 
settings = theSettings;
} 

public DiagramSettings getSettings()
    { 
return settings;
} 

private void addElementListener(Object element)
    { 
Model.getPump().addModelEventListener(this, element);
} 

@Override
    public final void removeFromDiagram()
    { 
Object o = getOwner();
if(o != null)//1
{ 
removeElementListener(o);
} 

super.removeFromDiagram();
damage();
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public Project getProject()
    { 
return ArgoFigUtil.getProject(this);
} 

@SuppressWarnings("deprecation")

    @Deprecated
    public void setProject(Project project)
    { 
} 

public ItemUID getItemUID()
    { 
return itemUid;
} 

@Override
    public String getTipString(MouseEvent me)
    { 
return "Comment Edge";
} 

protected void modelChanged(PropertyChangeEvent e)
    { 
if(e instanceof RemoveAssociationEvent
                && e.getOldValue() == annotatedElement)//1
{ 
removeFromDiagram();
} 

} 

public FigEdgeNote(Object element, DiagramSettings theSettings)
    { 
super();
settings = theSettings;
if(element != null)//1
{ 
setOwner(element);
} 
else
{ 
setOwner(new CommentEdge());
} 

setBetweenNearestPoints(true);
getFig().setLineWidth(LINE_WIDTH);
getFig().setDashed(true);
} 

@Override
    public void setDestFigNode(FigNode fn)
    { 
if(fn != null && Model.getFacade().isAComment(fn.getOwner()))//1
{ 
Object oldComment = comment;
if(oldComment != null)//1
{ 
removeElementListener(oldComment);
} 

comment = fn.getOwner();
if(comment != null)//1
{ 
addElementListener(comment);
} 

((CommentEdge) getOwner()).setComment(comment);
} 
else
if(fn != null
                   && !Model.getFacade().isAComment(fn.getOwner()))//1
{ 
annotatedElement = fn.getOwner();
((CommentEdge) getOwner()).setAnnotatedElement(annotatedElement);
} 


super.setDestFigNode(fn);
} 

public void renderingChanged()
    { 
} 

private void removeElementListener(Object element)
    { 
Model.getPump().removeModelEventListener(this, element);
} 

@Override
    public void setFig(Fig f)
    { 
LOG.info("Setting the internal fig to " + f);
super.setFig(f);
getFig().setDashed(true);
} 

@Override
    public String toString()
    { 
return Translator.localize("misc.comment-edge");
} 

 } 


