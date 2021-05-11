package org.argouml.uml.diagram.ui;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.CommentEdge;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.FigPoly;
import org.tigris.gef.undo.UndoableAction;
@UmlModelMutator
public class ActionAddNote extends UndoableAction
  { 
private static final int DEFAULT_POS = 20;
private static final int DISTANCE = 80;
private static final long serialVersionUID = 6502515091619480472L;
private Point calculateLocation(
        ArgoDiagram diagram, Object firstTarget, Fig noteFig)
    { 
Point point = new Point(DEFAULT_POS, DEFAULT_POS);
if(firstTarget == null)//1
{ 
return point;
} 
Fig elemFig = diagram.presentationFor(firstTarget);
if(elemFig == null)//1
{ 
return point;
} 
if(elemFig instanceof FigEdgeModelElement)//1
{ 
elemFig = ((FigEdgeModelElement) elemFig).getEdgePort();
} 
if(elemFig instanceof FigNode)//1
{ 
point.x = elemFig.getX() + elemFig.getWidth() + DISTANCE;
point.y = elemFig.getY();
Rectangle drawingArea =
                ProjectBrowser.getInstance().getEditorPane().getBounds();
if(point.x + noteFig.getWidth() > drawingArea.getX())//1
{ 
point.x = elemFig.getX() - noteFig.getWidth() - DISTANCE;
if(point.x >= 0)//1
{ 
return point;
} 
point.x = elemFig.getX();
point.y = elemFig.getY() - noteFig.getHeight() - DISTANCE;
if(point.y >= 0)//1
{ 
return point;
} 
point.y = elemFig.getY() + elemFig.getHeight() + DISTANCE;
if(point.y + noteFig.getHeight() > drawingArea.getHeight())//1
{ 
return new Point(0, 0);
} 
} 
} 
return point;
} 
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
Collection targets = TargetManager.getInstance().getModelTargets();
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
Object comment =
            Model.getCoreFactory().buildComment(null,
                                                diagram.getNamespace());
MutableGraphModel mgm = (MutableGraphModel) diagram.getGraphModel();
Object firstTarget = null;
Iterator i = targets.iterator();
while (i.hasNext()) //1
{ 
Object obj = i.next();
Fig destFig = diagram.presentationFor(obj);
if(destFig instanceof FigEdgeModelElement)//1
{ 
FigEdgeModelElement destEdge = (FigEdgeModelElement) destFig;
destEdge.makeEdgePort();
destFig = destEdge.getEdgePort();
destEdge.calcBounds();
} 
if(Model.getFacade().isAModelElement(obj)
                    && (!(Model.getFacade().isAComment(obj))))//1
{ 
if(firstTarget == null)//1
{ 
firstTarget = obj;
} 
if(!Model.getFacade().getAnnotatedElements(comment)
                        .contains(obj))//1
{ 
Model.getCoreHelper().addAnnotatedElement(comment, obj);
} 
} 
} 
mgm.addNode(comment);
Fig noteFig = diagram.presentationFor(comment);
i = Model.getFacade().getAnnotatedElements(comment).iterator();
while (i.hasNext()) //2
{ 
Object obj = i.next();
if(diagram.presentationFor(obj) != null)//1
{ 
CommentEdge commentEdge = new CommentEdge(comment, obj);
mgm.addEdge(commentEdge);
FigEdge fe = (FigEdge) diagram.presentationFor(commentEdge);
FigPoly fp = (FigPoly) fe.getFig();
fp.setComplete(true);
} 
} 
noteFig.setLocation(calculateLocation(diagram, firstTarget, noteFig));
TargetManager.getInstance().setTarget(noteFig.getOwner());
} 
public ActionAddNote()
    { 
super(Translator.localize("action.new-comment"),
              ResourceLoaderWrapper.lookupIcon("action.new-comment"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new-comment"));
putValue(Action.SMALL_ICON, ResourceLoaderWrapper
                 .lookupIconResource("New Note"));
} 

 } 
